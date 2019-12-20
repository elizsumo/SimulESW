<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        response.setHeader("Cache-Control", "no-cache");

        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Cache-Control", "must-revalidate");

        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java"%>
<%@page import="java.util.List"%>
<%@page import="SimulES.Control.*"%>
<%@page import="SimulES.Model.*"%>
<%@page import="SimulES.Util.*"%>

<%@ taglib prefix="a" uri="http://jmaki/v1.0/jsp" %>

<html>
    <head>

        <meta name="author" content="Darko Bunic and Elizabeth Suescun"/>
        <meta name="description" content="Individual Board Game"/>
        <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="jmaki-standard.css" type="text/css"/>
        <script type="text/javascript" src="drag.js"></script>
        <script type="text/javascript" src="saveDrag.js"></script>
        <title>SimulES - Individual Board</title>
        <meta http-equiv="Refresh" content= window.opener.location.reload()>


    </head>
    <body>

        
            <h2>All Individual Board </h2>

            <div id="main_container">
                <!-- tables inside this DIV could have draggable content -->

        <!-- tables inside this DIV could have draggable content -->
                <div id="drag">


                    <%    // SCRIPT CHAMADO PARA PEGAR O ID

        // Foi passado por post uma variável com o id do jogador referente ao tabuleiro aberto

        PlayerController playerController = new PlayerController();
        int playerSize = playerController.getSizeListPlayer();
        List<Player> allPlayer = playerController.getPlayerOrderById();
        //obter o nome do jogador e dono do tabuleiro
        int usernameId = 0;
        String username = null;
        String configuration = null;
        boolean existConf = false;
     

        for (int s = 0; s < playerSize; s++) {
            Player player = (Player) allPlayer.get(s);
            username = player.getNickname();
            usernameId = player.getPlayerId();

            out.print("<div id='right'>");

            out.print("<table id='table0'>");

            out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");
            out.print(
                    "<tr class='forbid'>" + username + "</tr>");
            out.print("</table>");



            PlayerSoftengineerController helper = new PlayerSoftengineerController();
            List softEngList = helper.getSoftEngEmployedByPlayer(usernameId);

            int softEngSize = softEngList.size();


            out.print("<table id='table1'>");

            out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");
            out.print(
                    "<tr>");
            out.print(
                    "<td class='forbid'>Software Engineer employed</td>");

            if (softEngSize > 0 && softEngSize <= 4) {

                for (int j = 0; j < softEngSize; j++) {
                    Softengineer softEng = (Softengineer) softEngList.get(j);
                    String softEngName = softEng.getName();
                    int softEngId = softEng.getSoftengineerId();
                    // out.print("<td valign='middle'> <div class='drag t1'>" + softEngName + "</div></td>");
                    out.print("<td valign='middle'> <div class='forbid'><a href=\"SoftwareEngineerDescPage.jsp?id=" + softEngId + "\">" + softEngName + "</a></div></td>");
                }
            } else {
                out.print(
                        "<td class='forbid'>You have more/less employees than allowed </td>");

            }


            out.print("</tr>");

            out.print("</table>");



            out.print("<table id='table4'>");
            out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");
            out.print(
                    "<tr>");
            out.print(
                    "<td class='forbid'>Description: </td>");

            if (softEngSize > 0 && softEngSize <= 4) {

                for (int z = 0; z < softEngSize; z++) {
                    Softengineer softEng = (Softengineer) softEngList.get(z);
                    out.print("<td class='mark orange_cell single'>Salary: " + softEng.getSalary() + "  Ability: " + softEng.getHability() + "  Maturity: " + softEng.getMaturity() + "</td>");
                }
            }


            out.print("</tr>");

            out.print("</table>");

            // Recupera a ultima configuração do tabuleiro que está sendo acessado no momento.

            IndividualboardController individualboardController = new IndividualboardController();
            configuration = individualboardController.getPlayerConfiguration(usernameId);
            if ((configuration == null)) {

                out.print("<table id='table2'>");
                out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");

                out.print("<tr style='background-color: #eee'>");
                out.print("<td class='forbid'>Requirements</td>");
                for (int i = 0; i < 4; i++) {
                    out.print("<td valign='middle'></div></td>");
                }
                out.print("</tr>");

                out.print("<tr>");
                out.print("<td class='forbid'>Design</td>");
                for (int i = 0; i < 4; i++) {
                    out.print("<td valign='middle'></div></td>");
                }
                out.print("</tr>");

                out.print("<tr style='background-color: #eee'>");
                out.print("<td class='forbid'>Code</td>");
                for (int i = 0; i < 4; i++) {
                    out.print("<td valign='middle'></div></td>");
                }
                out.print("</tr>");

                out.print("<tr>");
                out.print("<td class='forbid'>Trace</td>");
                for (int i = 0; i < 4; i++) {
                    out.print("<td valign='middle'></div></td>");
                }
                out.print("</tr>");

                out.print("<tr style='background-color: #eee'>");
                out.print("<td class='forbid'>Help</td>");
                for (int i = 0; i < 4; i++) {
                    out.print("<td valign='middle'></div></td>");
                }
                out.print("</tr>");

                out.print("</table>");
            } else {

                existConf = true;
                String[] cards = null;
                String valueBuild = null;
                JSFUtils jsfUtils = new JSFUtils();
                String[] fields = jsfUtils.getEachConfiguration(configuration);

                out.print("<table id='table2'>");
                out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");

                // iterate through each table row
                for (int r = 0; r < 5; r++) {

                    // iterate through each table column
                    for (int c = 0; c < 5; c++) {

                        if (r == 0 && c == 0) {
                            out.print("<tr style='background-color: #eee'>");
                            out.print("<td class='forbid'>Requirements</td>");

                        } else if (r == 1 && c == 0) {
                            out.print("<tr>");
                            out.print("<td class='forbid'>Design</td>");

                        } else if (r == 2 && c == 0) {
                            out.print("<tr style='background-color: #eee'>");
                            out.print("<td class='forbid'>Code</td>");

                        } else if (r == 3 && c == 0) {
                            out.print("<tr>");
                            out.print("<td class='forbid'>Trace</td>");

                        } else if (r == 4 && c == 0) {
                            out.print("<tr style='background-color: #eee'>");
                            out.print("<td class='forbid'>Help</td>");

                        } else {
                            cards = null;


                            cards = jsfUtils.returnValueConfiguration(configuration, r, c);
                            //there are cards
                            if (jsfUtils.returnDimArray(cards) > 0) {

                                valueBuild = null;

                                //<td><div class="drag t1">uno</div><div class="drag t1">dos</div></td>
                                //recorremos el vector de cartas
                                for (int x = 0; x < cards.length; x++) {
                                    if (cards[x].equals("G")) {
                                        if (valueBuild == null) {
                                            valueBuild = "<div class='drag t1'>GRAY*</div>";
                                        } else {
                                            valueBuild = valueBuild + "<div class='drag t1'>GRAY*</div>";
                                        }
                                    } else if (cards[x].equals("W")) {
                                        if (valueBuild == null) {
                                            valueBuild = "<div class='drag t1'>WHITE*</div>";
                                        } else {
                                            valueBuild = valueBuild + "<div class='drag t1'>WHITE*</div>";
                                        }

                                    } else if (cards[x].equals("B")) {
                                        if (valueBuild == null) {
                                            valueBuild = "<div id='B1' class='drag t1'> <img src='icon_angry.gif'/></div>";
                                        } else {
                                            valueBuild = valueBuild + "<div id='B1' class='drag t1'> <img src='icon_angry.gif'/></div>";
                                        }

                                    } else if (cards[x].equals("C")) {
                                        if (valueBuild == null) {

                                            valueBuild = "<div id='C1' class='drag t1'> <img src='icon_smile.gif'/></div>";
                                        } else {
                                            valueBuild = valueBuild + "<div id='C1' class='drag t1'> <img src='icon_smile.gif'/></div>";
                                        }


                                    }
                                }
                                out.print("<td>" + valueBuild + "</td>");

                            } //there aren't cards
                            else {
                                out.print("<td></td>");

                            }


                        }
                    }
                    out.print("</tr>");
                }

            }
out.print("</div>");
           
        }

        
                    %>

                    <table id="table3">
                        <colgroup><col width="100"/><col width="100"/><col width="100"/><col width="100"/><col width="100"/></colgroup>
                        <tr style="background-color: #eee">
                            
                        </tr>
                    </table><div id="obj_new"></div>



                    <a href="#" onclick="location.reload(true)">refresh</a>

                    <input type="button" value="Go back"
                           onClick="javascript: history.go(-1)">

                </div><!-- right container -->

            </div><!-- main container -->

      
    </body>
</html>

