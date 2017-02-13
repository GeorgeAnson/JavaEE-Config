<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%
		String path = request.getContextPath();
	 	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>

    <%
     	//dispaly today's date
     	SimpleDateFormat sdf=new SimpleDateFormat("MM dd - yyyy");
    	String date=sdf.format(new Date())+" in Ningbo China";
    %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="icon" href="images/icon.png" sizes="512x512">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/owl.theme.css">
<link rel="stylesheet" href="css/owl.carousel.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

<title>es|易享健康科技</title>
</head>

<body data-spy="scroll" data-offset="50" data-target=".navbar-collapse">

<!-- =========================
     PRE LOADER
============================== -->
<div class="preloader">

	<div class="sk-rotating-plane"></div>

</div>


<!-- =========================
     NAVIGATION LINKS
============================== -->
<div class="navbar navbar-fixed-top custom-navbar" role="navigation">
	<div class="container">

		<!-- navbar header -->
		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
			</button>
			<a href="index.jsp" class="navbar-brand">Easy Share易享</a>
		</div>

		<div class="collapse navbar-collapse">

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#intro" class="smoothScroll">导航</a></li>
				<c:choose>
					<c:when test="${not empty user}"><li><a href="${pageContext.request.contextPath}/index.html?type=init" class="smoothScroll">易享</a></li></c:when>
					<c:otherwise><li><a href="#overview" class="smoothScroll">易享</a></li></c:otherwise>
				</c:choose>
				
				<li><a href="#speakers" class="smoothScroll">我们</a></li>
				<!--  <li><a href="#program" class="smoothScroll">本周要事</a></li>-->
				<li><a href="#venue" class="smoothScroll">地址</a></li>
				<li><a href="#sponsors" class="smoothScroll">合作赞助商</a></li>

				<li><a href="#contact" class="smoothScroll">联系我们</a></li>
				<li><a href="login.jsp" class="smoothScroll">登陆</a></li>
				<li><a href="#register" class="smoothScroll">注册</a></li>
			</ul>

		</div>

	</div>
</div>


<!-- =========================
    INTRO SECTION
============================== -->
<section id="intro" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<h3 class="wow bounceIn" data-wow-delay="0.9s"><%=date%></h3>
				<h1 class="wow fadeInUp" data-wow-delay="1.6s">Easy Share</h1>
				<a href="login.jsp" class="btn btn-lg btn-default smoothScroll wow fadeInUp hidden-xs" data-wow-delay="2.3s">LOGIN</a>
				<a href="#register" class="btn btn-lg btn-danger smoothScroll wow fadeInUp" data-wow-delay="2.3s">REGISTER NOW</a>
			</div>
		</div>
	</div>
</section>


<!-- =========================
    OVERVIEW SECTION
============================== -->
<section id="overview" class="parallax-section">
	<div class="container">
		<div class="row">

			<div class="wow fadeInUp col-md-6 col-sm-6" data-wow-delay="0.6s">
				<h3>何为易享</h3>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;易享，其全称为“宁波市易享健康科技有限公司”，是一家以提供移动健康方面系列产品技术服务为主要业务的科技服务型企业。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;易享将始终贯彻“健康心、服务心”的理念，不断完善现有产品功能，增加新功能并提高用户友好性，
				以积极的服务态度和健康的服务方式、卓越的技术服务品质和专业的技术服务实力，为不同群体的客户以及相关企业或机构提供优质的技术服务支持。</p>
			</div>

			<div class="wow fadeInUp col-md-6 col-sm-6" data-wow-delay="0.9s">
				<img src="images/overview-img.jpg" class="img-responsive" alt="Overview">
			</div>

		</div>
	</div>
</section>


<!-- =========================
    DETAIL SECTION
============================== -->
<section id="detail" class="parallax-section">
	<div class="container">
		<div class="row">

			<div class="wow fadeInLeft col-md-4 col-sm-4" data-wow-delay="0.3s">
				<i class="fa fa-group"></i>
				<h3>60位核心成员</h3>
				<p>自成立致此已发展为由60位成员组成的中小型团队。</p>
			</div>

			<div class="wow fadeInUp col-md-4 col-sm-4" data-wow-delay="0.6s">
				<i class="fa fa-clock-o"></i>
				<h3>26个项目</h3>
				<p>自成立致此已完美完成二十六个项目，并再持续更新中。</p>
			</div>

			<div class="wow fadeInRight col-md-4 col-sm-4" data-wow-delay="0.9s">
				<i class="fa fa-bookmark-o"></i>
				<h3>3 个专利</h3>
				<p>自成立致此共获得了三个专利，详情可以点击<a href＝"">这里。</a></p>
			</div>

		</div>
	</div>
