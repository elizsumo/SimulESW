package SimulES;

import SimulES.Control.EnvironmentvariablesController;
import SimulES.Control.ModulesProjectController;
import SimulES.Control.MoveController;
import SimulES.Control.PlayerController;
import SimulES.Control.PlayerSoftengineerController;
import SimulES.Control.ProjectController;
import SimulES.Control.RoundController;
import SimulES.Model.Project;
import SimulES.Control.SoftEngineerController;
import SimulES.Model.Environmentvariables;
import SimulES.Model.Modulesproject;
import SimulES.Model.Move;
import SimulES.Model.Player;
import SimulES.Model.Round;
import SimulES.Model.Softengineer;
import SimulES.Util.JSFUtils;
import SimulES.Util.ManageMessages;
import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.Hyperlink;
import com.sun.rave.web.ui.component.StaticText;
import com.sun.rave.web.ui.component.TextField;
import com.sun.rave.web.ui.event.TableSelectPhaseListener;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

/**
 * ******************************************************************
Titulo:	 joga rodada de inicio
Objetivo:	Descrever os preparativos para inicio do jogo.
Contexto:	
Ubicação = web
Java = PlayStartRoundPage
Pre-condição: cenário executado no inicio do jogo somente
pos-condição: executar cenário joga rodada de ações, construção de artefatos 
Todos os jogadores têm que se cadastrar no jogo.
O administrador do jogo fecha a entrada de novos jogadores.
simules_ informa sobre os movimentos feitos pelos jogadores.
O projeto para ser tratado no jogo deve ser escolhido.
Cada jogador tem uma carta de engenheiro de software.
Atores:	jogador, simules_
Recursos:	dado, cartas engenheiro, informações do projeto.
Exceção:
Episódios:	1- Os jogadores se cadastram no jogo
2- simules_ registra os jogares
3- simules_ anuncia os cadastrados
4- O jogador administrador fecha a entrada de jogadores
5- O jogador lança o dado. Restrição: jogador que tirar o maior número no dado, escolhe o projeto
6- simules_ valida a escolha do projeto
7- simules_ anuncia o projeto escolhido
8- Cada jogador compra uma carta de engenheiro de software
9- simules_ registra o engenheiro de software escolhido
Restrição: a ordem na qual os jogadores jogam será acorde com a ordem na qual os jogadores se cadastraram.
 *********************************************************************
 *
 * @version BeginningRoundPage.java
 * @version Created on Jul 23, 2009, 5:32:32 PM
 * @author Elizabeth
 */
public class PlayStartRoundPage extends AbstractPageBean {

    public String username = null;
    private int diceValue = 0;
    public static int roundPage = 1;
//    MoveController moveController = new MoveController();
//    PlayerController playerControler = new PlayerController();
//    RoundController roundController = new RoundController();

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private StaticText lblResultDice = new StaticText();

    public StaticText getLblResultDice() {
        return lblResultDice;
    }

    public void setLblResultDice(StaticText st) {
        this.lblResultDice = st;
    }
    private Button btnTrhowDice = new Button();

    public Button getBtnTrhowDice() {
        return btnTrhowDice;
    }

    public void setBtnTrhowDice(Button b) {
        this.btnTrhowDice = b;
    }
    private TextField softEngName = new TextField();

    public TextField getSoftEngName() {
        return softEngName;
    }

    public void setSoftEngName(TextField tf) {
        this.softEngName = tf;
    }
    private TextField softEngAbility = new TextField();

    public TextField getSoftEngAbility() {
        return softEngAbility;
    }

    public void setSoftEngAbility(TextField tf) {
        this.softEngAbility = tf;
    }
    private TextField softEngMaturity = new TextField();

    public TextField getSoftEngMaturity() {
        return softEngMaturity;
    }

    public void setSoftEngMaturity(TextField tf) {
        this.softEngMaturity = tf;
    }
    private TextField softEngSalary = new TextField();

    public TextField getSoftEngSalary() {
        return softEngSalary;
    }

    public void setSoftEngSalary(TextField tf) {
        this.softEngSalary = tf;
    }
    private Button btnArrow = new Button();

    public Button getBtnArrow() {
        return btnArrow;
    }

