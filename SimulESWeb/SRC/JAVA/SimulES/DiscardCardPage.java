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
import com.sun.rave.web.ui.component.RadioButton;
import com.sun.rave.web.ui.component.TableColumn;
import com.sun.rave.web.ui.component.TableRowGroup;
import com.sun.rave.web.ui.event.TableSelectPhaseListener;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version DiscardCardPage.java
 * @version Created on Jul 30, 2010, 6:45:57 PM
 * @author CarlosAlvarezH
 */
public class DiscardCardPage extends AbstractPageBean {
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
    private List<Card> cardsToDiscard = null;
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private TableColumn tableColumn2 = new TableColumn();

    public TableColumn getTableColumn2() {
        return tableColumn2;
    }

    public void setTableColumn2(TableColumn tc) {
        this.tableColumn2 = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DiscardCardPage() {
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
            log("DiscardCardPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        loadCardsByPlayerToDiscard();
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
        loadCardsByPlayerToDiscard();
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
     * @return the cardsToDiscard
     */
    public List<Card> getCardsToDiscard() {
        return cardsToDiscard;
    }

    /**
     * @param cardsToDiscard the cardsToDiscard to set
     */
    public void setCardsToDiscard(List<Card> cardsToDiscard) {
        this.cardsToDiscard = cardsToDiscard;
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

    //descarto carta de meu monte de cartas
    public void discardCard() {
        try {
            String username = getSessionBean1().getUsername();
            if (userIsValid()) {
                PlayConceptsProblemsRoundPage pageConcepts = new PlayConceptsProblemsRoundPage();

                if (pageConcepts.validMove()) {
                    if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                        RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

                        int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

                        Card card = cardsToDiscard.get(rowId);

                        PlayerCardController playercardcontroller = new PlayerCardController();

                        //apagar a carta do monte de cartas do engenheiro
                        if (playercardcontroller.deletePlayerCard(card)) {
                            FacesMessage fm = new FacesMessage("The card has been discarded");
                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                            FacesContext.getCurrentInstance().addMessage(null, fm);

                            //atualizar dados na tela
                            loadCardsByPlayerToDiscard();

                        } else {
                            FacesMessage fm = new FacesMessage("Error");
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

    //@episidio obter todas as cartas por jogador para fazer descarte
    public void loadCardsByPlayerToDiscard() {
        PlayerCardController playercard = new PlayerCardController();
        PlayerController playerCont = new PlayerController();
        int idPlayer = playerCont.getPlayerId(getSessionBean1().getUsername());
        setCardsToDiscard(playercard.getCardsByPlayer(idPlayer));
    }

    public String btnDiscard_action() {


        discardCard();
        return null;
    }

    public String hyperlinkDiscard_action() {
        discardCard();
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

    //o jogador pode usar a carta conceito para seu propio jogo
    public void usedCard() {
        try {
            PlayConceptsProblemsRoundPage pageConcepts = new PlayConceptsProblemsRoundPage();

            if (pageConcepts.validMove()) {
                String username = getSessionBean1().getUsername();

                if (getTableRowGroup1().getSelectedRowsCount() > 0) {

                    RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

                    int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

                    Card card = cardsToDiscard.get(rowId);

                    int typeCard = card.getCardtype().getCardtypeId();

                    //validamos que a carta seja carta conceito
                    if (typeCard == 1) {
                        PlayerController playercontroller = new PlayerController();
                        Player player = playercontroller.getPlayer(username);

                        PlayersproblemsController playerproblemscontroller = new PlayersproblemsController();

                        //o conceito é submetido para o jogador
                        if (playerproblemscontroller.addPlayerConceptCard(player, card)) {
                            PlayerCardController playercardcontroller = new PlayerCardController();

                            //a carta é apagada da lista de cartas conceito
                            if (playercardcontroller.deletePlayerCard(card)) {

                                //atualizar dados na tela
                                loadCardsByPlayerToDiscard();

                                FacesMessage fm = new FacesMessage("You can use the card on the individual board");
                                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                FacesContext.getCurrentInstance().addMessage(null, fm);

                            }
                        }

                    } else {

                        FacesMessage fm = new FacesMessage("You can use only concept cards");
                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
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

    public String btnUsedCard_action() {
        usedCard();
        return null;
    }

    public String hyperlinkUse_action() {
        usedCard();
        return null;
    }
}

