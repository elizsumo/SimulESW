/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulES;

import SimulES.Control.SourceofcardsController;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.RadioButton;
import com.sun.rave.web.ui.component.Table;
import com.sun.rave.web.ui.component.TableColumn;
import com.sun.rave.web.ui.component.TableRowGroup;
import javax.faces.FacesException;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ChooseSupporMaterialPage.java
 * @version Created on May 8, 2012, 4:14:00 PM
 * @author Elizabeth
 */
import SimulES.Model.Sourceofcards;
import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.event.TableSelectPhaseListener;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ChooseSupporMaterialPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>
    private List<Sourceofcards> sourceofcard = null;
    private Table tblSupportMaterial = new Table();

    public Table getTblSupportMaterial() {
        return tblSupportMaterial;
    }

    public void setTblSupportMaterial(Table t) {
        this.tblSupportMaterial = t;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private TableColumn tableColumn4 = new TableColumn();

    public TableColumn getTableColumn4() {
        return tableColumn4;
    }

    public void setTableColumn4(TableColumn tc) {
        this.tableColumn4 = tc;
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
    public ChooseSupporMaterialPage() {
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
            log("ChooseSupporMaterialPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        loadSupportMaterial();
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
        loadSupportMaterial();
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
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * @return the sourceofcard
     */
    public List<Sourceofcards> getSourceofcard() {
        return sourceofcard;
    }

    /**
     * @param sourceofcard the sourceofcard to set
     */
    public void setSourceofcard(List<Sourceofcards> sourceofcard) {
        this.sourceofcard = sourceofcard;
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
    //@episidio obter todas as fontes de informacao
    public void loadSupportMaterial() {
        SourceofcardsController sourceOfCard = new SourceofcardsController();
        setSourceofcard(sourceOfCard.getSourceofcards());
    }

    public void selectSupportMaterial() {
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {

            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            try {
                Sourceofcards sourceCards = this.sourceofcard.get(rowId);
                short idSourceCards = sourceCards.getSourceofcardsId();

                getApplicationBean1().setSourcePlayerCardsId(idSourceCards);

                FacesMessage fm = new FacesMessage("Source Cards chose is " + sourceCards.getDescription());
                //FacesMessage fm = new FacesMessage("Source Cards chose is " + idSourceCards);
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            } catch (Exception ex) {
                ex.printStackTrace();
                FacesMessage fm = new FacesMessage(ex.toString());
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }

        }
    }

    public String btnAccept_action() {
       selectSupportMaterial();
        return null;
    }
}

