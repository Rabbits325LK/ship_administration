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
				JAVA<small>API 请求帮助文档&nbsp;&nbsp;&nbsp;&nbsp; <a
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
						<strong>帮助文档说明</strong>
					</h3>
				</div>
				<div class="panel-body">Http发送请求,取回值</div>
				<div class="page-header">
					<h3 class="panel-title">
						<strong>API Http 请求</strong>
					</h3>
				</div>
				<div class="panel-body">
					<dl>
						<dt>创建工具类：HttpRequestUtil</dt>
						<dd class="well">static boolean proxySet = false; static
							String proxyHost = "127.0.0.1"; static int proxyPort = 8080;</dd>

						<dt>定义方法</dt>
						<dd class="well">
							public static String urlEncode(String source, String encode) {
							String result = source; try { result =
							java.net.URLEncoder.encode(source, encode); } catch
							(UnsupportedEncodingException e) { // TODO Auto-generated catch
							block e.printStackTrace(); return "0"; } return result; } <br>
							<br> public static String httpRequest(String req_url){
							StringBuffer buffer = new StringBuffer(); try { URL url = new
							URL(req_url); HttpURLConnection httpUrlConn = (HttpURLConnection)
							url.openConnection(); httpUrlConn.setDoOutput(false); //输出设置
							httpUrlConn.setDoInput(true); //输入设置
							httpUrlConn.setUseCaches(false); //缓存设置
							httpUrlConn.setRequestMethod("GET"); //请求方法设置
							httpUrlConn.connect(); //链接 //将返回的输入流转换成字符串 InputStream
							inputStream = httpUrlConn.getInputStream(); InputStreamReader
							inputStreamReader = new InputStreamReader(inputStream, "utf-8");
							BufferedReader bufferedReader = new
							BufferedReader(inputStreamReader); String str = null; while((str
							= bufferedReader.readLine()) != null){ buffer.append(str); }
							bufferedReader.close(); inputStreamReader.close();
							inputStream.close(); inputStream = null;
							httpUrlConn.disconnect(); } catch (Exception e) { // TODO: handle
							exception System.out.println(e.getStackTrace()); } return
							buffer.toString(); } <br>
							<br> public static InputStream httpRequestIO(String
							requestUrl) { InputStream inputStream = null; try { URL url = new
							URL(requestUrl); HttpURLConnection httpUrlConn =
							(HttpURLConnection) url.openConnection();
							httpUrlConn.setDoInput(true);
							httpUrlConn.setRequestMethod("GET"); httpUrlConn.connect();
							//获得返回的输入流 inputStream = httpUrlConn.getInputStream(); } catch
							(Exception e) { // TODO: handle exception e.printStackTrace(); }
							return inputStream; } <br>
							<br> public static String sendGet(String url, String param)
							{ String result = ""; BufferedReader in = null; try { String
							urlNameString = url + "?" +param; URL realUrl = new
							URL(urlNameString); //打开和URL之间的连接 URLConnection connection =
							realUrl.openConnection(); //设置通用的请求属性
							connection.setRequestProperty("accept","*/*");
							connection.setRequestProperty("connection", "Keep-Alive");
							connection.setRequestProperty("user-agent", "Mozilla/4.0
							(compatible; MSIE 6.0; Windows NT 5.1;SV1"); //建立实际的连接
							connection.connect(); //获取所有响应头字段 Map &lt;String,List
							&lt;String&gt;&gt; map = connection.getHeaderFields();
							//遍历所有的响应头字段 for(String key : map.keySet()) {
							System.out.println(key + "----&gt;" +map.get(key)); } //定义
							BufferedReader输入流来读取URL的响应 in = new BufferedReader(new
							InputStreamReader(connection.getInputStream())); String line;
							while((line = in.readLine()) != null){ result += line; } } catch
							(Exception e) { // TODO: handle exception
							System.out.println("发送GET请求出现异常！"+e); e.printStackTrace(); }
							finally { try { if (in != null){ in.close(); } } catch (Exception
							e2) { // TODO: handle exception e2.printStackTrace(); } } return
							result; } <br>
							<br> public static String sendPost(String url, String
							param,boolean isproxy) { OutputStreamWriter out = null;
							BufferedReader in = null; String result = ""; try { URL realUrl =
							new URL(url); HttpURLConnection conn = null; if(isproxy){//使用代理模式
							@SuppressWarnings("static-access") Proxy proxy = new
							Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost,
							proxyPort)); conn = (HttpURLConnection)
							realUrl.openConnection(proxy); }else{ conn = (HttpURLConnection)
							realUrl.openConnection(); } // 打开和URL之间的连接 // 发送POST请求必须设置如下两行
							conn.setDoOutput(true); conn.setDoInput(true);
							conn.setRequestMethod("POST"); // POST方法 // 设置通用的请求属性

							conn.setRequestProperty("accept", "*/*");
							conn.setRequestProperty("connection", "Keep-Alive");
							conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;
							MSIE 6.0; Windows NT 5.1;SV1)");
							conn.setRequestProperty("Content-Type",
							"application/x-www-form-urlencoded"); conn.connect(); //
							获取URLConnection对象对应的输出流 out = new
							OutputStreamWriter(conn.getOutputStream(), "UTF-8"); // 发送请求参数
							out.write(param); // flush输出流的缓冲 out.flush(); //
							定义BufferedReader输入流来读取URL的响应 in = new BufferedReader( new
							InputStreamReader(conn.getInputStream())); String line; while
							((line = in.readLine()) != null) { result += line; } } catch
							(Exception e) { System.out.println("发送 POST 请求出现异常！"+e);
							e.printStackTrace(); } //使用finally块来关闭输出流、输入流 finally{ try{
							if(out!=null){ out.close(); } if(in!=null){ in.close(); } }
							catch(IOException ex){ ex.printStackTrace(); } } return result; }
						</dd>
						<br>
						<dt>测试调用:</dt>
						<dd class="well">public class HttpTest { public static void
							main(String[] args) { String url =
							"http://localhost:8080/ship_administration/APIuser/UpdateUserInfo.do";
							String param = "userId=2&address=湖南省-天心区-通用时代国际社区-12栋-402房";
							System.out.println(HttpRequestUtil.sendPost(url, param, false));
							} }</dd>
						<br>
						<dt>参数:<dd class="well">{result:success}</dd></dt>

					</dl>
				</div>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
		</div>
	</div>
</body>
</html>
