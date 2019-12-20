<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PlayGamePage
    Created on : Feb 21, 2011, 4:54:06 PM
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
                        <jsp:directive.include file="Masthead.jspf"/>
                        <ui:button action="#{PlayGamePage.btnPlayActionsRound_action}" binding="#{PlayGamePage.btnPlayActionsRound}" id="btnPlayActionsRound"
                            style="font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold; height: 48px; left: 383px; top: 318px; position: absolute; width: 216px" text="Play Actions Round"/>
                        <ui:image height="48" id="image1" style="left: 481px; top: 260px; position: absolute" url="/resources/arrow-down-icon-b.gif" width="48"/>
                        <ui:image height="48" id="image2" style="left: 478px; top: 381px; position: absolute" url="/resources/arrow-down-icon-b1.gif" width="48"/>
                        <ui:image binding="#{PlayGamePage.img1}" id="img1" style="left: 560px; top: 200px; position: absolute; z-index: 502" url="/resources/target.gif"/>
                        <ui:image binding="#{PlayGamePage.img2}" id="img2" style="left: 567px; top: 329px; position: absolute" url="/resources/target2.gif"/>
                        <ui:image binding="#{PlayGamePage.img3}" id="img3" style="left: 564px; top: 456px; position: absolute; z-index: 501" url="/resources/target3.gif"/>
                        <h:graphicImage height="120" id="image3" style="left: 696px; top: 288px; position: absolute" value="/resources/dilbertSF.gif" width="144"/>
                        <ui:staticText id="staticTextTitle"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; left: 840px; top: 336px; position: absolute; width: 118px" text="Player Active:"/>
                        <ui:staticText id="staticTextNamePlayer" style="left: 962px; top: 338px; position: absolute; width: 144px" text="#{PlayGamePage.playerName}"/>
                        <ui:staticText id="staticText1"
                            style="color: navy; font-family: 'Arial','Helvetica',sans-serif; font-style: italic; font-weight: bold; left: 0px; top: 192px; position: absolute" text="Game Summary"/>
                        <ui:panelLayout id="layoutPanel1" panelLayout="flow" style="border: 2px solid black; background-color: white; height: 284px; left: 1px; top: 216px; overflow: auto; position: absolute; width: 334px">
                            <ui:staticText escape="false" id="staticText2" text="#{PlayGamePage.transcript}"/>
                        </ui:panelLayout>
                        <ui:staticText id="staticText3"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; left: 11px; top: 135px; position: absolute" text="User:"/>
                        <ui:staticText id="staticText4"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 42px; top: 135px; position: absolute" text="#{SessionBean1.username}"/>
                        <ui:staticText id="staticText5"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; left: 841px; top: 367px; position: absolute; width: 119px" text="Next Player:"/>
                        <ui:button action="#{PlayGamePage.btnPlayStartRound_action}" binding="#{PlayGamePage.btnPlayStartRound}" id="btnPlayStartRound"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; height: 48px; left: 383px; top: 192px; position: absolute; width: 216px; z-index: 499" text="Play Start Round"/>
                        <ui:button action="#{PlayGamePage.btnPlayConceptRound_action}" binding="#{PlayGamePage.btnPlayConceptRound}" id="btnPlayConceptRound"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; height: 48px; left: 383px; top: 444px; position: absolute; width: 216px; z-index: 500" text="Play Concepts Round"/>
                        <ui:staticText id="staticText6" style="left: 962px; top: 362px; position: absolute; width: 144px" text="#{PlayGamePage.nextPlayerName}"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
