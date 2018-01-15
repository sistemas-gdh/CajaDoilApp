package Modelo;
// Generated 08/01/2018 10:56:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * SubMcs generated by hbm2java
 */
public class SubMcs  implements java.io.Serializable {


     private Long smId;
     private Choferes choferes;
     private MovimientosCajas movimientosCajas;
     private Remolques remolques;
     private ServTransporte servTransporte;
     private Tractos tractos;
     private Double smViaticos;
     private Double smHospedaje;
     private Double smEnc;
     private Double smDesc;
     private Double smVigilancia;
     private Double smPropina;
     private Double smTotal;
     private Double smTotalliq;
     private Double smDevolucion;
     private Double smReintegro;
     private Integer smEstado;
     private Set<SmDesc> smDescs = new HashSet<SmDesc>(0);
     private Set<SmHospedaje> smHospedajes = new HashSet<SmHospedaje>(0);
     private Set<SmViaticos> smViaticoses = new HashSet<SmViaticos>(0);
     private Set<SmVigilancia> smVigilancias = new HashSet<SmVigilancia>(0);
     private Set<SmPropina> smPropinas = new HashSet<SmPropina>(0);
     private Set<SmEnc> smEncs = new HashSet<SmEnc>(0);

    public SubMcs() {
    }

    public SubMcs(Choferes choferes, MovimientosCajas movimientosCajas, Remolques remolques, ServTransporte servTransporte, Tractos tractos, Double smViaticos, Double smHospedaje, Double smEnc, Double smDesc, Double smVigilancia, Double smPropina, Double smTotal, Double smTotalliq, Double smDevolucion, Double smReintegro, Integer smEstado) {
        this.choferes = choferes;
        this.movimientosCajas = movimientosCajas;
        this.remolques = remolques;
        this.servTransporte = servTransporte;
        this.tractos = tractos;
        this.smViaticos = smViaticos;
        this.smHospedaje = smHospedaje;
        this.smEnc = smEnc;
        this.smDesc = smDesc;
        this.smVigilancia = smVigilancia;
        this.smPropina = smPropina;
        this.smTotal = smTotal;
        this.smTotalliq = smTotalliq;
        this.smDevolucion = smDevolucion;
        this.smReintegro = smReintegro;
        this.smEstado = smEstado;
    }

    public SubMcs(Choferes choferes, MovimientosCajas movimientosCajas, Remolques remolques, ServTransporte servTransporte, Tractos tractos, Double smViaticos, Double smHospedaje, Double smEnc, Double smDesc, Double smVigilancia, Double smPropina, Double smTotal, Double smTotalliq, Double smDevolucion, Double smReintegro, Integer smEstado, Set<SmDesc> smDescs, Set<SmHospedaje> smHospedajes, Set<SmViaticos> smViaticoses, Set<SmVigilancia> smVigilancias, Set<SmPropina> smPropinas, Set<SmEnc> smEncs) {
       this.choferes = choferes;
       this.movimientosCajas = movimientosCajas;
       this.remolques = remolques;
       this.servTransporte = servTransporte;
       this.tractos = tractos;
       this.smViaticos = smViaticos;
       this.smHospedaje = smHospedaje;
       this.smEnc = smEnc;
       this.smDesc = smDesc;
       this.smVigilancia = smVigilancia;
       this.smPropina = smPropina;
       this.smTotal = smTotal;
       this.smTotalliq = smTotalliq;
       this.smDevolucion = smDevolucion;
       this.smReintegro = smReintegro;
       this.smEstado = smEstado;
       this.smDescs = smDescs;
       this.smHospedajes = smHospedajes;
       this.smViaticoses = smViaticoses;
       this.smVigilancias = smVigilancias;
       this.smPropinas = smPropinas;
       this.smEncs = smEncs;
    }
   
    public Long getSmId() {
        return this.smId;
    }
    
    public void setSmId(Long smId) {
        this.smId = smId;
    }
    public Choferes getChoferes() {
        return this.choferes;
    }
    
