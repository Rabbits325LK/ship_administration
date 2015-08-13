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
				添加游艇信息 <small>API 接口&nbsp;&nbsp;&nbsp;&nbsp; <a
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
				<div class="panel-body">新增游艇信息，按帮助文档填入必填参数</div>


				<div class="page-header">
					<h3 class="panel-title">
						<strong>API Http 请求</strong>
					</h3>
				</div>
				<div class="panel-body">
					<dl>
						<dt>必带参:</dt>
						<dd class="well"><%=basePath%>APIship/AddShipInfo.do?shipName=游艇名称&shipTypeCode=类型编号
						</dd>

						<dt>带参:</dt>
						<dd class="well"><%=basePath%>APIship/AddShipInfo.do?shipName=游艇名称&shipTypeCode=类型编号&shipSize=尺寸&shipCapacity=载量&shipImages=图片路径
						</dd>
						<br />
						<dt>返回JSON格式数据:</dt>
						<dd class="well">{"result":"success"}</dd>
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
								<td>shipName</td>
								<td>String</td>
								<td><font color="green"><span
										class="glyphicon glyphicon-ok"></span></font></td>
								<td>船艇的名字</td>
							</tr>
							<tr>
								<td>输入</td>
								<td>shipTypeCode</td>
								<td>long</td>
								<td><font color="green"><span
										class="glyphicon glyphicon-ok"></span></font></td>
								<td>船艇类型编号(查看类型编号表对应填写)</td>
							</tr>
							<tr>
								<td>输入</td>
								<td>shipSize</td>
								<td>String</td>
								<td></td>
								<td>船艇的尺寸(英尺)</td>
							</tr>
							<tr>
								<td>输入</td>
								<td>shipCapacity</td>
								<td>String</td>
								<td></td>
								<td>船艇的载量(人)</td>
							</tr>
							<tr>
								<td>输入</td>
								<td>shipImages</td>
								<td>String</td>
								<td></td>
								<td>船艇图片地址</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>result</td>
								<td>String</td>
								<td></td>
								<td>"success":成功<br />"error":错误<br />"shipName:null":船名为空
								<br>"shipTypeCode:null":船艇类型编号为空<br/>"existing":船艇信息已存在
								</td>
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
