package SimulES.Model;

/**
Titulo: Carta por jogador
Objetivo: Descrever a relação entre jogador e suas cartas.
Contexto:
Localização geográfica: Web
Localização temporal: Java Playercard
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
public class Playercard  implements java.io.Serializable {


     private PlayercardId id;
     private Card card;
     private Player player;
     private String description;

    public Playercard() {
    }

	
    public Playercard(PlayercardId id, Card card, Player player) {
        this.id = id;
        this.card = card;
        this.player = player;
    }
    public Playercard(PlayercardId id, Card card, Player player, String description) {
       this.id = id;
       this.card = card;
       this.player = player;
       this.description = description;
    }
   
    public PlayercardId getId() {
        return this.id;
    }
    
    public void setId(PlayercardId id) {
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
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


