<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ProblemsByPlayerPage
    Created on : Jul 30, 2010, 6:47:06 PM
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
                <ui:body id="body1" style="background-color: rgb(235, 250, 250); -rave-layout: grid">
                    <ui:form id="form1">
                        <jsp:directive.include file="MastVertical.jspf"/>
                        <jsp:directive.include file="MastheadHome.jspf"/>
                        <ui:staticText id="staticText1"
                            style="font-size: 12px; font-style: normal; font-weight: bold; left: 8px; top: 131px; position: absolute" text="User:"/>
                        <ui:staticText id="staticText2"
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 312px; top: 136px; position: absolute; text-decoration: underline overline" text="Problems by Player"/>
                        <ui:staticText id="staticText3"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 42px; top: 132px; position: absolute" text="#{SessionBean1.username}"/>
                        <ui:image height="48" id="image1" style="left: 253px; top: 129px; position: absolute" url="/resources/cards.jpg" width="48"/>
                        <h:panelGrid id="grdMain" style="height: 192px; left: 288px; top: 216px; position: absolute" width="888">
                            <h:panelGrid binding="#{ProblemsByPlayerPage.grdAllProblems}" id="grdAllProblems" style="height: 312px">
                                <ui:table augmentTitle="false" binding="#{ProblemsByPlayerPage.tblTreatmentProblems}" id="tblTreatmentProblems"
                                    style="height: 140px" title="My Problems" width="838">
                                    <script type="text/javascript">
                                        function ProblemsByPlayer() {
                                            var table = document.getElementById("form1:tblTreatmentProblems");
                                            table.ProblemsByPlayer();
                                        }

                                    </script>
                                    <ui:tableRowGroup binding="#{ProblemsByPlayerPage.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        selected="#{ProblemsByPlayerPage.selectedState}" sourceData="#{ProblemsByPlayerPage.problemsBysPlayerToSolve}" sourceVar="currentRow">
                                        <ui:tableColumn binding="#{ProblemsByPlayerPage.tableColumn6}" id="tableColumn6" onClick="setTimeout(initAllRows(),0)" selectId="#{ProblemsByPlayerPage.radioButton1.id}">
                                            <ui:radioButton binding="#{ProblemsByPlayerPage.radioButton1}" id="radioButton1" label=""
                                                name="#{ProblemsByPlayerPage.radioButton1.id}" selected="#{ProblemsByPlayerPage.selected}" selectedValue="#{ProblemsByPlayerPage.selectedValue}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="ID" id="tableColumn1" sort="cardId">
                                            <ui:staticText id="staticText4" text="#{currentRow.value['cardId']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Name" id="tableColumn2" sort="name" width="141">
                                            <ui:staticText id="staticText5" text="#{currentRow.value['name']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Description" id="tableColumn3" sort="description">
                                            <ui:staticText id="staticText6" text="#{currentRow.value['description']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Reference" id="tableColumn4" sort="reference">
                                            <ui:hyperlink id="hyperlink1" text="#{currentRow.value['reference']}" url="#{currentRow.value['referencelink']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Rule" id="tableColumn5" sort="rule">
                                            <ui:staticText id="staticText8" text="#{currentRow.value['rule']}"/>
                                        </ui:tableColumn>
                                    </ui:tableRowGroup>
                                </ui:table>
                                <ui:button action="#{ProblemsByPlayerPage.btnChooseProblem_action}" id="btnChooseProblem" imageURL="/resources/01.jpg"
                                    style="height: 142px; width: 190px" text="Button" toolTip="Choose Problem to Solve"/>
                                <ui:hyperlink action="#{ProblemsByPlayerPage.hyperlinkChooseProblem_action}" id="hyperlinkChooseProblem"
                                    text="Choose Problem to Solve" toolTip="Choose Problem to Solve"/>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ProblemsByPlayerPage.grdProblem}" columns="2" id="grdProblem" style="height: 264px" width="791">
                                <ui:label id="lblProblemCard" text="Id Problem Card"/>
                                <ui:textField binding="#{ProblemsByPlayerPage.txtIdProblemCard}" disabled="true" id="txtIdProblemCard" style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; width: 552px"/>
                                <ui:label id="lblNameProblemCard" text="Name Problem Card"/>
                                <ui:textField binding="#{ProblemsByPlayerPage.txtNameProblemCard}" disabled="true" id="txtNameProblemCard" style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; width: 552px"/>
                                <ui:label id="lblDescription" text="Description"/>
                                <ui:textArea binding="#{ProblemsByPlayerPage.textAreaDescription}" disabled="true" id="textAreaDescription" style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; height: 96px; width: 552px"/>
                                <ui:label id="lblChoose" style="width: 216px" text="Choose your Treatment of Problem"/>
                                <ui:dropDown binding="#{ProblemsByPlayerPage.dropDownChoose}" id="dropDownChoose"
                                    items="#{ProblemsByPlayerPage.dropDownChooseDefaultOptions.options}"
                                    onChange="common_timeoutSubmitForm(this.form, 'gridPanel3:dropDownChoose');" style="width: 552px" valueChangeListener="#{ProblemsByPlayerPage.dropDownChoose_processValueChange}"/>
                                <h:panelGrid id="gridPanelReturn" style="height: 96px; width: 96px">
                                    <ui:button action="#{ProblemsByPlayerPage.btnReturn_action}" id="btnReturn" imageURL="/resources/Return2.jpg"
                                        style="height: 143px; width: 191px" text="Button"/>
                                    <ui:hyperlink action="#{ProblemsByPlayerPage.hyperlinkReturn_action}" id="hyperlinkReturn" text="Return to Problems"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid binding="#{ProblemsByPlayerPage.grdSubmitTreatment}" id="grdSubmitTreatment" style="height: 264px" width="335">
                                <ui:staticText binding="#{ProblemsByPlayerPage.lblKindTreatment}" id="lblKindTreatment"
                                    style="font-family: Arial,Helvetica,sans-serif; font-size: 12px; font-weight: bold" text="kind of Treatment" toolTip="kind of Treatment"/>
                                <ui:table augmentTitle="false" binding="#{ProblemsByPlayerPage.tblConcepts}" id="tblConcepts" style="height: 136px"
                                    title="Concept Cards to Treatment of Problems" width="526">
                                    <script type="text/javascript">
                                        function ConceptsToProblems() {
                                            var table = document.getElementById("form1:tblConcepts");
                                            table.ConceptsToProblems();
                                        }

                                    </script>
                                    <ui:tableRowGroup binding="#{ProblemsByPlayerPage.tableRowGroup2}" id="tableRowGroup2" rows="10"
                                        selected="#{ProblemsByPlayerPage.selectedState}" sourceData="#{ProblemsByPlayerPage.cardsConceptbyPlayer}" sourceVar="currentRow">
                                        <ui:tableColumn binding="#{ProblemsByPlayerPage.tableColumn12}" id="tableColumn12" onClick="setTimeout(initAllRows(),0)"
                                            selectId="#{ProblemsByPlayerPage.radioButton1.id}" width="23">
                                            <ui:radioButton binding="#{ProblemsByPlayerPage.radioButton2}" id="radioButton2" label=""
                                                name="#{ProblemsByPlayerPage.radioButton1.id}" selected="#{ProblemsByPlayerPage.selected}" selectedValue="#{ProblemsByPlayerPage.selectedValue}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="ID" id="tableColumn7" sort="cardId" width="86">
                                            <ui:staticText id="staticText9" text="#{currentRow.value['cardId']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Name" id="tableColumn8" sort="name">
                                            <ui:staticText id="staticText10" text="#{currentRow.value['name']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Description" id="tableColumn9" sort="description">
                                            <ui:staticText id="staticText11" text="#{currentRow.value['description']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Reference" id="tableColumn10" sort="reference">
                                            <ui:hyperlink id="hyperlink2" text="#{currentRow.value['reference']}" url="#{currentRow.value['referencelink']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Rule" id="tableColumn11" sort="rule">
                                            <ui:staticText id="staticText13" text="#{currentRow.value['rule']}"/>
                                        </ui:tableColumn>
                                    </ui:tableRowGroup>
                                </ui:table>
                                <ui:textArea binding="#{ProblemsByPlayerPage.textAreaObservation}" id="textAreaObservation" style="height: 48px; width: 528px"/>
                                <ui:button action="#{ProblemsByPlayerPage.btnSubmit_action}" binding="#{ProblemsByPlayerPage.btnSubmit}" id="btnSubmit"
                                    imageURL="/resources/Submit2.jpg" text="Button" toolTip="Submit Treatment"/>
                                <ui:hyperlink action="#{ProblemsByPlayerPage.hyperlinkSubmitTreatment_action}"
                                    binding="#{ProblemsByPlayerPage.hyperlinkSubmitTreatment}" id="hyperlinkSubmitTreatment" text="Submit Treatment"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
