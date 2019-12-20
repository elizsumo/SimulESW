package SimulES.Model;

/**
Titulo: Id de Engenheiros por Jogodor
Objetivo: Descrever Id de Engenheiros por Jogodor.
Contexto:
Localização geográfica: Web
Localização temporal: Java PlayersoftengineerId
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
public class PlayersoftengineerId  implements java.io.Serializable {


     private short playerId;
     private short softengineerId;

    public PlayersoftengineerId() {
    }

    public PlayersoftengineerId(short playerId, short softengineerId) {
       this.playerId = playerId;
       this.softengineerId = softengineerId;
    }
   
    public short getPlayerId() {
        return this.playerId;
    }
    
    public void setPlayerId(short playerId) {
        this.playerId = playerId;
    }
    public short getSoftengineerId() {
        return this.softengineerId;
    }
    
    public void setSoftengineerId(short softengineerId) {
        this.softengineerId = softengineerId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PlayersoftengineerId) ) return false;
		 PlayersoftengineerId castOther = ( PlayersoftengineerId ) other; 
         
		 return (this.getPlayerId()==castOther.getPlayerId())
 && (this.getSoftengineerId()==castOther.getSoftengineerId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPlayerId();
         result = 37 * result + this.getSoftengineerId();
         return result;
   }   


}


