package com.example.examen_1trimestre_di_pablopostigomorales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
public class ElementoTabla {
    @Getter
    @Setter
    private String matricula;

    @Getter
    @Setter
    private String modelo;

    @Setter
    @Getter
    private Date fechEntrada;

    @Setter
    @Getter
    private Date fechSalida;

    @Setter
    @Getter
    private String cliente;

    @Setter
    @Getter
    private String tarifa;

    @Setter
    @Getter
    private Integer coste;
}