</section>


<!-- =========================
    VIDEO SECTION
============================== -->
<section id="video" class="parallax-section">
	<div class="container">
		<div class="row">

			<div class="wow fadeInUp col-md-6 col-sm-10" data-wow-delay="1.3s">
				<h2>来看一段影像吧</h2>
				<h3>怀揣着宏伟梦想的中小型企业，这就是易享。</h3>
				<p>Here is our lab.</p>
			</div>
			<div class="wow fadeInUp col-md-6 col-sm-10" data-wow-delay="1.6s">
				<div class="embed-responsive embed-responsive-16by9">
					<video src="media/1.mp4" controls="controls"/>
				</div>
			</div>

		</div>
	</div>
</section>


<!-- =========================
    SPEAKERS SECTION
============================== -->
<section id="speakers" class="parallax-section">
	<div class="container">
		<div class="row">

			<div class="col-md-12 col-sm-12 wow bounceIn">
				<div class="section-title">
					<h2>核心成员</h2>
					<p>我们的核心成员分布图</p>
				</div>
			</div>

			<!-- Testimonial Owl Carousel section
			================================================== -->
			<div id="owl-speakers" class="owl-carousel">

				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>鲍淑娣</h3>
								<h6>核心指导</h6>
							</div>
					</div>
				</div>

				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>陈萌</h3>
								<h6>核心指导</h6>
							</div>
					</div>
				</div>
				
				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>孙洁</h3>
								<h6>核心指导</h6>
							</div>
					</div>
				</div>

				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>洪胜</h3>
								<h6>top</h6>
							</div>
					</div>
				</div>

				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>骆鸿益</h3>
								<h6>top</h6>
							</div>
					</div>
				</div>

				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>余鹏泽</h3>
								<h6>质量管理监督部</h6>
							</div>
					</div>
				</div>

				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>徐新宇</h3>
								<h6>技术部</h6>
							</div>
					</div>
				</div>

				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>周杰</h3>
								<h6>办公室</h6>
							</div>
					</div>
				</div>

				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>张磊</h3>
								<h6>人力资源部</h6>
							</div>
					</div>
				</div>


				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>董柯</h3>
								<h6>商务部</h6>
							</div>
					</div>
				</div>
				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>赵伶紫</h3>
								<h6>市场部</h6>
							</div>
					</div>
				</div>

				<div class="item wow fadeInUp col-md-3 col-sm-3" data-wow-delay="0.9s">
					<div class="speakers-wrapper">
						<img src="images/icon.png" class="img-responsive" alt="speakers">
							<div class="speakers-thumb">
								<h3>李文凯</h3>
								<h6>财务部</h6>
							</div>
					</div>
				</div>


			</div>

		</div>
	</div>
</section>
<!-- =========================
    PROGRAM SECTION
============================== -->





<!-- =========================
   REGISTER SECTION
============================== -->
<section id="register" class="parallax-section">
	<div class="container">
		<div class="row">

			<div class="wow fadeInUp col-md-7 col-sm-7" data-wow-delay="0.6s">
				<h2>注册</h2>
				<h3>加入我们吧</h3>
				<p>欢迎加入我们的大家庭</p>
			</div>

			<div class="wow fadeInUp col-md-5 col-sm-5" data-wow-delay="1s">				<form name="regForm" action="<%=basePath %>/register.html" method="post">					<input name="loginName" type="text" class="form-control" id="username" placeholder="用户名">					<input name="password" type="password" class="form-control" id="password" placeholder="密码">					<input name="confromPassword" type="password" class="form-control" id="cpassword" placeholder="确认密码">					<input name="email" type="email" class="form-control" id="email" placeholder="邮箱">					<input name="phone" type="telephone" class="form-control" id="phone" placeholder="手机">                    <div>			    		<select name="type" class="form-control" style="height: 45px; border-radius: 0px; width: 40%;display: inline;">			    			<option value="2" class="selectOpt">学生</option>			    			<option value="1" class="selectOpt">教师</option>			    		</select>
                        <input class="form-control" style="width: 30%; display: inline;" type="text" id="ident" name="code" class="" rel="popover" placeholder="验证码">                        <div id="coder" style="width: 35%; display: inline;"><img id="coderImg" src="<%=basePath%>code.html" style="margin:0px 0px 7px 0px;"></div>                    </div>                    <div class="col-md-offset-6 col-md-6 col-sm-offset-1 col-sm-10">						<input name="submit" type="submit" class="form-control" id="submit" onclick="return checkpasswd()" value="注册">					</div>				</form>			</div>
			<div class="col-md-1"></div>

		</div>
	</div>
