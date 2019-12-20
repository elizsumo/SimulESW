package SimulES.Model;

/**
Titulo: Aceitar movimento
Objetivo: Descrever o objeto aceitar movimento.
Contexto:
Localização geográfica: Web
Localização temporal: Java Acceptmove
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
public class Acceptmove  implements java.io.Serializable {


     private AcceptmoveId id;
     private Card card;
     private Player player;
     private Move move;
     private String description;

    public Acceptmove() {
    }

    public Acceptmove(AcceptmoveId id, Card card, Player player, Move move, String description) {
       this.id = id;
       this.card = card;
       this.player = player;
       this.move = move;
       this.description = description;
    }
   
    public AcceptmoveId getId() {
        return this.id;
    }
    
    public void setId(AcceptmoveId id) {
        this.id = id;
    }
    public Card getCard() {
        return this.card;
    }
    
    public void setCard(Card card) {
        this.card = card;
    }
    public Player getPlayer() {
        return this.player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Move getMove() {
        return this.move;
    }
    
    public void setMove(Move move) {
        this.move = move;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


}


