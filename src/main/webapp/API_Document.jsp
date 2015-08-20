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

<title>My JSP 'API_Document.jsp' starting page</title>

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
				API接口文档说明 <small>API Interface Document</small>
			</h1>
		</div>
		<!-- 接口调用帮助文档 -->
		<div class="row">
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
			<div
				class="panel panel-info col-lg-10 col-md-10 col-sm-10 col-xs-10">
					<div class="page-header">
						<h3 class="panel-title">
							<strong>调用接口帮助案例</strong>
						</h3>
					</div>
					<div class="page-body" style="margin-bottom: 2%">
						<a href="<%=basePath %>help/javaApi.jsp" class="btn btn-success">Java 调用API 帮助文档</a>
						<a href="javascript:void(0)" class="btn btn-primary">Swfit 调用API 帮助文档</a>
						
					</div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
		</div>
		<!-- 游艇功能列表 -->
		<div class="row">
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
			<div
				class="panel panel-primary col-lg-10 col-md-10 col-sm-10 col-xs-10">
				<div class="page-header">
					<h3 class="panel-title">
						<strong>游艇类接口</strong>
					</h3>
				</div>
				<div class="panel-body">
					<a href="<%=basePath%>ship/QueryShipInfoPage.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						查询游艇信息列表(分页处理)</a> <a href="<%=basePath%>ship/QueryShipInfoList.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						查询游艇信息列表</a> <a href="<%=basePath%>ship/AddShipInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						添加游艇信息</a> <a href="<%=basePath%>ship/UpdateShipInfo.jsp"
						class="list-group-item"> <span
						class="glyphicon glyphicon-link"></span> 根据编号修改船艇信息
					</a> <a href="<%=basePath%>ship/DelShipInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						删除游艇信息</a> <a href="<%=basePath%>ship/QueryShipInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						根据ID查询游艇详细信息</a> <a href="<%=basePath%>ship/OrderShip.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						预订游艇</a><a href="<%=basePath%>ship/QueryOrderInfoList.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						查看申请预订信息列表</a> <a href="<%=basePath%>ship/PassOrderShipInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						预订受理通过</a> <a href="<%=basePath%>ship/UseOrderShipInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						预订受理执行</a> <a href="<%=basePath%>ship/InvalidOrderShipInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						预订受理作废</a> <a href="<%=basePath%>ship/AutoUseOrderShipInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						批量处理过期申请成功的订单判断为已执行组件</a> <a
						href="<%=basePath%>ship/AutoInvalidOrderShipInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						批量处理过期订单请求组件</a> <a href="<%=basePath%>ship/QueryShipTypeList.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						查询船艇类型列表</a> <a href="<%=basePath%>ship/QueryShipType.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						根据编号查询船艇类型</a> <a href="<%=basePath%>ship/UpdateShipType.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						根据编号修改船艇类型</a> <a href="<%=basePath%>ship/DeleteShipType.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						根据编号删除船艇类型</a>
				</div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
		</div>

		<!-- 用户功能列表 -->
		<div class="row">
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
			<div
				class="panel panel-danger col-lg-10 col-md-10 col-sm-10 col-xs-10">
				<div class="page-header">
					<h3 class="panel-title">
						<strong>用户类接口</strong>
					</h3>
				</div>
				<div class="panel-body">
					<a href="<%=basePath%>user/QueryUserInfoPage.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						查询所有用户（分页）</a> <a href="<%=basePath%>user/QueryUserInfoList.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						查询所有用户</a> <a href="<%=basePath%>user/QueryUserInfo.jsp"
						class="list-group-item"> <span
						class="glyphicon glyphicon-link"></span> 根据编号查询用户信息信息
					</a> <a href="<%=basePath%>user/AddUserInfo.jsp"
						class="list-group-item"> <span
						class="glyphicon glyphicon-link"></span> 新增用户
					</a> <a href="<%=basePath%>user/UpdateUserInfo.jsp"
						class="list-group-item"> <span
						class="glyphicon glyphicon-link"></span> 根据编号修改
					</a> <a href="<%=basePath%>user/LoginCheck.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						用户登录验证</a> <a href="<%=basePath%>user/QueryRoleInfoList.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						查询角色信息列表</a> <a href="<%=basePath%>user/QueryRoleInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						根据编号查询角色信息</a> <a href="<%=basePath%>user/AddRoleInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						添加新角色</a> <a href="<%=basePath%>user/UpdateRoleInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						修改角色信息</a> <a href="<%=basePath%>user/DelRoleInfo.jsp"
						class="list-group-item"><span class="glyphicon glyphicon-link"></span>
						删除角色信息</a>
				</div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
		</div>
	</div>

</body>
</html>
