package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador do jogador
Objetivo: Descrever as operações de controle para o jogador.
Contexto:
Localização geográfica: Web
Localização temporal: Java PlayerController
Pre-condições: Serviços web disponíveis
Pos-condições:
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
Episódios:
- criar jogador
- validar se jogador existe
- obter identificador do jogador
- obter nome do jogador
- obter jogador por nome
- obter jogador por identificador
- obter todos os jogadores
- obter quantidade de jogadores
- apagar jogadores
- obter o Maximo lançamento do dado dos jogadores
- atualizar o valor do lançamento do dado dos jogadores
- obter um rango de jogadores
- obter o ultimo jogador registrado
- obter o primeiro jogador registrado

 */
public class PlayerController {

    // session hibernate variable
    Session session = null;

    //constructor
    public PlayerController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //@episodio1 criar jogador
    public boolean createPlayer(String nickname) {

        boolean bCreate = false;
      

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
           
            Player player = new Player();
         
            player.setNickname(nickname);
            session.save(player);
            tx.commit();
            bCreate = true;
        } catch (Exception e) {
            e.printStackTrace();
            bCreate = false;
        }

        return bCreate;

    }

    //@episodio2 validar se jogador existe
    public boolean playerExist(String nickname) {
        boolean bPlayerExist = false;

        List<Player> playerList = getPlayer();
        Iterator it = playerList.iterator();

        while (it.hasNext()) {
            Player player = (Player) it.next();
            if (player.getNickname().equals(nickname)) {
                bPlayerExist = true;
            }
        }

        return bPlayerExist;
    }

    // @episodio3 obter identificador do jogador
    public short getPlayerId(String nickname) {
        short sPlayerId = 0;

        List<Player> playerList = getPlayer();
        Iterator it = playerList.iterator();

        while (it.hasNext()) {
            Player player = (Player) it.next();
            if (player.getNickname().equals(nickname)) {
                sPlayerId = player.getPlayerId();
            }
        }

        return sPlayerId;
    }

    //@episodio4 obter jogador por identificador
    public String getPlayerName(int playerID) {
        String playerName = null;

        List<Player> playerList = getPlayer();
        Iterator it = playerList.iterator();

        while (it.hasNext()) {
            Player player = (Player) it.next();
            if (player.getPlayerId().equals(playerID)) {
                playerName = player.getNickname();
            }
        }
        return playerName;
    }


    //@episodio5 obter jogador por nome
    public Player getPlayer(String nickname) {
        Player player = null;
        List<Player> playerList = getPlayer();
        Iterator it = playerList.iterator();

        while (it.hasNext()) {
            player = (Player) it.next();
            if (player.getNickname().equals(nickname)) {
                return player;
            }
        }

        return player;
    }

    //@episodio5 obter jogaodor por identificador
    public Player getPlayer(int playerId) {
        Player player = null;
        List<Player> playerList = getPlayer();
        Iterator it = playerList.iterator();

        while (it.hasNext()) {
            player = (Player) it.next();
            if (player.getPlayerId().equals((short) playerId)) {
                return player;
            }
        }

        return player;
    }

    //@episodio6 obter todos os jogadores
    public List getPlayer() {

        List<Player> playerList = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Player");

            playerList = (List<Player>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerList;
    }

    //@episodio7 obter jogador por nome
    public Player getPlayerByNicname(String nickname) {

        Player player = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Player as player where player.nickname=" + nickname);

            player = (Player) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return player;
    }

    //@episodio7 obter jogador por nome
    public Player getPlayerById(int playerId) {

        Player player = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Player as player where player.playerId=" + playerId);
            player = (Player) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return player;
    }

    //@episodio8 obter quantidade de jogadores
    public int getSizeListPlayer() {

        int size = 0;

        List<Player> playerList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Player");

            playerList = (List<Player>) q.list();

            size = playerList.size();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    //@episodio9 apagar jogadores
    public boolean deletePlayers() {
        boolean bPlayerDelete = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Player> playerList = getPlayer();

            Iterator it = playerList.iterator();

            while (it.hasNext()) {
                Player player = (Player) it.next();
                session.delete(player);
            }

            bPlayerDelete = true;

            tx.commit();

            session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bPlayerDelete;
    }

    //@episodio10 obter o maximo resultado do lancamento do dado
    public Player getMaxDicetByPlayer() {

        Player player = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Player as player where player.dice=(select Max(dice) from Player)");
            player = (Player) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return player;
    }

    //@episodio11 atualizar lancamento do dado
    public boolean updatePlayerByDice(Player play, int dice) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Player player = (Player) session.load(Player.class, play.getPlayerId());

            player.setDice(dice);
            tx.commit();
            System.out.println("Update Successfully");
            bTrans = true;
        //session.close();

        } catch (Exception e) {
            bTrans = false;
            e.printStackTrace();

        }
        return bTrans;

    }

    //@episodio11 obter um rango de jogadores
    public List getPlayerNicname(int startID, int endID) {
        List<Player> playerList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Player as player where player.playerId between '" + startID + "' and '" + endID + "'");
            playerList = (List<Player>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerList;
    }

    //@episodio12 obter o ultimo jogador registrado
    public Player getMaxIdPlayer() {

        Player player = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Player as player where player.playerId=(select Max(playerId) from Player)");
            player = (Player) q.uniqueResult();

            System.out.println("Player Name: " + player.getNickname());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return player;
    }

    //@episodio13 obter o primerio jogador registrado
    public Player getMinIdPlayer() {

        Player player = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Player as player where player.playerId=(select Min(playerId) from Player)");
            player = (Player) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return player;
    }

    //@episodio14 reiniciar o lançamento do dado
    public boolean restartRollDice() {
        boolean bRestartRollDice = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Player> playerList = getPlayer();

            Iterator it = playerList.iterator();

            while (it.hasNext()) {
                Player player = (Player) it.next();
                // int value = 0;
                player.setDice(null);
            }

            bRestartRollDice = true;
            System.out.println("Restart Successfully");
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bRestartRollDice;
    }

    //@episodio15 obter o seguinte jogador após do jogador ativo
    public Player getNextPlayer(Player actPlayer) {
        int idNextPlayer = actPlayer.getPlayerId() + 1;
        Player nextPlayer = null;
        Player maxPlayer = getMaxIdPlayer();
        Player minPlayer = getMinIdPlayer();

        try {
            //se o maximo jogador corresponde com o jogador ativo deve-se retorna o primeiro jogador
            if (maxPlayer.equals(actPlayer)) {
                return minPlayer;
            } else {
                nextPlayer = getPlayer(idNextPlayer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            nextPlayer = actPlayer;
        }
        return nextPlayer;
    }

    //@episodio12 obter o ultimo id do jogador registrado
    public int getMaxId() {
        int idPlayerMax = 0;

        Player player = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Player as player where player.playerId=(select Max(playerId) from Player)");
            player = (Player) q.uniqueResult();

            idPlayerMax = player.getPlayerId();

            System.out.println("Player Name: " + player.getNickname());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return idPlayerMax;
    }


     //@episodio14 criar a columa que mostra uma lista consecutiva na tela principal
    // nela apresenta ordenadamente os jogadores
    public boolean createListOrderToPlay() {
        boolean bRestartRollDice = false;
        int value = 0;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Player> playerList = getPlayerOrderById();

            Iterator it = playerList.iterator();

            while (it.hasNext()) {
                Player player = (Player) it.next();
                value = value+1;
                player.setOrdertoplay(value);
            }

            bRestartRollDice = true;
            System.out.println("Restart Successfully");
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bRestartRollDice;
    }

    //@episodio6 obter todos os jogadores ordenados por Id
    public List getPlayerOrderById() {

        List<Player> playerList = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Player order by  playerId");

            playerList = (List<Player>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerList;
    }
}

