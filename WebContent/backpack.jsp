<%@page import="entity.Equipment"%>
<%@page import="java.util.List"%>
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
<title>背包</title>
<script language="javascript">
	    function delcfm(i) {
	        if (!confirm("确认要丢弃？")) {
	            window.event.returnValue = false;
	        }else{
	        	window.location='<%=path%>/BackpackServlet?select=3&index='+i;
	        }
	    }
</script>
</head>
<body>
	<div class="uk-width-1-2"  style="width:100%">
		<div class="uk-panel uk-panel-box uk-panel-box-primary">
		<%
			Character role = (Character)session.getAttribute("Character");
			List<Equipment> bag = role.getBag();
		%>
			<div class="uk-panel-title">背包列表  <%=bag.size() %>/50</div>
			<table class="uk-table uk-table-striped">
				<thead>
					<tr>
						<th>名称</th>
						<th>种类</th>
						<th>强化等级</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<%
					for(int i=0;i<bag.size();i++){
						Equipment e = bag.get(i);
				%>
					<tr>
						<td style="vertical-align:middle;"><%=e.getName() %></td>
						<td style="vertical-align:middle;"><%=e.getType() %></td>
						<td style="vertical-align:middle;"><%=e.getLevel() %></td>
						<td>
							<button class="uk-button" title="<%=e.describe() %>">详情</button>
							<%
								if( e != role.getEquipments().get(e.getType())){
							%>
							<button class="uk-button" onclick="window.location='<%=path%>/BackpackServlet?select=0&index=<%=i%>'">装备</button>
							<button class="uk-button" onclick="delcfm(<%=i%>);">丢弃</button>
							<%
								}else{
							%>
							<button class="uk-button" onclick="window.location='<%=path%>/BackpackServlet?select=1&index=<%=i%>'">脱下</button>
							<%
								}
							%>
							<button class="uk-button" title="每次强化需要10个金币" onclick="window.location='<%=path%>/BackpackServlet?select=2&index=<%=i%>'">强化</button>
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