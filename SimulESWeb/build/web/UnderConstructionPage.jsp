<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : UnderConstructionPage
    Created on : Jul 5, 2009, 9:36:15 AM
    Author     : Elizabeth
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
                        <ui:image id="image1" style="left: 552px; top: 192px; position: absolute" url="/resources/UnderConstrucition.gif"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
