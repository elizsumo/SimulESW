
package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador da relação problemas por jogador
Objetivo: Descrever as operações de controle entre o jogador e os problemas asignados.
Contexto:
Localização geográfica: Web
Localização temporal: Java PlayersproblemsController
Pre-condições: Serviços web disponíveis
Pos-condições:
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
 */
public class PlayersproblemsController {

    //session hibernate variable
    Session session = null;

    //constructor
    public PlayersproblemsController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /*
     *@episidio1 adiciona um novo problema para o jogador
     */
    public boolean addPlayerProblemCard(Player player, Card card) {

        boolean addReg = false;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            PlayersproblemsId playersproblemsId = new PlayersproblemsId();

            playersproblemsId.setCardId(card.getCardId());
            playersproblemsId.setPlayerId(player.getPlayerId());


            Playersproblems playerproblemcard = new Playersproblems();
            playerproblemcard.setId(playersproblemsId);
            playerproblemcard.setCardByCardId(card);
            playerproblemcard.setPlayer(player);

            session.save(playerproblemcard);
            addReg = true;
            tx.commit();
        } catch (Exception e) {
            addReg = false;
            e.printStackTrace();
        }

        return addReg;

    }

    //adicionamos carta conceito no tabuleiro do jogador para que ele possa usar-la
    public boolean addPlayerConceptCard(Player player, Card card) {
        boolean addReg = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            PlayersproblemsId playersproblemsId = new PlayersproblemsId();

            playersproblemsId.setCardId(card.getCardId());
            playersproblemsId.setPlayerId(player.getPlayerId());
            Playersproblems playerproblemcard = new Playersproblems();
            playerproblemcard.setId(playersproblemsId);
            playerproblemcard.setCardByCardId(card);
            playerproblemcard.setPlayer(player);
            playerproblemcard.setState(4);
            session.save(playerproblemcard);
            addReg = true;
            tx.commit();
        } catch (Exception e) {
            addReg = false;
            e.printStackTrace();
        }

        return addReg;

    }

    /*
     * @episidio2 obter os problemas de um jogador especificado
     * 
     */
    public List getCardsProblemsByPlayer(int idPlayer) {
        List<Card> cardList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Card as card where card.cardId in (select playersproblems.cardByCardId.cardId from Playersproblems as playersproblems where playersproblems.state=0 and playersproblems.player.playerId='" + idPlayer + "')");

            cardList = (List<Card>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }

    /*
     *@episidio3 obter todos os problemas por jogador em estado submetido
     */
    public List getAllCardsProblemsSubmit() {
        List<Playersproblems> playersproblemsList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Playersproblems as playersproblems where playersproblems.state=1)");

            playersproblemsList = (List<Playersproblems>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playersproblemsList;
    }


    /*
     * @episidio4 atualiza o campo da observacao nos problemas de um jogador
     *
     */
    public boolean updateObsCardsProblems(Card card, String observation) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Playersproblems problemCard = getCardProblems(card);

            Playersproblems playerProblem = (Playersproblems) session.load(Playersproblems.class, problemCard.getId());

            playerProblem.setObservation(observation);
            playerProblem.setState(1);

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

     /*
     * @episidio5 atualiza o campo tratamento nos problemas de um jogador
     *
     */
    public boolean acceptProblemTreated(Card cardProblem, Card cardTreatment) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Playersproblems problemCard = getCardProblems(cardProblem);

            Playersproblems playerProblem = (Playersproblems) session.load(Playersproblems.class, problemCard.getId());

            playerProblem.setState(2);

            tx.commit();
            System.out.println("Update Successfully");

            PlayerCardController playerCardController = new PlayerCardController();

            if (playerCardController.deletePlayerCard(cardTreatment)) {
                bTrans = true;
            }

        } catch (Exception e) {
            bTrans = false;
            e.printStackTrace();

        }
        return bTrans;

    }

     /*
     * @episidio6 quando o tratamento a um problema tratado é aceito
     *
     */
    public boolean acceptProblemTreated(Card cardProblem) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Playersproblems problemCard = getCardProblems(cardProblem);

            Playersproblems playerProblem = (Playersproblems) session.load(Playersproblems.class, problemCard.getId());

            playerProblem.setState(2);

            tx.commit();
            System.out.println("Update Successfully");

            PlayerCardController playerCardController = new PlayerCardController();

            bTrans = true;

        } catch (Exception e) {
            bTrans = false;
            e.printStackTrace();

        }
        return bTrans;

    }

    /*
     * @episidio quando o tratamento a um problema tratado é aceito e enviado o objeto problembyplayer
     *
     */
    public boolean acceptProblemTreated(Playersproblems problemCard) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

           Playersproblems playerProblem = (Playersproblems) session.load(Playersproblems.class, problemCard.getId());

            playerProblem.setState(2);

            tx.commit();
            System.out.println("Update Successfully");

            PlayerCardController playerCardController = new PlayerCardController();

            bTrans = true;

        } catch (Exception e) {
            bTrans = false;
            e.printStackTrace();

        }
        return bTrans;

    }

     /*
     * @episidio7 quando o tratamento a um problema tratado é rejeitado e é enviado o objeto problembyplayer
     *
     */
    public boolean rejectProblemTreated(Card card) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Playersproblems problemCard = getCardProblems(card);

            Playersproblems playerProblem = (Playersproblems) session.load(Playersproblems.class, problemCard.getId());

            playerProblem.setState(0);
            playerProblem.setCardByCardTreatment(null);
            playerProblem.setObservation("");

            tx.commit();
            System.out.println("Update Successfully");
            bTrans = true;

        } catch (Exception e) {
            bTrans = false;
            e.printStackTrace();

        }
        return bTrans;

    }

    /*
     * @episidio7 quando o tratamento a um problema tratado é rejeitado
     *
     */
     public boolean rejectProblemTreated(Playersproblems problemCard) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Playersproblems playerProblem = (Playersproblems) session.load(Playersproblems.class, problemCard.getId());

            playerProblem.setState(0);
            playerProblem.setCardByCardTreatment(null);
            playerProblem.setObservation("");

            tx.commit();
            System.out.println("Update Successfully");
            bTrans = true;

        } catch (Exception e) {
            bTrans = false;
            e.printStackTrace();

        }
        return bTrans;

    }


    /*
     * @episidio7 jogador da tratamento a problema
     *
     */
    public boolean updateTreatmentCardsProblems(Card card, Card cardTreatment) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Playersproblems problemCard = getCardProblems(card);
            Playersproblems playerProblem = (Playersproblems) session.load(Playersproblems.class, problemCard.getId());
            playerProblem.setCardByCardTreatment(cardTreatment);
            playerProblem.setState(1);

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

    /*
     * @episidio8 obter numa lista os problemas por jogador do jogo
     *
     */
       public List getCardsProblemsList() {

        List<Playersproblems> playersProblemsList = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Playersproblems");

            playersProblemsList = (List<Playersproblems>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playersProblemsList;
    }


     /*
     * @episidio9 obter o objeto especifico em problemas por jogador
     *
     */
    public Playersproblems getCardProblems(Card card) {

        Playersproblems cardProblem = null;
        List<Playersproblems> playersproblemsList = getCardsProblemsList();
        Iterator it = playersproblemsList.iterator();

        while (it.hasNext()) {
            cardProblem = (Playersproblems) it.next();
            if (cardProblem.getCardByCardId().equals(card)) {
                return cardProblem;
            }
        }
        return cardProblem;
    }

    /*
     * @episidio10 apagar todos os problemas por jogador na jogada
     */
      public boolean deletePlayersProblems() {
        boolean bDelete = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Playersproblems> playerProblemsList = getCardsProblemsList();

            Iterator it = playerProblemsList.iterator();

            while (it.hasNext()) {
                Playersproblems playerproblem = (Playersproblems) it.next();
                session.delete(playerproblem);
            }

            bDelete = true;

            tx.commit();

            session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bDelete;
    }

       /*
     * @episidio11 obter as cartas conceito usadas pelo jogador
     */
      public List getCardsConceptUsedByPlayer(int idPlayer) {
        List<Card> cardList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Card as card where card.cardId in (select playersproblems.cardByCardId.cardId from Playersproblems as playersproblems where playersproblems.state=4 and playersproblems.player.playerId='" + idPlayer + "')");

            cardList = (List<Card>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }
}
