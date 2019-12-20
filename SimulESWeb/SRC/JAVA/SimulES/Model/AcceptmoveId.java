package SimulES.Model;

/**
Titulo: Aceitar movimentoId
Objetivo: Descrever o id objeto aceitar movimento.
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
public class AcceptmoveId  implements java.io.Serializable {


     private short playerId;
     private short moveId;
     private short cardId;

    public AcceptmoveId() {
    }

    public AcceptmoveId(short playerId, short moveId, short cardId) {
       this.playerId = playerId;
       this.moveId = moveId;
       this.cardId = cardId;
    }
   
    public short getPlayerId() {
        return this.playerId;
    }
    
    public void setPlayerId(short playerId) {
        this.playerId = playerId;
    }
    public short getMoveId() {
        return this.moveId;
    }
    
    public void setMoveId(short moveId) {
        this.moveId = moveId;
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
		 if ( !(other instanceof AcceptmoveId) ) return false;
		 AcceptmoveId castOther = ( AcceptmoveId ) other; 
         
		 return (this.getPlayerId()==castOther.getPlayerId())
 && (this.getMoveId()==castOther.getMoveId())
 && (this.getCardId()==castOther.getCardId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPlayerId();
         result = 37 * result + this.getMoveId();
         result = 37 * result + this.getCardId();
         return result;
   }   


}


