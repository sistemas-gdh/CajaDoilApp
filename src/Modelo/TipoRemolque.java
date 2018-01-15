package Modelo;
// Generated 08/01/2018 10:56:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TipoRemolque generated by hbm2java
 */
public class TipoRemolque  implements java.io.Serializable {


     private Integer trId;
     private String trDesc;
     private Set<Remolques> remolqueses = new HashSet<Remolques>(0);

    public TipoRemolque() {
    }

    public TipoRemolque(String trDesc) {
        this.trDesc = trDesc;
    }

    public TipoRemolque(String trDesc, Set<Remolques> remolqueses) {
       this.trDesc = trDesc;
       this.remolqueses = remolqueses;
    }
   
    public Integer getTrId() {
        return this.trId;
    }
    
    public void setTrId(Integer trId) {
        this.trId = trId;
    }
    public String getTrDesc() {
        return this.trDesc;
    }
    
    public void setTrDesc(String trDesc) {
        this.trDesc = trDesc;
    }
    public Set<Remolques> getRemolqueses() {
        return this.remolqueses;
    }
    
    public void setRemolqueses(Set<Remolques> remolqueses) {
        this.remolqueses = remolqueses;
    }




}

