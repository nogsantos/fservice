<%-- 
    Document   : template
    Created on : Dec 5, 2014, 3:34:46 PM
    Author     : nogsantos
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<t:insertTemplate template="/WEB-INF/jsp/template/head.jsp"/>
<body>
    <t:insertTemplate template="/WEB-INF/jsp/template/top_bar.jsp"/>
    <t:insertTemplate template="/WEB-INF/jsp/template/menu.jsp"/>
    <t:insertTemplate template="/WEB-INF/jsp/template/account.jsp"/>
    <main class="ls-main ">
        <div class="container-fluid">
            <div class="row text-right" style="color: #C4C4C4;" id="countdown-container">
                <div>${t['tit.session_time']}:&nbsp;<i>[&nbsp;<span id="countdown"><%= session.getMaxInactiveInterval() %></span>&nbsp;]</i>&nbsp;${t['tit.seconds']}</div>
            </div>
            <t:insertAttribute name="body"/>
        </div>
        <t:insertTemplate template="/WEB-INF/jsp/template/footer.jsp"/>
    </main>
    <t:insertTemplate template="/WEB-INF/jsp/template/notificacoes.jsp"/>
    <div class="modal fade" id="changePasswordForm" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel"></h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label for="recipient-name" class="control-label">Recipient:</label>
                            <input type="text" class="form-control" id="recipient-name">
                        </div>
                        <div class="form-group">
                            <label for="sysuser_password_old" class="control-label">${t['tit.password']} (${t['tit.old']})</label>
                            <input type="password" data-ls-module="charCounter" maxlength="15" autocomplete="off" class="form-control password_field" required id="sysuser_password_old" name="password_old" value="">
                        </div>
                        <div class="form-group">
                            <label for="sysuser_password" class="control-label">${t['tit.password']} (${t['tit.new']})</label>
                            <input type="password" data-ls-module="charCounter" maxlength="15" autocomplete="off" class="form-control password_field" required id="sysuser_password" name="sysuser.password" value="">
                        </div>
                        <div class="form-group">
                            <label for="sysuser_password_confirm" class="control-label">${t['tit.password_confirm']}</label>
                            <input type="password" data-ls-module="charCounter" maxlength="15" autocomplete="off" class="form-control password_field" required id="sysuser_password_confirm" name="password_confirm" equalTo="sysuser_password" value="">
                        </div>
                        <a class="ls-label-text-prefix ls-toggle-pass ls-ico-eye" data-toggle-class="ls-ico-eye, ls-ico-eye-blocked" data-target=".password_field" href="#" aria-label="${t['tit.visualize']} ${t['tit.password']}"></a>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">${t['tit.cancel']}</button>
                    <button type="button" class="btn btn-primary">${t['tit.updating']}</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

