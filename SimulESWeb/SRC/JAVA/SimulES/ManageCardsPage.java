package SimulES;

import com.sun.data.provider.RowKey;
import com.sun.data.provider.impl.CachedRowSetDataProvider;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.DropDown;
import com.sun.rave.web.ui.component.Form;
import com.sun.rave.web.ui.component.Table;
import com.sun.rave.web.ui.component.TableRowGroup;
import com.sun.sql.rowset.CachedRowSetXImpl;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.convert.IntegerConverter;
import javax.faces.convert.LongConverter;
import javax.faces.event.ValueChangeEvent;

/**
 * ******************************************************************
Titulo: SDsituations gestionar cartas
Objetivo: Permite gestionar as cartas conceito e as cartas problema.
Contexto: Localização geografica: Web
Localização temporal: Java index
Precondições: Serviços web disponíveis
Poscondições: Informações gerais do jogo disponíveis Atores: jogador, SimulES
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Restrições: tempo de resposta adequado

 *********************************************************************
 *
 * @version Index.java
 * @version Created on Jun 15, 2009, 10:13:18 PM
 * @author Elizabeth
 */
public class ManageCardsPage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        sourceofcardsDataProvider.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.sourceofcardsRowSet}"));
        cardDataProvider1.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.cardRowSet1}"));
        cardDataProvider.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.cardRowSet1}"));
        cardtypeDataProvider.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.cardtypeRowSet}"));
        cardtypeDataProvider1.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.cardtypeRowSet}"));
        sourceofcardsDataProvider1.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{ManageCardsPage.sourceofcardsRowSet}"));
        sourceofcardsRowSet.setDataSourceName("java:comp/env/jdbc/simules_MySQL");
        sourceofcardsRowSet.setCommand("SELECT * FROM sourceofcards");
        sourceofcardsRowSet.setTableName("sourceofcards");
        sourceofcardsDataProvider2.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{ManageCardsPage.sourceofcardsRowSet}"));
    }
    private CachedRowSetDataProvider sourceofcardsDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getSourceofcardsDataProvider() {
        return sourceofcardsDataProvider;
    }

    public void setSourceofcardsDataProvider(CachedRowSetDataProvider crsdp) {
        this.sourceofcardsDataProvider = crsdp;
    }
    private CachedRowSetDataProvider cardDataProvider1 = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getCardDataProvider1() {
        return cardDataProvider1;
    }

    public void setCardDataProvider1(CachedRowSetDataProvider crsdp) {
        this.cardDataProvider1 = crsdp;
    }
    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
    }
    private DropDown dropDownSource = new DropDown();

    public DropDown getDropDownSource() {
        return dropDownSource;
    }

    public void setDropDownSource(DropDown dd) {
        this.dropDownSource = dd;
    }
    private CachedRowSetDataProvider cardDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getCardDataProvider() {
        return cardDataProvider;
    }

    public void setCardDataProvider(CachedRowSetDataProvider crsdp) {
        this.cardDataProvider = crsdp;
    }
    private CachedRowSetDataProvider cardtypeDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getCardtypeDataProvider() {
        return cardtypeDataProvider;
    }

    public void setCardtypeDataProvider(CachedRowSetDataProvider crsdp) {
        this.cardtypeDataProvider = crsdp;
    }
    private Form form1 = new Form();

    public Form getForm1() {
        return form1;
    }

    public void setForm1(Form f) {
        this.form1 = f;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private CachedRowSetDataProvider cardtypeDataProvider1 = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getCardtypeDataProvider1() {
        return cardtypeDataProvider1;
    }

    public void setCardtypeDataProvider1(CachedRowSetDataProvider crsdp) {
        this.cardtypeDataProvider1 = crsdp;
    }
    private LongConverter dropDownTypeCardConverter = new LongConverter();

    public LongConverter getDropDownTypeCardConverter() {
        return dropDownTypeCardConverter;
    }

    public void setDropDownTypeCardConverter(LongConverter lc) {
        this.dropDownTypeCardConverter = lc;
    }
    private CachedRowSetDataProvider sourceofcardsDataProvider1 = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getSourceofcardsDataProvider1() {
        return sourceofcardsDataProvider1;
    }

    public void setSourceofcardsDataProvider1(CachedRowSetDataProvider crsdp) {
        this.sourceofcardsDataProvider1 = crsdp;
    }
    private CachedRowSetXImpl sourceofcardsRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getSourceofcardsRowSet() {
        return sourceofcardsRowSet;
    }

    public void setSourceofcardsRowSet(CachedRowSetXImpl crsxi) {
        this.sourceofcardsRowSet = crsxi;
    }
    private CachedRowSetDataProvider sourceofcardsDataProvider2 = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getSourceofcardsDataProvider2() {
        return sourceofcardsDataProvider2;
    }

    public void setSourceofcardsDataProvider2(CachedRowSetDataProvider crsdp) {
        this.sourceofcardsDataProvider2 = crsdp;
    }
    private IntegerConverter dropDownSourceConverter = new IntegerConverter();

    public IntegerConverter getDropDownSourceConverter() {
        return dropDownSourceConverter;
    }

    public void setDropDownSourceConverter(IntegerConverter ic) {
        this.dropDownSourceConverter = ic;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ManageCardsPage() {
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
            log("ManageCardsPage Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here
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

        //@episodio1 obter a fonte das cartas a apresentar
        if ( dropDownSource.getSelected() == null ) {
           Object firstCardId = null;
           try {
               sourceofcardsDataProvider.cursorFirst();
               firstCardId = sourceofcardsDataProvider.getValue("sourceofcards.sourceofcards_id");
               dropDownSource.setSelected(firstCardId);
               getSessionBean1().getCardRowSet1().setObject(
                       1, firstCardId);
               cardDataProvider.refresh();
           } catch (Exception e) {
               error("Cannot switch to card " +
                       firstCardId);
               log("Cannot switch to card " +
                       firstCardId, e);
           }
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
        sourceofcardsDataProvider.close();
        cardDataProvider1.close();
        cardDataProvider.close();
        cardtypeDataProvider.close();
        cardtypeDataProvider1.close();
        sourceofcardsDataProvider1.close();
        sourceofcardsDataProvider2.close();
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

    //@episodio2 mudar as cartas conforme à fonte de informação
    public void dropDownSource_processValueChange(ValueChangeEvent event) {
        Object selectedCardId = dropDownSource.getSelected();
        try {
            sourceofcardsDataProvider.setCursorRow(
                    sourceofcardsDataProvider.findFirst("sourceofcards.sourceofcards_id",
                    selectedCardId));
            getSessionBean1().getCardRowSet1().setObject(1, selectedCardId);
            cardDataProvider.refresh();
            form1.discardSubmittedValues("save");
        } catch (Exception e) {
            error("Cannot switch to card " + selectedCardId);
            log("Cannot switch to card " + selectedCardId, e);
        }

    }

    //@episodio3 criar uma nova carta conceito ou problema
    public String add_action() {

        try {
            RowKey rk = cardDataProvider.appendRow();
            cardDataProvider.setCursorRow(rk);
            cardDataProvider.setValue("card.card_id", new Integer(0));
            cardDataProvider.setValue("card.sourceofcards_id", dropDownSource.getSelected());

        } catch (Exception ex) {
            log("Error Description", ex);
            error(ex.getMessage());
        }

        return null;
    }

    //@episodio4 salvar as modifições feitas nas cartas conceito e problema
    public String save_action() {
       try {

            // Get the next key, using result of query on MaxTrip data provider
            CachedRowSetDataProvider maxCard = getSessionBean1().getMaxCardDataProvider();

            maxCard.refresh();
            maxCard.cursorFirst();
             String maxCardId =  maxCard.getValue("maxcard").toString();

           int newCardId = Integer.parseInt(maxCardId);

            // Navigate through rows with data provider
            if (cardDataProvider.getRowCount() > 0) {
                cardDataProvider.cursorFirst();
                do {
                    if (cardDataProvider.getValue("card.card_id").equals
					   (new Integer(0))) {
                        cardDataProvider.setValue("card.card_id",
						new Integer(newCardId));
                        newCardId++;
                    }

                } while (cardDataProvider.cursorNext());
            }
            cardDataProvider.commitChanges();
        } catch (Exception ex) {
            log("Error Description", ex);
            error("Error :"+ex.getMessage());
        }

        return null;
    }

    //@episodio5 apagar cartas conceito ou cartas problema
    public String delete_action() {
   form1.discardSubmittedValues("save");
        try {
            RowKey rk = tableRowGroup1.getRowKey();
            if (rk != null) {
                cardDataProvider.removeRow(rk);
                cardDataProvider.commitChanges();
                cardDataProvider.refresh();}
        } catch (Exception ex) {
            log("ErrorDescription", ex);
            error(ex.getMessage());
        }

        return null;
    }

    //@episodio6 reverter as mudanças feitas nas cartas problemas e cartas conceito
    public String revert_action() {
      form1.discardSubmittedValues("save");
        try {
            cardDataProvider.refresh();

        } catch (Exception ex) {
            log("Error Description", ex);
            error(ex.getMessage());
        }

        return null;
    }
}

