<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <style type="text/css">
			*{
				margin: 0;
				padding: 0;
			}
			.box{
				width: 500px;
				height: 300px;
				position: relative;
				overflow: hidden;
				margin: 100px auto;
			}
			.box .slider{
				width: 100%;
				height: 100%;
			}
			.box .slider ul{
				width: 1000%;
				list-style: none;
				position: absolute;
				top: 0;
				left: 0;
			}
			.box .slider img{
				vertical-align: top;
			}
			.box .slider ul li{
				float: left;
			}
			.box .scroll_nav{
				list-style: none;
				position: absolute;
				right: 20px;
				bottom: 10px;
			}
			.box .scroll_nav li{
				float: left;
				width: 20px;
				height: 20px;
				background-color: #000;
				color: #fff;
				text-align: center;
				font-size: 12px;
				font-family: "微软雅黑";
				line-height: 20px;
				cursor: pointer;
				border-radius: 50%;
				margin-right: 5px;
			}
			.box .scroll_nav li.current{
				background-color: #356acb;
			}
			.box .arr{
				width: 40px;
				height: 50px;
				font-size: 35px;
				font-family: "黑体";
				line-height: 50px;
				background-color: rgba(0,0,0,0.3); /*这种方式能让背景透明而文本不收影响*/
				color: #fff;
				text-align: center;
				position: absolute;
				top: 125px;
				font-weight: bold;
				display: none;
				cursor: pointer;
				/* opacity: 0.1; opacity属性会让盒子半透明，与此同时它也会让黑子内部的文本半透明*/
			}
			.box .arr_prev{
				left: 5px;
			}
			.box .arr_next{
				right: 5px;
			}
        </style>
        <script type="text/javascript">
        	function $(id){
        		return document.getElementById(id);
        	}
        	window.onload = function(){
        		//鼠标进入轮播图区域时，显示左右翻页的箭头
        		$("scroll").onmouseover = function(){
        			var arrs = this.getElementsByTagName("span");//获取到左右箭头
        			for (var i = 0; i < arrs.length; i++) {
        				arrs[i].style.display = "block";
        			};
        		}
        		//鼠标移出轮播图区域时，左右箭头隐藏
        		$("scroll").onmouseout = function(){
        			var arrs = this.getElementsByTagName("span");//获取到左右箭头
        			for (var i = 0; i < arrs.length; i++) {
        				arrs[i].style.display = "none";
        			};
        		}
				//动态生成轮播图对应的导航条选项
	        	var imgCount = $("sl").getElementsByTagName("img").length;//获取图片个数
	        	// imgCount = $("scroll").children[0].children[0].children.length
	        	for (var i = 0; i < imgCount; i++) {
	        		var li = document.createElement("li");//创建1给个li标签
	        		li.innerHTML = i+1;
	        		//设置初始选中项
	        		if(i == 0){
	        			li.setAttribute("class", "current");
	        		}
	        		li.setAttribute("index", i);
	        		//注册每个选项的onclick事件。排他思想
	        		li.onclick = function(){
	        			var lis = $("sc_nav").getElementsByTagName("li");
	        			for (var i = 0; i < lis.length; i++) {
	        				lis[i].className = "";
	        			};
	        			this.className = "current";
	        			//点击导航选项时，修改target的值，让图片滚动起来
	        			target = this.getAttribute("index") * -500;
	        		}
	        		$("sc_nav").appendChild(li);
	        	};
	        	//缓动动画
	        	var leader = 0;
	        	var target = 0;
	        	setInterval(function(){
	        		leader = leader + (target - leader) / 10;
	        		$("sl_ul").style.left = leader + "px";
	        	}, 30);
	        	//左箭头点击事件
	        	$("prev").onclick = function(){
	        		if(target < 0){
	        			target += 500;
	        		}
	        		setCurrent();
	        	}
	        	//右箭头点击事件
	        	$("next").onclick = function(){
	        		if(target > -3200){
	        			target -= 500;
	        		}
	        		else{
	        			target = 0;//如果已经是最后一张图(第5张图),就直接回到首图
	        		}
	        		setCurrent();
	        	}
	        	//修改对应的nav栏中的按钮为被选中项
	        	function setCurrent(){
	        		var index = Math.abs(target / 500);//取绝对值
	        		var lis = $("sc_nav").getElementsByTagName("li");
	        		for (var i = 0; i < lis.length; i++) {
	        			lis[i].className = "";
	        		};
	        		lis[index].className = "current";
	        	}
        	}	
        </script>
    </head>
    <body>

	<h1>successful</h1>
	<p>Welcome:&nbsp&nbsp&nbsp&nbsp<span style="color: red">${user.username}</span></p>
	<a href="user.action?method=userLoginOut">注销此次登录</a>

    	<div class="box" id="scroll">
    		<div class="slider" id="sl">
    			<ul id="sl_ul">
					<li><img src="" alt="开啡尔"></li>
					<li><img src="" alt="安慕希"></li>
					<li><img src="" alt="白小纯"></li>
					<li><img src="" alt="蒙牛"></li>
					<li><img src="" alt="莫斯利安"></li>
					<li><img src="" alt="纯甄"></li>
					<li><img src="" alt="慢醇"></li>
					<li><img src="" alt="伊利"></li>
    			</ul>
    		</div>
    		<ul class="scroll_nav" id="sc_nav">
    			
    		</ul>
    		<span class="arr arr_prev" id="prev"><</span>
    		<span class="arr arr_next" id="next">></span>
    	</div>
    </body>
</html>