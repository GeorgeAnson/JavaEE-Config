package com.easyshare.action;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easyshare.dao.UserDao;
import com.easyshare.dao.jdbc.UserDaoImpl;
import com.easyshare.entity.CommonUserInfo;
import com.easyshare.entity.Student;
import com.easyshare.entity.Teacher;
import com.easyshare.globle.Constant;
import com.easyshare.utils.Utils;

import net.sf.json.JSONObject;

@Component
public class CropAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7370782703513914698L;

	//用户上传的饿头像类型
	private static String HEAD_PIC="userHeadPic";
	
	@Autowired
	UserDao userDao=new UserDaoImpl();
	
	//请求流对象
	private HttpServletRequest request=null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.request=request;		
		
		String initType=request.getParameter("type");
		HttpSession session=request.getSession();
		Object user=session.getAttribute(Constant.USER_KEY);
		
		//若用户请求上传的为用户头像图片
		if(HEAD_PIC.equals(initType))
		{
			System.out.println("用户头像上传");
			//更新用户头像信息
			uploadUserHeadPic(request, response, user);
		}
	}
	
	/**
	 * 用户头像上传
	 * @param request
	 * 		HttpServletRequest
	 * @param response
	 * 		HttpServletResponse
	 * @param user
	 * 		Object
	 * @throws ServletException 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	private void uploadUserHeadPic(HttpServletRequest request, HttpServletResponse response, Object user) throws IOException{
		
		//获取用户剪切后的图片
		BufferedImage image=receiveImage();
		//随机生成图片名称
		String fileName=Utils.createRandomName()+".jpg";
		//new处读片在服务器端的存放路径
		File file=new File(request.getSession().getServletContext().getRealPath("\\UserImages\\"+fileName));
		//写入图片
		ImageIO.write(image, "png", file);
		
		//获取用户公共信息
		CommonUserInfo commonUserInfo=userDao.getUserInfoByCommonId(Utils.getUserCommonInfo(user).getCommonID());
		commonUserInfo.setHeadPic(fileName);
		
		if(1==commonUserInfo.getUserType())
		{
			//若用户类型为教师，则更新教师头像数据
			((Teacher)user).setCommonUserInfo(commonUserInfo);
		}else if(2==commonUserInfo.getUserType())
		{
			//若用户类型为学生，则更新学生头像数据
			((Student)user).setCommonUserInfo(commonUserInfo);
		}
		
		//更新用户对象
		userDao.update(user);
		
		//记录头像刘静
		String path=request.getSession().getServletContext().getRealPath("\\UserImages\\"+fileName);
		//new一个JSON对象
		JSONObject jsonObject=new JSONObject();
		//存储路径值
		jsonObject.put("result",path);
		//发送到客户端
		response.getOutputStream().write(jsonObject.toString().getBytes("UTF-8"));
		//刷新缓冲
		response.getOutputStream().flush();
		//关闭流
		response.getOutputStream().close();
	}


	/**
	 * 接收用户上传的图片
	 * @return
	 * 		BufferedImage
	 */
	@SuppressWarnings("unchecked")
	private BufferedImage receiveImage() {
		//定义表单数据集合
		List<FileItem> items=null;
		//上传的图片
		BufferedImage bi=null;
		
		//文件工厂
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//文件上传对象
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		try 
		{
			//获取请求流中数据
			items=upload.parseRequest(this.request);
		} catch (FileUploadException e)
		{
			e.printStackTrace();
		}
		
		//数据为空则返回
		if(items==null||items.size()==0)
		{
			return null;
		}
		//起始点坐标，目标长度及宽度
		int x1=0,y1=0,w=0,h=0;
		
		//遍历表单
		Iterator<FileItem> it=items.iterator();
		while(it.hasNext())
		{
			FileItem item=it.next();
			//若为表单域，则为非文件上传
			if(item.isFormField())
			{
				String name=item.getFieldName();
				String value=item.getString();	
				
				//若为Json数据请求
				if(name.equals("avatar_data"))
				{
					//获取json对象值
					JSONObject jsonObject=JSONObject.fromObject(value);
					System.out.println(value.toString());
					
					//获取图片左上角起点坐标以及图片目标长度及宽度
					x1=(int) jsonObject.getDouble("x");
					y1=(int) jsonObject.getDouble("y");
					h=(int) jsonObject.getDouble("width");
					w=(int) jsonObject.getDouble("height");
				}
			}else
			{
				//若为文件流，则将数据按图片形式缓存
				try 
				{
					//缓存图片数据
					bi=ImageIO.read(item.getInputStream());
					System.out.println("items "+item);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
		if(null!=bi)
		{
			System.out.println("起点横坐标"+x1+" 起点纵坐标 "+y1+" 目标宽度 "+w+" 目标高度 "+h);
			//按用户所选区域裁剪图片
			bi=cut(bi,(int)(x1),(int)(y1),(int)(w),(int)(h));
		}
		return bi;
	}

	/**
	 * 图像切割
	 * @param bi
	 * 		图片
	 * @param x1
	 * 		起点横坐标
	 * @param y1
	 * 		起点纵坐标
	 * @param width
	 * 		目标宽度
	 * @param height
	 * 		目标高度
	 * @return
	 * 		
	 */
	private BufferedImage cut(BufferedImage bi, int x1, int y1, int width, int height) {
		//裁剪的高度及宽度
		int srcWidth=bi.getWidth();
		int srcHeight=bi.getHeight();
		
		//若长宽为0，则返回null
		if(srcWidth<=0||srcHeight<=0)
		{
			return null;
		}
		
		//获取图像资源
		Image image=bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
		ImageFilter cropFilter=new CropImageFilter(y1, y1, width, height);
		//裁剪图片
		Image img=Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
		
		BufferedImage result=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//创建画布
		Graphics g=result.getGraphics();
		//绘制图片
		g.drawImage(img, 0, 0, width,height,null);
		//释放对象资源
		g.dispose();
		return result;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
