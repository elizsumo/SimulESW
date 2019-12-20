package SimulES.Model;



import java.util.HashSet;
import java.util.Set;

/**
Titulo: Tipo de Carta
Objetivo: Descrever as operações para obter o objeto tipo de carta.
Contexto:
Localização geográfica: Web
Localização temporal: Java CardType
Pre-condições: Banco de dados deve estar disponível
Pos-condições: Objeto disponível
Atores: simules
Recursos: tipo de carta(identificador, descrição).
Episódios:
1- receber objeto da camada de controle
2- conectar ao banco de dado
3- enviar objeto à base de dados

 */
public class Cardtype  implements java.io.Serializable {


     private Integer cardtypeId;
     private String description;
     private Set<Card> cards = new HashSet<Card>(0);

    public Cardtype() {
    }

	
    public Cardtype(String description) {
        this.description = description;
    }
    public Cardtype(String description, Set<Card> cards) {
       this.description = description;
       this.cards = cards;
    }
   
    public Integer getCardtypeId() {
        return this.cardtypeId;
    }
    
    public void setCardtypeId(Integer cardtypeId) {
        this.cardtypeId = cardtypeId;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<Card> getCards() {
        return this.cards;
    }
    
    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }




}


