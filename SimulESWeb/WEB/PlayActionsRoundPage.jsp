<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PlayActionPage
    Created on : Jul 4, 2009, 10:14:12 PM
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
                    <ui:form id="form1" virtualFormsConfig="virtualFormCard | | buyPlayingCard">
                        <jsp:directive.include file="Masthead.jspf"/>
                        <ui:staticText id="staticText1"
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 55px; top: 175px; position: absolute; text-decoration: underline overline" text="Play Actions Round"/>
                        <ui:button action="#{PlayActionsRoundPage.trhowDice_action}" id="trhowDice" imageURL="/resources/Dice-06-june.gif"
                            style="height: 47px; left: 720px; top: 240px; position: absolute; width: 46px" text="Button" toolTip="Trhrow Out Dice"/>
                        <ui:staticText binding="#{PlayActionsRoundPage.resultDice}" id="resultDice"
                            style="color: navy; font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; left: 720px; top: 192px; position: absolute; width: 286px" text="Awaiting the outcome of the dice..."/>
                        <ui:image height="48" id="imgCards1" style="left: 4px; top: 173px; position: absolute" url="/resources/cards.jpg" width="48"/>
                        <ui:staticText id="staticTextTitleUserName"
                            style="font-size: 12px; font-style: normal; font-weight: bold; left: 8px; top: 133px; position: absolute" text="User:"/>
                        <ui:staticText id="staticTextUserName"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 40px; top: 133px; position: absolute" text="#{SessionBean1.username}"/>
                        <ui:staticText id="staticText14"
                            style="color: navy; font-family: 'Arial','Helvetica',sans-serif; font-style: italic; font-weight: bold; left: 26px; top: 219px; position: absolute" text="Game Summary"/>
                        <ui:staticText id="staticText16"
                            style="color: purple; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: bold; left: 720px; top: 288px; position: absolute; width: 168px" text="Click to roll the dice"/>
                        <ui:image height="24" id="image1" style="left: 408px; top: 168px; position: absolute" url="/resources/chiffres7-02.gif" width="24"/>
                        <h:panelGrid columns="2" id="grdMain" style="height: 96px; left: 408px; top: 336px; position: absolute" width="864">
                            <h:panelGrid id="grdCards" style="height: 120px" width="168">
                                <ui:button action="#{PlayActionsRoundPage.buyPlayingCard_action}" binding="#{PlayActionsRoundPage.buyPlayingCard}"
                                    id="buyPlayingCard" imageURL="/resources/index3.jpg" style="border-style: solid; height: 142px; width: 142px" text="Button" toolTip="Click to pick up your concept and problem cards"/>
                                <ui:staticText id="staticText9"
                                    style="color: navy; font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: bold; width: 334px"
                                    text="Click to pick up your concept and problem cards" toolTip="Click to pick up your concept and problem cards"/>
                                <ui:image height="24" id="image3" url="/resources/chiffres7-04.gif" width="24"/>
                                <ui:table augmentTitle="false" binding="#{PlayActionsRoundPage.tblCard}" id="tblCard" title="Your concepts and problems cards" width="287">
                                    <ui:tableRowGroup id="tableRowGroup2" rows="10" sourceData="#{PlayActionsRoundPage.cardsbyPlayer}" sourceVar="currentRow">
                                        <ui:tableColumn headerText="ID" id="tableColumn8" sort="cardId">
                                            <ui:staticText id="staticText17" text="#{currentRow.value['cardId']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Description" id="tableColumn10" sort="description">
                                            <ui:staticText id="staticText11" text="#{currentRow.value['description']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Name" id="tableColumn11" sort="name">
                                            <ui:staticText id="staticText12" text="#{currentRow.value['name']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Rule" id="tableColumn14" sort="rule">
                                            <ui:staticText id="staticText15" text="#{currentRow.value['rule']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Type" id="tableColumn9" sort="cardtype">
                                            <ui:staticText id="staticText10" text="#{currentRow.value['cardtype'].description}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Reference" id="tableColumn12" sort="reference">
                                            <ui:hyperlink id="hyperlink1" text="#{currentRow.value['reference']}" url="#{currentRow.value['referencelink']}"/>
                                        </ui:tableColumn>
                                    </ui:tableRowGroup>
                                </ui:table>
                            </h:panelGrid>
                            <h:panelGrid id="grdSoftEng" style="height: 168px" width="240">
                                <ui:button action="#{PlayActionsRoundPage.buySoftEngineer_action}" binding="#{PlayActionsRoundPage.buySoftEngineer}"
                                    id="buySoftEngineer" imageURL="/resources/Dilbert.jpg" style="border-style: solid; height: 118px; width: 124px"
                                    text="Button" toolTip="Click to pick up your Software engineers"/>
                                <ui:staticText id="staticText13"
                                    style="color: navy; font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: bold; width: 262px" text="Click to pick up your Software engineers"/>
                                <ui:image height="24" id="image5" url="/resources/chiffres7-05.gif" width="24"/>
                                <ui:table augmentTitle="false" id="tblSoftEng" style="width: 0px" title="Your Software Engineering" width="0">
                                    <ui:tableRowGroup id="tableRowGroup1" rows="10" sourceData="#{PlayActionsRoundPage.softEngByPlayer}" sourceVar="currentRow">
                                        <ui:tableColumn headerText="ID" id="tableColumn6" sort="softengineerId">
                                            <ui:staticText id="staticText7" text="#{currentRow.value['softengineerId']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Name" id="tableColumn4" sort="name">
                                            <ui:staticText id="staticText5" text="#{currentRow.value['name']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Description" id="tableColumn1" sort="description">
                                            <ui:staticText id="staticText2" text="#{currentRow.value['description']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Ability" id="tableColumn2" sort="hability">
                                            <ui:staticText id="staticText3" text="#{currentRow.value['hability']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Maturity" id="tableColumn3" sort="maturity">
                                            <ui:staticText id="staticText4" text="#{currentRow.value['maturity']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Salary" id="tableColumn5" sort="salary">
                                            <ui:staticText id="staticText6" text="#{currentRow.value['salary']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Status" id="tableColumn7" sort="softwareengineerstatus">
                                            <ui:staticText id="staticText8" text="#{currentRow.value['softwareengineerstatus'].description}"/>
                                        </ui:tableColumn>
                                    </ui:tableRowGroup>
                                </ui:table>
                            </h:panelGrid>
                        </h:panelGrid>
                        <ui:panelLayout id="layoutPanel1" panelLayout="flow" style="border: 2px solid black; background-color: white; height: 284px; left: 24px; top: 240px; overflow: auto; position: absolute; width: 334px">
                            <ui:staticText escape="false" id="staticText18" text="#{PlayActionsRoundPage.transcript}"/>
                        </ui:panelLayout>
                        <ui:button action="#{PlayActionsRoundPage.btnSubmit_action}" id="btnSubmit1"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-weight: bold; height: 96px; left: 1007px; top: 266px; position: absolute; width: 264px" text="Submit, I have finished my moves"/>
                        <ui:image id="image4" style="left: 1239px; top: 326px; position: absolute" url="/resources/target.gif"/>
                        <h:panelGrid id="grdIndividualBoard" style="height: 96px; left: 408px; top: 192px; position: absolute; width: 96px">
                            <ui:imageHyperlink height="88" id="imgIndividualBoard" imageURL="/resources/TableIcon.png" textPosition="left"
                                url="PlayerTable.jsp?username=#{Masthead.username}" width="168"/>
                            <ui:hyperlink id="linkIndividualBoard" text="Individual Board" url="PlayerTable.jsp?username=#{Masthead.username}"/>
                        </h:panelGrid>
                        <ui:image height="24" id="image2" style="left: 720px; top: 215px; position: absolute" url="/resources/chiffres7-03.gif" width="24"/>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
