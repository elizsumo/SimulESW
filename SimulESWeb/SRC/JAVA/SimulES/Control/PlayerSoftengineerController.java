package SimulES.Control;

import SimulES.Model.*;
import SimulES.Control.PlayerController;
import SimulES.Util.JSFUtils;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
Titulo: Controlador engenheiros de software por jogador
Objetivo: Descrever as operações de controle entre o jogador e seus engenheiros de software.
Contexto:
Localização geográfica: Web
Localização temporal: Java PlayerSoftengineerController
Pre-condições: Serviços web disponíveis
Pos-condições:
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
Episódios:
- criar a relação entre engenheiro de software e jogador
- obter todas as relações jogador e engenheiros de software
- obter uma relação engenheiro de software jogador especifica
- obter uma relação engenheiro de software jogador especifica onde engenheiro esta em estado contratado
- apagar todas as relações engenheiro de software e jogador
- apagar uma relação engenheiro de software e jogador especifica
- obter um engenheiro de software especifico
- apagar um engenheiro de software de uma relação, especificando engenheiro
 */
public class PlayerSoftengineerController {

    //session hibernate variable
    Session session = null;

    //constructor
    public PlayerSoftengineerController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //@episodio1 criar a relação entre engenheiro de software e jogador
    public boolean addPlayerSoftengineer(short playerId, short softEngineerId) {

        boolean addReg = false;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            PlayersoftengineerId pse = new PlayersoftengineerId();
            pse.setPlayerId(playerId);
            pse.setSoftengineerId(softEngineerId);

            SoftEngineerController softEngHelper = new SoftEngineerController();
            List<Softengineer> softEngineerList = softEngHelper.getSoftEngineer();
            Softengineer softEng = softEngineerList.get(softEngineerId);

            PlayerController playerHelper = new PlayerController();
            List<Player> playerList = playerHelper.getPlayer();
            Player player = playerList.get(playerId);

            Playersoftengineer playerSoftEng = new Playersoftengineer();
            playerSoftEng.setId(pse);
            playerSoftEng.setPlayer(player);
            playerSoftEng.setSoftengineer(softEng);
            playerSoftEng.setDescription("Test");

            session.save(playerSoftEng);
            addReg = true;
            tx.commit();
        } catch (Exception e) {
            addReg = false;
            e.printStackTrace();

        }

