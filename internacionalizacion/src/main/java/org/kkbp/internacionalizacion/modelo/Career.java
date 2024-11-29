package org.kkbp.internacionalizacion.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Career {
    @Id @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String oid;

    @Column(length = 100)
    @Required(message = "Debe ingresar el nombre completo de la carrera.")
    private String name;

    @Column(length = 100)
    @Required(message = "Debe ingresar el titulo y nombre del coordinador.")
    private String coordinator;
}
