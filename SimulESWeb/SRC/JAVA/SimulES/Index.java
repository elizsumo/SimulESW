package SimulES;

import SimulES.Control.AcceptmoveController;
import SimulES.Control.EnvironmentvariablesController;
import SimulES.Control.MoveController;
import SimulES.Control.PlayerController;
import SimulES.Control.RoundController;
import SimulES.Model.Acceptmove;
import SimulES.Model.Environmentvariables;
import SimulES.Model.Move;
import SimulES.Model.Player;
import SimulES.Model.Round;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Hyperlink;
import com.sun.rave.web.ui.component.ImageHyperlink;
import com.sun.rave.web.ui.component.PanelGroup;
import com.sun.rave.web.ui.component.PanelLayout;
import com.sun.rave.web.ui.component.StaticText;
import com.sun.rave.web.ui.component.TextField;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * ******************************************************************
Titulo: SDsituations apresentar dinâmica do jogo
Objetivo: Descrever e disponibilizar as informações gerais do jogo.
Contexto: Localização geografica: Web
Localização temporal: Java index
Precondições: Serviços web disponíveis
Poscondições: Informações gerais do jogo disponíveis Atores: jogador, SimulES
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Episódios:
1 – jogador entra no jogo
2 – jogador pode trocar mensagens com os jogadores;
3 – SimulES disponibiliza as informações do projeto escolhido;
4 – SimulES disponibiliza as informações de aceitação de movimentos;
5 – SimulES disponibiliza as mensagens trocadas entre os jogadores;
6 – SimulES disponibiliza as informações dos movimentos do jogo;
Restrições: tempo de resposta adequado

 *********************************************************************
 * 
 * @version Index.java
 * @version Created on Jun 15, 2009, 10:13:18 PM
 * @author Elizabeth
 */
public class Index extends AbstractPageBean {

    private List<Acceptmove> acceptmoveList = null;
    private List<Player> allPlayer = null;
    private List<Round> activeRound = null;
    private String playerName = null;
    private String nextPlayerName = null;
    private String nameRound = null;
    private String strPlayer1 = null;
    private String strPlayer2 = null;
    private String strPlayer3 = null;
    private String strPlayer4 = null;
    private String strPlayer5 = null;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private TextField comment = new TextField();

    public TextField getComment() {
        return comment;
    }

    public void setComment(TextField tf) {
        this.comment = tf;
    }
    private StaticText staticText1 = new StaticText();

