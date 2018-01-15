package Modelo;
// Generated 08/01/2018 10:56:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer usuarioId;
     private Cargos cargos;
     private Departamentos departamentos;
     private String usuarioUser;
     private String usuarioPassword;
     private String usuarioNombres;
     private Integer usuarioPermisos;
     private Integer usuarioEstado;
     private Set<MovimientosCajasd> movimientosCajasds = new HashSet<MovimientosCajasd>(0);
     private Set<SolicitudViaticos> solicitudViaticoses = new HashSet<SolicitudViaticos>(0);
     private Set<MovimientosCajas> movimientosCajases = new HashSet<MovimientosCajas>(0);
     private Set<SolicitudCaja> solicitudCajas = new HashSet<SolicitudCaja>(0);

    public Usuarios() {
    }

    public Usuarios(Cargos cargos, Departamentos departamentos, String usuarioUser, String usuarioPassword, String usuarioNombres, Integer usuarioPermisos, Integer usuarioEstado) {
        this.cargos = cargos;
        this.departamentos = departamentos;
        this.usuarioUser = usuarioUser;
        this.usuarioPassword = usuarioPassword;
        this.usuarioNombres = usuarioNombres;
        this.usuarioPermisos = usuarioPermisos;
        this.usuarioEstado = usuarioEstado;
    }

    public Usuarios(Cargos cargos, Departamentos departamentos, String usuarioUser, String usuarioPassword, String usuarioNombres, Integer usuarioPermisos, Integer usuarioEstado, Set<MovimientosCajasd> movimientosCajasds, Set<SolicitudViaticos> solicitudViaticoses, Set<MovimientosCajas> movimientosCajases, Set<SolicitudCaja> solicitudCajas) {
       this.cargos = cargos;
       this.departamentos = departamentos;
       this.usuarioUser = usuarioUser;
       this.usuarioPassword = usuarioPassword;
       this.usuarioNombres = usuarioNombres;
       this.usuarioPermisos = usuarioPermisos;
       this.usuarioEstado = usuarioEstado;
       this.movimientosCajasds = movimientosCajasds;
       this.solicitudViaticoses = solicitudViaticoses;
       this.movimientosCajases = movimientosCajases;
       this.solicitudCajas = solicitudCajas;
    }
   
    public Integer getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Cargos getCargos() {
        return this.cargos;
    }
    
    public void setCargos(Cargos cargos) {
        this.cargos = cargos;
    }
    public Departamentos getDepartamentos() {
        return this.departamentos;
    }
    
    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }
    public String getUsuarioUser() {
        return this.usuarioUser;
    }
    
    public void setUsuarioUser(String usuarioUser) {
        this.usuarioUser = usuarioUser;
    }
    public String getUsuarioPassword() {
        return this.usuarioPassword;
    }
    
    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }
    public String getUsuarioNombres() {
        return this.usuarioNombres;
    }
    
    public void setUsuarioNombres(String usuarioNombres) {
        this.usuarioNombres = usuarioNombres;
    }
    public Integer getUsuarioPermisos() {
        return this.usuarioPermisos;
    }
    
    public void setUsuarioPermisos(Integer usuarioPermisos) {
        this.usuarioPermisos = usuarioPermisos;
    }
    public Integer getUsuarioEstado() {
        return this.usuarioEstado;
    }
    
    public void setUsuarioEstado(Integer usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }
    public Set<MovimientosCajasd> getMovimientosCajasds() {
        return this.movimientosCajasds;
    }
    
    public void setMovimientosCajasds(Set<MovimientosCajasd> movimientosCajasds) {
        this.movimientosCajasds = movimientosCajasds;
    }
    public Set<SolicitudViaticos> getSolicitudViaticoses() {
        return this.solicitudViaticoses;
    }
    
    public void setSolicitudViaticoses(Set<SolicitudViaticos> solicitudViaticoses) {
        this.solicitudViaticoses = solicitudViaticoses;
    }
    public Set<MovimientosCajas> getMovimientosCajases() {
        return this.movimientosCajases;
    }
    
    public void setMovimientosCajases(Set<MovimientosCajas> movimientosCajases) {
        this.movimientosCajases = movimientosCajases;
    }
    public Set<SolicitudCaja> getSolicitudCajas() {
        return this.solicitudCajas;
    }
    
    public void setSolicitudCajas(Set<SolicitudCaja> solicitudCajas) {
        this.solicitudCajas = solicitudCajas;
    }




}

