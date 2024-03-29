package SimulES.Model;
// Generated Aug 17, 2011 6:59:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Environmentvariables generated by hbm2java
 */
@Entity
@Table(name="environmentvariables"
    ,catalog="simules"
)
public class Environmentvariables  implements java.io.Serializable {


     private Short environmentvariablesId;
     private String description;
     private int state;

    public Environmentvariables() {
    }

    public Environmentvariables(String description, int state) {
       this.description = description;
       this.state = state;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="environmentvariables_id", unique=true, nullable=false)
    public Short getEnvironmentvariablesId() {
        return this.environmentvariablesId;
    }
    
    public void setEnvironmentvariablesId(Short environmentvariablesId) {
        this.environmentvariablesId = environmentvariablesId;
    }
    
    @Column(name="description", nullable=false, length=45)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="state", nullable=false)
    public int getState() {
        return this.state;
    }
    
    public void setState(int state) {
        this.state = state;
    }




}


