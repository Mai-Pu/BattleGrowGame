<%@page import="entity.Character"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<jsp:useBean id="CharacterDirector" class="entitybuild.CharacterDirector" scope="session"/>
<jsp:useBean id="MonsterFactory" class="entitybuild.MonsterFactory" scope="session"/>
<%
	ArrayList<String> list = (ArrayList)session.getAttribute("note");
	if(list == null){
		list = new ArrayList<String>();
		list.add("欢迎来到这个世界");
		list.add("你的每一次探索都将显示在剧情栏上");
		list.add("目前的存档功能还不可用");
		list.add("祝你好运！！！");
		session.setAttribute("note", list);
	}
	
	Character role = (Character)session.getAttribute("Character");
	if(role == null){
		role = CharacterDirector.construct();
		session.setAttribute("Character", role);
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
      function setMessage(s){
    	  
    	  var box = document.getElementById('messagebox');
    	  var new_m = document.createElement('div');
    	  new_m.className = "comment";
    	  new_m.style.height = "15px";
    	  var new_Text=document.createTextNode(s);
    	  new_m.appendChild(new_Text);
    	  //box.appendChild(new_m);
    	  box.insertBefore(new_m,box.childNodes[0]);
      }
     </script>
</head>
<body>
<div id="game" data-uk-margin>
	<div class="uk-width-1-1">
		<div class="uk-panel-box uk-container-center uk-panel-box-secondary">
			<h1 class="uk-text-center" title="Lords">战斗成长游戏</h1>
			<button class="uk-button uk-button-primary" @click="updateSave()">存档更新</button>
			<button class="uk-button uk-button-primary" @click="initGame()">存档重置</button>
			<a class="uk-button uk-button-primary" href="guide.html" target="_blank">新手指南</a>
		</div>
	</div>
	
	<div style="text-align:center">
	<div class="uk-panel uk-panel-box uk-panel-box-primary commentList" style="display:inline-block;width:50%">
			<div class="uk-panel-title">剧情栏</div>
			<div class="bor" id="messagebox">
				<%
					int time = 0;
					for(String s : list){
				%>
				<script type="text/javascript">	
  					setTimeout("setMessage('<%=s%>')",<%=time %>);
				</script>
				<%
						time+=2000;
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
			<button class="uk-button uk-button-primary uk-float-right uk-margin-small-left" onclick="show('skill')">技能</button>
			<button class="uk-button uk-button-primary uk-float-right uk-margin-small-left" onclick="show('equipment')">装备</button>
			<button class="uk-button uk-button-primary uk-float-right uk-margin-small-left" onclick="show('backpack')">背包</button>
			<button class="uk-button uk-button-primary uk-float-right uk-margin-small-left" onclick="show('character')">人物</button>
			<button class="uk-button uk-button-primary uk-float-right" onclick="window.location='<%=path%>/SearchServlet'">探索</button>
		</div>
	</div>
	
</div>
</body>
</html>