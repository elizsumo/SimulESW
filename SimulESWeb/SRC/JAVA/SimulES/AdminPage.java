package SimulES;

import SimulES.Control.EnvironmentvariablesController;
import SimulES.Control.MoveController;
import SimulES.Model.Sourceofcards;
import com.sun.data.provider.RowKey;
import com.sun.data.provider.impl.CachedRowSetDataProvider;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.DropDown;
import com.sun.rave.web.ui.component.TableColumn;
import com.sun.rave.web.ui.event.TableSelectPhaseListener;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import SimulES.Control.PlayerController;
import SimulES.Control.ProjectController;
import SimulES.Control.RoundController;
import SimulES.Control.SourceofcardsController;
import SimulES.Model.Environmentvariables;
import SimulES.Model.Player;
import javax.faces.convert.IntegerConverter;
import javax.faces.event.ValueChangeEvent;

/**
/**
 * ******************************************************************
Titulo: SDsituations gestão do Jogo
Objetivo: Descrever e disponibilizar as informações para gestionar o jogo.
Contexto: Localização geografica: Web
Localização temporal: Java AdminPage
Precondições: Serviços web disponíveis
Poscondições: Informações gerais do jogo disponíveis Atores: jogador, SimulES
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira

 *********************************************************************
 *
 * @version AdminPage.java
 * @version Created on Sep 3, 2009, 3:41:41 PM
 * @author Elizabeth
 */
public class AdminPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        sourceofcardsDataProvider.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.sourceofcardsRowSet}"));
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    private List<Sourceofcards> sourceofcardsList = null;
    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }
    private CachedRowSetDataProvider sourceofcardsDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getSourceofcardsDataProvider() {
        return sourceofcardsDataProvider;
    }

    public void setSourceofcardsDataProvider(CachedRowSetDataProvider crsdp) {
        this.sourceofcardsDataProvider = crsdp;
    }

    public AdminPage() {
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
            log("AdminPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>

        //@episodio1 obter as fontes das cartas

        //getApplicationBean1().getSourceOfCards();
        getApplicationBean1().setSourceofcardsList(getApplicationBean1().getSourceofcardsList());

    //getApplicationBean1().setPlayerList(getApplicationBean1().getPlayerList());
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
        //@episodio1 obter as fontes das cartas no preprocesso
        getSourceAvaliable();
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
        sourceofcardsDataProvider.close();
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

    //@episodio2 fecha a entrada de jogoadores
    public String btnCloseEntryPlayer_action() {

        boolean closeEntry = getApplicationBean1().isCloseEntryPlayer();
        if (!closeEntry) {
            PlayerController playerController = new PlayerController();
            MoveController moveController = new MoveController();
            RoundController roundController = new RoundController();
            ProjectController projectcontroller = new ProjectController();
            EnvironmentvariablesController enviromentVar = new EnvironmentvariablesController();
            Environmentvariables EnviVariable = enviromentVar.getEnvironmentVariable(2);
            enviromentVar.updateEnvironmentVariables(EnviVariable, 1);

            projectcontroller.restartProjects();
            roundController.restartRounds();
            moveController.restartMove();
            Player player = playerController.getMinIdPlayer();
            roundController.enableNextRound(1);
            moveController.firstMoveToStartGame();
            moveController.updatePlayerByMove(player, 1);
            getApplicationBean1().setCloseEntryPlayer(true);
            playerController.createListOrderToPlay();
            
            FacesMessage fm = new FacesMessage("Close entry player");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage("Entry of players is closed");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

        return null;
    }
    private TableSelectPhaseListener tablePhaseListener =
            new TableSelectPhaseListener();

    //evento setSelected da tabela
    public void setSelected(Object object) {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }

    //evento getSelected da tabela
    public Object getSelected() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.getSelected(rowKey);
    }

    //obter o elemento selecionado na tabela
    public Object getSelectedValue() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return (rowKey != null) ? rowKey.getRowId() : null;
    }

    //obter o estado do elemento selecionado na tabela
    public boolean getSelectedState() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.isSelected(rowKey);
    }



    //@episodio4 reiniciar a sesão do jogo
    public String btnRestartSession_action() {

        PlayStartRoundPage playstarroundpage = new PlayStartRoundPage();
        PlayActionsRoundPage playsactiosroundpage = new PlayActionsRoundPage();

        //todas as variaveis de sesão são inicializadas
        getApplicationBean1().setProjectChoose(null);
        getApplicationBean1().setModulesProject(null);
        getApplicationBean1().setProjectGame(false);
        getApplicationBean1().setPlayerList(null);
        getApplicationBean1().setCloseEntryPlayer(false);
        getApplicationBean1().setAcceptmoveList(null);
        getApplicationBean1().entryList.clear();

        getApplicationBean1().setRound(1);
        getApplicationBean1().setSoftEngChoosen(false);

        //inicializamos o valor do dado na pagina de jogada de inicio
        playstarroundpage.setDiceValue(0);

        //inicializamos os valores apresentados nas tabelas
        playsactiosroundpage.setCardsbyPlayer(null);
        playsactiosroundpage.setSoftEngByPlayer(null);

        //criamos a mensagem a ser apresentada no main sobre a inicialização do jogo
        String username = getSessionBean1().getUsername();
        String message = "A new session has been established";

        getApplicationBean1().addEntry(username, message);

        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, fm);

        return null;
    }

    public String btnNewRollDice_action() {
        reStartRollingDice();
        return null;
    }

    public void reStartRollingDice() {

        PlayerController playerController = new PlayerController();
        MoveController moveController = new MoveController();
        PlayStartRoundPage playstarroundpage = new PlayStartRoundPage();

        moveController.restartMove();
        moveController.firstMoveToStartGame();
        Player player = playerController.getMinIdPlayer();
        moveController.updatePlayerByMove(player, 1);

        playerController.restartRollDice();
        playstarroundpage.setDiceValue(0);

        String username = getSessionBean1().getUsername();
        String message = "The Dice must be rolled again";

        getApplicationBean1().addEntry(username, message);

    }

    /**
     * @return the sourceofcardsList
     */
    public List<Sourceofcards> getSourceofcardsList() {
        return sourceofcardsList;
    }

    /**
     * @param sourceofcardsList the sourceofcardsList to set
     */
    public void setSourceofcardsList(List<Sourceofcards> sourceofcardsList) {
        this.sourceofcardsList = sourceofcardsList;
    }

    public void getSourceAvaliable() {
        SourceofcardsController sourceofcardsController = new SourceofcardsController();
        setSourceofcardsList((List<Sourceofcards>) sourceofcardsController.getSourceofcards());

    }

    public void dropDownSourceOfCards_processValueChange(ValueChangeEvent event) {
    }
}

