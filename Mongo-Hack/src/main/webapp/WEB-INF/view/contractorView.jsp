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


    <script type="text/javascript"
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKqxSWB8GcQPSn61zFa73d3bgJ6BjCebc">
    </script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript">


        function initialize() {
            var center = new google.maps.LatLng(33.655781, -117.778931);

            var map = new google.maps.Map(document.getElementById('map-canvas'), {
                zoom: 12,
                center: center,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            });

            var latArray = [];
            var x = $.makeArray($('.lat'));
            $.each(x, function (index, value) {
                latArray.push(parseFloat(value.innerText));
            });

            var longArray = [];
            var y = $.makeArray($('.long'));
            $.each(y, function (index, value) {
                longArray.push(parseFloat(value.innerText));
            });
            var nameArray = [];
            var x = $.makeArray($('.name'));
            $.each(x, function (index, value) {
                nameArray.push(value.innerText);
            });

            var ratingArray = [];
            var y = $.makeArray($('.rating'));
            $.each(y, function (index, value) {
                ratingArray.push(parseFloat(value.innerText));
            });

            var markers = [];
            for (var i = 0; i < latArray.length; i++) {
                var myLat = latArray[i];
                var myLong = longArray[i];
                var myName = nameArray[i];
                var myRating = ratingArray[i];

                var latLng = new google.maps.LatLng(myLat, myLong);
                var marker = new google.maps.Marker({map: map, position: latLng});
                var avgStars = widthOfDisplay(i, myRating);
                console.log("rating " + myRating + "stars : " + avgStars);
                var infowindow = new google.maps.InfoWindow({
                    content: "<div>" + myName + "</div><div id='" + i + "' class='stars-inner' style='width:" + avgStars + "'></div>"
                });
                infowindow.open(map, marker);
                markers.push(marker);
            }
        }
        ;

        google.maps.event.addDomListener(window, 'load', initialize);
        function widthOfDisplay(id, star) {
            console.log("id : " + id);
            return  widthOfRating = star * 16 + "px";
        }
        function starDisplay(id, star) {
            console.log("id : " + id);
            var widthOfRating = star * 16;
            $('#' + id).css('width', widthOfRating + 'px');

        }
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

                <form name="input" action="/Mongo-Hack/searchContractor" method="GET">
                    <!-- Utility Box-->
                    <div class="utility-box listing-criteria-block-top">
                        <div class="l-left col-md-9">
                            <select name="trade" class="form-control select2Min" onchange="this.form.submit()">
                                <option value="DRILLING" ${'DRILLING' == input.trade ? 'selected': ''}>Drilling
                                </option>
                                <option value="WELDING" ${'WELDING' == input.trade ? 'selected': ''}>Welding
                                </option>
                                <option value="MASONRY" ${'MASONRY' == input.trade ? 'selected': ''}>Masonry
                                </option>
                                <option value="PAINTING" ${'PAINTING' == input.trade ? 'selected': ''}>Painting
                                </option>
                                <option value="ELECTRICIAN" ${'ELECTRICIAN' == input.trade ? 'selected': ''}>
                                    Electrician
                                </option>
                                <option value="JANITORIAL" ${'JANITORIAL' == input.trade ? 'selected': ''}>
                                    Janitorial
                                </option>
                            </select>

                            <input id="zip" class="input-text" placeholder="Enter ZIP" validate="zip" type="text"
                                   value="${input.zipCode}" maxlength="5" name="zipCode">

                            <button id="change-service" class="btn btn-default btn-xs"
                                    class="button-standard button-small" type="submit">
                                Search
                            </button>
                        </div>
   
                        <div class="l-right col-md-3">
                            <label for="rating">Filter By:</label>
                            <select id="rating" name="rating" class="form-control-sortBy" onchange="this.form.submit()">
                                <option value="5" ${5 == input.rating ? 'selected' : ''}>5-Star</option>
                                <option value="4" ${4 == input.rating ? 'selected' : ''}>4-Star</option>
                                <option value="3" ${3 == input.rating ? 'selected' : ''}>3-Star</option>
                                <option value="2" ${2 == input.rating ? 'selected' : ''}>2-Star</option>
                                <option value="1" ${1 == input.rating ? 'selected' : ''}>1-Star</option>
                            </select>
                        </div>
                    </div>
                </form>

                <!-- Separator -->
                <div class="featured-separator">FEATURED</div>
            <!-- Separator -->
            <section style="margin-bottom: 10px">
             <div id="map-canvas"></div>
            </section>

                <!-- Listing Information -->
                <c:if test="${not empty contractors}">
                    <c:forEach var="contractor" items="${contractors}">

                        <div class="listing utility-box">
                            <div>
                                    <%--<h4 class="col-md-12 c-title">${contractor.name}</h4>--%>

                                <h4 class="col-md-12 c-title">${contractor.name}</h4>

                                <div class="col-md-3">
                                    <div class="stars-rating">
                                        <div id="${contractor.id}" class="stars-inner">
                                            <script type="text/javascript">starDisplay("${contractor.id}", ${contractor.avgRating})</script>
                                        </div>
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
                                    <div class="lat" style="display: none;">${contractor.latitute}</div>
                                    <div class="long" style="display: none;">${contractor.logitute}</div>
                                    <div class="name" style="display: none;">${contractor.name}</div>
                                    <div class="rating" style="display: none;">${contractor.avgRating}</div>
                                </div>
                                <div class="col-md-3">
                                    <p>We are PICS contractors and we Love it!.</p>

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

          <section class="top-ad">
            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/ad3-3.jpg"></a>
          </section>

            <hr class="ads-separator">

            <section>
                <a href="#"><img src="${pageContext.request.contextPath}/resources/img/ad1-3.jpg"></a>
            </section>
        </div>
    </div>
</div>


</body>
</html>