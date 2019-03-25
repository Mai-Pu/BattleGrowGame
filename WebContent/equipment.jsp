<%@page import="entity.Equipment"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
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
<title>装备</title>
</head>
<body>
	<div class="uk-width-1-2"  style="width:100%">
		<div class="uk-panel uk-panel-box uk-panel-box-primary">
			<div class="uk-panel-title">已穿戴装备</div>
			<table class="uk-table uk-table-striped">
				<thead>
					<tr>
						<th>名称</th>
						<th>种类</th>
						<th>属性</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<%
					Character role = (Character)session.getAttribute("Character");
					HashMap<String,Equipment> es = role.getEquipments();
					Set<String> keys = es.keySet();
					for(String s:keys){
				%>
					<tr>
						<td style="vertical-align:middle;"><%=es.get(s).getName() %></td>
						<td style="vertical-align:middle;"><%=es.get(s).getType() %></td>
						<td style="vertical-align:middle;">
						<%
							if("Weapon".equals(s)){
						%>攻击力<%}else{%>防御力<%} %>+<%=es.get(s).getPower() %>&nbsp;强化等级+<%=es.get(s).getLevel() %></td>
						<td>
							<button class="uk-button" title="<%=es.get(s).describe()%>">详情</button>
							<button class="uk-button" title="每次强化需要10个金币" onclick="window.location='<%=path%>/BackpackServlet?select=seq&equipment=<%=s%>'">强化</button>
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