package com.georincon.escenarios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "torneo")
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false) //, unique =  true
    private String nombre;

    @Column(length = 20)
    private String categoria;

    @Column(length = 10, name = "fecha_inicio")
    private String  fechaIni;

    @Column(length = 10, name = "fecha_fin")
    private String fechaFin;

    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipioId;

    public Torneo(Integer id) {
        super();
        this.id = id;
    }

    public Torneo(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Torneo(String nombre, String categoria, String fechaIni, String fechaFin, Municipio municipioId) {
        super();
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.municipioId = municipioId;
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fechaIni=" + fechaIni +
                ", fechaFin=" + fechaFin +
                ", municipioId=" + municipioId +
                '}';
    }

}
