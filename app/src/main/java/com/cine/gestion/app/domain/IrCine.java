package com.cine.gestion.app.domain;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.Data;

@Entity
@Table(name = "TBL_CINE")
@Data
public class IrCine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo_electronico")
    private String correo_electronico;
    @Column(name = "pelicula_ver")
    private String pelicula_ver;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "hora")
    private String hora;
    @Column(name = "cantidad_adultos")
    private int cantidad_adultos;
    @Column(name = "cantidad_niños")
    private int cantidad_niños;
    @Column(name = "preferencia_asientos")
    private String preferencia_asientos;
    @Column(name = "notificaciones")
    private String notificaciones;

    public IrCine(String nombre, String apellido, String correo_electronico, String pelicula_ver, Date fecha,
            String hora, int cantidad_adultos, int cantidad_niños, String preferencia_asientos,
            String notificaciones) {
    
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.pelicula_ver = pelicula_ver;
        this.fecha = fecha;
        this.hora = hora;
        this.cantidad_adultos = cantidad_adultos;
        this.cantidad_niños = cantidad_niños;
        this.preferencia_asientos = preferencia_asientos;
        this.notificaciones = notificaciones;
    }

    public IrCine() {
    }

}
