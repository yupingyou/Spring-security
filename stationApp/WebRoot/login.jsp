<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>兴国充电桩运营管理系统</title>
	</head>
	<link rel="shortcut icon" href="img/16.ico" type="image/x-icon"/>
	<!--bootshrapCSS-->
	<link rel="stylesheet" href="css/bootstrap.css"/>
	<link rel="stylesheet" href="css/common/common.css"/>
	<link rel="stylesheet" href="css/common/bootstrapfiller.css"/>
	<!--jQery加载-->
	<script src="js/jquery.js"></script>
	<!--bootshrap基础JS-->
	<script src="js/bootstrap.js"></script>
	<style>
		body{background:url(img/home/login.jpg) no-repeat;background-size: cover; background-attachment: fixed;}
		/*.logo{ position: absolute; top: 50px; left: 56px;}
		.logo{}*/
		.main{position: absolute; top: 0; left: 0; right: 0; bottom: 0; margin: auto; width: 540px; height: 345px; overflow: hidden; background: rgba(255,255,255,0.8); border-radius: 10px;}
		.main .title{width: 100%; height: 70px; text-align: center; background: #cc161e;
					background: -webkit-linear-gradient(#059474, #2daf8b);
					background: -moz-linear-gradient(#059474, #2daf8b);
					background: -o-linear-gradient(#059474, #2daf8b);
					background: -webkit-gradient(linear, 0 0, 0 100%, from(#059474), to(#2daf8b));
					background: linear-gradient(#059474, #2daf8b); /* Safari 5.1 - 6.0 */
 		}
		.main .title .title_font{ line-height: 70px; font-size: 24px; color: #fff; font-family: "微软雅黑";}
		.main .text {position: relative; width: 100%; padding-top:45px ; height: calc(100% - 70px); }
		.main .text .box{position: relative;left: 0; top: 0; right: 0 ; bottom: 0;  margin:auto; width: 80%; text-align: center;}
		.main .text .box .input-group{margin-bottom: 20px;}
		.main .text .box .input-group .input-group-addon { background-color: #fff; border-right: 0;}
		.main .text .box .btn {width: 110px;}
		.glyphicon{top: 0;}
	</style>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript">
		function validata(){
			var flag=true;
			if(!$("input[name=loginName]").val()){
				xtip("用户名不能为空！");
				flag=false;
			}
			if(!$("input[name=password]").val()){
				xtip("密码不能为空！");
				flag=false;
			}
			return flag;
		}
		function login(){
			var flag=validata();
			if(flag){
				$.ajax({
					type:"post",
					url:'<s:url action="login" namespace=""/>',
					data:$("form").serializeObject(),
					dataType:"json",
					success:function(data){
						if(data.status==0){
							location.href="index.jsp";
						}else{
							xalert(data.msg);
						}
					},
					error:function(data){
						xerror(data.responseText);
					}
				});
			}
		}
		$(function(){
			$("html").keyup(function(e){
				e=e||window.event;
		        if(e.keyCode==13){
		            $("#loginForm a").trigger("click");
		        }
			});
			$("#loginForm").on("click","a",function(){
				login();
			});
		});
		
	</script>
	<body>
		<!--<div class="logo">
			<span class="logo_font">充电桩管理系统<span class="logo_eng">Charging management system</span></span>
		</div>-->
		<div class="main">
			<div class="title">
				<span class="title_font">充电桩运营管理系统</span>
			</div>
			<div class="text">
				<form id="loginForm">
					<div class="box">
						<div class="input-group input-group-lg">
					      <span class="input-group-addon glyphicon glyphicon-user"></span>
					      <input name="loginName" class="form-control" autofocus="autofocus"  type="text" placeholder="请输入用户名">
					    </div>
					    <div class="input-group input-group-lg">
					      <span class="input-group-addon glyphicon glyphicon-lock"></span>
					      <input name="password" class="form-control" type="password" placeholder="Password">
					    </div>
					    <a class="btn btn-success btn-lg">GO</a>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>

