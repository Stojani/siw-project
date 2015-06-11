<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>E-COMMERCE WEB SITE</title>
</head>
<body>
	<f:view>
		<h1>WELCOME TO THE E-COMMERCE WEB SITE</h1>
		<p>
			<strong>Please, choice an operation to execute</strong>
		</p>
		<h:form>
		<ul>
		 <li><a href="loginCustomer.html">Login</a></li>
		<li><a href="loginAdministrator.html">Login as Administrator</a></li>
		<li><a href="registerCustomer.html">Sign up</a></li>
		<li><a href="ProductsCatalog.html">Browse our products</a></li>
		</ul>
		</h:form>
	</f:view>
</body>
</html>

