package cl.veterinaria.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "mascota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mascota.findAll", query = "SELECT m FROM Mascota m"),
    @NamedQuery(name = "Mascota.findByMascotaId", query = "SELECT m FROM Mascota m WHERE m.mascotaId = :mascotaId"),
    @NamedQuery(name = "Mascota.findByDuenoId", query = "SELECT m FROM Mascota m WHERE m.duenoId.rut = :duenoId"),
    @NamedQuery(name = "Mascota.findByNombre", query = "SELECT m FROM Mascota m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mascota.findLikeNombre", query = "SELECT m FROM Mascota m WHERE m.nombre like :nombre"),
    @NamedQuery(name = "Mascota.findByRaza", query = "SELECT m FROM Mascota m WHERE m.raza = :raza"),
    @NamedQuery(name = "Mascota.findBySexo", query = "SELECT m FROM Mascota m WHERE m.sexo = :sexo"),
    @NamedQuery(name = "Mascota.findByFechaNacimiento", query = "SELECT m FROM Mascota m WHERE m.fechaNacimiento = :fechaNacimiento")})
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mascota_id")
    private Integer mascotaId;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 60)
    @Column(name = "raza")
    private String raza;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToMany(mappedBy = "mascotaId")
    private List<Ficha> fichaList;
    @JoinColumn(name = "dueno_id", referencedColumnName = "rut")
    @ManyToOne
    private Dueno duenoId;
    @JoinColumn(name = "tipo_animal_id", referencedColumnName = "tipo_animal_id")
    @ManyToOne
    private TipoAnimal tipoAnimalId;

    public Mascota() {
    }

    public Mascota(Integer mascotaId) {
        this.mascotaId = mascotaId;
    }

    public Integer getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Integer mascotaId) {
        this.mascotaId = mascotaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    public Dueno getDuenoId() {
        return duenoId;
    }

    public void setDuenoId(Dueno duenoId) {
        this.duenoId = duenoId;
    }

    public TipoAnimal getTipoAnimalId() {
        return tipoAnimalId;
    }

    public void setTipoAnimalId(TipoAnimal tipoAnimalId) {
        this.tipoAnimalId = tipoAnimalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mascotaId != null ? mascotaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascota)) {
            return false;
        }
        Mascota other = (Mascota) object;
        if ((this.mascotaId == null && other.mascotaId != null) || (this.mascotaId != null && !this.mascotaId.equals(other.mascotaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.veterinaria.entity.Mascota[ mascotaId=" + mascotaId + " ]";
    }
    
}
