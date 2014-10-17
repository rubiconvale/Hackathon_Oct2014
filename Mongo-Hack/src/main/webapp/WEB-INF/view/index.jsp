<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PICS Organizer Review Search</title>
    <base href="${pageContext.request.contextPath}">
    <!-- Bootstrap -->

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/theme.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/image_under.css" rel="stylesheet">
    
    <link href='http://fonts.googleapis.com/css?family=Fjalla+One' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed' rel='stylesheet' type='text/css'>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>


  <body role="document">
	<form:form method="GET" action="/Mongo-Hack/searchContractor" modelAttribute="input">
 
      <div class="nav-bar">
        <div class="container">
        <header class="page-header">
          <h1 class="logo"><a href="#"></a></h1>
        </header>

        </div>
      </div>
    <div class="image_under">

     <img src="${pageContext.request.contextPath}/resources/img/slide1_08_big1.jpg">

     <div class="col">

      <!-- Main jumbotron for a primary marketing message or call to action -->

      <div class="jumbotron">

        <h1 class="review-guard">ReviewGUARD</h1>

        <h2 class="review-guard">Find Trusted Contracting Pros</h2>


        <div class="row">

        <div class="col-lg-6">

	<select class="form-control">
		<option>Choose a Trade</option>
		<option value="ELECTRICIAN">Electrician</option>
		<option value="PLUMBING">Plumbing</option>
		<option value="JANITORIAL">Janitorial</option>
		<option value="WELDING">Welding</option>
		<option value="DRILLING">Drilling</option>
		<option value="PAINTING">Painting</option>
		<option value="MASONRY">Masonry</option>
	</select>
             </div>


        <div class="col-lg-2">


	<input type="text" class="form-control" placeholder="Enter Zip">

             </div>


        <div class="col-lg-3">
            <button type="submit"  class="btn btn-primary">Find Contractor Reviews</button>
             </div>
          </div>  <!-- end row -->

      </div> <!-- jumbotron-->

</div>
     <div class="well">
        <p>Copyright (c) 2014 PICS Auditing, LLC | Contact Us | Privacy Policy </p>
      </div>

    </div> <!-- /container -->

        </form:form>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

  </body>
</html>