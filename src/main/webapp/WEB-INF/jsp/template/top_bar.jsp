<%-- 
    Document   : top_bar
    Created on : Dec 5, 2014, 10:13:30 AM
    Author     : nogsantos
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ls-topbar">
    <div class="ls-notification-topbar">
        <div class="ls-alerts-list">
            <a href="#" class="ls-ico-bell-o" data-counter="8" data-ls-module="topbarCurtain" data-target="#ls-notification-curtain"><span>${t['tit.notification']}</span></a>
        </div>
        <div data-ls-module="dropdown" class="ls-dropdown ls-user-account">
            <a href="#" class="ls-ico-user">
                <span class="ls-name">${sysuser_session.name}</span>
            </a>
            <nav class="ls-dropdown-nav ls-user-menu">
                <ul>
                    <li><a href="${linkTo[SysuserController].update}${sysuser_session.id}">${t['tit.account']}</a></li>
                    <li><a href="" data-toggle="modal" data-target="#changePasswordForm" data-userid="${sysuser_session.id}">${t['tit.change_password']}</a></li>
                    <li><a href="${linkTo[IndexController].logout}" >${t['tit.exit_system']}</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <h1 class="ls-brand-name">
        <div class="ls-ico-mobile">
            ${t['sys.name']}
        </div>
    </h1>
    <span id="info-time"></span>
</div>