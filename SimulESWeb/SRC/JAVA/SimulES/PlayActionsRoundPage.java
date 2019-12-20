package SimulES;

import SimulES.Model.Card;
import SimulES.Control.CardController;
import SimulES.Control.MoveController;
import SimulES.Model.Player;
import SimulES.Control.PlayerCardController;
import SimulES.Control.PlayerController;
import SimulES.Control.PlayerSoftengineerController;
import SimulES.Control.RoundController;
import SimulES.Model.Playercard;
import SimulES.Control.SoftEngineerController;
import SimulES.Model.Move;
import SimulES.Model.Round;
import SimulES.Model.Softengineer;
import SimulES.Model.Sourceofcards;
import SimulES.Util.JSFUtils;
import SimulES.Util.ManageMessages;
import com.sun.data.provider.impl.CachedRowSetDataProvider;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.Hyperlink;
import com.sun.rave.web.ui.component.StaticText;
import com.sun.rave.web.ui.component.Tab;
import com.sun.rave.web.ui.component.Table;
import com.sun.rave.web.ui.component.TextField;
import com.sun.rave.web.ui.model.DefaultTableDataProvider;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

/**
 *
 * * ******************************************************************
Titulo:	 joga rodada de ações
Objetivo:	Descrever as regras da rodada de ações.
Contexto:	Ubicação: Java Web IndividualBoardPage e PlayDiceRound
informações do projeto na pagina principal do jogo.
A ordem das jogadas dos jogadores já foi definida dentro do jogo.
Atores:	jogador
Recursos:	dado, cartas, informações do projeto, pagina tabuleiro individual e pagina principal do jogo.
Exceção:
Episódios:	1- jogador usa seus engenheiros de software em CONSTRÓI artefato ou INSPECIONA artefato ou CORRIGE artefato ou joga lançamento do dado
Restrição: os três primeiros cenários serão executados de acordo com a habilidade de cada engenheiro de software.
Restrição: Habilidades e o custo dessas ações podem ser afetados por cartas de conceitos ou cartas de problemas.
Restrição: Se jogador não usou engenheiros de software e nem jogou o dado, então integra artefatos em um módulo. 
 *********************************************************************
 *
 * @version PlayActionPage.java
 * @version Created on Jul 4, 2009, 10:14:13 PM
 * @author Elizabeth
 */
public class PlayActionsRoundPage extends AbstractPageBean {

