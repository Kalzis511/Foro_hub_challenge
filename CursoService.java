package com.exemple.forohub.service;

import com.exemple.forohub.DTO.DatosRegistroCurso;
import com.exemple.forohub.model.Curso;
import com.exemple.forohub.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    
    @Autowired
    private ICursoRepository cursoRepo;
    
    public Curso registrarCurso(DatosRegistroCurso datosRegistroCurso){
        Curso curso = new Curso(datosRegistroCurso);
        
        return cursoRepo.save(curso);
    }   
}
