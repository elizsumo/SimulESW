<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : AdminPage
    Created on : Sep 3, 2009, 3:41:41 PM
    Author     : Elizabeth
-->
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1">
                    <ui:link id="link1" url="/resources/stylesheet.css"/>
                    <script type="text/javascript">
                        function confirmation() {
                            var answer = confirm("Are you sure, restart the game?")
                            if (answer){

                                window.open( "RestartGame.jsp", "myWindow",
                                "status = 1, height = 300, width = 300, resizable = 0" )
                                //alert("Game restart!")
                            }
                            else{
                                alert("Game doesn't restart!")
                            }
                        }
                    </script>
                </ui:head>
                <ui:body id="body1" style="-rave-layout: grid">
                    <ui:form id="form1" virtualFormsConfig="">
                        <jsp:directive.include file="Masthead.jspf"/>
                        <ui:button action="#{AdminPage.btnCloseEntryPlayer_action}" id="btnCloseEntryPlayer"
                            style="left: 455px; top: 216px; position: absolute; width: 168px" text="Close Entry Players"/>
                        <input onclick="confirmation()" style="left: 24px; top: 336px; position: absolute" type="button" value="Game Over"/>
                        <input onclick="confirmation()" style="left: 24px; top: 216px; position: absolute" type="button" value="Restart Game"/>
                        <ui:hyperlink action="case2" id="hyperlinkManageSourceCard" style="left: 144px; top: 456px; position: absolute" text="Type of Support Material"/>
                        <ui:hyperlink action="case1" id="hyperlinkManageCards" style="left: 24px; top: 456px; position: absolute" text="Manage Cards"/>
                        <ui:pageSeparator id="pageSeparator1" style="left: 0px; top: 264px; position: absolute; width: 1272px"/>
                        <ui:label id="label1" style="left: 24px; top: 168px; position: absolute" text="Start the game"/>
                        <ui:button action="#{AdminPage.btnRestartSession_action}" id="btnRestartSession" style="left: 191px; top: 216px; position: absolute" text="Establish Game Session"/>
                        <ui:pageSeparator id="pageSeparator2" style="left: 0px; top: 360px; position: absolute; width: 1272px"/>
                        <ui:label id="label2" style="left: 24px; top: 312px; position: absolute" text="Finish the game"/>
                        <ui:label id="label3" style="left: 24px; top: 408px; position: absolute" text="Manage The Support Material"/>
                        <ui:button action="#{AdminPage.btnNewRollDice_action}" id="btnNewRollDice"
                            style="left: 695px; top: 216px; position: absolute; width: 192px" text="Establish New Rolling Dice"/>
                        <ui:hyperlink action="case3" id="hyperlinkAdminProblems" style="height: 22px; left: 528px; top: 456px; position: absolute; width: 192px" text="Go to Admin Problems"/>
                        <ui:hyperlink action="case4" id="hyperlinkChooseSupportMaterial" style="left: 336px; top: 456px; position: absolute" text="Choose Support Material"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
