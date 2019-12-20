/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulES;

import SimulES.Control.PlayerController;
import SimulES.Control.PlayerSoftengineerController;
import SimulES.Control.SoftEngineerController;
import SimulES.Model.Softengineer;
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
 * @version ManageSoftwareEngineersPage.java
 * @version Created on Jul 30, 2010, 4:54:59 PM
 * @author CarlosAlvarezH
 */
public class ManageSoftwareEngineersPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    private List<Softengineer> softEngbyPlayer = null;
    private TableColumn tableColumn8 = new TableColumn();

    public TableColumn getTableColumn8() {
        return tableColumn8;
    }

    public void setTableColumn8(TableColumn tc) {
        this.tableColumn8 = tc;
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

    public ManageSoftwareEngineersPage() {
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
            log("ManageSoftwareEngineersPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        loadSoftEngByPlayer();
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
        loadSoftEngByPlayer();
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

    //@episidio obter todos os engenheiros de software por jogador
    public void loadSoftEngByPlayer() {
        PlayerSoftengineerController playerSoftengineerController = new PlayerSoftengineerController();
        PlayerController playerCont = new PlayerController();
        int idPlayer = playerCont.getPlayerId(getSessionBean1().getUsername());
        setSoftEngbyPlayer(playerSoftengineerController.getSoftEngByPlayer(idPlayer));
    }

    /**
     * @return the softEngbyPlayer
     */
    public List<Softengineer> getSoftEngbyPlayer() {
        return softEngbyPlayer;
    }

    /**
     * @param softEngbyPlayer the softEngbyPlayer to set
     */
    public void setSoftEngbyPlayer(List<Softengineer> softEngbyPlayer) {
        this.softEngbyPlayer = softEngbyPlayer;
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

    public void employSoftEngineer() {

        
        String username = getSessionBean1().getUsername();
        PlayConceptsProblemsRoundPage pageConcepts = new PlayConceptsProblemsRoundPage();
        if (userIsValid()) {
            if (pageConcepts.validMove()) {

                if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                    RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

                    int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

                    Softengineer softEng = softEngbyPlayer.get(rowId);

                    if (isHiringRight(softEng.getSalary())) {



                        if ( getSumEngSoftwareHiring() < 4 ) {

                            SoftEngineerController softEngCont = new SoftEngineerController();

                            //mudar o estado do engenheiro para empregado
                            if (softEngCont.employSoftwareEngineer(softEng)) {

                                //atualizar os dados na tela
                                loadSoftEngByPlayer();

                                FacesMessage fm = new FacesMessage("Software Engineer has been employed");
                                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                FacesContext.getCurrentInstance().addMessage(null, fm);

                            } else {
                                FacesMessage fm = new FacesMessage("Error running the program");
                                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                                FacesContext.getCurrentInstance().addMessage(null, fm);
                            }
                        } else {
                            FacesMessage fm = new FacesMessage("You can not hire more than 4 engineers");
                            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                            FacesContext.getCurrentInstance().addMessage(null, fm);
                        }
                    } else {
                        FacesMessage fm = new FacesMessage("You can not hire this engineer, is outside the budget" );
                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    }
                }
            }

        }

    }

    public void demitSoftEngineer() {
        String username = getSessionBean1().getUsername();
        if (userIsValid()) {
            PlayConceptsProblemsRoundPage pageConcepts = new PlayConceptsProblemsRoundPage();

            if (pageConcepts.validMove()) {

                if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                    RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

                    int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

                    

                    Softengineer softEng = softEngbyPlayer.get(rowId);

                    PlayerSoftengineerController softEngDet = new PlayerSoftengineerController();

                    //retornar o jogador a estado disponivel, para que outros jogadores possam usar ele
                    if (softEngDet.deleteRel(softEng)) {

                        FacesMessage fm = new FacesMessage("Software Engineer has been demited");
                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                        softEngbyPlayer.remove(rowId);
                        loadSoftEngByPlayer();

                    } else {
                        FacesMessage fm = new FacesMessage("Transation Error");
                        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext.getCurrentInstance().addMessage(null, fm);
                    }
                  }
            }
        }
    }

    public String btnEmploy_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        employSoftEngineer();

        return null;
    }

    public String hyperlinkEmploy_action() {

        employSoftEngineer();

        return null;
    }

    public String btnDemit_action() {


        demitSoftEngineer();

        return null;
    }

    public String hyperlinkDemit_action() {
        demitSoftEngineer();
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

    //validamos que a contratacao este dentro do orçamento do projeto
    public boolean isHiringRight(int budgetNewSoftEng) {
        boolean newHiringOk = true;
        PlayerController playerCont = new PlayerController();
        PlayerSoftengineerController playerSoftengineerController = new PlayerSoftengineerController();

        int idPlayer = playerCont.getPlayerId(getSessionBean1().getUsername());
        if (!playerSoftengineerController.validateHiring(idPlayer, budgetNewSoftEng)) {
            newHiringOk = false;
        }
        return newHiringOk;

    }

    public int getSumEngSoftwareHiring() {
        int sumHiring = 0;
        PlayerController playerCont = new PlayerController();
        int idPlayer = playerCont.getPlayerId(getSessionBean1().getUsername());
        PlayerSoftengineerController playerSoftengineerController = new PlayerSoftengineerController();
        sumHiring = playerSoftengineerController.getEngSoftwareHiring(idPlayer);
        return sumHiring;

    }
}

