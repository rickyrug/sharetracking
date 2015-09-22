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
@Table(name = "resultados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultados.findAll", query = "SELECT r FROM Resultados r"),
    @NamedQuery(name = "Resultados.findByIdresultados", query = "SELECT r FROM Resultados r WHERE r.idresultados = :idresultados"),
    @NamedQuery(name = "Resultados.findByFecha", query = "SELECT r FROM Resultados r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Resultados.findByValor", query = "SELECT r FROM Resultados r WHERE r.valor = :valor"),
    @NamedQuery(name = "Resultados.findByProfit", query = "SELECT r FROM Resultados r WHERE r.profit = :profit"),
    @NamedQuery(name = "Resultados.findByRendimiento", query = "SELECT r FROM Resultados r WHERE r.rendimiento = :rendimiento"),
    @NamedQuery(name = "Resultados.findByPortafolios", query = "SELECT r FROM Resultados r WHERE r.protafolios = :portafolios")
})
public class Resultados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresultados")
    private Integer idresultados;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "profit")
    private double profit;
    @Basic(optional = false)
    @Column(name = "rendimiento")
    private double rendimiento;
    @JoinColumn(name = "protafolios", referencedColumnName = "idportafolios")
    @ManyToOne(optional = false)
    private Portafolios protafolios;

    public Resultados() {
    }

    public Resultados(Integer idresultados) {
        this.idresultados = idresultados;
    }

    public Resultados(Integer idresultados, Date fecha, double valor, double profit, double rendimiento) {
        this.idresultados = idresultados;
        this.fecha = fecha;
        this.valor = valor;
        this.profit = profit;
        this.rendimiento = rendimiento;
    }

    public Integer getIdresultados() {
        return idresultados;
    }

    public void setIdresultados(Integer idresultados) {
        this.idresultados = idresultados;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    public Portafolios getProtafolios() {
        return protafolios;
    }

    public void setProtafolios(Portafolios protafolios) {
        this.protafolios = protafolios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultados != null ? idresultados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultados)) {
            return false;
        }
        Resultados other = (Resultados) object;
        if ((this.idresultados == null && other.idresultados != null) || (this.idresultados != null && !this.idresultados.equals(other.idresultados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Resultados[ idresultados=" + idresultados + " ]";
    }
    
}
