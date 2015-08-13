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
				游艇信息列表 <small>API 接口&nbsp;&nbsp;&nbsp;&nbsp; <a
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
				<div class="panel-body">查选数据库内已有的游艇信息</div>


				<div class="page-header">
					<h3 class="panel-title">
						<strong>API Http 请求</strong>
					</h3>
				</div>
				<div class="panel-body">
					<dl>
						<dt>无参:</dt>
						<dd class="well"><%=basePath%>APIship/QueryShipInfoList.do
						</dd>

						<dt>带参:</dt>
						<dd class="well">无</dd>
						<br />
						<dt>返回JSON格式数据:</dt>
						<dd class="well">
							{"totalCount":14,"ships":[{"shipId":1,"shipName":"荣超地产","shipType":"游艇","shipSize":"60","shipCapacity":"14","shipImages":null},{"shipId":2,"shipName":"双湾游艇","shipType":"游艇","shipSize":"55","shipCapacity":"14","shipImages":null},{"shipId":3,"shipName":"大梅沙1号","shipType":"帆船","shipSize":"42","shipCapacity":"10","shipImages":null},{"shipId":4,"shipName":"大梅沙2号","shipType":"帆船","shipSize":"37","shipCapacity":"8","shipImages":null},{"shipId":5,"shipName":"大梅沙3号","shipType":"帆船","shipSize":"14","shipCapacity":"4","shipImages":null},{"shipId":6,"shipName":"大梅沙4号","shipType":"帆船","shipSize":"14","shipCapacity":"4","shipImages":null},{"shipId":7,"shipName":"广田","shipType":"游艇","shipSize":"68","shipCapacity":"16","shipImages":null},{"shipId":8,"shipName":"55号","shipType":"帆船","shipSize":"55","shipCapacity":"12","shipImages":null},{"shipId":9,"shipName":"KING","shipType":"帆船","shipSize":"60","shipCapacity":"14","shipImages":null},{"shipId":10,"shipName":"梅沙6号","shipType":"游艇","shipSize":"43","shipCapacity":"10","shipImages":null},{"shipId":11,"shipName":"华为号","shipType":"游艇","shipSize":"80","shipCapacity":"24","shipImages":null},{"shipId":12,"shipName":"荣超快艇","shipType":"摩托艇","shipSize":"4","shipCapacity":"2","shipImages":null},{"shipId":13,"shipName":"渔人码头快艇","shipType":"快艇","shipSize":"12","shipCapacity":"5","shipImages":null},{"shipId":19,"shipName":"山河智能","shipType":"游艇","shipSize":"43","shipCapacity":"8","shipImages":null}]}
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
								<td>输出</td>
								<td>totalCount</td>
								<td>int</td>
								<td></td>
								<td>总条数</td>
							</tr>
							<tr>
								<td>输出</td>
								<td>ships</td>
								<td>Object合集</td>
								<td></td>
								<td>shipInfo类，具体查看shipInfo详细查询介绍</td>
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
