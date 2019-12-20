<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : ManageCardsPage
    Created on : Nov 10, 2009, 8:33:44 PM
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
                    <ui:form binding="#{ManageCardsPage.form1}" id="form1" virtualFormsConfig="source | dropDownSource | dropDownSource , save | table1:tableRowGroup1:tableColumn5:dropDownTypeCard table1:tableRowGroup1:tableColumn2:textField1 table1:tableRowGroup1:tableColumn3:textField2 table1:tableRowGroup1:tableColumn4:textArea1 table1:tableRowGroup1:tableColumn7:textField4 table1:tableRowGroup1:tableColumn6:textArea2 | save , add/revert/delete | | add revert table1:tableRowGroup1:tableColumn1:delete">
                        <jsp:directive.include file="Masthead.jspf"/>
                        <ui:dropDown binding="#{ManageCardsPage.dropDownSource}" converter="#{ManageCardsPage.dropDownSourceConverter}" id="dropDownSource"
                            items="#{ManageCardsPage.sourceofcardsDataProvider2.options['sourceofcards.sourceofcards_id,sourceofcards.description']}"
                            onChange="common_timeoutSubmitForm(this.form, 'dropDownSource');" style="left: 48px; top: 192px; position: absolute; width: 216px" valueChangeListener="#{ManageCardsPage.dropDownSource_processValueChange}"/>
                        <ui:table augmentTitle="false" binding="#{ManageCardsPage.table1}" id="table1" style="left: 48px; top: 240px; position: absolute"
                            title="Cards" width="1223">
                            <ui:tableRowGroup binding="#{ManageCardsPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                sourceData="#{ManageCardsPage.cardDataProvider}" sourceVar="currentRow">
                                <ui:tableColumn headerText="Id" id="tableColumn9" sort="card.card_id">
                                    <ui:staticText id="staticText1" text="#{currentRow.value['card.card_id']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="Name" id="tableColumn2" sort="card.name">
                                    <ui:textField id="textField1" maxLength="45" text="#{currentRow.value['card.name']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="Description" id="tableColumn4" sort="card.description" width="340">
                                    <ui:textArea columns="2" id="textArea1" maxLength="255" style="width: 336px" text="#{currentRow.value['card.description']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="Reference Name" id="tableColumn3" sort="card.reference">
                                    <ui:textField id="textField2" maxLength="255" text="#{currentRow.value['card.reference']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="Link Reference" id="tableColumn6" sort="card.referencelink" width="215">
                                    <ui:textArea columns="2" id="textArea2" maxLength="100" style="width: 168px" text="#{currentRow.value['card.referencelink']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="Rule" id="tableColumn7" sort="card.rule">
                                    <ui:textField id="textField4" maxLength="60" text="#{currentRow.value['card.rule']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="Category" id="tableColumn8" sort="card.category">
                                    <ui:textField id="textField5" maxLength="45" text="#{currentRow.value['card.category']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="Card Type" id="tableColumn5">
                                    <ui:dropDown converter="#{ManageCardsPage.dropDownTypeCardConverter}" id="dropDownTypeCard"
                                        items="#{ManageCardsPage.cardtypeDataProvider1.options['cardtype.cardtype_id,cardtype.description']}" selected="#{currentRow.value['card.cardtype_id']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn id="tableColumn1">
                                    <ui:button action="#{ManageCardsPage.delete_action}" id="delete" text="Delete"/>
                                </ui:tableColumn>
                            </ui:tableRowGroup>
                        </ui:table>
                        <ui:button action="#{ManageCardsPage.add_action}" id="add" style="left: 311px; top: 192px; position: absolute" text="Add Card"/>
                        <ui:button action="#{ManageCardsPage.save_action}" id="save" style="left: 407px; top: 192px; position: absolute" text="Save Changes"/>
                        <ui:button action="#{ManageCardsPage.revert_action}" id="revert" style="left: 527px; top: 192px; position: absolute" text="Revert Changes"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
