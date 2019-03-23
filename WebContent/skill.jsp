<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/base.css">
<link href="http://cdn.bootcss.com/uikit/2.27.1/css/uikit.min.css" rel="stylesheet">
<link href="http://cdn.bootcss.com/uikit/2.27.1/css/components/notify.css" rel="stylesheet">
<title>技能</title>
</head>
<body>
	<div class="uk-width-1-2"  style="width:100%">
		<div class="uk-panel uk-panel-box uk-panel-box-primary">
			<div class="uk-panel-title">已学会的技能</div>
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
					<tr>
						<td style="vertical-align:middle;">基础拳法一</td>
						<td style="vertical-align:middle;">拳法</td>
						<td style="vertical-align:middle;">略有所成</td>
						<td>
							<button class="uk-button" title="详情">详情</button>
							<button class="uk-button" @click="reduceBuilds(list.id)">闭关修炼</button>
							<button class="uk-button" @click="reduceBuilds(list.id)">遗忘</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>