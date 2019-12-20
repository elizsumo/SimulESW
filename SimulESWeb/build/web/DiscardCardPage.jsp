<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DiscardCardPage
    Created on : Jul 30, 2010, 6:45:57 PM
    Author     : CarlosAlvarezH
-->
<jsp:root version="1.2" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
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
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 312px; top: 144px; position: absolute; text-decoration: underline overline" text="My Own Concept or/and Problems Cards"/>
                        <ui:image height="37" id="image1" style="left: 264px; top: 144px; position: absolute" url="/resources/cards.jpg" width="37"/>
                        <h:panelGrid id="gridPanel1" style="height: 96px; left: 264px; top: 216px; position: absolute" width="840">
                            <ui:table augmentTitle="false" id="tblDiscardCards" style="height: 116px" title="My Own Cards" width="838">
                                <script type="text/javascript">
                                    function ConceptsManageSoftEng() {
                                        var table = document.getElementById("form1:tblDiscardCards");
                                        table.ConceptsManageSoftEng();
                                    }

                                </script>
                                <ui:tableRowGroup binding="#{DiscardCardPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    selected="#{DiscardCardPage.selectedState}" sourceData="#{DiscardCardPage.cardsToDiscard}" sourceVar="currentRow">
                                    <ui:tableColumn binding="#{DiscardCardPage.tableColumn2}" id="tableColumn2" onClick="setTimeout(initAllRows(),0)"
                                        selectId="#{DiscardCardPage.radioButton1.id}" width="19">
                                        <ui:radioButton binding="#{DiscardCardPage.radioButton1}" id="radioButton1" label=""
                                            name="#{DiscardCardPage.radioButton1.id}" selected="#{DiscardCardPage.selected}" selectedValue="#{DiscardCardPage.selectedValue}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="ID" id="tableColumn1" sort="cardId">
                                        <ui:staticText id="staticText4" text="#{currentRow.value['cardId']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Name" id="tableColumn5" sort="name">
                                        <ui:staticText id="staticText8" text="#{currentRow.value['name']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Description" id="tableColumn4" sort="description">
                                        <ui:staticText id="staticText7" text="#{currentRow.value['description']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Reference" id="tableColumn6" sort="reference">
                                        <ui:hyperlink id="hyperlink1" text="#{currentRow.value['reference']}" url="#{currentRow.value['referencelink']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Rule" id="tableColumn7" sort="rule">
                                        <ui:staticText id="staticText5" text="#{currentRow.value['rule']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Type" id="tableColumn3" sort="cardtype">
                                        <ui:staticText id="staticText6" text="#{currentRow.value['cardtype'].description}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Category" id="tableColumn8" sort="category">
                                        <ui:staticText id="staticText9" text="#{currentRow.value['category']}"/>
                                    </ui:tableColumn>
                                </ui:tableRowGroup>
                            </ui:table>
                            <h:panelGrid columns="2" id="grdPanelButtons" style="height: 192px" width="479">
                                <h:panelGrid id="grdUse" style="height: 96px; width: 96px">
                                    <ui:button action="#{DiscardCardPage.btnUsedCard_action}" id="btnUsedCard" imageURL="/resources/011.jpg"
                                        style="height: 120px; width: 185px" text="Button"/>
                                    <ui:hyperlink action="#{DiscardCardPage.hyperlinkUse_action}" id="hyperlinkUse" text="Use Card Concept to Me"/>
                                </h:panelGrid>
                                <h:panelGrid id="gridPanelDiscard">
                                    <ui:button action="#{DiscardCardPage.btnDiscard_action}" id="btnDiscard" imageURL="/resources/Dilbert_animation.jpg"
                                        style="height: 120px; width: 185px" text="Button"/>
                                    <ui:hyperlink action="#{DiscardCardPage.hyperlinkDiscard_action}" id="hyperlinkDiscard" text="Discard Card"/>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
