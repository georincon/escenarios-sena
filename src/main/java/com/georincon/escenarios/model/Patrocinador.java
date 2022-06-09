package com.georincon.escenarios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patrocinador")
public class Patrocinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false) //, unique =  true
    private String identificacion;

    @Column(length = 50, nullable = false) //, unique =  true
    private String nombre;

    @Column(length = 150, nullable = false)
    private String direccion;

    @Column(length = 20, nullable = false)
    private String telefono;

    @Column(length = 10, nullable = false)
    private String tipo_persona;

    @Column(length = 100)
    private String correo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patrocinador_id")
    private List<Equipo> equipos = new ArrayList<>();

    public Patrocinador(Integer id) {
        super();
        this.id = id;
    }

    public Patrocinador(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Patrocinador(String identificacion, String nombre, String direccion, String telefono, String tipo_persona, String correo, List<Equipo> equipos) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo_persona = tipo_persona;
        this.correo = correo;
       // this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "Patrocinador{" +
                "id=" + id +
                ", identificacion='" + identificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipo_persona='" + tipo_persona + '\'' +
                ", correo='" + correo + '\'' +
            //    ", equipos=" + equipos +
                '}';
    }

    /*
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Patrocinador other = (Patrocinador) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

*/
}
