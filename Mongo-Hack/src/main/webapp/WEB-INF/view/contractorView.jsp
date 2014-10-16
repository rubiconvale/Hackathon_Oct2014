<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Review Results</title>
    <base href="${pageContext.request.contextPath}">
    <link href="${pageContext.request.contextPath}/resources/css/site.css" type="text/css" rel="stylesheet" >

    <link href="${pageContext.request.contextPath}/resources/css/pics.css" type="text/css" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

<body>
    <h2>Submitted Employee Information</h2>
    <table>
    	<c:if test="${not empty contractors}">
			<c:forEach var="contractor" items="${contractors}">
            <div class="listing utility-box">
              <div>
                <h4 class="col-md-12 c-title">${contractor.name}</h4>
                <div class="col-md-3">
                  <div class="stars-rating">
                    <div class="stars-inner">${contractor.avgRating}</div>
                  </div>
                  <div class="verified-reviews">
                    <a href="#">Reviews</a>
                  </div>
                </div>
                <div class="col-md-3">
                  <p class="heavy" itemprop="telephone">${contractor.phoneNo}</p>
                  <p></p>
                  <div></div>
                </div>
                <div class="col-md-3">
                  <p class="heavy" itemprop="address">${contractor.address}, ${contractor.city}, ${contractor.state}, ${contractor.zipCode} </p>
                </div>
                <div class="col-md-3">
                  <a href="/Mongo-Hack/profile?id=${contractor.id}"><button class="btn btn-warning">Profile</button></a>
                </div>
              </div>
            </div>
			</c:forEach>
	</c:if>
    </table>
</body>
</html>