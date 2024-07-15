package com.exemple.forohub.DTO;

import com.exemple.forohub.enumerador.Categoria;
import com.exemple.forohub.model.Curso;

public record DatosListadoCurso(
        String nombre,
        Categoria categoriaPrincipal,
        String subcategoria) {

    public DatosListadoCurso(Curso curso) {
        this(
                curso.getNombre(),
                curso.getCategoriaPrincipal(),
                curso.getSubcategoria()
        );
    }
}
