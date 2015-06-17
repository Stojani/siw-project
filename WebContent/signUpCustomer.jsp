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
            <label for="inputFirstName" class="sr-only">FirstName</label>
		    <h:inputText id="inputFirstName" styleClass="form-control"
					value="#{customerController.firstName}"
					required="true"  requiredMessage="First Name is mandatory">
					<h:outputLabel value="First Name" />   </h:inputText>
					<h:message for="inputFirstName" />
		    </div>
            <div class="form-group">
			<label for="inputLastName" class="sr-only">LastName</label>
        <h:inputText id="inputLastName" styleClass="form-control"
					value="#{customerController.lastName}"
					required="true"  requiredMessage="Last Name is mandatory">
					<h:outputLabel value="Last Name" />   </h:inputText>  
					<h:message for="inputLastName" />
		</div> 

			<div class="form-group">      
        <label for="inputEmail" class="sr-only">Email</label>
        <h:inputText id="inputEmail" styleClass="form-control"
		            value="#{customerController.email}"
					required="true"  requiredMessage="Email is mandatory">
					<h:outputLabel value="Email" />   </h:inputText> 
					<h:message for="inputEmail" />
        </div>
        <div class="form-group">
        <label for="inputPassword" class="sr-only">Password</label>
        <h:inputSecret id="inputPassword" styleClass="form-control"
                       value="#{customerController.password}"
		               required="true" requiredMessage="Password is mandatory">
		               <h:outputLabel value="Password" /> </h:inputSecret>
		               <h:message for="inputPassword" />
        </div>

			
			<h2 class="text-center">Address informations</h2>
				
				<div class="form-group">
				<label for="inputStreet" class="sr-only">Street</label>
                <h:inputText id="inputStreet" styleClass="form-control"
		            value="#{customerController.street}"
					required="true"  requiredMessage="Street is mandatory">
					<h:outputLabel value="Street" />   </h:inputText> 
					<h:message for="inputStreet" />
				</div>
				
				<div class="form-group">
				<label for="inputCity" class="sr-only">City</label>
                <h:inputText id="inputCity" styleClass="form-control"
		            value="#{customerController.city}"
					required="true"  requiredMessage="City is mandatory">
					<h:outputLabel value="City" />   </h:inputText> 
					<h:message for="inputCity" />
				</div>
				
				<div class="form-group">
				<label for="inputState" class="sr-only">State</label>
                <h:inputText id="inputState" styleClass="form-control"
		            value="#{customerController.state}"
					required="true"  requiredMessage="State is mandatory">
					<h:outputLabel value="State" />   </h:inputText> 
					<h:message for="inputState" />
				</div>
				
				<div class="form-group">
					<label for="inputZipcode" class="sr-only">Zipcode</label>
                <h:inputText id="inputZipcode" styleClass="form-control"
		            value="#{customerController.zipcode}"
					required="true"  requiredMessage="Zipcode is mandatory">
					<h:outputLabel value="Zipcode" />   </h:inputText> 
					<h:message for="inputZipcode" />
				</div>
				
				<div class="form-group">
					<label for="inputCountry" class="sr-only">Country</label>
                <h:inputText id="inputCountry" styleClass="form-control"
		            value="#{customerController.country}"
					required="true"  requiredMessage="Country is mandatory">
					<h:outputLabel value="Country" />   </h:inputText> 
					<h:message for="inputCountry" />
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