/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ignacio
 */
@Entity
@Table(name = "ficha")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
	@NamedQuery(name = "Ficha.findByFichaId", query = "SELECT f FROM Ficha f WHERE f.fichaId = :fichaId"),
	@NamedQuery(name = "Ficha.findByFecha", query = "SELECT f FROM Ficha f WHERE f.fecha = :fecha")})
public class Ficha implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ficha_id")
	private Integer fichaId;
	@Lob
    @Size(max = 65535)
    @Column(name = "diagnostico")
	private String diagnostico;
	@Lob
    @Size(max = 65535)
    @Column(name = "recetario")
	private String recetario;
	@Column(name = "fecha")
    @Temporal(TemporalType.DATE)
	private Date fecha;
	@JoinColumn(name = "mascota_id", referencedColumnName = "mascota_id")
    @ManyToOne
	private Mascota mascotaId;

	public Ficha() {
	}

	public Ficha(Integer fichaId) {
		this.fichaId = fichaId;
	}

	public Integer getFichaId() {
		return fichaId;
	}

	public void setFichaId(Integer fichaId) {
		this.fichaId = fichaId;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getRecetario() {
		return recetario;
	}

	public void setRecetario(String recetario) {
		this.recetario = recetario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Mascota getMascotaId() {
		return mascotaId;
	}

	public void setMascotaId(Mascota mascotaId) {
		this.mascotaId = mascotaId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fichaId != null ? fichaId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Ficha)) {
			return false;
		}
		Ficha other = (Ficha) object;
		if ((this.fichaId == null && other.fichaId != null) || (this.fichaId != null && !this.fichaId.equals(other.fichaId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "cl.veterinaria.entity.Ficha[ fichaId=" + fichaId + " ]";
	}
	
}
