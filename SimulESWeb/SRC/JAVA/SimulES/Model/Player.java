package SimulES.Model;

import java.util.HashSet;
import java.util.Set;

/**
Titulo: Jogador
Objetivo: Descrever o objeto Jogador.
Contexto:
Localização geográfica: Web
Localização temporal: Java Acceptmove
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
public class Player  implements java.io.Serializable {


     private Short playerId;
     private String nickname;
     private Integer dice;
     private Integer ordertoplay;

    public Player() {
    }


    public Player(String nickname) {
        this.nickname = nickname;
    }
    public Player(String nickname, Integer dice, Integer ordertoplay) {
       this.nickname = nickname;
       this.dice = dice;
       this.ordertoplay = ordertoplay;
    }

    public Short getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(Short playerId) {
        this.playerId = playerId;
    }
    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Integer getDice() {
        return this.dice;
    }

    public void setDice(Integer dice) {
        this.dice = dice;
    }
    public Integer getOrdertoplay() {
        return this.ordertoplay;
    }

    public void setOrdertoplay(Integer ordertoplay) {
        this.ordertoplay = ordertoplay;
    }




}


