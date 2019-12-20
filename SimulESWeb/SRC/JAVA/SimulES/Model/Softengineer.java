package SimulES.Model;

/**
Titulo: Engenheiro de Software
Objetivo: Descrever o objeto Engenheiro de Software
Contexto:
Localização geográfica: Web
Localização temporal: Java Softengineer
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
public class Softengineer  implements java.io.Serializable {


     private Short softengineerId;
     private Softwareengineerstatus softwareengineerstatus;
     private String name;
     private String description;
     private int salary;
     private int hability;
     private int maturity;

    public Softengineer() {
    }

    public Softengineer(Softwareengineerstatus softwareengineerstatus, String name, String description, int salary, int hability, int maturity) {
       this.softwareengineerstatus = softwareengineerstatus;
       this.name = name;
       this.description = description;
       this.salary = salary;
       this.hability = hability;
       this.maturity = maturity;
    }
   
    public Short getSoftengineerId() {
        return this.softengineerId;
    }
    
    public void setSoftengineerId(Short softengineerId) {
        this.softengineerId = softengineerId;
    }
    public Softwareengineerstatus getSoftwareengineerstatus() {
        return this.softwareengineerstatus;
    }
    
    public void setSoftwareengineerstatus(Softwareengineerstatus softwareengineerstatus) {
        this.softwareengineerstatus = softwareengineerstatus;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public int getSalary() {
        return this.salary;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getHability() {
        return this.hability;
    }
    
    public void setHability(int hability) {
        this.hability = hability;
    }
    public int getMaturity() {
        return this.maturity;
    }
    
    public void setMaturity(int maturity) {
        this.maturity = maturity;
    }




}


