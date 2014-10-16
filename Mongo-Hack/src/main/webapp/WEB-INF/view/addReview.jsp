<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Rate Contractor</title>
    <link href="${pageContext.request.contextPath}/resources/css/site.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/pics.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/rateit.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container-review-form">
    <div class="row">

        <div class="t-border l-left review-form-container l-top-space">
            <h3 class="t-header-big l-no-margin t-header-box t-underline">Rate Your Overall Experience</h3>
            <div class="review-form l-utility-box-padding">

                <form id="ratingReviewForm" name="review" action="/Mongo-Hack/addReview" method="POST">
                    <input type="hidden" name="contractorId" value="${contractorId}"/>

                    <div class="form-row">
                        <div class="form-questions col-md-3">
                            <label for="relationship">Author<span class="t-required">*</span></label>
                        </div>

                        <div class="col-md-8">
                            <input id="relationship4" name="author" onclick="document.getElementById('specify-relationship').focus();" type="text" placeholder="Name">
                        </div>
                    </div>

                    <div class="form-row">

                        <div class="form-questions col-md-3">
                            <label for="recommend">Comment:<span class="t-required">*</span></label>
                        </div>

                        <div class="col-md-8">
                            <textarea rows="7" cols="70" name="comment"></textarea>
                        </div>

                    </div>


                    <div class="form-row">
                        <div class="form-questions col-md-3">
                            <label for="overallRating">What is your overall rating of this business?<span class="t-required">*</span></label>
                        </div>

                        <div class="form-answers col-md-8">

                            <div class="rateit" id="rateit5" data-rateit-min="">
                            </div>

                            <div>
                                <span id="value5"></span>
                                <span id="hover5"></span>
                            </div>

                            <%--<div>--%>
                                <%--<label>Rating</label>--%>
                                <%--<input name="rating"/>--%>
                            <%--</div>--%>

                        </div>
                    </div>

                    <div class="clearing"></div>
                    <div class="form-row">
                        <%--<button class="btn btn-success btn-review" type="submit">Submit&nbsp;></button>--%>
                        <input class="btn btn-success btn-review" type="submit" value="Submit"/>
                    </div>
                </form>
            </div>
        </div>


    </div> <!-- end of "row" -->
</div> <!-- end of "content main" -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.rateit.js"></script>

<script type="text/javascript">
    $("#rateit5").bind('rated', function (event, value) { $('#value5').text('You\'ve rated it: ' + value); });
    $("#rateit5").bind('reset', function () { $('#value5').text('Rating reset'); });
    // $("#rateit5").bind('over', function (event, value) { $('#hover5').text('Hovering over: ' + value); });
</script>
</body>
</html>








<%--<html>--%>
<%--<head>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h3>Welcome, Enter The Employee Details</h3>--%>
<%--&lt;%&ndash;<form method="POST" action="/Mongo-Hack/addReview" name="review">&ndash;%&gt;--%>
<%--<form name="review" action="/Mongo-Hack/addReview" method="POST"/>--%>
    <%--<input type="hidden" name="contractorId" value="${contractorId}"/>--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td><label>Name</label></td>--%>
            <%--<td><input name="author"/></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td><label>Comment</label></td>--%>
            <%--<td><input name="comment"/></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td><label>Rating</label></td>--%>
            <%--<td><input name="rating"/></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td><input type="submit" value="Submit"/></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>