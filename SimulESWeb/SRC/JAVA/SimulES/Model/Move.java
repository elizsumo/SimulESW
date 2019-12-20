package SimulES.Model;

import java.util.HashSet;
import java.util.Set;

/**
Titulo: movimento
Objetivo: Descrever o objeto movimento.
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
public class Move  implements java.io.Serializable {


     private Short moveId;
     private Player player;
     private Round round;
     private String description;
     private String precondition;
     private String state;
     private Set<Acceptmove> acceptmoves = new HashSet<Acceptmove>(0);

    public Move() {
    }

	
    public Move(Round round, String description, String state) {
        this.round = round;
        this.description = description;
        this.state = state;
    }
    public Move(Player player, Round round, String description, String precondition, String state, Set<Acceptmove> acceptmoves) {
       this.player = player;
       this.round = round;
       this.description = description;
       this.precondition = precondition;
       this.state = state;
       this.acceptmoves = acceptmoves;
    }
   
    public Short getMoveId() {
        return this.moveId;
    }
    
    public void setMoveId(Short moveId) {
        this.moveId = moveId;
    }
    public Player getPlayer() {
        return this.player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Round getRound() {
        return this.round;
    }
    
    public void setRound(Round round) {
        this.round = round;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrecondition() {
        return this.precondition;
    }
    
    public void setPrecondition(String precondition) {
        this.precondition = precondition;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public Set<Acceptmove> getAcceptmoves() {
        return this.acceptmoves;
    }
    
    public void setAcceptmoves(Set<Acceptmove> acceptmoves) {
        this.acceptmoves = acceptmoves;
    }




}


