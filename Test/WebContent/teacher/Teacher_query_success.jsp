<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/Teacher_query_success.css" />

<body>
	<div id="navi">
		<div id='naviDiv'>
			<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>
				&nbsp;老师管理<span>&nbsp; 
				<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>
				&nbsp;<a href="<%=path%>/teacher/Teacher_query.action">老师列表</a> <span>&nbsp;
			
		</div>
	</div>
	
	<div id="tips">
		<div id="buttonGroup">
			<div class="button"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="<%=path%>/teacher/Teacher_add.jsp">添加教师</a>
			</div>
			<div class="button"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a>查找老师</a>
			</div>
		</div>
	</div>
	<div id="mainContainer">
		<!-- 从session中获取学生集合 -->

		<table class="default" width="100%">
			<col width="10%">
			<col width="20%">
			<col width="5%">
			<col width="20%">
			<col width="30%">
			<col width="15%">
			<tr class="title">
				<td>工号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>出生日期</td>
				<td>地址</td>
				<td>操作</td>
			</tr>

			<!-- 遍历开始 -->
			<s:iterator value="#session.teacher_list" var="tea">
				<tr class="list">
					<td><s:property value="#tea.tid" /></td>
					<td><a 	href="<%=path%>/teacher/Teacher_modify.action?tid=<s:property value="#tea.tid"/>">
						<s:property value="#tea.tname" /></a>
						</td>
								
					<td><s:property value="#tea.gender" /></td>
					<td><s:date name="#tea.birthday" format="yyyy年MM月dd日" /></td>
					<td><s:property value="#tea.address" /></td>
					<td><a href="<%=path%>/teacher/Teacher_delete.action?tid=<s:property value="#tea.tid"/>"
						onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
				</tr>
			</s:iterator>
			<!-- 遍历结束 -->
		</table>
	</div>
</body>
</html>