    private int valueDice;
    boolean BuySoftEng = false;
    private String user = null;
    public int value = 5;
    public List<Card> cardsbyPlayer = null;
    public List<Softengineer> softEngByPlayer = null;
    public String ChainOfIdSoftEng = null;
    private String chainOfIdCard = null;
    private int totalEng = 0;
    private int numCard = 0;
    private boolean moveDone = false;


    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        estudiantesDataProvider.setCachedRowSet(null);
    }
    private CachedRowSetDataProvider estudiantesDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getEstudiantesDataProvider() {
        return estudiantesDataProvider;
    }

    public void setEstudiantesDataProvider(CachedRowSetDataProvider crsdp) {
        this.estudiantesDataProvider = crsdp;
    }
    private StaticText resultDice = new StaticText();

    public StaticText getResultDice() {
        return resultDice;
    }

    public void setResultDice(StaticText st) {
        this.resultDice = st;
    }
    private Button buyPlayingCard = new Button();

    public Button getBuyPlayingCard() {
        return buyPlayingCard;
    }

    public void setBuyPlayingCard(Button b) {
        this.buyPlayingCard = b;
    }
    private Button buySoftEngineer = new Button();

    public Button getBuySoftEngineer() {
        return buySoftEngineer;
    }

    public void setBuySoftEngineer(Button b) {
        this.buySoftEngineer = b;
    }
    private Table tblCard = new Table();

    public Table getTblCard() {
        return tblCard;
    }

    public void setTblCard(Table t) {
        this.tblCard = t;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PlayActionsRoundPage() {
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
            log("PlayActionPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>

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

        //@episodio1 jogador entra no jogo
        String username = (String) getExternalContext().getRequestParameterMap().get("username");
        if (username != null) {

            getSessionBean1().setUsername(username);

        }


        if (getApplicationBean1().getRound() == 1) {
            setSoftEngByPlayer(null);
            setCardsbyPlayer(null);
        } else {
            softEngBAtMoment(ChainOfIdSoftEng);
            cardsAtMoment(chainOfIdCard);
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public int generateRandom() {
        int n = 0;
        do {
            n = (int) Math.round(Math.random() * 10);
        } while (n > 6 || n < 1);

        return n;
    }

    /**
     *
     * * ******************************************************************
    Titulo:	 joga lançamento do dado
    Objetivo:	Descrever as regras do lançamento do dado.
    Contexto:	Ubicação: Java Web IndividualBoardPage e PlayDiceRound
    Pré-condição: jogada de ações deve ter sido ativada.
    informações do projeto na pagina principal do jogo.
    A ordem das jogadas dos jogadores já foi definida dentro do jogo.
    Atores:	jogador
    Recursos:	dado, cartas, informações do projeto, pagina tabuleiro individual e pagina principal do jogo.
    Exceção:
    Episódios:
    1- jogador lança o dado.
    2- Se dado igual a 1,ou 2 ou 3, então jogador pega 1, 2 ou 3 cartas do monte de problemas e conceitos. Restrição: jogador não pode pegar cartas do monte de engenheiros de software.
    3- Se dado igual a 4 ou 5 ou 6, então jogador pega 3 cartas do monte de problemas e conceitos e x cartas do monte de engenheiro de software, onde x é o valor do dado menos 3.
     *********************************************************************
     **/
    public String trhowDice_action() {

        String username = getSessionBean1().getUsername();
        if (userIsValid()) {
            moveDone = false;

            MoveController mController = new MoveController();
            Move move = mController.getMove(4);
            username = getSessionBean1().getUsername();

            if (move.getState().equals("A")) {


                if (move.getPlayer().getNickname().equals(username)) {

                    //generamos o valor do dado aleatoriamente
                    valueDice = generateRandom();


                    //é apresentado o valor a o jogador
                    resultDice.setText("Your Result Dice Is : " + valueDice);

                    String result = (String) resultDice.getText();
                    getApplicationBean1().addEntry(username, result);

//                    //habilitamos o seguinte jogador
//                    avaliableNextPlayer();

                    allowActions(valueDice);

                    //é apresentada em qual ronda vai o jogador
                    FacesMessage fm = new FacesMessage("This is your round number: " + getApplicationBean1().getRound());
                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, fm);

                    getApplicationBean1().sumRound();
                } else {
                    ManageMessages.addMessage("Player who should play is: " + move.getPlayer().getNickname());
                }
            } else if (move.getState().equals("E")) {
                ManageMessages.addMessage("The move has already been executed by all players");
            } else {
                FacesMessage fm = new FacesMessage("This move is invalid");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }
        } else {
            FacesMessage fm = new FacesMessage("user is invalid");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

        return null;
    }

    //@episodio habilita ou não a opçao de comprar cartas de eng de software
    private void allowActions(int resultDice) {

        totalEng = 0;
        numCard = 0;
        this.setCardsbyPlayer(null);
        this.setSoftEngByPlayer(null);
        this.ChainOfIdSoftEng = null;
        this.chainOfIdCard = null;

        //quando o resultado do dado é maior de 3 o jogador pode comprar cartas de eng de software
        if (resultDice > 3) {

            FacesMessage fm = new FacesMessage("You can buy Problem and Concept Cards, moreover Software Engineer Cards");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);

            totalEng = resultDice - 3;
            numCard = 3;

            BuySoftEng = true;
        } else {

            numCard = resultDice;

            FacesMessage fm = new FacesMessage("You can only buy Problem and Concept Cards");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

    }

    //@Episodio o jogador compra cartas conceito e problema
    public String buyPlayingCard_action() {

        try {
            String username = getSessionBean1().getUsername();
            if (userIsValid()) {

                PlayerController playerhelper = new PlayerController();
                Player player = playerhelper.getPlayer(username);

                if (buyCard(numCard, player)) {

                    if (valueDice > 3) {

                        FacesMessage fm = new FacesMessage("You have bought Problem and Concept Cards, next you will buy your Software Engineer Cards");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);



                    } else {

                        FacesMessage fm = new FacesMessage("You have bought Problem and Concept Cards, you've made your move, next player...");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                        getApplicationBean1().addEntry(username, "have made your move, next player");
                        // habilitamos o seguinte jogador
                        avaliableNextPlayer();
                        moveDone = true;

                    }

                    numCard = 0;
                    valueDice = 0;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }

    //@Episodio o jogador carta engenheiro de software
    public String buySoftEngineer_action() {

        if (totalEng > 0) {

            int playerId = 0;
            setChainOfIdSoftEng(null);
            String username = getSessionBean1().getUsername();
            if (userIsValid()) {

                if (BuySoftEng) {

                    PlayerController playerhelper = new PlayerController();

                    playerId = playerhelper.getPlayerId(username);

                    JSFUtils utils = new JSFUtils();
                    SoftEngineerController softEngHelper = new SoftEngineerController();

                    int softId = 0;
                    int i = 0;
                    int limit = softEngHelper.getSoftEngineer().size();
                    int scale = 100;
                    try {
                        while (i < totalEng) {

                            try {
                                softId = utils.generateRandom(limit, scale);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                FacesMessage fm = new FacesMessage(ex.toString());
                                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                                FacesContext.getCurrentInstance().addMessage(null, fm);
                            }
                            if (softEngHelper.getSoftEngineerFree(softId)) {
                                if (createPlayerSoftEngRel(playerId, softId)) {

                                    if (i == 0) {
                                        setChainOfIdSoftEng(Integer.toString(softId));
                                    } else {
                                        setChainOfIdSoftEng(getChainOfIdSoftEng() + "," + Integer.toString(softId));
                                    }

                                    i = i + 1;
                                    softId = 0;

                                }
                            } else {
                                softId = 0;
                            }
                        }

                        totalEng = 0;

                        FacesMessage fm = new FacesMessage("You have bought your Software Engineer Cards, you've made your move, next player...");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                        getApplicationBean1().addEntry(username, "have made your move, next player");
                        moveDone = true;
                        avaliableNextPlayer();


                    } catch (Exception ex) {
                        ex.printStackTrace();
                        FacesMessage fm = new FacesMessage(ex.toString());
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    }
                } else {
                    FacesMessage fm = new FacesMessage("You can not buy Software Engineer Cards");
                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                }
            }

            softEngBAtMoment(getChainOfIdSoftEng());
        } else {
            FacesMessage fm = new FacesMessage("You can not buy Software Engineer Cards");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }


        return null;

    }
    //obter os engenheiros de software compranos no momento

    public void softEngBAtMoment(String chain) {
        PlayerSoftengineerController playerSoftEngCont = new PlayerSoftengineerController();
        setSoftEngByPlayer(playerSoftEngCont.getEngineersReserved(chain));
        chain = null;
    }

    //@episodio cria na base de dados a relação entre o eng de software e o jogador
    public boolean createPlayerSoftEngRel(int playerId, int softEngId) {

        boolean valueCreate = false;

        try {

            PlayerSoftengineerController playerSoftEngCont = new PlayerSoftengineerController();

            valueCreate = (playerSoftEngCont.addPlayerSoftengineer(playerId, softEngId));


        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

        return valueCreate;
    }

    //@episodio reserva na base de dados as cartas conceito e problema para o jogador
    public boolean buyCard(int totalCard, Player player) {

        if (totalCard > 0) {

            int cardByRound = totalCard;
            boolean trans = true;
            int i = 0;
            setChainOfIdCard(null);
            //variavel onde vai ficar o ID da carta
            int idCard = 0;

            //o material de aopoio neste
            int sourceCardId = getApplicationBean1().getSourcePlayerCardsId();
            //se o material de apoio ser 0 ou seja nao foi escolhido usamos o material de apoio por default
            if (sourceCardId == 0) {
                sourceCardId = 1;
            }

            while (i < cardByRound) {
                try {
                    List<Card> cardList = null;

                    CardController cardHelper = new CardController();

                    if (sourceCardId > 0) {
                        //obter lista de cartas disponiveis conforme o tipo de material de apoio
                        cardList = cardHelper.getCardsFree(sourceCardId);

                        int index = new Random().nextInt(cardList.size());

                        if (index > 0) {


                            JSFUtils utils = new JSFUtils();

                            try {
                                PlayerCardController playercard = new PlayerCardController();

                                boolean flatIdGerated = true;

                                do {
                                    //gera um valor aleatorio que tem como limite a quantidade de cartas conceito e problema
                                    idCard = cardList.get(index).getCardId();

                                    //valida que o ID não tenha sido escolhido nesta rodada
                                    if (!utils.goOverString(chainOfIdCard, idCard)) {
                                        flatIdGerated = false;
                                    }
                                } while (flatIdGerated);

                            } catch (Exception ex) {
                                ex.printStackTrace();
                                FacesMessage fm = new FacesMessage("Create random");
                                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                                FacesContext.getCurrentInstance().addMessage(null, fm);
                            }

                            PlayerCardController playercardcontroller = new PlayerCardController();
                            //valida que o numero gerado aleatoriamente esteja na lista de cartas e que esteja disponivel
                            if (!playercardcontroller.existCard(idCard)) {

                                //obtemos o objeto carta que corresponde com esse ID
                                CardController cardcontroller = new CardController();
                                Card card = cardcontroller.getCardByID(idCard);

                                //validamos novamente que ele nao este vazio
                                if (!card.toString().isEmpty()) {

                                    //criamos a relaçao entre a carta e o jogador
                                    if (createPlayerCardRel(player, card)) {
                                        //incrementamos o contador para passar à seguinte carta

                                        if (i == 0) {
                                            setChainOfIdCard(Integer.toString(idCard));
                                        } else {
                                            setChainOfIdCard(getChainOfIdCard() + "," + Integer.toString(idCard));
                                        }
                                        i = i + 1;
                                        //inicialimos a variavel onde vai ficar o ID da carta
                                        idCard = 0;
                                    }
                                }
                            }

                        } else {

                            i = totalCard + 1;
                            //não se tem mais cartas disponiveis
                            FacesMessage fm = new FacesMessage("There are not cards enought in the chose source");
                            fm.setSeverity(FacesMessage.SEVERITY_INFO);
                            FacesContext.getCurrentInstance().addMessage(null, fm);
                        }
                    } else {
                        //quando uma fonte de cartas ainda não foi escolhido
                        FacesMessage fm = new FacesMessage("The source cards hasn't chosen");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    }
                } catch (Exception ex) {
                    //erro da bd
                    trans = false;
                    ex.printStackTrace();
                    FacesMessage fm = new FacesMessage(ex.toString());
                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, fm);

                }
            }

            FacesMessage fm = new FacesMessage("You win the next Cards: " + getChainOfIdCard());
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);


            cardsAtMoment(getChainOfIdCard());
            return trans;

        }
        {
            return false;
        }


    }

    //obter as cartas compradas no momento
    public void cardsAtMoment(String chain) {
        CardController cardController = new CardController();
        setCardsbyPlayer(cardController.getCardBought(chain));
        chain = null;
    }

    //@episodio cria na base de dados a relação entre o jogador e as cartas conceito e problema
    public boolean createPlayerCardRel(Player player, Card card) {

        PlayerCardController playerCardHelper = new PlayerCardController();

        boolean add = playerCardHelper.addPlayerCard(player, card);

        return add;
    }

    public String imageGoActions_action() {
        setUser(getSessionBean1().getUsername());
        // TODO: Replace with your code
        return "case1";
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the cardsbyPlayer
     */
    public List<Card> getCardsbyPlayer() {
        return cardsbyPlayer;
    }

    /**
     * @param cardsbyPlayer the cardsbyPlayer to set
     */
    public void setCardsbyPlayer(List<Card> cardsbyPlayer) {
        this.cardsbyPlayer = cardsbyPlayer;
    }

    public String tabCard_action() {
        // TODO: Replace with your code
        return null;
    }

    /**
     * @return the softEngByPlayer
     */
    public List<Softengineer> getSoftEngByPlayer() {
        return softEngByPlayer;
    }

    /**
     * @param softEngByPlayer the softEngByPlayer to set
     */
    public void setSoftEngByPlayer(List<Softengineer> softEngByPlayer) {
        this.softEngByPlayer = softEngByPlayer;
    }

    //@episodio validamos a sessao do usuario
    public boolean userIsValid() {
        boolean isValid = true;
        String username = null;
        PlayerController playerController = new PlayerController();

        username = getSessionBean1().getUsername();
        try {
            if (username.isEmpty() || username.equals("")) {
                isValid = false;
            } else if (!playerController.playerExist(username)) {
                isValid = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("user is invalid");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            isValid = false;

        }
        return isValid;

    }

    /**
     * @return the ChainOfIdSoftEng
     */
    public String getChainOfIdSoftEng() {
        return ChainOfIdSoftEng;
    }

    /**
     * @param ChainOfIdSoftEng the ChainOfIdSoftEng to set
     */
    public void setChainOfIdSoftEng(String ChainOfIdSoftEng) {
        this.ChainOfIdSoftEng = ChainOfIdSoftEng;
    }

    /**
     * @return the chainOfIdCard
     */
    public String getChainOfIdCard() {
        return chainOfIdCard;
    }

    /**
     * @param chainOfIdCard the chainOfIdCard to set
     */
    public void setChainOfIdCard(String chainOfIdCard) {
        this.chainOfIdCard = chainOfIdCard;
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

    //@episodio pasa a seguinte ronda
    public void nextRoundNextPlayer() {
        MoveController moveController = new MoveController();
        RoundController roundController = new RoundController();
        moveController.closeMove(4);
        moveController.enableNextMove(5);
        roundController.closeRound(2);
        roundController.enableNextRound(3);
        moveController.enableMinPlayerToMove(5);
    }

    //@episodio pasa ao seguinte jogador
    public void nextPlayer() {
        MoveController moveController = new MoveController();
        moveController.updateNextPlayerToMove();
    }

    //depois do lançamento do dado, atualizamos o seguinte jogador.
    public void avaliableNextPlayer() {
        String username = getSessionBean1().getUsername();

        PlayerController playerControler = new PlayerController();
        Player playerMax = playerControler.getMaxIdPlayer();
        if (playerMax.getNickname().equals(username)) {
            nextRoundNextPlayer();
        } else {
            nextPlayer();
        }

    }

    public String btnSubmit_action() {
        if (moveDone == true) {
            return "case4";
        } else {
            FacesMessage fm = new FacesMessage("You need to click on icons to buy your cards");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }
}

