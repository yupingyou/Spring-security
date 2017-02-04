/*后台业务*/
var pagination={
	//加载分页html	
	load:function(data,dom){
		if(data.pageCount==0){
			/* 查不到数据 */
			html="";
		}else{
			if(data.pageNo==1){
				html="<li class='disabled'>"+
				 "<a href='javascript:;'>首页</a>"+
				 "</li>"+
				 "<li class='prev disabled'>"+
				    "<a href='javascript:;'><span>上一页</span></a>"+
				 "</li>";	
			}else{
				html="<li class='start'>"+
				 "<a href='javascript:;'>首页</a>"+
				 "</li>"+
				 "<li class='prev'>"+
				    "<a href='javascript:;'><span>上一页</span></a>"+
				 "</li>";
			}
			
			if(data.pageCount<=5){
				for(var i=1;i<=data.pageCount;i++){
					if(data.pageNo==i){
						html+="<li class='leaf active'>"+
								  "<a href='javascript:;'>"+i+"</a>"+
								  "</li>";
					}else{
						html+="<li class='leaf'>"+
								  "<a href='javascript:;'>"+i+"</a>"+
								  "</li>";
					}																
				}
			}else{
				if(data.pageNo<4){
					for(var i=1;i<=5;i++){					
						if(data.pageNo==i){
							html=html+"<li class='leaf active'>"+
									  "<a href='javascript:;' >"+i+"</a>"+
								 	  "</li>";
						}else{
							html=html+"<li class='leaf'>"+
									  "<a href='javascript:;' >"+i+"</a>"+
									  "</li>";
						}	
					}
				}else if(data.pageNo+2>data.pageCount){
					for(var i=data.pageCount-4;i<=data.pageCount;i++){					
						if(data.pageNo==i){
							html=html+"<li class='leaf active'>"+
									  "<a href='javascript:;'>"+i+"</a>"+
									  "</li>";
						}else{
							html=html+"<li class='leaf'>"+
									  "<a href='javascript:;'>"+i+"</a>"+
									  "</li>";
						}	
					}
				}else{
					for(var i=data.pageNo-2;i<=data.pageNo+2;i++){
						if(data.pageNo==i){
							html=html+"<li class='leaf active'>"+
									  "<a href='javascript:;' >"+i+"</a>"+
									  "</li>";
						}else{
							html=html+"<li class='leaf'>"+
									  "<a href='javascript:;' >"+i+"</a>"+
									  "</li>";
						}	
					}
				}
			}
			
			if(data.pageNo==data.pageCount){
				html+="<li class='next disabled'>"+
				  "<a href='javascript:;'><span>下一页</span></a>"+
			      "</li>"+
				  "<li class='disabled' id='"+data.pageCount+"'>"+
				  "<a href='javascript:;'>尾页</a>"+
				  "</li>";		
			}else{
				html+="<li class='next'>"+
				  "<a href='javascript:;'><span>下一页</span></a>"+
				  "</li>"+
				  "<li class='end' id='"+data.pageCount+"'>"+
				  "<a href='javascript:;'>尾页</a>"+
				  "</li>";	
			}
			
		} 
		html=html+"<span class='fany'>&nbsp;第 "+data.pageNo+" 页 &nbsp;|&nbsp;共 "+data.pageCount+" 页</span>";				
		$(dom).html(html);
		//上一页 下一页
		$(dom).find(".prev").click(function(){
			var active=$(dom+" .active");
			if(active.prev().text()!=$(this).text()){
				active.prev().trigger("click");
			}
		});
		$(dom).find(".next").click(function(){
			var active=$(dom+" .active");
			if(active.next().text()!=$(this).text()){
				active.next().trigger("click");
			}
		});
		}
	};
var xgTree={
	//菜单树Tree
	buildTree : function() {
		$.ajax({
				url : treeUrl,
				data : null,
				dataType : 'json',
				async : false,
				cache : false,
				success : function(data) {
				var a="";
				$.each(data.provinceList,function(i,pro){
					a+="<li class='itemP'><a class='pa' href='javascript:;'><span class='iconP liconP'></span><span>"+pro+"</span></a><ul class='itemsC'>";
				$.each(data.cityList[i],function(j,city){
					a+="<li class='itemC'><a class='ca' href='javascript:;'><span class='iconC liconC'></span><span>"+city+"</span></a><ul class='sites'>";
				$.each(data.cdzList,function(z,cdz){
					if(city==cdz.city){
						a+="<li class='site'><a class='sa' href='javascript:;' id='"+cdz.id+"' data-chargingId='"+cdz.chargingId+"'><span class='iconS'></span><span>"+cdz.sideName+"</span></a></li>";
					}		
				});
					a+="</ul></li>";
				});
					a+="</ul></li>";
				});
					$(".itemsP").html(a);	
				}
		});
	}
};
/*业务公用方法*/
var comm={
		//根据checkbox的name值,检测多选框是否为空，
		//不为空，返回checkbox的value值集合ids
	checkbox:function(name){
		arr = $("[name="+name+"]");
		ids=[];
		for ( var i = 0; i < arr.length; i++) {
			if (arr[i].checked == true) {
				ids.push($(arr[i]).data("id"));
			}
		}
		if (ids == "") {
			xalert("请至少选择一条记录!");
			return false;
		}else{
			return ids;
		}
	},
	//调用复制：comm.btnselect(".p_ul",".p_con");
	//按钮菜单的下拉框的值替换  jqery对象
	btnselect:function(ul,targer){
		$(ul).each(function(index,lidom){
			$(this).on("click","li",function(){
				$(targer).eq(index).text($(this).text());
				$(targer).eq(index).prev().val($(this).text());
				if($(this).data("value")!=undefined&&$(this).data("value")!=null){
					$(targer).eq(index).prev().val($(this).data("value"));
				}
			});
		});
	},
	//省市级联下拉 //comm.pcselect("#pdata1","#cdata1",pcdata);
	//格式pcdata={"data":[{"p":"北京","c":["北京市"]},{"p":"天津","c":["天津市"]},{"p":"上海","c":["上海市"]},{"p":"重庆","c":["重庆市"]},
	pcselect:function(pid,cid,data){
			$(pid+" button").click(function(){
				var html = "";
				data.data.forEach(function(i,index,all){
					html+="<li><a href='javascript:;'>"+i.p+"</a></li>";
				});
				$(cid+" input").val("");
				$(pid+" ul").html(html);
				$(cid+" .p_con").html("请选择");
				comm.btnselect(pid+" .p_ul",pid+" .p_con");
			});
			
			$(cid+" button").click(function(){
				if($(pid+" .p_con").text().trim()=="请选择")return;
				var html = "";
				data.data.forEach(function(i,index,all){
					if(i.p==$(pid+" .p_con").text().trim()){
						i.c.forEach(function(j){
							html+="<li><a href='javascript:;'>"+j+"</a></li>";
						});
						$(cid+" ul").html(html);
						comm.btnselect(cid+" .p_ul",cid+" .p_con");
					}
					return;
				});
			});
	},
	/**模板格式:
	 * <ul>
				<li class="filter_li heg48" id="markTarget">
					<button class="btn btn-warning btn-sm put">导出Excel</button>
				</li>
				<li class="filter_li" id="mark">
					<div class="filter_font">选项：</div>
						<a class="filter_fa" href="javascript:;">省份</a>
						<a class="filter_fa" href="javascript:;">城市名称</a>
	 *
	 id:点击的父容器ID
	 targetid:目标元素父容器元素ID addmark("#mark","#markTarget")
	 */
	addmark:function(id,targetid){
		$(id+" .filter_fa").click(function(){
			var $this = this;
			if($(targetid).text().indexOf($(this).text())==-1){
				$(this).addClass("filter_fafocus");
				var tempdom =$("<div />")
				tempdom.html("<button class='btn btn-danger btn-sm' type='button'>"+$(this).text()+"<span class='close close_mgl'>&times;</span></button>");
				tempdom.find(".close").click(function(){
					$(this).closest("button").fadeOut(function(){
						$(this).remove();
					});
					$($this).removeClass("filter_fafocus");
				});
				$(targetid).append(tempdom.children());
			}
		});
	},
	removeMark:function(id,targetid){
		$(targetid).html("");
		$(id+" a").each(function(){
			$(this).removeClass("filter_fafocus");
		});
	},
};

