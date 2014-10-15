<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Contractor Profile</title>
    <link href="${pageContext.request.contextPath}/resources/css/site.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/pics.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/rateit.css" rel="stylesheet">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fancybox/source/jquery.fancybox.css?v=2.1.5" type="text/css" media="screen" />

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.rateit.js"></script>
    <!-- Add fancyBox -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fancybox/source/jquery.fancybox.pack.js?v=2.1.5"></script>

    <script type="text/javascript">
      $(document).ready(function() {
        $(".fancybox").fancybox();
      });
    </script>

  </head>
  <body>
    <header>
      <div id="primary_navigation" class="navbar-fixed-top bootstrap3">
        <div class="container">
          
          <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
              <a class="navbar-brand" href="/">Dashboard</a>
            </div>
            <ul class="nav navbar-nav">
              <li class="dropdown ">
                <a id="" href="" class="dropdown-toggle" data-toggle="dropdown" target="">Company</a>    
              </li>
              <li class="dropdown ">
                <a id="" href="" class="dropdown-toggle" data-toggle="dropdown" target="">Reports</a>    
              </li>
              <li class="dropdown ">
                <a id="" href="" class="dropdown-toggle" data-toggle="dropdown" target="">Manage</a>    
              </li>
              <li class="dropdown ">
                <a id="" href="" class="dropdown-toggle" data-toggle="dropdown" target="">Configure</a>    
              </li>
              <li class="dropdown ">
                <a id="" href="" class="dropdown-toggle" data-toggle="dropdown" target="">Dev</a>    
              </li>
              <li class="dropdown ">
                <a id="" href="" class="dropdown-toggle" data-toggle="dropdown" target="">Support</a>    
              </li>
            </ul>
          </nav>

        </div>
      </div>  
    </header>

    <div class="container">
      <div class="row">
        <div class="content-main col-md-9">

          <section class="profile-header col-md-12">
           
              <h1>${contractor.name}</h1>
              <div class="col-md-4">
                <div class="stars-rating">
                    <div class="stars-inner">${contractor.avgRating}</div>
                    <div class="verified-reviews">
                      <a class="fancybox" href="file:///Users/ca00456-mb/Documents/HACKATHON/ContractorReviews/RateContractor.html">Write a Review</a>
                    </div>
                </div>
              </div>

              <div class="col-md-4">
                <p class="heavy" itemprop="telephone">${contractor.phoneNo}</p>
                <p>${contractor.address}</p>
              </div>

              <div class="col-md-4">
                <a href="mailto:someone@example.com?Subject=Hello%20again" target="_top"><button class="btn btn-warning ">Contact</button></a>
              </div>

          </section><!-- end "profile-header" -->

          <div class="clearing"></div>

          <section class="profile-content col-md-12">
            <h3>Profile</h3> 
            <hr>
            <span class="description">
              <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
            </span>

            <div class="col-md-6">
              <div class="profile-service-area">
                <h4 class="green">Service Area</h4>
                <ul>
                  <li>Irvine</li>
                  <li>Orange</li>
                  <li>Newport Beach</li>
                  <li>Hungtinton Beach</li>
                  <li>Costa Mesa</li>
                </ul>
              </div>
            </div>
            
            <div class="col-md-6">
              <div class="profile-business-hours">
                <h4 class="green">Business Hours</h4>
                <p>Monday - Friday 8:00am - 10:00pm</p>
                <p>Saturday - Sunday 8:00am - 10:00pm</p>
                <ul>
                  <li>Warranty Offered</li>
                  <li>Credit Cards Accepted</li>
                  <li>Free Estimates</li>
                </ul>
              </div>
            </div>
          </section><!-- end "profile-content" -->

          <div class="clearing"></div>

          <section class="profile-reviews col-md-12">
            <h3 class="reviews-title">Reviews</h3>

            <a class="fancybox write-review" href="file:///Users/ca00456-mb/Documents/HACKATHON/ContractorReviews/RateContractor.html"><button class="btn btn-default">Write a Review</button></a>

            <div class="clearing"></div>
            <hr>
    	<c:if test="${not empty contractor.reviews}">

            <div class="profile-user-review">
			<c:forEach var="review" items="${contractor.reviews}">
              <div class="stars-rating">
                  <div class="stars-inner stars-profile-review">${review.rating}</div> 
                  <span class="heavy t-stars-rating">${review.rating}</span> 
                  <span class="t-text-pipe">&nbsp;&nbsp;|&nbsp;&nbsp;</span>  
                  <span data="datePublished">${review.date}</span>              
              </div>

              <div class="profile-user-review-body">
                <div class="heavy">
                  <p>Review by&nbsp;<span data="author">${review.author}</span></p>
                </div>
                <div class="profile-user-review-content">
                  <span data="reviewBody">${review.comment}</span>
                </div>
              </div>
			</c:forEach>
            </div>
		</c:if>
          </section><!-- end "profile-reviews" -->

          
        </div> <!-- end "content-main" -->

        <div class="col-md-3">
          <section class="ads">
            <h5>PICS Ads &copy;</h5>
          </section><!-- end "col-md-3 ads" -->

          <section style="margin-bottom: 10px">
            <a href="#"><img src="img/ad3-3.jpg"></a>
          </section>

        </div>

      </div><!-- end "row" -->

    </div> <!-- end "container" -->
    

  
  </body>
</html>