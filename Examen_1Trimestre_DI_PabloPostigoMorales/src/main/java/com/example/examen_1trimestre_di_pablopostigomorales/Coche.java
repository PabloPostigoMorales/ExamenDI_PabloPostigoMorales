package com.example.examen_1trimestre_di_pablopostigomorales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
public class Coche {
    @Setter
    @Getter
    private String matricula;

    @Setter
    @Getter
    private String modelo;

    @Setter
    @Getter
    private Cliente cliente;
}