/*
 表单js
 * */
var fjs={
	init:function(){
		this.file.init();
	},
	tree:function(dom){
		$("body").on("click",hideTree);
		$(".xform .f_cont").on("scroll",hideTree);
		var offset = $(dom).offset(); 
		$(dom).next().css({left:offset.left, top:offset.top + $(dom).outerHeight(),width:$(dom).outerWidth()}).slideDown("fast");
		function hideTree(event) {
			if (!(event.target == dom || $(event.target).closest(".ztree").length>0)) {
				$(dom).next().hide();
				$("body").unbind("click", hideTree);
				$(".xform .f_cont").unbind("scroll",hideTree);
			}
		}
	},
	file:{
		init:function(){
			this.imgclick();
			this.targ();
		},
		targ:function(){
			var $this =this;
			$("body")[0].ondragover=function(e){
				console.log($(e.target).closest(".js_drag").length)
				if($(e.target).closest(".js_drag").length>0){
					$(e.target).css("background-color","#E6F5FF");
					e.preventDefault();
				}
			}
			$("body")[0].ondrop=function(e){
				if($(e.target).closest(".js_drag").length>0){
					e.preventDefault();
					$(e.target).css("background-color","#fff");
					var files =Array.prototype.slice.call(e.dataTransfer.files);
					$this._main(files,$(e.target).closest(".js_drag"));
				}
			}
		},
		imgclick:function(){
			var $this = this;
			$("body").on("change",".js_files",function(){
				var files =Array.prototype.slice.call(this.files);
				$this._main(files,this);
			});
		},
		_main:function(files,dom){
				//1.filter
				//2.加载模板
				//3.赋予事件
				var $this = this;
				var $dom=dom;
				var maxsize=512000;
				var notImg=[];
				//过滤掉不是img
				var files=files.filter(function(file,index,all){
					if (file.type.indexOf("image")==0&&file.size<=maxsize){
						return true;
					}else{
						notImg.push(file.name);
						return false;
					}
				});
				//提示
				if(notImg.length>0){
					xalert("抱歉，以下文件读取失败:<br>"+notImg.join("<br>")+"<br>请选择小于500KB的\"图片文件\"哇~");
				}
				if(files.length>0){
					var parent=$($dom).closest(".files");
					parent.find(".f_des").addClass("hide");
					parent.find(".js_files")[0].disabled = true;
					parent.find(".js_files")[0].files = null;
					parent.find(".js_files")[0].value = null;
					xloading.init(parent[0]);
					//加载模板
					$.each(files, function(index,file) {
						//读取图片url
						//加载li
						//绑定事件
						$this._html(file,parent.find(".js_fileList"),function(){
							//file属性赋予
							parent.find(".js_fileList li").last().find("input[name='file']")[0].files[0]=file;
							//绑定事件
							$this.bindevent(parent.find(".js_fileList li").last());
						});
					});
				}
		},
		/*
		 file:文件
		 targetul:模板添加的目标位置
		 * */
		_html:function(file,targetul,cllBack){
			var $this=this;
			this._getImgURL(file,function(url){
				var html="<li class='f_itemfile'>"+
												"		<div class='f_info'>"+
												"			<span class='f_file'>"+
												"				<img data-view='true' src='"+url+"'/>"+
												"			</span>"+
												"			<span class='f_name'>"+file.name +"("+$this._fmtFileSize(file.size)+")</span>"+
												"		</div>"+
												"		<div class='f_opts'>"+
												"			<label>"+
												"			<span class='text-info cur'>重新选择</span>"+
												"			<input class='hide js_reset' type='file' name='file'/>"+
												"			</label>"+
												"			<a href='javascript:;' class='text-danger js_close'>删除</a> |"+
												"			<a href='javascript:;' class='text-warning js_add'>再次添加</a>"+
												"		</div>"+
												"	</li>";
				targetul.append(html);
				cllBack&&cllBack();
				xloading.destroy();
			});
		},
		/*
		 targetli绑定li元素下面的三个事件js_reset js_close js_add
		 * */
		bindevent:function(targetli){
		var $this =this;
			//重新选择
			targetli.find(".js_reset").change(function(){
					var file =this.files[0];
					$this._getImgURL(file,function(url){
						//改名字
						targetli.find(".f_name").html(file.name +"("+$this._fmtFileSize(file.size)+")");
						//改图片路径
						targetli.find(".f_file").children().attr("src",url);
					});
				});
			//删除
			//如果删除到0条  就让他显示出来出来多个选项框
				targetli.find(".js_close").click(function(){
					var parent=$(targetli).closest(".files");
					var filesList=targetli.parent();
					targetli.remove();
					if(filesList.children().length==0){
						parent.find(".js_files")[0].disabled = false;
						parent.find(".f_des").removeClass("hide");
					}
				});
			//再次添加
			targetli.find(".js_add").click(function(){
				var $dom = this;
				var file =$("<input type='file' name='file'>");
					file.trigger("click");
					file.change(function(){
						var file =this.files[0];
						$this._html(file,$($dom).closest(".files").find(".js_fileList"),function(){
						//file属性赋予
						$($dom).closest(".files").find(".js_fileList li").last().find("input[name='file']")[0].files[0]=file;
						//绑定事件
						$this.bindevent($($dom).closest(".files").find(".js_fileList li").last());
					});
				});
			});
		},
		_getImgURL:function(file,callBack){
			if(window.FileReader){
				var fr = new FileReader();
				fr.readAsDataURL(file);
				fr.onload = function(e){
					callBack&&callBack(e.target.result);
				}
			}else{
				xalert("您的浏览器版本过低，操作失败");
			}
		},
		/**
		 * ("B","KB","MB","GB");
		 * 1G=1024MB  1MB=1024KB 1KB=1024字节
		 * */
		_fmtFileSize:function (size){
			var kb=1024,
					MB=1024*1024,
					GB=1024*1024*1024;
			if(size<kb){
				return size+" B";
			}else if((kb <= size) && (size < MB)){
				return (size/kb).toFixed(3)+" KB";
			}else if(MB <= size && (size < GB)){
				return (size/MB).toFixed(2)+" MB";
			}else if(GB <= size){
				return (size/GB).toFixed(1)+" GB";
			}
		}
	}
}
/*工具类*/
/**
 * 判断非空
 * 
 * @param val
 * @returns Boolean
 */
