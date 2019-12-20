
package SimulES.Control;

import SimulES.Model.*;
import SimulES.Util.JSFUtils;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador dos módulos do projeto
Objetivo: Descrever as operações de controle em nos módulos do projeto.
Contexto:
Localização geográfica: Web
Localização temporal: Java ModulesProjectController
Pre-condições: Serviços web disponíveis, projeto para o jogo já escolhido
Pos-condições:
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
Episódios:
-  obter os módulos de um projeto especificado
-  obter os módulos do projeto com estado escolhido
-  obter os módulos de um projeto organizados em um arranjo
-  inspecionar módulos especificados
 */
public class ModulesProjectController {

    //session hibernate variable
    Session session = null;

    //constructor
    public ModulesProjectController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //@episodio1 obter os módulos de um projeto especificado
    public List getModulesProject(int projectId) {
        List<Modulesproject> modulesList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Modulesproject as modulesproject where modulesproject.project.projectId='" + projectId + "')");
            modulesList = (List<Modulesproject>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modulesList;
    }

    //@episodio2 obter os módulos do projeto com estado escolhido
    public List getModulesProjectChose() {
        List<Modulesproject> modulesList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Modulesproject as modulesproject where modulesproject.project.projectId in (select project.projectId from Project as project where project.status=1)");
            modulesList = (List<Modulesproject>) q.list();

            int value = modulesList.size();

            System.out.println("Size module: " + value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return modulesList;
    }

    //@episodio3 obter os módulos de um projeto organizados em um arranjo
    public int[] getSumModulesByProject() {

        int[] modulesArray = new int[6];

        int modulesSum = 0;
        int requirement = 0;
        int design = 0;
        int code = 0;
        int traceability = 0;
        int help = 0;


        List<Modulesproject> modulesList = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Modulesproject as modulesproject where modulesproject.project.projectId in (select project.projectId from Project as project where project.status=1)");

            modulesList = (List<Modulesproject>) q.list();

            modulesSum = modulesList.size();

            Iterator it = modulesList.iterator();

            while (it.hasNext()) {

                Modulesproject modulesproject = (Modulesproject) it.next();

                try {
                    requirement = requirement + modulesproject.getRequirement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    design = design + modulesproject.getDesign();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    code = code + modulesproject.getCode();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    traceability = traceability + modulesproject.getTraceability();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    help = help + modulesproject.getHelp();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            modulesArray[0] = requirement;
            modulesArray[1] = design;
            modulesArray[2] = code;
            modulesArray[3] = traceability;
            modulesArray[4] = help;
            modulesArray[5] = modulesSum;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return modulesArray;
    }

   //@episodio4 inspecionar módulos especificados
    public int[] getModulesToInspect(int quantityInspect) {
        int modulesSum = 0;

        List<Modulesproject> modulesList = null;

        Modulesproject modulesproject = null;

        int[] modulesArray = new int[5];
        int requirement = 0;
        int design = 0;
        int code = 0;
        int traceability = 0;
        int help = 0;


        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();
            //   Query q = session.createQuery("from Card as card where card.cardId in (select playerCard.card.cardId from Playercard as playerCard where playerCard.player.playerId='" + idPlayer + "')");
            Query q = session.createQuery("from Modulesproject as modulesproject where modulesproject.project.projectId in (select project.projectId from Project as project where project.status=1)");

            modulesList = (List<Modulesproject>) q.list();

            int sizeModules = modulesList.size();

            JSFUtils jsfUtils = new JSFUtils();

            int[] randomOrderModules = jsfUtils.randomVectorGeneration(sizeModules);

            for (int x = 0; x < quantityInspect; x++) {

                int valueIndex = randomOrderModules[x];

                modulesproject = getModuleById(valueIndex);

                try {
                    requirement = requirement + modulesproject.getRequirement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    design = design + modulesproject.getDesign();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    code = code + modulesproject.getCode();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    traceability = traceability + modulesproject.getTraceability();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    help = help + modulesproject.getHelp();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            modulesArray[0] = requirement;
            modulesArray[1] = design;
            modulesArray[2] = code;
            modulesArray[3] = traceability;
            modulesArray[4] = help;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return modulesArray;
    }

    //@episodio6 obter os módulos por um identificador
    public Modulesproject getModuleById(int moduleId) {
        Modulesproject module = null;

        List<Modulesproject> Modulelist = getModulesProjectChose();
        Iterator it = Modulelist.iterator();

        while (it.hasNext()) {
            module = (Modulesproject) it.next();
            if (module.getId().getModule()== moduleId) {
                return module;
            }
        }
        return module;
    }
}
