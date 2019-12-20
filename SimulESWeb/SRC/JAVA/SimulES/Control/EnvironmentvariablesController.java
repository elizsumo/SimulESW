/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author elizsumoComputer
 */
public class EnvironmentvariablesController {
    // session with Hibernate

    Session session = null;

    // constructor
    public EnvironmentvariablesController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //  @episodio 1 obter uma variavel especifica
    public Environmentvariables getEnvironmentVariable(int variableId) {

        Environmentvariables environmentvariables = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Environmentvariables as environmentvariables where environmentvariables.environmentvariablesId=" + variableId);
            environmentvariables = (Environmentvariables) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return environmentvariables;
    }

    //reiniciar todas as variaveis de ambiente
    public boolean restartEnvironmentVariables() {
        boolean brestart = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Environmentvariables> environmentvariablesList = getEnvironmentVariables();

            Iterator it = environmentvariablesList.iterator();

            while (it.hasNext()) {

                Environmentvariables environmentvariables = (Environmentvariables) it.next();

                environmentvariables.setState(0);

            }
            brestart = true;
            System.out.println("Restart Successfully");
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brestart;
    }

    //obter todas as variaveis de ambiente
    public List getEnvironmentVariables() {
        List<Environmentvariables> environmentvariablesList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Environmentvariables");
            environmentvariablesList = (List<Environmentvariables>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return environmentvariablesList;
    }

    //@ obter uma variavel de ambiente por identificador
    public Environmentvariables getEnvironmentVariableByID(int environmentvariableId) {

        Environmentvariables environmentvariable = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Environmentvariables as environmentvariables where environmentvariables.environmentvariablesId=" + environmentvariableId);
            environmentvariable = (Environmentvariables) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return environmentvariable;
    }

    //atualizar um registro
    public boolean updateEnvironmentVariables(Environmentvariables environmentvariable, int value) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Environmentvariables ev = (Environmentvariables) session.load(Environmentvariables.class, environmentvariable.getEnvironmentvariablesId());
            ev.setState(value);
            tx.commit();
            System.out.println("Update Successfully");
            bTrans = true;
        } catch (Exception e) {
            bTrans = false;
            e.printStackTrace();
        }
        return bTrans;
    }
}
