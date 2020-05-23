/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class Tweet {
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sec_twe", sequenceName = "tweets_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_twe", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="fecha") 
    private Date fecha;
    @Column(name="contenido")
    private String contenido;
    @Column(name="likes")
    private Integer likes;
    
   
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario; 
    
    @ManyToMany(mappedBy = "tweets")
    private List<Hashtag> hashtags;
    
    @OneToOne(mappedBy = "tweet")
    private Lugar lugar;
    
    @OneToOne(mappedBy = "tweet")
    private Emocion emocion;

    public Emocion getEmocion() {
        return emocion;
    }

    public void setEmocion(Emocion emocion) {
        this.emocion = emocion;
    }   
    
    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
    
    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   
      

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
    
    
    
}
