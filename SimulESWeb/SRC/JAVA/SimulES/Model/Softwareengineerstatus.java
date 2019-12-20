package SimulES.Model;

import java.util.HashSet;
import java.util.Set;

/**
Titulo: Estatus do Engenheiro de Software
Objetivo: Descrever o estado do Engenheiro de Software
Contexto:
Localização geográfica: Web
Localização temporal: Java Softwareengineerstatus
Pre-condições: Banco de dados deve estar disponível
Pos-condições: Objeto disponível
Atores: simules
Recursos: Player online
Episódios:
1- receber objeto da camada de controle
2- conectar ao banco de dado
3- enviar objeto à base de dados
4- receber objeto da base de dados
 */
public class Softwareengineerstatus  implements java.io.Serializable {


     private Short statusId;
     private String description;
     private Set<Softengineer> softengineers = new HashSet<Softengineer>(0);

    public Softwareengineerstatus() {
    }

	
    public Softwareengineerstatus(String description) {
        this.description = description;
    }
    public Softwareengineerstatus(String description, Set<Softengineer> softengineers) {
       this.description = description;
       this.softengineers = softengineers;
    }
   
    public Short getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(Short statusId) {
        this.statusId = statusId;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<Softengineer> getSoftengineers() {
        return this.softengineers;
    }
    
    public void setSoftengineers(Set<Softengineer> softengineers) {
        this.softengineers = softengineers;
    }




}


