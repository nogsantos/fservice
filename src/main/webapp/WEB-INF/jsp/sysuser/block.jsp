<%-- 
    Document   : delete form
    Created on : Dec 19, 2014, 3:36:06 PM
    Author     : nogsantos
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
    <t:putAttribute name="body">
        <h1 class="ls-title-intro ls-ico-user">${t['tit.user']} <small>${t[form_title]}</small></h1>        
        <div class="alert alert-warning" role="alert">
            ${t['text.block']}
        </div>
        <div class="panel panel-default">
            <div class="panel-body">
                <form role="form" id="block_sysuser" action="${linkTo[SysuserController].blockaction}" method="POST" class="ls-form ls-form-horizontal" data-ls-module="form">
                    <input type="hidden" name="sysuser.id" value="${sysuser.id}">
                    <fieldset id="fields-disabled" class="row ls-form-disable ls-form-text">
                        <label class="ls-label col-md-3">
                            <b class="ls-label-text">${t['tit.name']}</b>
                            <input type="text" name="nome" name="sysuser.name" value="${sysuser.name}">
                        </label>
                        <label class="ls-label col-md-3">
                            <b class="ls-label-text">${t['tit.login']}</b>
                            <input type="text" name="nome" name="sysuser.login" value="${sysuser.login}">
                        </label>
                        <label class="ls-label col-md-3">
                            <b class="ls-label-text">${t['tit.email']}</b>
                            <c:forEach items="${sysuser.emails}" var="email" varStatus="c">
                                <p><input type="email" id="sysuser_email_${c.count}" name="sysuser.emails" value="${email}"></p>
                            </c:forEach>                        
                        </label>
                    </fieldset>
                    <div class="ls-actions-btn">
                        <button type="submit" class="ls-btn"><i class="fa fa-save"></i> ${t['tit.block']}</button>
                        <a href="${linkTo[SysuserController].index}" class="ls-btn-danger" role="button"><i class="fa fa-reply"></i> ${t['tit.cancel']}</a>
                    </div>                       
                </form>
            </div>
        </div>
    </t:putAttribute>
</t:insertTemplate>