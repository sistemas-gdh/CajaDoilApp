package Modelo;
// Generated 08/01/2018 10:56:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Departamentos generated by hbm2java
 */
public class Departamentos  implements java.io.Serializable {


     private Integer dptoId;
     private String dptoDesc;
     private String dptoObs;
     private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

    public Departamentos() {
    }

    public Departamentos(String dptoDesc, String dptoObs) {
        this.dptoDesc = dptoDesc;
        this.dptoObs = dptoObs;
    }

    public Departamentos(String dptoDesc, String dptoObs, Set<Usuarios> usuarioses) {
       this.dptoDesc = dptoDesc;
       this.dptoObs = dptoObs;
       this.usuarioses = usuarioses;
    }
   
    public Integer getDptoId() {
        return this.dptoId;
    }
    
    public void setDptoId(Integer dptoId) {
        this.dptoId = dptoId;
    }
    public String getDptoDesc() {
        return this.dptoDesc;
    }
    
    public void setDptoDesc(String dptoDesc) {
        this.dptoDesc = dptoDesc;
    }
    public String getDptoObs() {
        return this.dptoObs;
    }
    
    public void setDptoObs(String dptoObs) {
        this.dptoObs = dptoObs;
    }
    public Set<Usuarios> getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set<Usuarios> usuarioses) {
        this.usuarioses = usuarioses;
    }




}


