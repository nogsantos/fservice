<%-- 
    Document   : template
    Created on : Dec 5, 2014, 3:34:46 PM
    Author     : nogsantos
--%>
<%@ include file="/WEB-INF/jsp/template/head.jsp" %>
<body>
    <div class="ls-login-parent">
        <div class="ls-login-inner">
            <div class="ls-login-container">
                <div class="ls-login-box">                    
                    <h4 class="text-center"><small>${t['tit.welcome']}!</small></h4>
                    <h1 class="ls-login-logo">
                        <img title="FService" alt="FService" width="120" src="<c:url value="img/android_work.png"/>" />
                    </h1>
                    <c:if test="${not empty return_message}">
                        <div class="alert alert-warning text-center" role="alert">
                            ${t[return_message]}
                        </div> 
                    </c:if>
                    <form role="form" class="ls-form ls-login-form" action="${linkTo[IndexController].doLogin}" method="post">
                        <fieldset>
                            <label class="ls-label">
                                <b class="ls-label-text ls-hidden-accessible">${t['tit.login']}</b>
                                <input class="ls-login-bg-user ls-field-lg" type="text" onkeydown="this.value = this.value.toLowerCase();" placeholder="${t['tit.login']}" name="sysuser.login" autocomplete="off" required autofocus>
                            </label>
                            <label class="ls-label">
                                <b class="ls-label-text ls-hidden-accessible">${t['tit.password']}</b>
                                <div class="ls-prefix-group">
                                    <input id="password_field" class="ls-login-bg-password ls-field-lg" type="password" placeholder="${t['tit.password']}" name="sysuser.password" autocomplete="off" required>
                                    <a class="ls-label-text-prefix ls-toggle-pass ls-ico-eye" data-toggle-class="ls-ico-eye, ls-ico-eye-blocked" data-target="#password_field" href="#"></a>
                                </div>
                            </label>
                            <input type="submit" value="${t['tit.enter']}" class="ls-btn-primary ls-btn-block ls-btn-lg">
                        </fieldset>
                    </form>
                    <h6 class="text-center"><small>${current_year}</small></h6>
                </div>
            </div>
        </div>
    </div>
</body>
</html>