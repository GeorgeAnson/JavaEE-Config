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
                            成员管理 <small>你好 ${user.commonUserInfo.loginName}</small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="${pageContext.request.contextPath}">易享</a></li>
					  <li><a href="${pageContext.request.contextPath}/index.html?type=init">易享后台</a></li>
					  <li class="active">成员管理</li>
					</ol>

		</div>
    <div class="alert alert-danger" id="serMessage" style="margin-top: 35px;height: 30px; padding-top: 4px; margin-left:30px;margin-right:30px;">
      <strong>不行不行！</strong>请找到唯一项目再查询
    </div>
            <div id="page-inner">

                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                         	成员列表
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                <thead>
                                                    <tr>
                                                    	<th>成员编号</th>
                                                        <th>成员学号</th>
                                                        <th>成员姓名</th>
                                                        <th>成员班级</th>
                                                        <th>成员性别</th>
                                                        <th>所属部门</th>
                                                        <th>权限组</th>
                                                        <th>是否毕业</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr class="odd gradeX">
                                                    	<td></td>
                                                        <td>15401190220</td>
                                                        <td>Nisal</td>
                                                        <td>网络152</td>
                                                        <td class="center">男</td>
                                                        <td class="center">技术部</td>
                                                        <td>学生</td>
                                                        <td>否</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 col-sm-6" style="width: 100%;">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                	成员管理
                                            </div>
                                            <div class="panel-body">
                                                <ul class="nav nav-tabs">
                                                    <li class="active"><a href="#addMember" data-toggle="tab">添加</a>
                                                    </li>
                                                    <li class=""><a href="#editMember" data-toggle="tab">修改</a>
                                                    </li>
                                                    <li class=""><a href="#delMember" data-toggle="tab">删除</a>
                                                    </li>
                                                </ul>

                                                <div class="tab-content">
                                                    <div class="tab-pane fade active in" id="addMember">
                                                        <div>
                                                            <div class="sub-title">成员学号</div>
                                                            <div>
                                                                <input type="text" class="form-control inputSty" placeholder="成员学号">
                                                            </div>
                                                            <div class="sub-title">成员姓名</div>
                                                            <div>
                                                                <input type="text" class="form-control inputSty" placeholder="成员姓名">
                                                            </div>
                                                            <div class="sub-title">成员班级</div>
                                                            <div>
                                                                <input type="text" class="form-control inputSty" placeholder="成员班级">
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
                                                            <div class="sub-title">所属部门</div>
                                                            <div>
                                                            <select>
                                                                    <option value="">技术部</option>
                                                                    <option value="">物流部</option>
                                                                    <option value="">办公室</option>
                                                                    <option value="">xxx</option>
                                                                    <option value="">xxx</option>
                                                                    <option value="">xxx</option>
                                                                    <option value="">xxx</option>
                                                                    <option value="">xxx</option>
                                                            </select>
                                                            </div>
                                                            <div class="sub-title">权限组</div>
                                                            <div>
                                                                    <select>
                                                                            <option value="">学生</option>
                                                                            <option value="">教师</option>
                                                                            <option value="">设备管理员</option>
                                                                            <option value="">书籍管理员</option>
                                                                            <option value="">资金管理员</option>
                                                                            <option value="">维修服务统计管理员</option>
                                                                            <option value="">项目管理员</option>
                                                                            <option value="">全站管理员</option>
                                                                    </select>
                                                            </div>
                                                            <div class="sub-title">是否毕业</div>
                                                            <div>
                                                                <div>
                                                                      <div class="radio3 radio-check radio-success radio-inline">
                                                                        <input type="radio" id="graduated1" name="graduated" value="" checked="cheked">
                                                                        <label for="graduated1">
                                                                          是
                                                                        </label>
                                                                      </div>
                                                                      <div class="radio3 radio-check radio-success radio-inline">
                                                                        <input type="radio" id="graduated2" name="graduated" value="">
                                                                        <label for="graduated2">
                                                                          否
                                                                        </label>
                                                                      </div>
                                                                </div>
                                                            </div>
                                                            <div class="">
                                                                <button type="button" class="buttoner">添加</button>
                                                            </div>
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
                                                                <div class="sub-title">成员学号</div>
                                                                <div>
                                                                    <input id="memberId" type="text" class="form-control inputSty" placeholder="成员学号" readonly="true">
                                                                </div>
                                                                <div class="sub-title">成员姓名</div>
                                                                <div>
                                                                    <input id="memberName" type="text" class="form-control inputSty" placeholder="成员姓名">
                                                                </div>
                                                                <div class="sub-title">成员班级</div>
                                                                <div>
                                                                    <input id="memberClass" type="text" class="form-control inputSty" placeholder="成员班级">
                                                                </div>
                                                                <div class="sub-title">成员性别</div>
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
                                                                <div class="sub-title">所属部门</div>
                                                                <div>
                                                                <select>
                                                                        <option value="">技术部</option>
                                                                        <option value="">物流部</option>
                                                                        <option value="">办公室</option>
                                                                        <option value="">xxx</option>
                                                                        <option value="">xxx</option>
                                                                        <option value="">xxx</option>
                                                                        <option value="">xxx</option>
                                                                        <option value="">xxx</option>
                                                                </select>
                                                                </div>
                                                                <div class="sub-title">权限组</div>
                                                                <div>
                                                                        <select>
                                                                                <option value="">学生</option>
                                                                                <option value="">教师</option>
                                                                                <option value="">设备管理员</option>
                                                                                <option value="">书籍管理员</option>
                                                                                <option value="">资金管理员</option>
                                                                                <option value="">维修服务统计管理员</option>
                                                                                <option value="">项目管理员</option>
                                                                                <option value="">全站管理员</option>
                                                                        </select>
                                                                </div>
                                                                <div class="sub-title">是否毕业</div>
                                                                <div>
                                                                    <div>
                                                                          <div class="radio3 radio-check radio-success radio-inline">
                                                                            <input type="radio" id="newGraduated1" name="newGraduated" value="" checked="">
                                                                            <label for="newGraduated1">
                                                                              	是
                                                                            </label>
                                                                          </div>
                                                                          <div class="radio3 radio-check radio-success radio-inline">
                                                                            <input type="radio" id="newGraduated2" name="newGraduated" value="">
                                                                            <label for="newGraduated2">
                                                                              	否
                                                                            </label>
                                                                          </div>
                                                                    </div>
                                                                </div>
                                                                <div class="">
                                                                    <button type="button" class="buttoner">添加</button>
                                                                </div>
                                                        </div>
                                                        </div>
                                                    </div>

                                                    <div class="tab-pane fade" id="delMember">
                                                        <div class="sub-title">请在上面的表格中搜索到你想删除的人员，点击查询即可，暂不支持批量删除</div>
                                                        <div>

                                                        </div>
                                                        <div class="">
                                                            <button type="button" class="buttoner" id="delMemberInfo" style="margin-top:5px;">删除</button>
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

                                                    <a href="#" class="list-group-item">
                                                        <span class="badge">2016-01-01</span>
                                                        <i class="fa fa-fw fa-edit"></i>nisal 修改了 15401190219
                                                    </a>
                                                    <a href="#" class="list-group-item">
                                                        <span class="badge">2016-01-01</span>
                                                        <i class="fa fa-fw fa-edit"></i>nisal 删除了 15401190219
                                                    </a>
                                                    <a href="#" class="list-group-item">
                                                        <span class="badge">2016-01-01</span>
                                                        <i class="fa fa-fw fa-edit"></i>nisal 添加了 15401190219
                                                    </a>
                                                    <a href="#" class="list-group-item">
                                                        <span class="badge">2016-01-01</span>
                                                        <i class="fa fa-fw fa-edit"></i>nisal 删除了 15401190219
                                                    </a>
                                                    <a href="#" class="list-group-item">
                                                        <span class="badge">2016-01-01</span>
                                                        <i class="fa fa-fw fa-edit"></i>nisal 删除了 15401190219
                                                    </a>
                                                    <a href="#" class="list-group-item">
                                                        <span class="badge">2016-01-01</span>
                                                        <i class="fa fa-fw fa-edit"></i>nisal 删除了 15401190219
                                                    </a>
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

   <script type="text/javascript" src="js/labMemberCus.js"></script>
   <script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>

</body>
</html>
