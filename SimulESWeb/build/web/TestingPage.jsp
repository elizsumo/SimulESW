<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : TestingPage
    Created on : Feb 21, 2011, 2:52:31 PM
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
                <ui:body id="body1" style="-rave-layout: grid">
                    <ui:form id="form1">
                        <jsp:directive.include file="MastheadMain.jspf"/>
                        <ui:dropDown id="dropDown1" items="#{TestingPage.dropDown1DefaultOptions.options}" style="left: 48px; top: 288px; position: absolute"/>
                        <ui:table augmentTitle="false" id="table1" style="left: 120px; top: 312px; position: absolute; width: 450px" title="Table" width="0">
                            <ui:tableRowGroup id="tableRowGroup1" rows="5" sourceData="#{ApplicationBean1.modulesProject}" sourceVar="currentRow">
                                <ui:tableColumn headerText="code" id="tableColumn1" sort="code">
                                    <ui:staticText id="staticText1" text="#{currentRow.value['code']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="design" id="tableColumn2" sort="design">
                                    <ui:staticText id="staticText2" text="#{currentRow.value['design']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="help" id="tableColumn3" sort="help">
                                    <ui:staticText id="staticText3" text="#{currentRow.value['help']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="id" id="tableColumn4" sort="id">
                                    <ui:staticText id="staticText4" text="#{currentRow.value['id']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="project" id="tableColumn5" sort="project">
                                    <ui:staticText id="staticText5" text="#{currentRow.value['project']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="requirement" id="tableColumn6" sort="requirement">
                                    <ui:staticText id="staticText6" text="#{currentRow.value['requirement']}"/>
                                </ui:tableColumn>
                                <ui:tableColumn headerText="traceability" id="tableColumn7" sort="traceability">
                                    <ui:staticText id="staticText7" text="#{currentRow.value['traceability']}"/>
                                </ui:tableColumn>
                            </ui:tableRowGroup>
                        </ui:table>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
