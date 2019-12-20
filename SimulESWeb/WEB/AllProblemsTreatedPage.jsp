<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : AllProblemsTreatedPage
    Created on : Jul 30, 2010, 6:47:35 PM
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
                        <jsp:directive.include file="MastheadHome.jspf"/>
                        <ui:staticText id="staticText1"
                            style="font-size: 12px; font-style: normal; font-weight: bold; left: 8px; top: 131px; position: absolute" text="User:"/>
                        <ui:staticText id="staticText2"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 42px; top: 132px; position: absolute" text="#{SessionBean1.username}"/>
                        <ui:staticText id="staticText3"
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 312px; top: 136px; position: absolute; text-decoration: underline overline" text="All Problems Treated"/>
                        <ui:image height="37" id="image1" style="left: 255px; top: 131px; position: absolute" url="/resources/cards.jpg" width="37"/>
                        <h:panelGrid id="grdMain" style="height: 288px; left: 264px; top: 192px; position: absolute" width="864">
                            <ui:table augmentTitle="false" id="tblAllProblemsSubmit" style="height: 80px" title="Problems and Treatment"
                                toolTip="Problems and Treatment" width="838">
                                <script type="text/javascript">
                                    function AllProblems() {
                                        var table = document.getElementById("form1:tblAllProblemsSubmit");
                                        table.AllProblems();
                                    }

                                </script>
                                <ui:tableRowGroup binding="#{AllProblemsTreatedPage.tableRowGroup1}" id="tableRowGroup1" rows="5"
                                    selected="#{AllProblemsTreatedPage.selectedState}" sourceData="#{AllProblemsTreatedPage.cardsProblemsSubmitbyPlayers}" sourceVar="currentRow">
                                    <ui:tableColumn binding="#{AllProblemsTreatedPage.tableColumn3}" id="tableColumn3" onClick="setTimeout(initAllRows(),0)" selectId="#{AllProblemsTreatedPage.radioButton1.id}">
                                        <ui:radioButton binding="#{AllProblemsTreatedPage.radioButton1}" id="radioButton1" label=""
                                            name="#{AllProblemsTreatedPage.radioButton1.id}" selected="#{AllProblemsTreatedPage.selected}" selectedValue="#{AllProblemsTreatedPage.selectedValue}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Player" id="tableColumn5" sort="player">
                                        <ui:staticText id="staticText8" text="#{currentRow.value['player'].nickname}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Problem Card Name" id="tableColumn1" sort="cardByCardId">
                                        <ui:staticText id="staticText4" text="#{currentRow.value['cardByCardId'].name}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Problem Card Description" id="tableColumn32" sort="cardByCardId">
                                        <ui:textField id="textField5" readOnly="true" text="#{currentRow.value['cardByCardId'].description}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Treatment Card" id="tableColumn2" sort="cardByCardTreatment">
                                        <ui:staticText id="staticText6" text="#{currentRow.value['cardByCardTreatment'].description}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Observation" id="tableColumn4" sort="observation">
                                        <ui:staticText id="staticText7" text="#{currentRow.value['observation']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="State" id="tableColumn6" sort="state">
                                        <ui:staticText id="staticText9" text="#{currentRow.value['state']}"/>
                                    </ui:tableColumn>
                                </ui:tableRowGroup>
                            </ui:table>
                            <h:panelGrid columns="2" id="grdButtom" style="height: 96px" width="408">
                                <ui:button action="#{AllProblemsTreatedPage.btnAccept_action}" id="btnAccept" imageURL="/resources/AcceptMove.jpg"
                                    style="height: 104px; width: 168px" text="Button" toolTip="Accept  Treatment"/>
                                <ui:button action="#{AllProblemsTreatedPage.btnReject_action}" id="btnReject" imageURL="/resources/Reject.jpg" text="Button" toolTip="Reject Treatment"/>
                                <ui:hyperlink action="#{AllProblemsTreatedPage.hyperlinkAccept_action}" id="hyperlinkAccept" text="Accept  Treatment" toolTip="Accept  Treatment"/>
                                <ui:hyperlink action="#{AllProblemsTreatedPage.hyperlinkReject_action}" id="hyperlinkReject" text="Reject Treatment" toolTip="Reject Treatment"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
