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
				查看申请预订信息列表<small>API Interface&nbsp;&nbsp;&nbsp;&nbsp; <a
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
				<div class="panel-body">
					查看申请预订信息列表 <br>*传入参数state long型<br>0:全部<br>1:申请<br>2:已受理<br>3:已执行<br>4:作废
				</div>


				<div class="page-header">
					<h3 class="panel-title">
						<strong>API Http 请求</strong>
					</h3>
				</div>
				<div class="panel-body">
					<dl>
						<dt>无参:</dt>
						<dd class="well">无</dd>

						<dt>带参:</dt>
						<dd class="well"><%=basePath%>APIship/QueryOrderInfoList.do?state=状态编号
						</dd>
						<br />
						<dt>返回JSON格式数据:</dt>
						<dd class="well">
							{"totalCount":3,"shipOperations":[{"shipOperationCode":1,"shipId":1,"userId":1,"shipState":3,"stratime":1439430180000,"endtime":1439440920000},{"shipOperationCode":2,"shipId":1,"userId":1,"shipState":4,"stratime":1439340180000,"endtime":1439347320000},{"shipOperationCode":3,"shipId":1,"userId":1,"shipState":2,"stratime":1439803200000,"endtime":1439814000000}]}
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
								<td>state</td>
								<td>long</td>
								<td><font color="green"><span
										class="glyphicon glyphicon-ok"></span></font></td>
								<td>状态编号<br>0:全部<br>1:申请<br>2:已受理<br>3:已执行<br>4:作废</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>pageCurrent</td>
								<td>Int</td>
								<td></td>
								<td>总条数</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>shipOperations</td>
								<td>Object合集</td>
								<td></td>
								<td>shipOperation类的合集</td>
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