package SimulES.Model;
/**
Titulo: Modulos do projeto
Objetivo: Descrever as operações para obter o ID do objeto Modulos do projeto que complementa o projeto.
Contexto:
Localização geográfica: Web
Localização temporal: Java ModulesprojectId
Pre-condições: Banco de dados deve estar disponível
Pos-condições: Objeto disponível
Atores: simules
Recursos: tipo de carta(identificador, descrição).
Episódios:
1- receber objeto da camada de controle
2- conectar ao banco de dado
3- enviar objeto à base de dados
 */
public class ModulesprojectId  implements java.io.Serializable {


     private short projectId;
     private short module;

    public ModulesprojectId() {
    }

    public ModulesprojectId(short projectId, short module) {
       this.projectId = projectId;
       this.module = module;
    }
   
    public short getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(short projectId) {
        this.projectId = projectId;
    }
    public short getModule() {
        return this.module;
    }
    
    public void setModule(short module) {
        this.module = module;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ModulesprojectId) ) return false;
		 ModulesprojectId castOther = ( ModulesprojectId ) other; 
         
		 return (this.getProjectId()==castOther.getProjectId())
 && (this.getModule()==castOther.getModule());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getProjectId();
         result = 37 * result + this.getModule();
         return result;
   }   


}


