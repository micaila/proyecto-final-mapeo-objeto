/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="lugares")
public class Lugar {

    @Id
    @SequenceGenerator(name = "sec_lug", sequenceName = "lugares_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_lug", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="latitud")
    private Double latitud;
    @Column(name="longitud")
    private Double longitud;
    
    @OneToOne
    @JoinColumn(name="id_tweet")
    private Tweet tweet;
    
    @ManyToOne
    @JoinColumn(name="id_pais")
    private Pais pais;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }   
    
    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
