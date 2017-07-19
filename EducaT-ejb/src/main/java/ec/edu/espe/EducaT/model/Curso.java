/*
 * The MIT License
 *
 * Copyright 2017 David Suarez.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ec.edu.espe.EducaT.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase encargada de obtener los datos de la base de datos EducaTBD.
 *
 * @author Adrián Calvopiña, Jonathan Almeida, David Suarez.
 * @version 1.0
 */

@Entity
@Table(name = "curso", catalog = "educat", schema = "")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_CURSO")
    /**
     * Clave primaria que corresponde al ID que tiene el curso en cuestión.
     */
    private String codCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    /**
     * Nombre que recibe el curso que puede ser impartido en un prograam de capacitación
     */
    private String nombre;
    @Size(max = 4000)
    @Column(name = "OBJETIVO")
    /**
     * Es el objetivo que se pretende alcanzar con el curso que se aprende.
     */
    private String objetivo;
    @Size(max = 4000)
    @Column(name = "DESCRIPCION")
    /**
     * Detalles específicos de lo que es el curso y en que consiste el aprendizaje que se ira a recibir.
     */
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION")
    /**
     * Duración que tiene el curso en un periodo de tiempo, en este caso número de horas.
     */
    private short duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    /**
     * Es el estado del curos, y se lo puede encontrar en los estados de "activo" e "inactivo".
     */
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCurso")
    /**
     * Lista de las capacitaciones.
     */
    private List<Capacitacion> capacitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    /**
     * Lista de las realciones que exiten entre el curso y un programa.
     */
    private List<ProgramaCurso> programaCursoList;

    public Curso() {
    }

    /**
     * 
     * @param codCurso 
     */
    public Curso(String codCurso) {
        this.codCurso = codCurso;
    }

    /**
     * 
     * @param codCurso
     * @param nombre
     * @param duracion
     * @param estado 
     */
    public Curso(String codCurso, String nombre, short duracion, String estado) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estado = estado;
    }

    /**
     * 
     * @return 
     */
    public String getCodCurso() {
        return codCurso;
    }

    /**
     * 
     * @param codCurso 
     */
    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    /**
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return 
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * 
     * @param objetivo 
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * 
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return 
     */
    public short getDuracion() {
        return duracion;
    }

    /**
     * 
     * @param duracion 
     */
    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }

    /**
     * 
     * @return 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * 
     * @param estado 
     */
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
