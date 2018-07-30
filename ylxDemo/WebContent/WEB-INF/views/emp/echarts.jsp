<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<div class="span6">
					<img alt="140x140"  />
				</div>
				<div class="span6">
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<ul class="nav nav-list">
						<li class="nav-header">
							列表标题
						</li>
						<li class="active">
							<a href="#">首页</a>
						</li>
						<li>
							<a href="#">库</a>
						</li>
						<li>
							<a href="#">应用</a>
						</li>
						<li class="nav-header">
							功能列表
						</li>
						<li>
							<a href="#">资料</a>
						</li>
						<li>
							<a href="#">设置</a>
						</li>
						<li class="divider">
						</li>
						<li>
							<a href="#">帮助</a>
						</li>
					</ul>
				</div>
				<div class="span6">
					<div class="row-fluid">
						<div class="span4">
							<h2>
								Fab1
							</h2>
						</div>
						<div class="span4">
							<div class="btn-group">
								 <button class="btn">Action</button> <button data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></button>
								<ul class="dropdown-menu">
									<li>
										<a href="#">操作</a>
									</li>
									<li>
										<a href="#">设置栏目</a>
									</li>
									<li>
										<a href="#">更多设置</a>
									</li>
									<li class="divider">
									</li>
									<li class="dropdown-submenu">
										 <a tabindex="-1" href="#">更多选项</a>
										<ul class="dropdown-menu">
											<li>
												<a href="#">操作</a>
											</li>
											<li>
												<a href="#">设置栏目</a>
											</li>
											<li>
												<a href="#">更多设置</a>
											</li>
										</ul>
									</li>
								</ul>
							</div>
						</div>
						<div class="span4">
							<div class="btn-group">
								 <button class="btn">Action</button> <button data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></button>
								<ul class="dropdown-menu">
									<li>
										<a href="#">操作</a>
									</li>
									<li>
										<a href="#">设置栏目</a>
									</li>
									<li>
										<a href="#">更多设置</a>
									</li>
									<li class="divider">
									</li>
									<li class="dropdown-submenu">
										 <a tabindex="-1" href="#">更多选项</a>
										<ul class="dropdown-menu">
											<li>
												<a href="#">操作</a>
											</li>
											<li>
												<a href="#">设置栏目</a>
											</li>
											<li>
												<a href="#">更多设置</a>
											</li>
										</ul>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span4">
						</div>
						<div class="span4">
						</div>
						<div class="span4">
						</div>
					</div>
					<div class="row-fluid">
						<div class="span4">
						</div>
						<div class="span4">
						</div>
						<div class="span4">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
    <div id="main" style="height:400px"></div>
     <div id="main1" style="height:400px"></div>
      <div id="main2" style="height:400px"></div>
       <div id="main3" style="height:400px"></div>
       <script type="text/javascript" src="${pageContext.request.contextPath }/scripts/echarts.js"></script>
       

     <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/gauge' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                var myChart1 = ec.init(document.getElementById('main1')); 
                var option = {
                	    tooltip : {
                	        formatter: "{a} <br/>{b} : {c}%"
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    series : [
                	        {
                	            name:'业务指标',
                	            type:'gauge',
                	            detail : {formatter:'{value}%'},
                	            data:[{value: 50, name: '完成率'}]
                	        }
                	    ]
                	};

                	//clearInterval(timeTicket);
                	timeTicket = setInterval(function (){
                	    option.series[0].data[0].value = (Math.random()*100).toFixed(2) - 0;
                	    myChart.setOption(option, true);
                	},2000);
                	                    
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
                myChart1.setOption(option); 
            }
        );
    </script>
<a href = "springmvc">换</a>
</body>
</html>