<%@page import="com.easyshare.entity.Fund"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	List<Fund> funds= (List<Fund>)request.getSession().getAttribute("funds");
	//余额计算
	double balance=0;
	double outcome=0;
	//遍历交易数据
	for(Fund item: funds)
	{
		//针对已完成的交易
		if(item.getStatus()==0)
		{
			if(item.getFundType()==1)
			{
				//交易类型为收入
				balance+=item.getTransationSum();
			}else
			{
				//交易为支出
				outcome+=item.getTransationSum();
				balance-=item.getTransationSum();
			}
		}
	}
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>ES | 资金管理</title>
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
                    <a class="active-menu" href="${pageContext.request.contextPath}/money.html?type=money"><i class="fa fa-money"></i>资金管理</a>
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
                            资金管理 <small>你好 ${user.commonUserInfo.loginName}</small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="${pageContext.request.contextPath}">易享</a></li>
					  <li><a href="${pageContext.request.contextPath}/index.html?type=init">易享后台</a></li>
					  <li class="active">资金管理</li>
					</ol>

		</div>
		<div class="alert alert-danger" id="serMessage" style="margin-top: 35px;height: 30px; padding-top: 4px; margin-left:30px;margin-right:30px;">
			<strong>不行不行！</strong>请找到唯一项目再查询
		</div>
            <div id="page-inner">

                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                                                资金列表 <span>资金余额：</span><u> ¥<%=balance %></u>
                                         <span>历史消费：</span><u> ¥<%=outcome %></u>
                                    </div>
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                <thead>
                                                    <tr>
                                                        <th>交易编号</th>
                                                        <th>款项名称</th>
                                                        <th>交易类型</th>
                                                        <th>交易额度</th>
                                                        <th>资金余额</th>
                                                        <th>交易明细</th>
                                                        <th>交易时间</th>
                                                        <th>交易状态</th>
                                                        <th>交易人</th>
														<th>操作</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${funds}" var="fund">
                                                	<tr class="odd gradeX">
                                                        <td>${fund.fundID}</td>
                                                        <td>${fund.fundName}</td>
                                                        <c:choose>
                                                        	<c:when test="${fund.fundType==1}"><td>收入</td></c:when>
                                                        	<c:otherwise><td>支出</td></c:otherwise>
                                                        </c:choose>
                                                        <td>${fund.transationSum}</td>
                                                        <td class="center">${fund.balance}</td>
                                                        <td>${fund.transationDetail}</td>
                                                        <c:choose>
                                                        	<c:when test="${empty fund.transationDate}"><td class="center">未填写</td></c:when>
                                                        	<c:otherwise><td class="center">${fund.transationDate}</td></c:otherwise>
                                                        </c:choose>
                                                        <c:if test="${fund.status==0}"><td>已完成</td></c:if>
                                                        <c:if test="${fund.status==1}"><td>进行中</td></c:if>
                                                        <c:if test="${fund.status==-1}"><td>已取消</td></c:if>
                                                        <td>${fund.commonUserInfo.loginName}</td>
														<td><a href="${pageContext.request.contextPath}/money.html?type=delete&delFundID=${fund.fundID}" class="delOp">删除</a></td>
                                                    </tr>
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
                                                	资金操作管理
                                            </div>
                                            <div class="panel-body">
                                                <ul class="nav nav-tabs">
                                                    <li class="active"><a href="#addMoneyLog" data-toggle="tab">添加</a>
                                                    </li>
                                                    <li class=""><a href="#editMoneyLog" data-toggle="tab">修改</a>
                                                    </li>
                                                    <li class=""><a href="#delMoneyLog" data-toggle="tab">删除</a>
                                                    </li>
                                                </ul>

                                                <div class="tab-content">
                                                    <div class="tab-pane fade active in" id="addMoneyLog">
                                                        <div>
                                                        <form action="${pageContext.request.contextPath}/money.html?type=add" method="post">
                                                        	<div class="sub-title">款项名称</div>
                                                            <div>
                                                                <input name="newFundName" type="text" class="form-control inputSty" placeholder="款项名称">
                                                            </div>
                                                            <div class="sub-title">交易类型</div>
                                                            <div>
                                                                <div class="radio3 radio-check radio-success radio-inline">
                                                                    <input type="radio" id="changeType2" name="newFundType" value="1" checked="">
                                                                    <label for="changeType2">
                                                                          	收入
                                                                    </label>
                                                                </div>
                                                                <div class="radio3 radio-check radio-success radio-inline">
                                                                     <input type="radio" id="changeType1" name="newFundType" value="-1">
                                                                     <label for="changeType1">
                                                                          	支出
                                                                     </label>
                                                                </div>
                                                            </div>
                                                            <div class="sub-title">交易额度</div>
                                                            <div>
                                                                <input name="newTransationSum" type="text" class="form-control inputSty" placeholder="交易额度">
                                                            </div>
                                                            <div class="sub-title">交易明细</div>
                                                            <div>
                                                                <input name="newTransationDetail" type="text" class="form-control inputSty" placeholder="交易明细">
                                                            </div>
                                                            <div class="sub-title">交易时间</div>
                                                            <div>
                                                                <input name="newTransationDate" type="text" class="form-control inputSty" placeholder="交易时间" onClick="laydate({istime: true, format: 'YYYY-MM-DD'})">
                                                            </div>
                                                            <div class="sub-title">交易状态</div>
                                                            <div>
                                                            <select name="newtradeStatus" class="selectbox">
											                   		<optgroup label="交易状态">
											                   			<option value="1">进行中</option>
											                   			<option value="0">已完成</option>
											                   			<option value="-1">已删除</option>
											                   		</optgroup>
											                </select>
                                                            </div>
                                                            <div class="sub-title">交易人</div>
                                                            <div>
											                   	<select name="newTransationPerson" class="selectbox">
											                   		<optgroup label="人员姓名">
											                   			<c:forEach items="${AllCommonUserInfo}" var="AllCommUserInfo">
											                   				<option value="${AllCommUserInfo.commonID}">${AllCommUserInfo.loginName}</option>
											                   			</c:forEach>
											                   		</optgroup>
											                   	</select>
											                </div>
                                                            <div class="">
                                                                <button type="submit" class="buttoner">添加</button>
                                                            </div>
                                                    </form>
                                                    </div>
                                                    </div>
                                                    <div class="tab-pane fade" id="editMoneyLog">
                                                        <div class="sub-title">请在上面的表格中搜索到你想修改的交易项，点击查询即可</div>
                                                        <div>

                                                        </div>
                                                        <div class="">
                                                            <button type="button" class="buttoner" id="serMoneyLogInfo" style="margin-top:5px;">查询</button>
                                                        </div>

                                                        <div id="updateFream">
                                                            <div>
                                                            <form action="${pageContext.request.contextPath}/money.html?type=update" method="post">
                                                                <div class="sub-title">交易编号</div>
                                                                <div>
                                                                    <input id="tradeId" name="fundID" type="text" class="form-control inputSty" placeholder="交易编号" readonly="true">
                                                                </div>
                                                                <div class="sub-title">款项名称</div>
                                                                <div>
                                                                    <input id="tradeName" name="fundName" type="text" class="form-control inputSty" placeholder="款项名称">
                                                                </div>
                                                                <div class="sub-title">交易类型</div>
                                                                <div>
                                                                    <div>
                                                                          <div class="radio3 radio-check radio-success radio-inline">
                                                                            <input type="radio" id="newChangeType2" name="fundType" value="1" checked="">
                                                                            <label for="newChangeType2">
                                                                             	 收入
                                                                            </label>
                                                                          </div>
                                                                          <div class="radio3 radio-check radio-success radio-inline">
                                                                            <input type="radio" id="newChangeType1" name="fundType" value="-1">
                                                                            <label for="newChangeType1">
                                                                              	支出
                                                                            </label>
                                                                          </div>
                                                                    </div>
                                                                </div>
                                                                <div class="sub-title">交易额度</div>
                                                                <div>
                                                                    <input id="tradeSum" name="transationSum" type="text" class="form-control inputSty" placeholder="交易额度">
                                                                </div>
                                                                <div class="sub-title">交易明细</div>
                                                                <div>
                                                                    <input id="tradeDetail" name="transationDetail" type="text" class="form-control inputSty" placeholder="交易明细">
                                                                </div>
                                                                <div class="sub-title">交易时间</div>
                                                                <div>
                                                                    <input id="tradeDate" name="transationDate" type="text" class="form-control inputSty" placeholder="交易时间" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                                                                </div>
                                                                <div class="sub-title">交易状态</div>
                                                            	<div>
                                                            		<select name="tradeStatus" class="selectbox">
											                   			<optgroup label="交易状态">
											                   				<option value="1">进行中</option>
											                   				<option value="0">已完成</option>
											                   				<option value="-1">已删除</option>
											                   			</optgroup>
											                		</select>
                                                           		</div>
                                                                <div class="sub-title">交易人</div>
                                                                <div>
											                   	<select name="transationPerson" class="selectbox">
											                   		<optgroup label="人员姓名">
											                   			<c:forEach items="${AllCommonUserInfo}" var="AllCommUserInfo">
											                   				<option value="${AllCommUserInfo.commonID}">${AllCommUserInfo.loginName}</option>
											                   			</c:forEach>
											                   		</optgroup>
											                   	</select>
											                    </div>
                                                                <div class="">
                                                                    <button id="" type="submit" class="buttoner">添加</button>
                                                                </div>
                                                        </form>
                                                        </div>
                                                    </div>
                                                </div>



                                               <div class="tab-pane fade" id="delMoneyLog">
                                                        <div class="sub-title">请在上面的表格中搜索到你想删除的交易，点击查询即可，暂不支持批量删除</div>
                                                        <div>

                                                        </div>
                                                        <div class="">
                                                            <button type="button" class="buttoner" id="delMoneyLogInfo" style="margin-top:5px;">查询</button>
                                                        </div>

                                                        <div id="deleteFream">
                                                            <div>
                                                            <form action="${pageContext.request.contextPath}/money.html?type=delete" method="post">
                                                                <div class="sub-title">交易编号</div>
                                                                <div>
                                                                    <input id="delTradeId" name="delFundID" type="text" class="form-control inputSty" placeholder="交易编号" readonly="true">
                                                                </div>
                                                                <div class="sub-title">款项名称</div>
                                                                <div>
                                                                    <input id="delTradeName" type="text" class="form-control inputSty" placeholder="款项名称" readonly="true">
                                                                </div>
                                                                <div class="sub-title">交易额度</div>
                                                                <div>
                                                                    <input id="delTradeSum" type="text" class="form-control inputSty" placeholder="交易额度" readonly="true">
                                                                </div>
                                                                <div class="sub-title">交易明细</div>
                                                                <div>
                                                                    <input id="delTradeDetail" type="text" class="form-control inputSty" placeholder="交易明细" readonly="true">
                                                                </div>
                                                                <div class="sub-title">交易时间</div>
                                                                <div>
                                                                    <input id="delTradeDate" type="text" class="form-control inputSty" placeholder="交易时间" readonly="true">
                                                                </div>
                                                                <div class="">
                                                                    <button id="" type="submit" class="buttoner">删除</button>
                                                                </div>
                                                        </form>
                                                        </div>
                                                    </div>
                                                </div>


                                                    <!-- <div class="tab-pane fade" id="delMoneyLog">
                                                        <div class="sub-title">请在上面的表格中搜索到你想删除的交易，点击查询即可，暂不支持批量删除</div>
                                                        <div>

                                                        </div>
                                                        <div class="">
                                                            <button type="button" class="buttoner" id="delMoneyLog" style="margin-top:5px;">删除</button>
                                                        </div>

                                                    </div>-->

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
                                                    <c:forEach items="${funds}" var="fund">
                                                    	<c:if test="${fund.status!=-1}">

                                                    	</c:if>
                                                    	<a href="#" class="list-group-item">
                                                            <span class="badge">￥${fund.transationSum}</span>
                                                            <i class="fa fa-fw fa-edit"></i>${fund.transationDetail}
                                                            <c:if test="${fund.status==1}">，交易进行中</c:if>
                                                            <c:if test="${fund.status==0}">，交易已达成</c:if>
                                                            <c:if test="${fund.status==-1}">，交易已取消</c:if>
                                                            <c:if test="${fund.fundType==-1}">，收入：</c:if>
                                                            <c:if test="${fund.fundType==1}">，支出：</c:if>
                                                        </a>
                                                    </c:forEach>
                                                    </div>
                                                    <div class="text-right">
                                                        <a href="#">更多<i class="fa fa-arrow-circle-right"></i></a>
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
	 <script type="text/javascript" src="js/laydate.js"></script>
     <script type="text/javascript" src="js/moneyCus.js"></script>
     <script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>
	 <script type="text/javascript" src="js/laydate.js"></script>
</body>
</html>
