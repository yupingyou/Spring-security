<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<meta name="Keywords" content="关键词,关键词,关键词">
		<meta name="description" content="">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<!--网页宽度默认等于屏幕宽度（width=device-width），原始缩放比例（initial-scale=1）为1.0，即网页初始大小占屏幕面积的100%。-->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta name="viewport" content="initial-scale = 1.0,maximum-scale = 1.0">
		<title>充电站运营管理系统</title>
		<!--bootstrap css-->
		<link rel="shortcut icon" href="img/16.ico" type="image/x-icon"/>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/common/bootstrapfiller.css" />
		<link rel="stylesheet" href="css/common/common.css" />
		<!--iconfont-->
		<link rel="stylesheet" href="fonts/iconfont.css" />
		<!--zTree-->
		<link rel="stylesheet" href="css/zTree/zTreeStyle.css" />
		<!--jquery包-->
		<script type="text/javascript" src="js/jquery.js" ></script>
		<!--bootstrap包-->
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<!--echarts	 图表-->
		<script type="text/javascript" src="js/echarts.js" ></script>
		<!--时间插件-->
		<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
		<script type="text/javascript" src="js/moment-with-locales.js" ></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js" ></script>
		<!--zTree-->
		<script type="text/javascript" src="js/zTree/jquery.ztree.core.js" ></script>
		<script type="text/javascript" src="js/zTree/jquery.ztree.excheck.js" ></script>
		<!--公共业务方法-->
		<script type="text/javascript" src="js/common.js" ></script>
	</head>
	<style>
		body{position: absolute; width: 100%; height: 100%; background-color: #eeeeee/*#f2f2f2*/;}
		/*头部*/
		.m_header{position: fixed; width: 100%; height: 9vh; overflow: hidden; background: linear-gradient(to left,#a8b486,#006f47  30%,#06765d);}
		
		.m_menu .iconfont{ font-size: 20px; color: #ff8816;}
		/*内容区*/
		.m_main{position: absolute;padding-top: 9vh; padding-left: 204px; width: 100%; height:100%;}
		
		/*菜单栏*/
		.m_menu{position: fixed; top: 0; bottom: 0; padding-top: 9vh; width: 205px; background: linear-gradient(to bottom,#18855e,#007048);}
		.m_menu >ul{max-height: 95%;overflow: auto;}
		.m_menu >ul li a{position:relative;display: inline-block; padding-left: 20px; width: 100%; height: 52px; line-height: 52px; color: #c7ceb0;border-left: 3px solid transparent;}
		.m_menu >ul li a .m_mark{position:absolute;z-index:1;right:10px;top:0;bottom:0;margin:auto;width: 20px;height: 20px;font-size: 12px;line-height: 20px;text-align: center;border-radius: 50%;}
		.m_menu >ul li a .m_mark:after{content:"";position:absolute;z-index:-1;right:0px;top:2px;bottom:0;margin:auto;width: 0px;height: 0px;border: transparent solid 10px ;border-top: rgba(0,0,0,0.5) solid 15px;border-bottom: none;}
		.m_menu >ul li a:hover{background-color: #025e3d;color:#ff7c00;}
		.m_menu >ul >li >a.action{border-left: 3px solid #ff7c00;background-color: #025e3d;color:#ff7c00;}
		.m_menu >ul >li >ul{display:none;}
		.m_menu >ul >li >ul >li >a{padding-left: 40px;background-color: #0b6847;}
		.m_menu >ul >li >ul >li >a.action{background-color: #025e3d;color:#ff7c00;}
		.m_menu >ul >li >ul >li >a.action{background-color: #025e3d;color:#ff7c00;}
		/*foot start*/
		.m_footmsg {height:40px;width:100%;position: fixed;bottom:0;overflow: hidden;z-index: 1;}
		.m_footmsg .msgbox{position: absolute;left:0px;}
		.m_footmsg .msgbox .msg{position:absolute;left:0;top:0;}
		.m_footmsg .msgbox .msg .msgA{font-size: 12px;width:375px;display: block;height: 40px;line-height: 40px;padding-right:15px;color:#333;background: rgba(255,255,255,0.8);border-radius: 20px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;}
		.m_footmsg .msgbox .msg .msgA:hover strong{font-size: 16px;}
		.m_footmsg .msgbox .msg .msgA .icon{height: 40px;width:40px;background: rgba(255,255,255,0.5);line-height: 40px;text-align: center;top:0;border-radius: 50%;}
		.m_footmsg .msgbox .msg .msgA strong{font-weight: 700;transition:font-size .3s ease-in-out;}
		/*end foot*/
		/*logo*/
		.logo_a {display: inline-block; padding-left: 4vh; line-height: 9vh;}
		.logo_a .logo_font{font-family: 'fzhz'; font-size: 3.6rem; color: #c7ceb0; }
		.logo_a .logo_eng{font-size: 2rem;}
		/*user 框*/
		.register{ width: 150px; height: 100%;}	
		.register .round{ float: left; width: 50px; height: 100%; line-height: 9vh;}	
		.register .round img{display: inline-block; border: 2px solid #FFF;}
		.register .username{position: relative; padding-left: 10px; float: left; height: 100%;}
		.register .username .name{display: inline-block; color: #fff; line-height: 9vh;}
		.register .username .name:after{content: "\25BC"; font-size: 12px;}
		.register .username > div:hover .userbox{ display: block;}
		.register .username .userbox{display: none; position: fixed; top: 9vh; right: 0; width: 240px; border: 1px solid #93ab7e; border-radius: 0 0 5px 5px; background-color: #fff;}
		.register .username .userbox .user_msg{position: relative; height: 90px; padding-left: 90px;}
		.register .username .userbox .user_msg img{display: inline-block; position: absolute; left: 10px; top: 0; bottom: 0; margin: auto 0; width: 65px; height: 65px;}
		.register .username .userbox .user_msg > ul{padding-top: 15px; color: #000;}
		.register .username .userbox > ul > li { height: 35px; background-color: #0E7D58;}
		.register .username .userbox > ul > li:last-child{padding: 0 5%;}
		.register .username .userbox > ul > li > a{ line-height: 35px; color: #fff; transition: color .3s ease;}
		.register .username .userbox .exit:hover { color: #c7ceb0;}
	</style>
	<body>
		<div class="m_main" id="m_cont"></div>
		<div class="m_menu">
			<ul>
				<li>
					<a  href="javascript:;" data-url="home/show.html"  title="首页"><i class="iconfont icon-home pr10"></i>首页</a>
				</li>
				<li>
					<a  href="javascript:;" data-url="monitor/monitor.html" title="充电桩监控"><i class="iconfont icon-monitor pr10"></i>充电桩监控</a>
				</li>
				<li>
					<a  href="javascript:;" title="营销管理"><i class="iconfont icon-marketing pr10"></i>营销管理<div class="m_mark fr">5</div></a>
					<ul >
						<li >
							<a  href="javascript:;" data-url="marketing/standingBook.html"  title="台账管理">台账管理</a>
						</li>
						<li >
							<a href="javascript:;" data-url="marketing/ruleSet.html" title="计费规则">计费规则</a>
						</li>
						<li >
							<a href="javascript:;" data-url="marketing/regulation.html" title="规则导入">规则导入</a>
						</li>
						<li >
							<a href="javascript:;" data-url="marketing/memberCenter.html" title="会员中心">会员中心</a>
						</li>
						<li >
							<a href="javascript:;" data-url="marketing/consumption.html" title="会员消费查询">会员消费查询</a>
						</li>
					</ul>					
				</li>
				<li >
					<a href="javascript:;" data-url="power/data.html" title="供电系统监控"><i class="iconfont icon-power pr10"></i>供电系统监控<div class="m_mark fr">2</div></a>
					<ul >
						<li >
							<a  href="javascript:;" data-url="power/data.html"  title="模拟量">模拟量</a>
						</li>
						<li >
							<a href="javascript:;" data-url="power/condition.html" title="状态量">状态量</a>
						</li>
					</ul>
				</li>
				<li >
					<a href="javascript:;"  title="故障中心"><i class="iconfont icon-malfunction pr10"></i>故障中心<div class="m_mark fr">5</div></a>
					<ul >
						<li >
							<a href="javascript:;" data-url="malfunction/realAlarm.html" title="实时告警">实时告警</a>
						</li>
						<li >
							<a href="javascript:;" data-url="malfunction/executeMechanic.html" title="执行维修工单">执行维修工单</a>
						</li>
						<li >
							<a href="javascript:;" data-url="malfunction/historyAlarm.html" title="历史告警">历史告警</a>
						</li>
						<li >
							<a href="javascript:;" data-url="malfunction/operationQuery.html" title="运维查询">运维查询</a>
						</li>
						<li >
							<a href="javascript:;" data-url="malfunction/executivesList.html" title="执行人员列表">执行人员列表</a>
						</li>
					</ul>					
				</li>
				<li >
					<a href="javascript:;"  title="系统管理"><i class="iconfont icon-system pr10"></i>系统管理<div class="m_mark fr">1</div></a>
					<ul >
						<li >
							<a href="javascript:;" data-url="system/organization.jsp" title="组织机构">组织机构</a>
						</li>
						<li >
							<a href="javascript:;" data-url="system/department.jsp" title="部门管理">部门管理</a>
						</li>
						<li >
							<a href="javascript:;" data-url="system/userManage.jsp" title="用户管理">用户管理</a>
						</li>
						<li >
							<a href="javascript:;" data-url="system/roleManage.jsp" title="角色管理">角色管理</a>
						</li>
						<li >
							<a href="javascript:;" data-url="system/menuconfiguration.jsp" title="菜单配置">菜单配置</a>
						</li>
						<li >
							<a href="javascript:;" data-url="system/common.jsp" title="通用管理">通用管理</a>
						</li>
					</ul>					
				</li>
				<!--<li>
					<a href="javascript:;" data-url="malfunction/executivesList.html" title="故障中心">
						<i class="iconfont icon-malfunction pr10"></i>
						故障中心
					</a>
				</li>-->
			</ul>
		</div>
		<div class="m_header">
			<a class="logo_a" href="index.html">
				<span class="logo_font">充电桩管理系统&nbsp;<span class="logo_eng">Charging&nbsp;management&nbsp;system</span></span>
			</a>
			<div class="register pull-right">
				<div class="round">
					<img src="img/home/user.jpg" class="img-circle img-responsive" />
				</div>
				<div class="username">
					<div>
						<a class="name" href="javascript:;">admin</a>
						<div class="userbox">
							<div class="user_msg">
								<img src="img/home/user.jpg" class="img-circle img-responsive" />
								<ul>
									<li>admin</li>
									<li>部门名称：研发部</li>
								</ul>
							</div>
							<ul>
								<li>
									<a class="exit pull-right" href="login.html">退出</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="m_footmsg">
			<ul class="msgbox">
				<li class="msg"><a class="msgA" href="javascript:;"><span class="glyphicon glyphicon-bell icon mr10"></span>紧急任务，请马上处理！<strong class="font text-warning">雅居乐中心</strong>有桩出现故障！！！</a></li>
				<li class="msg"><a class="msgA" href="javascript:;"><span class="glyphicon glyphicon-bell icon mr10"></span>紧急任务，请马上处理！<strong class="font text-warning">保利国际广场</strong>有桩出现故障！！！</a></li>
				<li class="msg"><a class="msgA" href="javascript:;"><span class="glyphicon glyphicon-bell icon mr10"></span>紧急任务，请马上处理！<strong class="font text-warning">桂林汽车站</strong>有桩出现故障！！！</a></li>
				<li class="msg"><a class="msgA" href="javascript:;"><span class="glyphicon glyphicon-bell icon mr10"></span>紧急任务，请马上处理！<strong class="font text-warning">雅居乐中心</strong>有桩出现故障！！！</a></li>
				<li class="msg"><a class="msgA" href="javascript:;"><span class="glyphicon glyphicon-bell icon mr10"></span>紧急任务，请马上处理！<strong class="font text-warning">丽江客运站</strong>有桩出现故障！！！</a></li>
				<li class="msg"><a class="msgA" href="javascript:;"><span class="glyphicon glyphicon-bell icon mr10"></span>紧急任务，请马上处理！<strong class="font text-warning">保利国际广场</strong>有桩出现故障！！！</a></li>
			</ul>
		</div>
		<div id="timelymsgbox"></div>
		<script>
			$(function(){
				//业务
				//交互
				var mainMenu={
					init:function(){
						//第一次进来默认点击跳转
						var $this = this;
						$(".m_menu a").each(function(index,dom){
							if($(dom).data()){
								$this.gotopag(dom);
								return false;
							}
						});
						this.pmenu();
						this.smenu();
						this.urlclick();
						this.initnum();
					},
					pmenu:function(){
						$(".m_menu >ul >li").click(function(){
							if($(this).find(">a").siblings().length>0){
								$(this).find(">a").toggleClass("action").end().siblings().find(">a").removeClass("action");
								$(this).find(">ul").slideToggle().end().siblings().find(">ul").slideUp();
							}
						});
					},
					smenu:function(){
						$(".m_menu >ul >li >ul >li").click(function(e){
							e.stopPropagation();
							$(this).find(">a").toggleClass("action").end().siblings().find(">a").removeClass("action");
						});
					},
					initnum:function(){
						var num;
						$(".m_menu >ul li a").each(function(){
							if($(this).siblings().length>0){
								num=$(this).siblings().find("li").length;
								$(this).find(".m_mark").html(num);
							}
						});
					},
					urlclick:function(){
						var $this=this;
						$(".m_menu a").click(function(){
							$this.gotopag(this);
						})
					},
					gotopag:function(dom){
						if($(dom).data("url")){
							var url="pag/"+$(dom).data("url");
							$("#m_cont").load(url);
						}
						return false;
					}
				}
				var xafootmsg={
					/*
					step：移动的顺畅程度有关，每帧移动的步长
					speed:消息运动的速度 毫秒为单位  默认45   1s =1000ms
					interval:消息循环的间隔
					*/
					init:function(step,speed,interval){
						var msgboxDom = document.querySelectorAll(".msgbox")[0];
						var msgDom = document.querySelectorAll(".msg");
						var targetDom = document.querySelector("#m_realtime");
						var msgwidth =msgDom[0].offsetWidth;
						var time;
						var totalwidth;
						var currposition;
						for(var i = 0 ,len = msgDom.length;i < len ;i++){
							var temp=(msgwidth+30)*i;
							msgDom[i].style.left=temp+"px";
							msgDom[i].onmouseenter=function(){
								clearInterval(time);
								currposition=this.parentElement.offsetLeft;
							}
							msgDom[i].onmouseleave=function(){
								start(currposition);
							}
							/*点击跳转*/
							msgDom[i].onclick=function(){
								$("#m_realtime").trigger("click"); 
							};
						}
						totalwidth=msgDom[msgDom.length-1].offsetLeft+msgwidth;
						start();
						function start(currposition){
							//初始化位置信息
							msgboxDom.style.left=currposition||window.innerWidth+"px";
							time=setInterval(function(){
								temp=msgboxDom.offsetLeft-step;
								msgboxDom.style.left=temp+"px";
								if(temp==-totalwidth-15){
									clearInterval(time);
									setTimeout(start,interval);
								}
							},speed || 45);
						}
					}
				}
				//即时消息弹框
				var timelymsg={
					zindex:0,//控制上下的显示效果zindex样式
					music:null,
					init:function(id,cont,time){//初始化方法
						this.template(id,cont);
						this.slidUp();
						this.close();
						this.find();
						this.setTime(time);
						this.drag();
						this.initmusic();
						this.playmusic();
					},
					initmusic:function(){
						this.music=new XaMusic();
						this.music.init();
						this.music.add([{src:"voice/dzjb.wav"}]);
					},
					playmusic:function(){
						this.music.play();
					},
					slidUp:function(){//显示
						$(".timelymsg").last().stop(true,true).animate({"bottom":0},300);
					},
					slidDown:function(){//关闭即时消息
						$(".timelymsg").first().stop(true,true).animate({"bottom":-200},300,function(){
							$(".timelymsg").first().remove();
						});
					},
					drag:function(){//拖拽效果
						var pthis =this;
						$(".timelymsg:last-child .dragmark").mousedown(function(e){
							var $this=this;
							var right=$(".timelymsg").outerWidth()-(e.pageX-$(this).offset().left);
							var bottom=$(".timelymsg").outerHeight()-(e.pageY-$(this).offset().top);
							$($this).closest(".timelymsg").css("z-index",++pthis.zindex);
							
							$(document).mousemove(function(e){
								$($this).closest(".timelymsg").css({"right":$("html body").innerWidth()-e.pageX-right,
								"bottom":$("html body").innerHeight()-e.pageY-bottom});
							});
							$(document).mouseup(function(){
								$(document).off("mousemove mouseup");
							})
						});
					},
					close:function(){//点击关闭
						$(".timelymsg .close").off("click");
						$(".timelymsg .close").click(function(){
							var box =$(this).closest(".timelymsg");
							box.animate({"bottom":-200},300,function(){
								box.remove();
							});
						});
					},
					find:function(){
						$(".timelymsg .findA").click(function(){
						$("#m_realtime").trigger("click"); 
						});
					},
					setTime:function(time){//设置多久时间关闭
						var $this = this;
						setTimeout(function(){
							$this.slidDown();
						},$this.getTime(time));
					},
					template:function(id,cont){//模板页面
						$('#'+id).append("<div class='timelymsg' style='position: fixed;bottom: -200px;right: 0;'>"+
						"	<div class='panel panel-primary mb0' style='border-color:#007247'>"+
						"	  <div class='panel-heading dragmark' style='cursor:move;background-color:#007247;border-color:#007247'>"+
						"	    <span class='panel-title fz14'>紧急消息</span>"+
						"	    <span class='close' style='color:#fff'>&times;</span>"+
						"	  </div>"+
						"	  <div class='panel-body'>"+
						"	   	<div class='findA' style='cursor:pointer;'><strong class='text-warning fz16 fw700'>"+cont+"</strong><span class='fz14'>有桩出现故障！！！</span></div>"+
						"	  </div>"+
						"	  <div class='panel-footer text-right pd0'>"+
						"	  		<a class='btn btn-link findA' href='javascript:;' style='color:#F87806'>查看</a>"+
						"	  </div>"+
						"	</div>"+
						"</div>");
					},
					getTime : function(time){/*一个接地气的方法   5s 5秒的意思   代表返回5000毫秒*/
						if(time<=0)return time;
						var str1=time.substring(0,time.length-1)*1;
						var str2=time.charAt(time.length-1);
						if (str2=="s"){
						    return str1*1000;
						}else if (str2=="m"){
							return str1*60*1000;
						}else if (str2=="h"){
							return str1*60*60*1000;
						}else if (str2=="d"){
						    return str1*24*60*60*1000;
						}else{
							alert("格式错误,调用格式为1s 2m 2h 返回单位为毫秒")
						}
					}
				};
				//业务
				//交互
				mainMenu.init();
				//子菜单
				xafootmsg.init(3,30,5000);
				//即时消息
				setTimeout(function(){
					timelymsg.init("timelymsgbox","雅居乐中心","30s");
					setTimeout(function(){
						timelymsg.init("timelymsgbox","保利国际广场","30s");
					},3000)
				},1000);
				});
		//公共样式
		var commcss={
			init:function(){
				this.subtool();//左侧滑动;
			},
			subtool:function(){
				$("#m_cont").on("click","#slidicon",function(){
					if($("#slidicon").hasClass("glyphicon-chevron-left")){//变图标
						//1.tittle:变图标
						//2.tittle:整体移动位置
						//3.contentbox:右侧padding-left移动位置
						//4.左侧 a改变宽度 显示tip
						//5.把图标想左推出
						$("#slidicon").removeClass("glyphicon-chevron-left").addClass("glyphicon-chevron-right");
						$("#monmenu").stop(true,true).animate({"width":50},300,function(){
							$("#options a").tooltip(); 
						});
						$(".contentbox").stop(true,true).animate({"padding-left":50},300);
						$("#pSubMenu").find("a").stop(true,true).animate({"width":50},300).find(".icon").show().stop(true,true).animate({"left":0},300);
					}else{
						$('#options a').tooltip('destroy');
						$(".contentbox").stop(true,true).animate({"padding-left":100},300);
						$("#slidicon").addClass("glyphicon-chevron-left").removeClass("glyphicon-chevron-right");
						$("#monmenu").stop(true,true).animate({"width":100},300);
						$("#pSubMenu a").stop(true,true).animate({"width":100},300).find(".icon").hide().stop(true,true).animate({"left":50},300);
					}
				});
				$("#m_cont").on("click","#options a",function(){
					//样式
					$("#options a").removeClass("action");
					$("#options i").removeClass("action");
					$(this).addClass("action");
					$(this).find("i").addClass("action");
					//收起来
					if($("#slidicon").hasClass("glyphicon-chevron-left")){
						$("#slidicon").removeClass("glyphicon-chevron-left").addClass("glyphicon-chevron-right");
						$("#monmenu").stop(true,true).animate({"width":50},300,function(){
							$("#options a").tooltip(); 
						});
						$(".contentbox").stop(true,true).animate({"padding-left":50},300);
						$("#pSubMenu").find("a").stop(true,true).animate({"width":50},300).find(".icon").show().stop(true,true).animate({"left":0},300);
					}
				});
			}
		}
		//公共js方法
		var commjs={
			init:function(){
				window.openpop=this.openpop;//打开窗口
				window.optsedit=this.optsedit;//进入编辑状态
				this.footPage();
			},
			openpop:function(domdiv){
				commjs.cancel();
				var optname = domdiv.classList[0];
				if(isEmpty(optname)){
					optname = $(domdiv).attr("class").split(" ")[0]
				}
				$("#"+optname).fadeIn();
				dom.center($("#"+optname+" >div")[0],"top");
				var mark=true;
				if(!$("#"+optname)[0].mark){
					xadrag.init({"dom":$("#"+optname+" >div")[0],proxyChild:0});
					$("#"+optname+" .f_close").click(function(){
						//关闭并重置表单
						$(this).closest(".xform").fadeOut();
						if($(this).closest(".xform").find(".f_cont").length>0){
							$(this).closest(".xform").find(".f_cont")[0].reset();
						}
					});
					$("#"+optname)[0].mark=mark;
				}
			},
			optsedit:function(domdiv,way){
				commjs.cancel();
				//进入编辑状态
				//1.表格选择框出现
				//2.确定和取消按钮组出现
				//3.分页数据隐藏
				var optname = $(domdiv).attr("class").split(" ")[0];
				//工具栏底部
				$(".btn-tool").find("."+optname).fadeIn();
				$("#ftpage").stop(true,true).animate({bottom:-50},300,function(){
					$(this).hide();
				});
				//表格
				$("#list tbody tr").css("cursor","pointer");
				$("#list").find(".tab-checkbox input[type='"+way+"']").fadeIn();
				//表格事件
				var mark=true;
				
				var tabledom={};
				if(!$("#list")[0].mark){
					$("#list tbody").on("click","tr .tab-checkbox input",function(e){
						e.stopPropagation();//取消冒泡
					});
					$("#list tbody").on("click","tr",function(){
						$(this).find(".tab-checkbox input").each(function(index,input){
							if($(input).css("display")!="none"){
								$(input).trigger("click");
								return false;
							}
						});
					});
					$(".btn-tool li button:last-child").click(function(){
						commjs.cancel();
					});
					$("#list")[0].mark=mark;
				}
			},
			cancel:function(){
				$("#list tbody tr").css("cursor","default");
				$(".tab-checkbox input").prop("checked", false).stop(true,true).fadeOut();
				$(".btn-tool li").hide();
				$("#ftpage").show().stop(true,true).animate({bottom:0},300);
			},
			footPage:function(){//分页交互效果footPage("#ftpage")
				//子点击
				$("#m_cont").on("click","#ftpage .leaf",function(){
					$(this).addClass("active").siblings().removeClass("active");
					if($("#ftpage .leaf").first().hasClass("active")){
						$("#ftpage .prev").addClass("disabled");
						$("#ftpage .start").addClass("invisible");
						$("#ftpage .next").removeClass("disabled");
						$("#ftpage .end").removeClass("invisible");
					}else if($("#ftpage .leaf").last().hasClass("active")){
						$("#ftpage .next").addClass("disabled");
						$("#ftpage .end").addClass("invisible");
						$("#ftpage .prev").removeClass("disabled");
						$("#ftpage .start").removeClass("invisible");
					}else{
						$("#ftpage .next").removeClass("disabled");
						$("#ftpage .end").removeClass("invisible");
						$("#ftpage .prev").removeClass("disabled");
						$("#ftpage .start").removeClass("invisible");
					}
					$("#ftpage .curr").html($(this).text());
				});
				//上一页 下一页
				$("#m_cont").on("click","#ftpage .prev",function(){
					var active=$("#ftpage .active");
					if(active.prev().text()!=$(this).text()){
						active.prev().trigger("click");
					}
				});
				$("#m_cont").on("click","#ftpage .next",function(){
					var active=$("#ftpage .active");
					if(active.next().text()!=$(this).text()){
						active.next().trigger("click");
					}
				});
				//首页和尾页
				$("#m_cont").on("click","#ftpage .start",function(){
					$("#ftpage .leaf").first().trigger("click");
				});
				$("#m_cont").on("click","#ftpage .end",function(){
					$("#ftpage .leaf").last().trigger("click");
				});
			}	
		}
		//表单图片上传
			fjs.init();
			//图片预览
			ximgshow();
		commcss.init();
		commjs.init();
		
		
		
		</script>
	</body>
</html>


