/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.EducaT.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adrián
 */
@Entity
@Table(name = "curso", catalog = "educat", schema = "")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_CURSO")
    private String codCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 4000)
    @Column(name = "OBJETIVO")
    private String objetivo;
    @Size(max = 4000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION")
    private short duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCurso")
    private List<Capacitacion> capacitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<ProgramaCurso> programaCursoList;

    public Curso() {
    }

    public Curso(String codCurso) {
        this.codCurso = codCurso;
    }

    public Curso(String codCurso, String nombre, short duracion, String estado) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estado = estado;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getDuracion() {
        return duracion;
    }

    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Capacitacion> getCapacitacionList() {
        return capacitacionList;
    }

    public void setCapacitacionList(List<Capacitacion> capacitacionList) {
        this.capacitacionList = capacitacionList;
    }

    public List<ProgramaCurso> getProgramaCursoList() {
        return programaCursoList;
    }

    public void setProgramaCursoList(List<ProgramaCurso> programaCursoList) {
        this.programaCursoList = programaCursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.EducaT.model.Curso[ codCurso=" + codCurso + " ]";
    }
    
}
