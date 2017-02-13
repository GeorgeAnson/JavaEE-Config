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
    <title>EasyShare|易享</title>
    <link rel="icon" href="images/icon.png" sizes="512x512">
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
    <link rel="stylesheet" href="assets/js/dataTables/dataTables.bootstrap.css">
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
                    <a class="active-menu" href="${pageContext.request.contextPath}/index.html?type=init"><i class="fa fa-dashboard"></i>易享后台</a>
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
                易享后台 <small>你好 <span id="">${user.commonUserInfo.loginName}</span></small>
            </h1>
			<ol class="breadcrumb">
		        <li><a href="${pageContext.request.contextPath}">易享</a></li>
		        <li><a href="${pageContext.request.contextPath}/index.html?type=init">易享后台</a></li>
		        <li class="active">后台首页</li>
		    </ol>
		</div>
            <div id="page-inner">

                <div class="row">
                    <div class="col-md-3 col-sm-12 col-xs-12">
    					<div class="board">
                            <div class="panel panel-primary">
        						<div class="number">
        							<h3>
        								<h3>${user.commonUserInfo.loginName}</h3>
        								<small>

        								<c:if test="${user.commonUserInfo.userType==2 and user.commonUserInfo.adminType==-1}">
        									权限：学生-普通用户
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==2 and user.commonUserInfo.adminType==0}">
        									权限：学生-系统管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==2 and user.commonUserInfo.adminType==1}">
        									权限：学生-人员管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==2 and user.commonUserInfo.adminType==2}">
        									权限：学生-书籍管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==2 and user.commonUserInfo.adminType==3}">
        									权限：学生-设备管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==2 and user.commonUserInfo.adminType==4}">
        									权限：学生-杂物管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==2 and user.commonUserInfo.adminType==5}">
        									权限：学生-项目管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==2 and user.commonUserInfo.adminType==6}">
        									权限：学生-财务管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==1 and user.commonUserInfo.adminType==-1}">
        									权限：教师-普通用户
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==1 and user.commonUserInfo.adminType==0}">
        									权限：教师-系统管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==1 and user.commonUserInfo.adminType==1}">
        									权限：教师-人员管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==1 and user.commonUserInfo.adminType==2}">
        									权限：教师-书籍管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==1 and user.commonUserInfo.adminType==3}">
        									权限：教师-设备管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==1 and user.commonUserInfo.adminType==4}">
        									权限：教师-杂物管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==1 and user.commonUserInfo.adminType==5}">
        									权限：教师-项目管理
        								</c:if>
        								<c:if test="${user.commonUserInfo.userType==1 and user.commonUserInfo.adminType==6}">
        									权限：教师-财务管理
        								</c:if>
        								</small>
        							</h3>
        						</div>
                    <div class="icon">
                        <img src="${pageContext.request.contextPath}/UserImages/${user.commonUserInfo.headPic}"  width="68px" height="68px" onclick="imgShow($(this))"/>
                        <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:999;width:100%;height:100%;display:none;">
                            <div id="innerdiv" style="position:absolute;"><img id="bigimg" style="border:5px solid #fff;" src="" /></div>
                        </div>
        			</div>
                  </div>
    					</div>
                    </div>
				    <div class="col-md-3 col-sm-12 col-xs-12">
    					<div class="board">
                            <div class="panel panel-primary">
        						<div class="number">
        							<h3>
        								<h3>消费平台</h3>
        								<small>暂未开放</small>
        							</h3>
        						</div>
            						<div class="icon">
            						   <i class="fa fa-shopping-cart fa-5x blue"></i>
            						</div>
                            </div>
        				</div>
                    </div>
					<div class="col-md-3 col-sm-12 col-xs-12">
    					<div class="board">
                            <div class="panel panel-primary">
        						<div class="number">
        							<h3>
        								<h3>微信账号</h3>
        								<small>
        								<c:choose>
        									<c:when test="${not empty user.commonUserInfo.weChat}">
        										${user.commonUserInfo.weChat}
        									</c:when>
        									<c:otherwise>
        										用户很懒
        									</c:otherwise>
        								</c:choose>
        								</small>
        							</h3>
        						</div>
        						<div class="icon">
        						   <i class="fa fa-comments fa-5x green"></i>
        						</div>
                            </div>
    					</div>
                    </div>
    				<div class="col-md-3 col-sm-12 col-xs-12">
    				    <div class="board">
                            <div class="panel panel-primary">
        						<div class="number">
        							<h3>
        								<h3>近期登陆</h3>
        								<small>${loginInfo.ip}</small>
        							</h3>
        						</div>
        						<div class="icon">
        						   <i class="fa fa-terminal fa-5x yellow"></i>
        						</div>
                            </div>
    					</div>
                    </div>
                </div>

               <!-- <div class="row">
        			<div class="col-xs-6 col-md-3">
        				<div class="panel panel-default">
        					<div class="panel-body easypiechart-panel">
        						<h4>溜溜英语</h4>
        						<div class="easypiechart" id="easypiechart-blue" data-percent="98" ><span class="percent">98%</span>
        						</div>
        					</div>
        				</div>
        			</div>
        			<div class="col-xs-6 col-md-3">
        				<div class="panel panel-default">
        					<div class="panel-body easypiechart-panel">
        						<h4>图像置换</h4>
        						<div class="easypiechart" id="easypiechart-orange" data-percent="55" ><span class="percent">55%</span>
        						</div>
        					</div>
        				</div>
        			</div>
        			<div class="col-xs-6 col-md-3">
        				<div class="panel panel-default">
        					<div class="panel-body easypiechart-panel">
        						<h4>挑战杯</h4>
        						<div class="easypiechart" id="easypiechart-teal" data-percent="84" ><span class="percent">84%</span>
        						</div>
        					</div>
        				</div>
        			</div>
                    <div class="col-xs-6 col-md-3">
                        <div class="panel panel-default">
                            <div class="panel-body easypiechart-panel">
                                <h4>心电数据压缩</h4>
                                <div class="easypiechart" id="easypiechart-red" data-percent="46" ><span class="percent">46%</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>-->

				<div class="row">
				    <div class="col-md-12"></div>
				</div>


                
                <div class="row">
                                  <div class="col-sm-12 col-xs-12">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                用户近期登录日志
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">

                                        <thead>
                                            <tr>
                                                <th>用户昵称</th>
                                                <th>用户类型</th>
                                                <th>用户性别</th>
                                                <th>登录IP</th>
                                                <th>登录时间</th>
                                                <th>用户权限</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       <c:forEach items="${userInfo}" var="userInfo">
                                       <c:if test="${not empty userInfo.IP and not empty userInfo.recentlyLogin}">
                                       		<tr>
                                       		<td>${userInfo.loginName}</td>
                                       		<td>学生</td>
                                       		<c:choose>
                                       			<c:when test="${userInfo.gender==false}">
                                       				<td>男</td>
                                       			</c:when>
                                       			<c:otherwise>
                                       				<td>女</td>
                                       			</c:otherwise>
                                       		</c:choose>
                                       		<td>${userInfo.IP}</td>
                                       		<td>${userInfo.recentlyLogin}</td>
                                       		<c:if test="${userInfo.adminType==-1}"><td>普通用户</td></c:if>
                                       		<c:if test="${userInfo.adminType==0}"><td>系统用户</td></c:if>
                                       		<c:if test="${userInfo.adminType==1}"><td>人员管理</td></c:if>
                                       		<c:if test="${userInfo.adminType==2}"><td>书籍管理</td></c:if>
                                       		<c:if test="${userInfo.adminType==3}"><td>设备管理</td></c:if>
                                       		<c:if test="${userInfo.adminType==4}"><td>杂物管理</td></c:if>
                                       		<c:if test="${userInfo.adminType==5}"><td>项目管理</td></c:if>
                                       		<c:if test="${userInfo.adminType==6}"><td>资金管理</td></c:if>
                                       		</tr>
                                       	</c:if>
                                       </c:forEach>
                                        </tbody>
                                    </table>
                                    <div class="text-right">
                                        <a href="#">更多<i class="fa fa-arrow-circle-right"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                   </div>
                <div class="row">
                    <div class="col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                	近期动态
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
                                <c:forEach items="${equipments}" var="equipment">
                                     <a href="#" class="list-group-item">
                                     	<span class="badge">￥ ${equipment.price} , Total ${equipment.amount}</span>
                                     	<i class="fa fa-fw fa-edit"></i>实验室添加 了编号为${equipment.equipmentID}的设备“${equipment.equipmentName}”,库存余量为${equipment.remain}件
                                     </a>
                         		</c:forEach>
                         		 <c:forEach items="${students}" var="student">
                                                	
                                                	<c:if test="${student.commonUserInfo.status==-1}">
                                                		<a href="#" class="list-group-item">
                                                		<span class="badge">用户类型：学生</span>
                                                        <i class="fa fa-fw fa-edit"></i>用户名为${student.commonUserInfo.loginName}的账号被删除
                                                    </a>
                                                	</c:if>
                                                	<c:choose>
                                                		<c:when test="${student.commonUserInfo.opr==0}">
                                                		
                                                		<a href="#" class="list-group-item">
                                                			<span class="badge">用户类型：学生</span>
                                                        	<i class="fa fa-fw fa-edit"></i>用户名为${student.commonUserInfo.loginName}的账号被创建
                                                    	</a>
                                                	    </c:when>
                                                	    <c:otherwise>
                                                	    	<a href="#" class="list-group-item">
                                                			<span class="badge">用户类型：学生</span>
                                                        <i class="fa fa-fw fa-edit"></i>用户名为${student.commonUserInfo.loginName}的账号被修改
                                                    	</a>
                                                	    </c:otherwise>
                                                	</c:choose>
                                                </c:forEach>
                                                <c:forEach items="${teachers}" var="teacher">
                                                	
                                                	<c:if test="${teacher.commonUserInfo.status==-1}">
                                                		<a href="#" class="list-group-item">
                                                		<span class="badge">用户类型：教师</span>
                                                        <i class="fa fa-fw fa-edit"></i>用户名为${teacher.commonUserInfo.loginName}的账号被删除
                                                    </a>
                                                	</c:if>
                                                	<c:choose>
                                                		<c:when test="${teacher.commonUserInfo.opr==0}">
                                                		
                                                		<a href="#" class="list-group-item">
                                                			<span class="badge">用户类型：教师</span>
                                                        	<i class="fa fa-fw fa-edit"></i>用户名为${teacher.commonUserInfo.loginName}的账号被创建
                                                    	</a>
                                                	    </c:when>
                                                	    <c:otherwise>
                                                	    	<a href="#" class="list-group-item">
                                                			<span class="badge">用户类型：教师</span>
                                                        <i class="fa fa-fw fa-edit"></i>用户名为${teacher.commonUserInfo.loginName}的账号被修改
                                                    	</a>
                                                	    </c:otherwise>
                                                	</c:choose>
                                                </c:forEach>
                                </div>
                                <div class="text-right">
                                    <a href="#">更多<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
  
                </div>
			<footer><p>Copyright &copy; 2016.EasyShare All rights reserved.</p>
			</footer>
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


	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>


    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
    <!-- imgbox Js -->
    <script src="js/imgbox.js"></script>
</body>

</html>
