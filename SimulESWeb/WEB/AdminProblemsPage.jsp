<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : AdminProblemsPage
    Created on : Oct 4, 2011, 11:08:04 AM
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
                        <ui:image height="43" id="image1" style="left: 5px; top: 175px; position: absolute" url="/resources/cards.jpg" width="43"/>
                        <ui:staticText id="staticText1"
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 54px; top: 177px; position: absolute; text-decoration: underline overline" text="Admin Problems"/>
                        <ui:staticText id="staticText2"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; left: 11px; top: 135px; position: absolute" text="User:"/>
                        <ui:staticText id="staticText3"
                            style="font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 43px; top: 135px; position: absolute" text="#{SessionBean1.username}"/>
                        <h:panelGrid id="grdAdmin" style="height: 192px; left: 48px; top: 216px; position: absolute" width="1200">
                            <ui:table augmentTitle="false" binding="#{AdminProblemsPage.tblAllProblemsSubmit}" id="tblAllProblemsSubmit" title="Table" width="1007">
                                <script type="text/javascript">
                                    function AllProblems() {
                                        var table = document.getElementById("form1:tblAllProblemsSubmit");
                                        table.AllProblems();
                                    }

                                </script>
                                <ui:tableRowGroup binding="#{AdminProblemsPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    selected="#{AdminProblemsPage.selectedState}" sourceData="#{AdminProblemsPage.cardsProblemsSubmitbyPlayers}" sourceVar="currentRow">
                                    <ui:tableColumn binding="#{AdminProblemsPage.tableColumn7}" id="tableColumn7" onClick="setTimeout(initAllRows(),0)" selectId="#{AdminProblemsPage.radioButton1.id}">
                                        <ui:radioButton binding="#{AdminProblemsPage.radioButton1}" id="radioButton1" label=""
                                            name="#{AdminProblemsPage.radioButton1.id}" selected="#{AdminProblemsPage.selected}" selectedValue="#{AdminProblemsPage.selectedValue}"/>
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
                                    <ui:tableColumn headerText="State" id="tableColumn6" sort="state" width="41">
                                        <ui:staticText id="staticText9" text="#{currentRow.value['state']}"/>
                                    </ui:tableColumn>
                                </ui:tableRowGroup>
                            </ui:table>
                            <h:panelGrid columns="2" id="grdButtons">
                                <ui:button action="#{AdminProblemsPage.btnAccept_action}" id="btnAccept" text="Accept  Treatment"/>
                                <ui:button action="#{AdminProblemsPage.btnReject_action}" id="btnReject" text="Reject Treatment"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
