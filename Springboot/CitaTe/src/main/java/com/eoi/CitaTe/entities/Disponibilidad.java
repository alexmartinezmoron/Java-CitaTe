package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "disponibilidad")
public class Disponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_disponibilidad", nullable = false)
    private Long id;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private LocalDate fecha;

// en lugar de por nombre por numero empezando desde el 0
    private int diaDeLaSemana;
    private String horaInicioManiana;
    private String horaFinManiana;
    private String horaInicioTarde;
    private String horaFinTarde;
    //Formato para dias laborables
    // 0;2;3;4;5
    private String diaslaborables;

    @OneToMany(mappedBy = "disponibilidad", cascade = CascadeType.ALL)

    private Set<Empleado> empleado;

}