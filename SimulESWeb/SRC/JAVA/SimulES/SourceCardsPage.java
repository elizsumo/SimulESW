package SimulES;

import SimulES.Control.CardController;
import SimulES.Control.CardtypeController;
import SimulES.Control.SourceofcardsController;
import SimulES.Model.Card;
import SimulES.Model.Cardtype;
import SimulES.Model.Sourceofcards;
import com.sun.data.provider.RowKey;
import com.sun.data.provider.impl.CachedRowSetDataProvider;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.DropDown;
import com.sun.rave.web.ui.component.RadioButton;
import com.sun.rave.web.ui.component.TableColumn;
import com.sun.rave.web.ui.component.TableRowGroup;
import com.sun.rave.web.ui.component.TextField;
import com.sun.rave.web.ui.event.TableSelectPhaseListener;
import com.sun.rave.web.ui.model.SingleSelectOptionsList;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.convert.IntegerConverter;
import javax.faces.convert.LongConverter;
import javax.faces.event.ValueChangeEvent;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version SourceCardsPage.java
 * @version Created on Nov 5, 2009, 3:15:12 PM
 * @author Elizabeth
 */
public class SourceCardsPage extends AbstractPageBean {

    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean addRequestCard = false;
    private boolean updateRequestCard = false;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        cardtypeDataProvider.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.cardtypeRowSet}"));
        sourceofcardsDataProvider.setCachedRowSet((javax.sql.rowset.CachedRowSet) getValue("#{SessionBean1.sourceofcardsRowSet}"));
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private TableColumn tableColumn3 = new TableColumn();

    public TableColumn getTableColumn3() {
        return tableColumn3;
    }

    public void setTableColumn3(TableColumn tc) {
        this.tableColumn3 = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TextField textFieldDescription = new TextField();

    public TextField getTextFieldDescription() {
        return textFieldDescription;
    }

    public void setTextFieldDescription(TextField tf) {
        this.textFieldDescription = tf;
    }
    private HtmlPanelGrid grdUpdateSourceCard = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdUpdateSourceCard() {
        return grdUpdateSourceCard;
    }

    public void setGrdUpdateSourceCard(HtmlPanelGrid hpg) {
        this.grdUpdateSourceCard = hpg;
    }
    private Button addButton = new Button();

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button b) {
        this.addButton = b;
    }
    private Button updateButton = new Button();

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button b) {
        this.updateButton = b;
    }
    private Button deleteButton = new Button();

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button b) {
        this.deleteButton = b;
    }
    private Button updateRecordButton = new Button();

    public Button getUpdateRecordButton() {
        return updateRecordButton;
    }

    public void setUpdateRecordButton(Button b) {
        this.updateRecordButton = b;
    }
    private Button addRecordButton = new Button();

    public Button getAddRecordButton() {
        return addRecordButton;
    }

    public void setAddRecordButton(Button b) {
        this.addRecordButton = b;
    }
    private TextField textFieldName = new TextField();

    public TextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(TextField tf) {
        this.textFieldName = tf;
    }
    private TextField textFieldDescriptionCard = new TextField();

    public TextField getTextFieldDescriptionCard() {
        return textFieldDescriptionCard;
    }

    public void setTextFieldDescriptionCard(TextField tf) {
        this.textFieldDescriptionCard = tf;
    }
    private DropDown dropDownType = new DropDown();

    public DropDown getDropDownType() {
        return dropDownType;
    }

    public void setDropDownType(DropDown dd) {
        this.dropDownType = dd;
    }
    private TextField textFieldConstrait = new TextField();

    public TextField getTextFieldConstrait() {
        return textFieldConstrait;
    }

    public void setTextFieldConstrait(TextField tf) {
        this.textFieldConstrait = tf;
    }
    private TextField textFieldReference = new TextField();

    public TextField getTextFieldReference() {
        return textFieldReference;
    }

    public void setTextFieldReference(TextField tf) {
        this.textFieldReference = tf;
    }
    private TableRowGroup tableRowGroup2 = new TableRowGroup();

    public TableRowGroup getTableRowGroup2() {
        return tableRowGroup2;
    }

    public void setTableRowGroup2(TableRowGroup trg) {
        this.tableRowGroup2 = trg;
    }
    private TableColumn tableColumn8 = new TableColumn();

    public TableColumn getTableColumn8() {
        return tableColumn8;
    }

    public void setTableColumn8(TableColumn tc) {
        this.tableColumn8 = tc;
    }
    private RadioButton radioButton2 = new RadioButton();

    public RadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(RadioButton rb) {
        this.radioButton2 = rb;
    }
    private CachedRowSetDataProvider cardtypeDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getCardtypeDataProvider() {
        return cardtypeDataProvider;
    }

    public void setCardtypeDataProvider(CachedRowSetDataProvider crsdp) {
        this.cardtypeDataProvider = crsdp;
    }
    private LongConverter dropDownTypeConverter = new LongConverter();

    public LongConverter getDropDownTypeConverter() {
        return dropDownTypeConverter;
    }

    public void setDropDownTypeConverter(LongConverter lc) {
        this.dropDownTypeConverter = lc;
    }
    private CachedRowSetDataProvider sourceofcardsDataProvider = new CachedRowSetDataProvider();

    public CachedRowSetDataProvider getSourceofcardsDataProvider() {
        return sourceofcardsDataProvider;
    }

    public void setSourceofcardsDataProvider(CachedRowSetDataProvider crsdp) {
        this.sourceofcardsDataProvider = crsdp;
    }
    private HtmlPanelGrid grdUpdateCards = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdUpdateCards() {
        return grdUpdateCards;
    }

    public void setGrdUpdateCards(HtmlPanelGrid hpg) {
        this.grdUpdateCards = hpg;
    }
    private Button btnAddRecord = new Button();

    public Button getBtnAddRecord() {
        return btnAddRecord;
    }

    public void setBtnAddRecord(Button b) {
        this.btnAddRecord = b;
    }
    private Button btnUpdateRecord = new Button();

    public Button getBtnUpdateRecord() {
        return btnUpdateRecord;
    }

    public void setBtnUpdateRecord(Button b) {
        this.btnUpdateRecord = b;
    }
    private Button btnAdd = new Button();

    public Button getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(Button b) {
        this.btnAdd = b;
    }
    private Button btnUpdated = new Button();

    public Button getBtnUpdated() {
        return btnUpdated;
    }

    public void setBtnUpdated(Button b) {
        this.btnUpdated = b;
    }
    private Button btnDelete = new Button();

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button b) {
        this.btnDelete = b;
    }
    private HtmlPanelGrid grdSourceCard = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdSourceCard() {
        return grdSourceCard;
    }

    public void setGrdSourceCard(HtmlPanelGrid hpg) {
        this.grdSourceCard = hpg;
    }
    private IntegerConverter dropDownSourceConverter = new IntegerConverter();

    public IntegerConverter getDropDownSourceConverter() {
        return dropDownSourceConverter;
    }

    public void setDropDownSourceConverter(IntegerConverter ic) {
        this.dropDownSourceConverter = ic;
    }
    private DropDown dropDownSource = new DropDown();

    public DropDown getDropDownSource() {
        return dropDownSource;
    }

    public void setDropDownSource(DropDown dd) {
        this.dropDownSource = dd;
    }
    private IntegerConverter integerConverter1 = new IntegerConverter();

    public IntegerConverter getIntegerConverter1() {
        return integerConverter1;
    }

    public void setIntegerConverter1(IntegerConverter ic) {
        this.integerConverter1 = ic;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SourceCardsPage() {
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
            log("SourceCardsPage Initialization Failure", e);
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

        prerenderSource();
        // Refresh the users data array in the session bean to to show
        // the newly added data or modified data in the Table Component
        getApplicationBean1().getSourceOfCards();
        getSessionBean1().getAllCard();
        getApplicationBean1().getSourceOfCards();
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
        cardtypeDataProvider.close();
        sourceofcardsDataProvider.close();
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
    private TableSelectPhaseListener tablePhaseListener =
            new TableSelectPhaseListener();

    public void setSelected(Object object) {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }

    public Object getSelected() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.getSelected(rowKey);

    }

    public Object getSelectedValue() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return (rowKey != null) ? rowKey.getRowId() : null;

    }

    public boolean getSelectedState() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.isSelected(rowKey);
    }

    public String addButton_action() {
        addRequest = true;
        return null;
    }

    public String updateButton_action() {
        updateRequest = true;
        return null;
    }

    public String deleteButton_action() {

        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
            List<Sourceofcards> sourceofcardsList = getApplicationBean1().getSourceofcardsList();
            Sourceofcards sourceofcards = sourceofcardsList.get(rowId);

            SourceofcardsController sourceofcardsController = new SourceofcardsController();
            sourceofcardsController.deleteSourceofcards(sourceofcards);

        }

        return null;
    }

    public String addRecordButton_action() {
        // Create a new User Entity
        Sourceofcards newSourceofcards = new Sourceofcards();
        newSourceofcards.setDescription((String) textFieldDescription.getText());

        // Add the new Entity to the database using sourceofcardsController
        SourceofcardsController sourceofcardsController = new SourceofcardsController();
        sourceofcardsController.addSourceofcards(newSourceofcards);
        getApplicationBean1().getSourceOfCards();
        updateRequest = false;
        return null;
    }

    public String updateRecordButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        // Create a new source Entity
        RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
        List<Sourceofcards> sourceofcardsList = getApplicationBean1().getSourceofcardsList();
        int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
        Sourceofcards sourceofcards = sourceofcardsList.get(rowId);

        sourceofcards.setDescription((String) textFieldDescription.getText());

        // Update the database table data using sourceofcardsController
        SourceofcardsController sourceofcardsController = new SourceofcardsController();
        sourceofcardsController.updateSourceofcards(sourceofcards);
        getApplicationBean1().getSourceOfCards();

        addRequest = false;
        return null;
    }

    public String btnAdd_action() {
        addRequestCard = true;
        return null;
    }

    public String btnUpdated_action() {
        updateRequestCard = true;
        return null;
    }



    public String btnAddRecord_action() {

        try
        {
        // Create a new card
        Card newCard = new Card();
         newCard.setCardId((short)(15));
        newCard.setDescription((String) textFieldDescriptionCard.getText());
        newCard.setName((String) textFieldName.getText());
        newCard.setReference((String) textFieldReference.getText());
        newCard.setSourceofcards(getSourceofcards());
        newCard.setCardtype(getTypeCard());


        // Add the new Entity to the database using sourceofcardsController
        CardController cardController = new CardController();

        cardController.addCard(newCard);
        updateRequestCard = false;
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }

    public Cardtype getTypeCard() {
          Cardtype newCardtype = new Cardtype();

        try {

            CardtypeController cardtypeController = new CardtypeController();

            int valueIndex = Integer.valueOf(dropDownType.getSelected().toString());
            newCardtype = cardtypeController.getCardtype(valueIndex);

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
          return newCardtype;
    }

    public Sourceofcards getSourceofcards() {

        Sourceofcards newSource = new Sourceofcards();

        try {

            SourceofcardsController sourceofcardsController = new SourceofcardsController();

            int valueIndex = Integer.valueOf(dropDownSource.getSelected().toString());
            newSource = sourceofcardsController.getSourceOfCards(valueIndex);

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        }

        return newSource;
    }



    public void prerenderSource() {
        if (addRequest) {
            grdUpdateSourceCard.setRendered(true);
            addRecordButton.setRendered(true);
            updateRecordButton.setRendered(false);
            textFieldDescription.setText("");


        } else if (updateRequest) {
            if (getTableRowGroup1().getSelectedRowsCount() > 0) {

                // Get the data from the selected Entity and update the fields
                RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
                List<Sourceofcards> sourceofcardsList = getApplicationBean1().getSourceofcardsList();
                int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
                Sourceofcards sourceofcards = sourceofcardsList.get(rowId);
                textFieldDescription.setText(sourceofcards.getDescription());

                grdUpdateSourceCard.setRendered(true);
                addRecordButton.setRendered(false);
                updateRecordButton.setRendered(true);


            }
        } else {
            grdUpdateSourceCard.setRendered(false);
        }
         getApplicationBean1().getSourceOfCards();
    }


}

