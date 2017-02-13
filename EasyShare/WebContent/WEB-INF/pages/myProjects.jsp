<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>ES | 我的项目</title>
    <link rel="icon" href="images/icon.png" sizes="512x512">
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="assets/js/dataTables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="css/nisalButton.css">
    <link rel="stylesheet" href="css/projectCus.css" media="screen" title="no title">
</head>
<body>
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
                        <a class="active-menu" href="${pageContext.request.contextPath}/projects.html?type=myProj"><i class="fa fa-sitemap"></i>项目管理<span class="fa arrow"></span></a>
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
                            我的项目 <small>你好 ${user.commonUserInfo.loginName}</small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="${pageContext.request.contextPath}">易享</a></li>
					  <li><a href="${pageContext.request.contextPath}/index.html?type=init">易享后台</a></li>
					  <li class="active">我的项目</li>
					</ol>

		</div>

            <div id="page-inner">
            <c:forEach items="${MyAliveProjects}" var="myProject">
                <div class="row">
                    <div class="col-md-12">
                        <div class="jumbotron" style="font-size: 16px;">
                            <h2>${myProject.projectName}</h2>
                            <a href="${pageContext.request.contextPath}/projects.html?type=done&id=${myProject.projectID}&page=myPro"><button type="button" class="buttoner">项目完成</button></a>
                            <br>

                               <div class="panel-body">
                                   <div class="table-responsive">
                                       <table class="table table-hover">
                                           <tbody>
                                                <tr>
                                                   <td>委托方:</td>
                                                   <td>${myProject.client}</td>
                                               </tr>
                                               <tr>
                                                   <td>项目类型:</td>
                                                   <c:if test="${myProject.projectType==0}"><td>学生科研</td></c:if>
                                                   <c:if test="${myProject.projectType==1}"><td>学科竞赛</td></c:if>
                                                   <c:if test="${myProject.projectType==2}"><td>服务外包</td></c:if>
                                               </tr>

                                               <tr>
                                                   <td>立项日期:</td>
                                                   <c:choose>
                                                   	<c:when test="${empty myProject.startDate}"><td>未填写</td></c:when>
                                                   	<c:otherwise><td>${myProject.startDate}</td></c:otherwise>
                                                   </c:choose>
                                               </tr>
                                               <tr>
                                                   <td>结题日期:</td>
                                                   <c:choose>
                                                   	<c:when test="${empty myProject.endDate}"><td>未填写</td></c:when>
                                                   	<c:otherwise><td>${myProject.endDate}</td></c:otherwise>
                                                   </c:choose>
                                               </tr>
                                               <tr>
                                                   <td>项目负责人:</td>
                                                   <td>${myProject.commonUserInfo.loginName}</td>
                                               </tr>
                                               <tr>
                                                   <td>是否签订合同:</td>
                                                   <c:choose>
                                                   	<c:when test="${myProject.isContract==1}"><td>未签</td></c:when>
                                                   	<c:otherwise><td>已签</td></c:otherwise>
                                                   </c:choose>
                                               </tr>
                                               <tr>
                                                   <td>日志时间轴:</td>
                                                   <td><a target="_blank" href="${pageContext.request.contextPath}/historyTimeLine.html?type=init&id=${myProject.projectID}" class="linkFont">查看</a></td>
                                               </tr>
                                               <tr>
                                                   <td>项目书:</td>
                                                   <td><a href="" class="linkFont">下载</a></td>
                                               </tr>
                                               <tr>
                                                   <td>添加日志:</td>
                                                   <td>
                                                   <form action="${pageContext.request.contextPath}/historyTimeLine.html?type=add&id=${myProject.projectID}" method="post">
                                                   	  <input name="newlogtxt" type="text" placeholder="${'当前进度信息'}">
                                                      <button type="submit" class="buttoner" style="margin-top: 0px; margin-left: 5px;width: 100px;height: 35px;">
                                                         	添加
                                                      </button>
                                                   </form>
                                                   </td>
                                               </tr>
                                           </tbody>
                                       </table>
                                   </div>
                               </div>

                        </div>
                    </div>
                </div>
                </c:forEach>
				 <footer><p>Copyright &copy; 2016.EasyShare All rights reserved.</p></footer>
				</div>

            </div>
        </div>

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

</body>
</html>
