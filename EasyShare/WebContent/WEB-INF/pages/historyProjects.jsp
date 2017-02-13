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
    <title>ES | 历史项目</title>
    <link rel="icon" href="images/icon.png" sizes="512x512">
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />

    <link href="assets/css/select2.min.css" rel="stylesheet" >
    <link href="assets/css/checkbox3.min.css" rel="stylesheet" >

    <link rel="stylesheet" href="css/projectCus.css">
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
                     </ul>
                </div>

            </nav>

        <div id="page-wrapper">
		  <div class="header">
                        <h1 class="page-header">
                            项目管理 <small>你好 ${user.commonUserInfo.loginName}</small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="${pageContext.request.contextPath}">易享</a></li>
					  <li><a href="${pageContext.request.contextPath}/index.html?type=init">易享后台</a></li>
					  <li class="active">项目管理</li>
					</ol>

		</div>
    <div class="alert alert-danger" id="serMessage" style="margin-top: 35px;height: 30px; padding-top: 4px; margin-left:30px;margin-right:30px;">
      <strong>不行不行！</strong>请找到唯一项目再查询
    </div>
            <div id="page-inner">

                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                         历史项目列表
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                <thead>
                                                    <tr>
                                                        <th>项目编号</th>
                                                        <th>项目名称</th>
                                                        <th>委托方</th>
                                                        <th>项目类型</th>
                                                        <th>立项日期</th>
                                                        <th>结题日期</th>
                                                        <th>负责人</th>
                                                        <th>合同签订</th>
                                                        <th>完成状态</th>
                                                        <th>项目书</th>
                                                        <th>项目日志</th>
                                                        <th>操作</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${AllProjects}" var="project">
                                                	<c:if test="${project.status!=-1}">
                                                	 <tr class="odd gradeX">
                                                        <td>${project.projectID}</td>
                                                        <td>${project.projectName}</td>
                                                        <td>${project.client}</td>
                                                        <c:if test="${project.projectType==0}"><td>学生科研</td></c:if>
                                                        <c:if test="${project.projectType==1}"><td>学科竞赛</td></c:if>
                                                        <c:if test="${project.projectType==2}"><td>服务外包</td></c:if>
                                                        <c:choose>
                                                        	<c:when test="${empty project.startDate}"><td class="center" disabled="true">未填写</td></c:when>
                                                        	<c:otherwise><td class="center">${project.startDate}</td></c:otherwise>
                                                        </c:choose>
                                                         <c:choose>
                                                        	<c:when test="${empty project.endDate}"><td class="center" disabled="true">未填写</td></c:when>
                                                        	<c:otherwise><td class="center">${project.endDate}</td></c:otherwise>
                                                        </c:choose>

                                                        <c:forEach items="${AllCommonUserInfo}" var="AllCommUserInfo">
                                                        	<c:if test="${AllCommUserInfo.commonID==project.commonID}">
                                                        		<td>${AllCommUserInfo.loginName}</td>
                                                        	</c:if>
                                                        </c:forEach>
                                                        <c:choose>
                                                        	<c:when test="${project.isContract==0}"><td>已签订</td></c:when>
                                                        	<c:otherwise><td>未签订</td></c:otherwise>
                                                        </c:choose>
                                                        <!-- 根据status类数据进行添加 -->
                                                        <c:if test="${project.status==0}"><td>已完成</td></c:if>
                                                        <c:if test="${project.status==1}"><td>进行中</td></c:if>
                                                        <c:if test="${project.status==-1}"><td>已删除</td></c:if>
                                                        <td><a href="" class="linkFont">下载</a></td>
                                                        <td><a target="_blank" href="${pageContext.request.contextPath}/historyTimeLine.html?type=init&id=${project.projectID}" class="linkFont">查看</a></td>
                                                        <td><a href="${pageContext.request.contextPath}/projects.html?type=delete&id=${project.projectID}" class="delOp">删除</a></td>
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
                                               	 项目操作管理
                                            </div>
                                            <div class="panel-body">
                                                <ul class="nav nav-tabs">
                                                    <li class="active"><a href="#addProject" data-toggle="tab">添加</a>
                                                    </li>
                                                    <li class=""><a href="#editProject" data-toggle="tab">修改</a>
                                                    </li>
                                                    <%-- <li class=""><a href="#delProject" data-toggle="tab">删除</a>
                                                    </li> --%>
                                                </ul>

                                                <div class="tab-content">
                                                    <div class="tab-pane fade active in" id="addProject">
                                                        <div>
                                                        <form action="${pageContext.request.contextPath}/projects.html?type=add" method="post">
                                                            <div class="sub-title">项目名称</div>
                                                            <div>
                                                                <input type="text" name="ProjectName" class="form-control inputSty" placeholder="项目名称">
                                                            </div>
                                                            <div class="sub-title">委托方</div>
                                                            <div>
                                                                <input type="text" name="Client" class="form-control inputSty" placeholder="委托方">
                                                            </div>
                                                            <div class="sub-title">项目类型</div>
                                                            <div>
										                    	<select name="ProjectType" class="selectbox">
										                    		<optgroup label="项目类型">
										                    			<option value="2">服务外包项目</option>
										                    			<option value="1">学科竞赛项目</option>
										                    			<option value="0">学生科研项目</option>
										                    		</optgroup>
										                    	</select>
										                     </div>
                                                            <!--<div>
                                                                <input type="text" name="ProjectType" class="form-control inputSty" placeholder="项目类型">
                                                            </div>-->
                                                            <div class="sub-title">立项日期</div>
                                                            <div>
                                                                <input type="text" name="StartDate" class="form-control inputSty date_input" placeholder="立项日期【可空】" onClick="laydate({istime: true, format: 'YYYY-MM-DD'})">
                                                            </div>
                                                            <div class="sub-title">结题日期</div>
                                                            <div>
                                                                <input type="text" name="EndDate" class="form-control inputSty" placeholder="结题日期【可空】" onClick="laydate({istime: true, format: 'YYYY-MM-DD'})">
                                                            </div>

                                                            <div class="sub-title">项目负责人</div>
                                                            <div>
										                    	<select name="LeaderName" class="selectbox">
										                    		<optgroup label="负责人姓名">
										                    			<c:forEach items="${AllCommonUserInfo}" var="AllCommUserInfo">
										                    				<option value="${AllCommUserInfo.commonID}">${AllCommUserInfo.loginName}</option>
										                    			</c:forEach>
										                    		</optgroup>
										                    	</select>
										                     </div>

                                                            <div class="sub-title">是否签订合同</div>
                                                            <div>
										                    	<select name="IsContract" class="selectbox">
										                    		<optgroup label="合同签订">
										                    			<option value="1">未签订</option>
										                    			<option value="0">已签订</option>
										                    		</optgroup>
										                    	</select>
										                     </div>
                                                            <div class="sub-title">项目书</div>
                                                            <div>
                                                                <input name="ProBook" type="file" id="">
                                                            </div>
                                                            <div class="sub-title">项目状态</div>
                                                            <div>
										                    	<select name="Status" class="selectbox">
										                    		<optgroup label="项目状态">
										                    			<option value="1">进行中</option>
										                    			<option value="0">已完成</option>
										                    		</optgroup>
										                    	</select>
										                     </div>

                                                            <div class="">
                                                                <button type="submit" class="buttoner">添加</button>
                                                            </div>
                                                            </form>
                                                    </div>
                                                    </div>
                                                    <div class="tab-pane fade" id="editProject">
                                                        <div class="sub-title">请在上面的表格中搜索到你想修改的项目，点击查询即可</div>
                                                        <div>

                                                        </div>
                                                        <div class="">
                                                            <button type="button" class="buttoner" id="serProjectInfo" style="margin-top:5px;">查询</button>
                                                        </div>

                                                        <div id="updateFream">
                                                            <div>
                                                            <form action="${pageContext.request.contextPath}/projects.html?type=update" method="post">
                                                                <div class="sub-title">项目编号</div>
                                                                <div>
                                                                    <input id="ProjectId" name="newProID" type="text" class="form-control inputSty" placeholder="项目编号" readonly="true">
                                                                </div>
                                                                <div class="sub-title">项目名</div>
                                                                <div>
                                                                    <input id="newProjectName" name="newProName" type="text" class="form-control inputSty" placeholder="项目名">
                                                                </div>
                                                                <div class="sub-title">委托方</div>
                                                                <div>
                                                                    <input id="newProjectEntruster" name="newProClinet" type="text" class="form-control inputSty" placeholder="委托方">
                                                                </div>
                                                                <div class="sub-title">项目类型</div>
                                                                <div>
										                    	<select name="newProType" class="selectbox">
										                    		<optgroup label="项目类型">
										                    			<option value="2">服务外包项目</option>
										                    			<option value="1">学科竞赛项目</option>
										                    			<option value="0">学生科研项目</option>
										                    		</optgroup>
										                    	</select>
										                     </div>
                                                                <div class="sub-title">立项日期</div>
                                                                <div>
                                                                    <input id="newProjectStartDate" name="newProStartDate" type="text" class="form-control inputSty date_input" placeholder="立项日期" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                                                                </div>
                                                                <div class="sub-title">结题日期</div>
                                                                <div>
                                                                    <input id="newProjectEndDate" name="newProEndDate" type="text" class="form-control inputSty" placeholder="结题日期" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                                                                </div>
                                                                <div class="sub-title">项目负责人</div>
	                                                            <div>
											                    	<select name="newLeaderName" class="selectbox">
											                    		<optgroup label="负责人姓名">
											                    			<c:forEach items="${AllCommonUserInfo}" var="AllCommUserInfo">
											                    				<option value="${AllCommUserInfo.commonID}">${AllCommUserInfo.loginName}</option>
											                    			</c:forEach>
											                    		</optgroup>
											                    	</select>
											                     </div>
											                     <div class="sub-title">是否签订合同</div>
	                                                            <div>
											                    	<select name="newIsContract" class="selectbox">
											                    		<optgroup label="合同签订">
											                    			<option value="1">未签订</option>
											                    			<option value="0">已签订</option>
											                    		</optgroup>
											                    	</select>
											                     </div>
											                     <div class="sub-title">项目状态</div>
	                                                            <div>
											                    	<select name="newStatus" class="selectbox">
											                    		<optgroup label="项目状态">
											                    			<option value="1">进行中</option>
											                    			<option value="0">已完成</option>
											                    		</optgroup>
											                    	</select>
											                     </div>
											                     <div class="sub-title">项目书</div>
	                                                            <div>
	                                                                <input name="newProBook" type="file" id="">
	                                                            </div>
                                                                <div class="">
                                                                    <button type="submit" class="buttoner">提交修改</button>
                                                                </div>
                                                        </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            <%-- <div class="tab-pane fade" id="delProject">
                                                 <div class="sub-title">请在上面的表格中搜索到你想删除的项目，点击查询即可，暂不支持批量删除</div>
                                                <div>
                                                </div>
                                                <div class="">
  													<button type="button" class="buttoner" id="delProjectInfo" style="margin-top:5px;">删除</button>
												</div>
                                            </div> --%>
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
                                                    <c:forEach items="${AllProjects}" var="project">
                                                    	<a href="#" class="list-group-item">
                                                    		<c:if test="${project.projectType==0}"><span class="badge">学生科研</span></c:if>
                                                            <c:if test="${project.projectType==1}"><span class="badge">学科竞赛</span></c:if>
                                                            <c:if test="${project.projectType==2}"><span class="badge">服务外包</span></c:if>
                                                            <i class="fa fa-fw fa-edit"></i>
                                                            <c:if test="${project.opr==0}">新增项目：${project.projectName}；</c:if>
                                                            <c:if test="${project.opr==1}">项目${project.projectName}信息被修改；</c:if>
                                                            <c:if test="${project.status==-1}">项目${project.projectName}已被删除；</c:if>
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

    <script type="text/javascript" src="js/historyProjectCus.js"></script>
    <script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>
    <script type="text/javascript" src="js/laydate.js"></script>


</body>
</html>
