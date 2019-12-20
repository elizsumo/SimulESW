
package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador de engenheiros de software
Objetivo: Descrever as operações de controle dos engenheiros de software.
Contexto:
Localização geográfica: Web
Localização temporal: Java SoftEngineerController
Pre-condições: Serviços web disponíveis
Pos-condições:  operações com engenheiros de software disponíveis
Atores: jogador, simules, engenheiros de software
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Episódios:
- obter todos os engenheiros de software
- obter um engenheiro de software especifico
- obter engenheiros de software disponíveis
- obter engenheiro de software se esta disponível
- atualizar o estado dos engenheiros de software para disponíveis
- empregar engenheiro de software
- reiniciar engenheiros de software

 */
public class SoftEngineerController {

    // session hibernate variable
    Session session = null;

    //constructor
    public SoftEngineerController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

   //obter todos os engenheiros de software
    public List getSoftEngineer() {
        List<Softengineer> SoftengineerList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Softengineer");
            SoftengineerList = (List<Softengineer>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SoftengineerList;
    }

    //obter um engenheiro de software especifico
    public Softengineer getSoftEngineer(int softEngId) {
        Softengineer softEng = null;
        List<Softengineer> softEngList = getSoftEngineer();
        Iterator it = softEngList.iterator();

        while (it.hasNext()) {
            softEng = (Softengineer) it.next();
            if (softEng.getSoftengineerId().equals((short) softEngId)) {
                return softEng;
            }
        }

        return softEng;
    }

    //obter engenheiros de software disponíveis
    public List getSoftEngineerFree() {
        List<Softengineer> SoftengineerList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Softengineer where softwareengineerstatus=1");
            SoftengineerList = (List<Softengineer>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SoftengineerList;
    }

    //obter engenheiro de software se esta disponível
    public boolean getSoftEngineerFree(int softEngId) {
        boolean valueReturn = false;
        try {

            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();
            tx.begin();
            Query q = session.createQuery("from Softengineer as softeng where softeng.softwareengineerstatus=1 and softeng.softengineerId='" + softEngId + "')");
            if (q.list().size() > 0) {
                valueReturn = true;

                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valueReturn;
    }

   //atualizar o estado dos engenheiros de software para disponíveis
    public boolean updateSoftwareEngineer(Softengineer softwareEngineer) {
        boolean bTrans = false;
        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
             
            org.hibernate.Transaction tx = session.beginTransaction();

            Softengineer softwEng = (Softengineer) session.load(Softengineer.class, softwareEngineer.getSoftengineerId());

            SoftwareEngineerStatusController softEngStatus = new SoftwareEngineerStatusController();

            Softwareengineerstatus status = softEngStatus.getSoftEngStatus(1);

            softwEng.setSoftwareengineerstatus(status);
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

   //empregar engenheiro de software
    public boolean employSoftwareEngineer(Softengineer softwareEngineer) {
        boolean bTrans = false;
        try {

             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
             
            org.hibernate.Transaction tx = session.beginTransaction();

            Softengineer softwEng = (Softengineer) session.load(Softengineer.class, softwareEngineer.getSoftengineerId());

            SoftwareEngineerStatusController softEngStatus = new SoftwareEngineerStatusController();
            Softwareengineerstatus status = softEngStatus.getSoftEngStatus(3);
            softwEng.setSoftwareengineerstatus(status);
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

    // reiniciar engenheiros de software
    public boolean restartSoftEngineer() {
        boolean brestartSoftEng = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Softengineer> softengineerList = getSoftEngineer();

            Iterator it = softengineerList.iterator();

            while (it.hasNext()) {

                Softengineer softEngineer = (Softengineer) it.next();

                SoftwareEngineerStatusController softEngStatus = new SoftwareEngineerStatusController();

                Softwareengineerstatus status = softEngStatus.getSoftEngStatus(1);

                softEngineer.setSoftwareengineerstatus(status);

            }

            brestartSoftEng = true;

            System.out.println("Restart Successfully");

            tx.commit();

        //session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return brestartSoftEng;
    }
}
