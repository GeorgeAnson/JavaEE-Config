<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>ES | 个人资料</title>
    <link rel="icon" href="images/icon.png" sizes="512x512">
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->

    <link rel="stylesheet" href="assets/js/dataTables/dataTables.bootstrap.css">

    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/nisalButton.css">
    <link rel="stylesheet" href="css/cropper.min.css">
    <link rel="stylesheet" href="css/sitelogo.css">
    <link href="assets/css/select2.min.css" rel="stylesheet" >
</head>
<body>

  </div>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">EasyShare</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}"><strong><i class="icon fa fa-smile-o"></i> Easy Share</strong></a>

		<div id="sideNav" href="">
		<i class="fa fa-bars icon"></i>
		</div>
            </div>

            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"  style="color:#000;"></i> <i class="fa fa-caret-down"  style="color:#000;"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i>${user.commonUserInfo.loginName}</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/personalInfoUpdate.html?type=init"><i class="fa fa-gear fa-fw"></i>个人信息</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/logout.html?type=logout"><i class="fa fa-sign-out fa-fw"></i>退出</a>
                        </li>
                    </ul>

                </li>

            </ul>
        </nav>

        <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <ul class="nav" id="main-menu">
                <li>
                    <a href="${pageContext.request.contextPath}/index.html?type=init"><i class="fa fa-dashboard"></i>易享后台</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/equipment.html?type=equip"><i class="fa fa-desktop"></i>设备管理</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/books.html?type=book"><i class="fa fa-sitemap"></i>书籍管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${pageContext.request.contextPath}/books.html?type=book">书本信息</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/books.html?type=borrowBooks">借阅信息</a>
                        </li>
                    </ul>
                </li>
                <li>
                <a href="${pageContext.request.contextPath}/projects.html?type=myProj"><i class="fa fa-sitemap"></i>项目管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${pageContext.request.contextPath}/projects.html?type=myProj">我的项目</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/projects.html?type=projects">现役项目</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/projects.html?type=histProj">项目管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/money.html?type=money"><i class="fa fa-money"></i>资金管理</a>
                </li>
                <!-- <li>
                    <a href="${pageContext.request.contextPath}/repair.html?type=repair"><i class="fa fa-table"></i>维修服务统计</a>
                </li>-->
                <li>
                    <a href="${pageContext.request.contextPath}/power.html?type=power"><i class="fa fa-edit"></i>权限分配</a>
                </li>
                <li>
                <a href="#"><i class="fa fa-users"></i>成员管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${pageContext.request.contextPath}/members.html?type=student">学生成员</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/members.html?type=teacher">教师成员</a>
                        </li>
                    </ul>
                </li>
            </ul>

        </div>

        </nav>

        <div id="page-wrapper">
		  <div class="header">
                        <h1 class="page-header">
                            你的资料 <small>你好 ${user.commonUserInfo.loginName}</small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="${pageContext.request.contextPath}">易享</a></li>
					  <li><a href="${pageContext.request.contextPath}/index.html?type=init">易享后台</a></li>
					  <li class="active">资料</li>
					</ol>

		</div>
            <div id="page-inner">
              <div class="row">
                  <div class="col-xs-12">
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <div class="card-title">
                                  <div class="title">详细资料</div>
                              </div>
                          </div>
                          <div class="panel-body">

						    <form class="form-horizontal" name="headForm" method="post"
						    action="${pageContext.request.contextPath}/crop.html?type=userHeadPic" enctype="multipart/form-data">
						       <div class="form-group">
	                             <label for="inputEmail3" class="col-sm-2 control-label">头像</label>
	                              <div class="col-sm-10">
                                  <div class="row">
                                    <div id="crop-avatar" class="col-md-6">
                                      <div class="avatar-view" title="" data-original-title="Change Logo Picture">
                                          <img src="${pageContext.request.contextPath}/UserImages/${user.commonUserInfo.headPic}" id="headPic" alt="Logo">
                                        </div>
                                    </div>
                                  </div>
	                              </div>
	                           </div>
                            </form>
                            <form class="form-horizontal" name="UserInfoUpdate" action="${pageContext.request.contextPath}/personalInfoUpdate.html?type=userInfo" method="post">
                            <div class="form-group">
                                      <label for="inputEmail3" class="col-sm-2 control-label">真实姓名</label>
                                      <div class="col-sm-10">
                                      <c:choose>
                                      	<c:when test="${not empty user.commonUserInfo.realName}">
                                      		<input type="text" name="realName" value="${user.commonUserInfo.realName}" class="form-control" id="" placeholder="真实姓名">
                                      	</c:when>
                                      	<c:otherwise>
                                      		<input type="text" name="realName" value="" class="form-control" id="" placeholder="真实姓名">
                                      	</c:otherwise>
                                      </c:choose>

                                 	  </div>
                                  </div>

                                  <div class="form-group">
                                      <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
                                      <div class="col-sm-10">
                                      	<input type="text" name="realName" value="${user.commonUserInfo.email}" class="form-control" id="" placeholder="邮箱">
                                      </div>
                                  </div>

                                  <!-- 只是任性的想要一个性别下拉框可选，默认为用户所选，不对不对 -->
                                   <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
                                      <div class="col-sm-10">
                                      <select name="sex" class="selectbox">
                                      		<optgroup label="性别">
                                      			<option value="${false}">男</option>
                                      			<option value="${true}">女</option>
                                      		</optgroup>
                                      </select>
                                      <span>&nbsp;您的选择是：</span>
	                                      <c:choose>
	                                      	<c:when test="${empty user.commonUserInfo.gender}">
	                                      		<label>未填写</label>
	                                      	</c:when>
	                                      	<c:otherwise>
	                                      		<c:if test="${user.commonUserInfo.gender==false}">
	                                      			<label>男</label>
	                                      		</c:if>
	                                      		<c:if test="${user.commonUserInfo.gender==true}">
	                                      			<label>女</label>
	                                      		</c:if>
	                                      	</c:otherwise>
	                                      </c:choose>
                                 	  </div>
                                  </div>

                                  <!-- 结束任性的下拉框 -->
                                  <!-- 任性的来一个对象 -->
                                  <c:if test="${user.commonUserInfo.userType==2}">

                                  <div class="form-group">
                                   	  <label for="inputPassword3" class="col-sm-2 control-label">学号</label>
                                      <div class="col-sm-10">
                                       <c:choose>
                                      		<c:when test="${not empty user.studentNum}">
                                      			 <input type="text" name="studentNum" value="${user.studentNum}" class="form-control" id="" placeholder="学号">
                                      		</c:when>
                                      		<c:otherwise>
                                      			 <input type="text" name="studentNum" value="" class="form-control" id="" placeholder="学号">
                                      		</c:otherwise>
                                      	</c:choose>

                                      </div>
                                  </div>

                                  <div class="form-group">
                                   	  <label for="inputPassword3" class="col-sm-2 control-label">专业</label>
                                      <div class="col-sm-10">
                                       <c:choose>
                                      		<c:when test="${not empty user.major}">
                                      			 <input type="text" name="major" value="${user.major}" class="form-control" id="" placeholder="专业">
                                      		</c:when>
                                      		<c:otherwise>
                                      			 <input type="text" name="major" value="" class="form-control" id="" placeholder="专业">
                                      		</c:otherwise>
                                      	</c:choose>

                                      </div>
                                  </div>

                                  <div class="form-group">
                                   	  <label for="inputPassword3" class="col-sm-2 control-label">年级</label>
                                      <div class="col-sm-10">
                                       <c:choose>
                                      		<c:when test="${not empty user.grade}">
                                      			 <input type="text" name="grade" value="${user.grade}" class="form-control" id="" placeholder="年级">
                                      		</c:when>
                                      		<c:otherwise>
                                      			 <input type="text" name="grade" value="" class="form-control" id="" placeholder="年级">
                                      		</c:otherwise>
                                      	</c:choose>

                                      </div>
                                  </div>

                                  <!-- <div class="form-group">
                                   	  <label for="inputPassword3" class="col-sm-2 control-label">所属部门</label>
                                      <div class="col-sm-10">
                                       <c:choose>
                                      		<c:when test="${not empty user.apartment}">
                                      			 <input type="text" name="apartment" value="${user.apartment}" class="form-control" id="" placeholder="所属部门">
                                      		</c:when>
                                      		<c:otherwise>
                                      			 <input type="text" name="apartment" value="" class="form-control" id="" placeholder="所属部门">
                                      		</c:otherwise>
                                      	</c:choose>

                                      </div>
                                  </div>-->

                                   <div class="form-group">
                                   	  <label for="inputPassword3" class="col-sm-2 control-label">负责人</label>
                                      <div class="col-sm-10">
                                      <select name="inCharge" class="selectbox">
                                      		<optgroup label="">
                                      			<option value="0">否</option>
                                      			<option value="1">是</option>
                                      		</optgroup>
                                      </select>
                                      <span>&nbsp;您的选择是：</span>
	                                      <c:choose>
	                                      	<c:when test="${empty user.commonUserInfo.isLeader}">
	                                      		<label>未填写</label>
	                                      	</c:when>
	                                      	<c:otherwise>
	                                      		<c:if test="${user.commonUserInfo.isLeader==0}">
	                                      			<label>否</label>
	                                      		</c:if>
	                                      		<c:if test="${user.commonUserInfo.isLeader==1}">
	                                      			<label>是</label>
	                                      		</c:if>
	                                      	</c:otherwise>
	                                      </c:choose>

                                      </div>
                                  </div>
                                  </c:if>


                                  <c:if test="${user.commonUserInfo.userType==1}">
                                  <div class="form-group">
                                   	  <label for="inputPassword3" class="col-sm-2 control-label">职称</label>
                                      <div class="col-sm-10">
                                       <c:choose>
                                      		<c:when test="${not empty user.proffessionalTitle}">
                                      			 <input type="text" name="proffessionalTitle" value="${user.proffessionalTitle}" class="form-control" id="" placeholder="职称">
                                      		</c:when>
                                      		<c:otherwise>
                                      			 <input type="text" name="proffessionalTitle" value="" class="form-control" id="" placeholder="职称">
                                      		</c:otherwise>
                                      	</c:choose>

                                      </div>
                                  </div>
                                  </c:if>


                                  <c:if test="${user.commonUserInfo.adminType!=-1}">
                                  <div class="form-group">
                                   	  <label for="inputPassword3" class="col-sm-2 control-label">管理员类型</label>
                                      <div class="col-sm-10">
                                       <c:choose>
                                      		<c:when test="${not empty user.commonUserInfo.adminType}">
                                      			<c:if test="${user.commonUserInfo.adminType==0}">
                                      				<input type="text" name="adminType" value="系统管理员" class="form-control" id="" placeholder="管理员类型">
                                      			</c:if>
                                      			 <c:if test="${user.commonUserInfo.adminType==1}">
                                      			 	<input type="text" name="adminType" value="人员管理员" class="form-control" id="" placeholder="管理员类型">
                                      			 </c:if>
                                      			  <c:if test="${user.commonUserInfo.adminType==2}">
                                      			 	<input type="text" name="adminType" value="书籍管理员" class="form-control" id="" placeholder="管理员类型">
                                      			 </c:if>
                                      			  <c:if test="${user.commonUserInfo.adminType==3}">
                                      			 	<input type="text" name="adminType" value="设备管理员" class="form-control" id="" placeholder="管理员类型">
                                      			 </c:if>
                                      			  <c:if test="${user.commonUserInfo.adminType==4}">
                                      			 	<input type="text" name="adminType" value="杂物管理员" class="form-control" id="" placeholder="管理员类型">
                                      			 </c:if>
                                      			  <c:if test="${user.commonUserInfo.adminType==5}">
                                      			 	<input type="text" name="adminType" value="项目管理员" class="form-control" id="" placeholder="管理员类型">
                                      			 </c:if>
                                      			  <c:if test="${user.commonUserInfo.adminType==6}">
                                      			 	<input type="text" name="adminType" value="资金管理员" class="form-control" id="" placeholder="管理员类型">
                                      			 </c:if>
                                      		</c:when>
                                      		<c:otherwise>
                                      			 <input type="text" value="" class="form-control" id="" placeholder="管理员类型">
                                      		</c:otherwise>
                                      	</c:choose>

                                      </div>
                                  </div>
                                  </c:if>
                                  <!-- 对象任性结束 -->

                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">QQ</label>
                                      <div class="col-sm-10">
                                       <c:choose>
                                      		<c:when test="${not empty user.commonUserInfo.QQ}">
                                      			 <input type="text" name="QQ" value="${user.commonUserInfo.QQ}" class="form-control" id="" placeholder="QQ">
                                      		</c:when>
                                      		<c:otherwise>
                                      			 <input type="text" name="QQ" value="" class="form-control" id="" placeholder="QQ">
                                      		</c:otherwise>
                                      	</c:choose>

                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">微信</label>
                                      <div class="col-sm-10">
                                      	  <c:choose>
                                      		<c:when test="${not empty user.commonUserInfo.weChat}">
                                      			 <input type="text" name="weChat" value="${user.commonUserInfo.weChat}" class="form-control" id="" placeholder="微信">
                                      		</c:when>
                                      		<c:otherwise>
                                      			<input type="text" name="weChat" value="" class="form-control" id="" placeholder="微信">
                                      		</c:otherwise>
                                      	</c:choose>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">电话号码</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="phone" value="${user.commonUserInfo.phone}" class="form-control" id="" placeholder="电话号码">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">通讯地址</label>
                                      <div class="col-sm-10">
                                      	  <c:choose>
                                      		<c:when test="${not empty user.commonUserInfo.address}">
                                      			<input type="text" name="address" value="${user.commonUserInfo.address}" class="form-control" id="" placeholder="通讯地址">
                                      		</c:when>
                                      		<c:otherwise>
                                      			<input type="text" name="address" value="" class="form-control" id="" placeholder="通讯地址">
                                      		</c:otherwise>
                                      	</c:choose>

                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <div class="col-sm-offset-2 col-sm-10">
                                          <button type="submit" class="buttoner">保存</button>
                                      </div>
                                  </div>
                                  </form>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="row">
                  <div class="col-xs-12">
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <div class="card-title">
                                  <div class="title">修改密码</div>
                              </div>
                          </div>
                          <div class="panel-body">
                              <form class="form-horizontal" name="PasswordUpdate" action="${pageContext.request.contextPath}/personalInfoUpdate.html?type=userPwd" method="post">
                                  <div class="form-group">
                                      <label for="inputEmail3" class="col-sm-2 control-label">旧密码</label>
                                      <div class="col-sm-10">
                                          <input type="password" name="oldPassword" class="form-control" id="" placeholder="旧密码">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
                                      <div class="col-sm-10">
                                          <input type="password" name="newPassword" class="form-control" id="" placeholder="新密码">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
                                      <div class="col-sm-10">
                                          <input type="password" name="fnewPassword" class="form-control" id="" placeholder="新密码">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <div class="col-sm-offset-2 col-sm-10">
                                          <button type="submit" class="buttoner">保存</button>
                                      </div>
                                  </div>
                                  </form>
                          </div>
                      </div>
                  </div>
              </div>
				 <footer><p>Copyright &copy; 2016.EasyShare All rights reserved.</p></footer>
				</div>

            </div>

        </div>
        
        
        <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <form class="avatar-form" action="${pageContext.request.contextPath}/crop.html?type=userHeadPic" enctype="multipart/form-data" method="post">
                <div class="modal-header">
                  <button class="close" data-dismiss="modal" type="button">×</button>
                  <h4 class="modal-title" id="avatar-modal-label">修改头像</h4>
                </div>
                <div class="modal-body">
                  <div class="avatar-body">
                    <div class="avatar-upload">
                      <input class="avatar-src" name="avatar_src" type="hidden">
                      <input class="avatar-data" name="avatar_data" type="hidden">
                      <label for="avatarInput">图片上传</label>
                      <input class="avatar-input" id="avatarInput" name="avatar_file" type="file"></div>
                    <div class="row">
                      <div class="col-md-9">
                        <div class="avatar-wrapper"></div>
                      </div>
                      <div class="col-md-3">
                        <div class="avatar-preview preview-lg"></div>
                        <div class="avatar-preview preview-md"></div>
                        <div class="avatar-preview preview-sm"></div>
                      </div>
                    </div>
                    <div class="row avatar-btns">
                      <div class="col-md-9">
                        <div class="btn-group">

                        </div>
                        <div class="btn-group">

                        </div>
                      </div>
                      <div class="col-md-3">
                        <button class="btn btn-success btn-block avatar-save" type="submit"><i class="fa fa-save"></i> 保存修改</button>
                      </div>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

    <!-- DATA TABLE SCRIPTS -->
   <script src="assets/js/dataTables/jquery.dataTables.js"></script>
   <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
   <script src="js/iscroll-zoom.js"></script>
   <script src="js/hammer.js"></script>
   <script src="js/lrz.all.bundle.js"></script>

   <script src="js/cropper.min.js"></script>
   <script src="js/sitelogo.js"></script>

   <script src="assets/js/select2.full.min.js"></script>
   <script type="text/javascript" src="js/historyProjectCus.js"></script>

</body>
</html>
