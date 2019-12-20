<%-- 
    Document   : PlayerTable
    Created on : Sep 18, 2009, 10:11:53 PM
    Author     : Elizabeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" session="true" %>
<%@page import="java.util.List"%>
<%@page import="SimulES.Control.*"%>
<%@page import="SimulES.Model.*"%>
<%@page import="SimulES.SessionBean1"%>
<%@page session = "true"  %>

<html>
    <head>

        <jsp:directive.include file="MastheadHome.jspf"/>
        <meta name="author" content="Darko Bunic and Elizabeth Suescun"/>
        <meta name="description" content="Individual Board Game"/>
        <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
        <script type="text/javascript" src="drag.js"></script>

        <title>Players Online</title>

    </head>
    <body>

        <%
        int startID = 1;
        int endID = 200;
        int prev_startID = 1;
        int prev_endID = 10;

        int PLAYER_RECORD_COUNT = 1000;

        boolean RECORD_START_PAGE = false;
        boolean RECORD_END_PAGE = false;

        String username = request.getParameter("username");

        if (request.getParameter("startid") != null) {
            startID = Integer.parseInt(request.getParameter("startid"));
        }
        if (request.getParameter("endid") != null) {
            endID = Integer.parseInt(request.getParameter("endid"));
        }

        PlayerController controler = new PlayerController();
        List playersList = controler.getPlayerNicname(startID, endID);

        if (startID == 1) {
            RECORD_START_PAGE = true;
        }
        if (endID == PLAYER_RECORD_COUNT) {
            RECORD_END_PAGE = true;
        }

        prev_startID = startID - 10;
        prev_endID = endID - 10;

        startID = endID + 1;
        endID = endID + 10;

        int playersSize = playersList.size();


        out.print("<table>");

        if (RECORD_START_PAGE) {
            out.print("<tr><td class='NEXT'> </td><td class='NEXT'> </td><td class='NEXT'> </td><td class='NEXT'><a class='RENT' href=\"IndividualBoardGame.jsp?startid=" + startID + "&endid=" + endID + "\">Next</a></td></tr>");
        } else if (RECORD_END_PAGE) {
            out.print("<tr><td class='NEXT'> </td><td class='NEXT'> </td><td class='NEXT'><a class='NEXT' href=\"PlayerTable.jsp?startid=" + prev_startID + "&endid=" + prev_endID + "\">Prev</a></td><td class='NEXT'> </td></tr>");
        } else {
            out.print("<tr><td class='NEXT'> </td><td class='NEXT'> </td><td class='NEXT'><a class='NEXT' href=\"PlayerTable.jsp?startid=" + prev_startID + "&endid=" + prev_endID + "\">Prev</a></td><td class='NEXT'><a class='NEXT' href=\"PlayerTable.jsp?startid=" + startID + "&endid=" + endID + "\">Next</a></td></tr>");
        }

        out.print("<tr><th>Title</th><th>Description</th><th> </th><th> </th></tr>");
        for (int i = 0; i < playersSize; i++) {
            Player player = (Player) playersList.get(i);
            int playerID = player.getPlayerId();
            out.print("<tr>");
            out.print("<td class='COL1'><a href=\"/SimulESWeb/IndividualBoardPage.jsp?id=" + playerID + "&username=" + username + "\">" + player.getPlayerId() + "</a></td>");
            out.print("<td class='COL2'>" + player.getNickname() + "</td>");
            out.print("<td class='COL2'><a href=\"/SimulESWeb/IndividualBoardPage.jsp?id=" + playerID + "&username=" + username + "\">More</a></td>");
            out.print("<td class='COL2'><a href=\"/SimulESWeb/IndividualBoardPage.jsp?id=" + playerID + "&username=" + username + "\">Individual Board by Player</a></td>");
            out.print("</tr>");

        }
        out.print("</table>");

        //  out.print("<tr>");
     //       out.print("<td class='COL2'><a href=\"/SimulESWeb/?username=" + username + "\">Go back SimulES</a></td>");
        //     out.print("</tr>");

             out.print("<tr>");
        out.print("<td class='COL2'><a href=\"/SimulESWeb/faces/PlayActionsRoundPage.jsp?username=" + username + "\">Go back SimulES</a></td>");
        out.print("</tr>");
             
        %>
        
    </body>
</html>
