<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Review Results</title>
    <base href="${pageContext.request.contextPath}">
    <link href="${pageContext.request.contextPath}/resources/css/site.css" type="text/css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/css/pics.css" type="text/css" rel="stylesheet">

    <!-- Bootstrap -->
    <%--<link href="<c:url value="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>" rel="stylesheet">--%>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

    <script type="text/javascript"
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKqxSWB8GcQPSn61zFa73d3bgJ6BjCebc">
    </script>
    <script type="text/javascript">
        function initialize() {
            var mapOptions = {
                center: { lat: 33.683, lng: -117.794},
                zoom: 8
            };
            var map = new google.maps.Map(document.getElementById('map-canvas'),
                    mapOptions);
        }
        google.maps.event.addDomListener(window, 'load', initialize);
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
        <div class="col-md-9">
            <h1>Contractor Reviews</h1>

            <div class="content-main">

                <!-- Utility Box-->
                <div class="utility-box listing-criteria-block-top">
                    <div class="l-left col-md-9">
                        <form id="trades-form" action="" method="post">
                            <select name="trades" class="form-control select2Min">
                                <option value="0">Drilling</option>
                                <option value="1">Welding</option>
                                <option value="2">Masonry</option>
                                <option value="3">Painting</option>
                            </select>

                            <input id="zip" class="input-text" placeholder="Enter ZIP" validate="zip" type="text"
                                   value="" maxlength="5">

                            <button id="change-service" class="btn btn-default btn-xs" name="search"
                                    class="button-standard button-small">
                                Search
                            </button>
                        </form>
                    </div>
                    <div class="l-right col-md-3">
                        <form id="rating-form" action="" method="post" name="">
                            <label for="sortBy">Sort By:</label>
                            <select id="sortBy" class="form-control-sortBy" name="sortBy" onchange="">
                                <option value="0">5-Star</option>
                                <option value="1">4-Star</option>
                                <option value="2">3-Star</option>
                                <option value="3">2-Star</option>
                                <option value="4">1-Star</option>
                            </select>
                        </form>
                    </div>
                </div>

                <!-- Separator -->
                <div class="featured-separator">FEATURED</div>

                <!-- Listing Information -->
                <c:if test="${not empty contractors}">
                    <c:forEach var="contractor" items="${contractors}">
                        <div class="listing utility-box">
                            <div>
                                <%--<h4 class="col-md-12 c-title">${contractor.name}</h4>--%>

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

                                    <p>${contractor.address}</p>

                                    <p>${contractor.city}, ${contractor.state} ${contractor.zipCode}</p>

                                    <div></div>
                                </div>
                                <div class="col-md-3">
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                    <a href="#">See More...</a>
                                </div>
                                <div class="col-md-3">
                                    <a href="/Mongo-Hack/profile?id=${contractor.id}">
                                        <button class="btn btn-warning">Profile</button>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>


                <%--<h2>Submitted Employee Information</h2>--%>
                <%--<table>--%>
                <%--<c:if test="${not empty contractors}">--%>
                <%--<c:forEach var="contractor" items="${contractors}">--%>
                <%--<div class="listing utility-box">--%>
                <%--<div>--%>
                <%--<h4 class="col-md-12 c-title">Contractor</h4>--%>

                <%--<div class="col-md-3">--%>
                <%--<div class="stars-rating">--%>
                <%--<div class="stars-inner">${contractor.id} ${contractor.name}${contractor.avgRating} phone--%>
                <%--: ${contractor.phoneNo} ${contractor.address} ${contractor.city} ${contractor.state}</div>--%>
                <%--</div>--%>
                <%--<div class="verified-reviews">--%>
                <%--<a href="#">Reviews</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--<div class="col-md-3">--%>
                <%--<p class="heavy" itemprop="telephone">${contractor.phoneNo}</p>--%>

                <%--<p></p>--%>

                <%--<div></div>--%>
                <%--</div>--%>
                <%--<div class="col-md-3">--%>
                <%--<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>--%>
                <%--<a href="#">See More...</a>--%>
                <%--</div>--%>
                <%--<div class="col-md-3">--%>
                <%--<a href="/Mongo-Hack/profile?id=${contractor.id}">--%>
                <%--<button class="btn btn-warning">Profile</button>--%>
                <%--</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</c:forEach>--%>
                <%--</c:if>--%>
                <%--</table>--%>

                <!-- Utility Box-->
                <div class="utility-box-ad listing-criteria-block-bottom">
                    <a href="#"><img src="${pageContext.request.contextPath}/resources/img/l-ad.jpg"></a>
                </div>

                <div class="utility-box-pagination listing-criteria-block-top ">
                    <span class="col-md-6">Showing 1-5 of 50</span>

                    <div class="col-md-6">
                        <ul class="pagination">
                            <li><a href="#"><</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">></a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-md-3">

            <section style="margin-bottom: 10px">
                <div id="map-canvas"></div>
            </section>

            <hr class="ads-separator">

            <section>
                <a href="#"><img src="${pageContext.request.contextPath}/resources/img/ad3-3.jpg"></a>
            </section>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>