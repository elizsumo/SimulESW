<%--
    Document   : index
    Created on : Aug 18, 2009, 10:26:45 AM
    Author     : Elizabeth

      Cenário - Construir Artefatos

     Objetivo:  Permitir ao Jogador da Vez alterar/incluir artefatos no seu tabuleiro.
     Contexto:  O Jogador da Vez pode comprar artefatos e escolher colocar em: Requerimentos, Design, Código, Rastreabilidade ou Ajuda.
                Pré-Condições: Login, Ser administrador do projeto selecionado.
     Atores:    Jogador da Vez
     Recursos:  Artefatos
     Episódios: O Jogador da Vez seleciona o radio Button (Build Artifacts), e então é permitido acrescentar/mudar
                Após decidir a melhor configuração possível de seus artefatos, o Jogador deve clicar no button "Submit"
                para então gravar as alterações feitas.

     ------------------------------------------------------------------------------------------------------------------------------------

     Cenário - Inspecionar Artefatos

     Objetivo:  Permitir ao Jogador da Vez verificar a consistência dos seus artefatos.
     Contexto:  O Jogador da Vez pode verificar seus artefatos para saber se eles foram implementados com Bug ou corretamente.
                Pré-Condições: Login, Ser administrador do projeto selecionado.
     Atores:    Jogador da Vez
     Recursos:  Artefatos
     Episódios: O Jogador da Vez seleciona o radio Button (Inspect Artifacts), e então é permitido olha o conteúdo das cartas.

                -Se após a inspeção, todos os artefatos tiverem ok para um  projeto individualmente. Então estes artefatos podem ser em-
                 pacotados e o produto fechado. Desta forma, este novo pacote estará livre de modificação por cartas problemas ou qualquer
                 outra coisa.
                 Para empacotar o produto, o Jogador da Vez deverá clicar no Button "Intagrate".

     ------------------------------------------------------------------------------------------------------------------------------------

    Cenário - Correct Artefatos

     Objetivo:  Permitir ao Jogador da Vez corrigir artefatos defeituosos.
     Contexto:  O Jogador da Vez, após ter inspecionado os artefatos, poderá agora corrigir aqueles onde encontraram defeitos.
                Pré-Condições: Login, Ser administrador do projeto selecionado.
     Atores:    Jogador da Vez
     Recursos:  Artefatos
     Episódios: O jogador em questão seleciona o radio Button (Correct Artefacts), e então é permitido corrigir os mesmos

     ------------------------------------------------------------------------------------------------------------------------------------
--%>

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

        <center>
            <h2>Individual Board by Player</h2>


        </center>

        <div id="main_container">
            <!-- tables inside this DIV could have draggable content -->

        <!-- tables inside this DIV could have draggable content -->
            <div id="drag">

                <!-- left container -->
                <div id="left">



                    <input type="hidden" id="player" value="<%=request.getParameter("id")%>">
                    <input type="hidden" id="username" value="<%=request.getParameter("username")%>">



                    <%    // SCRIPT CHAMADO PARA PEGAR O ID

        // Foi passado por post uma variável com o id do jogador referente ao tabuleiro aberto

        int playerID = 1;
        String configuration = null;
        boolean existConf = false;
        if (request.getParameter(
                "id") != null) {
            playerID = Integer.parseInt(request.getParameter("id"));

        }

        if (request.getParameter(
                "username") != null) {

            String logado = new String(request.getParameter("username").toString());


        }
                    %>


                    <%

        //


        // obter o projeto do jogo
        ProjectController projecthelper = new ProjectController();
        Project project = projecthelper.getProjectObject();



        if (project == null) {
            out.print("<h2> There is not project chosen </h2>");
        } else {

            out.print("<h2>Project: " + project.getName() + "</h2>");

            out.print("<table id='table0'>");
            out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");

            out.print("<tr style='background-color: #9BB3DA'>");
            out.print("<td class=mark green_cell single> Description </td>");

            out.print("<td class=mark green_cell single> Complexity: " + project.getComplexity() + "</td>");
            out.print("<td class=mark green_cell single> Size: " + project.getSize() + "</td>");
            out.print("<td class=mark green_cell single> Quality: " + project.getQuality() + "</td>");
            out.print("<td class=mark green_cell single> Budget: " + project.getBudget() + "</td>");

            out.print("</table>");
        }
                    %>

                    <%

        // obter modulos do projeto do jogo
        ModulesProjectController modulesthelper = new ModulesProjectController();
        List modulesList = modulesthelper.getModulesProjectChose();
        Modulesproject moduleProject = null;

        int modulesSize = modulesList.size();

        if (modulesSize > 0) {


            for (int i = 0; i < modulesSize; i++) {


                int module = i + 1;

                moduleProject = modulesthelper.getModuleById(i);

                out.print("<table id='table0" + i + "'>");


                out.print("<tr>");
                out.print("<td class=mark green_cell single> module: " + module + "</td>");
                out.print("</tr>");

                out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");
                out.print(
                        "<tr>");

                out.print("<td class='mark green_cell single'>Requeriment: " + moduleProject.getRequirement() + "</td>");
                out.print("<td class='mark green_cell single'>Design: " + moduleProject.getDesign() + "</td>");
                out.print("<td class='mark green_cell single'>Code: " + moduleProject.getCode() + "</td>");
                out.print("<td class='mark green_cell single'>Traceability: " + moduleProject.getTraceability() + "</td>");
                out.print("<td class='mark green_cell single'>Help: " + moduleProject.getHelp() + "</td>");

            }


            out.print("</tr>");

            out.print("</table>");
        }
                    %>

                    <%
        //tabela para apresentar os problemas jogados para cada jogador
        PlayersproblemsController playerProblems = new PlayersproblemsController();

        List<Card> cardList = null;

        cardList = (List<Card>) playerProblems.getCardsProblemsByPlayer(playerID);


        int cardListSize = cardList.size();


        out.print("<table id='table12'>");
        out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");


        out.print("<h2>Problems By Player</h2>");

        if (cardListSize > 0 && cardListSize <= 10) {

            for (int i = 0; i < cardListSize; i++) {
                Card card = (Card) cardList.get(i);
                out.print("<tr>");
                out.print("<td class='mark green_cell single'>Id: " + card.getCardId() + "</td>");
                out.print("<td class='mark orange_cell single'>Name: " + card.getName() + "</td>");
                out.print("<td class='mark green_cell single'>Description: " + card.getDescription() + "</td>");
                out.print("<td class='mark orange_cell single'>Rule: " + card.getRule() + "</td>");
                out.print("<td class='mark green_cell single'>Category: " + card.getCategory() + "</td>");
                out.print("</tr>");
            }
        }
        out.print("</table>");
                    %>



                </div><!-- left container -->


