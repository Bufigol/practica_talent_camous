<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Festival Event Registration System</title>
<link rel="stylesheet" href="css\portal.css"></link>
<script type="text/javascript" src="js/sprint5.js"></script>
</head>
<body>

	<div class="credentials">
		<form action="newVisitor.do" method="post">
			<table style="width: 100%;">
				<tr>
					<th class="registration" colspan="2">Festival Registration
						System</th>
				</tr>
				<tr>
					<th colspan="2">
						<nav>
							<a href="index.jsp">Log In</a>
						</nav>
					</th>
				</tr>
				<tr>
					<th style="text-align: center;" colspan="4"><h3>Portal
							Login Page</h3></th>
				</tr>
				<tr>
					<th style="text-align: right; font-size: x-small;" colspan="4"><h3>Fields
							marked (*) are mandatory</h3></th>
				</tr>
				<tr>
					<th style="text-align: right;">*First Name:</th>
					<th style="text-align: left;"><input required type="text"
						name="firstname" id="firstname" maxlength=30></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*Last Name:</th>
					<th style="text-align: left;"><input required type="text"
						name="lastname" id="lastname" maxlength=30></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*User Name:</th>
					<th style="text-align: left;"><input required type="text"
						name="username" id="username" maxlength=12
						onblur="searchUsername()"></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*Password:</th>
					<th style="text-align: left;"><input required type="password"
						name="password" id="password" maxlength=15></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*Confirm Password:</th>
					<th style="text-align: left;"><input required type="password"
						name="password" id="confirmPassword" maxlength=15></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*Email:</th>
					<th style="text-align: left;"><input required type="text"
						name="email" id="email" maxlength=200></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*Dni(XX.XXX.XXX-L):</th>
					<th style="text-align: left;"><input required type="text"
						name="dni" id="dni" maxlength=12></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">*Phone Number:</th>
					<th style="text-align: left;"><input required type="text"
						name="phoneNumber" name="phoneNumber" maxlength=20></input></th>
				</tr>
				<tr>
					<th style="text-align: right;">Address:</th>
					<th style="text-align: left;"><input type="text"
						name="address" id="address" maxlength=30></input></th>
				</tr>
				<tr>
					<th></th>
					<th style="text-align: left;"><input type="submit"
						value="register" style="margin-left: 73px;"
						onclick="return Validate()"></input></th>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
	function Validate() {
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementById("confirmPassword").value;
		if (password != confirmPassword) {
			alert("Passwords do not match.");
			return false;
		}
		return true;
	}
</script>
</html>
