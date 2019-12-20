<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page1
    Created on : Jun 15, 2009, 10:13:18 PM
    Author     : Elizabeth
-->
<jsp:root version="1.2" xmlns:df="http://java.sun.com/jsf/dynamicfaces" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1">
                    <ui:link id="link1" url="/resources/stylesheet.css"/>
                    <df:ajaxTransaction id="commentTx"
                        inputs="page1:html1:body1:form1:comment,page1:html1:body1:form1:send,page1:html1:body1:form1:trhowDice,page1:html1:body1:form1:buttonProject,page1:html1:body1:form1:button1"
                        postReplace="customPostReplaceForCommentTx" render="page1:html1:body1:form1:transcriptPanel:transcriptText"/>
                    <df:ajaxTransaction execute="none" id="pollTx" inputs="none" postReplace="customPostReplaceForPollTx"
                        render="page1:html1:body1:form1:transcriptPanel:transcriptText" replaceElement="customReplaceForPollTx"/>
                    <ui:script id="script1" url="/resources/ajaxmessage.js"/>
                    <df:ajaxTransaction id="commentTxProject" render=""/>
                    <df:ajaxTransaction execute="none" id="pollTxProject" inputs="none" postReplace="customPostReplaceForPollTxProject" render="" replaceElement="customReplaceForPollTxProject"/>
                    <ui:script id="script2" url="/resources/ajaxProject.js"/>
                </ui:head>
                <ui:body id="body1" onLoad="handleOnLoad()" onUnload="handleOnUnload()" style="background-color: rgb(235, 250, 250); -rave-layout: grid">
                    <ui:form id="form1" onSubmit="return interceptFormSubmit()">
                        <jsp:directive.include file="Masthead.jspf"/>
                        <ui:panelLayout id="transcriptPanel" panelLayout="flow" style="border: 2px solid black; background-color: white; height: 284px; left: 24px; top: 240px; overflow: auto; position: absolute; width: 334px">
                            <ui:staticText escape="false" id="transcriptText" text="#{Index.transcript}"/>
                        </ui:panelLayout>
                        <ui:textField binding="#{Index.comment}" columns="60" id="comment" style="border-style: solid; border-color: black; left: 24px; top: 552px; position: absolute; width: 336px"/>
                        <ui:button action="#{Index.send_action}" id="send"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-weight: bold; height: 20px; left: 23px; top: 576px; position: absolute; width: 120px" text="Send Message"/>
                        <ui:staticText binding="#{Index.staticText1}" id="staticText1"
                            style="color: navy; font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; left: 52px; top: 173px; position: absolute; text-decoration: underline overline" text="SimulES Main"/>
                        <ui:image height="48" id="imgCards" style="left: 0px; top: 171px; position: absolute" url="/resources/cards.jpg" width="48"/>
                        <ui:staticText binding="#{Index.staticTextUserName}" id="staticTextUserName"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: italic; font-weight: normal; left: 68px; top: 134px; position: absolute" text="#{SessionBean1.username}"/>
                        <h:panelGrid columns="2" id="grdPrincipal" style="height: 240px; left: 72px; top: 624px; position: absolute" width="936">
                            <h:panelGrid id="gridPanel1" style="height: 258px" width="719">
                                <h:panelGrid columns="2" id="pnlProject" style="border-color: navy; margin: 1px; height: 143px" width="622">
                                    <h:panelGrid id="pnlBoss" style="height: 96px; width: 96px">
                                        <ui:staticText id="staticText2"
                                            style="color: purple; font-family: 'Georgia','Times New Roman','times',serif; font-size: 12px; font-style: italic; font-weight: bold; text-decoration: underline" text="Project Card  "/>
                                        <ui:image height="72" id="imgBoss" url="/resources/default.jpg" width="120"/>
                                    </h:panelGrid>
                                    <ui:tabSet id="tabSetProject" selected="tab1" style="height: 120px; width: 463px">
                                        <ui:tab id="tab1" text="Project Chose">
                                            <ui:panelLayout id="layoutPanel1" style="height: 104px; position: relative; width: 480px; -rave-layout: grid">
                                                <ui:table augmentTitle="false" id="tblProject" style="height: 68px" title="Project" width="551">
                                                    <ui:tableRowGroup id="tableRowGroup4" rows="10" sourceData="#{ApplicationBean1.projectChoose}" sourceVar="currentRow">
                                                        <ui:tableColumn headerText="Id" id="tableColumn1" sort="projectId">
                                                            <ui:staticText id="staticText4" text="#{currentRow.value['projectId']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Description" id="tableColumn2" sort="description">
                                                            <ui:staticText id="staticText5" text="#{currentRow.value['description']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Budget" id="tableColumn3" sort="budget">
                                                            <ui:staticText id="staticText6" text="#{currentRow.value['budget']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Complexity" id="tableColumn4" sort="complexity">
                                                            <ui:staticText id="staticText7" text="#{currentRow.value['complexity']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Name" id="tableColumn6" sort="name">
                                                            <ui:staticText id="staticText9" text="#{currentRow.value['name']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Quality" id="tableColumn7" sort="quality">
                                                            <ui:staticText id="staticText10" text="#{currentRow.value['quality']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Size" id="tableColumn8" sort="size">
                                                            <ui:staticText id="staticText11" text="#{currentRow.value['size']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Status" id="tableColumn18" sort="status">
                                                            <ui:staticText id="staticText21" text="#{currentRow.value['status']}"/>
                                                        </ui:tableColumn>
                                                    </ui:tableRowGroup>
                                                </ui:table>
                                            </ui:panelLayout>
                                        </ui:tab>
                                        <ui:tab id="tab2" text="Its Modules">
                                            <ui:panelLayout id="layoutPanel3" style="height: 128px; position: relative; width: 456px; -rave-layout: grid">
                                                <ui:table augmentTitle="false" id="tblModules" title="Modules" width="479">
                                                    <ui:tableRowGroup id="tableRowGroup3" rows="10" sourceData="#{ApplicationBean1.modulesProject}" sourceVar="currentRow">
                                                        <ui:tableColumn headerText="Module" id="tableColumn17" sort="id">
                                                            <ui:staticText id="staticText12" text="#{currentRow.value['id'].module}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Requirement" id="tableColumn10" sort="requirement">
                                                            <ui:staticText id="staticText13" text="#{currentRow.value['requirement']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Design" id="tableColumn11" sort="design">
                                                            <ui:staticText id="staticText14" text="#{currentRow.value['design']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Code" id="tableColumn12" sort="code">
                                                            <ui:staticText id="staticText15" text="#{currentRow.value['code']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Trace" id="tableColumn13" sort="traceability">
                                                            <ui:staticText id="staticText16" text="#{currentRow.value['traceability']}"/>
                                                        </ui:tableColumn>
                                                        <ui:tableColumn headerText="Help" id="tableColumn14" sort="help">
                                                            <ui:staticText id="staticText17" text="#{currentRow.value['help']}"/>
                                                        </ui:tableColumn>
                                                    </ui:tableRowGroup>
                                                </ui:table>
                                            </ui:panelLayout>
                                        </ui:tab>
                                    </ui:tabSet>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="gridPanel2" style="height: 48px" width="647">
                                <ui:image height="61" id="image1" url="/resources/images.jpg" width="96"/>
                                <ui:table augmentTitle="false" id="tblMoveAccept" title="Agree Move by Player" width="478">
                                    <ui:tableRowGroup id="tableRowGroup2" rows="5" sourceData="#{Index.acceptmoveList}" sourceVar="currentRow">
                                        <ui:tableColumn headerText="Player" id="tableColumn19" sort="player">
                                            <ui:staticText id="staticText20" text="#{currentRow.value['player'].nickname}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Description" id="tableColumn20" sort="description">
                                            <ui:staticText id="staticText22" text="#{currentRow.value['description']}"/>
                                        </ui:tableColumn>
                                        <ui:tableColumn headerText="Name card problem" id="tableColumn22" sort="name">
                                            <ui:staticText id="staticText25" text="#{currentRow.value['card'].name}"/>
                                        </ui:tableColumn>
                                    </ui:tableRowGroup>
                                </ui:table>
                            </h:panelGrid>
                        </h:panelGrid>
                        <ui:staticText id="staticTextTitleUserName"
                            style="font-family: 'Arial','Helvetica',sans-serif; font-size: 12px; font-style: normal; font-weight: bold; left: 10px; top: 134px; position: absolute" text="Welcome:"/>
                        <h:panelGrid binding="#{Index.grdPlayer2}" id="grdPlayer2" style="border: 2px dashed black; height: 96px; left: 576px; top: 216px; position: absolute; width: 96px">
                            <ui:imageHyperlink action="#{Index.imgPlayer2_action}" binding="#{Index.imgPlayer2}" height="48" id="imgPlayer2"
                                imageURL="/resources/dilbertPlayer.jpg" text="Player 2" width="91"/>
                            <ui:staticText binding="#{Index.player2}" id="player2" text="#{Index.strPlayer2}"/>
                            <ui:hyperlink binding="#{Index.hyperlinkPlayer2}" id="hyperlinkPlayer2" text="Individual Board" url="IndividualBoardOnlyReadPage.jsp?username=#{Index.strPlayer2}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="2" id="grdInformation"
                            style="border-style: double; border-color: black; height: 288px; left: 696px; top: 240px; position: absolute" width="600">
                            <h:panelGrid id="grdImage" style="height: 218px" width="167">
                                <ui:image id="image2" url="/resources/dilbertSF.gif"/>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="grdTextInf" style="height: 144px" width="335">
                                <ui:staticText id="staticTextTitle1"
                                    style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; width: 118px" text="Player Active:"/>
                                <ui:staticText id="staticTextPlayerActive" text="#{Index.playerName}"/>
                                <ui:staticText id="staticText3"
                                    style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; width: 119px" text="Next Player:"/>
                                <ui:staticText id="staticTextNextPlayer" text="#{Index.nextPlayerName}"/>
                                <ui:staticText id="staticText8"
                                    style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; width: 119px" text="Next Round:"/>
                                <ui:hyperlink action="#{Index.linkRoundActive_action}" binding="#{Index.linkRoundActive}" id="linkRoundActive" text="Round Active"/>
                                <ui:staticText id="staticTextTitle2"
                                    style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; width: 118px" text="Round Active:"/>
                                <ui:staticText id="staticTextNameRound" text="#{Index.nameRound}"/>
                                <ui:staticText id="staticText18"
                                    style="font-family: 'Arial','Helvetica',sans-serif; font-size: 14px; font-weight: bold; width: 118px" text="All Individual Boards"/>
                                <ui:hyperlink id="hyperlinkAllIndidualBoards" text="Go to see" url="AllIndividualBoardsPage.jsp"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid binding="#{Index.grdPlayer1}" id="grdPlayer1" style="border: 2px dashed black; height: 96px; left: 408px; top: 216px; position: absolute; width: 96px">
                            <ui:imageHyperlink action="#{Index.imgPlayer1_action}" binding="#{Index.imgPlayer1}" height="48" id="imgPlayer1"
                                imageURL="/resources/dilbertPlayer.jpg" text="Player 1" width="91"/>
                            <ui:staticText binding="#{Index.player1}" id="player1" text="#{Index.strPlayer1}"/>
                            <ui:hyperlink binding="#{Index.hyperlinkPlayer1}" id="hyperlinkPlayer1" text="Individual Board" url="IndividualBoardOnlyReadPage.jsp?username=#{Index.strPlayer1}"/>
                        </h:panelGrid>
                        <h:panelGrid binding="#{Index.grdPlayer3}" id="grdPlayer3" style="border: 2px dashed black; height: 96px; left: 408px; top: 360px; position: absolute; width: 96px">
                            <ui:imageHyperlink action="#{Index.imgPlayer3_action}" binding="#{Index.imgPlayer3}" height="48" id="imgPlayer3"
                                imageURL="/resources/dilbertPlayer.jpg" text="Player 3" width="91"/>
                            <ui:staticText binding="#{Index.player3}" id="player3" text="#{Index.strPlayer3}"/>
                            <ui:hyperlink binding="#{Index.hyperlinkPlayer3}" id="hyperlinkPlayer3" text="Individual Board" url="IndividualBoardOnlyReadPage.jsp?username=#{Index.strPlayer3}"/>
                        </h:panelGrid>
                        <h:panelGrid binding="#{Index.grdPlayer4}" id="grdPlayer4" style="border: 2px dashed black; height: 96px; left: 576px; top: 360px; position: absolute; width: 96px">
                            <ui:imageHyperlink action="#{Index.imgPlayer4_action}" binding="#{Index.imgPlayer4}" height="48" id="imgPlayer4"
                                imageURL="/resources/dilbertPlayer.jpg" text="Player 4" width="91"/>
                            <ui:staticText binding="#{Index.player4}" id="player4" text="#{Index.strPlayer4}"/>
                            <ui:hyperlink binding="#{Index.hyperlinkPlayer4}" id="hyperlinkPlayer4" text="Individual Board" url="IndividualBoardOnlyReadPage.jsp?username=#{Index.strPlayer4}"/>
                        </h:panelGrid>
                        <h:panelGrid binding="#{Index.grdPlayer5}" id="grdPlayer5" style="border: 2px dashed black; height: 96px; left: 504px; top: 504px; position: absolute; width: 96px">
                            <ui:imageHyperlink action="#{Index.imgPlayer5_action}" binding="#{Index.imgPlayer5}" height="48" id="imgPlayer5"
                                imageURL="/resources/dilbertPlayer.jpg" text="Player 5" width="91"/>
                            <ui:staticText binding="#{Index.player5}" id="player5" text="#{Index.strPlayer5}"/>
                            <ui:hyperlink binding="#{Index.hyperlinkPlayer5}" id="hyperlinkPlayer5" text="Individual Board" url="IndividualBoardOnlyReadPage.jsp?username=#{Index.strPlayer5}"/>
                        </h:panelGrid>
                    </ui:form>
                </ui:body>
            </ui:html>
        </ui:page>
    </f:view>
</jsp:root>