        return addReg;

    }

    //@episodio1 criar a relação entre engenheiro de software e jogador
    public boolean addPlayerSoftengineer(Player player, Softengineer softEng) {

        boolean addReg = false;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            PlayersoftengineerId pse = new PlayersoftengineerId();
            pse.setPlayerId(player.getPlayerId());
            pse.setSoftengineerId(softEng.getSoftengineerId());

            Playersoftengineer playerSoftEng = new Playersoftengineer();
            playerSoftEng.setId(pse);
            playerSoftEng.setPlayer(player);
            playerSoftEng.setSoftengineer(softEng);
            playerSoftEng.setDescription("Test");

            session.save(playerSoftEng);
            addReg = true;
            tx.commit();
        } catch (Exception e) {
            addReg = false;
            e.printStackTrace();

        }

        return addReg;

    }


    //@episodio1 criar a relação entre engenheiro de software e jogador
    public boolean addPlayerSoftengineer(short playerId, Softengineer softEng) {

        boolean addReg = false;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            PlayersoftengineerId pse = new PlayersoftengineerId();
            pse.setPlayerId(playerId);
            pse.setSoftengineerId(softEng.getSoftengineerId());

            PlayerController playerHelper = new PlayerController();
            List<Player> playerList = playerHelper.getPlayer();
            Player player = playerList.get(playerId);

            Playersoftengineer playerSoftEng = new Playersoftengineer();
            playerSoftEng.setId(pse);
            playerSoftEng.setPlayer(player);
            playerSoftEng.setSoftengineer(softEng);
            playerSoftEng.setDescription("Test");

            Softengineer softwEng = (Softengineer) session.load(Softengineer.class, softEng.getSoftengineerId());

            SoftwareEngineerStatusController softEngStatus = new SoftwareEngineerStatusController();
            Softwareengineerstatus status = softEngStatus.getSoftEngStatus(2);
            softwEng.setSoftwareengineerstatus(status);

            session.save(playerSoftEng);
            addReg = true;
            tx.commit();
        } catch (Exception e) {
            addReg = false;
            e.printStackTrace();

        }

        return addReg;

    }

    //@episodio1 criar a relação entre engenheiro de software e jogador
    public boolean addPlayerSoftengineer(int playerId, int softEngId) {

        boolean addReg = false;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            PlayersoftengineerId pse = new PlayersoftengineerId();
            pse.setPlayerId((short) playerId);
            pse.setSoftengineerId((short) softEngId);

            PlayerController playerHelper = new PlayerController();
            Player player = playerHelper.getPlayer(playerId);

            SoftEngineerController softEngHelper = new SoftEngineerController();
            Softengineer softEng = softEngHelper.getSoftEngineer(softEngId);

            Playersoftengineer playerSoftEng = new Playersoftengineer();
            playerSoftEng.setId(pse);
            playerSoftEng.setPlayer(player);
            playerSoftEng.setSoftengineer(softEng);
            playerSoftEng.setDescription("Test");

            Softengineer softwEngUpd = (Softengineer) session.load(Softengineer.class, softEng.getSoftengineerId());

            SoftwareEngineerStatusController softEngStatus = new SoftwareEngineerStatusController();

            Softwareengineerstatus status = softEngStatus.getSoftEngStatus(2);

            softwEngUpd.setSoftwareengineerstatus(status);

            session.save(playerSoftEng);
            addReg = true;
            tx.commit();
        } catch (Exception e) {
            addReg = false;
            e.printStackTrace();

        }

        return addReg;

    }

    //@episodio2 obter todas as relações jogador e engenheiros de software
    public List getPlayerSoftEngineer() {

        List<Playersoftengineer> PlayerSoftEngineerList = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Playersoftengineer");

            PlayerSoftEngineerList = (List<Playersoftengineer>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return PlayerSoftEngineerList;
    }

    //@episodio3 obter uma relação engenheiro de software jogador geral
    public List getSoftEngByPlayer(int idPlayer) {
        List<Softengineer> softEngList = null;
        try {

            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Softengineer as softengineer where softengineer.softengineerId in (select playersoftengineer.softengineer.softengineerId from Playersoftengineer as playersoftengineer where playersoftengineer.player.playerId='" + idPlayer + "')");

            softEngList = (List<Softengineer>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return softEngList;
    }

    //@episodio4 obter uma relação engenheiro de software jogador especifica onde engenheiro esta em estado contratado
    public List getSoftEngEmployedByPlayer(int idPlayer) {
        List<Softengineer> softEngList = null;
        try {

            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Softengineer as softengineer where softengineer.softwareengineerstatus=3 and softengineer.softengineerId in (select playersoftengineer.softengineer.softengineerId from Playersoftengineer as playersoftengineer where playersoftengineer.player.playerId='" + idPlayer + "')");

            softEngList = (List<Softengineer>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return softEngList;
    }

    //@episodio5  apagar todas as relações engenheiro de software e jogador
    public boolean deletePlayerSoftEng() {
        boolean bPlayerSoftDelete = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            List<Playersoftengineer> PlayerSoftEngineerList = getPlayerSoftEngineer();

            Iterator it = PlayerSoftEngineerList.iterator();

            while (it.hasNext()) {
                Playersoftengineer playerSoftEng = (Playersoftengineer) it.next();
                session.delete(playerSoftEng);
            }

            bPlayerSoftDelete = true;

            tx.commit();

        //  session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bPlayerSoftDelete;
    }

    //@episodio6 apagar uma relação engenheiro de software e jogador especifica
    public boolean deleteSoftEngPlayerRel(Softengineer soft) {
        boolean bSoftEngPlayerRel = false;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }

            org.hibernate.Transaction tx = session.beginTransaction();

            Playersoftengineer playersoftengineer = getPlayerSofteng(soft);

            session.delete(playersoftengineer);

            System.out.println("Deleted Successfully");

            bSoftEngPlayerRel = true;

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bSoftEngPlayerRel;
    }

    //@episodio7 obter um engenheiro de software especifico
    public Playersoftengineer getPlayerSofteng(Softengineer soft) {

        Playersoftengineer playersoftengineer = null;
        List<Playersoftengineer> playersoftengineerdList = getPlayerSoftEngineer();
        Iterator it = playersoftengineerdList.iterator();

        while (it.hasNext()) {
            playersoftengineer = (Playersoftengineer) it.next();
            if (playersoftengineer.getSoftengineer().equals(soft)) {
                return playersoftengineer;
            }
        }
        return playersoftengineer;
    }

    //@episodio8 apagar um engenheiro de software de uma relação, especificando engenheiro
    public boolean deleteRel(Softengineer soft) {
        boolean bRel = false;
        try {
            if (deleteSoftEngPlayerRel(soft)) {
                SoftEngineerController softengcontroller = new SoftEngineerController();
                if (softengcontroller.updateSoftwareEngineer(soft)) {
                    bRel = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bRel;

    }

    // @obter o conjunto de cartas de engenheiros comprados na rodada
    public List getEngineersReserved(String setEngineers) {

        List<Softengineer> softEngList = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Softengineer as softeng where softeng.softengineerId in (" + setEngineers + ")");

            softEngList = (List<Softengineer>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return softEngList;
    }

    // com este metodo validamos que ao jogador construir não costrua em columnas que nao contenham
    // engenheiros de software, con tudo, validamos que o numero de columnas construidas seja menor ou
    //igual à quantidade de engenheiros de software no tabuleiro
    public boolean validateEngSoftxColumnsInIndividualBoard(String configuration, int playerID) {
        boolean isAppropriate = true;
        int maxValueColumn = 0;
        JSFUtils jsfUtils = new JSFUtils();

        maxValueColumn = jsfUtils.maxColumnValue(configuration);
        List softEngList = getSoftEngEmployedByPlayer(playerID);

        int dimSoftEngList = softEngList.size();

        if (maxValueColumn > dimSoftEngList) {
            isAppropriate = false;
        }

        return isAppropriate;


    }

    //validar se a contratação é valida em quanto a cantidade de engenheiros e orçamento
    public boolean validateHiring(int playerID, int budgetNewSoftEng) {
       boolean newHiringOk = true;
        ProjectController projectcontroller = new ProjectController();
        Project project = projectcontroller.getProjectObject();
        int budgetProject = project.getBudget();
        int budgetEngSoftHiring = getBudgetbyEngSoftware(playerID);

        int sumNewHiring = budgetEngSoftHiring + budgetNewSoftEng;

        if (sumNewHiring > budgetProject)
        {
            newHiringOk = false;
        }

        return newHiringOk;

    }

      //obter a suma do orcamento dos eng de soft já contratado
    public int getBudgetbyEngSoftware(int playerID) {
        int budget = 0;

        List<Softengineer> softEngList = getSoftEngEmployedByPlayer(playerID);

        Iterator it = softEngList.iterator();

        while (it.hasNext()) {
            Softengineer softengineer = (Softengineer) it.next();
            budget = budget + softengineer.getSalary();
        }

        return budget;
    }

    //obter a suma dos eng de soft já contratado
    public int getEngSoftwareHiring(int playerID) {
        int hiring = 0;

        List<Softengineer> softEngList = getSoftEngEmployedByPlayer(playerID);

        Iterator it = softEngList.iterator();

        while (it.hasNext()) {
          Softengineer softengineer = (Softengineer) it.next();
            hiring = hiring + 1;
        }

        return hiring;
    }
}
