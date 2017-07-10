/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
package ec.edu.espe.EducaT.web;

import ec.edu.espe.EducaT.model.Alumno;
import ec.edu.espe.EducaT.service.AlumnosService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class alumnoBean {
    
    @EJB
    private AlumnosService alumnosService;    
    
    private List<Alumno> alumno;
    
    @PostConstruct
    public void inicio(){
       this.alumno = this.alumnosService.obtenerAlumnos();
    }

    public List<Alumno> getAlumno() {
        return alumno;
    }
    
    
}
