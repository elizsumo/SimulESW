package SimulES.Model;

import java.util.HashSet;
import java.util.Set;

/**
Titulo: Projeto
Objetivo: Descrever o objeto projeto.
Contexto:
Localização geográfica: Web
Localização temporal: Java Index
Pre-condições: Banco de dados deve estar disponível
Pos-condições: Objeto disponível
Atores: simules
Recursos: projetos na bd
Episódios:
1- receber objeto da camada de controle
2- conectar ao banco de dado
3- enviar objeto à base de dados
4- receber objeto da base de dados
 */
public class Project  implements java.io.Serializable {


     private Short projectId;
     private String name;
     private String description;
     private int complexity;
     private int budget;
     private int status;
     private int size;
     private int quality;
     private Set<Modulesproject> modulesprojects = new HashSet<Modulesproject>(0);

    public Project() {
    }

	
    public Project(String name, String description, int complexity, int budget, int status, int size, int quality) {
        this.name = name;
        this.description = description;
        this.complexity = complexity;
        this.budget = budget;
        this.status = status;
        this.size = size;
        this.quality = quality;
    }
    public Project(String name, String description, int complexity, int budget, int status, int size, int quality, Set<Modulesproject> modulesprojects) {
       this.name = name;
       this.description = description;
       this.complexity = complexity;
       this.budget = budget;
       this.status = status;
       this.size = size;
       this.quality = quality;
       this.modulesprojects = modulesprojects;
    }
   
    public Short getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Short projectId) {
        this.projectId = projectId;
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
    public int getComplexity() {
        return this.complexity;
    }
    
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
    public int getBudget() {
        return this.budget;
    }
    
    public void setBudget(int budget) {
        this.budget = budget;
    }
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    public int getSize() {
        return this.size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    public int getQuality() {
        return this.quality;
    }
    
    public void setQuality(int quality) {
        this.quality = quality;
    }
    public Set<Modulesproject> getModulesprojects() {
        return this.modulesprojects;
    }
    
    public void setModulesprojects(Set<Modulesproject> modulesprojects) {
        this.modulesprojects = modulesprojects;
    }




}


