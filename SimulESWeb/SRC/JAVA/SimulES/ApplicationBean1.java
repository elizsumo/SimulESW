
package SimulES;

import SimulES.Control.AcceptmoveController;
import SimulES.Control.ModulesProjectController;
import SimulES.Control.PlayerCardController;
import SimulES.Control.PlayerController;
import SimulES.Control.PlayersproblemsController;
import SimulES.Control.ProjectController;
import SimulES.Control.SourceofcardsController;
import SimulES.Model.Acceptmove;
import SimulES.Model.Card;
import SimulES.Model.Modulesproject;
import SimulES.Model.Player;
import SimulES.Model.Project;
import SimulES.Model.Sourceofcards;
import com.sun.rave.web.ui.appbase.AbstractApplicationBean;
import com.sun.sql.rowset.CachedRowSetXImpl;
import java.util.LinkedList;
import java.util.List;
import javax.faces.FacesException;
import javax.swing.JTable;

/**
 * <p>Application scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available to all users
 *  and pages in the application.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version ApplicationBean1.java
 * @version Created on Jun 15, 2009, 10:13:17 PM
 * @author Elizabeth
 */
public class ApplicationBean1 extends AbstractApplicationBean {

    private boolean projectGame = false;
    private boolean closeEntryPlayer = false;
    private List<Player> playerList = null;
    private boolean starGame = false;
    private List<Project> projectChoose = null;
    private List<Modulesproject> modulesProject = null;
    private List<Card> TreatmentProblemsbyPlayer = null;
    private List<Sourceofcards> sourceofcardsList = null;
    private List<Acceptmove> acceptmoveList = null;
    private int moveId=0;
    private int round = 1;
    private boolean softEngChoosen=false;
    private int sourcePlayerCardsId=0;
   
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        cardRowSet.setDataSourceName("java:comp/env/jdbc/simules_MySQL");
        cardRowSet.setCommand("SELECT * FROM card");
        cardRowSet.setTableName("card");
    }
    private CachedRowSetXImpl cardRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getCardRowSet() {
        return cardRowSet;
    }

    public void setCardRowSet(CachedRowSetXImpl crsxi) {
        this.cardRowSet = crsxi;
    }
    // </editor-fold>

    /**
     * <p>Construct a new application data bean instance.</p>
     */
    public ApplicationBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * application scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * application scope.</p>
     * 
     * <p>You may customize this method to initialize and cache application wide
     * data values (such as the lists of valid options for dropdown list
     * components), or to allocate resources that are required for the
     * lifetime of the application.</p>
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
            log("ApplicationBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        getAllPalyer();
        getAllConfigurationProject();
        getSourceOfCards();
        //getAcceptmoveList();
        //chooseMoveAccept();
//        getAllMove();
        
    }

    /**
     * <p>This method is called when this bean is removed from
     * application scope.  Typically, this occurs as a result of
     * the application being shut down by its owning container.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return an appropriate character encoding based on the
     * <code>Locale</code> defined for the current JavaServer Faces
     * view.  If no more suitable encoding can be found, return
     * "UTF-8" as a general purpose default.</p>
     *
     * <p>The default implementation uses the implementation from
     * our superclass, <code>AbstractApplicationBean</code>.</p>
     */
    public String getLocaleCharacterEncoding() {
        return super.getLocaleCharacterEncoding();
    }

    public synchronized String getNextAnonUsername() {
        nextAnonIndex++;
        return "anonymous" + nextAnonIndex;
    }
    private int nextAnonIndex;
    private final int MAX_ENTRIES = 1000;
    //list of String arrays, with each array of length 2
    public List entryList = new LinkedList();
    //array containing same contents as entryList
    private String[][] entries;

    public String[][] getEntries() {
        synchronized (this.entryList) {
            return this.entries;
        }
    }

    //@episodio troca de mensagens gestionados desde o servidor
    //apresentar os movimentos feitos no jogo
    //apresentar as mesagens trocadas pelos jogadores
    public void addEntry(String username, String comment) {

        if (comment == null || comment.length() < 1) {
            return;
        }
        if (username == null) {
            username = "anonymous";
        }
        synchronized (this.entryList) {
            if (this.entryList.size() == MAX_ENTRIES) {
                this.entryList.remove(0);
            }
            String[] entry = new String[]{username, comment};
            this.entryList.add(entry);
            this.entries =
                    (String[][]) this.entryList.toArray(
                    new String[this.entryList.size()][entry.length]);

        }
    }

    /**
     * @return the projectGame
     */
    public boolean isProjectGame() {
        return projectGame;
    }

    /**
     * @param projectGame the projectGame to set
     */
    public void setProjectGame(boolean projectGame) {
        this.projectGame = projectGame;
    }

    /**
     * @return the starGame
     */
    public boolean isStarGame() {
        return starGame;
    }

    /**
     * @param starGame the starGame to set
     */
    public void setStarGame(boolean starGame) {
        this.starGame = starGame;
    }

    /**
     * @return the projectChoose
     */
    public List<Project> getProjectChoose() {
        return projectChoose;
    }

    /**
     * @param projectChoose the projectChoose to set
     */
    public void setProjectChoose(List<Project> projectChoose) {
        this.projectChoose = projectChoose;
    }

    /**
     * @return the modulesProject
     */
    public List<Modulesproject> getModulesProject() {
        return modulesProject;
    }

    /**
     * @param modulesProject the modulesProject to set
     */
    public void setModulesProject(List<Modulesproject> modulesProject) {
        this.modulesProject = modulesProject;
    }

    /**
     * @return the playerList
     */
    public List<Player> getPlayerList() {
        return playerList;
    }

    /**
     * @param playerList the playerList to set
     */
    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void getAllPalyer() {
        PlayerController playerHelper = new PlayerController();
        playerList = playerHelper.getPlayer();
    }

    public void getAllConfigurationProject()
    {
        ProjectController projectController = new ProjectController();
        projectChoose = projectController.getProjectChoose();
        ModulesProjectController modulesProjectController = new ModulesProjectController();
        modulesProject = modulesProjectController.getModulesProjectChose();
    }

    public void getSourceOfCards()
    {
        SourceofcardsController sourceofcardsController = new SourceofcardsController();
        setSourceofcardsList((List<Sourceofcards>) sourceofcardsController.getSourceofcards());

    }

    /**
     * @return the closeEntryPlayer
     */
    public boolean isCloseEntryPlayer() {
        return closeEntryPlayer;
    }

    /**
     * @param closeEntryPlayer the closeEntryPlayer to set
     */
    public void setCloseEntryPlayer(boolean closeEntryPlayer) {
        this.closeEntryPlayer = closeEntryPlayer;
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

    public void getTreatProblemsByPlayer(int idPlayer) {
        PlayersproblemsController playersproblemsController = new PlayersproblemsController();
        TreatmentProblemsbyPlayer = playersproblemsController.getCardsProblemsByPlayer(idPlayer);
    // TreatmentProblemsbyPlayer = playersproblemsController.getCardsProblemsByPlayer(23);
    }

     public void getAllMove()
    {
       AcceptmoveController acceptmoveController = new AcceptmoveController();
        setAcceptmoveList((List<Acceptmove>) acceptmoveController.getAcceptmove());
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

    /**
     * @return the sourcePlayerCardsId
     */
    public int getSourcePlayerCardsId() {
        return sourcePlayerCardsId;
    }

    /**
     * @param sourcePlayerCardsId the sourcePlayerCardsId to set
     */
    public void setSourcePlayerCardsId(int sourcePlayerCardsId) {
        this.sourcePlayerCardsId = sourcePlayerCardsId;
    }

   public void chooseMoveAccept()
   {
       AcceptmoveController acceptmoveController = new AcceptmoveController();
       setAcceptmoveList(acceptmoveController.getAcceptMove(getMoveId()));
   }

    /**
     * @return the moveId
     */
    public int getMoveId() {
        return moveId;
    }

    /**
     * @param moveId the moveId to set
     */
    public void setMoveId(int moveId) {
        this.moveId = moveId;
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

    /**
     * @return the round
     */
    public int getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void setRound(int round) {
        this.round = round;
    }


    public void sumRound()
    {
        round = round + 1;
    }

    /**
     * @return the softEngChoosen
     */
    public boolean isSoftEngChoosen() {
        return softEngChoosen;
    }

    /**
     * @param softEngChoosen the softEngChoosen to set
     */
    public void setSoftEngChoosen(boolean softEngChoosen) {
        this.softEngChoosen = softEngChoosen;
    }
}
