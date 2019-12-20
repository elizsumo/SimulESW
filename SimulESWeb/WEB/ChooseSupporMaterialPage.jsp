<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ChooseSupporMaterialPage
    Created on : May 8, 2012, 4:14:00 PM
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
                        <jsp:directive.include file="MastheadHome.jspf"/>
                        <h:panelGrid id="grdMain" style="height: 96px; left: 0px; top: 144px; position: absolute; width: 96px">
                            <ui:table augmentTitle="false" binding="#{ChooseSupporMaterialPage.tblSupportMaterial}" id="tblSupportMaterial" style="height: 92px"
                                title="Support Material" width="407">
                                <ui:tableRowGroup binding="#{ChooseSupporMaterialPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    selected="#{ChooseSupporMaterialPage.selectedState}" sourceData="#{ChooseSupporMaterialPage.sourceofcard}" sourceVar="currentRow">
                                    <ui:tableColumn binding="#{ChooseSupporMaterialPage.tableColumn4}" id="tableColumn4" onClick="setTimeout(initAllRows(),0)" selectId="#{ChooseSupporMaterialPage.radioButton1.id}">
                                        <ui:radioButton binding="#{ChooseSupporMaterialPage.radioButton1}" id="radioButton1" label=""
                                            name="#{ChooseSupporMaterialPage.radioButton1.id}" selected="#{ChooseSupporMaterialPage.selected}" selectedValue="#{ChooseSupporMaterialPage.selectedValue}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="sourceofcardsId" id="tableColumn3" sort="sourceofcardsId">
                                        <ui:staticText id="staticText3" text="#{currentRow.value['sourceofcardsId']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="description" id="tableColumn2" sort="description">
                                        <ui:staticText id="staticText2" text="#{currentRow.value['description']}"/>
                                    </ui:tableColumn>
                                    <script type="text/javascript">
                                    function fncSupportMaterial() {
                                        var table = document.getElementById("form1:tblSupportMaterial");
                                        table.fncSupportMaterial();
                                    }

                                </script>
                                </ui:tableRowGroup>
                            </ui:table>
                            <ui:button action="#{ChooseSupporMaterialPage.btnAccept_action}" id="btnAccept" text="Accept"/>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
