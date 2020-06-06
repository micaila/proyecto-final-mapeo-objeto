/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.curso.daos.TweetDAO;
import mx.uacm.curso.entidades.Pais;

import mx.uacm.curso.entidades.Tweet;

public class TweetDAOImpl extends GenericDAOImpl<Tweet, Integer> implements TweetDAO {

    public TweetDAOImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Tweet> tweetsPorHashtags(List<String> nombresHashtags) {
        TypedQuery<Tweet> consulta =
                em.createQuery("SELECT DISTINCT t "
                        + "FROM Tweet t JOIN t.hashtags h "
                        + "WHERE h.nombre IN :patron",
                        Tweet.class);
        consulta.setParameter("patron", nombresHashtags);
        return consulta.getResultList();    
    }

    @Override
    public List<Integer> tweetsIdsPorHashtagsYFecha(List<String> nombresHashtags, Date fechaMin, Date fechaMax){
        TypedQuery<Integer> consulta =
                em.createQuery("SELECT t.id FROM Tweet t JOIN t.hashtags h "
                        + "WHERE h.nombre IN :patron AND t.fecha "
                        + "BETWEEN :fmin AND :fmax GROUP BY t.id",
                        Integer.class);
        consulta.setParameter("patron", nombresHashtags);
        consulta.setParameter("fmin", fechaMin);
        consulta.setParameter("fmax", fechaMax);
        return consulta.getResultList();    
    }

    @Override
    public List<Integer> filtrarTweetsIdsPorPais(List<Integer> tweetsIds, Pais pais) {

        TypedQuery<Integer> consulta =
                em.createQuery("SELECT l.tweet.id "
                        + "FROM  Lugar l JOIN l.pais p JOIN l.tweet t "
                        + "WHERE p.id = :id AND t.id IN :patron", Integer.class);
        consulta.setParameter("patron", tweetsIds);
        consulta.setParameter("id", pais.getId());
        return consulta.getResultList();
    }
    
    

}
