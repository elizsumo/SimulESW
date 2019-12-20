/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulES;

import SimulES.Control.CardController;
import SimulES.Control.PlayerCardController;
import SimulES.Control.PlayerController;
import SimulES.Control.PlayersproblemsController;
import SimulES.Model.Card;
import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.DropDown;
import com.sun.rave.web.ui.component.Hyperlink;
import com.sun.rave.web.ui.component.RadioButton;
import com.sun.rave.web.ui.component.StaticText;
import com.sun.rave.web.ui.component.Table;
import com.sun.rave.web.ui.component.TableColumn;
import com.sun.rave.web.ui.component.TableRowGroup;
import com.sun.rave.web.ui.component.TextArea;
import com.sun.rave.web.ui.component.TextField;
import com.sun.rave.web.ui.event.TableSelectPhaseListener;
import com.sun.rave.web.ui.model.SingleSelectOptionsList;
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
 * @version ProblemsByPlayerPage.java
 * @version Created on Jul 30, 2010, 6:47:06 PM
 * @author CarlosAlvarezH
 */
public class ProblemsByPlayerPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dropDownChooseDefaultOptions.setOptions(new com.sun.rave.web.ui.model.Option[]{new com.sun.rave.web.ui.model.Option("0", ""), new com.sun.rave.web.ui.model.Option("1", "Accomplish  of penalty"), new com.sun.rave.web.ui.model.Option("2", "Treatment by concept")});
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    private List<Card> problemsBysPlayerToSolve = null;
    private List<Card> cardsConceptbyPlayer = null;
    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private Table tblTreatmentProblems = new Table();

    public Table getTblTreatmentProblems() {
        return tblTreatmentProblems;
    }

    public void setTblTreatmentProblems(Table t) {
        this.tblTreatmentProblems = t;
    }
    private SingleSelectOptionsList dropDownChooseDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDropDownChooseDefaultOptions() {
        return dropDownChooseDefaultOptions;
    }

    public void setDropDownChooseDefaultOptions(SingleSelectOptionsList ssol) {
        this.dropDownChooseDefaultOptions = ssol;
    }
    private TextField txtIdProblemCard = new TextField();

    public TextField getTxtIdProblemCard() {
        return txtIdProblemCard;
    }

    public void setTxtIdProblemCard(TextField tf) {
        this.txtIdProblemCard = tf;
    }
    private TextField txtNameProblemCard = new TextField();

    public TextField getTxtNameProblemCard() {
        return txtNameProblemCard;
    }

    public void setTxtNameProblemCard(TextField tf) {
        this.txtNameProblemCard = tf;
    }
    private DropDown dropDownChoose = new DropDown();

    public DropDown getDropDownChoose() {
        return dropDownChoose;
    }

    public void setDropDownChoose(DropDown dd) {
        this.dropDownChoose = dd;
    }
    private HtmlPanelGrid grdAllProblems = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdAllProblems() {
        return grdAllProblems;
    }

    public void setGrdAllProblems(HtmlPanelGrid hpg) {
        this.grdAllProblems = hpg;
    }
    private HtmlPanelGrid grdProblem = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdProblem() {
        return grdProblem;
    }

    public void setGrdProblem(HtmlPanelGrid hpg) {
        this.grdProblem = hpg;
    }
    private TextArea textAreaDescription = new TextArea();

    public TextArea getTextAreaDescription() {
        return textAreaDescription;
    }

    public void setTextAreaDescription(TextArea ta) {
        this.textAreaDescription = ta;
    }
    private HtmlPanelGrid grdSubmitTreatment = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdSubmitTreatment() {
        return grdSubmitTreatment;
    }

    public void setGrdSubmitTreatment(HtmlPanelGrid hpg) {
        this.grdSubmitTreatment = hpg;
    }
    private StaticText lblKindTreatment = new StaticText();

    public StaticText getLblKindTreatment() {
        return lblKindTreatment;
    }

    public void setLblKindTreatment(StaticText st) {
        this.lblKindTreatment = st;
    }
    private Table tblConcepts = new Table();

    public Table getTblConcepts() {
        return tblConcepts;
    }

    public void setTblConcepts(Table t) {
        this.tblConcepts = t;
    }
    private TextArea textAreaObservation = new TextArea();

    public TextArea getTextAreaObservation() {
        return textAreaObservation;
    }

    public void setTextAreaObservation(TextArea ta) {
        this.textAreaObservation = ta;
    }
    private Button btnSubmit = new Button();

    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(Button b) {
        this.btnSubmit = b;
    }
    private Hyperlink hyperlinkSubmitTreatment = new Hyperlink();

    public Hyperlink getHyperlinkSubmitTreatment() {
        return hyperlinkSubmitTreatment;
    }

    public void setHyperlinkSubmitTreatment(Hyperlink h) {
        this.hyperlinkSubmitTreatment = h;
    }
    private TableRowGroup tableRowGroup2 = new TableRowGroup();

    public TableRowGroup getTableRowGroup2() {
        return tableRowGroup2;
    }

    public void setTableRowGroup2(TableRowGroup trg) {
        this.tableRowGroup2 = trg;
    }
    private TableColumn tableColumn12 = new TableColumn();

    public TableColumn getTableColumn12() {
        return tableColumn12;
    }

    public void setTableColumn12(TableColumn tc) {
        this.tableColumn12 = tc;
    }
    private RadioButton radioButton2 = new RadioButton();

    public RadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(RadioButton rb) {
        this.radioButton2 = rb;
    }

    public ProblemsByPlayerPage() {
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
            log("ProblemsByPlayerPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        loadCardsProblemsByPlayerToSolve();
        loadCardsConceptByPlayer();
        grdProblem.setRendered(false);
        grdSubmitTreatment.setRendered(false);
        tblConcepts.setVisible(false);
        textAreaObservation.setVisible(false);
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
        loadCardsProblemsByPlayerToSolve();
        loadCardsConceptByPlayer();
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
     * @return the problemsBysPlayerToSolve
     */
    public List<Card> getProblemsBysPlayerToSolve() {
        return problemsBysPlayerToSolve;
    }

    /**
     * @param problemsBysPlayerToSolve the problemsBysPlayerToSolve to set
     */
    public void setProblemsBysPlayerToSolve(List<Card> problemsBysPlayerToSolve) {
        this.problemsBysPlayerToSolve = problemsBysPlayerToSolve;
    }

    //@episidio obter todas as cartas problema para jogador tratar
    public void loadCardsProblemsByPlayerToSolve() {
        PlayersproblemsController playercardProblems = new PlayersproblemsController();
        PlayerController playerCont = new PlayerController();
        int idPlayer = playerCont.getPlayerId(getSessionBean1().getUsername());
        setProblemsBysPlayerToSolve(playercardProblems.getCardsProblemsByPlayer(idPlayer));
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

    //@episidio obter todas as cartas conceito por jogador
    public void loadCardsConceptByPlayer() {
        PlayerCardController playercardCont = new PlayerCardController();
        PlayerController playerCont = new PlayerController();
        int idPlayer = playerCont.getPlayerId(getSessionBean1().getUsername());
        setCardsConceptbyPlayer(playercardCont.getCardsConceptByPlayer(idPlayer));
    }

    //@episodio escolher problema para tratar
    public void chooseProblemToSolve() {
        int RowIdProblem = 0;

        if (getTableRowGroup1().getSelectedRowsCount() > 0) {

            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

            RowIdProblem = Integer.parseInt(selectedRowKeys[0].getRowId());

            Card cardProblem = problemsBysPlayerToSolve.get(RowIdProblem);

            String valueChoose = (String) dropDownChoose.getSelected();

            if (cardProblem.getCardId() > 0) {
                dropDownChoose.setVisible(true);

                txtIdProblemCard.setText(cardProblem.getCardId().toString());
                txtNameProblemCard.setText(cardProblem.getName().toString());
                textAreaDescription.setText(cardProblem.getDescription().toString());

                setProblemsBysPlayerToSolve(null);

                grdAllProblems.setRendered(false);
                grdProblem.setRendered(true);

            }

        } else {
            FacesMessage fm = new FacesMessage("One problem must be chosen");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    //@retornar aos problemas todos
    public void returnToProblems() {
        getTableRowGroup1().clearFilter();
        getTableRowGroup1().clearSort();

        txtIdProblemCard.setText("");
        txtNameProblemCard.setText("");
        textAreaDescription.setText("");

        setCardsConceptbyPlayer(null);
        loadCardsProblemsByPlayerToSolve();

        grdAllProblems.setRendered(true);
        grdProblem.setRendered(false);
        grdSubmitTreatment.setRendered(false);
    }

    public String btnReturn_action() {
        // TODO: Process the button click action. Return value is a navigation
        returnToProblems();
        return null;
    }

    public String hyperlinkReturn_action() {
        returnToProblems();
        return null;
    }

    public String btnChooseProblem_action() {
        // TODO: Process the button click action. Return value is a navigation
        chooseProblemToTreatment();
        return null;
    }

    //@escolher um problema para tratar
    public void chooseProblemToTreatment() {
        int RowIdProblem = 0;

        try {
            String username = getSessionBean1().getUsername();
            if (userIsValid()) {
                PlayConceptsProblemsRoundPage pageConcepts = new PlayConceptsProblemsRoundPage();

            if (pageConcepts.validMove())
            {
                if (getTableRowGroup1().getSelectedRowsCount() > 0) {

                    RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

                    RowIdProblem = Integer.parseInt(selectedRowKeys[0].getRowId());

                    Card cardProblem = problemsBysPlayerToSolve.get(RowIdProblem);

                    String valueChoose = (String) dropDownChoose.getSelected();

                    if (cardProblem.getCardId() > 0) {
                        dropDownChoose.setVisible(true);

                        txtIdProblemCard.setText(cardProblem.getCardId().toString());
                        txtNameProblemCard.setText(cardProblem.getName().toString());
                        textAreaDescription.setText(cardProblem.getDescription().toString());

                        setProblemsBysPlayerToSolve(null);

                        grdAllProblems.setRendered(false);
                        grdProblem.setRendered(true);


                    }

                } else {
                    FacesMessage fm = new FacesMessage("One problem must be chosen");
                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
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

    public String hyperlinkChooseProblem_action() {
        chooseProblemToTreatment();
        return null;
    }

    public String button2_action() {
        String name = "estoy aqui y aqui me quedo";

        FacesMessage fm = new FacesMessage(name);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return null;
    }

    public void dropDownChoose_processValueChange(ValueChangeEvent event) {
        try {
            //quando o tratamento é observação, o SimulES disponibiliza estes controles
            if (dropDownChoose.getSelected().equals("1")) {

                grdSubmitTreatment.setRendered(true);
                lblKindTreatment.setValue("write your observation");
                textAreaObservation.setVisible(true);
                tblConcepts.setVisible(false);



            } //quando o tratamento e através de carta conceito, SimulES disponibiliza
            //as cartas conceito que possui o jogador
            else if (dropDownChoose.getSelected().equals("2")) {

                grdSubmitTreatment.setRendered(true);

                lblKindTreatment.setValue("choose one concept");

                tblConcepts.setVisible(true);
                textAreaObservation.setVisible(false);

                loadCardsConceptByPlayer();
            } else {
                grdSubmitTreatment.setRendered(true);
                lblKindTreatment.setValue("kind of Treatment");
            }

            loadCardsConceptByPlayer();

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    //@episodio para submeter o tratamento feito ao problema
    public void submitTreatmentProblem() {
        String observation = null;
        try {

            String valueChoose = (String) dropDownChoose.getSelected();

            PlayersproblemsController playersProblemsController = new PlayersproblemsController();

            //quando o jogador escolhe observação, ou seja, ele cumpriou uma penalidade e já vai
            //descartar a carta
            if (valueChoose.equals("1")) {

                lblKindTreatment.setValue("Explain how the problem was treated");
                tblConcepts.setVisible(false);
                textAreaObservation.setVisible(true);

                observation = (String) textAreaObservation.getText();

                if (observation.length() > 0) {

                    CardController cardController = new CardController();

                    int idCard = Integer.parseInt(txtIdProblemCard.getText().toString());

                    Card cardProblem = cardController.getCardByID(idCard);

                    if (playersProblemsController.updateObsCardsProblems(cardProblem, observation)) {

                        getSessionBean1().setCardproblem(null);
                        textAreaObservation.setText("");

                        setCardsConceptbyPlayer(null);
                        loadCardsProblemsByPlayerToSolve();


                        FacesMessage fm = new FacesMessage("You have sent your obs successfully");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);

                    } else {
                        FacesMessage fm = new FacesMessage("You have not sent your obs successfully");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    }

                } else {
                    FacesMessage fm = new FacesMessage("The observation can't be empty");
                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                }

            } //quando o jogador escolhe que o tratamento do problema vai ser com uma
            //carta conceito
            else if (valueChoose.equals("2")) {
                lblKindTreatment.setValue("choose one concept");
                tblConcepts.setVisible(true);
                textAreaObservation.setVisible(false);

                if (getTableRowGroup2().getSelectedRowsCount() > 0) {
                    RowKey[] selectedRowKeys = getTableRowGroup2().getSelectedRowKeys();

                    int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

                    Card cardConcept = cardsConceptbyPlayer.get(rowId);

                    CardController cardController = new CardController();

                    int idCard = Integer.parseInt(txtIdProblemCard.getText().toString());

                    Card cardProblem = cardController.getCardByID(idCard);

                    if (playersProblemsController.updateTreatmentCardsProblems(cardProblem, cardConcept)) {

                        setProblemsBysPlayerToSolve(null);
                        setCardsConceptbyPlayer(null);
                        loadCardsProblemsByPlayerToSolve();

                        FacesMessage fm = new FacesMessage("You have sent your solving successfully");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                        textAreaObservation.setText("");

                    } else {
                        FacesMessage fm = new FacesMessage("You have not sent your obs successfully");
                        fm.setSeverity(FacesMessage.SEVERITY_INFO);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    }
                } else {
                    FacesMessage fm = new FacesMessage("Choose the concept");
                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                }

            } else {

                FacesMessage fm = new FacesMessage("One option must be chose");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        }

        //limpamos os campos para novos tratamentos
        txtIdProblemCard.setText("");
        txtNameProblemCard.setText("");
        textAreaDescription.setText("");

        grdProblem.setRendered(false);
        grdSubmitTreatment.setRendered(false);
        grdAllProblems.setRendered(true);


    }

    public String btnSubmit_action() {
        // TODO: Process the button click action. Return value is a navigation
        submitTreatmentProblem();
        return null;
    }

    public String hyperlinkSubmitTreatment_action() {
        submitTreatmentProblem();
        return null;
    }

      //@episodio validamos a sessao do usuario
    public boolean userIsValid()
    {
        boolean isValid=true;
        try
        {
            if (getSessionBean1().getUsername().isEmpty())
            {
                isValid=false;
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("user is null");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            isValid = false;

        }
        return isValid;

    }
}

