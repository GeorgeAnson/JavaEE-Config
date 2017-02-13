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
  <title>ES | 书籍管理</title>
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
  <!-- 页面起始 -->
  <div id="wrapper">
    <!-- 顶部导航 -->
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
        <!-- 个人下拉导航 -->
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
            <i class="fa fa-user fa-fw"  style="color:#000;"></i>
            <i class="fa fa-caret-down"  style="color:#000;"></i>
          </a>
          <ul class="dropdown-menu dropdown-user">
            <li><a href="#"><i class="fa fa-user fa-fw"></i>${user.commonUserInfo.loginName}</a></li>
            <li><a href="${pageContext.request.contextPath}/personalInfoUpdate.html?type=init"><i class="fa fa-gear fa-fw"></i>个人信息</a></li>
            <li class="divider"></li>
            <li><a href="${pageContext.request.contextPath}/logout.html?type=logout"><i class="fa fa-sign-out fa-fw"></i>退出</a></li>
          </ul>
        <!-- /.个人下拉导航 -->
        </li>
      </ul>
    </nav>
    <!-- /.顶部导航 -->
    <!-- 侧栏导航 -->
    <nav class="navbar-default navbar-side" role="navigation">
      <div class="sidebar-collapse">
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
    <!-- /. 侧栏导航  -->
    <div id="page-wrapper">
      <div class="header">
        <h1 class="page-header">
          书籍管理 <small>你好 ${user.commonUserInfo.loginName}</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}">易享</a></li>
          <li><a href="${pageContext.request.contextPath}/index.html?type=init">易享后台</a></li>
          <li class="active">书籍管理</li>
        </ol>
      </div>
      <div class="alert alert-danger" id="serMessage" style="margin-top: 35px;height: 30px; padding-top: 4px; margin-left:30px;margin-right:30px;">
        <strong>不行不行！</strong>请找到唯一项目再查询
      </div>
      <div id="page-inner">
        <!-- 管理表 -->
        <div class="panel panel-default">
          <div class="panel-heading">
            书籍列表
          </div>
          <div class="panel-body">
            <div class="table-responsive">
              <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                  <tr>
                    <th>书本编号</th>
                    <th>书本名称</th>
                    <th>书本作者</th>
                    <th>书本价格</th>
                    <th>出版社名</th>
                    <th>库存总量</th>
                    <th>库存余量</th>
                    <th>登记日期</th>
                    <th>书籍状态</th>
                    <th>书本操作</th>
                  </tr>
                </thead>

                <tbody>

                 <c:forEach items="${books}" var="book">
                	 <c:if test="${book.status!=-1}">
                	 <tr class="odd gradeX">
                    <td>${book.bookID}</td>
                    <td>${book.bookName}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>${book.publishCompany}</td>
                    <td class="center">${book.amount}</td>
                    <td>${book.remain}</td>
                    <td>${book.modifyDate}</td>

                    	<c:choose>
                    		<c:when test="${book.remain!=0}">
                    			<td>库存不空</td>
                    		</c:when>

                    		<c:otherwise>
                    			<td>库存已空</td>
                    		</c:otherwise>
                    	</c:choose>
                      <td><a href="${pageContext.request.contextPath}/books.html?type=delete&id=${book.bookID}" class="delOp">删除</a></td>
                  </tr>
                  </c:if>
                </c:forEach>

                </tbody>
              </table>
            </div>
          </div>
        </div>
        <!-- 管理表 -->

      <div class="row">
        <div class="col-md-6 col-sm-6" style="width: 100%;">
          <div class="panel panel-default">
            <div class="panel-heading">
              书籍操作管理
            </div>
            <div class="panel-body">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#addBooks" data-toggle="tab">添加</a>
              </li>
              <li class=""><a href="#editBooks" data-toggle="tab">修改</a>
              </li>
              <li class=""><a href="#browBook" data-toggle="tab">借书</a>
              </li>

            </ul>
            <div class="tab-content">
              <div class="tab-pane fade active in" id="addBooks">
              <form id="addBookForm" action="${pageContext.request.contextPath}/books.html?type=addbook" method="post">
                <div>
                  <div class="sub-title">本书名</div>
                    <div>
                      <input type="text" name="bookName" class="form-control inputSty" placeholder="本书名">
                    </div>
                    <div class="sub-title">本书作者</div>
                    <div>
                      <input type="text" name="author" class="form-control inputSty" placeholder="本书作者">
                    </div>
                    <div class="sub-title">本书价格</div>
                    <div>
                      <input type="text" name="price" class="form-control inputSty" placeholder="本书价格">
                    </div>
                     <div class="sub-title">本书出版社</div>
                    <div>
                      <input type="text" name="publishCompany" class="form-control inputSty" placeholder="本书出版社">
                    </div>
                     <div class="sub-title">本书库存数量</div>
                    <div>
                      <input type="text" name="amount" class="form-control inputSty" placeholder="本书库存数量">
                    </div>
                    <div class="sub-title">本书状态</div>
                    <div>
                    	<select name="status" class="selectbox">
                    		<optgroup label="书本状态">
                    			<option value="1">库存不空</option>
                    			<option value="0">库存已空</option>
                    		</optgroup>
                    	</select>
                    </div>
                    <button type="submit" class="buttoner">添加</button>
                  </div>
                </div>
                </form>

                <div class="tab-pane fade" id="editBooks">
                    <div class="sub-title">请在上面的表格中搜索到你想修改的书籍，点击查询即可</div>
                      <div>

                    </div>
                    <div class="">
                      <button type="button" class="buttoner" id="serBookInfo" style="margin-top:5px;">查询</button>
                    </div>

					<form id="updateForm" action="${pageContext.request.contextPath}/books.html?type=update" method="post">
                    <div id="updateFream">

                    <div>
                      <div class="sub-title">书本编号</div>
                      <div>
                        <input id="bookId" name="bookID" type="text" class="form-control inputSty" placeholder="书本编号" id="newEquiId" readonly="true">
                      </div>
                      <div class="sub-title">书本名称</div>
                      <div>
                        <input id="bookName" name="bookName" type="text" class="form-control inputSty" placeholder="书名">
                      </div>

                      <!-- bookAuthor -->
                       <div class="sub-title">书本作者</div>
                      <div>
                        <input id="bookAuthor" name="bookAuthor" type="text" class="form-control inputSty" placeholder="本书作者">
                      </div>
                      <!-- bookAuthor -->


                      <div class="sub-title">书本价格</div>
                      <div>
                        <input id="bookPrice" name="bookPrice" type="text" class="form-control inputSty" placeholder="书本价格【未知留空】">
                      </div>


                      <!-- publicshCompany -->
                      <div class="sub-title">出版社名</div>
                      <div>
                        <input id="bookPubCompany" name="bookPubCompany" type="text" class="form-control inputSty" placeholder="出版社名">
                      </div>
                      <!-- publishCompany -->

                      <div class="sub-title">库存总量</div>
                      <div>
                        <input id="bookAmount" name="bookAmount" type="text" class="form-control inputSty" placeholder="库存总量">
                      </div>
                      <div class="sub-title">库存余量</div>
                      <div>
                        <input id="bookNum" name="bookNum" type="text" class="form-control inputSty" placeholder="库存余量">
                      </div>


                      <!-- record date -->
                       <div class="sub-title">登记日期</div>
                      <div>
                        <input id="bookRecordDate" name="bookRecordDate" type="text" class="form-control inputSty" placeholder="登记日期" readonly="true">
                      </div>

                       <!-- record date -->
                      <div class="sub-title">书籍状态</div>
                      <div>
                        <input id="bookTags" name="bookStatus" type="text" class="form-control inputSty" placeholder="书籍状态" readonly="true">
                      </div>


                      <div class="">
                        <button type="submit" class="buttoner">提交修改</button>
                      </div>
                    </div>
                  </div>
                  </form>
                </div>

                <div class="tab-pane fade" id="browBook">
                  <div class="sub-title">请在上面的表格中搜索到你想借阅的书籍，点击我要借书即可，不支持批量借书。</div>
                  <div class="">
                    <button type="button" class="buttoner" id="serBrowBookInfo" style="margin-top:5px;">我要借书</button>
                  </div>
                  <form action="${pageContext.request.contextPath}/books.html?type=borrow" method="post">
                  <div id="bookBrowerInfo">
                    <hr>
                    <div class="sub-title">书本编号</div>
                    <div>
                      <input id="browBookId" name="bookID" type="text" class="form-control inputSty" placeholder="" readonly="true">
                    </div>
                    <div class="sub-title">书本名称</div>
                    <div>
                      <input id="browBookName" type="text" class="form-control inputSty" placeholder="" readonly="true">
                    </div>
                    <div class="sub-title">书本作者</div>
                    <div>
                      <input id="browBookAuthor" type="text" class="form-control inputSty" placeholder="" readonly="true">
                    </div>
                    <button type="submit" class="buttoner" id="" style="margin-top:30px;">确认</button>
                  </div>
                  </form>
                </div>

              </div>
            </div>
          </div>

          <!-- 我借的书表 -->
          <div class="panel panel-default">
            <div class="panel-heading">
              我借的书
            </div>
            <div class="panel-body">
              <div class="table-responsive">
                <table class="table table-hover" id="browBookInfo">
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
                      <th>书本操作</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${borrowedBooks}" var="borrowedBook">
                  	 <tr>
                  	 <td>${borrowedBook.manageBookID}</td>
                      <td>${borrowedBook.bookID}</td>
                      <td>${borrowedBook.book.bookName}</td>
                      <td>${borrowedBook.book.author}</td>
                      <td>${borrowedBook.book.price}</td>
                      <td>${borrowedBook.book.publishCompany}</td>
                      <td>${borrowedBook.borrowDate}</td>
                      <c:choose>
                      	<c:when test="${not empty borrowedBook.returnDate}">
                      		<td>${borrowedBook.returnDate}</td>
                      	</c:when>
                      	<c:otherwise>
                      		<td>尚未归还</td>
                      	</c:otherwise>
                      </c:choose>
                       <td><a href="${pageContext.request.contextPath}/books.html?type=return&id=${borrowedBook.manageBookID}" class="retBook">还书</a></td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        <!-- /.我借的书 -->
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


<script type="text/javascript" src="js/booksCus.js"></script>
<script type="text/javascript" src="js/jquery.bootstrap.min.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
    $(".retBook").click(function(){
      return confirm("确定要还书吗？");
    });
  });
</script>
</body>
</html>
