package com.eoi.CitaTe.entities;

import com.eoi.CitaTe.filemanagement.entities.FileDB;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = true)
    private Long id;

    private String email;
    private String pass;
    @Basic(optional = false)
    private boolean activo;

    // Utilizamos  UUID.randomUUID de java util para generar el token de forma aleatoria cada vez que se cree un usuario
    // el token lo utilizaremos en el reset password cuando enviamos el correo al usuario para el cambio de pass
    private String token = UUID.randomUUID().toString();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_id", referencedColumnName = "id_empleado")
    private Empleado empleado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private Cliente cliente;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idrol")
    private Rol rol;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="usuarios_ficheros",
            joinColumns={@JoinColumn(name="usuario_id", referencedColumnName="id_usuario")},
            inverseJoinColumns={@JoinColumn(name="FILE_ID", referencedColumnName="ID")})
    private List<FileDB> filesDB = new ArrayList<>();


}