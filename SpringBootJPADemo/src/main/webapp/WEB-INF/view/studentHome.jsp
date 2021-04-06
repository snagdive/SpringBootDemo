
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
    

<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home</title>
<style>
* {
  box-sizing: border-box; }

	html {
	  height: 100%; }

	body {
	  background-color: #354152;
	  color: #7e8ba3;
	  font: 300 1rem/1.5 Helvetica Neue, serif;
	  margin: 0;
	  min-height: 100%; }

	table,th,td {
		border: 1px solid black;
		padding: 10px
	}
	th {
		background-color: #378f7b;
		color: white;
		
	}
	.align {
	  align-items: center;
	  display: flex;
	  flex-direction: row; }
	  .align__item--start {
	    align-self: flex-start; }
	  .align__item--end {
	    align-self: flex-end; }

	.site__logo {
	  margin-bottom: 2rem; }

	input {
	  border: 0;
	  font: inherit; }
	  input::placeholder {
	    color: #7e8ba3; }

	.form__field {
	  margin-bottom: 1rem; }
	.form input {
	  outline: 0;
	  padding: .5rem 1rem; }
	  .form input[type="text"], .form input[type="password"] {
	    width: 100%; }

	.grid {
	  margin: 0 auto;
	  max-width: 50rem;
	  width: 100%; }

	h2 {
	  font-size: 2.75rem;
	  font-weight: 100;
	  margin: 0 0 1rem;
	  text-transform: uppercase;
	  font-weight: bold;
	  font-family: serif;
	   }

	svg {
	  height: auto;
	  max-width: 100%;
	  vertical-align: middle; }

	a {
	  color: #7e8ba3; }
	  
	.register {
	  box-shadow: 0 0 250px #000;
	  text-align: center;
	  padding: 4rem 2rem; }
	  .register input {
	    border: 1px solid #242c37;
	    border-radius: 999px;
	    background-color: transparent;
	    text-align: center; }
	    .register input[type="submit"] {
	      background-image: linear-gradient(160deg, #8ceabb 0%, #378f7b 100%);
	      color: #fff;
	      margin-bottom: 6rem;
	      width: 100%; }

	/*# sourceMappingURL=login.css.map */
</style> 
</head>
<body class="align">
<div class="grid align__item">
<div class="register">
<h2>Welcome to Student Home</h2> 
<br><br>
	<table>
		<tr> <th>Student Id</th> <th>Student Name</th> <th>Student Department</th> <th>Edit</th> <th>Delete</th> </tr>
		<c:forEach var="stud" items="${allStudent}">
			<tr>
				<td>${stud.sid}</td>
				<td>${stud.name}</td>
				<td>${stud.dept}</td>
				<td><a href="/editStud/${stud.sid}">Edit</a></td>
				<td><a href="/deleteStud/${stud.sid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="/addStudent">Add New Student</a><p><a href="/home">Logout</a>
</div>
</div>
</body>
</html>