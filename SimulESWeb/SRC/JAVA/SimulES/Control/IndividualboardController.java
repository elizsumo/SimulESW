package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador de tabuleiro individual
Objetivo: Descrever as operações de controle no tabuleiro individual.
Contexto:
Localização geográfica: Web
Localização temporal: Java IndividualboardController
Pre-condições: Serviços web disponíveis, rodada de ações em execução
Pos-condições: Atualizar o tabuleiro individual do jogador.
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
Episódios:
-  criar o tabuleiro individual para o jogador
-  obter os tabuleiros individuais dos jogador
- obter a configuração do tabuleiro individual do jogador
- validar se jogador esta registrado no jogo para disponibilizar
- atualiza a configuração do tabuleiro do jogador
-  obter o tabuleiro individual por jogador
-  apaga os tabuleiros individuais dos jogadores
- Atualiza status da board do jogador
- Obter status da board do jogador

 */
public class IndividualboardController {

    // session hibernate variable
    Session session = null;

    //constructor
    public IndividualboardController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //@episodio1 criar o tabuleiro individual para o jogador
    public boolean createPlayer(int player, String configuration, int updateBoard) {
        boolean bCreate = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Individualboard individualboard = new Individualboard();
            individualboard.setPlayer((short) player);
            individualboard.setConfiguration(configuration);
            individualboard.setUpdate_board((short) updateBoard);
            session.save(individualboard);
            tx.commit();
            bCreate = true;
            if (updateBoard != 0) {
                this.updateBoard();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bCreate = false;
        }
        return bCreate;
    }

    //@episodio2 obter os tabuleiros individuais dos jogador
    public String getPlayerConfiguration(int player) {

        if (this.session.isOpen()) {
            this.session.clear();
            this.session.close();
        }


        this.session = HibernateUtil.getSessionFactory().getCurrentSession();

        short idPlayer = (short) player;
        String configuration = null;

        List<Individualboard> individualboardList = getIndividualboard();
        Iterator it = individualboardList.iterator();

        while (it.hasNext()) {
            Individualboard individualboard = (Individualboard) it.next();
            if (individualboard.getPlayer() == idPlayer) {
                configuration = individualboard.getConfiguration();
            }
        }

        return configuration;
    }


    //@episodio3  obter a configuração do tabuleiro individual do jogador
    public List getIndividualboard() {

        List<Individualboard> individualboardList = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Individualboard");

            individualboardList = (List<Individualboard>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return individualboardList;
    }

    //@episodio4 validar se jogador esta registrado no jogo para disponibilizar
    public boolean playerExist(int player) {
        boolean isPlayer = false;
        short idPlayer = (short) player;
        String configuration = null;

        List<Individualboard> individualboardList = getIndividualboard();
        Iterator it = individualboardList.iterator();

        while (it.hasNext()) {
            Individualboard individualboard = (Individualboard) it.next();
            if (individualboard.getPlayer() == idPlayer) {
                isPlayer = true;
            }
        }
        return isPlayer;
    }

    //@episodio5 atualiza a configuração do tabuleiro do jogador
    public boolean updateConfigurationByPlayer(int playerId, String configuration, int updateBoard) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Individualboard indBoard = null;

            indBoard = getIndividualBoard(playerId);

            Individualboard individualboard = (Individualboard) session.load(Individualboard.class, indBoard.getPlayer());
            // Check if configuration is equal or different from the constant "NoUpdateConfig"
            if (!configuration.equals("NoUpdateConfig")) {
                individualboard.setConfiguration(configuration);
            }
            individualboard.setUpdate_board((short) updateBoard);
            tx.commit();
            System.out.println("Update Successfully");
            bTrans = true;
            //session.close();
            if (updateBoard != 0) {
                this.updateBoard();
            }


        } catch (Exception e) {
            bTrans = false;
            e.printStackTrace();

        }
        return bTrans;

    }

    //@episodio5 atualiza a configuração do tabuleiro do jogador
    //sobrecarga do metodo anterior o qual é usado quando o jogador submete seu tabuleiro para finalizar o jogo
    public boolean updateConfigurationByPlayer(int playerId, String configuration) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Individualboard indBoard = null;

            indBoard = getIndividualBoard(playerId);

            Individualboard individualboard = (Individualboard) session.load(Individualboard.class, indBoard.getPlayer());
            individualboard.setConfiguration(configuration);
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

    //@episodio6 obter o tabuleiro individual por jogador
    public Individualboard getIndividualBoard(int player) {

        Individualboard individualboard = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Individualboard as individualboard where individualboard.player='" + player + "')");
            individualboard = (Individualboard) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return individualboard;
    }

    //@episodio7 apaga os tabuleiros individuais dos jogadores
    public boolean deleteIndividualboard() {
        boolean bIndividualboardDelete = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Individualboard> individualboardList = getIndividualboard();

            Iterator it = individualboardList.iterator();

            while (it.hasNext()) {
                Individualboard individualboard = (Individualboard) it.next();
                session.delete(individualboard);
            }

            bIndividualboardDelete = true;

            tx.commit();

            session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bIndividualboardDelete;
    }


    //@episodio 8 Atualiza status da board do jogador
    public boolean updateBoard() {
        boolean bIndividualboardDelete = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Individualboard> individualboardList = getIndividualboard();

            Iterator it = individualboardList.iterator();

            while (it.hasNext()) {
                Individualboard individualboard = (Individualboard) it.next();
                individualboard.setUpdate_board((short) 1);
                session.save(individualboard);
            }

            bIndividualboardDelete = true;

            tx.commit();

            session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bIndividualboardDelete;
    }

    //@episodio 9 Obter status da board do jogador
    public int getPlayerUpdateBoard(int player) {
        if (this.session.isOpen()) {
            this.session.clear();
            this.session.close();
        }
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();

        short idPlayer = (short) player;
        int update_board = 2;

        List<Individualboard> individualboardList = getIndividualboard();
        Iterator it = individualboardList.iterator();

        while (it.hasNext()) {
            Individualboard individualboard = (Individualboard) it.next();
            if (individualboard.getPlayer() == idPlayer) {
                update_board = (int) individualboard.getUpdate_board();
            }
        }

        return update_board;
    }

    //@episodio10 limpa o tabuleiro individual do jogador
     //@episodio5 atualiza a configuração do tabuleiro do jogador
    public boolean cleanConfigurationByPlayer(int playerId, int updateBoard) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Individualboard indBoard = null;

            indBoard = getIndividualBoard(playerId);

            Individualboard individualboard = (Individualboard) session.load(Individualboard.class, indBoard.getPlayer());
            // Check if configuration is equal or different from the constant "NoUpdateConfig"

            individualboard.setConfiguration(null);

            individualboard.setUpdate_board( (short) updateBoard );
            tx.commit();
            System.out.println("Update Successfully");
            bTrans = true;
        //session.close();
            if (updateBoard != 0) {
                this.updateBoard();
            }


        } catch (Exception e) {
            bTrans = false;
            e.printStackTrace();

        }
        return bTrans;

    }
}
