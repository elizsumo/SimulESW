
package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 Titulo: Controlador de movimentos no jogo
Objetivo: Descrever as operações de controle em nos módulos do projeto.
Contexto:
Localização geográfica: Web
Localização temporal: Java MoveController
Pre-condições: Serviços web disponíveis, rodada de conceitos em execução
Pos-condições:
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
Episódios:
- obter todos os movimentos
- atualizar o movimento para o jogador
- atualizar o próximo movimento
- obter um movimento especifico
- obter o movimento ativo no sistema
- obter o mínimo movimento ativo no sistema
- reiniciar os movimentos
- obter o primeiro movimento no sistema
- fechar um movimento
- habilitar o próximo movimento
- habilitar próximo movimento para o jogador
 */
public class MoveController {

    // session hibernate variable
    Session session = null;

    //constructor
    public MoveController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    // @episodio1 obter todos os movimentos
    public List getMovements() {
        List<Move> movementsList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Move");
            movementsList = (List<Move>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movementsList;
    }

    //@episodio2 atualizar o movimento para o jogador
    public boolean updatePlayerByMove(Player player, int moveId) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Move move = getMove(moveId);
            session.load(Move.class, move.getMoveId());
            move.setPlayer(player);
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

    //@episodio3 atualizar o próximo jogador que vai fazer o movimento movimento
    public boolean updateNextPlayerToMove() {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            PlayerController playerController = new PlayerController();

            Move move = getMinMoveActive();

            Player playerLastmove = move.getPlayer();

            Short idPlayer = playerLastmove.getPlayerId();

            Player player = playerController.getPlayer(idPlayer + 1);

            session.load(Move.class, move.getMoveId());
            move.setPlayer(player);

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

    //@episodio4 obter um movimento especifico
    public Move getMove(int moveId) {
        Move move = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Move as move where move.moveId='" + moveId + "')");
            move = (Move) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return move;
    }

    //@episodio5 obter o movimento ativo no sistema
    public Move getMoveActive() {
        Move move = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Move as move where move.state='A'");
            move = (Move) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return move;
    }

   //@episodio6 obter o primeiro movimento no sistema
    public Move getMinMoveActive() {

        Move move = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

             Query q = session.createQuery("from Move as move where move.moveId=(select Min(move1.moveId) from Move as move1 where move1.state='A')" );

           // Query q = session.createQuery("select Min(move1.moveId) from Move as move1 where move1.state='A'");

             move = (Move) q.uniqueResult();

           //int imove = Integer.parseInt(q.uniqueResult().toString());

            System.out.println("Move Id es: " + move.getMoveId());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return move;
    }

    //@episodio7 reiniciar os movimentos
    public boolean restartMove() {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Move> moveList = getMovements();

            Iterator it = moveList.iterator();

            while (it.hasNext()) {
                Move move = (Move) it.next();
                move.setPlayer(null);
                move.setState("I");
            }
            bTrans = true;
            System.out.println("Restart Successfully");
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bTrans;
    }

    //@episodio8 obter o primeiro movimento no sistema
    public boolean firstMoveToStartGame() {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Move move = getMove(1);
            session.load(Move.class, move.getMoveId());
            move.setState("A");
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

    //@episodio9 fechar um movimento
    public boolean closeMove(int moveId) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Move move = getMove(moveId);
            session.load(Move.class, move.getMoveId());
            move.setState("E");
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

    //@episodio10 habilitar o próximo movimento
    public boolean enableNextMove(int moveId) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            PlayerController playercontroller = new PlayerController();
            Player player = playercontroller.getMinIdPlayer();

            org.hibernate.Transaction tx = session.beginTransaction();
            Move move = getMove(moveId);
            session.load(Move.class, move.getMoveId());
            move.setState("A");
            move.setPlayer(player);
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

    //@episodio11  habilitar próximo movimento para o jogador
    public boolean enableMoveToPlayer(int moveId, Player player) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();
            Move move = getMove(moveId);
            session.load(Move.class, move.getMoveId());
            move.setState("A");
            move.setPlayer(player);
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

     //@episodio3 abilita o primeiro jogador
    public boolean enableMinPlayerToMove(int idMove) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            PlayerController playerController = new PlayerController();

            Move move = getMove(idMove);

            Player player = playerController.getMinIdPlayer();

            session.load(Move.class, move.getMoveId());
            move.setPlayer(player);

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
}
