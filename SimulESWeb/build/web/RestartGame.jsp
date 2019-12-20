<%-- 
    Document   : RestartGamejsp
    Created on : Jul 31, 2009, 8:57:29 PM
    Author     : Elizabeth
--%>
<%@page import="SimulES.Model.*"%>
<%@page import="SimulES.Control.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SimulES</title>
    </head>
    <body>
        <%
        EnvironmentvariablesController environmentvariablesController = new EnvironmentvariablesController();
        boolean evValue = environmentvariablesController.restartEnvironmentVariables();

        PlayerSoftengineerController playerSoftEngHelper = new PlayerSoftengineerController();
        boolean playerEng = playerSoftEngHelper.deletePlayerSoftEng();

        ProjectController projectController = new ProjectController();
        boolean restartProjects = projectController.restartProjects();

        PlayersproblemsController playersproblemsController = new PlayersproblemsController();
        boolean playerProblem = playersproblemsController.deletePlayersProblems();

        SoftEngineerController softEngHelper = new SoftEngineerController();
        boolean softEngRestart = softEngHelper.restartSoftEngineer();

        PlayerCardController playerCardHelper = new PlayerCardController();
        boolean playerCard = playerCardHelper.deletePlayerCard();

        IndividualboardController individualboardController = new IndividualboardController();
        boolean individualBoardDelete = individualboardController.deleteIndividualboard();

         MoveController moveController = new MoveController();
        boolean restartMove = moveController.restartMove();

        RoundController roundcontroller = new RoundController();
        boolean restartRound = roundcontroller.restartRounds();
        boolean enableFirstRound = roundcontroller.enableNextRound(1);

        AcceptmoveController acceptmoveController = new AcceptmoveController();
        boolean moveDelete = acceptmoveController.deleteMove();

        PlayerController helper = new PlayerController();
        boolean playerDelete = helper.deletePlayers();


        %>
        <h1>The game was restarted!</h1>
    </body>
</html>
