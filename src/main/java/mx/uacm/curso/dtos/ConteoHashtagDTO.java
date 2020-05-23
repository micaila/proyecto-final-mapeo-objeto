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
public class ConteoHashtagDTO {
    
    private String nombreHashtag;
    private Long totalTweets;

    public String getNombreHashtag() {
        return nombreHashtag;
    }

    public void setNombreHashtag(String nombreHashtag) {
        this.nombreHashtag = nombreHashtag;
    }

    public Long getTotalTweets() {
        return totalTweets;
    }

    public void setTotalTweets(Long totalTweets) {
        this.totalTweets = totalTweets;
    }
    
    
}
