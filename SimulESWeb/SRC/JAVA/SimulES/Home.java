package SimulES;

import SimulES.Util.ValidateCharacters;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.ImageComponent;
import com.sun.rave.web.ui.component.PanelLayout;
import com.sun.rave.web.ui.component.StaticText;
import com.sun.rave.web.ui.component.TextField;
import com.sun.rave.web.ui.model.DefaultTableDataProvider;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * ******************************************************************
Titulo: SDsituations apresentar dinâmica do jogo
Objetivo: Descrever e disponibilizar as informações gerais do jogo.
Contexto: Localização geografica: Web
Localização temporal: Java index
Precondições: Serviços web disponíveis
Poscondições: Informações gerais do jogo disponíveis Atores: jogador, SimulES
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Episódios:
1 – jogador entra no jogo
2 – jogador pode trocar mensagens com os jogadores;
3 – SimulES disponibiliza as informações do projeto escolhido;
4 – SimulES disponibiliza as informações de aceitação de movimentos;
5 – SimulES disponibiliza as mensagens trocadas entre os jogadores;
6 – SimulES disponibiliza as informações dos movimentos do jogo;
Restrições: tempo de resposta adequado

 *********************************************************************
 *
 * @version Index.java
 * @version Created on Jun 15, 2009, 10:13:18 PM
 * @author Elizabeth
 */
public class Home extends AbstractPageBean {

    private int init = 0;
    private TextField inputUsername = new TextField();
    private String resultMsg = "Uga Buga";


    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HtmlPanelGrid gridPanelRegister = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelRegister() {
        return gridPanelRegister;
    }

    public void setGridPanelRegister(HtmlPanelGrid hpg) {
        this.gridPanelRegister = hpg;
    }
    private HtmlPanelGrid grdContinuePlaying = new HtmlPanelGrid();

    public HtmlPanelGrid getGrdContinuePlaying() {
        return grdContinuePlaying;
    }

    public void setGrdContinuePlaying(HtmlPanelGrid hpg) {
        this.grdContinuePlaying = hpg;
    }
    private ImageComponent image3 = new ImageComponent();

    public ImageComponent getImage3() {
        return image3;
    }

    public void setImage3(ImageComponent ic) {
        this.image3 = ic;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Home() {
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
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        inputUsername.getOnFocus();

        gridPanelRegister.setRendered(true);
        grdContinuePlaying.setRendered(false);

    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
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
    public void prerender() {

        inputUsername.getOnFocus();

        //@episodio1 jogador entra no jogo
        String username = (String) getExternalContext().getRequestParameterMap().get("username");
        if (username != null) {



            getSessionBean1().setUsername(username);

            gridPanelRegister.setRendered(false);
            image3.setVisible(false);
            grdContinuePlaying.setRendered(true);
        } else if (getSessionBean1().getUsername() == null) {
            username = "anonymous";
        }
        //@episodio2 SimulES disponibiliza as informações do projeto escolhido;
        getApplicationBean1().setProjectChoose(getApplicationBean1().getProjectChoose());
        getApplicationBean1().setModulesProject(getApplicationBean1().getModulesProject());

        getApplicationBean1().setPlayerList(getApplicationBean1().getPlayerList());
        //@episodio3 SimulES disponibiliza as informações de aceitação de movimentos;
        getApplicationBean1().setAcceptmoveList(getApplicationBean1().getAcceptmoveList());
    }
    private int nextAnonIndex;

    public synchronized String getNextAnonUsername() {
        nextAnonIndex++;
        return "anonymous" + nextAnonIndex;
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
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

    public TextField getInputUsername() {
        return inputUsername;
    }

    public void setInputUsername(TextField tf) {
        this.inputUsername = tf;
    }

//    public String getResultMsg() {
//        return this.resultMsg;
//    }
//
//    public void setResultMsg(String s) {
//        this.resultMsg = s;
//    }
    public String sendUsername() {

        try {
            if (!this.inputUsername.getText().toString().isEmpty()) {

                ValidateCharacters validaChars = new ValidateCharacters();

                Boolean isCharValid = validaChars.validateOnlyCharacters(inputUsername.getText().toString());

                if (isCharValid) {

                    this.getSessionBean1().setUsername(this.inputUsername.getText().toString());
                    gridPanelRegister.setRendered(false);
                    init = init + 1;
                    return "case1";
                } else {
                    FacesMessage fm = new FacesMessage("There are some invalid characters in your Username");
                    fm.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                    return null;
                }
            } else {
                FacesMessage fm = new FacesMessage("The register can not be empty");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage fm = new FacesMessage("The register can not be empty");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 get1$ApplicationBean1() {
        return (ApplicationBean1) getBean("1$ApplicationBean1");
    }

    public void textField1_processValueChange(ValueChangeEvent event) {
    }

    public String btnContinue_action() {
        return "case3";
    }
}

