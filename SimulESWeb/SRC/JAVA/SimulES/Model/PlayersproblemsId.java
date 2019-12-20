package SimulES.Model;

/**
Titulo: Problemas por jogador
Objetivo: Descrever o objeto problemas por jogador
Contexto:
Localização geográfica: Web
Localização temporal: Java PlayersproblemsId
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
public class PlayersproblemsId  implements java.io.Serializable {


     private short playerId;
     private short cardId;

    public PlayersproblemsId() {
    }

    public PlayersproblemsId(short playerId, short cardId) {
       this.playerId = playerId;
       this.cardId = cardId;
    }
   
    public short getPlayerId() {
        return this.playerId;
    }
    
    public void setPlayerId(short playerId) {
        this.playerId = playerId;
    }
    public short getCardId() {
        return this.cardId;
    }
    
    public void setCardId(short cardId) {
        this.cardId = cardId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PlayersproblemsId) ) return false;
		 PlayersproblemsId castOther = ( PlayersproblemsId ) other; 
         
		 return (this.getPlayerId()==castOther.getPlayerId())
 && (this.getCardId()==castOther.getCardId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPlayerId();
         result = 37 * result + this.getCardId();
         return result;
   }   


}