function isEmpty(val) {
	val = $.trim(val);
	if (val == null)
		return true;
	if (val == undefined || val == 'undefined')
		return true;
	if (val == "")
		return true;
	if (val.length == 0)
		return true;
	if (!/[^(^\s*)|(\s*$)]/.test(val))
		return true;
	return false;
}

/*非空判断*/
function isNotEmpty(val) {
	return !isEmpty(val);
}
/*对页面元素的操作*/
var dom={
	//元素居中  js对象
	center:function(dom,str){
		dom.style.left=document.documentElement.clientWidth/2-dom.offsetWidth/2+"px";
		if(str!="top"){
			dom.style.top=document.documentElement.clientHeight/2-dom.offsetHeight/2+"px";
		}else{
			dom.style.top=(document.documentElement.clientHeight-dom.offsetHeight)/3+"px";
		}
	}
};
/*对象拓展*/
/**
 * 对Date的扩展，将 Date 转化为指定格式的String 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q)
 * 可以用 1-2 个占位符 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) eg: (new
 * Date()).format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 (new
 * Date()).format("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04 (new
 * Date()).format("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04 (new
 * Date()).format("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04 (new
 * Date()).format("yyyy-M-d h:m:s.S q ") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.format = function(fmt) {
	var o = {
		"Y+" : this.getFullYear(),
		"M+" : this.getMonth() + 1,
		// 月份
		"d+" : this.getDate(),
		// 日
		"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
		// 小时
		"H+" : this.getHours(),
		// 小时
		"m+" : this.getMinutes(),
		// 分
		"s+" : this.getSeconds(),
		// 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		// 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	var week = {
		"0" : "日",
		"1" : "一",
		"2" : "二",
		"3" : "三",
		"4" : "四",
		"5" : "五",
		"6" : "六"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt
				.replace(
						RegExp.$1,
						((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
								: "/u5468")
								: "")
								+ week[this.getDay() + ""]);
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
};

/**
 * 将form表单转化为json对象
 */
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if(o[this.name]) {
			if(!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
/**
 * 将json对象转化为URl参数字符串
 * @param {Object} param
 * @param {Object} key
 */
var parseParam=function(param, key){
    var paramStr="";
    if(param instanceof String||param instanceof Number||param instanceof Boolean){
        paramStr+="&"+key+"="+encodeURIComponent(param);
    }else{
        $.each(param,function(i){
            var k=key==null?i:key+(param instanceof Array?"["+i+"]":"."+i);
            paramStr+='&'+parseParam(this, k);
        });
    }
    return paramStr.substr(1);
};

/*组件*/

/*
	时间：2017年1月16日
	版本：1.0
	作者：小艾
	依赖：bootstrap的XX按钮一枚。
	描述：图片预览插件
	用法     调用   ximgshow();  后整个body类的img标签 有data-view='true'属性  都可以点击预览。作用格式：
	<img src="img/login.jpg" data-view='true' alt="" class="img-responsive" />
 * */
(function(win){
	var preview={
		init:function(){
			var $this = this;
			$("body").on("click","img[data-view='true']",function(){
				$this.getmain(this);
			});
		},
		getmain:function(dom){
			var imgbox = $("<div>");
			var img = $("<img>").attr("src",$(dom).attr("src"));
			var closebtn=$("<div>");
			imgbox[0].style.cssText="display:none;position: fixed;width: 100%; height: 100%; left:0;top:0;background: rgba(0,0,0,0.5); z-index: 999;";
			closebtn[0].style.cssText="position: absolute;right:5px;top:8px;cursor:pointer;width: 36px;height:36px;background-color:#393A3C;transition:background-color 0.3s linear;border-radius: 50%;font-size: 22px;line-height: 36px;color: #fff;text-align: center;";
			closebtn.addClass("glyphicon glyphicon-remove").attr("title","关闭");
			img[0].style.cssText="position: absolute;left:0;top:0;cursor:pointer;max-height:100%;max-width:100%;";
			closebtn.hover(function(){
				$(this).css("background-color","#D43F27");
			},function(){
				$(this).css("background-color","#393A3C");
			})
			imgbox.append(img);
			imgbox.append(closebtn);
			$("body").append(imgbox);
			imgbox.fadeIn();
			//居中
			this._center(img[0]);
			//移动窗口居中
			this._reize(img[0]);
			//点击关闭
			this._close(imgbox);
		},
		_center:function(dom,str){
			dom.style.left=document.documentElement.clientWidth/2-dom.offsetWidth/2+"px";
			if(str!="top"){
				dom.style.top=document.documentElement.clientHeight/2-dom.offsetHeight/2+"px";
			}else{
				dom.style.top=(document.documentElement.clientHeight-dom.offsetHeight)/3+"px";
			}
		},
		_reize:function(dom){
			var $this = this;
			$(window).resize(function(){
				$this._center(dom);
			});
		},
		_close:function(dom){
			dom.click(function(e){
				console.log(e.target.tagName)
				if(e.target.tagName!="IMG"){
					$(this).fadeOut(function(){
						$(this).remove();
					});
				}
			});
		}
	}
	window.ximgshow=function(){
		preview.init();
	};
})(window);
/*
	时间：2016-8-2
	版本：1.0
	作者：小艾
	面向对象音乐组件
*/
var XaMusic=(function(){
	function Music(){
		this.index=0;
		this.audioDom=null;
		this.songs=[];//音频源文件存储容器
	}
	Music.prototype={
		constructor:Music,
		init:function(){
			this.audioDom=document.createElement("audio");
			this.audioDom.volume=0.5;//声音0.5
			//this.ended("listLoop");
			
		},
		add:function(musicArr){
			//讲音乐放入的音乐容器中
			this.songs=musicArr;
			//默认播放第一首
			if(!this.audioDom.src)this.audioDom.src=this.songs[0].src;
		},
			//播放/暂停音乐
		play:function(callback){
			this.audioDom.play();
			if(callback)callback(this.index);
		},
			//暂停音乐
		stop:function(callback){
			this.audioDom.pause();
			if(callback)callback(this.index);
		},
		//声音控制
		sound:function(val){
			this.audioDom.volume=val;
		},
		//静音
		muted:function(){
			this.audioDom.muted=!this.audioDom.muted;
		},
		//进度展示  返回类型说明
		/*
		json.per 播放百分比 2位有效位
		json.rawcur 原始当前播放时间  秒
		json.cur 格式化后的当前播放时间 m:s
		json.rawSTime 原始剩余播放时间  秒
		json.sTime  格式化后的剩余播放时间
		json.rawTot  原始播放总时长   秒
		json.tot  格式化后的播放总时长   m:s
		*/
		progress:function(callback){
			var json={};
			var $this = this;
			$this.audioDom.oncanplaythrough = function(){
				//获取播放器的总时长
				json.rawTot = this.duration;
				//格式化时长
				json.tot =Music.formateTime(json.rawTot);
			if(callback)callback.call(json);
			};
			$this.audioDom.ontimeupdate=function(){
				//计算播放中的时间进度
				json.rawcur=this.currentTime;
				json.per = ((this.currentTime/this.duration)*100).toFixed(2);
				//用总时长减去播放去时长获取剩余的时间
				json.rawSTime = this.duration - this.currentTime;
				//格式化时间
				json.sTime = Music.formateTime(json.rawSTime);
				json.cur = Music.formateTime(this.currentTime);
				//定义返回
			if(callback)callback.call(json);
			}
		},
		//上一首
		pre:function(callback){
			this.index=this.index==0?0:--this.index;
			this.changeplay();
			if(callback)callback(this.index);
		},
		//下一首
		next:function(callback){
			this.index=this.index==this.songs.length-1?this.index:++this.index;
			this.changeplay();
			if(callback)callback(this.index);
		},
		//变更歌曲调用
		changeplay:function(){
			this.audioDom.src=this.songs[this.index].src;
			this.audioDom.play();
		},
		//页面点击播放
		selectplay:function(index,callback){
			this.index=index;
			this.audioDom.src=this.songs[this.index].src;
			this.audioDom.play();
			if(callback)callback(index);
		},
		//控制播放顺序
		//aLoop:单曲循环
		//listLoop:列表循环
		//randomLoop:随机播放
		ended:function(src,callback){
			var $this=this;
			this.audioDom.onended=function(){
			if(src=="aLoop"){
				$this.audioDom.loop=true;
			}else if(src=="listLoop"){
				$this.index=++$this.index;
				if($this.index==$this.songs.length){
					$this.index=0;
				}
				$this.changeplay();
			}if(src=="randomLoop"){
				$this.index=Math.floor(Math.random()*$this.songs.length)
				$this.changeplay();
			}
			if(callback)callback($this.index);
			}
		}
	}
	//格式化时间  静态方法
	Music.formateTime=function(time){
		var m = parseInt(time / 60);
		var s = parseInt(time % 60);
		var time = (m<10?("0"+m):m)+":"+(s<10?("0"+s):s);
		return time;
	}
	return Music;
})();
/*组件*/
/*
	时间：2016-8-15
	版本：1.0
	作者：小艾
	拖拽组件
*/
(function(win){
var index=0;//全局用来控制显示层级关系
var drag={
	default:{
		dir:"",//方向 x  y
		proxyChild:"",//代理子类的下标  从0开始
		ghost:"",//是否开启镜像  true  false
		callbackDur:"",//mousemove过程中的回调函数  
		callbackEnd:""//mouseup停止拖拽后的回调函数
		},
	init:function(json){
		//混入
		var json=this._mix({},this.default,json);
		var $this=this;
		var result={};
		var mainDom=json.dom;
		if(json.proxyChild||json.proxyChild=="0"){
			json.dom=json.dom.children[json.proxyChild]
		}
		json.dom.onmousedown=function(e){
			var e= e || window.event;
			var pos=$this._getXY(e);
			var x=pos.pageX-mainDom.offsetLeft;
			var y=pos.pageY-mainDom.offsetTop;
			//处理层级关系
			mainDom.style.zIndex=++index;
			var ghostDom = null;
			if(json.ghost){
				ghostDom = $this._getGhost(mainDom)
				mainDom.offsetParent.appendChild(ghostDom);
			};
			document.onmousemove=function(e){
				var e= e || window.event;
				pos=$this._getXY(e);
				//边界判断 拖拽点的元素的offsetWidth和offsetHeight
				var l,t;
				var l=pos.pageX-x;
				var t=pos.pageY-y;
				if(l<0)l=0;
				if(t<0)t=0;
				//这里有点特殊   ie的body.clientHeight是等于0的  如果等于0就让它找上一级的html.clientHeight
				if(mainDom.offsetParent.clientHeight){
					if(l>mainDom.offsetParent.clientWidth-mainDom.offsetWidth){
						l=mainDom.offsetParent.clientWidth-mainDom.offsetWidth;
					}
					if(t>mainDom.offsetParent.clientHeight-mainDom.offsetHeight){
						t=mainDom.offsetParent.clientHeight-mainDom.offsetHeight;
					}
				}else{
					if(l>mainDom.offsetParent.parentElement.clientWidth-mainDom.offsetWidth){
						l=mainDom.offsetParent.parentElement.clientWidth-mainDom.offsetWidth;
					}
					if(t>mainDom.offsetParent.parentElement.clientHeight-mainDom.offsetHeight){
						t=mainDom.offsetParent.parentElement.clientHeight-mainDom.offsetHeight;
					}
				}
				if(json.dir=="x"){
					(ghostDom||mainDom).style.left=l+"px";
				}else if(json.dir=="y"){
					(ghostDom||mainDom).style.top=t+"px";
				}else{
					(ghostDom||mainDom).style.left=l+"px";
					(ghostDom||mainDom).style.top=t+"px";
				}
				result.left=l;
				result.top=t;
				result.dom=mainDom;
				if(json.callbackDur)json.callbackDur.call(result);
			}
			document.onmouseup=function(){
				if(json.ghost){
					mainDom.offsetParent.removeChild(ghostDom);
					mainDom.style.left=result.left+"px";
					mainDom.style.top=result.top+"px";
				};
				if(json.callbackEnd)json.callbackEnd.call(result);
				this.onmousemove=null;
				this.onmouseup=null;
			}
		}
	},
	//获取拖拽镜像
	_getGhost:function(mainDom){
		var cloneDom = mainDom.cloneNode(true);
		cloneDom.style.opacity= "0.5";
		return cloneDom;
	},
	//检验是否碰撞
	_pengZhuang:function(dom1,dom2){
		var T1=dom1.offsetTop;
		var R1=dom1.offsetLeft+dom1.offsetWidth;
		var B1=dom1.offsetTop+dom1.offsetHeight;
		var L1=dom1.offsetLeft;

		var T2=dom2.offsetTop;
		var R2=dom2.offsetLeft+dom1.offsetWidth;
		var B2=dom2.offsetTop+dom1.offsetHeight;
		var L2=dom2.offsetLeft;
		if(T2>=B1||R2<=L1||B2<=T1||L2>=R1){
			return false;
		}else{
			return true;
		}
	},
	//获取碰撞数组中距离最近的dom
	_getMixPDom:function getMixPDom(dom,arr){
			//var mixDom=[dom,index,distance]
			var mixDom=[];
			for(var i in arr){
				var left=arr[i].offsetLeft-dom.offsetLeft;
				var top=arr[i].offsetTop-dom.offsetTop;
				var temp=Math.sqrt(left*left+top*top);
				mixDom.push({dom:arr[i],index:i,distance:temp});
			}
			//排序
			mixDom.sort(function(a,b){
				return a.distance-b.distance;
			});
			//想要其他值可以方便改
			return mixDom[0];
	},
	//对象混入
	/*
		target：目标，
		datajson：数据
		讲后面对象全部导入目标对象中
	*/
	_mix:function(target,datajson){
		var args = Array.prototype.slice.call(arguments);
		if(args.length==1)return args[0];
		var i = 1 ;
		while(args[i]){//这里做为判断条件 取不到就返回false
			var temp =args[i];
			for(var j in temp){
				if(temp.hasOwnProperty(j)){
				target[j]=temp[j];
				}
			}
			i++;
		}
			return target;
	},
	//获取坐标位置  兼容性写法
	/*
	json.pageX  
	json.pageY  元素到页面顶端的距离
	json.scrollTop  滚动条的距离  当然不包括元素本身的clientHeight
	json.scrollLeft
	json.scrollHeight  滚动条的高度
	json.scrollWidth
	*/
	_getXY:function(e){
		var e = e || window.event;
		var json ={};
		if(e.pageX){
			json.pageX=parseInt(e.pageX);
			json.pageY=parseInt(e.pageY);
		}else{
			//scrollTop和scrollLeft
			if(document.body){
				json.scrollTop=document.body.scrollTop;
				json.scrollLeft=document.body.scrollLeft;
				json.scrollHeight=document.body.scrollHeight;
				json.scrollWidth=document.body.scrollWidth;
			}else{
				json.scrollTop=document.documentElement.scrollTop;
				json.scrollLeft=document.documentElement.scrollLeft;
				json.scrollHeight=document.documentElement.scrollHeight;
				json.scrollWidth=document.documentElement.scrollWidth;
			}
			json.pageX=parseInt(e.clinetX+json.scrollLeft);
			json.pageY=parseInt(e.clinetY+json.scrollTop);
		}
		return json;
	}
};
win.xadrag=drag;
})(window);
/*组件*/
/*
	时间：2016-10-12
	版本：1.0
	作者：小艾
	弹窗组件
	调用:
	win.xalert("cont");//警告框
	win.xconfirm("cont","点击确认的回调函数--function");//确认框
*/
(function(win){
		var xaDialog = {
			//图标数据
			//默认参数
			defaults:{
				width:320,
				height:175,
				overclose:false,//是否开启点击弹出层阴影部分淡出
				title:"提示",
				content:"调用的时候没写内容哦 ~",
				callback:function(){},
				stext:"确定",
				ctext:"取消"
			},
			init:function(options){
				var opts = xaDialog.methods._mix(xaDialog.methods,xaDialog.defaults,options);
				var dialogDom = opts.template(opts);
				opts._center(dialogDom);
				opts._resize(dialogDom);
				opts._events(dialogDom,opts);
				opts._drag(dialogDom);
				return dialogDom;
			},
			alert:function(options){
				var dialogDom = xaDialog.init(options);
				var cbtnDom = dialogDom.querySelectorAll(".dcancle")[0];
				cbtnDom.parentElement.removeChild(cbtnDom);
			},
			confirm:function(options){
				this.init(options);
			},
			prompt:function(options){
				//最好写好静态页面 
			},
	
			iframe:function(options){
				//嵌入页面 iframe
			}
		
		};

	//扩展事件	
	xaDialog.methods = {
		//模板可拓展
		template:function(opts){
			var dialogwin = document.getElementById("xa_dialog");
			if(dialogwin){
				/*删除盒子关闭阴影层*/
				document.body.removeChild(dialogwin.nextElementSibling);
				document.body.removeChild(dialogwin);
			}else{
				dialogwin = document.createElement("div");
				dialogDom = document.createElement("div");
			}
		var html="<div id='xa_dialog' style='background:linear-gradient( to bottom,#30363F 0%,#1F2329 100%); min-width: 320px; min-height: 175px;border-radius: 5px;position:relative;z-index:1002;'>"+
			"  			<div class='tittle' style='height:35px;line-height: 35px;padding-left: 5px;color:#fff;border-bottom:1px solid #222;'>"+opts.title+
			"				<a class='xa_close' href='javascript:;' title='关闭' style='display:inline-block;width:30px;float:right;text-align: center;' onmouseover='this.style.opacity='.8';' onmouseout='this.style.opacity='1';'>"+
			"					<span style='display:inline-block;height: 10px;width: 10px;background: #FF2531;border-radius: 50%;'></span>"+
			"				</a>"+
			"			</div>"+
			"			<div class='cont' style='padding:10px 15px 50px 15px;color:#fff;text-align: justify;font-size: 14px;letter-spacing:1px;'>"+opts.content+
			"			</div>"+
			"			<div class='btns'  style='position: absolute;bottom: 0;height: 40px;line-height:35px;width: 100%;border-radius: 0 0 5px 5px;'>"+
			"				<div class='btn-group-xs' style='text-align: center;'>"+
			"					<button class='btn btn-danger dsure' style='border-radius: 15px;padding:2px 15px;'>"+opts.stext+"</button>"+
			"					<button class='btn btn-danger dcancle' style='border-radius: 15px;padding:2px 15px;margin-left: 10px;'>"+opts.ctext+"</button>"+
			"				</div>"+
			"			</div>"+
			"		</div>";
			dialogwin.id = "xa_dialogbox";
			dialogwin.style.cssText="position:fixed;height:100%;width:100%;top:0px;left:0;background:rgba(0,0,0,0.5);z-index:1001;";
			dialogDom = document.createElement("div");
			dialogDom.innerHTML = html;
			dialogDom = dialogDom.children[0];
			dialogDom.style.width = opts.width+"px";
			dialogDom.style.height = opts.height+"px";
			document.body.appendChild(dialogwin);
			document.body.appendChild(dialogDom);
			return dialogDom;
		},
		/*居中dialog*/
		_center:function(dialogDom){
			var nl = (window.innerWidth - dialogDom.offsetWidth)/2;
			var nt = (window.innerHeight - dialogDom.offsetHeight)/3;
			dialogDom.style.top = nt+"px";
			dialogDom.style.left = nl+"px";
		},
		_resize :function(dialogDom){
			var obj = this;
			window.onresize = function(){
				obj._center(dialogDom);
			};
		},
		/*按钮事件*/
		_events:function(dialogDom,opts){
			/*找到三个按钮对象*/
			var sureDom = this.domClass(dialogDom,"dsure")[0];
			var cancleDom = this.domClass(dialogDom,"dcancle")[0];
			var closeDom = this.domClass(dialogDom,"close")[0];
			var overDom = dialogDom.previousElementSibling;
			/*确定按钮事件*/
			sureDom.onclick = function(e){
				var e = e||window.event;
				$(dialogDom).animate({opacity:0,top:-400},function(){
					document.body.removeChild(dialogDom);
					document.body.removeChild(overDom);
					if(opts.callback)opts.callback();
				});
			};
			
			/*取消按钮事件*/
			cancleDom.onclick = function(e){
				var e = e||window.event;
				$(dialogDom).animate({opacity:0,top:-400},function(){
					document.body.removeChild(dialogDom);
					document.body.removeChild(overDom);
				});
			};
			/*关闭按钮事件*/
			closeDom.onclick = function(e){
				var e = e||window.event;
				$(dialogDom).animate({opacity:0,left:-400},function(){
						document.body.removeChild(dialogDom);
						document.body.removeChild(overDom);
					});
			};
			
			if(opts.overclose){
				/*点击阴影层关闭按钮事件*/
				overDom.onclick = function(){
					$(overDom).animate({opacity:0},function(){
						document.body.removeChild(dialogDom);
						document.body.removeChild(overDom);
					});
				};
			}
		},
		_drag:function(dialogDom){
			$this=this;
			var tittle=dialogDom.querySelectorAll(".tittle")[0];
			tittle.onmousedown = function(e){
				var ev = e || window.event;
				var pos = $this.getXY(ev);
				var nx =pos.x - dialogDom.offsetLeft;
				var ny =pos.y - dialogDom.offsetTop;
				var maxW = window.innerWidth - dialogDom.offsetWidth;
				var maxH = window.innerHeight - dialogDom.offsetHeight;
				document.onmousemove = function(e){
					var ev = e || window.event;
					var pos = $this.getXY(ev);
					var nleft = pos.x - nx; 
					var ntop = pos.y - ny;
					if(nleft<=0)nleft= 0;
					if(ntop<=0)ntop= 0;
					if(nleft>=maxW)nleft = maxW;
					if(ntop>=maxH)ntop =maxH;
					dialogDom.style.left = nleft+"px";
					dialogDom.style.top = ntop+"px";
				};
				document.onmouseup = function(e){
					document.onmouseup = null;
					document.onmousemove  = null;
				};
			};
		},
		_mix:function(target,datajson){
			var args = Array.prototype.slice.call(arguments);
			if(args.length==1)return args[0];
			var i = 1 ;
			while(args[i]){//这里做为判断条件 取不到就返回false
				var temp =args[i];
				for(var j in temp){
					if(temp.hasOwnProperty(j)){
					target[j]=temp[j];
					}
				}
				i++;
			}
				return target;
		},
		domClass:function (domPid,sClass){
			var aEle = (typeof domPid ==="string"?dom(domPid):domPid).getElementsByTagName('*');
			var arrs = [];
			for(var i=0;i<aEle.length;i++){
				if(aEle[i].className.indexOf(sClass)!=-1){
					arrs.push(aEle[i]);
				}
			}
			return arrs;
		},
		getXY:function(e){
			var ev = e || window.event;
			var x=0,y=0;
			if(ev.pageX){
				x = ev.pageX;
				y = ev.pageY;
			}else{
				/*拿到scrollTop 和scrollLeft*/
				var sleft = 0,stop = 0;
				/*ie678---*/
				if(document.documentElement){
					stop =document.documentElement.scrollTop;
					sleft = document.documentElement.scrollLeft;
				}else{
				//ie9+ 谷歌 
					stop = document.body.scrollTop;
					sleft = document.body.scrollLeft;
				}	
				x = ev.clientX + sleft;
				y = ev.clientY + stop;
			}
			return {x:x,y:y};
		}
	};
	win.xalertx = xaDialog.alert;
	win.xconfirmx = xaDialog.confirm;
	//win.xprompt = xaDialog.prompt;
	//win.xiframe = xaDialog.iframe;
	win.xalert=function(src){
		xaDialog.alert({content:src});
	}
	win.xconfirm=function(src,callback){
		xaDialog.confirm({content:src,callback:callback});
	}
	win.xerror=function(str){
		xaDialog.alert({content:str,width:800,height:500,title:"系统错误",stext:"知道了"});
	}
})(window);
/**
 * 	时间：2016-12-12
	版本：1.0
	作者：小艾
	错误弹出组件
	调用:
	win.xtip("错误信息");   注:只能弹出一个   出现多个的情况默认会覆盖
 */
(function(win){
	var tip = {
		//图标数据
		//默认参数
		defaults:{
			time:"3s",
			content:"哎呀，没传弹出内容  于是我出现了",
			fontSize:12
		},
		amtArray:[
		["animated flipInX","animated flipOutX"],
		["animated flipInY","animated flipOutY"],
		["animated fadeIn","animated fadeOut"],
		["animated fadeInUp","animated fadeOutUp"],
		["animated fadeInDown","animated fadeOutDown"],
		["animated fadeInLeft","animated fadeOutLeft"],
		["animated fadeInRight","animated fadeOutRight"],
		["animated fadeInUpBig","animated fadeOutUpBig"],
		["animated fadeInDownBig","animated fadeOutUpBig"],
		["animated fadeInLeftBig","animated fadeOutLeftBig"],
		["animated fadeInRightBig","animated fadeOutRightBig"],
		["animated bounceIn","animated bounceOut"],
		["animated bounceInUp","animated bounceOutUp"],
		["animated bounceInDown","animated bounceOutDown"],
		["animated bounceInLeft","animated bounceOutLeft"],
		["animated bounceInRight","animated bounceOutRight"],
		["animated rotateIn","animated rotateOut"],
		["animated rotateInUpLeft","animated rotateOutUpLeft"],
		["animated rotateInDownLeft","animated rotateOutDownLeft"],
		["animated rotateInUpRight","animated rotateOutUpRight"],
		["animated rotateInDownRight","animated rotateOutDownRight"],
		["animated rollIn","animated rollOut"]],
		animationCurr:0,
		timeOut:null,
		init:function(options){
			var opts = this.methods._mix(this.methods,this.defaults,options);
			this.animationCurr=Math.floor(Math.random()*this.amtArray.length);
			var tipDom = opts.template(opts);
			opts._center(tipDom);
			opts._resize(tipDom);
			opts._onclick(tipDom);
			opts._timeClear(opts,tipDom);
		},
		tip:function(options){
			this.init(options);
		}
	};
	//扩展事件	
	tip.methods = {
		//模板可拓展
		template:function(opts){
			var tipDom = document.getElementById("xatip");
			if(tipDom){
				document.body.removeChild(tipDom)
			}else{
				tipDom = document.createElement("div");
			}
			var html="<div id='xatip' style='cursor: pointer;padding:12px 19.5px;background:#111;color:#fff;display:inline-block;position:fixed;z-index:9999;border-radius:4px;box-shadow: 1px 1px 1em #111;'>"+opts.content+"</div>";
			tipDom.innerHTML=html;
			tipDom=tipDom.children[0];
			tipDom.className=tip.amtArray[tip.animationCurr][0];
			if(opts.fontSize){
				tipDom.style.fontSize=opts.fontSize+"px"
				tipDom.style.padding=opts.fontSize+"px "+opts.fontSize*1.625+"px"
			}
			document.body.appendChild(tipDom);
			return tipDom;
		},
		_center:function(tipDom){//居中dialog
			var nl = (window.innerWidth - tipDom.offsetWidth)/2;
			var nt = (window.innerHeight - tipDom.offsetHeight)/3;
			tipDom.style.top = nt+"px";
			tipDom.style.left = nl+"px";
		},
		_resize :function(tipDom){
			var obj = this;
			window.onresize = function(){
				obj._center(tipDom);
			};
		},
		_onclick:function(tipDom){
			$(tipDom).click(function(){
				$(this).removeClass(tip.amtArray[tip.animationCurr][0]).addClass(tip.amtArray[tip.animationCurr][1]).animate({"class":null},1000,function(){
					$(this).remove();
				});
				clearTimeout(tip.timeOut);
			});
		},
		_timeClear:function(opts,tipDom){
			tip.timeOut&&clearTimeout(tip.timeOut);
			tip.timeOut=setTimeout(function(){
				$(tipDom).trigger("click");
			},opts._getTime(opts.time));
		},
		_mix:function(target,datajson){
			var args = Array.prototype.slice.call(arguments);
			if(args.length==1)return args[0];
			var i = 1 ;
			while(args[i]){//这里做为判断条件 取不到就返回false
				var temp =args[i];
				for(var j in temp){
					if(temp.hasOwnProperty(j)){
						target[j]=temp[j];
					}
				}
				i++;
			}
				return target;
		},
		/*一个接地气的方法   5s 5秒的意思   代表返回5000毫秒*/
		_getTime:function(time){
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
				alert("格式错误,调用格式为1s 2m 2h 返回单位为毫秒");
			}
		}
	};
	win.xtip=function(str){
		tip.init({content:str});
	}
})(window);

/**
 * loading.js  暂时写在这个文件夹  获取 与xloding写在一起
 * */
(function($) {
	$.loading = function(a) {
		var b = $.extend({}, $.loading.template, $.loading.defaults, a);
		if (!b.mark) b.mark = Math.floor(Math.random() * 10);
		var c = $(b["t" + b.mark]);
		c.width(b.width).height(b.height);
		b.target.html(c)
	};
	$.loading.defaults = {
		width: 36,
		height: 36,
		mark: 1
	};
	$.loading.template = {
		t1: "<div class='sk-cube-grid kcube'>" + "      <div class='sk-cube sk-cube1'></div>" + "      <div class='sk-cube sk-cube2'></div>" + "      <div class='sk-cube sk-cube3'></div>" + "      <div class='sk-cube sk-cube4'></div>" + "      <div class='sk-cube sk-cube5'></div>" + "      <div class='sk-cube sk-cube6'></div>" + "      <div class='sk-cube sk-cube7'></div>" + "      <div class='sk-cube sk-cube8'></div>" + "      <div class='sk-cube sk-cube9'></div>" + "    </div>",
		t2: " <div class='sk-rotating-plane kcube'></div>",
		t3: "<div class='sk-folding-cube kcube'>" + "      <div class='sk-cube1 sk-cube'></div>" + "      <div class='sk-cube2 sk-cube'></div>" + "      <div class='sk-cube4 sk-cube'></div>" + "      <div class='sk-cube3 sk-cube'></div>" + "    </div>",
		t4: "<div class='sk-spinner sk-spinner-pulse kcube'></div>",
		t5: "<div class='sk-wandering-cubes kcube'>" + "   <div class='sk-cube sk-cube1'></div>" + "   <div class='sk-cube sk-cube2'></div>" + "</div>",
		t6: "<div class='sk-wave kcube'>" + "   <div class='sk-rect sk-rect1'></div>" + "   <div class='sk-rect sk-rect2'></div>" + "   <div class='sk-rect sk-rect3'></div>" + "   <div class='sk-rect sk-rect4'></div>" + "   <div class='sk-rect sk-rect5'></div>" + "</div>",
		t7: "<div class='sk-circle kcube'>" + "   <div class='sk-circle1 sk-child'></div>" + "   <div class='sk-circle2 sk-child'></div>" + "   <div class='sk-circle3 sk-child'></div>" + "   <div class='sk-circle4 sk-child'></div>" + "   <div class='sk-circle5 sk-child'></div>" + "   <div class='sk-circle6 sk-child'></div>" + "   <div class='sk-circle7 sk-child'></div>" + "   <div class='sk-circle8 sk-child'></div>" + "   <div class='sk-circle9 sk-child'></div>" + "   <div class='sk-circle10 sk-child'></div>" + "   <div class='sk-circle11 sk-child'></div>" + "   <div class='sk-circle12 sk-child'></div>" + "</div>",
		t8: "<div class='sk-double-bounce kcube'>" + "   <div class='sk-child sk-double-bounce1'></div>" + "   <div class='sk-child sk-double-bounce2'></div>" + " </div>",
		t9: "<div class='sk-chasing-dots kcube'>" + "   <div class='sk-child sk-dot1'></div>" + "   <div class='sk-child sk-dot2'></div>" + "</div>",
		t10: "<div class='sk-three-bounce kcube'>" + "  <div class='sk-child sk-bounce1'></div>" + "  <div class='sk-child sk-bounce2'></div>" + "  <div class='sk-child sk-bounce3'></div>" + "</div>",
		t11: "<div class='sk-fading-circle kcube'>" + "	<div class='sk-circle1 sk-circle'></div>" + "	<div class='sk-circle2 sk-circle'></div>" + "	<div class='sk-circle3 sk-circle'></div>" + "	<div class='sk-circle4 sk-circle'></div>" + "	<div class='sk-circle5 sk-circle'></div>" + "	<div class='sk-circle6 sk-circle'></div>" + "	<div class='sk-circle7 sk-circle'></div>" + "	<div class='sk-circle8 sk-circle'></div>" + "	<div class='sk-circle9 sk-circle'></div>" + "	<div class='sk-circle10 sk-circle'></div>" + "	<div class='sk-circle11 sk-circle'></div>" + "	<div class='sk-circle12 sk-circle'></div>" + "</div>"
	}
})(jQuery);

var loading =function(a, b) {
	$.loading({
		target: $(a),
		mark: b
	})
};

/**
 *时间:2016-12-5
	版本：1.0
	作者：小艾
	延迟遮罩层
	调用:
	xloading.init(dom);带个元素父box   一个页面只能存在一个!   可以是jQery对象  可以是js的dom
	xloading.destroy();
 *加载组件  依赖于loading.js文件  这个是多封装了个遮罩层
 */
var xloading={
	id:"",
	dom:null,
	init:function(dom){//初始化
		if($(dom).css("position")=="static")$(dom).css("position","relative");
		this.id="xa"+new Date().getTime();
		this.dom=dom;
		this.html();
		this.bind();
	},
	html:function(){//模板
		/*background:rgba(170,170,170,0.5)*/
		var html="<div style='position: absolute;z-index:9999;height:100%;width:100%;left: 0;top: 0;'><div id="+this.id+" style='position: absolute;left: 0;right: 0;top: 0;bottom: 0;margin: auto;'></div></div>";
		$(this.dom).append(html);
	},
	bind:function(){//绑定
		var id = this.id;
		loading("#"+id,Math.floor(Math.random()*11)+1);
		$("#"+id).children().eq(0).css({"width": "45","height": "45","position": "absolute","left": "0","right": "0","top":"-30%","bottom":"0","margin":"auto"});
	},
	destroy:function(){//销毁
		var id = this.id;
		$("#"+id).parent().remove();
	}
};

