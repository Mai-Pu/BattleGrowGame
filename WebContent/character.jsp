<%@page import="entity.SkillComponent"%>
<%@page import="java.util.Iterator"%>
<%@page import="entity.Character"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人物状态</title>

<link href="http://cdn.bootcss.com/uikit/2.27.1/css/uikit.min.css" rel="stylesheet">
<link href="http://cdn.bootcss.com/uikit/2.27.1/css/components/notify.css" rel="stylesheet">
</head>
<body>
<div class="uk-width-1-2" style="text-align:center;width:100%">
		<div class="uk-panel uk-panel-box uk-panel-box-primary">
			<div class="uk-panel-title">
				人物状态
			</div>
			<%
				Character role = (Character)session.getAttribute("Character");
				Iterator<SkillComponent> is = role.getSkills().getIterator();
				String W_name = "一条咸鱼";
				String C_name = "布衣";
				if(role.getEquipments().get("Weapon")!=null){
					W_name = role.getEquipments().get("Weapon").getName();
				}
				if(role.getEquipments().get("Cloth")!=null){
					C_name = role.getEquipments().get("Cloth").getName();
				}
			%>
			<ul class="uk-list uk-list-line">
				<li title="种族天赋"><small>职业:</small><%=role.getCareer().getType() %></li>
				<li title="等级"><small>等级:</small><%=role.getRank() %></li>
				<li title="经验值"><small>经验:</small><%=role.getExperience() %>/100</li>
				<li title="血量以及精力"><small>血量:</small><%=role.getBaseHp() %></li>
				<li title="其他一些属性(属性受装备影响)"><small>攻击力:</small><%=role.getBaseAttack() %>&nbsp;&nbsp;<small>防御力:</small><%=role.getBaseDefense() %>&nbsp;&nbsp;<small>速度:</small><%=role.getBaseSpeed() %></li>
				<li title="基础货币"><small>所持金币:</small><%=role.getMoney() %></li>
				<li title="已经穿戴的装备">你手里拿着<strong><%=W_name %></strong>&nbsp;身上穿着<strong><%=C_name %></strong></li>
				<li title="已经学会的技能"><small>你掌握的技能有:</small>
				<%
					while (is.hasNext()) {
				%>
				  <%=is.next().getName()%>&nbsp;
				<%
					}
				%>
				</li>
			</ul>
		</div>
</body>
</html>