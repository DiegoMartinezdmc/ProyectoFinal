package org.kkbp.internacionalizacion.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ReportDetail {
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String oid;

    @Required(message = "Debe ingresar el número de estudiantes enviados.")
    private int sentStudents;

    @Required(message = "Debe ingresar el número de estudiantes recibidos.")
    private int receivedStudents;

    @Required(message = "Debe ingresar el número de estudiantes en modalidad virtual.")
    private int virtualModeStudents;

    @Required(message = "Debe ingresar el número de docentes enviados.")
    private int sentTeachers;

    @Required(message = "Debe ingresar el número de docentes recibidos.")
    private int receivedTeachers;

    @Required(message = "Debe ingresar el número de docentes en modalidad virtual.")
    private int virtualModeTeachers;

    @Required(message = "Debe ingresar número de eventos realizados.")
    private int events;

    @Column(length = 200)
    @Required(message = "Debe ingresar los desafíos encontrados durante las actividades.")
    private String challenges;

    @Column(length = 200)
    @Required(message = "Debe ingresar las oportunidades encontradas durante las actividades.")
    private String opportunities;

    @Column(length = 200)
    @Required(message = "Debe ingresar las estrategias para futuras actividades.")
    private String futureStrategies;

    @Column(length = 200)
    @Required(message = "Debe ingresar las necesidades para futuras actividades.")
    private String necessities;

    @Column(length = 200)
    @Required(message = "Debe ingresar las recomendaciones para futuras actividades.")
    private String suggestions;
}
