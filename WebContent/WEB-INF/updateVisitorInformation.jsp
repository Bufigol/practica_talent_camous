<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Festival Event Registration System</title>
<link rel="stylesheet" href="/css/portal.css">
</head>
<body>

	<div class="credentials">
		<form action="updateVisitor.do" method="post">
			<table style="width: 100%;">
				<tr>
					<th class="registration" colspan="2">Festival Registration
						System</th>
				</tr>
				<tr>
					<th colspan="2">
						<nav>
							<a href="./index.jsp">Log Out</a> <a href="portal.jsp">My
								Portal</a>
						</nav>
					</th>
				</tr>
				<tr>
					<th style="text-align: center;" colspan="4"><h3>Update
							your information</h3></th>
				</tr>
				<tr>
					<th style="text-align: right; font-size: x-small;" colspan="4"><h3>Fields
							marked (*) are mandatory</h3></th>
				</tr>
				<tr>
					<th style="text-align: right;">*First Name:</th>
					<th style="text-align: left;"><input required type="text"
						name="firstname" id="firstname" value="" maxlength=30></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*Last Name:</th>
					<th style="text-align: left;"><input required type="text"
						name="lastname" id="lastname" value="" maxlength=30></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*User Name:</th>
					<th style="text-align: left;"><input required type="text"
						name="username" id="username" maxlength=12 value="" disabled></input></th>
				</tr>

				<tr>
					<th style="text-align: right;">*Email:</th>
					<th style="text-align: left;"><input required type="text"
						name="email" id="email" maxlength=200 value=""></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*Dni(XX.XXX.XXX-L):</th>
					<th style="text-align: left;"><input required type="text"
						name="dni" id="dni" maxlength=12 value=""></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*Phone Number:</th>
					<th style="text-align: left;"><input required type="text"
						name="phoneNumber" id="phoneNumber" maxlength=20 value=""></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">Address:</th>
					<th style="text-align: left;"><input type="text"
						name="address" id="address" maxlength=30 value=""></input></th>
				</tr>
				<tr>
					<th></th>
					<th style="text-align: left;"><input type="submit"
						name="update" value="update" style="margin-left: 10px;"></input></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
