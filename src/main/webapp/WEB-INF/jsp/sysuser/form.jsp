<%-- 
    Document   : newuser
    Created on : Dec 8, 2014, 3:51:00 PM
    Author     : nogsantos
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:insertTemplate template="/WEB-INF/jsp/template/template.jsp">    
    <t:putAttribute name="body">
        <div ng-controller="sysuserControllerForm" >
            <h1 class="ls-title-intro ls-ico-user">${t['tit.user']} <small>${t[form_title]}</small></h1>
            <c:if test="${not empty return_message}">
                <div class="alert alert-info" role="info">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span><span class="sr-only">${t['tit.close']}</span>
                    </button>
                    ${t[return_message]}
                </div>
            </c:if>
            <c:if test="${not empty errors}">
                <div class="panel panel-danger">
                    <div class="panel-heading"><i class="fa fa-warning"></i> ${t['tit.errors.return']}</div>
                    <div class="panel-body">
                        <c:forEach items="${errors}" var="error">
                            <ul class="list-unstyled">
                                <li>
                                    <i class="fa fa-asterisk"></i> ${t['tit.field']}: <b>${error.category}</b> ${t['tit.cause']}: <i>${t[error.message]}</i>
                                </li>
                            </ul>
                        </c:forEach>
                    </div>
                </div>
            </c:if>      
            <form role="form" id="newUserForm" action="${linkTo[SysuserController].persist}" method="POST" class="ls-form ls-form-horizontal row">
                <div class="ls-tabs-container" id="awesome-tab-content">
                    <div id="track" class="ls-tab-content ls-active">
                        <input type="hidden" name="sysuser.id" value="${sysuser.id}">
                        <fieldset>
                            <legend>${t['tit.identification']}</legend>
                            <div class="row">
                                <label class="ls-label col-md-5 col-xs-12">
                                    <b class="ls-label-text">${t['tit.name']}&nbsp;*</b>
                                    <input type="text" data-ls-module="charCounter" maxlength="80" class="ls-field" required id="sysuser_name" name="sysuser.name" value="${sysuser.name}">
                                </label>
                            </div>
                        </fieldset>
                        <fieldset>
                            <legend>${t['tit.authetication']}</legend>
                            <div class="row">
                                <label class="ls-label col-md-5 col-xs-12">
                                    <b class="ls-label-text">${t['tit.login']}&nbsp;*</b>
                                    <input type="text" data-ls-module="charCounter" maxlength="15" onkeydown="this.value = this.value.toLowerCase();" class="ls-field" required id="sysuser_login" name="sysuser.login" value="${sysuser.login}">
                                </label>
                            </div>
                            <c:if test="${empty sysuser.id}">
                                <div class="row">
                                    <label class="ls-label col-md-2 col-xs-12">
                                        <b class="ls-label-text">${t['tit.password']}&nbsp;*</b>
                                        <input type="password" data-ls-module="charCounter" maxlength="15" autocomplete="off" class="ls-field sysuser_password" required id="sysuser_password" name="sysuser.password" value="">
                                    </label>
                                    <label class="ls-label col-md-3 col-xs-12">
                                        <b class="ls-label-text">${t['tit.password_confirm']}&nbsp;*</b>
                                        <div class="ls-prefix-group">
                                            <input type="password" maxlength="15" autocomplete="off" class="ls-field sysuser_password" required id="sysuser_password_confirm" name="password_confirm" equalTo="sysuser_password" value="">
                                            <a class="ls-label-text-prefix ls-toggle-pass ls-ico-eye" data-toggle-class="ls-ico-eye, ls-ico-eye-blocked" data-target=".sysuser_password" href="#"></a>
                                        </div>
                                    </label>
                                </div>
                            </c:if>
                        </fieldset>
                        <fieldset>
                            <legend>${t['tit.email']}</legend>
                            <c:if test="${not empty sysuser.emails}">                                
                                <div class="row">
                                    <label class="ls-label col-md-5 col-xs-12">
                                        <c:forEach items="${sysuser.emails}" var="email" varStatus="c">
                                            <p><input type="email" id="sysuser_email_${c.count}" name="sysuser.emails" value="${email}"></p>
                                        </c:forEach>
                                    </label>
                                </div>
                            </c:if>
                            <div class="row">
                                <label class="ls-label col-md-5 col-xs-12">
                                    <div ng-repeat="email in emails">
                                        <input type="text" name="sysuser.emails" id="{{email.id}}" placeholder="{{email.placeholder}} ({{email.id}})" value="" style="margin-top: 10px;" />
                                    </div>
                                </label>
                            </div>
                            <div class="row">
                                <label class="ls-label col-md-5 col-xs-12">
                                    <a class="ls-label-text-prefix ls-ico-plus" ng-click="addNewEmail()"></a>
                                </label>
                            </div>
                        </fieldset>
                        <fieldset>
                            <legend>${t['tit.role']}</legend>
                            <div data-ng-bind-html="data"></div>
                            <c:if test="${not empty sysuser.sysUserRoles}">
                                <div class="row">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">${t['tit.related']}</div>
                                        <div class="panel-body">
                                            <div class="list-group">
                                                <c:forEach items="${sysuser.sysUserRoles}" var="sRole" > 
                                                    <a id="${sRole.sysrole.id}" ng-click="rmRole(${sysuser.id}, ${sRole.sysrole.id})" style="cursor: pointer;" class="list-group-item">${sRole.sysrole.name}<span class="badge"><i class="fa fa-trash-o"></i></span></a>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${not empty roles}">
                                <div class="row">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">${t['tit.available']}</div>
                                        <div class="panel-body">
                                            <ul class="list-group">
                                                <c:forEach items="${roles}" var="role" varStatus="i">
                                                    <div class="ls-box">
                                                        <h4 class="ls-title-4 ls-display-inline-block">${role.name}</h4>
                                                        <div class="ls-switch-btn ls-float-right-md">
                                                            <input type="checkbox" value="${role.id}" name="sysrole[].id" id="ck_sysrole_${i.index}">
                                                            <label class="ls-switch-label" for="ck_sysrole_${i.index}" name="label-ck_sysrole_${i.index}" ls-switch-off="Desativado" ls-switch-on="Ativado">
                                                                <span></span>
                                                            </label>
                                                        </div>
                                                        <div class="row">
                                                            <span class="col-md-12">${role.description}</span>
                                                        </div>
                                                    </div>                                                                                                     
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </fieldset>
                    </div>
                </div>
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <span class="navbar-brand">${t['tit.actions']}&nbsp;<i class="fa fa-angle-double-right"></i></span>
                        </div>
                        <div class="nav navbar-nav navbar-right">
                            <a href="${linkTo[SysuserController].form}" class="btn btn-default navbar-btn" role="button"><i class="fa fa-refresh"></i> ${t['tit.new']}</a>
                            <button type="submit" class="btn btn-default navbar-btn"><i class="fa fa-save"></i> ${t['tit.persist']}</button>
                            <a href="${linkTo[SysuserController].index}" class="btn btn-default navbar-btn" role="button"><i class="fa fa-reply"></i> ${t['tit.cancel']}</a>
                        </div>
                    </div>
                </nav>
            </form>
        </div>
        <span class="hidden" id="alert-message">${t['alert.confirm.remove']}</span>
        <script src="<c:url value="/js/administration/sysuser/sysuserController.js"/>" type="text/javascript"></script>  
    </t:putAttribute>
</t:insertTemplate>