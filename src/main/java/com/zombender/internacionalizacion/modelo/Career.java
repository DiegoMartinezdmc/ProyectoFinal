package com.zombender.internacionalizacion.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Career {
    @Id @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String career_oid;

    @Column(length = 100)
    @Required(message = "Debe ingresar el nombre completo de la carrera.")
    private String name;

    @Column(length = 100)
    @Required(message = "Debe ingresar el titulo y nombre del coordinador.")
    private String coordinator;
}