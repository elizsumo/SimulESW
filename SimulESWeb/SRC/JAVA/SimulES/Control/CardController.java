
package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador de cartas
Objetivo: Descrever as operações de controle nas cartas.
Contexto:
Localização geográfica: Web
Localização temporal: Java CardController
Pre-condições: Serviços web disponíveis, rodada de inicio já foi executada
Pos-condições: Atualizar estado das cartas no jogo e para jogador.
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Episódios:
- obter cartas disponíveis
- obter carta especifica
-  obter cartas livres por material de apoio
-  obter todas as cartas
- apagar todas as cartas do repositório
- adicionar cartas no repositório
- atualizar cartas

 */
public class CardController {

    // session with Hibernate
    Session session = null;

    // constructor
    public CardController() {

        this.session = HibernateUtil.getSessionFactory().getCurrentSession();

    }

   // @episodio1 obter cartas disponíveis
    public List getCardsFree() {
        List<Card> cardList = null;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Card as card where card.cardId not in (select playercard.card.cardId from Playercard as playercard)");

            cardList = (List<Card>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }

  //  @episodio2 obter carta especifica
    public Card getCardByID(int cardId) {

        Card card = null;

        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Card as card where card.cardId=" + cardId);
            card = (Card) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return card;
    }

    // @obter o conjunto de cartas compradas pelo jogador
        public List getCardBought(String setCards) {

         List<Card> cardList = null;

           try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            
            Query q = session.createQuery("from Card as card where card.cardId in (" + setCards+ ")");
             cardList = (List<Card>) q.list();

         }catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }


     // obter cartas livres por material de apoio
    public List getCardsFree(int source) {
        List<Card> cardList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Card as card where card.cardId not in (select playercard.card.cardId from Playercard as playercard) and card.sourceofcards.sourceofcardsId='" + source + "')");

           // Query q = session.createQuery("from Card as card where card.cardId not in (select playercard.card.cardId from Playercard as playercard)");
            cardList = (List<Card>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }

    // @episodio3 obter todas as cartas
    public List getCards() {
        List<Card> cardList = null;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Card as card");

            cardList = (List<Card>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardList;
    }

    //  @episodio4 apagar todas as cartas do repositório
    public boolean deleteCard(Card card) {
        boolean bcard = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            session.delete(card);
            bcard = true;
            tx.commit();
        //   session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bcard;
    }

    // @episodio5 adicionar carta
    public boolean addCards(Card card) {
        boolean bCard = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            System.out.println("los valores" + card.getName());

            org.hibernate.Transaction tx = session.beginTransaction();

            Card newCard = null;

            newCard.setDescription(card.getDescription());
            newCard.setName(card.getName());
            newCard.setReference(card.getReference());
            newCard.setCardtype(card.getCardtype());
            newCard.setSourceofcards(card.getSourceofcards());

            session.save(newCard);
            bCard = true;
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bCard;
    }

    // @episodio6    atualizar cartas
    public boolean updateCard(Card card) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            session.load(Card.class, card.getCardId());

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

    // @episodio5 adicionar carta
    public boolean addCard(Card card) {

        boolean addReg = false;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(card);
            addReg = true;
            tx.commit();
        } catch (Exception e) {
            addReg = false;
            e.printStackTrace();

        }

        return addReg;

    }

   
}
