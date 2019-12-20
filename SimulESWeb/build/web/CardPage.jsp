<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : CardPage
    Created on : Nov 7, 2009, 10:09:02 AM
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
                        <h:panelGrid id="mainContainer" style="height: 96px; left: 0px; top: 216px; position: absolute" width="1272">
                            <ui:table augmentTitle="false" binding="#{CardPage.tblCards}" id="tblCards" title="Cards" width="874">
                                <script>
                                    function PlayDiceRound() {
                                        var table = document.getElementById("form1:tblSourceCard");
                                        table.PlayDiceRound();
                                    }
                                </script>
                                <ui:tableRowGroup binding="#{CardPage.tableRowGroup1}" id="tableRowGroup1" rows="5" selected="#{CardPage.selectedState}"
                                    sourceData="#{SessionBean1.allCard}" sourceVar="currentRow">
                                    <ui:tableColumn binding="#{CardPage.tableColumn6}" id="tableColumn6" onClick="setTimeout('initAllRows()',0)" selectId="#{CardPage.radioButton1.id}">
                                        <ui:radioButton binding="#{CardPage.radioButton1}" id="radioButton1" label="" name="#{CardPage.radioButton1.id}"
                                            selected="#{CardPage.selected}" selectedValue="#{CardPage.selectedValue}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="cardId" id="tableColumn1" sort="cardId">
                                        <ui:staticText id="staticText1" text="#{currentRow.value['cardId']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="name" id="tableColumn2" sort="name">
                                        <ui:staticText id="staticText2" text="#{currentRow.value['name']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="description" id="tableColumn3" sort="description">
                                        <ui:staticText id="staticText3" text="#{currentRow.value['description']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="constraint" id="tableColumn4" sort="constraint">
                                        <ui:staticText id="staticText4" text="#{currentRow.value['constraint']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="reference" id="tableColumn5" sort="reference">
                                        <ui:staticText id="staticText5" text="#{currentRow.value['reference']}"/>
                                    </ui:tableColumn>
                                </ui:tableRowGroup>
                            </ui:table>
                            <h:panelGrid binding="#{CardPage.buttonPanel}" columns="3" id="buttonPanel" style="height: 48px" width="288">
                                <ui:button action="#{CardPage.addButton_action}" id="addButton" text="Add"/>
                                <ui:button action="#{CardPage.updateButton_action}" id="updateButton" text="Update"/>
                                <ui:button action="#{CardPage.deleteButton_action}" id="deleteButton" text="Delete"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{CardPage.addUpdatePanel}" columns="2" id="addUpdatePanel" style="height: 96px" width="264">
                                <ui:label id="label1" text="Name"/>
                                <ui:textField binding="#{CardPage.textFieldName}" id="textFieldName"/>
                                <ui:label id="label2" text="Description"/>
                                <ui:textField binding="#{CardPage.textFieldDescription}" id="textFieldDescription"/>
                                <ui:label id="label3" text="Constraint"/>
                                <ui:textField binding="#{CardPage.textFieldConstraint}" id="textFieldConstraint"/>
                                <ui:label id="label4" text="Reference"/>
                                <ui:textField binding="#{CardPage.textFieldReference}" id="textFieldReference"/>
                                <ui:label id="label5" text="Type"/>
                                <ui:dropDown binding="#{CardPage.dropDownType}" converter="#{CardPage.dropDownTypeConverter}" id="dropDownType"
                                    items="#{CardPage.cardtypeDataProvider.options['cardtype.cardtype_id,cardtype.description']}" style="width: 144px"/>
                                <ui:label id="label6" text="Source"/>
                                <ui:dropDown binding="#{CardPage.dropDownSource}" converter="#{CardPage.dropDownSourceConverter}" id="dropDownSource"
                                    items="#{CardPage.sourceofcardsDataProvider.options['sourceofcards.sourceofcards_id,sourceofcards.description']}" style="width: 144px"/>
                                <ui:button action="#{CardPage.addRecordButton_action}" binding="#{CardPage.addRecordButton}" id="addRecordButton" text="Add Record"/>
                                <ui:button action="#{CardPage.updateRecordButton_action}" binding="#{CardPage.updateRecordButton}" id="updateRecordButton" text="Update Record"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
