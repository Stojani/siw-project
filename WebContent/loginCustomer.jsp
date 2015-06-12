<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Login</title>
</head>
<body>
          <f:view>
	      <h:form>
		        <h1>Insert credentials</h1> 
        <div>Email: <h:inputText value="#{customerController.email}" 
                     required="true" requiredMessage="Email is mandatory"
                     id="email"/> <h:message for="email" />
	</div>
    <div>Password: <h:inputSecret value="#{customerController.password}" 
                     required="true" requiredMessage="Password is mandatory"
                     id="password"/> <h:message for="password" />
	</div>
		<div>
			<h:commandButton value="Login"
				action="#{customerController.Login}" />
		</div>
	</h:form>
	</f:view>

</body>
</html>