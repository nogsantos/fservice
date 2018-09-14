<%-- 
    Document   : 404
    Created on : Dec 19, 2014, 4:52:03 PM
    Author     : nogsantos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ include file="/WEB-INF/jsp/template/head.jsp" %>
<body>
    <div class="container">
        <div class="page-header">
            <div class="row">
                <h1 class="ls-ico-mobile">${t['sys.name']}</h1>
            </div>
            <div class="row text-center">
                <i class="fa fa-lock fa-5x"></i>
                <h1><small>${t['alert.permission_required']}</small></h1>
            </div>
            <div class="row text-center">
                <a class="btn btn-default" href="${linkTo[IndexController].index}"><i class="fa fa-user"></i> ${t['tit.login_form']}</a>
            </div>
        </div>
    </div>
</body>
</html>