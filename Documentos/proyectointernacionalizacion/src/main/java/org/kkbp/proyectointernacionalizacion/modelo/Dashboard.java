package org.kkbp.proyectointernacionalizacion.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@View(members =
        "faculty;" +
                "semester;" +
                "year;" +
                "totals [" +
                "   totalSentStudents, totalReceivedStudents, totalVirtualModeStudents;" +
                "   totalSentTeachers, totalReceivedTeachers, totalVirtualModeTeachers;" +
                "]")
public class Dashboard {
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String oid;

    @DescriptionsList
    @ManyToOne
    private Faculty faculty;

    @Required
    private Semester semester;

    @Required
    @Column(length = 4)
    private String year;

    @Stereotype("NUMERIC")
    private int totalSentStudents;

    @Stereotype("NUMERIC")
    private int totalReceivedStudents;

    @Stereotype("NUMERIC")
    private int totalVirtualModeStudents;

    @Stereotype("NUMERIC")
    private int totalSentTeachers;

    @Stereotype("NUMERIC")
    private int totalReceivedTeachers;

    @Stereotype("NUMERIC")
    private int totalVirtualModeTeachers;
}
