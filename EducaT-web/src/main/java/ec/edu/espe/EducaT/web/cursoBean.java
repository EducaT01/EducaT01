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

import ec.edu.espe.EducaT.model.Curso;
import ec.edu.espe.EducaT.service.CursoService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class cursoBean {
    
    @EJB
    private CursoService cursoService;    
    
    private List<Curso> curso;
    
    @PostConstruct
    public void inicio(){
       this.curso = this.cursoService.ListaCurso();
    }

    public List<Curso> getCurso() {
        return curso;
    }
    
    
}
