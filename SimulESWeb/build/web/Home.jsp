<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Jun 15, 2009, 10:13:18 PM
    Author     : Elizabeth
-->
<jsp:root version="1.2" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1">
                    <ui:link id="link1" url="/resources/stylesheet.css"/>
                    <ui:script id="script2" url="/resources/startUsername.js"/>
                    <df:ajaxTransaction id="ajaxTransaction1" inputs="page1:html1:body1:form1:textField1"/>
                </ui:head>
                <ui:body id="body1" onLoad="handleOnLoad()" onUnload="handleOnUnload()" style="background-color: rgb(235, 250, 250); -rave-layout: grid">
                    <ui:form id="form1">
                        <jsp:directive.include file="MastheadHome.jspf"/>
                        <ui:image height="61" id="image1" style="left: 1080px; top: 778px; position: absolute" url="/resources/erinicial_eng.jpg" width="87"/>
                        <ui:image height="72" id="image2" style="left: 1176px; top: 768px; position: absolute" url="/resources/puc-rio.gif" width="72"/>
                        <ui:textArea disabled="true" id="textArea1" readOnly="true"
                            style="border-style: solid; border-color: navy; background-color: white; color: black; font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: normal; height: 335px; left: 576px; top: 504px; position: absolute; width: 474px"
                            text="The idea in SimulES-W is to learn software engineering process so there each player takes the role of a software project manager in his own game, consequently he have to deals with budget, employs software engineer employment and dismissal them, and builds different software artifacts. During the game some situations can be established by other players named adversaries such as they could assign new problems to damage this player instance game or block moves of player. The player analyzes his game and the others, with that he created a strategy which allows his game to become better than his adversaries. This strategy is done with different elements such as: his intention to win the game, his resources (problems cards and concept cards), the project budget and the skill that his software engineers have.  The first when the game starts is to choose project and it will be available for all players. This choice must be made randomly so all players have to players roll the dice then the player who got the highest dice result is the one who chooses the project and starts the game. The information about game and project would be visible to all players. On the other hand, each player is allowed to take his first software engineering card and assemble it on his individual board." valueChangeListener="#{Home.textArea1_processValueChange}"/>
                        <ui:staticText id="staticText1"
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; left: 24px; top: 161px; position: absolute; text-align: center; width: 382px" text="Welcome to SimulES-W, the Website to Learn Software Engineering! "/>
                        <h:panelGrid id="grdMain" style="height: 288px; left: 600px; top: 144px; position: absolute" width="240">
                            <ui:image binding="#{Home.image3}" id="image3" url="/resources/play_now_home_01.gif"/>
                            <h:panelGrid binding="#{Home.gridPanelRegister}" columns="2" id="gridPanelRegister" style="height: 72px" width="192">
                                <ui:image height="83" id="image4" url="/resources/Register%20Now.JPG" width="96"/>
                                <h:panelGrid columns="3" id="gridPanel1" style="background-color: gray; height: 96px" width="456">
                                    <ui:label id="label1"
                                        style="color: white; font-family: Arial,Helvetica,sans-serif; font-size: 18px; font-style: italic; font-weight: bold" text="Username:"/>
                                    <ui:textField binding="#{Home.inputUsername}" id="textField1" maxLength="10" style="width: 168px" valueChangeListener="#{Home.textField1_processValueChange}"/>
                                    <ui:button action="#{Home.sendUsername}" id="button1"
                                        style="font-family: Arial,Helvetica,sans-serif; font-size: 18px; font-weight: bold" text="Entry"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{Home.grdContinuePlaying}" columns="2" id="grdContinuePlaying" style="height: 96px" width="240">
                                <ui:image height="144" id="image5" url="/resources/4242.jpg" width="192"/>
                                <ui:button action="#{Home.btnContinue_action}" id="btnContinue"
                                    style="color: navy; font-family: 'Arial','Helvetica',sans-serif; font-size: 24px; font-style: normal; font-variant: small-caps; font-weight: bold" text="Continue Playing"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <ui:image height="664" id="gameMap" style="left: 0px; top: 240px; position: absolute" url="/resources/scenarios.png" width="552"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
