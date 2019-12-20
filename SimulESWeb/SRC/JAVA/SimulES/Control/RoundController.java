package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador de rondas do jogo
Objetivo: Descrever as operações de controle das rondas do jogo.
Contexto:
Localização geográfica: Web
Localização temporal: Java RoundController
Pre-condições: Serviços web disponíveis, fechar a
 * entrada de jogadores já executada
Pos-condições: rondas do jogo controladas pelo SimulES
Atores: jogador, simules
Recursos: informações do projeto,
 * informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
 */
public class RoundController {

    // session with Hibernate
    Session session = null;

    // constructor
    public RoundController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //@episodio obter todas as rondas do jogo
    public List getRounds() {
        List<Round> roundList = null;
        try {
            if (!this.session.isOpen()) {
                this.session =
                        HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Round");
            roundList = (List<Round>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roundList;
    }

    //@episodio obter a ronda ativa
    public Round getActiveRound() {
       Round round = null;
        try {
            if (!this.session.isOpen()) {
                this.session =
                        HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Round as round where round.state ='A'");
            //Query q = session.createQuery("from Round as round where round.roundId=2");
           round = (Round) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return round;
    }


    //@episodio reiniciar todas as rondas do jogo
    public boolean restartRounds() {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session =
                        HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Round> roundList = getRounds();

            Iterator it = roundList.iterator();

            while (it.hasNext()) {
                Round round = (Round) it.next();
                round.setState("I");
            }
            bTrans = true;
            System.out.println("Restart Successfully");
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bTrans;
    }

    //@episodio fechar uma ronda especifica
     public boolean closeRound(int roundId) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session =
                        HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Round round = getRound(roundId);
            session.load(Round.class, round.getRoundId());
            round.setState("E");
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

     //@episodio obter uma ronda especifica
     public Round getRound(int roundId) {
        Round round = null;
        try {
            if (!this.session.isOpen()) {
                this.session =
                        HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery
                ("from Round as round where round.roundId='" + roundId + "')");
            round = (Round) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return round;
    }


     //@episodio habilitar a seguinte ronda
      public boolean enableNextRound(int roundId) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session =
                        HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Round round = getRound(roundId);
            session.load(Round.class, round.getRoundId());
            round.setState("A");
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
