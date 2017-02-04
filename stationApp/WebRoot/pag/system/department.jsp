<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>部门管理</title>
	</head>

	<body>
		<div class="module">
			<!--左侧工具栏 stars-->
			<div class="tool_left" id="monmenu">
				<div class="title"><a href="javascript:;"><span class="icon glyphicon glyphicon-chevron-left" id="slidicon"></span></a></div>
				<div class="tool" id="options">
					<ul id="pSubMenu">
						<li><a class="add" href="javascript:;" data-toggle="tooltip" data-trigger="hover" data-placement="right" title="新建" onclick="openpop(this)" ><i class="icon glyphicon glyphicon-plus"></i>新建</a></li>
						<li><a class="update" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="修改" onclick="optsedit(this,'radio')"><i class="icon glyphicon glyphicon-pencil"></i>修改</a></li>
						<li><a class="del" href="javascript:;" data-toggle="tooltip" data-placement="right" data-trigger="hover" title="删除" onclick="optsedit(this,'checkbox')"><i class="icon glyphicon glyphicon-trash"></i>删除</a></li>
					</ul>
				</div>
			</div>
			<!--end 左侧工具栏-->
			<div class="contentbox">
				<div class="navBar navBar_bg">
					<div class="breadCrumb">
						<ol>
							<li title="系统管理">系统管理</li>
							<li title="部门管理">部门管理</li>
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
												<label for="select_province" class="input-group-addon">组织名称</label>
												<select class="form-control">
													<option>请选择</option>
													<option>全部</option>
													<option>广州兴国</option>
													<option>深圳兴国</option>
													<option>佛山兴国</option>
													<option>江门兴国</option>
												</select>
											</div>
											<div class="input-group input-group-sm">
												<label for="select_province" class="input-group-addon">部门名称</label>
												<select class="form-control">
													<option>请选择</option>
													<option>研发部</option>
													<option>人力行政</option>
													<option>客服部</option>
													<option>工程部</option>
													<option>财务部</option>
													<option>营销部</option>
												</select>
											</div>
											<div class="input-group input-group-sm">
												<span class="input-group-addon">创建日期</span>
												<input type="text" class="form-control timeTip" placeholder="请选择时间">
												<span class="input-group-addon">-至-</span>
												<input type="text" class="form-control timeTip" placeholder="请选择时间">
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
									<input type="checkbox" placeholder="" id="checkbox_all" value="">
								</th>
								<th>序号</th>
								<th>组织名称</th>
								<th>部门名称</th>
								<th>上级部门</th>
								<th>优先等级</th>
								<th>创建时间</th>
								<th>备注</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>1</td>
								<td>广州兴国</td>
								<td>研发部</td>
								<td>广州兴国</td>
								<td>1</td>
								<td>2015-10-09 10:13:12</td>
								<td>产品研发</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>2</td>
								<td>广州兴国</td>
								<td>研发部</td>
								<td>广州兴国</td>
								<td>1</td>
								<td>2015-10-09 10:13:12</td>
								<td>产品研发</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>3</td>
								<td>广州兴国</td>
								<td>研发部</td>
								<td>广州兴国</td>
								<td>1</td>
								<td>2015-10-09 10:13:12</td>
								<td>产品研发</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>4</td>
								<td>广州兴国</td>
								<td>研发部</td>
								<td>广州兴国</td>
								<td>1</td>
								<td>2015-10-09 10:13:12</td>
								<td>产品研发</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>5</td>
								<td>广州兴国</td>
								<td>研发部</td>
								<td>广州兴国</td>
								<td>1</td>
								<td>2015-10-09 10:13:12</td>
								<td>产品研发</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>6</td>
								<td>广州兴国</td>
								<td>研发部</td>
								<td>广州兴国</td>
								<td>1</td>
								<td>2015-10-09 10:13:12</td>
								<td>产品研发</td>
							</tr>
						</tbody>
						<!--分页 stars-->
						<tfoot>
							<tr>
								<td colspan="8">
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
												<button  type="button" class="btn btn-warning" title="删除" onclick="xconfirm('确定删除选中部门及其子部门？')">
													<span class="ico"><i class="iconfont icon-cg"></i></span><span class="iconchar">删除</span>
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
		<!--添加-->
		<div class="xform" id="add" >
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
								<td>部门名称</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>上级部门</td>
								<td class="tree">
									<input class="form-control" type="text" onclick="fjs.tree(this);"/>
									<div>
										<ul id="ztree1" class="ztree"></ul>
									</div>
								</td>
							</tr>
							<tr>
								<td>优先级</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>备注</td>
								<!--textarea注意   成对标签不要换行！换行的话会把空标签添加到文本值里面去-->
								<td class="textarea">
									<textarea class="form-control"></textarea>
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
				<form class="f_cont">
					<table >
						<tbody>
							<tr>
								<td>部门名称</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>优先级</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>备注</td>
								<!--textarea注意   成对标签不要换行！换行的话会把空标签添加到文本值里面去-->
								<td class="textarea">
									<textarea class="form-control"></textarea>
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
		<script>
			$(".timeTip").datetimepicker({
		    	format: 'yyyy-MM-dd',
		    	minView:'month',
		 		language:  'zh-CN',
				autoclose: 1,
		    });
		    
		    $(function(){
		    	//添加部门
		    	var add={
		    		init:function(){
		    			this.tree();
		    		},
		    		tree:function(){
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
									$("#"+treeNode.tId).closest(".ztree").closest("div").fadeOut("fast").prev().val(treeNode.name);
								}
							}
						};
						var zNodes =[
							{id:1, pId:0, name:"研发部"},
							{id:11, pId:1, name:"软件开发"},
							{id:12, pId:1, name:"硬件开发"},
							{id:2, pId:0, name:"产品管理部"},
							{id:21, pId:2, name:"售前"},
							{id:22, pId:2, name:"售后"},
							{id:23, pId:2, name:"产品"},
							{id:3, pId:0, name:"市场营销部"},
							{id:31, pId:3, name:"业务"},
							{id:32, pId:3, name:"客户"},
							{id:4, pId:0, name:"战略策划部"},
							{id:41, pId:4, name:"市场推广"},
							{id:42, pId:4, name:"文案编辑"},
							{id:43, pId:4, name:"活动策划"},
							{id:44, pId:6, name:"平面设计"},
							{id:5, pId:0, name:"人力资源部"},
							{id:51, pId:5, name:"人事"},
							{id:52, pId:5, name:"行政"},
							{id:6, pId:0, name:"财资部"},
							{id:61, pId:5, name:"财务"},
							{id:62, pId:5, name:"采购"},
							{id:63, pId:5, name:"仓库"}
						 ];
						$.fn.zTree.init($("#ztree1"), setting, zNodes);
		    		}
		    	};
		    	add.init();
			});
		</script>
	</body>
</html>

