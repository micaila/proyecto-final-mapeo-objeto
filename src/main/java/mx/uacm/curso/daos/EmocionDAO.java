/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.List;
import mx.uacm.curso.dtos.EmocionPredominanteDTO;
import mx.uacm.curso.entidades.Emocion;


public interface EmocionDAO extends GenericDAO<Emocion,Integer>{
    
    public EmocionPredominanteDTO emocionPredominantePorTweetsIds(List<Integer> tweetsIds);
    
}
