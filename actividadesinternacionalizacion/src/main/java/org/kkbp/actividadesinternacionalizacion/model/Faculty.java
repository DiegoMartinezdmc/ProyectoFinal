package org.kkbp.actividadesinternacionalizacion.model;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter
@Setter
public class Faculty {
	@Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String faculty_oid;

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
    @DescriptionsList
    private Career career;
}
