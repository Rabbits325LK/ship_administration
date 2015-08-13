<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'defaultModel.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="./css/font-awesome.min.css">
<link rel="stylesheet" href="./css/buttons.css">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/CSQKtable.js"></script>
<script src="./js/buttons.js"></script>
</head>

<body>
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="page-header">
			<h1 class="text-center">
				用户信息列表(分页) <small>API 接口&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=basePath%>API_Document.jsp" class="btn btn-success">come
						back</a>
				</small>
			</h1>
		</div>

		<div class="row">
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
			<div
				class="panel panel-primary col-lg-10 col-md-10 col-sm-10 col-xs-10">
				<div class="page-header">
					<h3 class="panel-title">
						<strong>接口说明</strong>
					</h3>
				</div>
				<div class="panel-body">查选数据库内已有的用户信息，分页导出列表。默认起始页为1，每页10条数据。
				</div>


				<div class="page-header">
					<h3 class="panel-title">
						<strong>API Http 请求</strong>
					</h3>
				</div>
				<div class="panel-body">
					<dl>
						<dt>无参:</dt>
						<dd class="well">无
						</dd>

						<dt>带参:</dt>
						<dd class="well"><%=basePath%>APIuser/QueryUserInfoList.do?roleId=角色编号
						</dd>
						<br />
						<dt>返回JSON格式数据:</dt>
						<dd class="well">
							{"totalCount":2,"userInfos":[{"userId":1,"roleId":1,"userName":"rabbits325","userPwd":"lk5115702","nickName":"梁慷","gender":1,"userIdcard":null,"address":"天心区","email":"rabbits325@live.cn","tel":"07315115702","phone":"18676660220","qq":"464020173","userImages":null},{"userId":2,"roleId":2,"userName":"testuser","userPwd":"lk5115702","nickName":"测试帐号","gender":1,"userIdcard":"430103199002253016","address":"湖南省天心区金盆岭通用时代国际社区12栋402房","email":"rabbits325@live.cn","tel":"073185115702","phone":"18676660220","qq":"464020173","userImages":null}]}
						</dd>
						<br />
						<dt>参数:</dt>
						<table class="table table-bordered">
							<tr>
								<th>Intput/Output</th>
								<th>column</th>
								<th>type</th>
								<th>Required</th>
								<th>annotation</th>
							</tr>
							<tr>
								<td>输入</td>
								<td>roleId</td>
								<td>long</td>
								<td><font color="green"><span class="glyphicon glyphicon-ok"></span></font></td>
								<td>角色编号，0为查询全部</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>totalCount</td>
								<td>int</td>
								<td></td>
								<td>总条数</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>userInfos</td>
								<td>Object合集</td>
								<td></td>
								<td>userInfo类，具体查看userInfo详细查询介绍</td>
							</tr>
						</table>


					</dl>
				</div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
		</div>

	</div>
</body>
</html>
