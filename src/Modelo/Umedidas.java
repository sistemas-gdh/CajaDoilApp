package Modelo;
// Generated 08/01/2018 10:56:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Umedidas generated by hbm2java
 */
public class Umedidas  implements java.io.Serializable {


     private Integer unidadmId;
     private String unidadmDesc;
     private Integer unidadmEstado;
     private Set<DetalleSc> detalleScs = new HashSet<DetalleSc>(0);

    public Umedidas() {
    }

    public Umedidas(String unidadmDesc, Integer unidadmEstado) {
        this.unidadmDesc = unidadmDesc;
        this.unidadmEstado = unidadmEstado;
    }

    public Umedidas(String unidadmDesc, Integer unidadmEstado, Set<DetalleSc> detalleScs) {
       this.unidadmDesc = unidadmDesc;
       this.unidadmEstado = unidadmEstado;
       this.detalleScs = detalleScs;
    }
   
    public Integer getUnidadmId() {
        return this.unidadmId;
    }
    
    public void setUnidadmId(Integer unidadmId) {
        this.unidadmId = unidadmId;
    }
    public String getUnidadmDesc() {
        return this.unidadmDesc;
    }
    
    public void setUnidadmDesc(String unidadmDesc) {
        this.unidadmDesc = unidadmDesc;
    }
    public Integer getUnidadmEstado() {
        return this.unidadmEstado;
    }
    
    public void setUnidadmEstado(Integer unidadmEstado) {
        this.unidadmEstado = unidadmEstado;
    }
    public Set<DetalleSc> getDetalleScs() {
        return this.detalleScs;
    }
    
    public void setDetalleScs(Set<DetalleSc> detalleScs) {
        this.detalleScs = detalleScs;
    }




}