</section>


<!-- =========================
    FAQ SECTION
============================== -->
<section id="faq" class="parallax-section">
	<div class="container">
		<div class="row">

			<!-- Section title
			================================================== -->
			<div class="wow bounceIn col-md-offset-2 col-md-8 col-sm-offset-1 col-sm-10 text-center">
				<div class="section-title">
					<h2>Quesions &amp; Answer</h2>
					<p>我们整合了常见问题予以回答，如果这不能解决您的问题，请联系我们。</p>
				</div>
			</div>

			<div class="wow fadeInUp col-md-offset-1 col-md-10 col-sm-offset-1 col-sm-10" data-wow-delay="0.9s">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

  					<div class="panel panel-default">
   						<div class="panel-heading" role="tab" id="headingOne">
      						<h4 class="panel-title">
        						<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
          							 易享是做什么的
        						</a>
      						</h4>
    					</div>
   						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      						<div class="panel-body">
        						<p>Point One：我们主要研究方向为移动健康方向及信息安全方向。</p>
        						<p>Point Two：我们既注重科研成果的积累，亦注重科技产品的研发。</p>
								<p>Point Three：易享致力于将科技研究成果与产业化实现对接，将核心实验室在技术上的成果突破，融入易享产品中，并服务于广泛地社会群众。</p>
      						</div>
   						 </div>
 					</div>

    				<div class="panel panel-default">
   						<div class="panel-heading" role="tab" id="headingTwo">
      						<h4 class="panel-title">
        						<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          							如何加入我们的核心实验室团队
        						</a>
      						</h4>
    					</div>
   						<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      						<div class="panel-body">
                            	<p>Point One：随着不断发展壮大，现加入易享的核心实验室团队成员必须经过重重考验。</p>
                            	<p>Point Two：首先，我们更倾向于注重个人的道德品质以及是否拥有敢于挑战的决心。</p>
                            	<p>Point Three：其次，我们希望所有团队成员都能自觉主动地参与各个项目中，积极主动地服务承担责任。</p>
                            	<p>Point Four：再者，我们当然愿意对您的个人实力有一定要求，需要有一定的科研能力、软件开发能力以及文档撰写能力。</p>
                            	<p>Point Five：最后，我们欢迎广大技术实力强悍的个人以及团队加入我们。</p>
      						</div>
   						 </div>
 					</div>

 					<div class="panel panel-default">
   						<div class="panel-heading" role="tab" id="headingThree">
      						<h4 class="panel-title">
        						<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          							易享目前的发展如何
        						</a>
      						</h4>
    					</div>
   						<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      						<div class="panel-body">
        						<p>Point One：易享核心实验室与2012年创立，期间逐渐发展壮大，并与2016年正式注册成立宁波市易享健康科技有限公司。</p>
                            	<p>Point Two：易享目前是一家半IT科研机构半软件开发单位的中小型互联网企业，一方面逐步积累科研成果，另一方面将次科研成果转换为可为社会提供服务的互联网产品。</p>
                            	<p>Point Three：易享目前正在起步阶段，由于互联网+的概念推动，因此业务发展较快，但仍有很大的改进和发展空间。</p>
      						</div>
   						 </div>
 					 </div>

 				 </div>
			</div>

		</div>
	</div>
</section>


<!-- =========================
    VENUE SECTION
============================== -->
<section id="venue" class="parallax-section">
	<div class="container">
		<div class="row">

			<div class="wow fadeInLeft col-md-offset-1 col-md-5 col-sm-8" data-wow-delay="0.9s">
				<h2>我们在</h2>
				<p>在互联网的时代，其实我们到处都在</p>
				<h4>单位地址详情</h4>
  				<h4><spab class="fa fa-map-marker"></spab>&nbsp;&nbsp;宁波市江东区百丈东路966号A幢701室</h4>
  				<h4><span class="fa fa-envelope-o"></span>&nbsp;shudi.bao@nbut.com</h4>
				<h4><span class="fa fa-phone"></span>&nbsp;&nbsp;138-6780-0682</h4>
			</div>

		</div>
	</div>
</section>


<!-- =========================
    SPONSORS SECTION
