package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Long id;

    private String nombreCliente;
    private String apellido1Cliente;
    private String apellido2Cliente;
    private String telefono;

    @Lob
    private byte[] icono;

    @OneToOne(mappedBy = "cliente")
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Reserva> reservas = new HashSet<>();



// Metodo de sincronizacion
    public void addReserva(Reserva reserva){
        reservas.add(reserva);
        reserva.setCliente(this);
    }


}

