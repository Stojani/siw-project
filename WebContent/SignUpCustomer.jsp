<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%> 
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SIGN UP</title>
</head>
<body>
          <f:view>
	      <h:form>
		        <h1>Sign up</h1> 
		     <div>FirstName: <h:inputText value="#{customerController.firstName}"
		     required="true" requiredMessage="firstName is mandatory"
		     id="firstName"/> <h:message for="firtsName" />
		     </div>
    <div>LastName: <h:inputSecret value="#{customerController.lastName}" 
                     required="true" requiredMessage="lastName is mandatory"
                     id="lastName"/> <h:message for="lastName" />
                     </div>
    <div>Password: <h:inputSecret value="#{customerController.password}" 
                     required="true" requiredMessage="Password is mandatory"
                     id="password"/> <h:message for="password" />
		     
		     </h:form>
	         </f:view>
		     
		     
</body>
</html>