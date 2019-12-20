<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page language="java" session="true"%>
<%@page import="SimulES.Model.*"%>
<%@page import="SimulES.Control.*"%>
<%@page import="SimulES.Util.*"%>
<%@page import="java.util.List"%>

<%
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession sesion = request.getSession();

        String player = (String) sesion.getAttribute("player");
        String configuration = (String) sesion.getAttribute("configuration");
        String newConfiguration = null;
        String result = null;
        int playerID = Integer.parseInt(player);
        int qualityProject = 0;
        int[] modulesToInspect = new int[5];

        ModulesProjectController modulesProjectController = new ModulesProjectController();
        IndividualboardController individualboardController = new IndividualboardController();
        ProjectController projectController = new ProjectController();
        JSFUtils jsfUtils = new JSFUtils();

        PlayerController playerController = new PlayerController();
        Player playerObj = playerController.getPlayerById(playerID);
        String PlayerName = playerObj.getNickname();

        qualityProject = projectController.getQualityProject();
        modulesToInspect = modulesProjectController.getModulesToInspect(qualityProject);
        if (jsfUtils.allModulesWereBuilt(configuration, modulesToInspect)) {

            if (jsfUtils.areNotArtifactsInspect(configuration, modulesToInspect)) {
                newConfiguration = jsfUtils.inspectRandomArtifact(configuration, modulesToInspect);

                if (individualboardController.updateConfigurationByPlayer(playerID, newConfiguration)) {

                    result = "One inspection has been submited, check your individual board";

                } else {
                    result = "Error, doing inspection";
                }

            } else {

                if (jsfUtils.areArtefactsCorrect(configuration, modulesToInspect)) {
                    result = ("Your product is correct");
                } else {
                    result = ("You do not have enough artifacts to submit the product");
                }
            }


        } else {
            result = "There are not all required modules to project selected";
        }


        sesion.invalidate();

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>SimulES</title>

    </head>
    <body>
        <h1>Server Response</h1>
        <table>
            <tr><td><b>Player Id:</b></td><td><%=player%></td></tr>
            <tr><td><b>Result:</b></td><td><%=result%></td></tr>
        </table>

        <%
        out.print("<table id='table1'>");
        out.print("<tr>");
        out.print("<td class='COL1'><a href=\"/SimulESWeb/IndividualBoardPage.jsp?id=" + playerID + "&username=" + PlayerName + "\">Go back Individual Board</a></td>");
        out.print("</tr>");
        out.print("</table>");
        out.print("<table id='table2'>");
        out.print("<tr>");
        out.print("<td class='COL2'><a href=\"/SimulESWeb/faces/PlayConceptsProblemsRoundPage.jsp?username=" + PlayerName + "\">Go back The Concepts Round</a></td>");
        out.print("</tr>");
        out.print("</table>");
        %>
    </body>
</html>
