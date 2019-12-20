
package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador de cartas por jogador
Objetivo: Descrever as operações de controle em nos módulos do projeto.
Contexto:
Localização geográfica: Web
Localização temporal: Java PlayerCardController
Pre-condições: Serviços web disponíveis
Pos-condições:
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
Episódios:
-  obter todas as cartas por jogador
-  apagar todas as cartas por jogador
-  adicionar cartas para um jogador
-  obter cartas de um jogador especifico
-  obter as cartas problemas submetidas a um jogador especifico
-  obter as cartas problemas do jogador
- obter as cartas conceito por jogador
- apagar uma carta especifica
- obter cartas por jogador

 */
public class PlayerCardController {

    Session session = null;

    // constructor
    public PlayerCardController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    // @episode1 get all cards by player on-line
    public List getPlayerCard() {

        List<Playercard> playerCardList = null;

        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Playercard");

            playerCardList = (List<Playercard>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerCardList;
    }

    //@episodie2 delete all record related to cards by player
    public boolean deletePlayerCard() {
        boolean bPlayerCardDelete = false;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Playercard> playerCardList = getPlayerCard();

            Iterator it = playerCardList.iterator();

            while (it.hasNext()) {

                Playercard playerCard = (Playercard) it.next();
                session.delete(playerCard);
            }

            bPlayerCardDelete = true;

            tx.commit();

            session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bPlayerCardDelete;
    }

  //@episodio3 adicionar cartas para um jogador
    public boolean addPlayerCard(Player player, SimulES.Model.Card card) {

        boolean addReg = false;

        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            PlayercardId pse = new PlayercardId();
            pse.setPlayerId(player.getPlayerId());
            pse.setCardId(card.getCardId());

            Playercard playercard = new Playercard();
            playercard.setId(pse);
            playercard.setPlayer(player);

            playercard.setCard(card);
            playercard.setDescription("Test");

            session.save(playercard);
            addReg = true;
            tx.commit();
        } catch (Exception e) {
            addReg = false;
            e.printStackTrace();

        }

        return addReg;

    }

 //@episodio4 obter cartas de um jogador especifico
    public List getCardsByPlayer(int idPlayer) {
        List<Card> cardList = null;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Card as card where card.cardId in (select playerCard.card.cardId from Playercard as playerCard where playerCard.player.playerId='" + idPlayer + "')");

            cardList = (List<Card>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }

 
    //@episodio5 obter as cartas problemas submetidas a um jogador especifico
    public List getCardsProByPlayerToSubmit(int idPlayer) {
        List<Card> cardList = null;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Card as card where card.cardtype=2 and card.cardId in (select playerCard.card.cardId from Playercard as playerCard where playerCard.player.playerId='" + idPlayer + "')");

            cardList = (List<Card>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }


    //@validamos a existencia da carta na tabela relação
     public boolean existCard(int idCard) {
        List<Card> cardList = null;
       boolean valueReturn = false;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Card as card where card.cardId in (select playerCard.card.cardId from Playercard as playerCard where playerCard.card.cardId='" + idCard + "')");

            cardList = (List<Card>) q.list();

            if (q.list().size() > 0) {
                valueReturn = true;

                session.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return valueReturn;
    }

   //@episodio6 obter as cartas problemas do jogador
    public List getCardsProblemsByPlayer(int idPlayer) {
        List<Card> cardList = null;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            // Query q = session.createQuery("from Card as card where card.cardtype=1 and card.cardId in (select playerCard.card.cardId from Playercard as playerCard where playerCard.player.playerId='" + idPlayer + "')");

            //Query q = session.createQuery("from Card as card");

            Query q = session.createQuery("from Card as card where card.cardtype=2 and card.cardId in (select playerCard.card.cardId from Playercard as playerCard where playerCard.player.playerId='" + idPlayer + "')");

            cardList = (List<Card>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }

     //@episodio7 obter as cartas conceito por jogador
    public List getCardsConceptByPlayer(int idPlayer) {
        List<Card> cardList = null;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Card as card where card.cardtype=1 and card.cardId in (select playerCard.card.cardId from Playercard as playerCard where playerCard.player.playerId='" + idPlayer + "')");

            cardList = (List<Card>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }


   //@episodio8 apagar uma carta especifica
    public boolean deletePlayerCard(Card card) {
        boolean bPlayerCardDelete = false;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();

            Playercard playercard = getPlayerCard(card);

           // Playercard pc  = (Playercard) session.load(Playercard.class, playercard.getId());

            int id = playercard.getCard().getCardId();

             System.out.println("Id card Deleted is: " + id);

            session.delete(playercard);
            
            System.out.println("Deleted Successfully");

            bPlayerCardDelete = true;

            tx.commit();



        } catch (Exception e) {
            e.printStackTrace();
        }
        return bPlayerCardDelete;
    }


    //@episodio8 apagar uma carta especifica
    public boolean deletePlayerCard(int cardId) {
        boolean bPlayerCardDelete = false;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();

            Playercard playercard = getPlayerCardtoDelete(cardId);

           // Playercard pc  = (Playercard) session.load(Playercard.class, playercard.getId());

            int id = playercard.getCard().getCardId();

             System.out.println("Id card Deleted is: " + id);

            session.delete(playercard);

            System.out.println("Deleted Successfully");

            bPlayerCardDelete = true;

            tx.commit();



        } catch (Exception e) {
            e.printStackTrace();
        }
        return bPlayerCardDelete;
    }

    //@episodio9 obter cartas por jogador
    public Playercard getPlayerCard(Card card) {


        Playercard playercard = null;
        List<Playercard> playerCardList = getPlayerCard();
        Iterator it = playerCardList.iterator();

        while (it.hasNext()) {
            playercard = (Playercard) it.next();
            if (playercard.getCard().equals(card)) {
                 System.out.println("Card found");
                return playercard;
            }
        }
        return playercard;
    }


     // @episode1 get all cards by player on-line
    public Playercard getPlayerCardtoDelete(int idCard) {

       Playercard playercard = null;

        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Playercard as playercard where playercard.card.cardId='" + idCard + "')");

              playercard = (Playercard) q.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playercard;
    }



}
