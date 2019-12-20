
package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador de projeto
Objetivo: Descrever as operações de controle do projeto do jogo.
Contexto:
Localização geográfica: Web
Localização temporal: Java ProjectController
Pre-condições: Serviços web disponíveis
Pos-condições:
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos
movimentos e mensageira
Atores: simules, jogador
 */
public class ProjectController {

    //session hibernate variable
    Session session = null;

    //constructor
    public ProjectController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

   //@episodio1 obter todos os projetos do repositório
    public List getProject() {
        List<Project> projectList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Project");
            projectList = (List<Project>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectList;
    }

    //@episodio2 obter um projeto especifico
    public List getProject(int projectId) {
        List<Project> projectList = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Project as project where project.projectId='" + projectId + "')");
            projectList = (List<Project>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectList;
    }

    //@episodio3 obter um projeto por identificador
    public Project getProjectByID(int projectId) {

        Project project = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Project as project where project.projectId=" + projectId);
            project = (Project) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return project;
    }

     //@episodio3 obter o objeto projecto
    public Project getProjectObject() {

        Project project = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Project as project where project.status=1");
            project = (Project) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return project;
    }


   

   //@episodio4 atualizar o estado do projeto a escolhido
    public boolean updateProject(Project projectChoose) {
        boolean bTrans = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Project project = (Project) session.load(Project.class, projectChoose.getProjectId());
            project.setStatus(1);
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

    //@episodio5 reiniciar estado dos projetos
    public boolean restartProjects() {
        boolean updateProject = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();
            List<Project> projectList = getProject();

            Iterator it = projectList.iterator();

            while (it.hasNext()) {

                Project project = (Project) it.next();

                project.setStatus(0);

            }

            updateProject = true;

            System.out.println("Restart Successfully");

            tx.commit();

        //session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateProject;
    }

    //@episodio6 obter a quantidade de módulos a ser construídos por projeto
    public int getSumModulesByProject() {
        int modulesSum = 0;

        Modulesproject modules = null;
        
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            //   Query q = session.createQuery("from Card as card where card.cardId in (select playerCard.card.cardId from Playercard as playerCard where playerCard.player.playerId='" + idPlayer + "')");
            Query q = session.createQuery("from Modulesproject as modulesproject where modulesproject.projectId in (select project.projectId from Project as project where project.status=1)");

            modules = (Modulesproject) q.uniqueResult();

            modulesSum = modules.getCode();
            modulesSum = modulesSum + modules.getDesign();
            modulesSum = modulesSum + modules.getHelp();
            modulesSum = modulesSum + modules.getRequirement();
            modulesSum = modulesSum + modules.getTraceability();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return modulesSum;
    }

      //@episodio7 retornar o projeto escolhido para ser tratado no jogo
    public List getProjectChoose() {

        List<Project> projectList = null;

        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Project as project where project.status=1");
            projectList = (List<Project>) q.list();
            
            int value = projectList.size();

              System.out.println("Size project: " + value);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return projectList;
    }

     //@episodio8 obter a qualidade do projeto escolhido
    public int getQualityProject() {

      Project project = null;

      int qualityProject = 0;

        try {
             if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Project as project where project.status=1");
            project = (Project) q.uniqueResult();

            qualityProject = project.getQuality();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return qualityProject;
    }




}
