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
        <h1 class="ls-title-intro ls-ico-book">${t['tit.role']} <small>${t[form_title]}</small></h1>
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
        <form role="form" id="newRoleForm" action="${linkTo[SysroleController].persist}" data-ls-module="form" method="POST">
            <div class="ls-tabs-container" id="awesome-tab-content">
                <div id="track" class="ls-tab-content ls-active">
                    <input type="hidden" name="sysrole.id" value="${sysrole.id}">
                    <fieldset>
                        <legend>${t['tit.identification']}</legend>
                        <label class="ls-label col-md-5 col-xs-12">
                            <b class="ls-label-text">${t['tit.name']}&nbsp;*</b>
                            <input type="text" class="form-control required" id="sysrole_name" name="sysrole.name" required="" autocomplete="off" value="${sysrole.name}">
                        </label>    
                    </fieldset>
                    <fieldset>
                        <label class="ls-label col-md-5 col-xs-12">
                            <b class="ls-label-text">${t['tit.description']}</b>
                            <textarea rows="1" class="ls-textarea-autoresize" id="sysrole_description" name="sysrole.description">${sysrole.description}</textarea>
                        </label>    
                    </fieldset>
                </div>
            </div>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <span class="navbar-brand">${t['tit.actions']}&nbsp;<i class="fa fa-angle-double-right"></i></span>
                    </div>
                    <div class="nav navbar-nav navbar-right">
                        <a href="${linkTo[SysroleController].form}" class="btn btn-default navbar-btn" role="button"><i class="fa fa-refresh"></i> ${t['tit.new']}</a>
                        <button type="submit" class="btn btn-default navbar-btn"><i class="fa fa-save"></i> ${t['tit.persist']}</button>
                        <a href="${linkTo[SysroleController].index}" class="btn btn-default navbar-btn" role="button"><i class="fa fa-reply"></i> ${t['tit.cancel']}</a>
                    </div>
                </div>
            </nav>
        </form>
    </t:putAttribute>
</t:insertTemplate>