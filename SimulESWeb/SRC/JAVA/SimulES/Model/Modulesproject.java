package SimulES.Model;
/**
Titulo: Modulos do projeto
Objetivo: Descrever as operações para obter o objeto Modulos do projeto que complementa o projeto.
Contexto:
Localização geográfica: Web
Localização temporal: Java Modulesproject
Pre-condições: Banco de dados deve estar disponível
Pos-condições: Objeto disponível
Atores: simules
Recursos: tipo de carta(identificador, descrição).
Episódios:
1- receber objeto da camada de controle
2- conectar ao banco de dado
3- enviar objeto à base de dados
 */
public class Modulesproject  implements java.io.Serializable {


     private ModulesprojectId id;
     private Project project;
     private Integer requirement;
     private Integer design;
     private Integer code;
     private Integer traceability;
     private Integer help;

    public Modulesproject() {
    }

	
    public Modulesproject(ModulesprojectId id, Project project) {
        this.id = id;
        this.project = project;
    }
    public Modulesproject(ModulesprojectId id, Project project, Integer requirement, Integer design, Integer code, Integer traceability, Integer help) {
       this.id = id;
       this.project = project;
       this.requirement = requirement;
       this.design = design;
       this.code = code;
       this.traceability = traceability;
       this.help = help;
    }
   
    public ModulesprojectId getId() {
        return this.id;
    }
    
    public void setId(ModulesprojectId id) {
        this.id = id;
    }
    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    public Integer getRequirement() {
        return this.requirement;
    }
    
    public void setRequirement(Integer requirement) {
        this.requirement = requirement;
    }
    public Integer getDesign() {
        return this.design;
    }
    
    public void setDesign(Integer design) {
        this.design = design;
    }
    public Integer getCode() {
        return this.code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    public Integer getTraceability() {
        return this.traceability;
    }
    
    public void setTraceability(Integer traceability) {
        this.traceability = traceability;
    }
    public Integer getHelp() {
        return this.help;
    }
    
    public void setHelp(Integer help) {
        this.help = help;
    }




}


