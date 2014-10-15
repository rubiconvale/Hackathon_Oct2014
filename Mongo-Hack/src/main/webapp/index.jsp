<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie11 lt-ie10 lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie11 lt-ie10 lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie11 lt-ie10 lt-ie9"> <![endif]-->
<!--[if IE 9]>         <html class="no-js lt-ie11 lt-ie10"> <![endif]-->
<!--[if !IE]><!-->
<script>
if (/*@cc_on!@*/false) {
    document.documentElement.className+=' lt-ie11';
}
</script>
<!--<![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>PICS - PICS</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->


<script type="text/javascript">window.NREUM||(NREUM={}),__nr_require=function(t,e,n){function r(n){if(!e[n]){var o=e[n]={exports:{}};t[n][0].call(o.exports,function(e){var o=t[n][1][e];return r(o?o:e)},o,o.exports)}return e[n].exports}if("function"==typeof __nr_require)return __nr_require;for(var o=0;o<n.length;o++)r(n[o]);return r}({QJf3ax:[function(t,e){function n(t){function e(e,n,a){t&&t(e,n,a),a||(a={});for(var c=u(e),f=c.length,s=i(a,o,r),p=0;f>p;p++)c[p].apply(s,n);return s}function a(t,e){f[t]=u(t).concat(e)}function u(t){return f[t]||[]}function c(){return n(e)}var f={};return{on:a,emit:e,create:c,listeners:u,_events:f}}function r(){return{}}var o="nr@context",i=t("gos");e.exports=n()},{gos:"7eSDFh"}],ee:[function(t,e){e.exports=t("QJf3ax")},{}],gos:[function(t,e){e.exports=t("7eSDFh")},{}],"7eSDFh":[function(t,e){function n(t,e,n){if(r.call(t,e))return t[e];var o=n();if(Object.defineProperty&&Object.keys)try{return Object.defineProperty(t,e,{value:o,writable:!0,enumerable:!1}),o}catch(i){}return t[e]=o,o}var r=Object.prototype.hasOwnProperty;e.exports=n},{}],D5DuLP:[function(t,e){function n(t,e,n){return r.listeners(t).length?r.emit(t,e,n):(o[t]||(o[t]=[]),void o[t].push(e))}var r=t("ee").create(),o={};e.exports=n,n.ee=r,r.q=o},{ee:"QJf3ax"}],handle:[function(t,e){e.exports=t("D5DuLP")},{}],XL7HBI:[function(t,e){function n(t){var e=typeof t;return!t||"object"!==e&&"function"!==e?-1:t===window?0:i(t,o,function(){return r++})}var r=1,o="nr@id",i=t("gos");e.exports=n},{gos:"7eSDFh"}],id:[function(t,e){e.exports=t("XL7HBI")},{}],loader:[function(t,e){e.exports=t("G9z0Bl")},{}],G9z0Bl:[function(t,e){function n(){var t=l.info=NREUM.info;if(t&&t.agent&&t.licenseKey&&t.applicationID&&c&&c.body){l.proto="https"===p.split(":")[0]||t.sslForHttp?"https://":"http://",a("mark",["onload",i()]);var e=c.createElement("script");e.src=l.proto+t.agent,c.body.appendChild(e)}}function r(){"complete"===c.readyState&&o()}function o(){a("mark",["domContent",i()])}function i(){return(new Date).getTime()}var a=t("handle"),u=window,c=u.document,f="addEventListener",s="attachEvent",p=(""+location).split("?")[0],l=e.exports={offset:i(),origin:p,features:{}};c[f]?(c[f]("DOMContentLoaded",o,!1),u[f]("load",n,!1)):(c[s]("onreadystatechange",r),u[s]("onload",n)),a("mark",["firstbyte",i()])},{handle:"D5DuLP"}]},{},["G9z0Bl"]);</script>
<link rel="stylesheet" href="/employee-guard/build/style.css" />


<!--[if lt IE 9]>
        <script src="/bootstrap3/js/vendor/respond.js?v=7.3.13"></script>
        <link rel="stylesheet" href="/bootstrap3/css/ie8.css?v=7.3.13">
    <![endif]-->

<!--[if lt IE 8]><link rel="stylesheet" href="/bootstrap3/css/vendor/font-awesome/font-awesome-ie7.css?v=7.3.13"><![endif]-->



<script src="/employee-guard/build/script.js"></script>

</head>
<body>
	<div id="main">
		<header>

			<div id="primary_navigation" class="navbar-fixed-top bootstrap3">
				<div id="ie8_primary_navigation_background"></div>
				<div class="container">
					<nav class="navbar navbar-default" role="navigation">
						<div class="navbar-header">


							<a class="navbar-brand" href="/">Dashboard</a>

						</div>
						<ul class="nav navbar-nav">
							<li class="dropdown "><a id="" href=""
								class="dropdown-toggle" data-toggle="dropdown" target="">


									Company </a>


								<ul class="dropdown-menu">
									<li class=" "><a id="contractor_dashboard_menu"
										href="/ContractorView.action?id=63146" class="" data-toggle=""
										target=""> Dashboard </a></li>

									<li class=" "><a id="contractor_notes"
										href="/ContractorNotes.action?id=63146" class=""
										data-toggle="" target=""> Notes </a></li>
									<li class=" "><a id="contractor_trades"
										href="/ContractorTrades.action?id=63146" class=""
										data-toggle="" target=""> Trades </a></li>
									<li class=" "><a id="contractor_facilities"
										href="/ContractorFacilities.action?id=63146" class=""
										data-toggle="" target=""> Client Sites </a></li>
									<li class=" "><a id="users_manage"
										href="/UsersManage.action?account=63146" class=""
										data-toggle="" target=""> Users </a></li>
									<li class=" "><a id="contractor_forms"
										href="/ContractorForms.action" class="" data-toggle=""
										target=""> Resources </a></li>

									<li class=" "><a id="billing_detail"
										href="/BillingDetail.action?id=63146" class="" data-toggle=""
										target=""> Billing Detail </a></li>

									<li class=" "><a id="payment_options"
										href="/ContractorPaymentOptions.action?id=63146" class=""
										data-toggle="" target=""> Payment Options </a></li>
									<li class=" "><a id="contractor_edit"
										href="/ContractorEdit.action?id=63146" class="" data-toggle=""
										target=""> Company Profile </a></li>


								</ul></li>
							<li class="dropdown "><a id="" href=""
								class="dropdown-toggle" data-toggle="dropdown" target="">


									DocuGUARD </a>


								<ul class="dropdown-menu">





















									<li class=" "><a id=""
										href="/ContractorDocuments.action?id=63146" class=""
										data-toggle="" target=""> Summary </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1316947" class="" data-toggle=""
										target=""> PQF </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1316951" class="" data-toggle=""
										target=""> Annual Update 2013 </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1316950" class="" data-toggle=""
										target=""> Annual Update 2012 </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1316949" class="" data-toggle=""
										target=""> Annual Update 2011 </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1316953" class="" data-toggle=""
										target=""> Shell OGP Assessment </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1318811" class="" data-toggle=""
										target=""> Tesoro Security Specific </a></li>


								</ul></li>


















							<li class="dropdown "><a id="" href=""
								class="dropdown-toggle" data-toggle="dropdown" target="">


									AuditGUARD </a>


								<ul class="dropdown-menu">





















									<li class=" "><a id=""
										href="/ContractorDocuments.action?id=63146#auditguard"
										class="" data-toggle="" target=""> Summary </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1316952" class="" data-toggle=""
										target=""> Manual Audit 2014 </a></li>


								</ul></li>


















							<li class="dropdown "><a id="" href=""
								class="dropdown-toggle" data-toggle="dropdown" target="">


									InsureGUARD </a>


								<ul class="dropdown-menu">





















									<li class=" "><a id=""
										href="/ConInsureGUARD.action?id=63146" class="" data-toggle=""
										target=""> Summary </a></li>


















									<li class=" "><a id=""
										href="/ConInsureGUARD.action?id=63146" class="" data-toggle=""
										target=""> Certificates Manager </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1318814" class="" data-toggle=""
										target=""> Automobile Liability '01 </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1318840" class="" data-toggle=""
										target=""> Excess/Umbrella Liability '01 </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1318812" class="" data-toggle=""
										target=""> General Liability '01 </a></li>


















									<li class=" "><a id=""
										href="/Audit.action?auditID=1318810" class="" data-toggle=""
										target=""> Workers Compensation '01 </a></li>


								</ul></li>


















							<li class="dropdown "><a id="" href=""
								class="dropdown-toggle" data-toggle="dropdown" target="">


									EmployeeGUARD </a>


								<ul class="dropdown-menu">





















									<li class=" "><a id=""
										href="/employee-guard/contractor/dashboard" class=""
										data-toggle="" target=""> Summary </a></li>




									<li class=" "><a id=""
										href="/employee-guard/contractor/employee" class=""
										data-toggle="" target=""> Employees </a></li>