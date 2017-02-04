<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%@ page import="org.slf4j.Logger"%>

<%
	Throwable ex = null;
	if (exception != null) {
		ex = exception;
    }
	if (request.getAttribute("javax.servlet.error.exception") != null) {
		ex = (Exception) request.getAttribute("javax.servlet.error.exception");
    }

	//记录日志
	Logger logger = LoggerFactory.getLogger("500.jsp");
	logger.error(ex.getMessage(), ex);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>500 - 系统内部错误</title>
    <link href="<c:url value="/css/admin_index.css"/>" rel="stylesheet" type="text/css" />
</head>

<body>
<style>
	.error_content{width:770px;height:395px;text-align: center;color: #eaeaea;}
	.e_mian{height:50%;font-size:10em;line-height:150%;text-shadow: -1px -1px 0 #fff,1px 1px 0 #333,1px 1px 0 #444;-webkit-box-reflect:below -70px -webkit-linear-gradient(transparent,transparent 10%,rgba(255,255,255,.3));}
	.e_dec{height:50%;line-height:250px;color:#bbb;font-weight: 700;}
</style>
		
<div class="error_content">
	<div class="e_mian">500</div>
	<div class="e_dec">系统内部出Bug啦，请联系管理员</div>
</div>
</body>
</html>
