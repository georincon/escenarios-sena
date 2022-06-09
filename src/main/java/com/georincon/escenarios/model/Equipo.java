package com.georincon.escenarios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50) //, nullable = false, unique =  true
    private String nombre;

    @Column(length = 20)
    private String deporte;

    @Column(length = 10, name = "fecha_creacion")
    private String fechaCrea;

    @Column(length = 50)
    private String entrenador;

    @ManyToOne
    @JoinColumn(name = "patrocinador_id")
    private Patrocinador patrocinadorId;

    public Equipo(Integer id) {
        super();
        this.id = id;
    }

    public Equipo(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Equipo(String nombre, String deporte, String fechaCrea, String entrenador, Patrocinador patrocinadorId) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.fechaCrea = fechaCrea;
        this.entrenador = entrenador;
        this.patrocinadorId = patrocinadorId;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", deporte='" + deporte + '\'' +
                ", fechaCrea=" + fechaCrea +
                ", entrenador='" + entrenador + '\'' +
                ", patrocinadorId=" + patrocinadorId +
                '}';
    }

}
