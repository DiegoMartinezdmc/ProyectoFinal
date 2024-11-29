package org.kkbp.internacionalizacion.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.DateTime;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Report {
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String oid;

    @Column(length = 60)
    @Required(message = "Debe ingresar el titulo del reporte.")
    private String title;

    @DateTime
    @Required(message = "Debe ingresar la fecha de creacion del reporte.")
    private LocalDate creationDate;

    @OneToOne
    private Faculty faculty;
}
