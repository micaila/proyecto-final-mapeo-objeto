/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.curso.daos.HashtagDAO;
import mx.uacm.curso.dtos.ConteoHashtagDTO;
import mx.uacm.curso.entidades.Hashtag;

public class HashtagDAOImpl extends GenericDAOImpl<Hashtag, Integer> implements HashtagDAO {

    public HashtagDAOImpl(EntityManager em) {
        super(em);
    }
    @Override
    public List<String> nombresHashtags(){
        TypedQuery<String> consulta = em.createQuery("SELECT h.nombre FROM Hashtag h", String.class);
        return consulta.getResultList();
    }

    @Override
    public List<ConteoHashtagDTO> conteoHashtags() {
        TypedQuery<ConteoHashtagDTO> consulta =
                em.createQuery("SELECT new mx.uacm.curso.dtos.ConteoHashtagDTO(h.nombre,COUNT(t.id)) "
                        + "FROM Hashtag h INNER JOIN h.tweets t GROUP BY h.nombre",
                        ConteoHashtagDTO.class);
        return consulta.getResultList();    
    }

    @Override
    public List<ConteoHashtagDTO> conteoHashtags(String patronCadena) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO change body of generated methods, choose Tools | Templates.
    }
    
}
