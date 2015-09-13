<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="e-commerce web site">
    <meta name="author" content="Stojani">
<title>SignUp Customer</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<!-- Custom styles for this template -->
	<link href="boostrap/css/login.css" rel="stylesheet">
	
</head>
<body>
 <div class="container">
 <div class="modal-dialog">
 
       <h2 class="text-center">Sign up</h2>
       
       <f:view>
		<form class="form col-md-12 center-block">
		
			<div class="form-group">				
            <label for="firstName" class="sr-only"></label>
		    <h:inputText id="firstName" styleClass="form-control"
					value="#{customerController.firstName}"
					required="true"  requiredMessage="First Name is mandatory">
					<h:outputLabel value="First Name" />   </h:inputText>
					<h:message for="firstName" />
		    </div>
            <div class="form-group">
			<label for="lastName" class="sr-only"></label>
        <h:inputText id="lastName" styleClass="form-control"
					value="#{customerController.lastName}"
					required="true"  requiredMessage="Last Name is mandatory">
					<h:outputLabel value="Last Name" />   </h:inputText>  
					<h:message for="lastName" />
		</div> 

			<div class="form-group">      
        <label for="email" class="sr-only"></label>
        <h:inputText id="email" styleClass="form-control"
		            value="#{customerController.email}"
					required="true"  requiredMessage="Email is mandatory">
					<h:outputLabel value="Email" />   </h:inputText> 
					<h:message for="email" />
        </div>
        <div class="form-group">
        <label for="password" class="sr-only"></label>
        <h:inputSecret id="password" styleClass="form-control"
                       value="#{customerController.password}"
		               required="true" requiredMessage="Password is mandatory">
		               <h:outputLabel value="Password" /> </h:inputSecret>
		               <h:message for="password" />
        </div>
        
        <div class="form-group">
				<label for="dateOfBirth" class="sr-only"></label>
				<h:inputText id="dateOfBirth" styleClass="form-control"
					value="#{customerController.dateOfBirth}"
					required="true" requiredMessage="Date of Birth is mandatory">
					<f:convertDateTime pattern="d-M-yyyy" />
					<h:outputLabel value="Date of Birth (dd-mm-yyyy)" />   </h:inputText>
					<h:message for="dateOfBirth" />
				</div>

			
			<h2 class="text-center">Address informations</h2>
				
				<div class="form-group">
				<label for="street" class="sr-only"></label>
                <h:inputText id="street" styleClass="form-control"
		            value="#{customerController.street}"
					required="true"  requiredMessage="Street is mandatory">
					<h:outputLabel value="Street" />   </h:inputText> 
					<h:message for="street" />
				</div>
				
				<div class="form-group">
				<label for="city" class="sr-only"></label>
                <h:inputText id="city" styleClass="form-control"
		            value="#{customerController.city}"
					required="true"  requiredMessage="City is mandatory">
					<h:outputLabel value="City" />   </h:inputText> 
					<h:message for="city" />
				</div>
				
				<div class="form-group">
				<label for="state" class="sr-only"></label>
                <h:inputText id="state" styleClass="form-control"
		            value="#{customerController.state}"
					required="true"  requiredMessage="State is mandatory">
					<h:outputLabel value="State" />   </h:inputText> 
					<h:message for="state" />
				</div>
				
				<div class="form-group">
					<label for="zipcode" class="sr-only"></label>
                <h:inputText id="zipcode" styleClass="form-control"
		            value="#{customerController.zipcode}"
					required="true"  requiredMessage="Zipcode is mandatory">
					<h:outputLabel value="Zipcode" />   </h:inputText> 
					<h:message for="zipcode" />
				</div>
				
				<div class="form-group">
					<label for="country" class="sr-only"></label>
                <h:inputText id="country" styleClass="form-control"
		            value="#{customerController.country}"
					required="true"  requiredMessage="Country is mandatory">
					<h:outputLabel value="Country" />   </h:inputText> 
					<h:message for="country" />
				</div>

			<div class="form-group">
			<h:commandButton
						action="#{customerController.createCustomer}" value="SignUp"></h:commandButton>
			</div>

		
     </form>
     </f:view>
	</div>
	</div>

</body>
</html>