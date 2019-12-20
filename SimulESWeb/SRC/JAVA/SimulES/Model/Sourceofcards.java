package SimulES.Model;

import java.util.HashSet;
import java.util.Set;

/**
Titulo: Fonte de Cartas
Objetivo: Descrever a fonte das cartas conceito e problema
Contexto:
Localização geográfica: Web
Localização temporal: Java Sourceofcards
Pre-condições: Banco de dados deve estar disponível
Pos-condições: Objeto disponível
Atores: simules
Recursos: Player online
Episódios:
1- receber objeto da camada de controle
2- conectar ao banco de dado
3- enviar objeto à base de dados
4- receber objeto da base de dados
 */
public class Sourceofcards  implements java.io.Serializable {

     private Short sourceofcardsId;
     private String description;
     private Set<Card> cards = new HashSet<Card>(0);

    public Sourceofcards() {
    }
	
    public Sourceofcards(String description) {
        this.description = description;
    }
    public Sourceofcards(String description, Set<Card> cards) {
       this.description = description;
       this.cards = cards;
    }
   
    public Short getSourceofcardsId() {
        return this.sourceofcardsId;
    }
    
    public void setSourceofcardsId(Short sourceofcardsId) {
        this.sourceofcardsId = sourceofcardsId;
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


