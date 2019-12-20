
package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador de estados dos engenheiros de software
Objetivo: Descrever as operações de controle sobre os estados dos engenheiros de software.
Contexto:
Localização geográfica: Web
Localização temporal: Java SoftEngineerController
Pre-condições: repositório com engenheiros de software
Pos-condições:  operações com os diferentes estados dos engenheiros de software
Atores: simules, engenheiros de software
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Episódios:
- obter todos os estados dos engenheiros de software
- obter estado de um engenheiro de software especifico

 */
public class SoftwareEngineerStatusController {

    // session with Hibernate
    Session session = null;

    // constructor
    public SoftwareEngineerStatusController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //@episodio1 obter todos os estados dos engenheiros de software
    public List getAllSoftEngStatus() {

        List<Softwareengineerstatus> statusList = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Softwareengineerstatus");

            statusList = (List<Softwareengineerstatus>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusList;
    }

    //@eposodio2 obter estado de um engenheiro de software especifico
    public Softwareengineerstatus getSoftEngStatus(int statusId) {
        Softwareengineerstatus status = null;
        List<Softwareengineerstatus> statusList = getAllSoftEngStatus();
        Iterator it = statusList.iterator();

        while (it.hasNext()) {
            status = (Softwareengineerstatus) it.next();
            if (status.getStatusId().equals((short) statusId)) {
                return status;
            }
        }

        return status;
    }

}
