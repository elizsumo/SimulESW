<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ManageSoftwareEngineersPage
    Created on : Jul 30, 2010, 4:54:59 PM
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
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 312px; top: 136px; position: absolute; text-decoration: underline overline" text="Manage Software Engineers"/>
                        <ui:image height="37" id="image1" style="left: 264px; top: 136px; position: absolute" url="/resources/cards.jpg" width="37"/>
                        <ui:staticText id="staticText2"
                            style="font-size: 12px; font-style: normal; font-weight: bold; left: 8px; top: 131px; position: absolute" text="User:"/>
                        <ui:staticText id="staticText3"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 42px; top: 132px; position: absolute" text="#{SessionBean1.username}"/>
                        <h:panelGrid id="gridPanel1" style="height: 96px; left: 288px; top: 240px; position: absolute" width="936">
                            <ui:table augmentTitle="false" id="tblsoftwareEngineer" style="height: 140px" title="Software Engineers By Player" width="886">
                                <script type="text/javascript">
                                    function ConceptsManageSoftEng() {
                                        var table = document.getElementById("form1:tblsoftwareEngineer");
                                        table.ConceptsManageSoftEng();
                                    }

                                </script>
                                <ui:tableRowGroup binding="#{ManageSoftwareEngineersPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                    selected="#{ManageSoftwareEngineersPage.selectedState}" sourceData="#{ManageSoftwareEngineersPage.softEngbyPlayer}" sourceVar="currentRow">
                                    <ui:tableColumn binding="#{ManageSoftwareEngineersPage.tableColumn8}" id="tableColumn8"
                                        onClick="setTimeout(initAllRows(),0)" selectId="#{ManageSoftwareEngineersPage.radioButton1.id}">
                                        <ui:radioButton binding="#{ManageSoftwareEngineersPage.radioButton1}" id="radioButton1" label=""
                                            name="#{ManageSoftwareEngineersPage.radioButton1.id}" selected="#{ManageSoftwareEngineersPage.selected}" selectedValue="#{ManageSoftwareEngineersPage.selectedValue}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="ID" id="tableColumn6" sort="softengineerId">
                                        <ui:staticText id="staticText9" text="#{currentRow.value['softengineerId']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Name" height="67" id="tableColumn4" sort="name">
                                        <ui:staticText id="staticText7" text="#{currentRow.value['name']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Description" id="tableColumn1" sort="description" width="190">
                                        <ui:staticText id="staticText4" text="#{currentRow.value['description']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Ability" id="tableColumn2" sort="hability" width="0">
                                        <ui:staticText id="staticText5" text="#{currentRow.value['hability']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Maturity" id="tableColumn3" sort="maturity">
                                        <ui:staticText id="staticText6" text="#{currentRow.value['maturity']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Salary" height="43" id="tableColumn5" sort="salary">
                                        <ui:staticText id="staticText8" text="#{currentRow.value['salary']}"/>
                                    </ui:tableColumn>
                                    <ui:tableColumn headerText="Status" id="tableColumn7" sort="softwareengineerstatus">
                                        <ui:staticText id="staticText10" text="#{currentRow.value['softwareengineerstatus'].description}"/>
                                    </ui:tableColumn>
                                </ui:tableRowGroup>
                            </ui:table>
                            <h:panelGrid columns="2" id="gridPanel2">
                                <ui:button action="#{ManageSoftwareEngineersPage.btnEmploy_action}" id="btnEmploy" imageURL="/resources/DilbertIIcopy.jpg"
                                    style="height: 119px; width: 168px" text="Button" toolTip="Click to Employ Software Engineer"/>
                                <ui:button action="#{ManageSoftwareEngineersPage.btnDemit_action}" id="btnDemit" imageURL="/resources/dilbert-beta-preview.jpg"
                                    style="height: 120px; width: 163px" text="Button" toolTip="Click to Demit Sotfware Engineer"/>
                                <ui:hyperlink action="#{ManageSoftwareEngineersPage.hyperlinkEmploy_action}" id="hyperlinkEmploy" text="Employ"/>
                                <ui:hyperlink action="#{ManageSoftwareEngineersPage.hyperlinkDemit_action}" id="hyperlinkDemit" text="Demit"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <blink> "haga esto" </blink>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
