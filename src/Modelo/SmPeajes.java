/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Date;
/**
 *
 * @author ASUS
 */
public class SmPeajes implements java.io.Serializable{
     
    private Long PeId;
     private SubMcs subMcs;
     private String PeDesc;
     private Double PeImporte;
     private Date PeDocfecha;
     private String PeDocserie;
     private String PeProveedor;
     private String PeDoc;
     private Integer PeEstado;

    public SmPeajes() {
    }

    public SmPeajes(SubMcs subMcs, String PeDesc, Double PeImporte, Date PeDocfecha, String PeDocserie, String PeProveedor, String PeDoc, Integer PeEstado) {
        this.subMcs = subMcs;
        this.PeDesc = PeDesc;
        this.PeImporte = PeImporte;
        this.PeDocfecha = PeDocfecha;
        this.PeDocserie = PeDocserie;
        this.PeProveedor = PeProveedor;
        this.PeDoc = PeDoc;
        this.PeEstado = PeEstado;
    }

     
     
    public Long getPeId() {
        return PeId;
    }

    public void setPeId(Long PeId) {
        this.PeId = PeId;
    }

    public SubMcs getSubMcs() {
        return subMcs;
    }

    public void setSubMcs(SubMcs subMcs) {
        this.subMcs = subMcs;
    }

    public String getPeDesc() {
        return PeDesc;
    }

    public void setPeDesc(String PeDesc) {
        this.PeDesc = PeDesc;
    }

    public Double getPeImporte() {
        return PeImporte;
    }

    public void setPeImporte(Double PeImporte) {
        this.PeImporte = PeImporte;
    }

    public Date getPeDocfecha() {
        return PeDocfecha;
    }

    public void setPeDocfecha(Date PeDocfecha) {
        this.PeDocfecha = PeDocfecha;
    }

    public String getPeDocserie() {
        return PeDocserie;
    }

    public void setPeDocserie(String PeDocserie) {
        this.PeDocserie = PeDocserie;
    }

    public String getPeProveedor() {
        return PeProveedor;
    }

    public void setPeProveedor(String PeProveedor) {
        this.PeProveedor = PeProveedor;
    }

    public String getPeDoc() {
        return PeDoc;
    }

    public void setPeDoc(String PeDoc) {
        this.PeDoc = PeDoc;
    }

    public Integer getPeEstado() {
        return PeEstado;
    }

    public void setPeEstado(Integer PeEstado) {
        this.PeEstado = PeEstado;
    }
     
     
     
     
}
