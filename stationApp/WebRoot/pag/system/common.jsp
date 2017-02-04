<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>通用管理</title>
	</head>
	<style>
	
	</style>
	<body>
		<div class="module">
			<!--左侧工具栏 stars-->
			<div class="tool_left" id="monmenu">
				<div class="title"><a href="javascript:;"><span class="icon glyphicon glyphicon-chevron-left" id="slidicon"></span></a></div>
				<div class="tool" id="options">
					<ul class="toolp" id="pSubMenu">
						<li class="station"><a class="update" href="javascript:;" data-toggle="tooltip" data-trigger="hover" data-placement="right" title="修改通用密码" onclick="openpop(this)"><i class="icon glyphicon glyphicon-pencil"></i>修改通用密码</a></li>
						<li class="station"><a class="com_lock" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="锁定"><i class="icon iconfont icon-lock"></i>锁定</a></li>
						<li class="station"><a class="com_unlock" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="解锁"><i class="icon iconfont icon-lock_open"></i>解锁</a></li>
					</ul>
				</div>
			</div>
			<!--end 左侧工具栏-->
			<div class="contentbox">
				<div class="navBar navBar_bg">
					<div class="breadCrumb">
						<ol>
							<li title="系统管理">系统管理</li>
							<li title="通用管理">通用管理</li>
						</ol>
					</div>
				</div>
				<div class="main_box">
					<table class="table table-striped mtable-striped table-hover table_hide" id="list">
						<thead>
							<tr>
								<th class="tab-checkbox">
								<th>公用密码</th>
								<th>创建时间</th>
								<th>修改时间</th>
								<th>锁定状态</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>xin45213</td>
								<td>2015-10-05 11:13</td>
								<td>2016-08-12 16:14</td>
								<td><span class="normal">未锁定</span></td>
							</tr>
						</tbody>
						<!--分页 stars-->
						<tfoot>
							<tr>
								<td colspan="5">
									<div class="col-xs-12">
										<ul class="btn-tool">
											<!--锁定-->
											<li class="lock">
												<button  type="button" class="btn btn-warning" title="锁定" onclick="xconfirm('确定锁定选中用户？');">
													<span class="ico"><i class="iconfont icon-cg"></i></span><span class="iconchar">锁定</span>
												</button>
												<button  type="button" class="btn btn-default tool-cancel" title="取消">
													<span class="ico"><i class="iconfont icon-cw"></i></span><span class="iconchar">取消</span>
												</button>
											</li>
										</ul>
									</div>
								</td>
							</tr>
						</tfoot>
						<!--end 分页-->
					</table>
				</div>
			</div>
		</div>	
		<!--修改通用密码-->
		<div class="xform" id="update" >
			<div>
				<div class="f_haeder">
					<span>修改通用密码</span>
					<a class="f_close" href="javascript:;" title="关闭">
						<span></span>
					</a>
				</div>
				<form class="f_cont">
					<table >
						<tbody>
							<tr>
								<td>新密码</td>
								<td>
									<input name="password" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>确认新密码</td>
								<td>
									<input name="repassword" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="opts">
						<a id="save" class="btn btn-warning">确定</a>
					</div>
				</form>
			</div>
		</div>
		<script>
			$(function(){
				/**业务**/
				var bsn={
					loadData:function(){
						$.ajax({
							type:"post",
							url:'<s:url action="list" namespace="/sys/commom" />',
							data:{},
							dataType:"json",
							success:function(data){
								var tr='<tr>'+
									'<td class="ruleSet_td tab-checkbox">'+
										'<input type="checkbox" name="select" value="" />'+
									'</td>'+
									'<td>'+data.value+'</td>'+
									'<td>'+data.createDate+'</td>'+
									'<td>'+data.updateDate+'</td>';
									if(data.state=='0'){
										tr+='<td><span class="normal">未锁定</span></td>';
									}else{
										tr+='<td><span class="shut">已锁定</span></td>';
									}
								tr+='</tr>';
								$("#list tbody").html(tr);
							},
							error:function(data){
								xerror(data.responseText);
							}
						});
					},
					lock:function(){
						//锁定
						$("#options .com_lock").click(function(){
							xconfirm("确定锁定当前密码？",function(){
								$.ajax({
									type:"post",
									url:'<s:url action="lock" namespace="/sys/commom" />',
									data:{},
									dataType:"json",
									success:function(data){
										if(data.status==0){
											bsn.loadData();
										}
										xalert(data.msg);
									},
									error:function(data){
										xerror(data.responseText);										
									}
								});
							});
						});
					},
					unlock:function(){
						$("#options .com_unlock").click(function(){
							xconfirm("确定解锁当前密码？",function(){
								$.ajax({
									type:"post",
									url:'<s:url action="unlock" namespace="/sys/commom" />',
									data:{},
									dataType:"json",
									success:function(data){
										if(data.status==0){
											bsn.loadData();
										}
										xalert(data.msg);
									},
									error:function(data){
										xerror(data.responseText);										
									}
								});
							});
						});
					},
					modify:function(){
						$("#save").click(function(){
							var p1=$("input[name=password]").val();
							var p2=$("input[name=repassword]").val();
							if(p1!=p2){
								xalert("两次输入的密码不相同！");
								return;
							}
							$.ajax({
								type:"post",
								url:'<s:url action="update" namespace="/sys/commom" />',
								data:{value:p1},
								dataType:"json",
								success:function(data){
									if(data.status==0){
										bsn.loadData();
										$("#update .f_close").trigger("click");
									}
									xalert(data.msg);
								},
								error:function(data){
									xerror(data.responseText);
								}
							});
						});
					},
					init:function(){
						bsn.loadData();
						bsn.lock();
						bsn.unlock();
						bsn.modify();
					}
				}
				bsn.init();
			});
			
		</script>
	</body>
</html>

