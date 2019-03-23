<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
ArrayList<String> list = (ArrayList)session.getAttribute("note");
if(list == null){
	list = new ArrayList<String>();
	session.setAttribute("note", list);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>大冒险</title>
	<link rel="stylesheet" href="css/base.css">
	<link href="https://cdn.bootcss.com/uikit/2.27.1/css/uikit.min.css" rel="stylesheet">
	<link href="https://cdn.bootcss.com/uikit/2.27.1/css/components/notify.css" rel="stylesheet">
	<script type="text/javascript" src="js/lhgcore.js"></script>
    <script type="text/javascript" src="js/lhgdialog.js"></script>
    <script type="text/javascript">
      function show(where){ 
         J.dialog.get({id: 'haoyue_creat',title: where,width: 600,height:400, link: '<%=path%>/'+where+'.jsp', cover:true});
      }
      function search(){
    	 list.add("你好");
      }
     </script>
</head>
<body>
<div id="game" data-uk-margin>
	<div class="uk-width-1-1">
		<div class="uk-panel-box uk-container-center uk-panel-box-secondary">
			<h1 class="uk-text-center" title="Lords">大冒险</h1>
			<button class="uk-button uk-button-primary" @click="updateSave()">存档更新</button>
			<button class="uk-button uk-button-primary" @click="initGame()">存档重置</button>
			<a class="uk-button uk-button-primary" href="guide.html" target="_blank">新手指南</a>
		</div>
	</div>
	
	<div style="text-align:center">
	<div class="uk-panel uk-panel-box uk-panel-box-primary commentList" style="display:inline-block;width:50%">
			<div class="uk-panel-title">剧情栏</div>
			<div class="bor">
				<%
					for(String s : list){
				%>
				<div class="comment" style="height:15px"><%=s %></s></div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	
	<div style="text-align:center">
	<div class="uk-panel uk-panel-box uk-panel-box-primary" style="display:inline-block;width:50%">
			<div class="uk-panel-title">你目前位于：未知</div>
			<span>地图</span>：
			<span class="uk-text-muted">未知</span>
			<span class="uk-text-muted">未知</span>
			<span class="uk-text-muted">未知</span>
			<span class="uk-text-muted">未知</span>
			<!--<span class="uk-text-success" v-if="menace=='safe'">安全</span>
			<span class="uk-text-warning" v-if="menace=='unstable'">不安</span>
			<span class="uk-text-warning" v-if="menace=='complaint'">敌视</span>
			<span class="uk-text-danger" v-if="menace=='enmity'">恨意</span>
			<span class="uk-text-danger" v-if="menace=='hatred'">血仇</span>  
			<small>(探索消耗：无)</small>-->
			<button class="uk-button uk-button-primary uk-float-right uk-margin-small-left" onclick="show('skill')">技能</button>
			<button class="uk-button uk-button-primary uk-float-right uk-margin-small-left" onclick="show('equipment')">装备</button>
			<button class="uk-button uk-button-primary uk-float-right uk-margin-small-left" onclick="show('backpack')">背包</button>
			<button class="uk-button uk-button-primary uk-float-right uk-margin-small-left" onclick="show('character')">人物</button>
			<button class="uk-button uk-button-primary uk-float-right" onclick="window.location='search.jsp'">探索</button>
		</div>
	</div>
	
</div>
</body>
</html>