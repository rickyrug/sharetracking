/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 60044723
 */
@Entity
@Table(name = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o"),
    @NamedQuery(name = "Operaciones.findByIdaportaciones", query = "SELECT o FROM Operaciones o WHERE o.idaportaciones = :idaportaciones"),
    @NamedQuery(name = "Operaciones.findByFecha", query = "SELECT o FROM Operaciones o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Operaciones.findByCantidad", query = "SELECT o FROM Operaciones o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "Operaciones.findByTipooperacion", query = "SELECT o FROM Operaciones o WHERE o.tipooperacion = :tipooperacion"),
    @NamedQuery(name = "Operaciones.getSumbyOperation", query = "SELECT sum(o.cantidad) FROM Operaciones o WHERE o.portafolios = :portafolios and o.fecha <= :fecha and o.tipooperacion =:operacion"),
    @NamedQuery(name = "Operaciones.findaportacionesbyportafolios", query = "SELECT o FROM Operaciones o WHERE o.portafolios = :portafolios and o.tipooperacion =:operacion")
})
public class Operaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaportaciones")
    private Integer idaportaciones;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @Column(name = "tipooperacion")
    private String tipooperacion;
    @JoinColumn(name = "portafolios", referencedColumnName = "idportafolios")
    @ManyToOne(optional = false)
    private Portafolios portafolios;

    public Operaciones() {
    }

    public Operaciones(Integer idaportaciones) {
        this.idaportaciones = idaportaciones;
    }

    public Operaciones(Integer idaportaciones, Date fecha, double cantidad) {
        this.idaportaciones = idaportaciones;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Integer getIdaportaciones() {
        return idaportaciones;
    }

    public void setIdaportaciones(Integer idaportaciones) {
        this.idaportaciones = idaportaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(String tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    public Portafolios getPortafolios() {
        return portafolios;
    }

    public void setPortafolios(Portafolios portafolios) {
        this.portafolios = portafolios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaportaciones != null ? idaportaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.idaportaciones == null && other.idaportaciones != null) || (this.idaportaciones != null && !this.idaportaciones.equals(other.idaportaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Operaciones[ idaportaciones=" + idaportaciones + " ]";
    }
    
}
