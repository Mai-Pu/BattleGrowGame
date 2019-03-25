<%@page import="java.net.URLEncoder"%>
<%@page import="entity.SkillComponent"%>
<%@page import="java.util.Iterator"%>
<%@page import="entity.Character"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/base.css">
<link href="http://cdn.bootcss.com/uikit/2.27.1/css/uikit.min.css" rel="stylesheet">
<link href="http://cdn.bootcss.com/uikit/2.27.1/css/components/notify.css" rel="stylesheet">
<title>技能</title>
<script language="javascript">
	    function delcfm(name) {
	        if (!confirm("确认要遗忘这个技能？")) {
	            window.event.returnValue = false;
	        }else{
	        	window.location='<%=path%>/SkillServlet?select=1&skillname='+name;
	        }
	    }
</script>
</head>
<body>
	<div class="uk-width-1-2"  style="width:100%">
		<div class="uk-panel uk-panel-box uk-panel-box-primary">
			<div class="uk-panel-title">已学会的技能&nbsp;&nbsp;<small>注:当你掌握了四个技能后,你就再也没有办法学会新技能了</small></div>
			<table class="uk-table uk-table-striped">
				<thead>
					<tr>
						<th>名称</th>
						<th>种类</th>
						<th>掌握程度</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<%
					Character role = (Character)session.getAttribute("Character");
					Iterator<SkillComponent> is = role.getSkillIterator();
					while(is.hasNext()){
						SkillComponent skill = is.next();
				%>
					<tr>
						<td style="vertical-align:middle;"><%=skill.getName() %></td>
						<td style="vertical-align:middle;"><%=role.getType() %></td>
						<%
							String level = "";
							switch(skill.getLevel()){
								case 0:
									level = "差强人意";
									break;
								case 1:
									level = "小试牛刀";
									break;
								case 2:
									level = "运用自如";
									break;
								case 3:
									level = "炉火纯青";
									break;
							}
						%>
						<td style="vertical-align:middle;"><%=level %></td>
						<td>
							<button class="uk-button" title="<%=skill.description()%>">详情</button>
							<%
								//由于技能的名称是中文,在URL传参中先要进行编码
								String code = URLEncoder.encode(skill.getName(),"UTF-8");
								if(skill.getLevel() < 3){
							%>
							<button class="uk-button" title="每次闭关需要20个金币" onclick="window.location='<%=path%>/SkillServlet?select=0&skillname=<%=code%>'">闭关修炼</button>
							<%
								}
							%>
							<button class="uk-button" onclick="delcfm('<%=code%>');">遗忘</button>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>            
</body>
</html>