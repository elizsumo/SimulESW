<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : SourceCardsPage
    Created on : Nov 5, 2009, 3:15:11 PM
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
                        <h:panelGrid id="panelMain" style="height: 144px; left: 0px; top: 168px; position: absolute" width="360">
                            <h:panelGrid binding="#{SourceCardsPage.grdSourceCard}" id="grdSourceCard" style="height: 192px" width="336">
                                <ui:table augmentTitle="false" id="tblSourceCard" style="width: 450px" title="Source of Player Card" width="0">
                                    <script>
                                    function ConceptsManageSoftEng() {
                                        var table = document.getElementById("form1:tblSourceCard");
                                        table.ConceptsManageSoftEng();
                                    }
                                </script>
                                    <ui:tableRowGroup binding="#{SourceCardsPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        selected="#{SourceCardsPage.selectedState}" sourceData="#{ApplicationBean1.sourceofcardsList}" sourceVar="currentRow">
                                        <ui:tableColumn binding="#{SourceCardsPage.tableColumn3}" id="tableColumn3" onClick="setTimeout('initAllRows()',0)" selectId="#{SourceCardsPage.radioButton1.id}">
                                            <ui:radioButton binding="#{SourceCardsPage.radioButton1}" id="radioButton1" label=""
                                                name="#{SourceCardsPage.radioButton1.id}" selected="#{SourceCardsPage.selected}" selectedValue="#{SourceCardsPage.selectedValue}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="sourceofcardsId" id="tableColumn1" sort="sourceofcardsId">
                                            <ui:staticText id="staticText1" text="#{currentRow.value['sourceofcardsId']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="description" id="tableColumn2" sort="description">
                                            <ui:staticText id="staticText2" text="#{currentRow.value['description']}"/>
                                        </ui:tableColumn>
                                    </ui:tableRowGroup>
                                </ui:table>
                                <h:panelGrid columns="3" id="grdMainBtnSourceCard" style="height: 20px" width="240">
                                    <ui:button action="#{SourceCardsPage.addButton_action}" binding="#{SourceCardsPage.addButton}" id="addButton" text="Add"/>
                                    <ui:button action="#{SourceCardsPage.updateButton_action}" binding="#{SourceCardsPage.updateButton}" id="updateButton" text="Update"/>
                                    <ui:button action="#{SourceCardsPage.deleteButton_action}" binding="#{SourceCardsPage.deleteButton}" id="deleteButton" text="Delete"/>
                                </h:panelGrid>
                                <h:panelGrid binding="#{SourceCardsPage.grdUpdateSourceCard}" columns="2" id="grdUpdateSourceCard" style="height: 48px" width="240">
                                    <ui:label id="lbldescription" text="Description"/>
                                    <ui:textField binding="#{SourceCardsPage.textFieldDescription}" id="textFieldDescription"/>
                                    <ui:button action="#{SourceCardsPage.updateRecordButton_action}" binding="#{SourceCardsPage.updateRecordButton}"
                                        id="updateRecordButton" text="Update Record"/>
                                    <ui:button action="#{SourceCardsPage.addRecordButton_action}" binding="#{SourceCardsPage.addRecordButton}"
                                        id="addRecordButton" text="Add Record"/>
                                </h:panelGrid>
                            </h:panelGrid>

                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
