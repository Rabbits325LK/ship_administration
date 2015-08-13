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
				 查看用户信息 <small>API 接口&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="<%=basePath%>API_Document.jsp" class="btn btn-success">come
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
				<div class="panel-body">根据Id查看用户详细信息</div>
				<div class="page-header">
					<h3 class="panel-title">
						<strong>API Http 请求</strong>
					</h3>
				</div>
				<div class="panel-body">
					<dl>
						<dt>必带参:</dt>
						<dd class="well"><%=basePath%>APIuser/QueryUserInfo.do?userId=用户编号
						</dd>

						<dt>带参:</dt>
						<dd class="well"><%=basePath%>APIuser/QueryUserInfo.do?userId=用户编号
						</dd>
						<br />
						<dt>返回JSON格式数据:</dt>
						<dd class="well">
							{"result":"success","userInfo":{"userId":1,"roleId":1,"userName":"rabbits325","userPwd":"lk5115702","nickName":"梁慷","gender":1,"userIdcard":null,"address":"天心区","email":"rabbits325@live.cn","tel":"07315115702","phone":"18676660220","qq":"464020173","userImages":null}}
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
								<td>输入/输出</td>
								<td>userId</td>
								<td>long</td>
								<td><font color="green"><span
										class="glyphicon glyphicon-ok"></span></font></td>
								<td>用户的编号</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>roleId</td>
								<td>long</td>
								<td></td>
								<td>角色的编号</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>userName</td>
								<td>String</td>
								<td></td>
								<td>用户帐号</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>userPwd</td>
								<td>String</td>
								<td></td>
								<td>用户密码</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>nickName</td>
								<td>String</td>
								<td></td>
								<td>用户昵称</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>gender</td>
								<td>String</td>
								<td></td>
								<td>性别：1为男，0为女</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>userIdcard</td>
								<td>String</td>
								<td></td>
								<td>身份证号码</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>address</td>
								<td>String</td>
								<td></td>
								<td>地址</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>email</td>
								<td>String</td>
								<td></td>
								<td>邮箱</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>tel</td>
								<td>String</td>
								<td></td>
								<td>固话</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>phone</td>
								<td>String</td>
								<td></td>
								<td>手机</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>qq</td>
								<td>String</td>
								<td></td>
								<td>qq号码</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>userImages</td>
								<td>String</td>
								<td></td>
								<td>图片地址</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>result</td>
								<td>String</td>
								<td></td>
								<td>"no data":没有数据<br>"success":成功</td>
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
