<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>角色管理</title>
	</head>
	<body>
		<div class="module">
			<!--左侧工具栏 stars-->
			<div class="tool_left" id="monmenu">
				<div class="title"><a href="javascript:;"><span class="icon glyphicon glyphicon-chevron-left" id="slidicon"></span></a></div>
				<div class="tool" id="options">
					<ul class="toolp" id="pSubMenu">
						<li class="station"><a class="add" href="javascript:;" data-toggle="tooltip" data-trigger="hover" data-placement="right" title="新建" onclick="openpop(this)"><i class="icon glyphicon glyphicon-plus"></i>新建</a></li>
						<li class="station"><a class="update" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="修改" onclick="optsedit(this,'radio')"><i class="icon glyphicon glyphicon-pencil"></i>修改</a></li>
						<li class="station"><a class="del" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="删除" onclick="optsedit(this,'checkbox')"><i class="icon glyphicon glyphicon-trash"></i>删除</a></li>
						<li class="station"><a class="bill" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="菜单配置" onclick="optsedit(this,'radio')"><i class="icon glyphicon glyphicon-th-list"></i>菜单配置</a></li>
						<li class="station"><a class="area" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="管理区域配置" onclick="optsedit(this,'radio')"><i class="icon glyphicon glyphicon-map-marker"></i>管理区域配置</a></li>
					</ul>
				</div>
			</div>
			<!--end 左侧工具栏-->
			<div class="contentbox">
				<div class="navBar navBar_bg">
					<div class="breadCrumb">
						<ol>
							<li title="系统管理">系统管理</li>
							<li title="角色管理">角色管理</li>
						</ol>
					</div>
				</div>
				<div class="main_box">
					<div class="screen pl20">
						<div class="row">
							<form class="form-inline">
								<div class="col-xs-11 screen_left">
									<div class="col-xs-12 plf0">
										<div class="col-xs-1 plf0 ops mb5 screen_title">
											<span class="form-group screen_org pr5">高级筛选:</span>
										</div>
										<div class="col-xs-11 plf0 ops mb5">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">角色名称</span>
												<input type="text" class="form-control" />
											</div>
											<div class="input-group input-group-sm">
												<span class="input-group-addon">创建时间</span>
												<input type="text" class="form-control timeTip" placeholder="请选择时间" id="protime1">
												<span class="input-group-addon">-至-</span>
												<input type="text" class="form-control timeTip" placeholder="请选择时间" id="protime2">
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-1 plf0 text-center">
									<button type="button" class="btn btn-warning btn-sm" title="导出Excel">导出Excel</button>
									<button type="button" class="btn btn-danger btn-sm" title="确定查询">确定查询</button>
								</div>
							</form>
						</div>
					</div>
					<table class="table table-striped mtable-striped table-hover table_hide" id="list">
						<thead>
							<tr>
								<th class="tab-checkbox">
								</th>
								<th>角色名称</th>
								<th>角色描叙</th>
								<th>创建时间</th>
								<th>登录密码</th>
								<th>详情</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>研发</td>
								<td>研发主管</td>
								<td>2015-10-06 10:13</td>
								<td>123456</td>
								<td><a class="find" href="javascript:;" title="查看" onclick="openpop(this)">查看</a></td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>客服</td>
								<td>客服主管</td>
								<td>2015-09-20 11:12</td>
								<td>123456</td>
								<td><a class="find" href="javascript:;" title="查看" onclick="openpop(this)">查看</a></td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>工程</td>
								<td>工程主管</td>
								<td>2015-10-09 11:15</td>
								<td>123456</td>
								<td><a class="find" href="javascript:;" title="查看" onclick="openpop(this)">查看</a></td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>人力行政</td>
								<td>行政主管</td>
								<td>2015-10-12 10:12</td>
								<td>123456</td>
								<td><a class="find" href="javascript:;" title="查看" onclick="openpop(this)">查看</a></td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>财务</td>
								<td>财务主管</td>
								<td>2015-10-11 09:12</td>
								<td>123456</td>
								<td><a class="find" href="javascript:;" title="查看" onclick="openpop(this)">查看</a></td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>营销</td>
								<td>营销主管</td>
								<td>2015-10-11 09:12</td>
								<td>123456</td>
								<td><a class="find" href="javascript:;" title="查看" onclick="openpop(this)">查看</a></td>
							</tr>
						</tbody>
						<!--分页 stars-->
						<tfoot>
							<tr>
								<td colspan="6">
									<div class="col-xs-12">
										<ul class="btn-tool">
											<!--修改-->
											<li class="update">
												<button  type="button" class="update btn btn-warning" title="修改" onclick="openpop(this)">
													<span class="ico"><i class="iconfont icon-cg"></i></span><span class="iconchar">修改</span>
												</button>
												<button  type="button" class="btn btn-default tool-cancel" title="取消">
													<span class="ico"><i class="iconfont icon-cw"></i></span><span class="iconchar">取消</span>
												</button>
											</li>
											<!--删除-->
											<li class="del">
												<button  type="button" class="btn btn-warning" title="删除" onclick="xconfirm('确定删除选中用户？')">
													<span class="ico"><i class="iconfont icon-cg"></i></span><span class="iconchar">删除</span>
												</button>
												<button  type="button" class="btn btn-default tool-cancel" title="取消">
													<span class="ico"><i class="iconfont icon-cw"></i></span><span class="iconchar">取消</span>
												</button>
											</li>
											<!--菜单配置-->
											<li class="bill">
												<button  type="button" class="bill btn btn-warning" title="菜单配置" onclick="openpop(this)">
													<span class="ico"><i class="iconfont icon-cg"></i></span><span class="iconchar">菜单配置</span>
												</button>
												<button  type="button" class="btn btn-default tool-cancel" title="取消">
													<span class="ico"><i class="iconfont icon-cw"></i></span><span class="iconchar">取消</span>
												</button>
											</li>
											<!--管理区域配置-->
											<li class="area">
												<button  type="button" class="area btn btn-warning" title="区域配置" onclick="openpop(this)">
													<span class="ico"><i class="iconfont icon-cg"></i></span><span class="iconchar">区域配置</span>
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
		<div class="xform" id="add">
			<div>
				<div class="f_haeder">
					<span>添加</span>
					<a class="f_close" href="javascript:;" title="关闭">
						<span></span>
					</a>
				</div>
				<form class="f_cont">
					<table >
						<tbody>
							<tr>
								<td>角色名称</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>角色描叙</td>
								<td><input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>成员</td>
								<td class="tree">
									<input class="form-control" type="text" onclick="fjs.tree(this)"/>
									<div>
										<ul id="ztree1" class="ztree"></ul>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="opts">
						<!--<a class="btn btn-default">选择用户</a>-->
						<a class="btn btn-warning">确定</a>
					</div>
				</form>
			</div>
		</div>
		<!--修改-->
		<div class="xform" id="update">
			<div>
				<div class="f_haeder">
					<span>修改</span>
					<a class="f_close" href="javascript:;" title="关闭">
						<span></span>
					</a>
				</div>
				<form class="f_cont">
					<table >
						<tbody>
							<tr>
								<td>角色名称</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>角色描叙</td>
								<td><input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>成员</td>
								<td class="tree">
									<input class="form-control" type="text" onclick="fjs.tree(this);"/>
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
		<!--菜单配置-->
		<div class="xform" id="bill">
			<div>
				<div class="f_haeder">
					<span>菜单配置</span>
					<a class="f_close" href="javascript:;" title="关闭">
						<span></span>
					</a>
				</div>
				<form class="f_cont">
					<table >
						<tbody>
							<tr>
								<td>菜单配置</td>
								<td class="tree">
									<input class="form-control" type="text" onclick="fjs.tree(this);"/>
									<div>
										<ul id="ztree3" class="ztree"></ul>
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
		<!--管理区域配置-->
		<div class="xform" id="area">
			<div>
				<div class="f_haeder">
					<span>管理区域配置</span>
					<a class="f_close" href="javascript:;" title="关闭">
						<span></span>
					</a>
				</div>
				<form class="f_cont">
					<table >
						<tbody>
							<tr>
								<!--<td><ul id="treeArea" class="ztree"></ul></td>-->
								<td>管理区域配置</td>
								<td class="tree">
									<input class="form-control" type="text" onclick="fjs.tree(this);"/>
									<div>
										<ul id="ztree4" class="ztree"></ul>
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
					<table>
						<tbody>
							<tr>
								<td>用户账号</td>
								<td>xg101</td>
							</tr>
							<tr>
								<td>用户姓名</td>
								<td>潘国栋</td>
							</tr>
							<tr>
								<td>机构名称</td>
								<td>研发部</td>
							</tr>
							<tr>
								<td>手机号码</td>
								<td>13922287057</td>
							</tr>
							<tr>
								<td>电话号码</td>
								<td>----</td>
							</tr>
							<tr>
								<td>电子邮箱</td>
								<td>4532896262@qq.com</td>
							</tr>
							<tr>
								<td>性别</td>
								<td>男</td>
							</tr>
							<tr>
								<td>单位名称</td>
								<td>广州兴国新能源科技有限公司</td>
							</tr>
							<tr>
								<td>法人代表(单位负责人)</td>
								<td>陈冠华</td>
							</tr>
							<tr>
								<td>用户(公司)地址</td>
								<td>广州市萝岗区科学城光谱西路3号</td>
							</tr>
							<tr>
								<td>锁定次数</td>
								<td>0</td>
							</tr>
							<tr>
								<td>错误次数</td>
								<td>0</td>
							</tr>
							<tr>
								<td>用户状态</td>
								<td>激活</td>
							</tr>
							<tr>
								<td>用户类型</td>
								<td>研发主管</td>
							</tr>
							<tr>
								<td>用户描述</td>
								<td>----</td>
							</tr>
							<tr>
								<td>用户创建时间</td>
								<td>2015-10-11 10:33:12</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<script>
			$(".timeTip").datetimepicker({
		    	format: 'yyyy-MM-dd',
		    	minView:'month',
		 		language:  'zh-CN',
				autoclose: 1,
		    });
		    $(function(){
		    	//新增
		    	var add = {
		    		init:function(){
		    			this.ztree();
		    		},
		    		ztree:function(){
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
									chkStyle: "checkbox",
									chkboxType: { "Y": "ps", "N": "ps" }
								},
								callback: {
									onClick:function(e, treeId, treeNode){
										if(treeNode.isParent){
											$("#"+treeNode.tId+"_switch").trigger("click");
										}
									},
									onCheck: function(e, treeId, treeNode){
										var treeObj = $.fn.zTree.getZTreeObj("ztree1");
										var nodes = treeObj.getCheckedNodes(true);
										var len = nodes.length;//选中的数组长度
										var sublen = 0;//选中子项的查明后第
										var html ="";//页面显示的值
										var ids ="";//数据库传入的值
										$.each(nodes, function(index,node){
											if(!node.isParent){
												sublen++;
												if(index!=len-1){
													html+=node.name+",";
													ids+=node.id+",";
												}else{
													html+=node.name;
													ids+=node.id;
												}
											}
										});
										$("#"+treeNode.tId).closest(".ztree").closest("div").prev().val("("+sublen+"个)"+html).data("ids",ids);
									}
								}
							};
							var zNodes =[
								{id:1, pId:0, name:"组织机构"},
								{id:11, pId:1, name:"兴国科技"},
								{id:111, pId:11, name:"研发部"},
								{id:1111, pId:111, name:"潘国栋"},
								{id:1112, pId:111, name:"余伦聪"},
								{id:1113, pId:111, name:"张剑威"},
								{id:1111, pId:111, name:"艾华桥"}
							 ];
							$.fn.zTree.init($("#ztree1"), setting, zNodes);
		    		}
		    	};
		    	//修改
		    	var update = {
		    		init:function(){
		    			this.ztree();
		    		},
		    		ztree:function(){
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
									chkStyle: "checkbox",
									chkboxType: { "Y": "ps", "N": "ps" }
								},
								callback: {
									onClick:function(e, treeId, treeNode){
										if(treeNode.isParent){
											$("#"+treeNode.tId+"_switch").trigger("click");
										}
									},
									onCheck: function(e, treeId, treeNode){
										var treeObj = $.fn.zTree.getZTreeObj("ztree2");
										var nodes = treeObj.getCheckedNodes(true);
										var len = nodes.length;//选中的数组长度
										var sublen = 0;//选中子项的查明后第
										var html ="";//页面显示的值
										var ids ="";//数据库传入的值
										$.each(nodes, function(index,node){
											if(!node.isParent){
												sublen++;
												if(index!=len-1){
													html+=node.name+",";
													ids+=node.id+",";
												}else{
													html+=node.name;
													ids+=node.id;
												}
											}
										});
										$("#"+treeNode.tId).closest(".ztree").closest("div").prev().val("("+sublen+"个)"+html).data("ids",ids);
									}
								}
							};
							var zNodes =[
								{id:1, pId:0, name:"组织机构"},
								{id:11, pId:1, name:"兴国科技"},
								{id:111, pId:11, name:"研发部"},
								{id:1111, pId:111, name:"潘国栋"},
								{id:1112, pId:111, name:"余伦聪"},
								{id:1113, pId:111, name:"张剑威"},
								{id:1114, pId:111, name:"艾华桥"},
								{id:122, pId:12, name:"财资部"},
								{id:1223, pId:122, name:"陈梅珍"},
								{id:12, pId:1, name:"中外建集团"},
							 ];
							$.fn.zTree.init($("#ztree2"), setting, zNodes);
		    		}
		    	};
		    	//菜单配置
		    	var bill = {
		    		init:function(){
		    			this.ztree();
		    		},
		    		ztree:function(){
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
									chkStyle: "checkbox",
									chkboxType: { "Y": "ps", "N": "ps" }
								},
								callback: {
									onClick:function(e, treeId, treeNode){
										if(treeNode.isParent){
											$("#"+treeNode.tId+"_switch").trigger("click");
										}
									},
									onCheck: function(e, treeId, treeNode){
										var treeObj = $.fn.zTree.getZTreeObj("ztree3");
										var nodes = treeObj.getCheckedNodes(true);
										var len = nodes.length;//选中的数组长度
										var sublen = 0;//选中子项的查明后第
										var html ="";//页面显示的值
										var ids ="";//数据库传入的值
										$.each(nodes, function(index,node){
											if(!node.isParent){
												sublen++;
												if(index!=len-1){
													html+=node.name+",";
													ids+=node.id+",";
												}else{
													html+=node.name;
													ids+=node.id;
												}
											}
										});
										$("#"+treeNode.tId).closest(".ztree").closest("div").prev().val("("+sublen+"个)"+html).data("ids",ids);
									}
								}
							};
							var zNodes =[
								{id:1, pId:0, name:"首页"},
								{id:2, pId:0, name:"充电桩监控"},
								{id:3, pId:0, name:"营销管理"},
								{id:31, pId:3, name:"台账管理"},
								{id:32, pId:3, name:"计费规则"},
								{id:33, pId:3, name:"规则导入"},
								{id:34, pId:3, name:"会员中心"},
								{id:35, pId:3, name:"会员消费查询"},
								{id:4, pId:0, name:"供电系统监控"},
								{id:5, pId:0, name:"故障中心"},
								{id:51, pId:5, name:"实时警告"},
								{id:52, pId:5, name:"执行维修工单"},
								{id:53, pId:5, name:"历史告警"},
								{id:54, pId:5, name:"运维查询"},
								{id:55, pId:5, name:"执行人员列表"},
								{id:6, pId:0, name:"系统管理"},
								{id:61, pId:6, name:"组织机构"},
								{id:62, pId:6, name:"部门管理"},
								{id:63, pId:6, name:"用户管理"},
								{id:64, pId:6, name:"角色管理"},
								{id:65, pId:6, name:"菜单配置"},
								{id:66, pId:6, name:"同样管理"}
							 ];
							$.fn.zTree.init($("#ztree3"), setting, zNodes);
		    		}
		    	};
		    	//管理区域配置
		    	var area = {
		    		init:function(){
		    			this.ztree();
		    		},
		    		ztree:function(){
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
									chkStyle: "checkbox",
									chkboxType: { "Y": "ps", "N": "ps" }
								},
								callback: {
									onClick:function(e, treeId, treeNode){
										if(treeNode.isParent){
											$("#"+treeNode.tId+"_switch").trigger("click");
										}
									},
									onCheck: function(e, treeId, treeNode){
										var treeObj = $.fn.zTree.getZTreeObj("ztree4");
										var nodes = treeObj.getCheckedNodes(true);
										var len = nodes.length;//选中的数组长度
										var sublen = 0;//选中子项的查明后第
										var html ="";//页面显示的值
										var ids ="";//数据库传入的值
										$.each(nodes, function(index,node){
											if(!node.isParent){
												sublen++;
												if(index!=len-1){
													html+=node.name+",";
													ids+=node.id+",";
												}else{
													html+=node.name;
													ids+=node.id;
												}
											}
										});
										$("#"+treeNode.tId).closest(".ztree").closest("div").prev().val("("+sublen+"个)"+html).data("ids",ids);
									}
								}
							};
							var zNodes =[
								{id:1, pId:0, name:"北京市"},
								{id:11, pId:1, name:"昌平区"},
								{id:111, pId:11, name:"昌平充电站"},
								{id:12, pId:1, name:"朝阳区"},
								{id:121, pId:12, name:"朝阳充电站"},
								{id:13, pId:1, name:"大兴区"},
								{id:131, pId:13, name:"大兴充电站"},
								{id:14, pId:1, name:"东城区"},
								{id:141, pId:14, name:"东城充电桩"},
								{id:15, pId:1, name:"房山区"},
								{id:151, pId:15, name:"房山充电桩"},
								{id:16, pId:1, name:"丰台区"},
								{id:161, pId:16, name:"丰台充电桩"},
								{id:2, pId:0, name:"广东省"},
								{id:21, pId:2, name:"潮州市"},
								{id:211, pId:21, name:"潮州充电桩"},
								{id:22, pId:2, name:"东莞市"},
								{id:221, pId:22, name:"东莞充电桩"},
								{id:23, pId:2, name:"佛山市"},
								{id:231, pId:23, name:"佛山充电桩"},
								{id:24, pId:2, name:"广州市"},
								{id:241, pId:24, name:"广州充电桩"},
								{id:25, pId:2, name:"河源市"},
								{id:251, pId:25, name:"河源充电桩"},
								{id:26, pId:2, name:"惠州市"},
								{id:261, pId:26, name:"惠州充电桩"},
								{id:3, pId:0, name:"湖南省"},
								{id:31, pId:3, name:"长沙市"},
								{id:311, pId:31, name:"长沙充电站"},
							 ];
							$.fn.zTree.init($("#ztree4"), setting, zNodes);
		    		}
		    	};
		    	
		    	//新增
		    	add.init();
		    	update.init();
		    	bill.init();
		    	area.init();
		    });
		</script>
	</body>
</html>
