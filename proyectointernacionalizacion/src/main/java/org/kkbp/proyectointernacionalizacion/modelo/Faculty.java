package org.kkbp.proyectointernacionalizacion.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter
@Setter
public class Faculty {
    @Id @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String oid;

    @Column(length = 50)
    @Required(message = "Debe ingresar el nombre de la facultad.")
    private String name;

    @Column(length = 6)
    @Required(message = "Debe ingresar las iniciales de la facultad.")
    private String abbreviation;

    @Column(length = 100)
    @Required(message = "Debe ingresar el titulo y nombre del decano.")
    private String dean;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Career career;
}
