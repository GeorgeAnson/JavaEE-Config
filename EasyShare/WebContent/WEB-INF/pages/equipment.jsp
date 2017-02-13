<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>ES | 设备</title>
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
                    <a class="active-menu" href="${pageContext.request.contextPath}/equipment.html?type=equip"><i class="fa fa-desktop"></i>设备管理</a>
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
                <!-- <li>
                    <a href="${pageContext.request.contextPath}/members.html?type=member"><i class="fa fa-users"></i>成员管理</a>
                </li>-->
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
                            设备管理 <small>你好 ${user.commonUserInfo.loginName}</small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="${pageContext.request.contextPath}">易享</a></li>
					  <li><a href="${pageContext.request.contextPath}/index.html?type=init">易享后台</a></li>
					  <li class="active">设备管理</li>
					</ol>

		</div>
    <div class="alert alert-danger" id="serMessage" style="margin-top: 35px;height: 30px; padding-top: 4px; margin-left:30px;margin-right:30px;">
      <strong>不行不行！</strong>请找到唯一项目再查询
    </div>
            <div id="page-inner">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                         	设备列表
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                <thead>
                                                    <tr>
                                                        <th>设备编号</th>
                                                        <th>设备名称</th>
                                                        <th>设备价格</th>
                                                        <th>库存总量</th>
                                                        <th>库存余量</th>
                                                        <th>设备状态</th>
                                                        <th>设备简述</th>
                                                        <th>操作</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${equipments}" var="equipment">
                                                	 <c:if test="${equipment.status!=-1}">
                                                	 <tr class="odd gradeX">
                                                        <td>${equipment.equipmentID}</td>
                                                        <td>${equipment.equipmentName}</td>
                                                        <td>${equipment.price}</td>
                                                        <td class="center">${equipment.amount}</td>
                                                        <td class="center">${equipment.remain}</td>
                                                        <c:choose>
                                                        	<c:when test="${equipment.status==0}">
                                                        		<td>闲置中</td>
                                                        	</c:when>
                                                        	<c:otherwise>
                                                        		<c:choose>
                                                        			<c:when test="${equipment.status==1}">
                                                        				<td>使用中</td>
                                                        			</c:when>
                                                        			<c:otherwise>
                                                        				<c:choose>
                                                        					<c:when test="${equipment.status==2}">
                                                        						<td>已损坏</td>
                                                        					</c:when>
                                                        					<c:otherwise>
                                                        						<td>丢弃、报废或其他</td>
                                                        					</c:otherwise>
                                                        				</c:choose>
                                                        			</c:otherwise>
                                                        		</c:choose>
                                                        	</c:otherwise>
                                                        </c:choose>

                                                        <td>${equipment.sketch}</td>
                                                        <td><a href="${pageContext.request.contextPath}/equipment.html?type=delete&id=${equipment.equipmentID}" class="delOp">删除</a></td>
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
                                                	设备操作管理
                                            </div>
                                            <div class="panel-body">
                                                <ul class="nav nav-tabs">
                                                    <li class="active"><a href="#addEquit" data-toggle="tab">添加</a>
                                                    </li>
                                                    <li class=""><a href="#editEquit" data-toggle="tab">修改</a>
                                                    </li>
                                                </ul>

                                                <div class="tab-content">
                                                    <div class="tab-pane fade active in" id="addEquit">
                                                    <form id="addEquipForm" action="${pageContext.request.contextPath}/equipment.html?type=add" method="post">
                                                        <div>
                                                            <div class="sub-title">设备名称</div>
                                                            <div>
                                                                <input name="equipmentName" type="text" class="form-control inputSty" placeholder="设备名称">
                                                            </div>
                                                            <div class="sub-title">设备价格</div>
                                                            <div>
                                                                <input name="equipmentPrice" type="text" class="form-control inputSty" placeholder="设备价格【未知留空】">
                                                            </div>
                                                            <div class="sub-title">库存总量</div>
                                                            <div>
                                                                <input name="equipmentAmount" type="text" class="form-control inputSty" placeholder="库存总量">
                                                            </div>
                                                             <div class="sub-title">库存余量</div>
                                                            <div>
                                                                <input name="equipmentRemain" type="text" class="form-control inputSty" placeholder="库存余量">
                                                            </div>

                                                            <div class="sub-title">设备状态</div>
                                                            <div>
                                                                  <div class="radio3 radio-check radio-success radio-inline">
                                                                    <input type="radio" id="equiState1" name="equiStatus" value="0" checked="">
                                                                    <label for="equiState1">
                                                                      	闲置中
                                                                    </label>
                                                                  </div>
                                                                  <div class="radio3 radio-check radio-success radio-inline">
                                                                    <input type="radio" id="equiState2" name="equiStatus" value="1">
                                                                    <label for="equiState2">
                                                                   	      使用中
                                                                    </label>
                                                                  </div>
                                                                  <div class="radio3 radio-check radio-success radio-inline">
                                                                    <input type="radio" id="equiState3" name="equiStatus" value="2">
                                                                    <label for="equiState3">
                                                                      	已损坏
                                                                    </label>
                                                                  </div>
                                                                  <div class="radio3 radio-check radio-success radio-inline">
                                                                    <input type="radio" id="equiState4" name="equiStatus" value="3">
                                                                    <label for="equiState4">
                                                                      	丢弃、报废或其他
                                                                    </label>
                                                                  </div>
                                                            </div>
                                                            <div class="sub-title">设备简述</div>
                                                            <div>
                                                                <input name="equipmentSketch" type="text" class="form-control inputSty" placeholder="简述应用">
                                                            </div>
                                                            <div class="">
                                                                <button type="submit" class="buttoner">添加</button>
                                                            </div>
                                                    </div>
                                                    </form>
                                                    </div>
                                                    <div class="tab-pane fade" id="editEquit">
                                                        <div class="sub-title">请在上面的表格中搜索到你想修改的设备，点击查询即可</div>
                                                        <div>

                                                        </div>
                                                        <div class="">
                                                            <button type="button" class="buttoner" id="serEquitInfo" style="margin-top:5px;">查询</button>
                                                        </div>
                                                        <form action="${pageContext.request.contextPath}/equipment.html?type=update" method="post">
                                                        <div id="updateFream">
                                                        <div class="sub-title">设备编号</div>
                                                        <div>
                                                            <input name="equipmentID" type="text" class="form-control inputSty" placeholder="设备编号" id="newEquiId" readonly="true">
                                                        </div>
                                                        <div class="sub-title">设备名称</div>
                                                        <div>
                                                            <input name="equipmentName" type="text" class="form-control inputSty" placeholder="设备名称" id="newEquiName">
                                                        </div>
                                                        <div class="sub-title">设备价格</div>
                                                        <div>
                                                            <input name="equipmentPrice" type="text" class="form-control inputSty" placeholder="设备价格【未知留空】" id="newEquiPrice">
                                                        </div>
                                                        <div class="sub-title">库存总量</div>
                                                        <div>
                                                            <input name="equipmentAmount" type="text" class="form-control inputSty" placeholder="设备库存总量" id="newEquiAmount">
                                                        </div>
                                                        <div class="sub-title">库存余量</div>
                                                        <div>
                                                            <input name="equipmentRemain" type="text" class="form-control inputSty" placeholder="设备库存余量" id="newEquiRemain">
                                                        </div>
                                                        <div class="sub-title">设备状态</div>
                                                        <div>
                                                              <div class="radio3 radio-check radio-success radio-inline">
                                                                <input type="radio" id="newEquiState1" name="newEquiState" value="0" checked="">
                                                                <label for="newEquiState1">
                                                                  	闲置中
                                                                </label>
                                                              </div>
                                                              <div class="radio3 radio-check radio-success radio-inline">
                                                                <input type="radio" id="newEquiState2" name="newEquiState" value="1">
                                                                <label for="newEquiState2">
                                                                  	使用中
                                                                </label>
                                                              </div>
                                                              <div class="radio3 radio-check radio-success radio-inline">
                                                                <input type="radio" id="newEquiState3" name="newEquiState" value="2">
                                                                <label for="newEquiState3">
                                                                  	已损坏
                                                                </label>
                                                              </div>
                                                              <div class="radio3 radio-check radio-success radio-inline">
                                                                <input type="radio" id="newEquiState4" name="newEquiState" value="3">
                                                                <label for="newEquiState4">
                                                                  	丢弃、报废或其他
                                                                </label>
                                                              </div>
                                                        </div>
                                                        <div class="sub-title">设备简述</div>
                                                        <div>
                                                            <input name="equipmentSketch" type="text" class="form-control inputSty" placeholder="简述应用" id="newSimplePro">
                                                        </div>
                                                        <div class="">
                                                            <button type="submit" class="buttoner">提交修改</button>
                                                        </div>
                                                    </div>
                                                    </form>
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
                                               		<c:forEach items="${equipments}" var="equipment">
                                                		<a href="#" class="list-group-item">
                                                        <span class="badge">￥ ${equipment.price} , Total ${equipment.amount}</span>
                                                        <i class="fa fa-fw fa-edit"></i>实验室添加 了编号为${equipment.equipmentID}的设备“${equipment.equipmentName}”,库存余量为${equipment.remain}件
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

    <script type="text/javascript" src="js/equitmentCus.js"></script>
    <script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>

</body>
</html>
