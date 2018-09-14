<%-- 
    Document   : account
    Created on : Dec 5, 2014, 10:17:18 AM
    Author     : nogsantos
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div data-ls-module="dropdown" class="ls-dropdown ls-user-account">
    <a href="#" class="ls-ico-user">
        <span class="ls-name"><small>${user}</small></span>
    </a>
    <nav class="ls-dropdown-nav ls-user-menu">
        <ul>
            <li><a href="#">${t['tit.account']}</a></li>
        </ul>
        <a href="<c:url value="/"/>" class="ls-btn-logout">${t['tit.exit_system']}</a>
    </nav>
</div>