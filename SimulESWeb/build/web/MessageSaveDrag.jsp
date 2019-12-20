<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page language="java" session="true"%>
<%@page import="SimulES.Model.*"%>
<%@page import="SimulES.Control.*"%>

<%
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession sesion = request.getSession();

        String player = (String) sesion.getAttribute("player");
        String configuration = (String) sesion.getAttribute("configuration");
        String update_board = (String) sesion.getAttribute("update_board");

        IndividualboardController individualboardController = new IndividualboardController();
        PlayerController playerController = new PlayerController();
        PlayerSoftengineerController playersoftengController = new PlayerSoftengineerController();
        int playerID = Integer.parseInt(player);
        Player playerObj = playerController.getPlayerById(playerID);
        String PlayerName = playerObj.getNickname();

        boolean sucessfullTrans = false;

        int updateBoard = Integer.parseInt(update_board);

        String result = null;

        if (playersoftengController.validateEngSoftxColumnsInIndividualBoard(configuration, playerID)) {

            if (individualboardController.playerExist(playerID)) {

                sucessfullTrans = individualboardController.updateConfigurationByPlayer(playerID, configuration, updateBoard);
            } else {
                sucessfullTrans = individualboardController.createPlayer(playerID, configuration, updateBoard);
            }

            if (sucessfullTrans) {
                result = "Update Successfully";
            } else {
                result = "Update Fault";
            }
        } else {
            result = "You are trying to do some ilegal move in your individual board, Please check the number of software engineers and the product";
        }

        sesion.invalidate();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>

        <title>SimulES</title>
        <Script Language="JavaScript">
            <!-- Script
            function load() {
                window.close();
                var load = window.open('/SimulESWeb/faces/PlayConceptsProblemsRoundPage.jsp?username='+ PlayerName);
                self.close();

            }
            // -->
        </Script>
    </head>
    <body>
        <h1>Server Response</h1>
        <table>
            <tr><td><b>Player Id:</b></td><td><%=player%></td></tr>
            <tr><td><b>Configuration submited:</b></td><td><%=configuration%></td></tr>
            <tr><td><b>Result:</b></td><td><%=result%></td></tr>
            <tr><td><b>You have submitted successfully your individual board</b></td></tr>
        </table>


        <%
        out.print("<table id='table1'>");
        out.print("<tr>");
        out.print("<td class='COL1'><a href=\"/SimulESWeb/IndividualBoardPage.jsp?id=" + playerID + "&username=" + PlayerName + "\">Go back Individual Board</a></td>");
        out.print("</tr>");
        out.print("</table>");
        out.print("<table id='table2'>");
        out.print("<tr>");
        out.print("<td class='COL2'><a href=\"/SimulESWeb/faces/PlayActionsRoundPage.jsp?username=" + PlayerName + "\">Go back The Actions Round</a></td>");
        out.print("</tr>");
        out.print("</table>");
        %>

    </body>
</html>
