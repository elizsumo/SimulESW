<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : BeginningRoundPage
    Created on : Jul 23, 2009, 5:32:31 PM
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
                <ui:body id="body1" style="background-color: rgb(235, 250, 250); -rave-layout: grid">
                    <ui:form id="form1">
                        <h:panelGrid id="gridPanel1" style="height: 168px; left: 432px; top: 384px; position: absolute; width: 96px">
                            <ui:image height="24" id="image3" url="/resources/chiffres7-04.gif" width="24"/>
                            <ui:button action="#{PlayStartRoundPage.btnSelectProject_action}" id="btnSelectProject" imageURL="/resources/dilbert_screen001.jpg"
                                style="height: 126px; width: 168px" text="Select Project" toolTip="Click to pick up the project"/>
                            <ui:hyperlink action="#{PlayStartRoundPage.hyperlinkChooseProject_action}" id="hyperlinkChooseProject"
                                text="Click to pick up the project" toolTip="Click to pick up the project"/>
                        </h:panelGrid>
                        <jsp:directive.include file="Masthead.jspf"/>
                        <ui:staticText id="staticTextTitle"
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 54px; top: 177px; position: absolute; text-decoration: underline overline" text="Play Start Round "/>
                        <ui:staticText binding="#{PlayStartRoundPage.lblResultDice}" id="lblResultDice"
                            style="color: navy; font-family: Arial,Helvetica,sans-serif; font-size: 14px; font-weight: bold; left: 672px; top: 216px; position: absolute; width: 286px" text="Awaiting the outcome of the dice..."/>
                        <ui:image height="48" id="imgCards1" style="left: 5px; top: 175px; position: absolute" url="/resources/cards.jpg" width="48"/>
                        <ui:staticText id="staticTextTitleUserName"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; left: 11px; top: 135px; position: absolute" text="User:"/>
                        <ui:staticText id="staticTextUserName"
                            style="font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 43px; top: 135px; position: absolute" text="#{SessionBean1.username}"/>
                        <ui:staticText id="staticText5"
                            style="color: navy; font-family: 'Arial','Helvetica',sans-serif; font-style: italic; font-weight: bold; left: 24px; top: 240px; position: absolute" text="Game Summary"/>
                        <h:panelGrid id="grdJoinGame" style="height: 96px; left: 432px; top: 209px; position: absolute" width="192">
                            <ui:image height="24" id="image1" url="/resources/chiffres7-02.gif" width="24"/>
                            <ui:imageHyperlink action="#{PlayStartRoundPage.imgJoinGame_action}" id="imgJoinGame" imageURL="/resources/JoinTheGame.jpg" toolTip="click to play the game"/>
                            <ui:hyperlink action="#{PlayStartRoundPage.hyperlinkJoinGame_action}" id="hyperlinkJoinGame" text="Click to play the game" toolTip="Click to play the game"/>
                        </h:panelGrid>
                        <h:panelGrid id="grdRollDice" style="height: 96px; left: 672px; top: 264px; position: absolute" width="192">
                            <ui:image height="24" id="image4" url="/resources/chiffres7-03.gif" width="24"/>
                            <ui:button action="#{PlayStartRoundPage.trhowDice_action}" binding="#{PlayStartRoundPage.btnTrhowDice}" id="btnTrhowDice"
                                imageURL="/resources/Dice-06-june.gif" style="height: 46px; width: 52px" text="Roll the Dice" toolTip="Click to roll the dice"/>
                            <ui:hyperlink action="#{PlayStartRoundPage.hyperlinkRollDice_action}" id="hyperlinkRollDice" text="Click to roll the dice" toolTip="Roll the Dice"/>
                        </h:panelGrid>
                        <h:panelGrid id="grdSwEng" style="height: 96px; left: 672px; top: 432px; position: absolute" width="312">
                            <ui:image height="24" id="image2" url="/resources/chiffres7-05.gif" width="24"/>
                            <h:panelGrid columns="2" id="gridPanelSoftEng1" style="border-style: solid; border-color: navy; " width="408">
                                <ui:button action="#{PlayStartRoundPage.btnEngSoft_action}" id="btnEngSoft" imageURL="/resources/Dilbert.jpg"
                                    style="border-style: solid; height: 120px; width: 144px" text="Button" toolTip="Click to pick up the first software engineer "/>
                                <ui:label id="label1" text="Software Engineer: ">
                                    <h:panelGrid columns="2" id="gridPanelSoftEng" style="height: 96px" width="215">
                                        <ui:label id="label2" text="Name:"/>
                                        <ui:textField binding="#{PlayStartRoundPage.softEngName}" disabled="true" id="softEngName" readOnly="true"/>
                                        <ui:label id="label3" text="Ability:"/>
                                        <ui:textField binding="#{PlayStartRoundPage.softEngAbility}" disabled="true" id="softEngAbility" readOnly="true"/>
                                        <ui:label id="label4" text="Maturity:"/>
                                        <ui:textField binding="#{PlayStartRoundPage.softEngMaturity}" disabled="true" id="softEngMaturity" readOnly="true"/>
                                        <ui:label id="label5" text="Salary::"/>
                                        <ui:textField binding="#{PlayStartRoundPage.softEngSalary}" disabled="true" id="softEngSalary" readOnly="true"/>
                                    </h:panelGrid>
                                </ui:label>
                            </h:panelGrid>
                            <ui:hyperlink action="#{PlayStartRoundPage.hyperlinkSoftEng_action}" id="hyperlinkSoftEng" style="width: 336px"
                                text="Click to pick up the first software engineer " toolTip="Click to pick up the first software engineer"/>
                        </h:panelGrid>
                        <ui:panelLayout id="layoutPanel1" panelLayout="flow" style="border: 2px solid black; background-color: white; height: 284px; left: 24px; top: 264px; overflow: auto; position: absolute; width: 334px">
                            <ui:staticText escape="false" id="staticText1" text="#{PlayActionsRoundPage.transcript}"/>
                        </ui:panelLayout>
                        <h:panelGrid id="grdArrow" style="height: 120px; left: 1032px; top: 240px; position: absolute" width="144">
                            <ui:button action="#{PlayStartRoundPage.btnArrow_action}" binding="#{PlayStartRoundPage.btnArrow}" id="btnArrow"
                                imageURL="/resources/right_Arrow.png" style="height: 96px; width: 152px" text="Button"/>
                            <ui:hyperlink binding="#{PlayStartRoundPage.hyperlinkArrow}" id="hyperlinkArrow" text="Click to next Round"/>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
