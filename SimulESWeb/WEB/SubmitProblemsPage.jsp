<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : SubmitProblemsPage
    Created on : Jul 30, 2010, 6:46:31 PM
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
                    <ui:form id="form1" virtualFormsConfig="conceptChange | |">
                        <jsp:directive.include file="MastVertical.jspf"/>
                        <jsp:directive.include file="MastheadHome.jspf"/>
                        <ui:staticText id="staticText1"
                            style="font-size: 12px; font-style: normal; font-weight: bold; left: 8px; top: 131px; position: absolute" text="User:"/>
                        <ui:staticText id="staticText2"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 42px; top: 132px; position: absolute" text="#{SessionBean1.username}"/>
                        <ui:staticText id="staticText3"
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 312px; top: 144px; position: absolute; text-decoration: underline overline" text="Submit Problems"/>
                        <ui:image height="37" id="image1" style="left: 256px; top: 134px; position: absolute" url="/resources/cards.jpg" width="37"/>
                        <ui:staticText id="staticTextChoosePlayer"
                            style="color: navy; font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-style: italic; font-weight: bold"
                            text="choose player to submit  problem" toolTip="choose player to submit  problem"/>
                        <h:panelGrid id="gridPanel1" style="left: 288px; top: 216px; position: absolute" width="744">
                            <h:panelGrid binding="#{SubmitProblemsPage.grdTblPlayers}" id="grdTblPlayers" style="height: 96px; width: 100%">
                                <ui:table augmentTitle="false" binding="#{SubmitProblemsPage.tblPlayers}" id="tblPlayers" style="height: 68px"
                                    title="Players Online" width="862">
                                    <script type="text/javascript">
                                        function SubmitPlayers() {
                                            var table = document.getElementById("tblPlayers");
                                            table.SubmitPlayers();
                                        }

                                    </script>
                                    <ui:tableRowGroup binding="#{SubmitProblemsPage.tableRowGroup2}" id="tableRowGroup2" rows="10"
                                        selected="#{SubmitProblemsPage.selectedState}" sourceData="#{SubmitProblemsPage.playerOnlineList}" sourceVar="currentRow">
                                        <ui:tableColumn binding="#{SubmitProblemsPage.tableColumn6}" id="tableColumn6" onClick="setTimeout(initAllRows(),0)" selectId="#{SubmitProblemsPage.radioButton2.id}">
                                            <ui:radioButton binding="#{SubmitProblemsPage.radioButton2}" id="radioButton2" label=""
                                                name="#{SubmitProblemsPage.radioButton2.id}" selected="#{SubmitProblemsPage.selected}" selectedValue="#{SubmitProblemsPage.selectedValue}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Player Id" id="tableColumn13" sort="playerId">
                                            <ui:staticText id="staticText14" text="#{currentRow.value['playerId']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Nickname" id="tableColumn12" sort="nickname">
                                            <ui:staticText id="staticText13" text="#{currentRow.value['nickname']}"/>
                                        </ui:tableColumn>
                                    </ui:tableRowGroup>
                                </ui:table>
                                <h:panelGrid columns="1" id="grdPlayer" style="height: 48px" width="359">
                                    <ui:button action="#{SubmitProblemsPage.btnAcceptPlayer_action}" binding="#{SubmitProblemsPage.btnAcceptPlayer}"
                                        id="btnAcceptPlayer" imageURL="/resources/ChooseSWE.png" style="height: 96px; width: 96px" text="Choose"/>
                                    <ui:hyperlink action="#{SubmitProblemsPage.hyperlinkChoose_action}" binding="#{SubmitProblemsPage.hyperlinkChoose}"
                                        id="hyperlinkChoose" text="Choose Player"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{SubmitProblemsPage.grdTxtPlayer}" columns="1" id="grdTxtPlayer" style="height: 48px" width="623">
                                <ui:textField binding="#{SubmitProblemsPage.txtPlayer}" id="txtPlayer" style="width: 456px"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{SubmitProblemsPage.grdProblems}" id="grdProblems" style="height: 96px" width="216">
                                <ui:table augmentTitle="false" binding="#{SubmitProblemsPage.tblProblems}" id="tblProblems" style="height: 212px"
                                    title="Choose Problem to Submit" width="862">
                                    <script type="text/javascript">
                                        function SubmitProblems() {
                                            var table = document.getElementById("tblProblems");
                                            table.SubmitProblems();
                                        }

                                    </script>
                                    <ui:tableRowGroup binding="#{SubmitProblemsPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        selected="#{SubmitProblemsPage.selectedState}" sourceData="#{SubmitProblemsPage.allCardsToSubmitProblems}" sourceVar="currentRow">
                                        <ui:tableColumn binding="#{SubmitProblemsPage.tableColumn8}" id="tableColumn8" onClick="setTimeout(initAllRows(),0)" selectId="#{SubmitProblemsPage.radioButton1.id}">
                                            <ui:radioButton binding="#{SubmitProblemsPage.radioButton1}" id="radioButton1" label=""
                                                name="#{SubmitProblemsPage.radioButton1.id}" selected="#{SubmitProblemsPage.selected}" selectedValue="#{SubmitProblemsPage.selectedValue}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="ID" id="tableColumn1" sort="cardId">
                                            <ui:staticText id="staticText4" text="#{currentRow.value['cardId']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Name" id="tableColumn2" sort="name">
                                            <ui:staticText id="staticText5" text="#{currentRow.value['name']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Description" id="tableColumn3" sort="description">
                                            <ui:staticText id="staticText6" text="#{currentRow.value['description']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Type" id="tableColumn4" sort="cardtype">
                                            <ui:staticText id="staticText7" text="#{currentRow.value['cardtype'].description}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Reference" id="tableColumn5" sort="reference">
                                            <ui:hyperlink id="hyperlink2" text="#{currentRow.value['reference']}" url="#{currentRow.value['referencelink']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Rule" id="tableColumn7" sort="rule">
                                            <ui:staticText id="staticText10" text="#{currentRow.value['rule']}"/>
                                        </ui:tableColumn>
                                    </ui:tableRowGroup>
                                </ui:table>
                                <h:panelGrid columns="2" id="grdButton" style="height: 96px; width: 96px">
                                    <h:panelGrid id="grdSubmit" style="height: 96px; width: 96px">
                                        <ui:button action="#{SubmitProblemsPage.btnSubmit_action}" binding="#{SubmitProblemsPage.btnSubmit}" id="btnSubmit"
                                            imageURL="/resources/dogbert.jpg" text="Button"/>
                                        <ui:hyperlink action="#{SubmitProblemsPage.hyperlinkSubmit_action}" binding="#{SubmitProblemsPage.hyperlinkSubmit}"
                                            id="hyperlinkSubmit" text="Submit Problem"/>
                                    </h:panelGrid>
                                    <h:panelGrid id="grdBtnCancel" style="height: 96px; width: 96px">
                                        <ui:button action="#{SubmitProblemsPage.btnCancel_action}" binding="#{SubmitProblemsPage.btnCancel}" id="btnCancel"
                                            imageURL="/resources/Cancel.png" style="height: 96px; width: 96px" text="Cancel"/>
                                        <ui:hyperlink action="#{SubmitProblemsPage.hyperlinkCancel_action}" binding="#{SubmitProblemsPage.hyperlinkCancel}"
                                            id="hyperlinkCancel" style="" text="Return to Players"/>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
