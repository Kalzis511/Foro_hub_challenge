package com.exemple.forohub.DTO;

import com.exemple.forohub.enumerador.Categoria;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        
        @NotBlank(message = "El nombre es obligatorio") String nombre,
        Categoria categoriaPrincipal,
        String subcategoria
        ) {
}
