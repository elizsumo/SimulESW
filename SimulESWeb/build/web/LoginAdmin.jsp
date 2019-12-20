<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LoginAdmin
    Created on : Aug 24, 2011, 3:51:26 PM
    Author     : elizsumoComputer
-->
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1">
                    <ui:link id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body id="body1" style="-rave-layout: grid">
                    <ui:form id="form1">
                        <jsp:directive.include file="Masthead.jspf"/>
                        <h:panelGrid columns="2" id="grdLogin" style="border: 3px solid navy; height: 192px; left: 24px; top: 192px; position: absolute" width="408">
                            <ui:label id="lblName" text="Name"/>
                            <ui:textField binding="#{LoginAdmin.txtName}" id="txtName" maxLength="10"/>
                            <ui:label id="lblPassword" text="Password"/>
                            <ui:passwordField binding="#{LoginAdmin.txtPassword}" id="txtPassword" maxLength="20"/>
                            <ui:button action="#{LoginAdmin.btnAccept_action}" id="btnAccept" text="Accept"/>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
