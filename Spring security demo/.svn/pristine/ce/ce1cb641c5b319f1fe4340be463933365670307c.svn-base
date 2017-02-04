<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>组织机构</title>
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
							<li title="组织机构">组织机构</li>
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
													<option>全部组织</option>
													<option>广东兴国</option>
													<option>江门兴国</option>
													<option>佛山兴国</option>
													<option>深圳兴国</option>
													<option>厦门兴国</option>
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
								</th>
								<th>序号</th>
								<th>组织名称</th>
								<th>组织简称</th>
								<th>法人代表</th>
								<th>组织电话</th>
								<th>组织邮箱</th>
								<th>详细地址</th>
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
								<td>江门兴国</td>
								<td>JMXG</td>
								<td>陈冠华</td>
								<td>18745112353</td>
								<td>15422541@163.com</td>
								<td>光谱西路3号</td>
								<td>2015-10-09 10:13:12</td>
								<td>无</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>2</td>
								<td>广东兴国</td>
								<td>GZXG</td>
								<td>陈冠华</td>
								<td>18745112353</td>
								<td>15422541@163.com</td>
								<td>光谱西路3号</td>
								<td>2015-10-09 10:13:12</td>
								<td>无</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>3</td>
								<td>广东兴国</td>
								<td>GZXG</td>
								<td>陈冠华</td>
								<td>18745112353</td>
								<td>15422541@163.com</td>
								<td>光谱西路3号</td>
								<td>2015-10-09 10:13:12</td>
								<td>无</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>4</td>
								<td>广东兴国</td>
								<td>GZXG</td>
								<td>陈冠华</td>
								<td>18745112353</td>
								<td>15422541@163.com</td>
								<td>光谱西路3号</td>
								<td>2015-10-09 10:13:12</td>
								<td>无</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>5</td>
								<td>广东兴国</td>
								<td>GZXG</td>
								<td>陈冠华</td>
								<td>18745112353</td>
								<td>15422541@163.com</td>
								<td>光谱西路3号</td>
								<td>2015-10-09 10:13:12</td>
								<td>无</td>
							</tr>
							<tr>
								<td class="ruleSet_td tab-checkbox">
									<input type="checkbox" name="select" value="" />
									<input type="radio" name="single" value="" />
								</td>
								<td>6</td>
								<td>广东兴国</td>
								<td>GZXG</td>
								<td>陈冠华</td>
								<td>18745112353</td>
								<td>15422541@163.com</td>
								<td>光谱西路3号</td>
								<td>2015-10-09 10:13:12</td>
								<td>无</td>
							</tr>
						</tbody>
						<!--分页 stars-->
						<tfoot>
							<tr>
								<td colspan="10">
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
												<button  type="button" class="btn btn-warning" title="删除" onclick="xconfirm('确定删除选中组织及其子部门？')">
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
								<td>企业名称</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>企业简称</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>企业邮箱</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>企业电话</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>法人代表</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>详细地址</td>
								<td class="textarea">
									<textarea class="form-control" placeholder="请输入"></textarea>
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
								<td>企业名称</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>企业简称</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>企业邮箱</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>企业电话</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>法人代表</td>
								<td>
									<input class="form-control" type="text" placeholder="请输入"/>
								</td>
							</tr>
							<tr>
								<td>详细地址</td>
								<td class="textarea">
									<textarea class="form-control" placeholder="请输入"></textarea>
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
		</script>
	</body>
</html>

