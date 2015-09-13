
package com.mycompany.hackernewsuutiset;

public class Uutinen {
    
    private String title;
    private String by;
    private String url;
    
    /**
     * Constructor for tests
     */
    public Uutinen(String title, String by, String url){
        this.title = title;
        this.by = by;
        this.url = url;
    }
   
    @Override
    public String toString() {
        return title  + " by " + by + ", url: " + url;
    }
    
}
