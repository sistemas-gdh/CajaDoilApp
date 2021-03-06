package Modelo;
// Generated 08/01/2018 10:56:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ServTransporte generated by hbm2java
 */
public class ServTransporte  implements java.io.Serializable {


     private Integer stId;
     private String stOrigen;
     private String stDestino;
     private Double stPeajes;
     private Integer stPcant;
     private String stEstado;
     private Set<DetalleSv> detalleSvs = new HashSet<DetalleSv>(0);
     private Set<SubMcs> subMcses = new HashSet<SubMcs>(0);

    public ServTransporte() {
    }

    public ServTransporte(String stOrigen, String stDestino, Double stPeajes, Integer stPcant, String stEstado) {
        this.stOrigen = stOrigen;
        this.stDestino = stDestino;
        this.stPeajes = stPeajes;
        this.stPcant = stPcant;
        this.stEstado = stEstado;
    }

    public ServTransporte(String stOrigen, String stDestino, Double stPeajes, Integer stPcant, String stEstado, Set<DetalleSv> detalleSvs, Set<SubMcs> subMcses) {
       this.stOrigen = stOrigen;
       this.stDestino = stDestino;
       this.stPeajes = stPeajes;
       this.stPcant = stPcant;
       this.stEstado = stEstado;
       this.detalleSvs = detalleSvs;
       this.subMcses = subMcses;
    }
   
    public Integer getStId() {
        return this.stId;
    }
    
    public void setStId(Integer stId) {
        this.stId = stId;
    }
    public String getStOrigen() {
        return this.stOrigen;
    }
    
    public void setStOrigen(String stOrigen) {
        this.stOrigen = stOrigen;
    }
    public String getStDestino() {
        return this.stDestino;
    }
    
    public void setStDestino(String stDestino) {
        this.stDestino = stDestino;
    }
    public Double getStPeajes() {
        return this.stPeajes;
    }
    
    public void setStPeajes(Double stPeajes) {
        this.stPeajes = stPeajes;
    }
    public Integer getStPcant() {
        return this.stPcant;
    }
    
    public void setStPcant(Integer stPcant) {
        this.stPcant = stPcant;
    }
    public String getStEstado() {
        return this.stEstado;
    }
    
    public void setStEstado(String stEstado) {
        this.stEstado = stEstado;
    }
    public Set<DetalleSv> getDetalleSvs() {
        return this.detalleSvs;
    }
    
    public void setDetalleSvs(Set<DetalleSv> detalleSvs) {
        this.detalleSvs = detalleSvs;
    }
    public Set<SubMcs> getSubMcses() {
        return this.subMcses;
    }
    
    public void setSubMcses(Set<SubMcs> subMcses) {
        this.subMcses = subMcses;
    }




}


