/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulES;

import SimulES.Control.PlayerCardController;
import SimulES.Control.PlayerController;
import SimulES.Control.PlayersproblemsController;
import SimulES.Model.Card;
import SimulES.Model.Player;
import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.Hyperlink;
import com.sun.rave.web.ui.component.RadioButton;
import com.sun.rave.web.ui.component.Table;
import com.sun.rave.web.ui.component.TableColumn;
import com.sun.rave.web.ui.component.TableRowGroup;
import com.sun.rave.web.ui.component.TextField;
import com.sun.rave.web.ui.event.TableSelectPhaseListener;
import com.sun.rave.web.ui.model.DefaultTableDataProvider;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version SubmitProblemsPage.java
 * @version Created on Jul 30, 2010, 6:46:31 PM
 * @author CarlosAlvarezH
 */
public class SubmitProblemsPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    private List<Card> allCardsToSubmitProblems = null;
    private List<Player> PlayerOnlineList = null;
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private TableColumn tableColumn8 = new TableColumn();

    public TableColumn getTableColumn8() {
        return tableColumn8;
    }

    public void setTableColumn8(TableColumn tc) {
        this.tableColumn8 = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableRowGroup tableRowGroup2 = new TableRowGroup();

    public TableRowGroup getTableRowGroup2() {
        return tableRowGroup2;
    }

    public void setTableRowGroup2(TableRowGroup trg) {
        this.tableRowGroup2 = trg;
    }
    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }
    private RadioButton radioButton2 = new RadioButton();

    public RadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(RadioButton rb) {
        this.radioButton2 = rb;
    }
    private TextField txtPlayer = new TextField();

    public TextField getTxtPlayer() {
        return txtPlayer;
    }

    public void setTxtPlayer(TextField tf) {
        this.txtPlayer = tf;
    }
    private Table tblPlayers = new Table();

    public Table getTblPlayers() {
        return tblPlayers;
    }

    public void setTblPlayers(Table t) {
        this.tblPlayers = t;
    }
    private Table tblProblems = new Table();

    public Table getTblProblems() {
        return tblProblems;
    }

    public void setTblProblems(Table t) {
        this.tblProblems = t;
    }
    private HtmlPanelGrid grdTblPlayers = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdTblPlayers() {
        return grdTblPlayers;
    }

    public void setGrdTblPlayers(HtmlPanelGrid hpg) {
        this.grdTblPlayers = hpg;
    }
    private HtmlPanelGrid grdTxtPlayer = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdTxtPlayer() {
        return grdTxtPlayer;
    }

    public void setGrdTxtPlayer(HtmlPanelGrid hpg) {
        this.grdTxtPlayer = hpg;
    }
    private HtmlPanelGrid grdProblems = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdProblems() {
        return grdProblems;
    }

    public void setGrdProblems(HtmlPanelGrid hpg) {
        this.grdProblems = hpg;
    }
    private Button btnAcceptPlayer = new Button();

    public Button getBtnAcceptPlayer() {
        return btnAcceptPlayer;
    }

    public void setBtnAcceptPlayer(Button b) {
        this.btnAcceptPlayer = b;
    }
    private Button btnCancel = new Button();

    public Button getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(Button b) {
        this.btnCancel = b;
    }
    private Button btnSubmit = new Button();

    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(Button b) {
        this.btnSubmit = b;
    }
    private Hyperlink hyperlinkSubmit = new Hyperlink();

    public Hyperlink getHyperlinkSubmit() {
        return hyperlinkSubmit;
    }

    public void setHyperlinkSubmit(Hyperlink h) {
        this.hyperlinkSubmit = h;
    }
    private Hyperlink hyperlinkChoose = new Hyperlink();

    public Hyperlink getHyperlinkChoose() {
        return hyperlinkChoose;
    }

    public void setHyperlinkChoose(Hyperlink h) {
        this.hyperlinkChoose = h;
    }
    private Hyperlink hyperlinkCancel = new Hyperlink();

    public Hyperlink getHyperlinkCancel() {
        return hyperlinkCancel;
    }

    public void setHyperlinkCancel(Hyperlink h) {
        this.hyperlinkCancel = h;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SubmitProblemsPage() {
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
            log("SubmitProblemsPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        //loadCardsProblemToSubmit();
        loadPlayersOnline();
        tblProblems.setVisible(false);
        grdTblPlayers.setRendered(true);
        grdProblems.setRendered(false);
        grdTxtPlayer.setRendered(false);
        btnCancel.setVisible(false);
        setAllCardsToSubmitProblems(null);

        loadCardsProblemToSubmit();

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
        //loadCardsProblemToSubmit();
        loadPlayersOnline();
//        grdTblPlayers.setRendered(true);
//        grdProblems.setRendered(false);
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

    /**
     * @return the allCardsToSubmitProblems
     */
    public List<Card> getAllCardsToSubmitProblems() {
        return allCardsToSubmitProblems;
    }

    /**
     * @param allCardsToSubmitProblems the allCardsToSubmitProblems to set
     */
    public void setAllCardsToSubmitProblems(List<Card> allCardsToSubmitProblems) {
        this.allCardsToSubmitProblems = allCardsToSubmitProblems;
    }

    //@episidio obter todas cartas problemas submetidas
    public void loadCardsProblemToSubmit() {
        PlayerCardController playercardcontroller = new PlayerCardController();
        PlayerController playerCont = new PlayerController();
        int idPlayer = playerCont.getPlayerId(getSessionBean1().getUsername());
        setAllCardsToSubmitProblems(playercardcontroller.getCardsProByPlayerToSubmit(idPlayer));
    }

    public void submitProblem() {
        try {
            String username = getSessionBean1().getUsername();
            if (userIsValid()) {
                PlayConceptsProblemsRoundPage pageConcepts = new PlayConceptsProblemsRoundPage();

                if (pageConcepts.validMove()) {
                    if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                        RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

                        int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

                        String name = (String) txtPlayer.getText();

                        if (!getSessionBean1().getUsername().equals(name)) {
                            PlayerController playercontroller = new PlayerController();
                            Player player = playercontroller.getPlayer(name);

                            Card card = allCardsToSubmitProblems.get(rowId);

                            PlayersproblemsController playerproblemscontroller = new PlayersproblemsController();

                            //o problema é submetido para o jogador
                            if (playerproblemscontroller.addPlayerProblemCard(player, card)) {
                                PlayerCardController playercardcontroller = new PlayerCardController();

                                int id = card.getCardId();

                                //a carta é apagada das cartas do jogador que submeteu o problema
                                if (deleteRelationCardSubmitPlayer()) {

                                    FacesMessage fm = new FacesMessage("Problem has been submited sucessfully");
                                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                    FacesContext.getCurrentInstance().addMessage(null, fm);

                                } else {
                                    FacesMessage fm = new FacesMessage("Error deleted this card, try deleted it manually");
                                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                    FacesContext.getCurrentInstance().addMessage(null, fm);
                                }
                            } else {
                                FacesMessage fm = new FacesMessage("Error in database transation, try again");
                                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                FacesContext.getCurrentInstance().addMessage(null, fm);
                            }
                        } else {
                            FacesMessage fm = new FacesMessage("You can not submit problems to yourself");
                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                            FacesContext.getCurrentInstance().addMessage(null, fm);
                        }


                    }
                }
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
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

    public String btnSubmit_action() {
         submitProblem();

        return null;
    }

    public String hyperlinkSubmit_action() {
        submitProblem();
        return null;
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

    public void dropDownPlayer_processValueChange(ValueChangeEvent event) {
    }

    public boolean deleteRelationCardSubmitPlayer() {
        boolean deleteOk = false;

        PlayerCardController playercardcontroller = new PlayerCardController();
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            Card card = allCardsToSubmitProblems.get(rowId);
            int idCard = card.getCardId();

            //a carta é apagada das cartas do jogador que submeteu o problema
            if (playercardcontroller.deletePlayerCard(idCard)) {

                //recarregamos os dados
                loadCardsProblemToSubmit();
                deleteOk = true;

            }

        }

        return deleteOk;
    }

    /**
     * @return the PlayerOnlineList
     */
    public List<Player> getPlayerOnlineList() {
        return PlayerOnlineList;
    }

    /**
     * @param PlayerOnlineList the PlayerOnlineList to set
     */
    public void setPlayerOnlineList(List<Player> PlayerOnlineList) {
        this.PlayerOnlineList = PlayerOnlineList;
    }

    //@episidio obter todas cartas problemas submetidas
    public void loadPlayersOnline() {
        PlayerController playercontroller = new PlayerController();
        setPlayerOnlineList(playercontroller.getPlayer());
    }

    public String btnAcceptPlayer_action() {
       
        choosePlayer();
        return null;
    }

    public String btnCancel_action() {
      
        cancel();
        return null;
    }

    public void choosePlayer() {
       
        grdTxtPlayer.setRendered(true);
        getTableRowGroup2().clearFilter();
        getTableRowGroup2().clearSort();
        grdTblPlayers.setRendered(false);
        tblPlayers.setVisible(false);
        txtPlayer.setVisible(true);
        btnCancel.setVisible(true);
        btnAcceptPlayer.setVisible(false);
        grdProblems.setRendered(true);
        tblProblems.setVisible(true);
        btnSubmit.setVisible(true);
        hyperlinkSubmit.setVisible(true);
        hyperlinkChoose.setVisible(false);

        if (getTableRowGroup2().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup2().getSelectedRowKeys();

            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
            Player player = getPlayerOnlineList().get(rowId);

            txtPlayer.setText(player.getNickname());

            FacesMessage fm = new FacesMessage("Player chosen :" + player.getNickname());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        }

       
        loadCardsProblemToSubmit();
    }

    public String hyperlinkChoose_action() {
        choosePlayer();
        return null;
    }

    public void cancel() {
        grdTxtPlayer.setRendered(false);
        grdTblPlayers.setRendered(true);
        getTableRowGroup2().clearFilter();
        getTableRowGroup2().clearSort();
        txtPlayer.setText("");
        tblPlayers.setVisible(true);
        txtPlayer.setVisible(false);
        setPlayerOnlineList(null);
        btnCancel.setVisible(false);
        btnAcceptPlayer.setVisible(true);
        grdProblems.setRendered(false);
        tblProblems.setVisible(false);
        btnSubmit.setVisible(false);
        hyperlinkSubmit.setVisible(false);
        hyperlinkChoose.setVisible(true);
        setAllCardsToSubmitProblems(null);
        loadPlayersOnline();
    }

    public String hyperlinkCancel_action() {
        cancel();
        return null;
    }
}

