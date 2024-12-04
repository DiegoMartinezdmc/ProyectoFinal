package com.zombender.internacionalizacion.modelo;

import java.time.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

enum Semester {
    I, II
}

@Entity
@Getter
@Setter
public class Report {
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String report_oid;

    @Column(length = 60)
    @Required(message = "Debe ingresar el t�tulo del reporte.")
    private String title;

    @Required(message = "Debe ingresar la fecha de creaci�n del reporte.")
    private LocalDate creationDate;

    @Column(length = 4)
    @Required(message = "Debe especificar el a�o que comprende el reporte.")
    private String year;

    @ManyToOne(fetch = FetchType.EAGER)
    @DescriptionsList
    private Faculty faculty;

    @Required(message = "Debe ingresar el n�mero de estudiantes enviados.")
    private int sentStudents;

    @Required(message = "Debe ingresar el n�mero de estudiantes recibidos.")
    private int receivedStudents;

    @Required(message = "Debe ingresar el n�mero de estudiantes en modalidad virtual.")
    private int virtualModeStudents;

    @Required(message = "Debe ingresar el n�mero de docentes enviados.")
    private int sentTeachers;

    @Required(message = "Debe ingresar el n�mero de docentes recibidos.")
    private int receivedTeachers;

    @Required(message = "Debe ingresar el n�mero de docentes en modalidad virtual.")
    private int virtualModeTeachers;

    @Required(message = "Debe ingresar el n�mero de eventos realizados.")
    private int events;

    @Column(length = 200)
    @Required(message = "Debe ingresar los desaf�os encontrados durante las actividades.")
    private String challenges;

    @Column(length = 200)
    @Required(message = "Debe ingresar las oportunidades encontradas durante las actividades.")
    private String opportunities;

    @Column(length = 200)
    @Required(message = "Debe ingresar las estrategias para futuras actividades.")
    private String futureStrategies;

    @Column(length = 200)
    private String necessities;

    @Column(length = 200)
    private String suggestions;
}
