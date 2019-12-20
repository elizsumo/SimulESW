package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Aceitar Movimentos
Objetivo: Descrever as ações necessárias para aceitar movimentos.
Contexto:
Localização geográfica: Web
Localização temporal: Java AcceptmoveController
Pre-condições: Serviços web disponíveis, Jogada de conceitos em execução
Pos-condições: Informações gerais do jogo disponíveis
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Episódios:
- obter todos os movimentos aceitados
- obter movimento aceitado
- valida que jogador não aceita seu próprio movimento
- adicionar avaliação do movimento realizado
- apagar movimento


 */
public class AcceptmoveController {

    // session with Hibernate
    Session session = null;

    // constructor
    public AcceptmoveController() {

        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    // @episodio1 obter todos os movimentos aceitados
    public List getAcceptmove() {

        List<Acceptmove> moveList = null;

        try {

            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Acceptmove");

            moveList = (List<Acceptmove>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return moveList;
    }

    // @episodio2 obter movimento aceitado
    public List getAcceptMove(int moveId) {
        List<Acceptmove> acceptmoveList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Acceptmove as acceptmove where acceptmove.move.moveId='" + moveId + "')");

            acceptmoveList = (List<Acceptmove>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acceptmoveList;
    }

    /*
     * this class allows to know if the player is registered into the database
     * if he isn't then he is registered
     */
    // @episodio2  valida que jogador não aceita seu próprio movimento
    public boolean existPlayerConcept(Player player, Card card) {
        boolean bPlayerExist = false;

        List<Acceptmove> acceptmoveList = getAcceptmove();
        Iterator it = acceptmoveList.iterator();

        while (it.hasNext()) {
            Acceptmove acceptmove = (Acceptmove) it.next();
            if (acceptmove.getPlayer().equals(player) && acceptmove.getCard().equals(card)) {
                bPlayerExist = true;
            }
        }

        return bPlayerExist;
    }

    //@episodio3 adicionar avaliação do movimento realizado
    public boolean addConceptPlayer(Player player, Move move, Card card, String description) {

        boolean addReg = false;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            AcceptmoveId acceptmoveId = new AcceptmoveId();

            acceptmoveId.setMoveId(move.getMoveId());
            acceptmoveId.setPlayerId(player.getPlayerId());
            acceptmoveId.setCardId(card.getCardId());

            Acceptmove acceptmove = new Acceptmove();
            acceptmove.setId(acceptmoveId);
            acceptmove.setMove(move);
            acceptmove.setPlayer(player);
            acceptmove.setCard(card);
            acceptmove.setDescription(description);

            session.save(acceptmove);
            addReg = true;
            tx.commit();
        } catch (Exception e) {
            addReg = false;
            e.printStackTrace();
        }
        return addReg;

    }

    //@episodio4 apagar movimento
    public boolean deleteMove() {
        boolean bMoveDelete = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Acceptmove> acceptmoveList = getAcceptmove();

            Iterator it = acceptmoveList.iterator();

            while (it.hasNext()) {
                Acceptmove acceptmove = (Acceptmove) it.next();
                session.delete(acceptmove);
            }
            bMoveDelete = true;
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bMoveDelete;
    }

}
