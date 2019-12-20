/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulES;

import SimulES.Control.PlayersproblemsController;
import SimulES.Model.Playersproblems;
import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.RadioButton;
import com.sun.rave.web.ui.component.Table;
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
 * @version AdminProblemsPage.java
 * @version Created on Oct 4, 2011, 11:08:05 AM
 * @author elizsumoComputer
 */
public class AdminProblemsPage extends AbstractPageBean {

    private List<Playersproblems> cardsProblemsSubmitbyPlayers = null;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private TableColumn tableColumn7 = new TableColumn();

    public TableColumn getTableColumn7() {
        return tableColumn7;
    }

    public void setTableColumn7(TableColumn tc) {
        this.tableColumn7 = tc;
    }
    private Table tblAllProblemsSubmit = new Table();

    public Table getTblAllProblemsSubmit() {
        return tblAllProblemsSubmit;
    }

    public void setTblAllProblemsSubmit(Table t) {
        this.tblAllProblemsSubmit = t;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AdminProblemsPage() {
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
            log("AdminProblemsPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        loadAllProblemsSubmit();
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
     * @return the cardsProblemsSubmitbyPlayers
     */
    public List<Playersproblems> getCardsProblemsSubmitbyPlayers() {
        return cardsProblemsSubmitbyPlayers;
    }

    /**
     * @param cardsProblemsSubmitbyPlayers the cardsProblemsSubmitbyPlayers to set
     */
    public void setCardsProblemsSubmitbyPlayers(List<Playersproblems> cardsProblemsSubmitbyPlayers) {
        this.cardsProblemsSubmitbyPlayers = cardsProblemsSubmitbyPlayers;
    }

    //@episidio obter todos os problemas submetidos
    public void loadAllProblemsSubmit() {
        PlayersproblemsController playersproblemsController = new PlayersproblemsController();
        setCardsProblemsSubmitbyPlayers(playersproblemsController.getAllCardsProblemsSubmit());

        cardsProblemsSubmitbyPlayers = playersproblemsController.getAllCardsProblemsSubmit();

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

    public String btnAccept_action() {
        adminProblemsbyTutor(1);
        return null;
    }

   public String btnReject_action() {
       adminProblemsbyTutor(2);
        return null;
    }

    //o professor ou tutor aceita ou não o tratamento dado para uma carta,
    public void adminProblemsbyTutor(int valueUpdate) {
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            Playersproblems playerproblem = cardsProblemsSubmitbyPlayers.get(rowId);

            PlayersproblemsController playerspoblemscontroller = new PlayersproblemsController();

            if (valueUpdate == 1) {
                if (playerspoblemscontroller.acceptProblemTreated(playerproblem)) {
                    FacesMessage fm = new FacesMessage("The treatment/problem was stored");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                } else {
                    FacesMessage fm = new FacesMessage("There was error in database, try again");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                }
            } else if (valueUpdate == 2) {

                if (playerspoblemscontroller.rejectProblemTreated(playerproblem)){
                    FacesMessage fm = new FacesMessage("The problem has went back to the player");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                } else {
                    FacesMessage fm = new FacesMessage("There was error in database, try again");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                }
               
            }

             loadAllProblemsSubmit();
          
        }
    }


}

