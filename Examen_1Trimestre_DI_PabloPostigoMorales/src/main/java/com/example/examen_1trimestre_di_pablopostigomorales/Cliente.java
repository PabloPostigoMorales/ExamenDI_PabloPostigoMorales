package com.example.examen_1trimestre_di_pablopostigomorales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
public class Cliente {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String correo;
}
