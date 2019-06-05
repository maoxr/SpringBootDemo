<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>统一异常处理</title>
</head>
<body>
	<h1>Error Handler</h1>
	<div>message: ${message}</div>
	<div>timestamp: ${(timestamp?string("yyyy-MM-dd HH:mm:ss"))!}</div>
	<div>status: ${status}</div>
	<div>error: ${error}</div>
	<div>path: ${path}</div>
	<div>customErrorMap: ${customErrorMap.errorMsg}</div>
	
	
</body>
</html>