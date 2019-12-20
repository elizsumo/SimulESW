
package SimulES.Control;

import SimulES.Model.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
Titulo: Controlador de cartas tipo
Objetivo: Descrever as operações de controle nos tipos de cartas.
Contexto:
Localização geográfica: Web
Localização temporal: Java CardtypeController
Pre-condições: Serviços web disponíveis, rodada de inicio já foi executada
Pos-condições: Atualizar estado das cartas no jogo e para jogador.
Atores: jogador, simules
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Atores: simules, jogador
Recursos: informações do projeto, informações dos jogadores, informações dos movimentos e mensageira
Episódios:
- obter os tipos de cartas

 */
public class CardtypeController {

    //session hibernate variable
    Session session = null;

    //constructor
    public CardtypeController() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    // @eposidio1 obter os tipos de carta
     public Cardtype getCardtype(int typeId) {
        Cardtype cardtype = null;
        try {
            if (!this.session.isOpen()) {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cardtype as cardtype where cardtype.cardtypeId='" + typeId + "')");
            cardtype = (Cardtype) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cardtype;
    }


}
