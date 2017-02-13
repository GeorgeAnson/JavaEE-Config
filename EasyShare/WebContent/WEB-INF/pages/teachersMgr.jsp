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
    <title>ES | 人员管理</title>
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
        <div class="alert alert-danger" id="serMessage" style="margin-top: 35px;height: 30px; padding-top: 4px;">
            <strong>不行不行！</strong>请找到唯一项目再查询
        </div>
            <div id="page-inner">

                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                         	教师成员列表
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                              <thead>
                                                  <tr>
                                                      <th>教师编号</th>
                                                      <th>教师姓名</th>
                                                      <th>教师性别</th>
                                                      <th>教师职称</th>
                                                      <th>联系方式</th>
                                                      <th>账号状态</th>
                                                      <th>权限组别</th>
                                                      <th>操作</th>
                                                  </tr>
                                              </thead>
                                              <tbody>
                                              <c:forEach items="${teachers}" var="teacher">
                                              	<c:if test="${teacher.commonUserInfo.status!=-1}">
                                              	<tr class="">
                                                      <td>${teacher.teacherID}</td>
                                                       <c:choose>
                                                        	<c:when test="${not empty teacher.commonUserInfo.realName}"><td>${teacher.commonUserInfo.realName}</td></c:when>
                                                        	<c:otherwise><td>${teacher.commonUserInfo.loginName}</td></c:otherwise>
                                                        </c:choose>
                                                      <c:choose>
                                                        	<c:when test="${teacher.commonUserInfo.gender==false}"><td>男</td></c:when>
                                                        	<c:otherwise><td>女</td></c:otherwise>
                                                      </c:choose>
                                                      <c:choose>
                                                        	<c:when test="${empty teacher.proffessionalTitle}"><td>未填写</td></c:when>
                                                        	<c:otherwise><td>${teacher.proffessionalTitle}</td></c:otherwise>
                                                      </c:choose>
                                                      
                                                      <c:choose>
                                                        	<c:when test="${empty teacher.commonUserInfo.phone}"><td>未填写</td></c:when>
                                                        	<c:otherwise><td>${teacher.commonUserInfo.phone}</td></c:otherwise>
                                                       </c:choose>
                                                      <c:choose>
                                                        	<c:when test="${teacher.commonUserInfo.status==1}"><td>正常</td></c:when>
                                                        	<c:otherwise><td>冻结</td></c:otherwise>
                                                        </c:choose>
				        								<c:if test="${teacher.commonUserInfo.userType==1 and teacher.commonUserInfo.adminType==-1}">
				        									<td>教师-普通用户</td>
				        								</c:if>
				        								<c:if test="${teacher.commonUserInfo.userType==1 and teacher.commonUserInfo.adminType==0}">
				        									<td>教师-系统管理</td>
				        								</c:if>
				        								<c:if test="${teacher.commonUserInfo.userType==1 and teacher.commonUserInfo.adminType==1}">
				        									<td>教师-人员管理</td>
				        								</c:if>
				        								<c:if test="${teacher.commonUserInfo.userType==1 and teacher.commonUserInfo.adminType==2}">
				        									<td>教师-书籍管理</td>
				        								</c:if>
				        								<c:if test="${teacher.commonUserInfo.userType==1 and teacher.commonUserInfo.adminType==3}">
				        									<td>教师-设备管理</td>
				        								</c:if>
				        								<c:if test="${teacher.commonUserInfo.userType==1 and teacher.commonUserInfo.adminType==4}">
				        									<td>教师-杂物管理</td>
				        								</c:if>
				        								<c:if test="${teacher.commonUserInfo.userType==1 and teacher.commonUserInfo.adminType==5}">
				        									<td>教师-项目管理</td>
				        								</c:if>
				        								<c:if test="${teacher.commonUserInfo.userType==1 and teacher.commonUserInfo.adminType==6}">
				        									<td>教师-财务管理</td>
				        								</c:if>
                                                      <th><a href="${pageContext.request.contextPath}/members.html?type=delete&id=${teacher.teacherID}&userType=1" class="delOp">删除</a></th>
                                                  </tr>
                                              </c:if>
                                              </c:forEach>
                                              </tbody>
                                            </table>
                                        </div>

                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 col-sm-6" style="width: 100%;">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                	教师成员管理
                                            </div>
                                            <div class="panel-body">
                                                <ul class="nav nav-tabs">
                                                    <li class="active"><a href="#addMember" data-toggle="tab">添加</a>
                                                    </li>
                                                    <li class=""><a href="#editMember" data-toggle="tab">修改</a>
                                                    </li>
                                                </ul>

                                                <div class="tab-content">
                                                    <div class="tab-pane fade active in" id="addMember">
                                                        <div>
                                                        <form action="${pageContext.request.contextPath}/members.html?type=add&userType=1" method="post">
                                                            <div class="sub-title">教师姓名</div>
                                                            <div>
                                                                <input name="newRealName" type="text" class="form-control inputSty" placeholder="教师姓名">
                                                            </div>
                                                             <div class="sub-title">手机号</div>
                                                            <div>
                                                                <input name="newPhone" type="text" class="form-control inputSty" placeholder="手机号">
                                                            </div>
                                                            <div class="sub-title">邮箱</div>
                                                            <div>
                                                                <input name="newEmail" type="text" class="form-control inputSty" placeholder="邮箱">
                                                            </div>
                                                            <div class="sub-title">成员性别</div>
                                                            <div>
                                                                  <div class="radio3 radio-check radio-success radio-inline">
                                                                    <input type="radio" id="sex1" name="sex" value="" checked="cheked">
                                                                    <label for="sex1">
                                                                      	男
                                                                    </label>
                                                                  </div>
                                                                  <div class="radio3 radio-check radio-success radio-inline">
                                                                    <input type="radio" id="sex2" name="sex" value="">
                                                                    <label for="sex2">
                                                                      	女
                                                                    </label>
                                                                  </div>
                                                            </div>
                                                            <div class="sub-title">教师职称</div>
                                                            <div>
                                                                <input name="newProfessionalTitle" type="text" class="form-control inputSty" placeholder="教师职称">
                                                            </div>
                                                            
                                                            <div class="sub-title">权限组</div>
                                                            <div>
                                                                    <select name="newAdminType">
                                                                            <option value="-1">普通教师</option>
                                                                            <option value="2">书籍管理</option>
                                                                            <option value="3">设备管理</option>
                                                                            <option value="5">项目管理</option>
                                                                            <option value="6">资金管理</option>
                                                                            <option value="1">人员管理</option>
                                                                            <option value="0">系统管理</option>
                                                                    </select>
                                                            </div>
                                                            <div class="">
                                                                <button type="submit" class="buttoner">添加</button>
                                                            </div>
                                                    </form>
                                                    </div>
                                                    </div>
                                                    <div class="tab-pane fade" id="editMember">
                                                        <div class="sub-title">请在上面的表格中搜索到你想修改的人员，点击查询即可</div>
                                                        <div>

                                                        </div>
                                                        <div class="">
                                                            <button type="button" class="buttoner" id="serMemberInfo" style="margin-top:5px;">查询</button>
                                                        </div>

                                                        <div id="updateFream">
                                                            <div>
                                                            <form action="${pageContext.request.contextPath}/members.html?type=update&userType=1" method="post">
                                                                <div class="sub-title">教师编号</div>
                                                                <div>
                                                                    <input id="memberId" name="userID" type="text" class="form-control inputSty" placeholder="教师编号" readonly="true">
                                                                </div>
                                                                <div class="sub-title">教师姓名</div>
                                                                <div>
                                                                    <input id="memberName" name="memberName" type="text" class="form-control inputSty" placeholder="教师姓名">
                                                                </div>
                                                                <div class="sub-title">教师职称</div>
                                                                <div>
                                                                    <input id="memberPro" name="professionalTitle" type="text" class="form-control inputSty" placeholder="教师职称">
                                                                </div>
                                                                <div class="sub-title">教师性别</div>
                                                                <div>
                                                                      <div class="radio3 radio-check radio-success radio-inline">
                                                                        <input type="radio" id="newSex1" name="newSex" value="" checked="cheked">
                                                                        <label for="newSex1">
                                                                          	男
                                                                        </label>
                                                                      </div>
                                                                      <div class="radio3 radio-check radio-success radio-inline">
                                                                        <input type="radio" id="newSex2" name="newSex" value="">
                                                                        <label for="newSex2">
                                                                         	 女
                                                                        </label>
                                                                      </div>
                                                                </div>
                                                                <div class="sub-title">联系方式</div>
                                                                <div>
                                                                    <input id="memberContact" name="phone" type="text" class="form-control inputSty" placeholder="联系方式">
                                                                </div>
                                                                <div class="sub-title">账号状态</div>
                                                                <div>
                                                                        <select name="menberStatus">
                                                                                <option value="0">冻结</option>
                                                                                <option value="1">正常</option>
                                                                        </select>
                                                                </div>
                                                                <div class="sub-title">权限组</div>
                                                                <div>
                                                                    <select name="adminType">
                                                                            <option value="-1">普通教师</option>
                                                                            <option value="2">书籍管理</option>
                                                                            <option value="3">设备管理</option>
                                                                            <option value="5">项目管理</option>
                                                                            <option value="6">资金管理</option>
                                                                            <option value="1">人员管理</option>
                                                                            <option value="0">系统管理</option>
                                                                    </select>
                                                                </div>
                                                                
                                                                <div class="">
                                                                    <button type="submit" class="buttoner">修改</button>
                                                                </div>
                                                        </form>
                                                        </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-12 col-xs-12" style="width: 100%">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                	近期日志
                                            </div>
                                            <div class="panel-body">
                                                <div class="list-group">
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

   <script type="text/javascript" src="js/labMemTeacCus.js"></script>
   <script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>

</body>
</html>
