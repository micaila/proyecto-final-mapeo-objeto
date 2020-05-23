/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "paises")
public class Pais {
    
    @Id
    @SequenceGenerator(name = "sec_pai", sequenceName = "paises_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_pai", strategy = GenerationType.SEQUENCE)
    private Integer id; 
    @Column(name="codigo")
    private String codigo;
    @Column(name="nombre")
    private String nombre;
    @Column(name="latitud")
    private Double latitud;
    @Column(name="longitud")
    private Double longitud;
    @OneToMany(mappedBy="pais")
    private List<Lugar> lugares;

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }   
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }  
            

}
