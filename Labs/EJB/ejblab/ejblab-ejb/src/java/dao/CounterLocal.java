/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Singleton;


@Singleton 
public class CounterLocal implements CounterLocalLocal {

    private int hits = 1;
   
    
    @Override
    public int getHits(){
        return hits++;
    }
}