    public void setChoferes(Choferes choferes) {
        this.choferes = choferes;
    }
    public MovimientosCajas getMovimientosCajas() {
        return this.movimientosCajas;
    }
    
    public void setMovimientosCajas(MovimientosCajas movimientosCajas) {
        this.movimientosCajas = movimientosCajas;
    }
    public Remolques getRemolques() {
        return this.remolques;
    }
    
    public void setRemolques(Remolques remolques) {
        this.remolques = remolques;
    }
    public ServTransporte getServTransporte() {
        return this.servTransporte;
    }
    
    public void setServTransporte(ServTransporte servTransporte) {
        this.servTransporte = servTransporte;
    }
    public Tractos getTractos() {
        return this.tractos;
    }
    
    public void setTractos(Tractos tractos) {
        this.tractos = tractos;
    }
    public Double getSmViaticos() {
        return this.smViaticos;
    }
    
    public void setSmViaticos(Double smViaticos) {
        this.smViaticos = smViaticos;
    }
    public Double getSmHospedaje() {
        return this.smHospedaje;
    }
    
    public void setSmHospedaje(Double smHospedaje) {
        this.smHospedaje = smHospedaje;
    }
    public Double getSmEnc() {
        return this.smEnc;
    }
    
    public void setSmEnc(Double smEnc) {
        this.smEnc = smEnc;
    }
    public Double getSmDesc() {
        return this.smDesc;
    }
    
    public void setSmDesc(Double smDesc) {
        this.smDesc = smDesc;
    }
    public Double getSmVigilancia() {
        return this.smVigilancia;
    }
    
    public void setSmVigilancia(Double smVigilancia) {
        this.smVigilancia = smVigilancia;
    }
    public Double getSmPropina() {
        return this.smPropina;
    }
    
    public void setSmPropina(Double smPropina) {
        this.smPropina = smPropina;
    }
    public Double getSmTotal() {
        return this.smTotal;
    }
    
    public void setSmTotal(Double smTotal) {
        this.smTotal = smTotal;
    }
    public Double getSmTotalliq() {
        return this.smTotalliq;
    }
    
    public void setSmTotalliq(Double smTotalliq) {
        this.smTotalliq = smTotalliq;
    }
    public Double getSmDevolucion() {
        return this.smDevolucion;
    }
    
    public void setSmDevolucion(Double smDevolucion) {
        this.smDevolucion = smDevolucion;
    }
    public Double getSmReintegro() {
        return this.smReintegro;
    }
    
    public void setSmReintegro(Double smReintegro) {
        this.smReintegro = smReintegro;
    }
    public Integer getSmEstado() {
        return this.smEstado;
    }
    
    public void setSmEstado(Integer smEstado) {
        this.smEstado = smEstado;
    }
    public Set<SmDesc> getSmDescs() {
        return this.smDescs;
    }
    
    public void setSmDescs(Set<SmDesc> smDescs) {
        this.smDescs = smDescs;
    }
    public Set<SmHospedaje> getSmHospedajes() {
        return this.smHospedajes;
    }
    
    public void setSmHospedajes(Set<SmHospedaje> smHospedajes) {
        this.smHospedajes = smHospedajes;
    }
    public Set<SmViaticos> getSmViaticoses() {
        return this.smViaticoses;
    }
    
    public void setSmViaticoses(Set<SmViaticos> smViaticoses) {
        this.smViaticoses = smViaticoses;
    }
    public Set<SmVigilancia> getSmVigilancias() {
        return this.smVigilancias;
    }
    
    public void setSmVigilancias(Set<SmVigilancia> smVigilancias) {
        this.smVigilancias = smVigilancias;
    }
    public Set<SmPropina> getSmPropinas() {
        return this.smPropinas;
    }
    
    public void setSmPropinas(Set<SmPropina> smPropinas) {
        this.smPropinas = smPropinas;
    }
    public Set<SmEnc> getSmEncs() {
        return this.smEncs;
    }
    
    public void setSmEncs(Set<SmEnc> smEncs) {
        this.smEncs = smEncs;
    }




}

