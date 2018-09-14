<%-- 
    Document   : head
    Created on : Dec 4, 2014, 8:26:19 PM
    Author     : nogsantos
libs:
    http://getbootstrap.com/
    http://fontawesome.io/
    http://locaweb.github.io/locawebstyle/
    http://jquery.com/download/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="ls-theme-light-green ls-html-nobg" ng-app="fService">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<head>
  <title>${t['sys.name']}</title>
  <meta charset="utf-8">
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  <meta name="mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <link rel="icon" sizes="192x192" href="<c:url value="/images/ico-painel2.png" />">
  <link rel="apple-touch-icon" href="<c:url value="/images/ico-painel2.png" /> ">
  <meta name="apple-mobile-web-app-title" content="Painel 2">
  <!--style-->
  <link href="<c:url value="/bower_components/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/bower_components/bootstrap/dist/css/bootstrap-theme.min.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/bower_components/locawebstyle/dist/stylesheets/locastyle.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/bower_components/fontawesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/bower_components/chosen/chosen.min.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/bower_components/lou-multiselect/css/multi-select.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/bower_components/angular/angular-csp.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/bower_components/datatables/media/css/jquery.dataTables.min.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/bower_components/datatables/media/css/jquery.dataTables_themeroller.css"/>" rel="stylesheet" type="text/css" />
  
  <link href="<c:url value="/css/app.css"/>" rel="stylesheet" type="text/css" />
  <!--script-->
  <script src="<c:url value="/bower_components/jquery/dist/jquery.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/bower_components/angular/angular.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/bower_components/angular-resource/angular-resource.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/bower_components/angular-route/angular-route.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/bower_components/bootstrap/dist/js/bootstrap.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/bower_components/locawebstyle/dist/javascripts/locastyle.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/bower_components/moment/min/moment-with-locales.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/bower_components/chosen/chosen.jquery.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/bower_components/lou-multiselect/js/jquery.multi-select.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/bower_components/datatables/media/js/jquery.dataTables.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/js/session_countdown.js"/>" type="text/javascript"></script>    
  <script type="text/javascript">
    /*
     */
    $(window).load(function() {
        locastyle.browserUnsupportedBar.init();
    });    
  </script>
  <script src="<c:url value="/js/app.js"/>" type="text/javascript"></script>    
</head>