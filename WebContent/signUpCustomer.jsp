<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="e-commerce web site">
    <meta name="author" content="Stojani">

    <title>SignUp</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">


      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

  </head>
  <body>

    <div class="container">

      <form class="form-signup">
        <h2 class="form-signup-heading">Sign up</h2>
        <div>
        <label for="inputFirstName" class="sr-only">FirstName</label>
        <h:inputText id="inputFirstName" styleClass="form-control"
					value="#{customerController.firstName}"
					required="true"  requiredMessage="First Name is mandatory">
					<h:outputLabel value="First Name" />   </h:inputText>
					<h:message for="inputFirstName" />
		</div>
		<div>			
        <label for="inputLastName" class="sr-only">LastName</label>
        <h:inputText id="inputLastName" styleClass="form-control"
					value="#{customerController.lastName}"
					required="true"  requiredMessage="Last Name is mandatory">
					<h:outputLabel value="Last Name" />   </h:inputText>  
					<h:message for="inputLastName" />
		</div> 
		<div>			  
        <label for="inputDateOfBirth" class="sr-only">Date of birth</label>
        <h:inputText id="inputLastName" styleClass="form-control"
					value="#{customerController.dateOfBirth}"
					required="true"  requiredMessage="Date of birth is mandatory">
					<h:outputLabel value="Date of birth" />   </h:inputText> 
					<h:message for="inputDateOfBirth" />
		</div> 
		<div>				
		<label for="inputAddress" class="sr-only">Address</label>
		<h:inputText id="inputAddress" styleClass="form-control"
		            value="#{customerController.address}"
					required="true"  requiredMessage="Address is mandatory">
					<h:outputLabel value="Address" />   </h:inputText> 
					<h:message for="inputAddress" />
		</div>
		<div>      
        <label for="inputEmail" class="sr-only">Email</label>
        <h:inputText id="inputEmail" styleClass="form-control"
		            value="#{customerController.address}"
					required="true"  requiredMessage="Email is mandatory">
					<h:outputLabel value="Email" />   </h:inputText> 
					<h:message for="inputEmail" />
        </div>
        <div>
        <label for="inputPassword" class="sr-only">Password</label>
        <h:inputSecret id="inputPassword" styleClass="form-control"
                       value="#{customerController.password}"
		               required="true" requiredMessage="Password is mandatory">
		               <h:outputLabel value="Password" /> </h:inputSecret>
		               <h:message for="inputPassword" />
        </div>
        <div>
				<div class="checkbox"></div> 
				<h:commandLink action="#{customerController.signUp}">
					<button class="btn btn-lg btn-primary btn-block" type="submit">SignUp</button>
				</h:commandLink>
				</div>
      </form>

    </div> <!-- /container -->
    
    <!-- Bootstrap core JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>