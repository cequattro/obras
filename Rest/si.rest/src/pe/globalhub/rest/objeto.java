/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.globalhub.rest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wcastro
 */
public class objeto {
    
    private int data1 = 4444;
    private String data2 = "hola mundo rest";
    private List<String> list = new ArrayList<String>() {
      {
            add("Willy");
            add("Arturo");
            add("Tom");
            add("Tony");
            add("Carlos");
            add("Roque");
            add("Feri");
      }
    };        

    /**
     * @return the data1
     */
    public int getData1() {
        return data1;
    }

    /**
     * @param data1 the data1 to set
     */
    public void setData1(int data1) {
        this.data1 = data1;
    }

    /**
     * @return the data2
     */
    public String getData2() {
        return data2;
    }

    /**
     * @param data2 the data2 to set
     */
    public void setData2(String data2) {
        this.data2 = data2;
    }

    /**
     * @return the list
     */
    public List<String> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<String> list) {
        this.list = list;
    }
    
    @Override
    public String toString() {
       return "DataObject [data1=" + getData1() + ", data2=" + getData2() + ", list="
            + getList() + "]";
    }
    
}
