<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : SupportMaterialPage
    Created on : Jan 21, 2010, 10:39:21 AM
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
                    <ui:form binding="#{SupportMaterialPage.form1}" id="form1" virtualFormsConfig="save | table1:tableRowGroup1:tableColumn2:textField1 | save , add/revert/delete | | add revert table1:tableRowGroup1:tableColumn3:delete">
                        <ui:table augmentTitle="false" id="table1" style="left: 144px; top: 168px; position: absolute; width: 0px" title="Table" width="0">
                            <ui:tableRowGroup binding="#{SupportMaterialPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                sourceData="#{SupportMaterialPage.sourceofcardsDataProvider}" sourceVar="currentRow">
                                <ui:tableColumn headerText="description" id="tableColumn2" sort="sourceofcards.description">
                                    <ui:textField id="textField1" text="#{currentRow.value['sourceofcards.description']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn id="tableColumn3">
                                    <ui:button action="#{SupportMaterialPage.delete_action}" id="delete" text="Delete"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="sourceofcards_id" id="tableColumn1" sort="sourceofcards.sourceofcards_id">
                                    <ui:textField id="textField2" text="#{currentRow.value['sourceofcards.sourceofcards_id']}"/>
                                </ui:tableColumn>
                            </ui:tableRowGroup>
                        </ui:table>
                        <ui:button action="#{SupportMaterialPage.add_action}" id="add" style="left: 263px; top: 96px; position: absolute" text="Add "/>
                        <ui:button action="#{SupportMaterialPage.save_action}" id="save" style="left: 359px; top: 96px; position: absolute" text="Save Changes"/>
                        <ui:button action="#{SupportMaterialPage.revert_action}" id="revert" style="left: 479px; top: 96px; position: absolute" text="Revert Changes"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