============================== -->
<section id="sponsors" class="parallax-section">
	<div class="container">
		<div class="row">

			<div class="wow bounceIn col-md-12 col-sm-12">
				<div class="section-title">
					<h2>赞助商 &amp; 合作商</h2>
					<p>我们有许多合作商</p>
				</div>
			</div>

			<div class="wow fadeInUp col-md-3 col-sm-6 col-xs-6" data-wow-delay="0.3s">
				<img src="images/sponsor-img1.jpg" class="img-responsive" alt="sponsors">
			</div>

			<div class="wow fadeInUp col-md-3 col-sm-6 col-xs-6" data-wow-delay="0.6s">
				<img src="images/sponsor-img2.jpg" class="img-responsive" alt="sponsors">
			</div>

			<div class="wow fadeInUp col-md-3 col-sm-6 col-xs-6" data-wow-delay="0.9s">
				<img src="images/sponsor-img3.jpg" class="img-responsive" alt="sponsors">
			</div>

			<div class="wow fadeInUp col-md-3 col-sm-6 col-xs-6" data-wow-delay="1s">
				<img src="images/sponsor-img4.jpg" class="img-responsive" alt="sponsors">
			</div>

		</div>
	</div>
</section>


<!-- =========================
    CONTACT SECTION
============================== -->
<section id="contact" class="parallax-section">
	<div class="container">
		<div class="row">
			<!--
			<div class="wow fadeInUp col-md-offset-1 col-md-5 col-sm-6" data-wow-delay="0.6s">
				<div class="contact_des">
					<h3>最新动态</h3>
					<p></p>
					<p></p>
					<p></p>
					<a href="#" class="btn btn-danger">DOWNLOAD NOW</a>
				</div>
			</div>
			-->
			<div class="wow fadeInUp col-md-5 col-sm-6" data-wow-delay="0.9s">
				<div class="contact_detail">
					<div class="section-title">
						<h2>联系我们</h2>
					</div>
					<form action="#" method="post">
						<input name="name" type="text" class="form-control" id="name" placeholder="您的称呼">
					  	<input name="email" type="email" class="form-control" id="email" placeholder="电子邮件地址">
					  	<textarea name="message" rows="5" class="form-control" id="message" placeholder="内容..."></textarea>
						<div class="col-md-6 col-sm-10">
							<input name="submit" type="submit" class="form-control" id="submit" value="发送">
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
</section>


<!-- =========================
    FOOTER SECTION
============================== -->
<footer>
	<div class="container">
		<div class="row">

			<div class="col-md-12 col-sm-12">
				<p class="wow fadeInUp" data-wow-delay="0.6s">Copyright &copy; 2016 EasyShare</a></p>

				<ul class="social-icon">
					<li><a href="#" class="fa fa-weixin wow fadeInUp" data-wow-delay="1s"></a></li>
					<li><a href="#" class="fa fa-qq wow fadeInUp" data-wow-delay="1.3s"></a></li>
					<li><a href="#" class="fa fa-weibo wow fadeInUp" data-wow-delay="1.6s"></a></li>
					<!--<li><a href="#" class="fa fa-github wow fadeInUp" data-wow-delay="1.9s"></a></li>
					<li><a href="#" class="fa fa-google-plus wow fadeInUp" data-wow-delay="2s"></a></li>-->
				</ul>

			</div>

		</div>
	</div>
</footer>


<!-- Back top -->
<a href="#back-top" class="go-top"><i class="fa fa-angle-up"></i></a>


<!-- =========================
     SCRIPTS
============================== -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.parallax.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/smoothscroll.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/custom.js"></script>

<script type="text/javascript">
function changeCode(){
    document.getElementById("coderImg").src='<%=basePath%>code.html?id='+new Date().getMilliseconds();
}
function  getObjsByClass (param) {
    var tags = tags || document.getElementsByTagName("*");
    var list = [];
    for( var k in tags)
    {
        var tag = tags[k];
        if(tag.className == param) {
            list.push(tag);
        }
    }
    return list;
}
$(document).ready(function(){
    var flager = 0;
    $("#coder").hide();
    $("#ident").click(function(){
        if(flager != 0){
            changeCode();
        }
    });

    $("#ident").focus(function(){
            $("#coder").fadeIn("fast");
            flager = 1;

    });

    $("#ident").blur(function(){
        $("#coder").fadeOut("fast");
        flager = 0;
    });
});
</script>

<script type="text/javascript">
function checkpasswd() {  
    var password = document.getElementById("password").value;  
    var repassword = document.getElementById("cpassword").value;  
         if(password!=repassword){  
             window.alert("您输入的新密码与确认密码确认不一致");  
             regForm.cpassword.focus();  
             return false;
             }
          return true;
    }
</script>

</body>
</html>
