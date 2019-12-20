package SimulES.Model;


/**
Titulo: Tabuleiro Individual
Objetivo: Descrever as operações para obter o tabuleiro individual.
Contexto:
Localização geográfica: Web
Localização temporal: Java Individualboard
Pre-condições: Banco de dados deve estar disponível
Pos-condições: Objeto disponível
Atores: simules
 */
public class Individualboard implements java.io.Serializable {


    //Recursos: Tabuleiro Individual (jogador, configuração)
    private short player;
    private String configuration;
    private short update_board;

    public Individualboard() {
    }

    //episodio1 receber objeto da camada de controle
    public Individualboard(short player, String configuration) {
        this.player = player;
        this.configuration = configuration;
    }

    //episodio2 enviar objeto à base de dados
    public void setPlayer(short player) {
        this.player = player;
    }
     public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
     //episodio3 receber objeto da base de dados
    public String getConfiguration() {
        return this.configuration;
    }
    public short getPlayer() {
        return this.player;
    }
    public void setUpdate_board(short update_board) {
        this.update_board = update_board;
    }
    public short getUpdate_board() {
        return this.update_board;
    }
}


