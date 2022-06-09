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
    private Torneo torneoId;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipoId;

    public TorneoEquipo(Torneo torneoId, Equipo equipoId) {
        super();
        this.torneoId = torneoId;
        this.equipoId = equipoId;
    }

    @Override
    public String toString() {
        return "TorneoEquipo{" +
                "id=" + id +
                ", torneoId=" + torneoId +
                ", equipoId=" + equipoId +
                '}';
    }

}