    public void setBtnArrow(Button b) {
        this.btnArrow = b;
    }
    private Hyperlink hyperlinkArrow = new Hyperlink();

    public Hyperlink getHyperlinkArrow() {
        return hyperlinkArrow;
    }

    public void setHyperlinkArrow(Hyperlink h) {
        this.hyperlinkArrow = h;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PlayStartRoundPage() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("BeginningRoundPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here

    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
        //enquanto o engenheiro de software não seja escolhido os campos devem ficar vazios
        if (!getApplicationBean1().isSoftEngChoosen()) {
            refreshEngSoftware();
        }

    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }
    private TableSelectPhaseListener tablePhaseListener =
            new TableSelectPhaseListener();

    public void setSelected(Object object) {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }

    public Object getSelected() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.getSelected(rowKey);

    }

    public Object getSelectedValue() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return (rowKey != null) ? rowKey.getRowId() : null;

    }

    public boolean getSelectedState() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.isSelected(rowKey);
    }

    // @ Episode 4: The player chooses the project
    public String btnSelectProject_action() {

        chooseProject();

        return null;
    }

    //@episodio escolher o projeto
    public void chooseProject() {
        MoveController moveController = new MoveController();
        String nameMaxDice = null;

        try {

            if (userIsValid()) {
                if (getApplicationBean1().isCloseEntryPlayer()) {

                    PlayerController playerController = new PlayerController();

                    try {
                        nameMaxDice = playerController.getMaxDicetByPlayer().getNickname();

                    } catch (Exception ex) {

                        String message = "There was an error, try again";
                        ex.printStackTrace();
                        FacesMessage fm = new FacesMessage(message);
                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    }

                    if (username.equals(nameMaxDice)) {
                        if (!isProjectChose()) {
                            if (markProject()) {
                                List<Project> projectList = getSessionBean1().getProjectList();

                                //  int sizeProject = projectList.size();

                                JSFUtils utils = new JSFUtils();

                                int rowId = utils.generateRandom(7);

                                ProjectController projectController = new ProjectController();

                                Project project = projectController.getProjectByID(rowId);

                                getApplicationBean1().setProjectGame(true);

                                ProjectController projectHelper = new ProjectController();
                                List<Project> projectChoose = projectHelper.getProject(rowId);
                                getApplicationBean1().setProjectChoose(projectChoose);

                                ModulesProjectController modulesHelper = new ModulesProjectController();
                                List<Modulesproject> modules = modulesHelper.getModulesProject(rowId);
                                getApplicationBean1().setModulesProject(modules);

                                if (projectHelper.updateProject(project)) {

                                    String message = "The project: " + project.getName() + " has been selected";

                                    lblResultDice.setValue(message);

                                    getApplicationBean1().addEntry(username, message);

                                    moveController.closeMove(2);
                                    moveController.enableNextMove(3);
                                }
                            } else {
                                FacesMessage fm = new FacesMessage("Error in Database, try again your operation");
                                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                FacesContext.getCurrentInstance().addMessage(null, fm);
                            }
                        } else {
                            FacesMessage fm = new FacesMessage("The project has already been choose");
                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                            FacesContext.getCurrentInstance().addMessage(null, fm);
                        }
                    } else {
                        FacesMessage fm = new FacesMessage("Only " + nameMaxDice + " can choose the project");
                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    }

                } else {
                    FacesMessage fm = new FacesMessage("Movement doesn't allow or player input is open");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

    }

    // @Episode 3: The player throws the dice
    public String trhowDice_action() {

        rollTheDice();

        return null;
    }

    //@eposidio para lançar o dado
    public void rollTheDice() {
        MoveController moveController = new MoveController();
        PlayerController playerControler = new PlayerController();
        RoundController roundController = new RoundController();
        int moveDice = 1;
        try {

            MoveController mController = new MoveController();

            Move move = mController.getMove(moveDice);

            username = getSessionBean1().getUsername();

            if (userIsValid()) {

                if (move.getState().equals("A")) {

                    if (move.getPlayer().getNickname().equals(username)) {


                        setDiceValue(generateRandom());

                        if (playerControler.updatePlayerByDice(playerControler.getPlayer(getSessionBean1().getUsername()), getDiceValue())) {

                            Player playerMax = playerControler.getMaxIdPlayer();

                            if (playerMax.getNickname().equals(username)) {
                                moveController.closeMove(moveDice);
                                moveController.enableNextMove(moveDice + 1);
                            } else {
                                moveController.updateNextPlayerToMove();
                            }
                            String message = username + " his result Dice has been: " + getDiceValue();

                            lblResultDice.setText(message);

                            getApplicationBean1().addEntry(username, message);


                        } else {
                            FacesMessage fm = new FacesMessage("Result Dice has an error");
                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                            FacesContext.getCurrentInstance().addMessage(null, fm);
                            setDiceValue(0);
                        }


                    } else {
                        ManageMessages.addMessage("Player who should play is: " + move.getPlayer().getNickname());
                    }
                } else if (move.getState().equals("E")) {
                    ManageMessages.addMessage("The move has already been executed by all players");
                } else {
                    ManageMessages.addMessage("Movement doesn't allow or player input is open");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            setDiceValue(0);
        }
    }

    // @ Episode 5: The player chooses the first software engineer
    public String btnEngSoft_action() {

        chooseFirstSoftEngineer();

        return null;
    }

    //@eposidio escolher o primeiro eng de software
    public void chooseFirstSoftEngineer() {
        try {

            int moveChooseEngSoft = 3;

            MoveController moveController = new MoveController();
            PlayerController playerControler = new PlayerController();
            RoundController roundController = new RoundController();
            Move move = moveController.getMove(moveChooseEngSoft);

            username = getSessionBean1().getUsername();
            if (userIsValid()) {

                if (move.getState().equals("A")) {

                    if (move.getPlayer().getNickname().equals(username)) {

                        if (!getSoftwareEngineersByPlayer()) {

                            if (!username.isEmpty()) {
                                List<Softengineer> softEngineerList;

                                SoftEngineerController SEH = new SoftEngineerController();

                                softEngineerList = SEH.getSoftEngineerFree();

                                int sizeSoft = softEngineerList.size();

                                JSFUtils utils = new JSFUtils();

                                int idSoft = utils.generateRandom(sizeSoft);

                                Softengineer softEngineer = softEngineerList.get(idSoft);

                                if (!softEngineer.toString().isEmpty()) {

                                    PlayerController playerhelper = new PlayerController();

                                    Player player = playerhelper.getPlayer(username);

                                    PlayerSoftengineerController playersoft = new PlayerSoftengineerController();

                                    if (playersoft.addPlayerSoftengineer(player, softEngineer)) {

                                        if (SEH.employSoftwareEngineer(softEngineer)) {
                                            lblResultDice.setValue("Your first Engineer software is: " + softEngineer.getName());

                                            softEngName.setText(softEngineer.getName());
                                            softEngAbility.setText(softEngineer.getHability());
                                            softEngMaturity.setText(softEngineer.getMaturity());
                                            softEngSalary.setText(softEngineer.getSalary());

                                            String message = username + "  his first software engineer is: " + softEngName.getText();

                                            lblResultDice.setValue(message);

                                            getApplicationBean1().setSoftEngChoosen(true);

                                            getApplicationBean1().addEntry(username, message);

                                            Player playerMax = playerControler.getMaxIdPlayer();
                                            Player playerMin = playerControler.getMinIdPlayer();

                                            //é abilitada a seguinte rodada
                                            if (playerMax.getNickname().equals(username)) {
                                                moveController.closeMove(moveChooseEngSoft);
                                                roundController.closeRound(roundPage);
                                                moveController.enableNextMove(4);
                                                roundController.enableNextRound(roundPage + 1);
                                                
                                            } else {
                                                moveController.updateNextPlayerToMove();
                                            }

                                        } else {
                                            FacesMessage fm = new FacesMessage("Try again!!, error when employing your soft engineer");
                                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                            FacesContext.getCurrentInstance().addMessage(null, fm);
                                        }


                                    } else {
                                        FacesMessage fm = new FacesMessage("Try again!!, error when employing your soft engineer");
                                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                        FacesContext.getCurrentInstance().addMessage(null, fm);
                                    }


                                } else {
                                    FacesMessage fm = new FacesMessage("Try again!!, this software engineer are busy");
                                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                    FacesContext.getCurrentInstance().addMessage(null, fm);
                                }
                            } else {
                                FacesMessage fm = new FacesMessage("Try again!!, his username is empty");
                                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                FacesContext.getCurrentInstance().addMessage(null, fm);
                            }
                        } else {
                            FacesMessage fm = new FacesMessage("You has choosen your first Software Engineer yet");
                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                            FacesContext.getCurrentInstance().addMessage(null, fm);
                        }

                    } else {
                        ManageMessages.addMessage("Player who should play is: " + move.getPlayer().getNickname());
                    }

                } else if (move.getState().equals("E")) {
                    ManageMessages.addMessage("The move has already been executed by all players");
                } else {
                    ManageMessages.addMessage("Movement doesn't allow or player input is open");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    // @Episode 2: The player entries the game
    public String btnJoinGame_action() {

        try {

            if (!getApplicationBean1().isCloseEntryPlayer()) {

                if (!username.isEmpty()) {

                    //  String username = "Elizabeth";

                    PlayerController helper = new PlayerController();

                    if (helper.playerExist(username)) {
                        FacesMessage fm = new FacesMessage("The Player already exists, change your username");
                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    } else {

                        helper.createPlayer(username);

                        getApplicationBean1().getAllPalyer();

                        FacesMessage fm = new FacesMessage("Player was created");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    }

                } else {

                    FacesMessage fm = new FacesMessage("Error username is null");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                }
            } else {
                FacesMessage fm = new FacesMessage("Error the game has been closed");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }

    public String btnStartGame_action() {

        PlayerController helper = new PlayerController();

        boolean starGame = getApplicationBean1().isStarGame();

        if (!starGame) {

            getApplicationBean1().setStarGame(true);
            FacesMessage fm = new FacesMessage("The game was started");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        } else {

            boolean option = ((JOptionPane.showConfirmDialog(null, "Are you sure, The game already was started?", "Quit", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION);

            if (option) {
                // boolean playerDelete = helper.deletePlayers();

                System.out.println("The game was started");

                FacesMessage fm = new FacesMessage("The game already was started again");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, fm);

            } else {
                System.out.println("Choice not");
            }
        }


        return null;
    }

    public int generateRandom() {
        int n = 0;
        do {
            n = (int) Math.round(Math.random() * 10);
        } while (n > 6 || n < 1);

        return n;
    }

    public boolean createPlayerSoftEngRel(String playerId, String softEngId) {
        PlayerSoftengineerController psh = new PlayerSoftengineerController();

        short uno = Short.parseShort(playerId);
        short dos = Short.parseShort(softEngId);

        Boolean add = psh.addPlayerSoftengineer(uno, dos);

        return add;

    }

    public String imgJoinGame_action() {

        joinGame();

        return null;
    }

    //@eposidio registrarse no jogo
    public void joinGame() {
        try {

            username = getSessionBean1().getUsername();
            if (userIsValid()) {

                if (!getApplicationBean1().isCloseEntryPlayer()) {



                    PlayerController helper = new PlayerController();

                    if (helper.playerExist(username)) {
                        FacesMessage fm = new FacesMessage("The Player already exists, change your username");
                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    } else {

                        if (helper.getSizeListPlayer()<5)
                        {

                        if (helper.createPlayer(username)) {
                            getApplicationBean1().getAllPalyer();

                            FacesMessage fm = new FacesMessage("Player was created");
                            fm.setSeverity(FacesMessage.SEVERITY_INFO);
                            FacesContext.getCurrentInstance().addMessage(null, fm);

                            getApplicationBean1().addEntry(username, username + " join the game");

                            
                        } else {
                            FacesMessage fm = new FacesMessage("Player was not created");
                            fm.setSeverity(FacesMessage.SEVERITY_INFO);
                            FacesContext.getCurrentInstance().addMessage(null, fm);
                        }
                        }
                        else
                        {
                            FacesMessage fm = new FacesMessage("The maximum amount of players is 5");
                            fm.setSeverity(FacesMessage.SEVERITY_INFO);
                            FacesContext.getCurrentInstance().addMessage(null, fm);
                        }
                    }

                    

                } else {
                    FacesMessage fm = new FacesMessage("Error the game has been closed");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public String hyperlinkJoinGame_action() {
        joinGame();
        return null;
    }

    public String hyperlinkRollDice_action() {
        rollTheDice();
        return null;
    }

    public String hyperlinkChooseProject_action() {
        chooseProject();
        return null;
    }

    public String hyperlinkSoftEng_action() {
        chooseFirstSoftEngineer();
        return null;
    }

    /**
     * @return the diceValue
     */
    public int getDiceValue() {
        return diceValue;
    }

    /**
     * @param diceValue the diceValue to set
     */
    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }

    //@episodio permite validar que o jogador não se tenha nenhum engenheiro de soft
    // no inicio do jogo
    public boolean getSoftwareEngineersByPlayer() {
        boolean existSoftEng = false;

        PlayerController playercontroller = new PlayerController();
        PlayerSoftengineerController playersoftcontroller = new PlayerSoftengineerController();

        String username = getSessionBean1().getUsername();
        int idPlayer = playercontroller.getPlayerId(username);

        List<Softengineer> softEngList = null;

        softEngList = playersoftcontroller.getSoftEngByPlayer(idPlayer);

        if (!softEngList.isEmpty()) {
            existSoftEng = true;
        }

        return existSoftEng;
    }

    //@episodio validamos a sessao do usuario
    public boolean userIsValid() {
        boolean isValid = true;
        try {
            if (getSessionBean1().getUsername().isEmpty()) {
                isValid = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("user is null");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            isValid = false;

        }
        return isValid;

    }

    //@episidio refresh nos campos de engenheiro de software
    public void refreshEngSoftware() {
        softEngName.setText("");
        softEngAbility.setText("");
        softEngMaturity.setText("");
        softEngSalary.setText("");
    }

    //episodio5 SimulES disponibiliza as informações dos movimentos do jogo;
    public String getTranscript() {
        String[][] entries =
                getApplicationBean1().getEntries();
        if (entries == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < entries.length; i++) {
            String entryUsername = entries[i][0];
            String comment = entries[i][1];
            String color = "purple";
            String username = getSessionBean1().getUsername();
            if (username.equals(entryUsername)) {
                color = "blue";
            }
            sb.append(
                    "<div><span style=\"font-weight:bold;color:");
            sb.append(color);
            sb.append("\">[");
            sb.append(entryUsername);
            sb.append("]</span> ");
            sb.append(comment);
            sb.append("</div>");
        }
        return sb.toString();
    }

    //@episodie obter a descripção da ronda ativa para abilitar o botao
    // e seguir na seguinte ronda
    public boolean getRoundActive() {

        boolean bEnable = false;
        btnArrow.setDisabled(true);
        hyperlinkArrow.setDisabled(true);

        RoundController roundController = new RoundController();

        Round actRound = roundController.getActiveRound();

        int idRound = actRound.getRoundId();

        if (idRound == 2) {
            btnArrow.setDisabled(false);
            hyperlinkArrow.setDisabled(false);
            bEnable = true;
        }
        return bEnable;
    }

    public String btnArrow_action() {
        if (getRoundActive()) {
            return "case2";
        } else {
            FacesMessage fm = new FacesMessage("The next round is not yet enabled");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);

            return null;
        }
    }

    public String hyperlinkArrow_action() {
        if (getRoundActive()) {
            return "case3";
        } else {
            FacesMessage fm = new FacesMessage("The next round is not yet enabled");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    //validar que o projecto ainda não fosse escolhido
    public boolean isProjectChose() {
        boolean isChose = false;
        EnvironmentvariablesController evc = new EnvironmentvariablesController();
        Environmentvariables environmentvariable = evc.getEnvironmentVariable(3);
        if (environmentvariable.getState() == 1) {
            isChose = true;
        }
        return isChose;
    }

    public boolean markProject() {
        boolean isProjectMark = false;
        EnvironmentvariablesController evc = new EnvironmentvariablesController();
        Environmentvariables environmentvariable = evc.getEnvironmentVariable(3);
        if (evc.updateEnvironmentVariables(environmentvariable, 1)) {
            isProjectMark = true;
        }
        return isProjectMark;
    }
}

