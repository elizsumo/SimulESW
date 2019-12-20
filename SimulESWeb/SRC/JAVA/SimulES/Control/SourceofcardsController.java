package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador de material de apoio
Objetivo: Descrever as operações de controle sobre o material de apoio.
Contexto:
Localização geográfica: Web
Localização temporal: Java SourceofcardsController
Pre-condições:
Pos-condições:  operações com os materiais de apoio disponíveis
Atores: simules, jogador administrador
Recursos: mensageira
Episódios:
- obter todos os materiais de apoio
- apagar material de apoio
- adicionar material de apoio
- atualizar material de apoio
- obter material de apoio por identificador
- obter o Maximo identificador do material de apoio
 */
public class SourceofcardsController {

    // session with Hibernate
    Session session = null;

    // constructor
    public SourceofcardsController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //@episodio1 obter todos os materiais de apoio
    public List getSourceofcards() {
        List<Sourceofcards> sourceofcardsList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Sourceofcards");
            sourceofcardsList = (List<Sourceofcards>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceofcardsList;
    }

    //@episodio2 apagar material de apoio
    public boolean deleteSourceofcards(Sourceofcards sourceofcards) {
        boolean bSourceofcards = false;
           session.close();
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            session.delete(sourceofcards);
            bSourceofcards = true;
            tx.commit();
        //  session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bSourceofcards;
    }

    //@episodio3 adicionar material de apoio
    public boolean addSourceofcards(Sourceofcards sourceofcards) {
        boolean bSourceofcards = false;
         session.close();
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(sourceofcards);
            bSourceofcards = true;
            tx.commit();
           // session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bSourceofcards;
    }

    //@episodio4 atualizar material de apoio
    public boolean updateSourceofcards(Sourceofcards sourceofcards) {
        boolean bTrans = false;
         session.close();
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            session.load(Sourceofcards.class, sourceofcards.getSourceofcardsId());
           
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

    //@episodio5 obter material de apoio por identificador
    public Sourceofcards getSourceOfCards(int sourceId) {
        Sourceofcards sourceofcards = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Sourceofcards as sourceofcards where sourceofcards.sourceofcardsId='" + sourceId + "')");
            sourceofcards = (Sourceofcards) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceofcards;
    }

    //@episodio6 obter o Maximo identificador do material de apoio
    public Sourceofcards getMaxSourceofcards() {

        Sourceofcards sourceofcards  = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Sourceofcards as sourceofcards where sourceofcards.sourceofcardsId=(select Max(sourceofcardsId) from Sourceofcards)" );
            sourceofcards = (Sourceofcards) q.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceofcards;
    }

}
