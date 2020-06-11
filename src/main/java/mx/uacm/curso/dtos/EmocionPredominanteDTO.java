/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.dtos;

/**
 *
 * @author samantha
 */
public class EmocionPredominanteDTO {
    
    private String emocion;
    public Double promedio;

    public EmocionPredominanteDTO(String emocion, Double promedio) {
        this.emocion = emocion;
        this.promedio = promedio;
    }

    public EmocionPredominanteDTO() {
    }
    
    
    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
       
    
}
