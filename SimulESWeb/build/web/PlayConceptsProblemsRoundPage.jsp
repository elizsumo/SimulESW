<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PlayConceptsProblemsRoundPage
    Created on : Jul 30, 2010, 3:30:17 PM
    Author     : CarlosAlvarezH
-->
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1">
                    <ui:link id="link1" url="/resources/stylesheet.css"/>
                </ui:head>
                <ui:body id="body1" style="background-color: rgb(235, 250, 250); -rave-layout: grid">
                    <ui:form id="form1">
                        <jsp:directive.include file="MastVertical.jspf"/>
                        <jsp:directive.include file="Masthead.jspf"/>
                        <ui:staticText id="staticText1"
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 296px; top: 169px; position: absolute; text-decoration: underline overline" text="Play Concepts and problems Round"/>
                        <ui:staticText id="staticText2"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 40px; top: 132px; position: absolute" text="#{SessionBean1.username}"/>
                        <ui:staticText id="staticText3"
                            style="font-size: 12px; font-style: normal; font-weight: bold; left: 8px; top: 131px; position: absolute" text="User:"/>
                        <ui:image height="37" id="image1" style="left: 252px; top: 168px; position: absolute" url="/resources/cards.jpg" width="37"/>
                        <ui:textArea id="textArea1" readOnly="true"
                            style="border-style: dotted; font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: normal; height: 90px; left: 384px; top: 576px; position: absolute; width: 432px" text="The Play Round to Concepts and Manage Problems allows the player to use Concept Cards, Problem Cards and manage his/her software engineer. Each card describes a typical process, good practice or problem in a specific area of software engineering. The players use the Problems Cards to halt the adversaries’ progress, but they need to understand what they mean."/>
                        <ui:image height="192" id="image2" style="left: 624px; top: 360px; position: absolute" url="/resources/ChooseAction.jpg" width="256"/>
                        <ui:panelLayout id="layoutPanel1" panelLayout="flow" style="border: 2px solid black; background-color: white; height: 188px; left: 264px; top: 360px; overflow: auto; position: absolute; width: 334px">
                            <ui:staticText escape="false" id="staticText4" text="#{PlayConceptsProblemsRoundPage.transcript}"/>
                        </ui:panelLayout>
                        <ui:staticText id="staticText5" style="left: 264px; top: 336px; position: absolute" text="Game Summary"/>
                        <ui:button action="#{PlayConceptsProblemsRoundPage.btnSubmit_action}" id="btnSubmit"
                            style="font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-weight: bold; height: 96px; left: 263px; top: 216px; position: absolute; width: 264px" text="Submit, I have finished my moves"/>
                        <ui:image id="image3" style="left: 492px; top: 274px; position: absolute" url="/resources/target.gif"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
