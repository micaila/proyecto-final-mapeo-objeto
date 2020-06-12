/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.servicios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.uacm.curso.daos.EmocionDAO;
import mx.uacm.curso.daos.PaisDAO;
import mx.uacm.curso.daos.TweetDAO;
import mx.uacm.curso.dtos.PaisYEmocionPredominanteDTO;
import mx.uacm.curso.entidades.Pais;
import mx.uacm.curso.servicios.EstadisticasServicio;

public class EstadisticasServicioImpl implements EstadisticasServicio {

    private TweetDAO tweetDAO;
    private EmocionDAO emocionDAO;
    private PaisDAO paisDAO;

    public TweetDAO getTweetDAO() {
        return tweetDAO;
    }

    public void setTweetDAO(TweetDAO tweetDAO) {
        this.tweetDAO = tweetDAO;
    }

    public EmocionDAO getEmocionDAO() {
        return emocionDAO;
    }

    public void setEmocionDAO(EmocionDAO emocionDAO) {
        this.emocionDAO = emocionDAO;
    }

    @Override
    public List<PaisYEmocionPredominanteDTO>  emocionesPredominantesAgrupadasPorPais(List<String> hashtags, Date fechaMin, Date fechaMax) {
    
        List<PaisYEmocionPredominanteDTO> paisesYEmociones = new ArrayList<PaisYEmocionPredominanteDTO>();        
        List<Integer> tweetsIds = tweetDAO.tweetsIdsPorHashtagsYFecha(hashtags, fechaMin, fechaMax);
        List<Pais> paises = paisDAO.obtenPorTweetsIds(tweetsIds);
        //List<Integer> tweetsIdsPorPaises = new ArrayList<Integer>();
    
        //paisesYEmociones = (List<PaisYEmocionPredominanteDTO>) emocionDAO.emocionPredominantePorTweetsIds(tweetsIdsPorPaises);
        return paisesYEmociones;
    }

}
