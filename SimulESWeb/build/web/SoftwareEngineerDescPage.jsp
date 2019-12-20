<%@ page language="java"%>
<%@page import="java.util.List"%>
<%@page import="SimulES.Control.*"%>
<%@page import="SimulES.Model.*"%>
<%@page import="SimulES.Util.*"%>
<%@ taglib prefix="a" uri="http://jmaki/v1.0/jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SimulES</title>
    </head>
    <body>
        <center>
        <h2>Sofware Engineer Description</h2>       </center>
        <%    //Get ID
        int softEngID = 1;

        if (request.getParameter(
                "id") != null) {
            softEngID = Integer.parseInt(request.getParameter("id"));

        }
        %>

        <%
        SoftEngineerController softEngCont = new SoftEngineerController();
        Softengineer softwareEngineer = softEngCont.getSoftEngineer(softEngID);

        int softwareId = softwareEngineer.getSoftengineerId();
        String softEngName = softwareEngineer.getName();
        String softEngDesc = softwareEngineer.getDescription();
        int softEngSalary = softwareEngineer.getSalary();
        int softEngHability = softwareEngineer.getHability();
        int softEngMaturity = softwareEngineer.getMaturity();


        out.print("<table>");
        out.print("<tr><td class='COL1'>Id: </td><td class='COL2'>" + softwareId + "</td></tr>");
        out.print("<tr><td class='COL1'> </td><td class='COL2'> </td></tr>");
        out.print("<tr><td class='COL1'>Name: </td><td class='COL2'>" + softEngName + "</td></tr>");
        out.print("<tr><td class='COL1'> </td><td class='COL2'> </td></tr>");
        out.print("<tr><td class='COL1'>Description: </td><td class='COL2'>" + softEngDesc + "</td></tr>");
        out.print("<tr><td class='COL1'> </td><td class='COL2'> </td></tr>");
        out.print("<tr><td class='COL1'>Salary: </td><td class='COL2'>" + softEngSalary + "</td></tr>");
        out.print("<tr><td class='COL1'>Ability: </td><td class='COL2'>" + softEngHability + "</td></tr>");
        out.print("<tr><td class='COL1'>Maturity: </td><td class='COL2'>" + softEngMaturity + "</td></tr>");
        out.print("<tr><td class='COL1'> </td><td class='COL2'> </td></tr>");
        out.print("</table>");

        %>

 <input type="button" value="Back to Individual Board"
               onClick="javascript: history.go(-1)">

    </body>
</html>
