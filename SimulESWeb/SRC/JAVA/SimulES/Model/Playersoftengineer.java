package SimulES.Model;

/**
Titulo: Engenheiros por Jogodor
Objetivo: Descrever Os Engenheiros por Jogodor.
Contexto:
Localização geográfica: Web
Localização temporal: Java Playersoftengineer
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
public class Playersoftengineer  implements java.io.Serializable {


     private PlayersoftengineerId id;
     private Softengineer softengineer;
     private Player player;
     private String description;

    public Playersoftengineer() {
    }

    public Playersoftengineer(PlayersoftengineerId id, Softengineer softengineer, Player player, String description) {
       this.id = id;
       this.softengineer = softengineer;
       this.player = player;
       this.description = description;
    }
   
    public PlayersoftengineerId getId() {
        return this.id;
    }
    
    public void setId(PlayersoftengineerId id) {
        this.id = id;
    }
    public Softengineer getSoftengineer() {
        return this.softengineer;
    }
    
    public void setSoftengineer(Softengineer softengineer) {
        this.softengineer = softengineer;
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


