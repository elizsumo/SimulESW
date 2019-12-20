package SimulES.Model;

/**
Titulo: Problemas por jogador
Objetivo: Descrever o objeto problemas por jogador
Contexto:
Localização geográfica: Web
Localização temporal: Java Playersproblems
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
public class Playersproblems  implements java.io.Serializable {


     private PlayersproblemsId id;
     private Card cardByCardId;
     private Player player;
     private Card cardByCardTreatment;
     private int state;
     private String observation;

    public Playersproblems() {
    }

	
    public Playersproblems(PlayersproblemsId id, Card cardByCardId, Player player, int state) {
        this.id = id;
        this.cardByCardId = cardByCardId;
        this.player = player;
        this.state = state;
    }
    public Playersproblems(PlayersproblemsId id, Card cardByCardId, Player player, Card cardByCardTreatment, int state, String observation) {
       this.id = id;
       this.cardByCardId = cardByCardId;
       this.player = player;
       this.cardByCardTreatment = cardByCardTreatment;
       this.state = state;
       this.observation = observation;
    }
   
    public PlayersproblemsId getId() {
        return this.id;
    }
    
    public void setId(PlayersproblemsId id) {
        this.id = id;
    }
    public Card getCardByCardId() {
        return this.cardByCardId;
    }
    
    public void setCardByCardId(Card cardByCardId) {
        this.cardByCardId = cardByCardId;
    }
    public Player getPlayer() {
        return this.player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Card getCardByCardTreatment() {
        return this.cardByCardTreatment;
    }
    
    public void setCardByCardTreatment(Card cardByCardTreatment) {
        this.cardByCardTreatment = cardByCardTreatment;
    }
    public int getState() {
        return this.state;
    }
    
    public void setState(int state) {
        this.state = state;
    }
    public String getObservation() {
        return this.observation;
    }
    
    public void setObservation(String observation) {
        this.observation = observation;
    }




}


