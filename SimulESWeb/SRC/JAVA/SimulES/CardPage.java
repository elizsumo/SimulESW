
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
import javax.faces.convert.IntegerConverter;
import javax.faces.convert.LongConverter;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version CardPage.java
 * @version Created on Nov 7, 2009, 10:09:03 AM
 * @author Elizabeth
 */
public class CardPage extends AbstractPageBean {

    private boolean addRequest = false;
    private boolean updateRequest = false;

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
    private IntegerConverter dropDownSourceConverter = new IntegerConverter();

    public IntegerConverter getDropDownSourceConverter() {
        return dropDownSourceConverter;
    }

    public void setDropDownSourceConverter(IntegerConverter ic) {
        this.dropDownSourceConverter = ic;
    }
    private TextField textFieldName = new TextField();

    public TextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(TextField tf) {
        this.textFieldName = tf;
    }
    private TextField textFieldDescription = new TextField();

    public TextField getTextFieldDescription() {
        return textFieldDescription;
    }

    public void setTextFieldDescription(TextField tf) {
        this.textFieldDescription = tf;
    }
    private TextField textFieldConstraint = new TextField();

    public TextField getTextFieldConstraint() {
        return textFieldConstraint;
    }

    public void setTextFieldConstraint(TextField tf) {
        this.textFieldConstraint = tf;
    }
    private TextField textFieldReference = new TextField();

    public TextField getTextFieldReference() {
        return textFieldReference;
    }

    public void setTextFieldReference(TextField tf) {
        this.textFieldReference = tf;
    }
    private DropDown dropDownType = new DropDown();

    public DropDown getDropDownType() {
        return dropDownType;
    }

    public void setDropDownType(DropDown dd) {
        this.dropDownType = dd;
    }
    private DropDown dropDownSource = new DropDown();

    public DropDown getDropDownSource() {
        return dropDownSource;
    }

    public void setDropDownSource(DropDown dd) {
        this.dropDownSource = dd;
    }
    private Button addRecordButton = new Button();

    public Button getAddRecordButton() {
        return addRecordButton;
    }

    public void setAddRecordButton(Button b) {
        this.addRecordButton = b;
    }
    private Button updateRecordButton = new Button();

    public Button getUpdateRecordButton() {
        return updateRecordButton;
    }

    public void setUpdateRecordButton(Button b) {
        this.updateRecordButton = b;
    }
    private HtmlPanelGrid addUpdatePanel = new HtmlPanelGrid();

    public HtmlPanelGrid getAddUpdatePanel() {
        return addUpdatePanel;
    }

    public void setAddUpdatePanel(HtmlPanelGrid hpg) {
        this.addUpdatePanel = hpg;
    }
    private HtmlPanelGrid buttonPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(HtmlPanelGrid hpg) {
        this.buttonPanel = hpg;
    }
    private Table tblCards = new Table();

    public Table getTblCards() {
        return tblCards;
    }

    public void setTblCards(Table t) {
        this.tblCards = t;
    }
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
    private RadioButton radioButton3 = new RadioButton();

    public RadioButton getRadioButton3() {
        return radioButton3;
    }

    public void setRadioButton3(RadioButton rb) {
        this.radioButton3 = rb;
    }
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CardPage() {
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
            log("CardPage Initialization Failure", e);
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
//         if (addRequest) {
//            addUpdatePanel.setRendered(true);
//            addRecordButton.setRendered(true);
//            updateRecordButton.setRendered(false);
//            textFieldDescription.setText("");
//            textFieldName.setText("");
//            textFieldConstraint.setText("");
//            textFieldReference.setText("");
//
//        } else if (updateRequest) {
//            if (getTableRowGroup1().getSelectedRowsCount() > 0) {
//                // Get the data from the selected Entity and update the fields
//                RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
//                List<Cards> cardList = getSessionBean1().getAllCard();
//                int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
//                Cards card = cardList.get(rowId);
//
//                textFieldDescription.setText(card.getDescription());
//                textFieldName.setText(card.getName());
//                textFieldConstraint.setText(card.getConstraint());
//                textFieldReference.setText(card.getReference());
////                dropDownType.setValue(card.getCardtype());
////                dropDownSource.setValue(card.getSourceofcards());
//
//                addUpdatePanel.setRendered(true);
//                addRecordButton.setRendered(false);
//                updateRecordButton.setRendered(true);
//            }
//        } else {
//            addUpdatePanel.setRendered(false);
//        }
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
//        try
//        {
//
//        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
//            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
//            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
//          //  List<Cards> cardList = getSessionBean1().getAllCard();
//            Cards card = cardList.get(rowId);
//            CardsController cardController = new CardsController();
//            if(cardController.deleteCard(card))
//            {
//            getSessionBean1().getAllCards();
//            FacesMessage fm = new FacesMessage("Delete");
//            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
//            FacesContext.getCurrentInstance().addMessage(null, fm);
//            }
//        }
//         } catch (Exception ex) {
//            ex.printStackTrace();
//            FacesMessage fm = new FacesMessage(ex.toString());
//            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
//            FacesContext.getCurrentInstance().addMessage(null, fm);
//        }
        return null;
    }

    public String addRecordButton_action() {
        try {
            // Create a new card
            Card newCard = new Card();
            newCard.setDescription((String) textFieldDescription.getText());
            newCard.setName((String) textFieldName.getText());
            newCard.setReference((String) textFieldReference.getText());
    
//            newCard.setSourceofcards(getSourceofcards());
//            newCard.setCardtype(getTypeCard());
         

            // Add the new Entity to the database using sourceofcardsController
            CardController cardController = new CardController();

            cardController.addCard(newCard);
            updateRequest = false;
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage(ex.toString());
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
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

    public String updateRecordButton_action() {
//    try {
//            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
//           // List<Cards> cardList = getSessionBean1().getAllCard();
//            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
//            Cards card = cardList.get(rowId);
//
//            card.setDescription((String) textFieldDescription.getText());
//            card.setName((String) textFieldName.getText());
//            card.setReference((String) textFieldReference.getText());
//            card.setConstraint((String) textFieldConstraint.getText());
////            card.setSourceofcards(getSourceofcards());
////            card.setCardtype(getTypeCard());
//
//            // Update the database table data using sourceofcardsController
//            CardsController cardController = new CardsController();
//
//            if( cardController.updateCard(card))
//            {
//            getSessionBean1().getAllCards();
//            FacesMessage fm = new FacesMessage("Delete");
//            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
//            FacesContext.getCurrentInstance().addMessage(null, fm);
//            }
//
//            addRequest = false;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            FacesMessage fm = new FacesMessage(ex.toString());
//            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
//            FacesContext.getCurrentInstance().addMessage(null, fm);
//
//        }
        return null;
    }
}