    public StaticText getStaticText1() {
        return staticText1;
    }

    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }
    private StaticText staticTextUserName = new StaticText();

    public StaticText getStaticTextUserName() {
        return staticTextUserName;
    }

    public void setStaticTextUserName(StaticText st) {
        this.staticTextUserName = st;
    }
    private ImageHyperlink imgPlayer2 = new ImageHyperlink();

    public ImageHyperlink getImgPlayer2() {
        return imgPlayer2;
    }

    public void setImgPlayer2(ImageHyperlink ih) {
        this.imgPlayer2 = ih;
    }
    private ImageHyperlink imgPlayer1 = new ImageHyperlink();

    public ImageHyperlink getImgPlayer1() {
        return imgPlayer1;
    }

    public void setImgPlayer1(ImageHyperlink ih) {
        this.imgPlayer1 = ih;
    }
    private Hyperlink linkRoundActive = new Hyperlink();

    public Hyperlink getLinkRoundActive() {
        return linkRoundActive;
    }

    public void setLinkRoundActive(Hyperlink h) {
        this.linkRoundActive = h;
    }
    private StaticText player1 = new StaticText();

    public StaticText getPlayer1() {
        return player1;
    }

    public void setPlayer1(StaticText st) {
        this.player1 = st;
    }
    private StaticText player2 = new StaticText();

    public StaticText getPlayer2() {
        return player2;
    }

    public void setPlayer2(StaticText st) {
        this.player2 = st;
    }
    private StaticText player3 = new StaticText();

    public StaticText getPlayer3() {
        return player3;
    }

    public void setPlayer3(StaticText st) {
        this.player3 = st;
    }
    private StaticText player4 = new StaticText();

    public StaticText getPlayer4() {
        return player4;
    }

    public void setPlayer4(StaticText st) {
        this.player4 = st;
    }
    private StaticText player5 = new StaticText();

    public StaticText getPlayer5() {
        return player5;
    }

    public void setPlayer5(StaticText st) {
        this.player5 = st;
    }
    private ImageHyperlink imgPlayer3 = new ImageHyperlink();

    public ImageHyperlink getImgPlayer3() {
        return imgPlayer3;
    }

    public void setImgPlayer3(ImageHyperlink ih) {
        this.imgPlayer3 = ih;
    }
    private ImageHyperlink imgPlayer4 = new ImageHyperlink();

    public ImageHyperlink getImgPlayer4() {
        return imgPlayer4;
    }

    public void setImgPlayer4(ImageHyperlink ih) {
        this.imgPlayer4 = ih;
    }
    private ImageHyperlink imgPlayer5 = new ImageHyperlink();

    public ImageHyperlink getImgPlayer5() {
        return imgPlayer5;
    }

    public void setImgPlayer5(ImageHyperlink ih) {
        this.imgPlayer5 = ih;
    }
    private HtmlPanelGrid grdPlayer1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdPlayer1() {
        return grdPlayer1;
    }

    public void setGrdPlayer1(HtmlPanelGrid hpg) {
        this.grdPlayer1 = hpg;
    }
    private HtmlPanelGrid grdPlayer2 = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdPlayer2() {
        return grdPlayer2;
    }

    public void setGrdPlayer2(HtmlPanelGrid hpg) {
        this.grdPlayer2 = hpg;
    }
    private HtmlPanelGrid grdPlayer3 = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdPlayer3() {
        return grdPlayer3;
    }

    public void setGrdPlayer3(HtmlPanelGrid hpg) {
        this.grdPlayer3 = hpg;
    }
    private HtmlPanelGrid grdPlayer4 = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdPlayer4() {
        return grdPlayer4;
    }

    public void setGrdPlayer4(HtmlPanelGrid hpg) {
        this.grdPlayer4 = hpg;
    }
    private HtmlPanelGrid grdPlayer5 = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdPlayer5() {
        return grdPlayer5;
    }

    public void setGrdPlayer5(HtmlPanelGrid hpg) {
        this.grdPlayer5 = hpg;
    }
    private Hyperlink hyperlinkPlayer1 = new Hyperlink();

    public Hyperlink getHyperlinkPlayer1() {
        return hyperlinkPlayer1;
    }

    public void setHyperlinkPlayer1(Hyperlink h) {
        this.hyperlinkPlayer1 = h;
    }
    private Hyperlink hyperlinkPlayer2 = new Hyperlink();

    public Hyperlink getHyperlinkPlayer2() {
        return hyperlinkPlayer2;
    }

    public void setHyperlinkPlayer2(Hyperlink h) {
        this.hyperlinkPlayer2 = h;
    }
    private Hyperlink hyperlinkPlayer3 = new Hyperlink();

    public Hyperlink getHyperlinkPlayer3() {
        return hyperlinkPlayer3;
    }

    public void setHyperlinkPlayer3(Hyperlink h) {
        this.hyperlinkPlayer3 = h;
    }
    private Hyperlink hyperlinkPlayer4 = new Hyperlink();

    public Hyperlink getHyperlinkPlayer4() {
        return hyperlinkPlayer4;
    }

    public void setHyperlinkPlayer4(Hyperlink h) {
        this.hyperlinkPlayer4 = h;
    }
    private Hyperlink hyperlinkPlayer5 = new Hyperlink();

    public Hyperlink getHyperlinkPlayer5() {
        return hyperlinkPlayer5;
    }

    public void setHyperlinkPlayer5(Hyperlink h) {
        this.hyperlinkPlayer5 = h;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Index() {
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
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        getApplicationBean1().setAcceptmoveList(getApplicationBean1().getAcceptmoveList());
        chooseMoveAccept();
        getRoundActive();
        setVisiblePlayersControls(false);
        setDisabledPlayersControls(true);
        avaliablePlayers();
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
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
    public void prerender() {


        //@episodio1 jogador entra no jogo
        String username = (String) getExternalContext().getRequestParameterMap().get("username");
        if (username != null) {
            getSessionBean1().setUsername(username);
        } else if (getSessionBean1().getUsername() == null) {

            getSessionBean1().setUsername(getApplicationBean1().getNextAnonUsername());

        }
        //@episodio2 SimulES disponibiliza as informações do projeto escolhido;
        getApplicationBean1().setProjectChoose(getApplicationBean1().getProjectChoose());
        getApplicationBean1().setModulesProject(getApplicationBean1().getModulesProject());

        getApplicationBean1().setPlayerList(getApplicationBean1().getPlayerList());
        //@episodio3 SimulES disponibiliza as informações de aceitação de movimentos;
        getApplicationBean1().setAcceptmoveList(getApplicationBean1().getAcceptmoveList());
        chooseMoveAccept();
        getPlayerActive();
        getNextPlayer();
        avaliablePlayers();


    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
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

    //eposidio4  SimulES disponibiliza as mensagens trocadas entre os jogadores;
    public String send_action() {


        String comment = (String) getComment().getText();
        String username = getSessionBean1().getUsername();
        getApplicationBean1().addEntry(username, comment);

        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 get1$ApplicationBean1() {
        return (ApplicationBean1) getBean("1$ApplicationBean1");
    }

    public void textFieldUserName_processValueChange(ValueChangeEvent event) {
    }

    /**
     * @return the acceptmoveList
     */
    public List<Acceptmove> getAcceptmoveList() {
        return acceptmoveList;
    }

    /**
     * @param acceptmoveList the acceptmoveList to set
     */
    public void setAcceptmoveList(List<Acceptmove> acceptmoveList) {
        this.acceptmoveList = acceptmoveList;
    }

    public void chooseMoveAccept() {
        AcceptmoveController acceptmoveController = new AcceptmoveController();
        setAcceptmoveList(acceptmoveController.getAcceptmove());
    }

    public String imgPlayer1_action() {

        int idRound = getRoundActive();
        if (idRound == 1) {
            return "case3";
        } else if (idRound == 2) {
            return "case6";
        } else if (idRound == 3) {
            return "case5";
        }

        return null;
    }

    public String imgPlayer2_action() {
        int idRound = getRoundActive();
        if (idRound == 1) {
            return "case3";
        } else if (idRound == 2) {
            return "case6";
        } else if (idRound == 3) {
            return "case5";
        }

        return null;
    }

    public String imgPlayer3_action() {
        int idRound = getRoundActive();
        if (idRound == 1) {
            return "case3";
        } else if (idRound == 2) {
            return "case6";
        } else if (idRound == 3) {
            return "case5";
        }

        return null;
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the nextPlayerName
     */
    public String getNextPlayerName() {
        return nextPlayerName;
    }

    /**
     * @param nextPlayerName the nextPlayerName to set
     */
    public void setNextPlayerName(String nextPlayerName) {
        this.nextPlayerName = nextPlayerName;
    }

    //@episodie obter a descripção da ronda ativa
    public int getRoundActive() {

        linkRoundActive.setText("Play Start Round");

        RoundController roundController = new RoundController();

        Round roundActive = new Round();

        Round actRound = roundController.getActiveRound();

        int idRound = actRound.getRoundId();

        switch (idRound) {
            case 1:
                setNameRound("Play Start Round");
                break;
            case 2:
                setNameRound("Play Actions Round");
                break;
            case 3:
                setNameRound("Play Concepts Round");
                break;
            default:
                setNameRound("Play Start Round");

                break;
        }
        return idRound;
    }

    public String linkRoundActive_action() {
        int idRound = getRoundActive();

        if (idRound == 1) {
            return "case3";
        } else if (idRound == 2) {
            return "case6";
        } else if (idRound == 3) {
            return "case5";
        }

        return null;

    }

    public String imgPlayer4_action() {
        int idRound = getRoundActive();

        if (idRound == 1) {
            return "case3";
        } else if (idRound == 2) {
            return "case6";
        } else if (idRound == 3) {
            return "case5";
        }

        return null;
    }

    public String imgPlayer5_action() {
        int idRound = getRoundActive();

        if (idRound == 1) {
            return "case3";
        } else if (idRound == 2) {
            return "case6";
        } else if (idRound == 3) {
            return "case5";
        }

        return null;
    }

    /**
     * @return the nameRound
     */
    public String getNameRound() {
        return nameRound;
    }

    /**
     * @param nameRound the nameRound to set
     */
    public void setNameRound(String nameRound) {
        this.nameRound = nameRound;
    }

    //@episodie get player active in round active
    public void getPlayerActive() {
        try {
            Move move = null;
            MoveController movecontroller = new MoveController();
            move = movecontroller.getMoveActive();

            Player player = move.getPlayer();

            setPlayerName(player.getNickname());
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("user has not registred yet");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    //episodie get the next player avaliable to play
    public void getNextPlayer() {
        try {
            Move move = null;
            MoveController movecontroller = new MoveController();
            move = movecontroller.getMoveActive();

            Player actPlayer = move.getPlayer();
            Player nextPlayer = null;

            PlayerController playercontroller = new PlayerController();
            nextPlayer = playercontroller.getNextPlayer(actPlayer);

            setNextPlayerName(nextPlayer.getNickname());

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("user has not registred yet");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public void avaliablePlayers() {
        EnvironmentvariablesController enviromentVar = new EnvironmentvariablesController();
        PlayerController playercontroller = new PlayerController();
         playercontroller.createListOrderToPlay();
        Environmentvariables EnviVariable = enviromentVar.getEnvironmentVariable(2);
        if (EnviVariable.getState() == 1) {

            List<Player> playerList = playercontroller.getPlayerOrderById();

            

            Iterator it = playerList.iterator();

            while (it.hasNext()) {
                Player player = (Player) it.next();
                showPlayers(player);

            }

        }
    }

    /**
     * @return the allPlayer
     */
    public List<Player> getAllPlayer() {
        return allPlayer;
    }

    /**
     * @param allPlayer the allPlayer to set
     */
    public void setAllPlayer(List<Player> allPlayer) {
        this.allPlayer = allPlayer;
    }

    /**
     * @return the strPlayer1
     */
    public String getStrPlayer1() {
        return strPlayer1;
    }

    /**
     * @param strPlayer1 the strPlayer1 to set
     */
    public void setStrPlayer1(String strPlayer1) {
        this.strPlayer1 = strPlayer1;
    }

    /**
     * @return the strPlayer2
     */
    public String getStrPlayer2() {
        return strPlayer2;
    }

    /**
     * @param strPlayer2 the strPlayer2 to set
     */
    public void setStrPlayer2(String strPlayer2) {
        this.strPlayer2 = strPlayer2;
    }

    /**
     * @return the strPlayer3
     */
    public String getStrPlayer3() {
        return strPlayer3;
    }

    /**
     * @param strPlayer3 the strPlayer3 to set
     */
    public void setStrPlayer3(String strPlayer3) {
        this.strPlayer3 = strPlayer3;
    }

    /**
     * @return the strPlayer4
     */
    public String getStrPlayer4() {
        return strPlayer4;
    }

    /**
     * @param strPlayer4 the strPlayer4 to set
     */
    public void setStrPlayer4(String strPlayer4) {
        this.strPlayer4 = strPlayer4;
    }

    /**
     * @return the strPlayer5
     */
    public String getStrPlayer5() {
        return strPlayer5;
    }

    /**
     * @param strPlayer5 the strPlayer5 to set
     */
    public void setStrPlayer5(String strPlayer5) {
        this.strPlayer5 = strPlayer5;
    }

    public void showPlayers(Player player) {
        int iOrder = 0;
        try
        {

        if (userIsValid()) {

            iOrder = player.getOrdertoplay();
            String username = getSessionBean1().getUsername();

            switch (iOrder) {
                case 1:
                    imgPlayer1.setVisible(true);
                    player1.setVisible(true);
                    hyperlinkPlayer1.setVisible(true);
                    strPlayer1 = player.getNickname();

                    if (username.equals(strPlayer1)) {
                        grdPlayer1.setBgcolor("#6495ED");

                    }

                    if (strPlayer1.equals(getPlayerName())) {
                        grdPlayer1.setBgcolor("#FF7F50");
                    }

                    if (username.equals(getPlayerName()) && strPlayer1.equals(getPlayerName())) {
                        imgPlayer1.setDisabled(false);
                    }


                    break;
                case 2:
                    imgPlayer2.setVisible(true);
                    player2.setVisible(true);
                    hyperlinkPlayer2.setVisible(true);
                    strPlayer2 = player.getNickname();

                    if (username.equals(strPlayer2)) {
                        grdPlayer2.setBgcolor("#6495ED");
                    }

                    if (strPlayer2.equals(getPlayerName())) {
                        grdPlayer2.setBgcolor("#FF7F50");
                    }
                    if (username.equals(getPlayerName()) && strPlayer2.equals(getPlayerName())) {
                        imgPlayer2.setDisabled(false);
                    }


                    break;
                case 3:
                    imgPlayer3.setVisible(true);
                    player3.setVisible(true);
                    hyperlinkPlayer3.setVisible(true);
                    strPlayer3 = player.getNickname();

                    if (username.equals(strPlayer3)) {

                        grdPlayer3.setBgcolor("#6495ED");

                    }
                    if (strPlayer3.equals(getPlayerName())) {
                        grdPlayer3.setBgcolor("#FF7F50");
                    }
                    if (username.equals(getPlayerName()) && strPlayer3.equals(getPlayerName())) {
                        imgPlayer3.setDisabled(false);
                    }
                    break;
                case 4:
                    imgPlayer4.setVisible(true);
                    player4.setVisible(true);
                    hyperlinkPlayer4.setVisible(true);
                    strPlayer4 = player.getNickname();

                    if (username.equals(strPlayer4)) {
                        grdPlayer4.setBgcolor("#6495ED");
                    }
                    if (strPlayer4.equals(getPlayerName())) {
                        grdPlayer4.setBgcolor("#FF7F50");
                    }
                    if (username.equals(getPlayerName()) && strPlayer4.equals(getPlayerName())) {
                        imgPlayer4.setDisabled(false);
                    }
                    break;
                case 5:
                    imgPlayer5.setVisible(true);
                    player5.setVisible(true);
                    hyperlinkPlayer5.setVisible(true);
                    strPlayer5 = player.getNickname();

                    if (username.equals(strPlayer5)) {
                        grdPlayer5.setBgcolor("#6495ED");
                    }

                    if (strPlayer5.equals(getPlayerName())) {
                        grdPlayer5.setBgcolor("#FF7F50");
                    }
                    if (username.equals(getPlayerName()) && strPlayer5.equals(getPlayerName())) {
                        imgPlayer5.setDisabled(false);
                    }

                    break;
                default:
                    setVisiblePlayersControls(false);
                    break;
            }
        }
         } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("Try again");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        }
    }

    public void setVisiblePlayersControls(boolean value) {
        imgPlayer1.setVisible(value);
        imgPlayer2.setVisible(value);
        imgPlayer3.setVisible(value);
        imgPlayer4.setVisible(value);
        imgPlayer5.setVisible(value);
        player1.setVisible(value);
        player2.setVisible(value);
        player3.setVisible(value);
        player4.setVisible(value);
        player5.setVisible(value);
        hyperlinkPlayer1.setVisible(value);
        hyperlinkPlayer2.setVisible(value);
        hyperlinkPlayer3.setVisible(value);
        hyperlinkPlayer4.setVisible(value);
        hyperlinkPlayer5.setVisible(value);
    }

    public void setDisabledPlayersControls(boolean value) {
        imgPlayer1.setDisabled(value);
        imgPlayer2.setDisabled(value);
        imgPlayer3.setDisabled(value);
        imgPlayer4.setDisabled(value);
        imgPlayer5.setDisabled(value);
    }

    public String playerGoesToPage() {
        String valueReturn = null;
        int idRound = getRoundActive();
        String username = getSessionBean1().getUsername();
        if (getPlayerName().equals(username)) {
            if (idRound == 2) {
                valueReturn = "case4";
            } else if (idRound == 3) {
                valueReturn = "case5";
            }
        }
        return valueReturn;
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
}

