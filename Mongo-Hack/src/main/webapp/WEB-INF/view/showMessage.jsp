<%--
Document   : basicForm
Created on : Oct 11, 2011, 9:03:28 PM
Author     : home
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
html { height: 100% }
body { height: 100%; margin: 0; padding: 0 }
#map_canvas { height: 100% }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<title>spring-mvc-showcase</title>
<link href="<c:url value="/resources/css/custom-theme/jquery-ui-1.8.16.custom.css" />" rel="stylesheet" type="text/css" />
 
<script type="text/javascript"
src="http://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&sensor=true">
</script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.6.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.8.16.custom.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.button.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.core.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.widget.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/datatable/js/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/datatable/js/jquery.json-2.3.js" />"></script>
<script>
$(document).ready(function() {
 
 
 
$("button").button();
var name= $("input[name='name']").val();
var lon =$("input[name='logitute']").val();
var lat =$("input[name='latitute']").val();
 
initialize(lat, lon);
});
function initialize(lat, lon,name)
{
 
// var latlng = new google.maps.LatLng(1.385001, 103.756047);
var latlng = new google.maps.LatLng(lat, lon);
var myOptions = {
zoom: 15,
center: latlng,
mapTypeId: google.maps.MapTypeId.ROADMAP
};
var map = new google.maps.Map(document.getElementById("map_canvas"),
myOptions);
var marker = new google.maps.Marker({
position: latlng,
title:name
});
marker.setMap(map);
var circle = new google.maps.Circle({
map: map,
radius: 1000    // metres
//fillColor: '#AA0000'
});
circle.bindTo('center', marker, 'position');
google.maps.event.addListenerOnce(map, 'idle', function(){
 
});
}
function test()
{
var lon =$("input[name='logitute']").val();
var lat =$("input[name='latitute']").val();
var url = "../mapnearby/" + lon + "/" + lat + "/1.9";
 
var results="";
$.getJSON(url, function(data) {
 
 
results = "<b>Found near by result </b> </br>"
for(var i=0, l=data.results.length; i < l ;   i++)
{
// Process each image
// alert(results +data.results[i].name);
results = results +data.results[i].obj.name;
results = results +  "<a href=\"/mongospring-1.0-SNAPSHOT/mapview/"+  data.results[i].obj.name + "\"> " +  data.results[i].obj.name + " Distance " +  data.results[i].dis +"</a></br>" ;
}
$.each(data, function(i,item){
// results = results +"<a href=\"/mongospring-1.0-SNAPSHOT/mapview/"+  item.obj.name + "\"> " + "item.obj.businessName" + "test " +item.obj.name + "</a></br>" ;
});
});
 
$('#result').html(results);
}
</script>
<style type="text/css">
*{
margin:0;
padding:0;
font:bold 12px "Lucida Grande", Arial, sans-serif;
}
body {
padding: 10px;
}
#status{
width:250px;
padding:10px;
outline:none;
height:36px;
}
 
</style>
</head>
<body >
<form:form modelAttribute="locationbean" method="post" >
<h2>Its for Map Data details back to MongoDB</h2>
<table>
<tr>
<td> <div> Location name </div></td>
<td>
<form:input path="name"/>
</br></td>
</tr>
<tr>
<td>  <div> Business Name </div></td>
<td>
<form:input path="businessName"/>
</br></td>
</tr>
<tr>
<td>
 
<div> Type </div></td>
<td>
<form:input path="type"/>
 
</td>
</tr>
<tr>
<td><div>Longitute </div></td>
<td>  <form:input path="logitute"/>
</td>
</tr>
<tr>
<td><div> Latitute </div></td>
<td>  <form:input path="latitute"/>
</td>
</tr>
 
</table>
 
 
  
</form:form>
 
 
</button>
<div id="map_canvas" style="width:300px; height:300px"></div>
<br/>
<div id="dynamic">
<input type="button" onclick="test()" value="Search Near By Locations"/>
<div id="result"></div>
 
</body>
</html>