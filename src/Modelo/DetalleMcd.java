package Modelo;
// Generated 08/01/2018 10:56:44 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * DetalleMcd generated by hbm2java
 */
public class DetalleMcd  implements java.io.Serializable {


     private Long dmcdId;
     private MovimientosCajasd movimientosCajasd;
     private String unidadmId;
     private String dmcdDesc;
     private Double dmcdCant;
     private Double dmcdImporte;
     private Double dmcdSt;
     private String dmcdDoc;
     private String dmcdProveedor;
     private String dmcdDocserie;
     private Double dmcdDoctotal;
     private Date dmcdDocfecha;
     private Integer dmcdEstado;

    public DetalleMcd() {
    }

    public DetalleMcd(MovimientosCajasd movimientosCajasd, String unidadmId, String dmcdDesc, Double dmcdCant, Double dmcdImporte, Double dmcdSt, String dmcdDoc, String dmcdProveedor, String dmcdDocserie, Double dmcdDoctotal, Date dmcdDocfecha, Integer dmcdEstado) {
       this.movimientosCajasd = movimientosCajasd;
       this.unidadmId = unidadmId;
       this.dmcdDesc = dmcdDesc;
       this.dmcdCant = dmcdCant;
       this.dmcdImporte = dmcdImporte;
       this.dmcdSt = dmcdSt;
       this.dmcdDoc = dmcdDoc;
       this.dmcdProveedor = dmcdProveedor;
       this.dmcdDocserie = dmcdDocserie;
       this.dmcdDoctotal = dmcdDoctotal;
       this.dmcdDocfecha = dmcdDocfecha;
       this.dmcdEstado = dmcdEstado;
    }
   
    public Long getDmcdId() {
        return this.dmcdId;
    }
    
    public void setDmcdId(Long dmcdId) {
        this.dmcdId = dmcdId;
    }
    public MovimientosCajasd getMovimientosCajasd() {
        return this.movimientosCajasd;
    }
    
    public void setMovimientosCajasd(MovimientosCajasd movimientosCajasd) {
        this.movimientosCajasd = movimientosCajasd;
    }
    public String getUnidadmId() {
        return this.unidadmId;
    }
    
    public void setUnidadmId(String unidadmId) {
        this.unidadmId = unidadmId;
    }
    public String getDmcdDesc() {
        return this.dmcdDesc;
    }
    
    public void setDmcdDesc(String dmcdDesc) {
        this.dmcdDesc = dmcdDesc;
    }
    public Double getDmcdCant() {
        return this.dmcdCant;
    }
    
    public void setDmcdCant(Double dmcdCant) {
        this.dmcdCant = dmcdCant;
    }
    public Double getDmcdImporte() {
        return this.dmcdImporte;
    }
    
    public void setDmcdImporte(Double dmcdImporte) {
        this.dmcdImporte = dmcdImporte;
    }
    public Double getDmcdSt() {
        return this.dmcdSt;
    }
    
    public void setDmcdSt(Double dmcdSt) {
        this.dmcdSt = dmcdSt;
    }
    public String getDmcdDoc() {
        return this.dmcdDoc;
    }
    
    public void setDmcdDoc(String dmcdDoc) {
        this.dmcdDoc = dmcdDoc;
    }
    public String getDmcdProveedor() {
        return this.dmcdProveedor;
    }
    
    public void setDmcdProveedor(String dmcdProveedor) {
        this.dmcdProveedor = dmcdProveedor;
    }
    public String getDmcdDocserie() {
        return this.dmcdDocserie;
    }
    
    public void setDmcdDocserie(String dmcdDocserie) {
        this.dmcdDocserie = dmcdDocserie;
    }
    public Double getDmcdDoctotal() {
        return this.dmcdDoctotal;
    }
    
    public void setDmcdDoctotal(Double dmcdDoctotal) {
        this.dmcdDoctotal = dmcdDoctotal;
    }
    public Date getDmcdDocfecha() {
        return this.dmcdDocfecha;
    }
    
    public void setDmcdDocfecha(Date dmcdDocfecha) {
        this.dmcdDocfecha = dmcdDocfecha;
    }
    public Integer getDmcdEstado() {
        return this.dmcdEstado;
    }
    
    public void setDmcdEstado(Integer dmcdEstado) {
        this.dmcdEstado = dmcdEstado;
    }




}

