<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ES | 项目时间轴</title>
<link rel="icon" href="images/icon.png" sizes="512x512">
<link rel="stylesheet" type="text/css" href="css/timeline.css">

</head>
<body>
<c:forEach items="${ManageProjectInfo}" var="logInfo">
	<c:if test="${logInfo.status!=-1}">
	<div class="content">
	<div id="proName" style="color:#000; font-size: 26px;">
		${logInfo.project.projectName}
	</div>
	<article>
		<h3><fmt:formatDate value="${logInfo.modifyDate}" pattern="yyyy"/></h3>
		
		<section class="mouseHover">
			<span class="point-time point-yellow"></span>
			<time datetime="2013-03">
				<span><fmt:formatDate value="${logInfo.modifyDate}" pattern="MM月dd日"/></span>
				<span><fmt:formatDate value="${logInfo.modifyDate}" pattern="yyyy"/></span>
			</time>
			<aside>
				<p class="things">${logInfo.logtxt}</p>
				<p class="brief">
					<span class="text-yellow">${logInfo.commonUserInfo.loginName}</span>
					<span class="delMenu">
						<a href="${pageContext.request.contextPath}/historyTimeLine.html?type=delete&manageProjectId=${logInfo.manageProjectID}&projectId=${logInfo.projectID}">删除</a>
					</span>
				</p>
			</aside>
		</section>
		
	</article>
</div>
</c:if>
</c:forEach>
</body>
</html>
