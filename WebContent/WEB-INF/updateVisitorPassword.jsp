<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Festival Event Registration System</title>
<link rel="stylesheet" href="/css/portal.css">
</head>
<body>

	<div class="credentials">
		<form action="changePassword.do" method="post">
			<table style="width: 100%;">
				<tr>
					<td class="registration" colspan="2">Festival Registration
						System</td>
				</tr>
				<tr>
					<td colspan="2">
						<nav>
							<a href="">Log Out</a> <a href="">My Portal</a>
						</nav>
					</td>
				</tr>
				<tr>
					<td style="text-align: center;" colspan="4"><h3>Update
							your password</h3></td>
				</tr>
				<tr>
					<td style="text-align: right;">Current password:</td>
					<td style="text-align: left;"><input required type="password"
						name="currentPassword" maxlength=15></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">New password:</td>
					<td style="text-align: left;"><input required type="password"
						name="newPassword" maxlength=15></input></td>
				</tr>
				<tr>
					<td style="text-align: right;">Repeat new password:</td>
					<td style="text-align: left;"><input required type="password"
						name="confirmPassword" maxlength=15></input></td>
				</tr>
				<tr>
					<td style="text-align: left;"><input type="submit"
						value="update" style="margin-left: 73px;"
						onclick="return Validate()"></input></td>
				</tr>
			</table>
			<script type="text/javascript">
				function Validate() {
					var password = document.getElementById("currentPassword").value;
					var confirmPassword = document
							.getElementById("confirmPassword").value;
					if (password != confirmPassword) {
						alert("Passwords do not match.");
						return false;
					}
					return true;
				}
			</script>

		</form>
	</div>
</body>
</html>
