<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Festival Event Registration System</title>
<link rel="stylesheet" href="css\portal.css">
</head>
<body>

	<div class="credentials">
		<form action="searchVisitor.do" method="post">
			<table style="width: 100%;">
				<tr>
					<th class="loginTableth" colspan="4">Festival Event
						Registration System</th>
				</tr>
				<tr>
					<th style="text-align: center;" colspan="4"><h3>Portal
							Login Page</h3></th>
				<tr>
					<th style="text-align: right;">Visitor name:</th>
					<th style="text-align: left;"><input type="text"
						name="visitorname"></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">Password:</th>
					<th style="text-align: left;"><input type="password"
						name="visitorpassword"></input></th>
				</tr>
				<tr>
					<th></th>
					<th style="text-align: left;"><input
						style="margin-left: 88px;" type="submit" value="login"></input></th>

				</tr>
				<tr>
					<th style="text-align: right;">New Visitor:</th>
					<th></th>
				</tr>
				<tr>
					<th style="text-align: right;"><a href="register.jsp">register
							here</a></th>
					<th></th>
				</tr>
			</table>
			<div>${requestscope.error}</div>
		</form>
	</div>
</body>
</html>

