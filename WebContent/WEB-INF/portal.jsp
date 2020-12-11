<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FERS</title>
<link rel="stylesheet" href="/css/portal.css">
<%@ page session="true"%>
</head>
<body>

	<div class="generic">
		<div class="title">
			<p style="color: maroon; font-size: x-large; marging-bottom: 10px;">Festival
				Registration System</p>

		</div>
		<nav>
			<a href="./logoutController.do">Log Out</a>
		</nav>
		<h3>
			Festival Portal Page: Welcome <span id="user"></span> to your portal
			page:
		</h3>

		<div class="userInformation">
			Your personal information is below. To change your information <a
				href="./updateVisitorInformation.jsp">Update visitor</a> <a
				href="./changePassword.do">Update password</a> <br>Username: <span
				id="username"> <%
 	out.println(request.getSession().getAttribute("username"));
 %>
			</span> <br>Vistor ID: <span id="visitorid"> <%
 	out.println(request.getSession().getAttribute("visitorid"));
 %>
			</span> <br>Email: <span id="email"> <%
 	out.println(request.getSession().getAttribute("email"));
 %>
			</span> <br>Phone Number: <span id="phonenumber"> <%
 	out.println(request.getSession().getAttribute("phonenumber"));
 %>
			</span> <br>Address: <span id="address"> <%
 	out.println(request.getSession().getAttribute("address"));
 %>
			</span>
		</div>

		<hr
			style="background-color: DarkCyan; border: 0; height: 3px; margin: 2px">
		<div class="release">
			To release a ticket you have for an upcoming attraction, please find
			the attraction below, and click the release link.
			<form method="post">
				<table style="width: 100%;">
					<tr bgcolor="#66CC99" style="font-size: small">
						<th>Event id</th>
						<th>Event name</th>
						<th>Description</th>
						<th>Places</th>
						<th>Duration</th>
						<th>Event type</th>
						<th>Action</th>
					</tr>
					<c:forEach var="registeredevents"
						items="${sessionScope.visitor.registeredEvents}">
						<tr>
							<th>${registeredevents.eventId}</th>
							<th>${registeredevents.name}</th>
							<th>${registeredevents.description}</th>
							<th>${registeredevents.place}</th>
							<th>${registeredevents.duration}</th>
							<th>${registeredevents.eventType}</th>
							<th><a
								href="eventUnreg.do?idEvento=${registeredevents.eventId}">Unregister</th>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<p></p>
		<hr
			style="background-color: DarkCyan; border: 0; height: 3px; margin: 2px">

		<div class="release">
			To get a ticket for an up-coming attraction, please find the
			attraction below, and click the Register link.
			<form method="post">
				<table style="width: 100%;">
					<tr bgcolor="#669966" style="font-size: small">
						<th>Event id</th>
						<th>Event name</th>
						<th>Description</th>
						<th>Places</th>
						<th>Duration</th>
						<th>Event type</th>
						<th>Available Tickets</th>
						<th>Action</th>
					</tr>
					<c:forEach var="allEvents" items="${aplicationScope.lista_Eventos}">
						<tr>
							<th>${allEvents.eventId}</th>
							<th>${allEvents.name}</th>
							<th>${allEvents.description}</th>
							<th>${allEvents.place}</th>
							<th>${allEvents.duration}</th>
							<th>${allEvents.eventType}</th>
							<th><a href="eventReg.do?idEvento=${allEvents.eventId}">Register</th>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>

