package com.example.examen_1trimestre_di_pablopostigomorales;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
