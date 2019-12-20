package SimulES;

import SimulES.Control.CardController;

import SimulES.Model.Card;
import SimulES.Control.PlayerCardController;
import SimulES.Control.PlayerController;
import SimulES.Control.PlayerSoftengineerController;
import SimulES.Control.PlayersproblemsController;
import SimulES.Model.Project;
import SimulES.Control.ProjectController;
import SimulES.Control.SoftEngineerController;
import SimulES.Model.Playersproblems;
import SimulES.Model.Softengineer;
import com.sun.data.provider.impl.CachedRowSetDataProvider;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.sql.rowset.CachedRowSetXImpl;

import java.util.List;
import javax.faces.FacesException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version SessionBean1.java
 * @version Created on Jun 15, 2009, 10:13:18 PM
 * @author Elizabeth
 */
public class SessionBean1 extends AbstractSessionBean {

    private List<Card> allCard = null;

    private List<Project> projectList = null;
    private List<Softengineer> softengineerList = null;
    private List<Softengineer> softEngListbyPlayer = null;
    private List<Card> cardsbyPlayer = null;
    private List<Card> cardsProblemsbyPlayer = null;
    private List<Card> cardsConceptbyPlayer = null;
    private List<Card> TreatmentProblemsbyPlayer = null;
    private List<Playersproblems> playersproblemsList = null;
    private Card cardproblem = null;
    private Playersproblems playersproblems = null;
    private int RowIdProblem = 0;
    private int idPlayer;
   
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        
        playerRowSet.setDataSourceName("java:comp/env/jdbc/simules_MySQL");
        playerRowSet.setCommand("SELECT * FROM player");
        playerRowSet.setTableName("player");
        cardtypeRowSet.setDataSourceName("java:comp/env/jdbc/simules_MySQL");
        cardtypeRowSet.setCommand("SELECT ALL cardtype.cardtype_id, cardtype.description  FROM cardtype");
        cardtypeRowSet.setTableName("cardtype");
        sourceofcardsRowSet.setDataSourceName("java:comp/env/jdbc/simules_MySQL");
        sourceofcardsRowSet.setCommand("SELECT ALL sourceofcards.sourceofcards_id, sourceofcards.description  FROM sourceofcards");
        sourceofcardsRowSet.setTableName("sourceofcards");
        cardRowSet1.setDataSourceName("java:comp/env/jdbc/simules_MySQL");
        cardRowSet1.setCommand("SELECT ALL card.card_id, card.name, card.reference, card.description, card.cardtype_id, card.sourceofcards_id, card.rule, card.referencelink, card.category  FROM card WHERE card.sourceofcards_id = ?");
        cardRowSet1.setTableName("card");
        maxCardDataProvider.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.maxCardRowSet}"));
        maxCardRowSet.setDataSourceName("java:comp/env/jdbc/simules_MySQL");
        maxCardRowSet.setCommand("SELECT MAX(card.card_id)+1 AS maxcard FROM card");
        maxCardRowSet.setTableName("card");
        playerRowSet1.setDataSourceName("java:comp/env/jdbc/Simules_MySQL");
        playerRowSet1.setCommand("SELECT * FROM player");
        playerRowSet1.setTableName("player");

    }
    private CachedRowSetXImpl usuariosRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getUsuariosRowSet() {
        return usuariosRowSet;
    }

    public void setUsuariosRowSet(CachedRowSetXImpl crsxi) {
        this.usuariosRowSet = crsxi;
    }
    private CachedRowSetXImpl projectRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getProjectRowSet() {
        return projectRowSet;
    }

    public void setProjectRowSet(CachedRowSetXImpl crsxi) {
        this.projectRowSet = crsxi;
    }
    private CachedRowSetXImpl playerRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getPlayerRowSet() {
        return playerRowSet;
    }

    public void setPlayerRowSet(CachedRowSetXImpl crsxi) {
        this.playerRowSet = crsxi;
    }
    private CachedRowSetXImpl cardRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getCardRowSet() {
        return cardRowSet;
    }

    public void setCardRowSet(CachedRowSetXImpl crsxi) {
        this.cardRowSet = crsxi;
    }
    private CachedRowSetXImpl cardtypeRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getCardtypeRowSet() {
        return cardtypeRowSet;
    }

    public void setCardtypeRowSet(CachedRowSetXImpl crsxi) {
        this.cardtypeRowSet = crsxi;
    }
    private CachedRowSetXImpl sourceofcardsRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getSourceofcardsRowSet() {
        return sourceofcardsRowSet;
    }

    public void setSourceofcardsRowSet(CachedRowSetXImpl crsxi) {
        this.sourceofcardsRowSet = crsxi;
    }
    private CachedRowSetXImpl cachedRowSetXImpl1 = new CachedRowSetXImpl();

    public CachedRowSetXImpl getCachedRowSetXImpl1() {
        return cachedRowSetXImpl1;
    }

    public void setCachedRowSetXImpl1(CachedRowSetXImpl crsxi) {
        this.cachedRowSetXImpl1 = crsxi;
    }
    private CachedRowSetXImpl cardRowSet1 = new CachedRowSetXImpl();

    public CachedRowSetXImpl getCardRowSet1() {
        return cardRowSet1;
    }

    public void setCardRowSet1(CachedRowSetXImpl crsxi) {
        this.cardRowSet1 = crsxi;
    }
    private CachedRowSetDataProvider maxCardDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getMaxCardDataProvider() {
        return maxCardDataProvider;
    }

    public void setMaxCardDataProvider(CachedRowSetDataProvider crsdp) {
        this.maxCardDataProvider = crsdp;
    }
    private CachedRowSetXImpl maxCardRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getMaxCardRowSet() {
        return maxCardRowSet;
    }

    public void setMaxCardRowSet(CachedRowSetXImpl crsxi) {
        this.maxCardRowSet = crsxi;
    }
    private CachedRowSetXImpl playerRowSet1 = new CachedRowSetXImpl();

    public CachedRowSetXImpl getPlayerRowSet1() {
        return playerRowSet1;
    }

    public void setPlayerRowSet1(CachedRowSetXImpl crsxi) {
        this.playerRowSet1 = crsxi;
    }
    // </editor-fold>

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SessionBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
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
            log("SessionBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

     //   getcardsByPlayer();
        getAllCards();


    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
        maxCardDataProvider.close();
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    private String username;

    public synchronized String getUsername() {
        return username;
    }

    public synchronized void setUsername(String username) {
        this.username = username;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 get1$ApplicationBean1() {
        return (ApplicationBean1) getBean("1$ApplicationBean1");
    }

    /**
     * @return the projectList
     */
    public List<Project> getProjectList() {
        return projectList;
    }

    /**
     * @param projectList the projectList to set
     */
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }



    /**
     * @return the softengineerList
     */
    public List<Softengineer> getSoftengineerList() {
        return softengineerList;
    }

    /**
     * @param softengineerList the softengineerList to set
     */
    public void setSoftengineerList(List<Softengineer> softengineerList) {
        this.softengineerList = softengineerList;
    }

    
     public void getAllCards() {
         CardController cardController = new CardController();
         allCard = cardController.getCards();

    }



    /**
     * @return the idPlayer
     */
    public int getIdPlayer() {

        return idPlayer;
    }

    /**
     * @param idPlayer the idPlayer to set
     */
    public void setIdPlayer(int idPlayer) {


        this.idPlayer = idPlayer;

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

    /**
     * @return the cardsProblemsbyPlayer
     */
    public List<Card> getCardsProblemsbyPlayer() {
        return cardsProblemsbyPlayer;
    }

    /**
     * @param cardsProblemsbyPlayer the cardsProblemsbyPlayer to set
     */
    public void setCardsProblemsbyPlayer(List<Card> cardsProblemsbyPlayer) {
        this.cardsProblemsbyPlayer = cardsProblemsbyPlayer;
    }

    /**
     * @return the softEngListbyPlayer
     */
    public List<Softengineer> getSoftEngListbyPlayer() {
        return softEngListbyPlayer;
    }

    /**
     * @param softEngListbyPlayer the softEngListbyPlayer to set
     */
    public void setSoftEngListbyPlayer(List<Softengineer> softEngListbyPlayer) {
        this.softEngListbyPlayer = softEngListbyPlayer;
    }

    /**
     * @return the TreatmentProblemsbyPlayer
     */
    public List<Card> getTreatmentProblemsbyPlayer() {
        return TreatmentProblemsbyPlayer;
    }

    /**
     * @param TreatmentProblemsbyPlayer the TreatmentProblemsbyPlayer to set
     */
    public void setTreatmentProblemsbyPlayer(List<Card> TreatmentProblemsbyPlayer) {
        this.TreatmentProblemsbyPlayer = TreatmentProblemsbyPlayer;
    }

    /**
     * @return the cardsConceptbyPlayer
     */
    public List<Card> getCardsConceptbyPlayer() {
        return cardsConceptbyPlayer;
    }

    /**
     * @param cardsConceptbyPlayer the cardsConceptbyPlayer to set
     */
    public void setCardsConceptbyPlayer(List<Card> cardsConceptbyPlayer) {
        this.cardsConceptbyPlayer = cardsConceptbyPlayer;
    }

    /**
     * @return the cardproblem
     */
    public Card getCardproblem() {
        return cardproblem;
    }

    /**
     * @param cardproblem the cardproblem to set
     */
    public void setCardproblem(Card cardproblem) {
        this.cardproblem = cardproblem;
    }

    /**
     * @return the RowIdProblem
     */
    public int getRowIdProblem() {
        return RowIdProblem;
    }

    /**
     * @param RowIdProblem the RowIdProblem to set
     */
    public void setRowIdProblem(int RowIdProblem) {
        this.RowIdProblem = RowIdProblem;
    }

    /**
     * @return the playersproblemsList
     */
    public List<Playersproblems> getPlayersproblemsList() {
        return playersproblemsList;
    }

    /**
     * @param playersproblemsList the playersproblemsList to set
     */
    public void setPlayersproblemsList(List<Playersproblems> playersproblemsList) {
        this.playersproblemsList = playersproblemsList;
    }

    /**
     * @return the playersproblems
     */
    public Playersproblems getPlayersproblems() {
        return playersproblems;
    }

    /**
     * @param playersproblems the playersproblems to set
     */
    public void setPlayersproblems(Playersproblems playersproblems) {
        this.playersproblems = playersproblems;
    }



     public void getSoftEngByPlayer() {
        PlayerSoftengineerController playerSoftEng = new PlayerSoftengineerController();
        softEngListbyPlayer = playerSoftEng.getSoftEngByPlayer(getIdPlayer());

    }

    /**
     * @return the allCard
     */
    public List<Card> getAllCard() {
        return allCard;
    }

    /**
     * @param allCard the allCard to set
     */
    public void setAllCard(List<Card> allCard) {
        this.allCard = allCard;
    }

   




}
