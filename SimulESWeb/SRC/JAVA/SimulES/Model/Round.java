package SimulES.Model;

import java.util.HashSet;
import java.util.Set;

/**
Titulo: Ronda
Objetivo: Descrever o objeto ronda
Contexto:
Localização geográfica: Web
Localização temporal: Java Round
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
public class Round  implements java.io.Serializable {


     private short roundId;
     private String description;
     private String state;
     private Set<Move> moves = new HashSet<Move>(0);

    public Round() {
    }

	
    public Round(short roundId, String description, String state) {
        this.roundId = roundId;
        this.description = description;
        this.state = state;
    }
    public Round(short roundId, String description, String state, Set<Move> moves) {
       this.roundId = roundId;
       this.description = description;
       this.state = state;
       this.moves = moves;
    }
   
    public short getRoundId() {
        return this.roundId;
    }
    
    public void setRoundId(short roundId) {
        this.roundId = roundId;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public Set<Move> getMoves() {
        return this.moves;
    }
    
    public void setMoves(Set<Move> moves) {
        this.moves = moves;
    }




}


