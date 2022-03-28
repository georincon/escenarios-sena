package com.georincon.escenarios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "torneo_equipo")
public class TorneoEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public TorneoEquipo(Torneo torneo, Equipo equipo) {
        super();
        this.torneo = torneo;
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "TorneoEquipo{" +
                "id=" + id +
                ", torneo=" + torneo +
                ", equipo=" + equipo +
                '}';
    }

}
