package SimulES.Model;



import java.util.HashSet;
import java.util.Set;

/**
Titulo: Carta
Objetivo: Descrever o objeto carta.
Contexto:
Localização geográfica: Web
Localização temporal: Java Card
Pre-condições: Banco de dados deve estar disponível
Pos-condições: Objeto disponível
Atores: simules
Recursos: movimentos
Episódios:
1- receber objeto da camada de controle
2- conectar ao banco de dado
3- enviar objeto à base de dados
4- receber objeto da base de dados
 */
public class Card  implements java.io.Serializable {


     private Short cardId;
     private Sourceofcards sourceofcards;
     private Cardtype cardtype;
     private String name;
     private String reference;
     private String description;
     private String rule;
     private String referencelink;
     private String category;
     private Set<Acceptmove> acceptmoves = new HashSet<Acceptmove>(0);

    public Card() {
    }

	
    public Card(Sourceofcards sourceofcards, Cardtype cardtype, String name, String reference, String description, String referencelink) {
        this.sourceofcards = sourceofcards;
        this.cardtype = cardtype;
        this.name = name;
        this.reference = reference;
        this.description = description;
        this.referencelink = referencelink;
    }
    public Card(Sourceofcards sourceofcards, Cardtype cardtype, String name, String reference, String description, String rule, String referencelink, Set<Acceptmove> acceptmoves) {
       this.sourceofcards = sourceofcards;
       this.cardtype = cardtype;
       this.name = name;
       this.reference = reference;
       this.description = description;
       this.rule = rule;
       this.referencelink = referencelink;
       this.acceptmoves = acceptmoves;
    }
   
    public Short getCardId() {
        return this.cardId;
    }
    
    public void setCardId(Short cardId) {
        this.cardId = cardId;
    }
    public Sourceofcards getSourceofcards() {
        return this.sourceofcards;
    }
    
    public void setSourceofcards(Sourceofcards sourceofcards) {
        this.sourceofcards = sourceofcards;
    }
    public Cardtype getCardtype() {
        return this.cardtype;
    }
    
    public void setCardtype(Cardtype cardtype) {
        this.cardtype = cardtype;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getReference() {
        return this.reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRule() {
        return this.rule;
    }
    
    public void setRule(String rule) {
        this.rule = rule;
    }
    public String getReferencelink() {
        return this.referencelink;
    }
    
    public void setReferencelink(String referencelink) {
        this.referencelink = referencelink;
    }
    public Set<Acceptmove> getAcceptmoves() {
        return this.acceptmoves;
    }
    
    public void setAcceptmoves(Set<Acceptmove> acceptmoves) {
        this.acceptmoves = acceptmoves;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }




}