<!-- right container -->
                <div id="right">

                    <%
        //obter o nome do jogador e dono do tabuleiro
        int usernameId = 0;
        PlayerController playerController = new PlayerController();
        Player player = playerController.getPlayer(playerID);
        String playerName = player.getNickname();

        //recuperar o objeto do movimento
        MoveController mController = new MoveController();
        Move move = mController.getMove(4);
       // RoundController rController = new RoundController();
       // Round round = rController.getRound(2);

        //validamos que jogador ativo seja o jogador a estar realizandoa a jogada


        // Foi passado o parametro "username" para a página, contendo o nome do usuario logado. Com este nome podemos obter o ID do mesmo.

        //inicialmente validamos que o jogador exista na tabela de jogadores
        Boolean playerExist = playerController.playerExist(request.getParameter("username"));

        //se jogador existir
        if (playerExist) {

            Player playerUsername = playerController.getPlayer(request.getParameter("username"));

            usernameId = playerUsername.getPlayerId();


            //validamos que o jogador que existe eh o dono do tabuleiro a ser mudado

            //se eles sao iguais
            if (usernameId == playerID) {

                int idUserActive = move.getPlayer().getPlayerId();
                //validamos que a jogada este ativa
                if (move.getState().equals("A") && idUserActive == usernameId) {
                //if (round.getState().equals("A") && idUserActive == usernameId) {
                    {
                        usernameId = playerUsername.getPlayerId();
                    }
                } else {
                    usernameId = 2;
                }
            } else {
                usernameId = 1;
            }
        }

        out.print("<h2> Player: " + playerName + "</h2>");

        // O ID recuperado acime é então usado para pegar também o seu nome.

        PlayerSoftengineerController helper = new PlayerSoftengineerController();
        List softEngList = helper.getSoftEngEmployedByPlayer(playerID);

        int softEngSize = softEngList.size();


        out.print("<table id='table1'>");
        out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");
        out.print(
                "<tr>");
        out.print(
                "<td class='forbid'>Software Engineer employed</td>");

        if (softEngSize > 0 && softEngSize <= 4) {

            for (int i = 0; i < softEngSize; i++) {
                Softengineer softEng = (Softengineer) softEngList.get(i);
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



                    %>

                    <%
        out.print("<table id='table11'>");
        out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");
        out.print(
                "<tr>");
        out.print(
                "<td class='forbid'>Description: </td>");

        if (softEngSize > 0 && softEngSize <= 4) {

            for (int i = 0; i < softEngSize; i++) {
                Softengineer softEng = (Softengineer) softEngList.get(i);
                out.print("<td class='mark orange_cell single'>Salary: " + softEng.getSalary() + "  Ability: " + softEng.getHability() + "  Maturity: " + softEng.getMaturity() + "</td>");
            }
        }


        out.print("</tr>");

        out.print("</table>");
                    %>

                    <input type="hidden" id="usernameId" value="<%=usernameId%>">

                    <%
        // Recupera a ultima configuração do tabuleiro que está sendo acessado no momento.

        IndividualboardController individualboardController = new IndividualboardController();
        configuration = individualboardController.getPlayerConfiguration(playerID);
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
                    %>

                    <table id="table3">
                        <colgroup><col width="100"/><col width="100"/><col width="100"/><col width="100"/><col width="100"/></colgroup>
                        <tr style="background-color: #eee">
                            <td class="forbid" title="You can not drop here">Cards:</td>
                            <td><div class="drag t2 clone">GRAY</div></td>
                            <td><div class="drag t3 clone">WHITE</div></td>
                            <td> <div><input type="button" value="Show content of the board" class="button" onclick="table_content('table2')" title="Show content of the individual board game"/><span class="message_line"></span></div></td>
                            <td class="trash" title="Trash">Trash Cards</td>
                        </tr>
                    </table><div id="obj_new"></div>


                    <div><input type="radio" name="drop_option" class="checkbox" onclick="set_drop_option(this)" value="build" title="Build artifacts" /><span class="message_line">Build artifacts</span></div>
                    <div><input type="radio" name="drop_option" class="checkbox" onclick="set_drop_option(this)" value="inspect" title="Inspect artifacts" /><span class="message_line">Inspect artifacts</span></div>
                    <div><input type="radio" name="drop_option" class="checkbox" onclick="set_drop_option(this)" value="correct" title="Correct Artifacts" /><span class="message_line">Correct Artifacts</span></div>
                    <div><input type="radio" name="drop_option" class="checkbox" onclick="set_drop_option(this)" value="discard" title="Discard Artifacts" /><span class="message_line">Discard Artifacts</span></div>
                    <div><input type="checkbox" class="checkbox" onclick="toggle_confirm(this)" title="Confirm before delete object" checked="true"/><span class="message_line">Confirm before delete object</span></div>
                    <!--Este Botão chama a função JavaScript que grava a nova configuraçã do tabuleiro -->
                    <form onsubmit="read_table_content('table2'); return false;">
                        <table>
                            <tr>
                                <td><b>Submit board configuration:</b></td>
                                <td><a:widget name="yahoo.tooltip" args="{context:['Observations']}" value="Observations."  /></td>
                                <td><input type="submit" value="Submit"/></td>
                                <td><input type="hidden" value="submit" /></td>
                            </tr>
                        </table>
                    </form>
                    <!--Este Botão chama a função JavaScript que fecha o pacote do projeto -->
                    <form onsubmit="save_table_content('table2'); return false;">
                        <table>
                            <tr>
                                <td><b>Integrate and Submit product:</b></td>
                                <td><a:widget name="yahoo.tooltip" args="{context:['Observations1']}" value="Observations1."  /></td>
                                <td><input type="submit" value="Integrate"/></td>
                                <td><input type="hidden" value="submit" /></td>
                            </tr>
                        </table>

                    </form>



                    <%


        List<Card> cardList1 = null;

        cardList1 = (List<Card>) playerProblems.getCardsConceptUsedByPlayer(playerID);


        int cardListSize1 = cardList1.size();


        out.print("<table id='table121'>");
        out.print("<colgroup><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/><col width=" + 100 + "/></colgroup>");


        out.print("<h2>Card Concepts Used By Player</h2>");

        if (cardListSize1 > 0 && cardListSize1 <= 10) {

            for (int i = 0; i < cardListSize1; i++) {
                Card card1 = (Card) cardList1.get(i);
                out.print("<tr>");
                out.print("<td class='mark green_cell single'>Id: " + card1.getCardId() + "</td>");
                out.print("<td class='mark orange_cell single'>Name: " + card1.getName() + "</td>");
                out.print("<td class='mark green_cell single'>Description: " + card1.getDescription() + "</td>");
                out.print("<td class='mark orange_cell single'>Rule: " + card1.getRule() + "</td>");
                out.print("<td class='mark green_cell single'>Category: " + card1.getCategory() + "</td>");
                out.print("</tr>");
            }
        }
        out.print("</table>");

        //save in a variable the user name
        String UserLog = new String(request.getParameter("username").toString());

         out.print("<tr>");
            out.print("<td class='COL2'><a href=\"/SimulESWeb/faces/PlayActionsRoundPage.jsp?username=" + UserLog + "\">Go back The Actions Round</a></td>");
             out.print("</tr>");


                    %>

 <a href="#" onclick="location.reload(true)">refresh</a>

                </div><!-- right container -->



            </div>

        </div><!-- main container -->
    </body>
</html>
