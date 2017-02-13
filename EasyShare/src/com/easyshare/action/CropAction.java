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

	//�û��ϴ��Ķ�ͷ������
	private static String HEAD_PIC="userHeadPic";
	
	@Autowired
	UserDao userDao=new UserDaoImpl();
	
	//����������
	private HttpServletRequest request=null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.request=request;		
		
		String initType=request.getParameter("type");
		HttpSession session=request.getSession();
		Object user=session.getAttribute(Constant.USER_KEY);
		
		//���û������ϴ���Ϊ�û�ͷ��ͼƬ
		if(HEAD_PIC.equals(initType))
		{
			System.out.println("�û�ͷ���ϴ�");
			//�����û�ͷ����Ϣ
			uploadUserHeadPic(request, response, user);
		}
	}
	
	/**
	 * �û�ͷ���ϴ�
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
		
		//��ȡ�û����к��ͼƬ
		BufferedImage image=receiveImage();
		//�������ͼƬ����
		String fileName=Utils.createRandomName()+".jpg";
		//new����Ƭ�ڷ������˵Ĵ��·��
		File file=new File(request.getSession().getServletContext().getRealPath("\\UserImages\\"+fileName));
		//д��ͼƬ
		ImageIO.write(image, "png", file);
		
		//��ȡ�û�������Ϣ
		CommonUserInfo commonUserInfo=userDao.getUserInfoByCommonId(Utils.getUserCommonInfo(user).getCommonID());
		commonUserInfo.setHeadPic(fileName);
		
		if(1==commonUserInfo.getUserType())
		{
			//���û�����Ϊ��ʦ������½�ʦͷ������
			((Teacher)user).setCommonUserInfo(commonUserInfo);
		}else if(2==commonUserInfo.getUserType())
		{
			//���û�����Ϊѧ���������ѧ��ͷ������
			((Student)user).setCommonUserInfo(commonUserInfo);
		}
		
		//�����û�����
		userDao.update(user);
		
		//��¼ͷ������
		String path=request.getSession().getServletContext().getRealPath("\\UserImages\\"+fileName);
		//newһ��JSON����
		JSONObject jsonObject=new JSONObject();
		//�洢·��ֵ
		jsonObject.put("result",path);
		//���͵��ͻ���
		response.getOutputStream().write(jsonObject.toString().getBytes("UTF-8"));
		//ˢ�»���
		response.getOutputStream().flush();
		//�ر���
		response.getOutputStream().close();
	}


	/**
	 * �����û��ϴ���ͼƬ
	 * @return
	 * 		BufferedImage
	 */
	@SuppressWarnings("unchecked")
	private BufferedImage receiveImage() {
		//��������ݼ���
		List<FileItem> items=null;
		//�ϴ���ͼƬ
		BufferedImage bi=null;
		
		//�ļ�����
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//�ļ��ϴ�����
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		try 
		{
			//��ȡ������������
			items=upload.parseRequest(this.request);
		} catch (FileUploadException e)
		{
			e.printStackTrace();
		}
		
		//����Ϊ���򷵻�
		if(items==null||items.size()==0)
		{
			return null;
		}
		//��ʼ�����꣬Ŀ�곤�ȼ����
		int x1=0,y1=0,w=0,h=0;
		
		//������
		Iterator<FileItem> it=items.iterator();
		while(it.hasNext())
		{
			FileItem item=it.next();
			//��Ϊ������Ϊ���ļ��ϴ�
			if(item.isFormField())
			{
				String name=item.getFieldName();
				String value=item.getString();	
				
				//��ΪJson��������
				if(name.equals("avatar_data"))
				{
					//��ȡjson����ֵ
					JSONObject jsonObject=JSONObject.fromObject(value);
					System.out.println(value.toString());
					
					//��ȡͼƬ���Ͻ���������Լ�ͼƬĿ�곤�ȼ����
					x1=(int) jsonObject.getDouble("x");
					y1=(int) jsonObject.getDouble("y");
					h=(int) jsonObject.getDouble("width");
					w=(int) jsonObject.getDouble("height");
				}
			}else
			{
				//��Ϊ�ļ����������ݰ�ͼƬ��ʽ����
				try 
				{
					//����ͼƬ����
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
			System.out.println("��������"+x1+" ��������� "+y1+" Ŀ���� "+w+" Ŀ��߶� "+h);
			//���û���ѡ����ü�ͼƬ
			bi=cut(bi,(int)(x1),(int)(y1),(int)(w),(int)(h));
		}
		return bi;
	}

	/**
	 * ͼ���и�
	 * @param bi
	 * 		ͼƬ
	 * @param x1
	 * 		��������
	 * @param y1
	 * 		���������
	 * @param width
	 * 		Ŀ����
	 * @param height
	 * 		Ŀ��߶�
	 * @return
	 * 		
	 */
	private BufferedImage cut(BufferedImage bi, int x1, int y1, int width, int height) {
		//�ü��ĸ߶ȼ����
		int srcWidth=bi.getWidth();
		int srcHeight=bi.getHeight();
		
		//������Ϊ0���򷵻�null
		if(srcWidth<=0||srcHeight<=0)
		{
			return null;
		}
		
		//��ȡͼ����Դ
		Image image=bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
		ImageFilter cropFilter=new CropImageFilter(y1, y1, width, height);
		//�ü�ͼƬ
		Image img=Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
		
		BufferedImage result=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//��������
		Graphics g=result.getGraphics();
		//����ͼƬ
		g.drawImage(img, 0, 0, width,height,null);
		//�ͷŶ�����Դ
		g.dispose();
		return result;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
