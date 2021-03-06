<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="e-commerce web site">
    <meta name="author" content="Stojani">

    <title>E-COMMERCE WEB SITE</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <link href="bootstrap/css/carousel.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">E-COMMERCE</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">E-COMMERCE</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Administration Area <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="loginAdministrator.xhtml">Login as administrator</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="home" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#home" data-slide-to="0" class="active"></li>
        <li data-target="#home" data-slide-to="1"></li>
        <li data-target="#home" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="http://informatica.digitalmatik.com/e107_images/custom/e-commerce3.png" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>WELCOME TO THE E-COMMERCE WEB SITE</h1>
              <p>If you're interested about our products and wont to make an order you've to be registered as a customer </p>
              <p><a class="btn btn-lg btn-primary" href="newCustomer.xhtml" role="button">Sign up now</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="http://thenextweb.com/wp-content/blogs.dir/1/files/2013/12/customer-people.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Login</h1>
              <p>If you're already registered as an our customer you can login here</p>
              <p><a class="btn btn-lg btn-primary" href="loginCustomer.xhtml" role="button">Login now</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="http://www.pymecontrol.cl/img/slide/slides/4.jpg?1438128014270" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Browse our catalog</h1>
              <p>If you wont to browse our products (isn't necessary to be our customer)</p>
              <p><a class="btn btn-lg btn-primary" href="productsCatalog.xhtml" role="button">Browse now</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#home" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#home" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
          <h2>New Product!</h2>
          <p>we have added some new products to our catalog. Browse them now!</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
          <h2>New Provider!</h2>
          <p>we have make a new agreement with a new Provider!</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
          <h2>News!</h2>
          <p>to write...</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->

      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2015 Stojani &middot; </p>
      </footer>

    </div><!-- /.container -->


     <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!--T o make our placeholder images work. -->
    <script src="bootstrap/js/holder.js"></script>
  </body>
</html>