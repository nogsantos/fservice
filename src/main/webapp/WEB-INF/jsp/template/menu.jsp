<%-- 
Document   : menu
    Created on : Dec 5, 2014, 10:16:11 AM
    Author     : nogsantos
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside class="ls-sidebar">
    <div class="ls-sidebar-inner">
        <a href="/main"  class="ls-go-prev"><span class="ls-text">Voltar &agrave; lista de servi&ccedil;os</span></a>
        <nav class="ls-menu">
            <ul>
                <li><a href="${linkTo[MainController].index}" class="ls-ico-dashboard" title="${t['tit.dashboard']}">${t['tit.dashboard']}</a></li>
                <li><a href="${linkTo[SysuserController].index}" class="ls-ico-users">${t['tit.users']}</a></li>
                <li><a href="${linkTo[SysroleController].index}" class="ls-ico-book">${t['tit.role']}</a></li>
            </ul>
        </nav>
    </div>    
</aside>
