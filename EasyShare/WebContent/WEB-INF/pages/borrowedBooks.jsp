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
    <title>ES | 借出的书</title>
    <link rel="icon" href="images/icon.png" sizes="512x512">
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />

    <link href="assets/css/select2.min.css" rel="stylesheet" >
    <link href="assets/css/checkbox3.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="assets/js/dataTables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="css/nisalButton.css">
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
                            <a class="active-menu" href="${pageContext.request.contextPath}/books.html?type=book"><i class="fa fa-sitemap"></i>书籍管理<span class="fa arrow"></span></a>
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
                    书籍管理 <small>你好 ${user.commonUserInfo.loginName}</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}">易享</a></li>
                    <li><a href="${pageContext.request.contextPath}/index.html?type=init">易享后台</a></li>
                    <li class="active">借出情况</li>
                </ol>
            </div>
            <div id="page-inner">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        借书列表
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                    	<th>借书编号</th>
                                        <th>书本编号</th>
                                        <th>书本名称</th>
                                        <th>书本作者</th>
                                        <th>书本价格</th>
                                        <th>出版社名</th>
                                        <th>借书日期</th>
                                        <th>还书日期</th>
                                    </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${allBorrowedBooks}" var="Book">
                                	<tr>
				                  	  <td>${Book.manageBookID}</td>
				                      <td>${Book.bookID}</td>
				                      <td>${Book.book.bookName}</td>
				                      <td>${Book.book.author}</td>
				                      <td>${Book.book.price}</td>
				                      <td>${Book.book.publishCompany}</td>
				                      <td>${Book.borrowDate}</td>
				                      <c:choose>
				                      	<c:when test="${not empty Book.returnDate}">
				                      		<td>${Book.returnDate}</td>
				                      	</c:when>
				                      	<c:otherwise>
				                      		<td>尚未归还</td>
				                      	</c:otherwise>
				                      </c:choose>

				                    </tr>
				           		</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="row">
                <div class="col-md-4 col-sm-12 col-xs-12" style="width: 100%">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                                           近期日志
                        </div>
                        <div class="panel-body">
                            <div class="list-group">
                             <c:forEach items="${allBorrowedBooks}" var="Book">
                                <a href="#" class="list-group-item">
                                <span class="badge">${Book.borrowDate}</span>
                             	<c:choose>
                             		<c:when test="${empty Book.returnDate}">
                             			<i class="fa fa-fw fa-edit"></i>${Book.loginName}借了 一本${Book.book.bookName}
                             		</c:when>
                             		<c:otherwise>
                             			<i class="fa fa-fw fa-edit"></i>${Book.loginName}还回之前借的${Book.book.bookName}一书
                             		</c:otherwise>
                             	</c:choose>
                                </a>
                             </c:forEach>
                            </div>
                            <div class="text-right">
                                <a href="#">更多<i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
<script src="assets/js/select2.full.min.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="assets/js/dataTables/jquery.dataTables.js"></script>
<script src="assets/js/dataTables/dataTables.bootstrap.js"></script>

<!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>

<script type="text/javascript" src="js/borrowedBooksCus.js"></script>
<script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>

</body>
</html>
