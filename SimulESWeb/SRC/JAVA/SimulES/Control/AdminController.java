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
public class AdminController {

      // session with Hibernate
    Session session = null;

    // constructor
    public AdminController() {

        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

     //@episodio obter todos os admin
    public List getAdmin() {

        List<Admin> adminList = null;

        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();

            Query q = session.createQuery("from Admin");

            adminList = (List<Admin>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminList;
    }

    //@episodio obter admin por identificador
    public Admin getAdminbyName(String name) {
        Admin admin = null;
        List<Admin> adminList = getAdmin();
        Iterator it = adminList.iterator();

        while (it.hasNext()) {
            admin = (Admin) it.next();
            if (admin.getName().equals(name)) {
                return admin;
            }
        }

        return admin;
    }


    //@episodio2 validar se administrador existe
    public boolean adminExist(String nickname) {
        boolean bAdminExist = false;

        List<Admin> adminList = getAdmin();
        Iterator it = adminList.iterator();

        while (it.hasNext()) {
            Admin admin = (Admin) it.next();
            if (admin.getName().equals(nickname)) {
                bAdminExist = true;
            }
        }

        return bAdminExist;
    }


     public boolean passwordIsCorrect(String nickname, String password) {
        boolean bAdminExist = false;

        List<Admin> adminList = getAdmin();
        Iterator it = adminList.iterator();

        while (it.hasNext()) {
            Admin admin = (Admin) it.next();
            if (admin.getPassword().equals(password) && admin.getName().equals(nickname)) {
                bAdminExist = true;
            }
        }

        return bAdminExist;
    }




}
