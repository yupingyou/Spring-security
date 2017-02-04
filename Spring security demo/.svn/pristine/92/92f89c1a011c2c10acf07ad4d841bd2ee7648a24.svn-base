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
		<meta charset="UTF-8">
		<title>用户管理</title>
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
						<li class="station"><a class="add" href="javascript:;" data-toggle="tooltip" data-trigger="hover" data-placement="right" title="新建"  onclick="openpop(this)"><i class="icon glyphicon glyphicon-plus"></i>新建</a></li>
						<li class="station"><a class="update" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="修改" onclick="optsedit(this,'radio')"><i class="icon glyphicon glyphicon-pencil"></i>修改</a></li>
						<li class="station"><a class="del" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="删除" onclick="optsedit(this,'checkbox')"><i class="icon glyphicon glyphicon-trash"></i>删除</a></li>
						<li class="station"><a class="move" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="移动" onclick="optsedit(this,'checkbox')"><i class="icon glyphicon glyphicon-move"></i>移动</a></li>
					</ul>
				</div>
			</div>
			<!--end 左侧工具栏-->
			<div class="contentbox">
				<div class="navBar navBar_bg">
					<div class="breadCrumb">
						<ol>
							<li title="系统管理">系统管理</li>
							<li title="用户管理">用户管理</li>
						</ol>
					</div>
				</div>
				<div class="main_box">
					<div class="screen pl20">
						<div class="row">
							<form class="form-inline" id="search_form">
								<div class="col-xs-11 screen_left">
									<div class="col-xs-12 plf0">
										<div class="col-xs-1 plf0 ops mb5 screen_title">
											<span class="form-group screen_org pr5">高级筛选:</span>
										</div>
										<div class="col-xs-11 plf0 ops mb5">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">用户账号</span>
												<input name="loginName" type="text" class="form-control" />
											</div>
											<div class="input-group input-group-sm">
												<span class="input-group-addon">手机号码</span>
												<input name="mobilePhone" type="text" class="form-control" />
											</div>
											<div class="input-group input-group-sm">
												<span class="input-group-addon">单位名称</span>
												<input name="orgName" type="text" class="form-control" />
											</div>
											<div class="input-group input-group-sm">
												<span class="input-group-addon">用户名字</span>
												<input name="userName" type="text" class="form-control" />
											</div>
											<div class="input-group input-group-sm">
												<label for="select_province" class="input-group-addon">锁定状态</label>
												<select name="disabled" class="form-control">
													<option value="">全部</option>
													<option value="1">解锁</option>
													<option value="0">锁定</option>
												</select>
												<b class="dropdown-bg"></b>
												<i class="dropdown-trigger"></i>
											</div>
											<div class="input-group input-group-sm">
												<span class="input-group-addon">创建时间</span>
												<input name="dateStart" type="text" class="form-control timeTip" placeholder="请选择时间" id="protime1">
												<span class="input-group-addon">-至-</span>
												<input type="text" name="dateEnd" class="form-control timeTip" placeholder="请选择时间" id="protime2">
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-1 plf0 text-center">
									<button type="button" class="btn btn-warning btn-sm" title="导出Excel">导出Excel</button>
									<button type="button" id="search" class="btn btn-danger btn-sm" title="确定查询">确定查询</button>
								</div>
							</form>
						</div>
					</div>
					<table class="table table-striped mtable-striped table-hover table_hide" id="list">
						<thead>
							<tr>
								<th class="tab-checkbox">
								</th>
								<th>用户账号</th>
								<th>用户姓名</th>
								<th>手机号码</th>
								<th>单位名称</th>
								<th>部门名称</th>
								<th>创建时间</th>
								<th>锁定状态</th>
								<th>详情</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>1</td>
								<td>潘国栋</td>
								<td>13922287057</td>
								<td>广州兴国新能源科技有限公司</td>
								<td>研发部</td>
								<td>2015-10-13 15:00:56</td>
								<td><span class="normal">解锁</span></td>
								<td><a class="find" href="javascript:;" title="查看" onclick="openpop(this)">查看</a></td>
							</tr>
							
						</tbody>
						<!--分页 stars-->
						<tfoot>
							<tr>
								<td colspan="9">
									<div class="col-xs-12" id="action">
										<ul class="btn-tool">
											<!--修改-->
											<li class="update">
												<button id="js_update_load" type="button" class="update btn btn-warning" title="修改">
													<span class="ico"><i class="iconfont icon-cg"></i></span><span class="iconchar">修改</span>
												</button>
												<button  type="button" class="btn btn-default tool-cancel" title="取消">
													<span class="ico"><i class="iconfont icon-cw"></i></span><span class="iconchar">取消</span>
												</button>
											</li>
											<!--删除-->
											<li class="del">
												<button id="delete" type="button" class="btn btn-warning" title="删除">
													<span class="ico"><i class="iconfont icon-cg"></i></span><span class="iconchar">删除</span>
												</button>
												<button  type="button" class="btn btn-default tool-cancel" title="取消">
													<span class="ico"><i class="iconfont icon-cw"></i></span><span class="iconchar">取消</span>
												</button>
											</li>
											<!--移动-->
											<li class="move">
												<button name="move" type="button" class="move btn btn-warning" title="移动">
													<span class="ico"><i class="iconfont icon-cg"></i></span><span class="iconchar">移动</span>
												</button>
												<button  type="button" class="btn btn-default tool-cancel" title="取消">
													<span class="ico"><i class="iconfont icon-cw"></i></span><span class="iconchar">取消</span>
												</button>
											</li>
										</ul>
									</div>
									<div class="col-xs-12 text-center" id="ftpage">
										<ul class="pagination pagination-color ">
											<li class="start invisible">
												<a href="javascript:;" title="首页">首页</a>
											</li>
											<li class="prev disabled">
												<a href="javascript:;" title="上一页"><span>上一页</span></a>
											</li>
											<li class="leaf active">
												<a href="javascript:;">1</a>
											</li>
											<li class="leaf">
												<a href="javascript:;">2</a>
											</li>
											<li class="leaf">
												<a href="javascript:;">3</a>
											</li>
											<li class="leaf">
												<a href="javascript:;">4</a>
											</li>
											<li class="leaf">
												<a href="javascript:;">5</a>
											</li>
											<li class="next">
												<a href="javascript:;" title="下一页"><span>下一页</span></a>
											</li>
											<li class="end">
												<a href="javascript:;" title="尾页">尾页</a>
											</li>
											<span class="fany">&nbsp;第 <span class="curr">1</span> 页 &nbsp;|&nbsp;共 <span class="total">5</span>页</span>
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
		<!--新建-->
		<div class="xform" id="add" >
			<div>
				<div class="f_haeder">
					<span>新建</span>
					<a class="f_close" href="javascript:;" title="关闭">
						<span></span>
					</a>
				</div>
				<form class="f_cont" id="add_form">
					<table >
						<tbody>
							<tr>
								<td>用户账号</td>
								<td>
									<input name="loginName" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>用户姓名</td>
								<td><input name="userName" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>部门名称</td>
								<td class="tree">
									<input type="hidden" name="deptId"/>
									<input placeholder="请选择部门" class="form-control" name="deptName" type="text" onclick="fjs.tree(this);"/>
									<div>
										<ul id="ztree1" class="ztree"></ul>
									</div>
								</td>
							</tr>
							<tr>
								<td>手机号码</td>
								<td><input class="form-control" name="mobilePhone" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>电话号码</td>
								<td><input name="tel" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>电子邮箱</td>
								<td><input name="email" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>登录密码</td>
								<td><input class="form-control" name="password" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>密码锁定次数</td>
								<td><input class="form-control" name="userLockNum" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>性别</td>
								<td>
									<select name="gender" class="form-control">
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
									<b class="dropdown-bg"></b>
									<i class="dropdown-trigger"></i>
								</td>
							</tr>
							<tr>
								<td>工作单位</td>
								<td>
									<select id="js_org_add" name="orgId" class="form-control">
										<option value="">请选择</option>
										<option>兴国分公司</option>
										<option>广州市政府</option>
										<option>中外建集团</option>
									</select>
									<b class="dropdown-bg"></b>
									<i class="dropdown-trigger"></i>
								</td>	
							</tr>
							<tr>
								<td>居住(工作)地址</td>
								<td><input name="addr" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>用户类型</td>
								<td>
									<select class="form-control">
										<option>系统用户</option>
										<option>加盟商</option>
									</select>
									<b class="dropdown-bg"></b>
									<i class="dropdown-trigger"></i>
								</td>
							</tr>
							<tr>
								<td>描述</td>
								<td><input name="remark" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="opts">
						<a class="btn btn-warning">确定</a>
					</div>
				</form>
			</div>
		</div>
		<!--修改-->
		<div class="xform" id="update" >
			<div>
				<div class="f_haeder">
					<span>修改</span>
					<a class="f_close" href="javascript:;" title="关闭">
						<span></span>
					</a>
				</div>
				<form class="f_cont" id="update_form">
					<table>
						<tbody>
							<tr>
								<td>用户账号</td>
								<td>
									<input name="id" type="hidden" />
									<input class="form-control" readonly="readonly" name="loginName" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>用户姓名</td>
								<td><input name="userName" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>部门名称</td>
								<td class="tree">
								<input type="hidden" name="deptId" />
								<input class="form-control" name="deptName" type="text" placeholder="请选择部门" onclick="fjs.tree(this);"/>
								<div>
									<ul id="ztree3" class="ztree"></ul>
								</div>
								</td>
							</tr>
							<tr>
								<td>手机号码</td>
								<td><input name="mobilePhone" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>电话号码</td>
								<td><input name="tel" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>电子邮箱</td>
								<td><input name="email" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>登录密码</td>
								<td><input name="password" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>密码锁定次数</td>
								<td><input class="form-control" name="userLockNum" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>密码错误次数次数</td>
								<td><input class="form-control" name="userLockErrorNum" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>性别</td>
								<td>
									<select name="gender" class="form-control">
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
									<b class="dropdown-bg"></b>
									<i class="dropdown-trigger"></i>
								</td>
							</tr>
							<tr>
								<td>工作单位</td>
								<td>
								<select id="js_org_update" name="orgId" class="form-control">
										<option value="">请选择</option>
										<option>兴国分公司</option>
										<option>广州市政府</option>
										<option>中外建集团</option>
									</select>
									<b class="dropdown-bg"></b>
									<i class="dropdown-trigger"></i>
								</td>
							</tr>
							<tr>
								<td>居住(工作)地址</td>
								<td><input name="addr" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>用户类型</td>
								<td>
									<select class="form-control">
										<option>系统用户</option>
										<option>加盟商</option>
									</select>
									<b class="dropdown-bg"></b>
									<i class="dropdown-trigger"></i>
								</td>
							</tr>
							<tr>
								<td>描述</td>
								<td><input name="remark" class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="opts">
						<a class="btn btn-warning">确定</a>
					</div>
				</form>
			</div>
		</div>
		<!--移动-->
		<div class="xform" id="move" >
			<div>
				<div class="f_haeder">
					<span>移动</span>
					<a class="f_close" href="javascript:;" title="关闭">
						<span></span>
					</a>
				</div>
				<form class="f_cont">
					<table >
						<tbody>
							<tr>
								<td>选择部门</td>
								<td class="tree">
									<input type="hidden" name="deptId" />
									<input class="form-control" placeholder="请选择部门" name="deptName" type="text" onclick="fjs.tree(this);"/>
									<div>
										<ul id="ztree2" class="ztree"></ul>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="opts">
						<a class="btn btn-warning">确定</a>
					</div>
				</form>
			</div>
		</div>
		<!--详情-->
		<div class="xform" id="find" >
			<div>
				<div class="f_haeder">
					<span>用户详细信息</span>
					<a class="f_close" href="javascript:;" title="关闭">
						<span></span>
					</a>
				</div>
				<form class="f_cont">
				<input type="hidden" name="userId"/>
					<table>
						<tbody>
							<tr>
								<td>用户账号</td>
								<td class="loginName"></td>
							</tr>
							<tr>
								<td>用户姓名</td>
								<td class="userName"></td>
							</tr>
							<tr>
								<td>部门名称</td>
								<td class="deptName"></td>
							</tr>
							<tr>
								<td>手机号码</td>
								<td class="mobilePhone"></td>
							</tr>
							<tr>
								<td>电话号码</td>
								<td class="tel"></td>
							</tr>
							<tr>
								<td>电子邮箱</td>
								<td class="email"></td>
							</tr>
							<tr>
								<td>性别</td>
								<td class="gender"></td>
							</tr>
							<tr>
								<td>单位名称</td>
								<td class="orgName"></td>
							</tr>
							<tr>
								<td>法人代表(单位负责人)</td>
								<td class="lawRepresentative"></td>
							</tr>
							<tr>
								<td>用户(公司)地址</td>
								<td class="addr"></td>
							</tr>
							<tr>
								<td>锁定次数</td>
								<td class="userLockNum"></td>
							</tr>
							<tr>
								<td>错误次数</td>
								<td class="userLockErrorNum"></td>
							</tr>
							<tr>
								<td>用户状态</td>
								<td class="status"></td>
							</tr>
							<tr>
								<td>用户类型</td>
								<td>系统用户</td>
							</tr>
							<tr>
								<td>用户描述</td>
								<td class="remark"></td>
							</tr>
							<tr>
								<td>用户创建时间</td>
								<td class="createDate"></td>
							</tr>
						</tbody>
					</table>
					<div class="opts">
						<a id="js_lock" class="btn btn-warning">锁定</a>
						<a id="js_unlock" class="btn btn-default">解锁</a>
					</div>
				</form>
			</div>
		</div>
	<script>
			//时间插件
	    $('.timeTip').datetimepicker({
        	showClear: true,
        	format: 'YYYY-MM-DD',
			locale: 'zh-CN'
       });
	    
	    $(function(){
	    		var bsn={
	    			ids:[],
	    			ctd:{},
	    			pageNo:1,
	    			init:function(){
	    				bsn.loadData(1);
	    				bsn.initDept();
	    				bsn.add();
	    				bsn.deleteUser();
	    				bsn.detail();
	    				bsn.search();
	    				bsn.update();
	    				bsn.updateLoad();
	    				bsn.move();
	    				bsn.moveAction();
	    				bsn.lock();
	    				bsn.unlock();
	    			},
	    			loadData:function(pageNo){
	    					bsn.pageNo=pageNo;
		    				var data={pageNo:pageNo};
		    				if(bsn.ctd.loginName){
		    					data.loginName=bsn.ctd.loginName;
		    				}
		    				if(bsn.ctd.userName){
		    					data.userName=bsn.ctd.userName;
		    				}
		    				if(bsn.ctd.mobilePhone){
		    					data.mobilePhone=bsn.ctd.mobilePhone;
		    				}
		    				if(bsn.ctd.orgName){
		    					data.orgName=bsn.ctd.orgName;
		    				}
		    				if(bsn.ctd.disabled){
		    					data.disabled=bsn.ctd.disabled;
		    				}
		    				if(bsn.ctd.dateStart){
		    					data.dateStart=bsn.ctd.dateStart;
		    				}
		    				if(bsn.ctd.dateEnd){
		    					data.dateEnd=bsn.ctd.dateEnd;
		    				}
		    				$.ajax({
		    					url:"<s:url action='/user/list' namespace='/sys'/>",
		    					data:data,
		    					type:"post",
		    					success:function(data){
		    						if(data.status!=1){
		    							pagination.load(data.page,"#ftpage ul");
		    							bsn.footPage();
		    							bsn.initData(data.page);
		    						}else{
		    							xalert(data.msg);
		    						}
		    					},
		    					error:function(data){
		    						xerror(data.responseText);
		    					}
		    				});
	    			},
	    			footPage:function(){//分页工具栏事件绑定
						$("#ftpage .start").click(function() {
							bsn.loadData(1);  //不同模块只需改加载方法.loadData()和ftpage2对象
						});
						$("#ftpage .end").click(function(){
							bsn.loadData($(this).attr("id"));
						});
						$("#ftpage .leaf").click(function(){
							bsn.loadData($(this).children().html());
						});
					},
	    			initData:function(page){
	    				var list=page.items;
	    				$("#list tbody").html("");
	    				if(list&&list.length>0){
	    					for(var i=0;i<list.length;i++){
	    						var user=list[i];
	    						var createData=user.createDate;
	    						if(createData){
	    							createData=createData.replace("T"," ");
	    						}else{
	    							createData="";
	    						}
			    				var tr='<tr>'+
											'<td class="ruleSet_td tab-checkbox">'+
												'<input type="checkbox" name="select" value="'+user.id+'">'+
												'<input type="radio" name="single" value="'+user.id+'">'+
											'</td>'+
											'<td>'+user.loginName+'</td>'+
											'<td>'+user.userName+'</td>'+
											'<td>'+(user.mobilePhone||'')+'</td>'+
											'<td>'+(user.org?user.org.orgName:'')+'</td>'+
											'<td>'+(user.dept?user.dept.deptName:'')+'</td>'+
											'<td>'+createData+'</td>'+
											'<td><span class="'+(user.disabled==1?'normal':'shut')+'">'+(user.disabled==1?'解锁':'锁定')+'</span></td>'+
											'<td><a class="find" href="javascript:;" title="查看" onclick="openpop(this)">查看</a></td>'+
										'</tr>';
									$("#list tbody").append(tr);
	    					}
	    				}else{
	    					$("#list tbody").html("<tr><td colspan='20'>暂无数据</td></tr>");
	    				}
	    			},
	    			initDept:function(){
	    				//加载部门下拉
    					$.ajax({
    						type:"post",
    						url:"<s:url action='/dept/loadDeptTree' namespace='/sys'/>",
    						type:"post",
    						success:function(data){
    							var list=data.list;
    							if(list&&list.length>0){
    								var nodes=[];
    								for(var i=0;i<list.length;i++){
    									var dept=list[i];
    									var node={};
    									node.id=dept.id;
    									node.name=dept.deptName;
    									node.pId=dept.parentDept?dept.parentDept.id:0;
    									nodes.push(node);
    								}
    								add.tree(nodes);
    								update.tree(nodes);
    								move.tree(nodes);
    							}
    						},
    						error:function(data){
    							xerror(data.responseText);
    						}
    					});
    					//加载组织下拉
    					$.ajax({
    						type:"post",
    						url:"<s:url action='loadOrg' namespace='/sys/org'/>",
    						success:function(data){
    							$("#js_org_add").html("<option value=''>暂无组织</option>");
    							$("#js_org_update").html("<option value=''>暂无组织</option>");
    							if(data.list){
    								var list=data.list;
    								if(list.length>0){
    									$("#js_org_add").html("<option value=''>请选择</option>");
    									$("#js_org_update").html("<option value=''>请选择</option>");
    									for(var i=0;i<list.length;i++){
    										$("#js_org_add").append("<option value='"+list[i].id+"'>"+list[i].orgName+"</option>");
    										$("#js_org_update").append("<option value='"+list[i].id+"'>"+list[i].orgName+"</option>");
    									}
    								}
    							}else{
    								xalert(data.msg);
    							}
    						},
    						error:function(data){
    							
    						}
    					});
	    			},
	    			add:function(){
	    				$("#add_form .opts a").click(function(){
	    					var formData=$("#add_form").serializeObject();
	    					if(!formData.loginName){
	    						xtip("请输入用户名！");
	    						return;
	    					}
	    					if(!formData.userName){
	    						xtip("请输入用户姓名！");
	    						return;
	    					}
	    					if(!formData.deptId){
	    						xtip("请选择一个部门！");
	    						return;
	    					}
	    					if(!(/^1[34578]\d{9}$/.test(formData.mobilePhone))){ 
						        xtip("请输入正确的手机号码!");
						        return;
						    }
							if(!/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(formData.email)){
								xtip("请输入正确的邮箱！");
								return;
							}
	    					if(!formData.password){
	    						xtip("请输入登录密码！");
	    						return;
	    					}
	    					if(!formData.orgId){
	    						xtip("请选择一个组织！");
	    						return;
	    					}
	    					$.ajax({
	    						url:"<s:url action='addUser' namespace='/sys/user'/>",
	    						type:"post",
	    						data:formData,
	    						success:function(data){
	    							if(data.status==0){
	    								$("#add .f_close").trigger("click");//关闭
	    								bsn.loadData(bsn.pageNo);
	    							}
	    							xalert(data.msg);
	    						},
	    						error:function(data){
	    							xerror(data.responseText);
	    						}
	    					});
	    				});
	    			},
	    			update:function(){//修改确认动作
	    				$("#update_form .opts a").click(function(){
	    					var formData=$("#update_form").serializeObject();
	    					if(!formData.loginName){
	    						xtip("请输入用户名！");
	    						return;
	    					}
	    					if(!formData.userName){
	    						xtip("请输入用户姓名！");
	    						return;
	    					}
	    					if(!formData.deptId){
	    						xtip("请选择一个部门！");
	    						return;
	    					}
	    					if(!(/^1[34578]\d{9}$/.test(formData.mobilePhone))){ 
						        xtip("请输入正确的手机号码!");
						        return;
						    }
							if(!/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(formData.email)){
								xtip("请输入正确的邮箱！");
								return;
							}
	    					if(!formData.orgId){
	    						xtip("请选择一个组织！");
	    						return;
	    					}
	    					$.ajax({
	    						url:"<s:url action='/user/update' namespace='/sys'/>",
	    						type:"post",
	    						data:formData,
	    						success:function(data){
	    							if(data.status==0){
	    								$("#update .f_close").trigger("click");//关闭
	    								bsn.loadData(bsn.pageNo);
	    							}
	    							xalert(data.msg);
	    						},
	    						error:function(data){
	    							xerror(data.responseText);
	    						}
	    					});
	    				});
	    			},
	    			updateLoad:function(){//修改加载默认数据
	    				$("#js_update_load").click(function(){
	    					var id="";
	    					$("#list tbody input[name=single]").each(function(){
	    						if(this.checked){
	    							id=this.value;
	    						}
	    					});
	    					if(id){
	    						openpop(this);
	    						$.ajax({
	    							type:"post",
	    							url:"<s:url action='userDetail' namespace='/sys/user'/>",
	    							data:{id:id},
	    							success:function(data){
	    								if(data.user){
	    									var user=data.user;
	    									$("#update_form input[name=id]").val(user.id);
	    									$("#update_form input[name=loginName]").val(user.loginName);
	    									$("#update_form input[name=userName]").val(user.userName);
	    									$("#update_form input[name=deptId]").val(user.dept.id);
	    									$("#update_form input[name=deptName]").val(user.dept.deptName);
	    									$("#update_form input[name=mobilePhone]").val(user.mobilePhone);
	    									$("#update_form input[name=tel]").val(user.tel);
	    									$("#update_form input[name=email]").val(user.email);
//	    									$("#update_form input[name=password]").val(user.password);
	    									$("#update_form input[name=userLockNum]").val(user.userLockNum);
	    									$("#update_form input[name=userLockErrorNum]").val(user.userLockErrorNum);
	    									$("#update_form select[name=gender]").find("option").each(function(){
	    										if(this.value==user.gender){
	    											this.selected=true;
	    										}
	    									});
	    									if(user.org){
	    										$("#js_org_update").find("option").each(function(){
		    										if(this.value==user.org.id){
		    											this.selected=true;
		    										}
		    									});
	    									}
	    									$("#update_form input[name=addr]").val(user.addr);
	    									$("#update_form input[name=remark]").val(user.remark);
	    								}
	    							},
	    							error:function(data){
	    								xerror(data.responseText);
	    							}
	    							
	    						});
	    					}else{
	    						xalert("请选择一个用户！");
	    					}
	    					
	    				});
	    				
	    			},
	    			detail:function(){
	    				$("#list tbody").on("click",".find",function(){
	    					var id=$(this).parent().parent().find("input[name=select]").val();
	    					xloading.init("#find");
	    					bsn.loadDetailData(id);
	    				});
	    			},
	    			loadDetailData:function(id){
	    				$.ajax({
	    						url:"<s:url action='userDetail' namespace='/sys/user'/>",
	    						type:"post",
	    						data:{id:id},
	    						success:function(data){
	    							xloading.destroy();
	    							if(data.user){
    									var user=data.user;
    									var date=user.createDate;
    									if(date){
    										date=date.replace("T"," ");
    									}else{
    										date="";
    									}
    									$("#find input[name=userId]").val(user.id);
    									$("#find table tr td[class=loginName]").html(user.loginName);
    									$("#find table tr td[class=userName]").html(user.userName);
    									$("#find table tr td[class=deptName]").html(user.dept?user.dept.deptName:"");
    									$("#find table tr td[class=mobilePhone]").html(user.mobilePhone);
    									$("#find table tr td[class=tel]").html(user.tel);
    									$("#find table tr td[class=email]").html(user.email);
    									$("#find table tr td[class=gender]").html(user.gender==0?"男":"女");
    									$("#find table tr td[class=orgName]").html(user.org?user.org.orgName:"");
    									$("#find table tr td[class=lawRepresentative]").html(user.org?user.org.lawRepresentative:"");
    									$("#find table tr td[class=addr]").html(user.addr);
    									$("#find table tr td[class=userLockNum]").html(user.userLockNum);
    									$("#find table tr td[class=userLockErrorNum]").html(user.userLockErrorNum);
    									$("#find table tr td[class=status]").html(user.disabled==0?"锁定":"解锁");
    									$("#find table tr td[class=remark]").html(user.remark);
    									$("#find table tr td[class=createDate]").html(date);
    								}
	    						},
	    						error:function(){
	    							xloading.destroy();
	    							xerror(data.responseText)
	    						}
	    					});
	    			},
	    			deleteUser:function(){
	    				$("#delete").click(function(){
	    					var ids=[];
	    					$("#list tbody").find("input[type=checkbox]").each(function(){
	    						if(this.checked){
	    							ids.push(this.value);
	    						}
	    					});
	    					if(ids.length==0){
	    						xalert("请至少选择其中一项以删除");
	    						return;
	    					}
	    					xconfirm("确定要删除选中用户吗？",function(){
	    						xloading.init(".module");
		    					$.ajax({
		    						type:"post",
		    						url:"<s:url action='delete' namespace='/sys/user'/>",
		    						data:{ids:ids.toString()},
		    						success:function(data){
		    							xloading.destroy();
		    							if(data.status==0){
		    								$("#delete").next().trigger("click");//关闭选择
		    								bsn.loadData(bsn.pageNo);
		    							}
		    							xalert(data.msg);
		    						},
		    						error:function(data){
		    							xloading.destroy();
		    							xerror(data.responseText);
		    						}
		    					});
	    					});
	    				});
	    			},
	    			search:function(){
	    				$("#search").click(function(){
	    					var formData=$("#search_form").serializeObject();
	    					bsn.ctd=formData;
	    					bsn.loadData(1);
	    				});
	    			},
	    			move:function(){
	    				$("#action .move button[name=move]").click(function(){
	    					bsn.ids=[];
	    					$("#list tbody").find("input[type=checkbox]").each(function(){
	    						if(this.checked){
	    							bsn.ids.push(this.value);
	    						}
	    					});
	    					if(bsn.ids.length==0){
	    						xalert("请至少选择一个用户");
	    						return;
	    					}
	    					openpop(this);
	    				});
	    			},
	    			moveAction:function(){
	    				$("#move .opts a").click(function(){
	    					if(!$("#move form input[name=deptId]").val()){
	    						xalert("请选择一个部门！");
	    						return;
	    					}
	    					
	    					$.ajax({
	    						url:"<s:url action='moveDept' namespace='/sys/user'/>",
	    						type:"post",
	    						data:{ids:bsn.ids.toString(),deptId:$("#move form input[name=deptId]").val()},
	    						success:function(data){
	    							if(data.status==0){
	    								$("#move .f_close").trigger("click");//关闭
	    								bsn.ids=[];
	    								bsn.loadData(bsn.pageNo);
	    							}
	    							xalert(data.msg);
	    						},
	    						error:function(data){
	    							xerror(data.responseText);
	    						}
	    					})
	    					
	    				});
	    			},
	    			unlock:function(){
	    				$("#js_unlock").click(function(){
	    					var id=$("#find input[name=userId]").val();
	    					$.ajax({
	    						type:"post",
	    						url:"<s:url action='unlock' namespace='/sys/user'/>",
	    						data:{id:id},
	    						success:function(data){
	    							if(data.status==0){
	    								bsn.loadData(bsn.pageNo);
	    								bsn.loadDetailData(id);
	    							}
	    							xalert(data.msg);
	    						},
	    						error:function(data){
	    							xerror(data.responseText);
	    						}
	    					});
	    				});
	    			},
	    			lock:function(){
	    				$("#js_lock").click(function(){
	    					var id=$("#find input[name=userId]").val();
	    					$.ajax({
	    						type:"post",
	    						url:"<s:url action='lock' namespace='/sys/user'/>",
	    						data:{id:id},
	    						success:function(data){
	    							if(data.status==0){
	    								bsn.loadData(bsn.pageNo);
	    								bsn.loadDetailData(id);
	    							}
	    							xalert(data.msg);
	    						},
	    						error:function(data){
	    							xerror(data.responseText);
	    						}
	    					});
	    				});
	    			}
	    			
	    			
	    		};
	    	
		    	//添加部门
		    	var add={
		    		init:function(){
		    			/*this.tree();*/
		    			this.keyboardChange();
		    		},
		    		keyboardChange:function(){//键盘更改了里面的内容则需要验证
		    			$("#add input[name=deptName]").keyup(function(){
		    				var treeObj = $.fn.zTree.getZTreeObj("ztree1");
		    				var nodes = treeObj.getCheckedNodes(true);
		    				if(nodes.length>0){
		    					treeObj.checkNode(nodes[0],false, false);
		    				}
		    				nodes=treeObj.getNodes();
		    				var flag=true;
		    				if(nodes.length>0){
		    					for(var i=0;i<nodes.length;i++){
		    						if(nodes[i].name==this.value){
		    							flag=false;
		    							$(this).prev().val(nodes[i].id);
		    							treeObj.checkNode(nodes[i], true, false);//选中节点
		    							break;
		    						}
		    					}
		    				}
		    				if(flag){//如果找不到匹配的节点，则将隐藏域清空
		    					$(this).prev().val("");
		    				}
		    			});
		    		},
		    		tree:function(nodes){
		    			var setting = {
							view: {
								dblClickExpand: false,
								showLine: false,
								showIcon:false
							},
							data: {
								simpleData: {
									enable: true
								}
							},
							check:{
								enable:true,
								chkStyle: "radio",
								radioType: "all",
							},
							callback: {
								onClick:function(e, treeId, treeNode){
									if(treeNode.isParent){
										$("#"+treeNode.tId+"_switch").trigger("click");
									}
								},
								onCheck: function(e, treeId, treeNode){
									$("#"+treeNode.tId).closest(".ztree").closest("div").fadeOut("fast").prev().prev().val(treeNode.id);
									$("#"+treeNode.tId).closest(".ztree").closest("div").fadeOut("fast").prev().val(treeNode.name);
								}
							}
						};
						var zNodes =[
							{id:1, pId:0, name:"研发部"},
							{id:5, pId:0, name:"产品管理部"},
							{id:6, pId:0, name:"市场营销部"},
							{id:6, pId:0, name:"战略策划部"},
							{id:6, pId:0, name:"人力资源部"},
							{id:6, pId:0, name:"财资部"},
							{id:6, pId:0, name:"客服部"},
							{id:6, pId:0, name:"工程部"}
						 ];
						$.fn.zTree.init($("#ztree1"), setting, nodes);
		    		}
		    	};
		    	var move ={
		    		init:function(){
		    			/*this.tree();*/
		    			this.keyboardChange();
		    		},
		    		keyboardChange:function(){//键盘更改了里面的内容则需要验证
		    			$("#move input[name=deptName]").keyup(function(){
		    				var treeObj = $.fn.zTree.getZTreeObj("ztree2");
		    				//取消选中节点的勾选状态
		    				var nodes = treeObj.getCheckedNodes(true);
		    				if(nodes.length>0){
		    					treeObj.checkNode(nodes[0],false, false);
		    				}
		    				var flag=true;
		    				nodes=treeObj.getNodes();
		    				if(nodes.length>0){
		    					for(var i=0;i<nodes.length;i++){
		    						if(nodes[i].name==this.value){
		    							flag=false;
		    							$(this).prev().val(nodes[i].id);
		    							treeObj.checkNode(nodes[i], true, false);//选中节点
		    							break;
		    						}
		    					}
		    				}
		    				if(flag){//如果找不到匹配的节点，则将隐藏域清空
		    					$(this).prev().val("");
		    				}
		    			});
		    		},
		    		tree:function(nodes){
		    			var setting = {
							view: {
								dblClickExpand: false,
								showLine: false,
								showIcon:false
							},
							data: {
								simpleData: {
									enable: true
								}
							},
							check:{
								enable:true,
								chkStyle: "radio",
								radioType: "all",
							},
							callback: {
								onClick:function(e, treeId, treeNode){
									if(treeNode.isParent){
										$("#"+treeNode.tId+"_switch").trigger("click");
									}
								},
								onCheck: function(e, treeId, treeNode){
									$("#"+treeNode.tId).closest(".ztree").closest("div").fadeOut("fast").prev().prev().val(treeNode.id);
									$("#"+treeNode.tId).closest(".ztree").closest("div").fadeOut("fast").prev().val(treeNode.name);
								}
							}
						};
						var zNodes =[
							{id:1, pId:0, name:"研发部"},
							{id:5, pId:0, name:"产品管理部"},
							{id:6, pId:0, name:"市场营销部"},
							{id:6, pId:0, name:"战略策划部"},
							{id:6, pId:0, name:"人力资源部"},
							{id:6, pId:0, name:"财资部"},
							{id:6, pId:0, name:"客服部"},
							{id:6, pId:0, name:"工程部"}
						 ];
						$.fn.zTree.init($("#ztree2"), setting, nodes);
		    		}
		    	};
		    	
		    	//修改：部门
		    	var update={
		    		init:function(){
		    			/*this.tree();*/
		    			this.keyboardChange();
		    		},
		    		keyboardChange:function(){//键盘更改了里面的内容则需要验证
		    			$("#update input[name=deptName]").keyup(function(){
		    				var treeObj = $.fn.zTree.getZTreeObj("ztree3");
		    				//取消选中节点的勾选状态
		    				var nodes = treeObj.getCheckedNodes(true);
		    				if(nodes.length>0){
		    					treeObj.checkNode(nodes[0],false, false);
		    				}
		    				var flag=true;
		    				nodes=treeObj.getNodes();
		    				if(nodes.length>0){
		    					for(var i=0;i<nodes.length;i++){
		    						if(nodes[i].name==this.value){
		    							flag=false;
		    							$(this).prev().val(nodes[i].id);
		    							treeObj.checkNode(nodes[i], true, false);//选中节点
		    							break;
		    						}
		    					}
		    				}
		    				if(flag){//如果找不到匹配的节点，则将隐藏域清空
		    					$(this).prev().val("");
		    				}
		    			});
		    		},
		    		tree:function(nodes){
		    			var setting = {
							view: {
								dblClickExpand: false,
								showLine: false,
								showIcon:false
							},
							data: {
								simpleData: {
									enable: true
								}
							},
							check:{
								enable:true,
								chkStyle: "radio",
								radioType: "all",
							},
							callback: {
								onClick:function(e, treeId, treeNode){
									if(treeNode.isParent){
										$("#"+treeNode.tId+"_switch").trigger("click");
									}
								},
								onCheck: function(e, treeId, treeNode){
									$("#"+treeNode.tId).closest(".ztree").closest("div").fadeOut("fast").prev().prev().val(treeNode.id);
									$("#"+treeNode.tId).closest(".ztree").closest("div").fadeOut("fast").prev().val(treeNode.name);
								}
							}
						};
						var zNodes =[
							{id:1, pId:0, name:"研发部"},
							{id:5, pId:0, name:"产品管理部"},
							{id:6, pId:0, name:"市场营销部"},
							{id:6, pId:0, name:"战略策划部"},
							{id:6, pId:0, name:"人力资源部"},
							{id:6, pId:0, name:"财资部"},
							{id:6, pId:0, name:"客服部"},
							{id:6, pId:0, name:"工程部"}
						 ];
						$.fn.zTree.init($("#ztree3"), setting, nodes);
		    		}
		    	};
		    	var formReset={
		    		init:function(){
		    			this.close();
		    		},
		    		close:function(){
		    			$(".f_close").click(function(){
		    				bsn.ids=[];
		    				$(this).parent().parent().find("form")[0].reset();
		    			});
		    		}
		    	}
		    	//模拟数据加载
		    	add.init();//新增
		    	move.init();//移动
		    	update.init();//修改:部门
		    	formReset.init();
		    	bsn.init();
			});
	</script>
	</body>
</html>
