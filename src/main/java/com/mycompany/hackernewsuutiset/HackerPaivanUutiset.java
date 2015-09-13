
package com.mycompany.hackernewsuutiset;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.paivanuutiset.PaivanUutiset;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HackerPaivanUutiset implements PaivanUutiset {
    
    private static Gson gson = new Gson();
    private HTTPClient client;
    private String baseurl = "";
    
    public HackerPaivanUutiset(HTTPClient client){
        this.client = client;
    }
    
    public HackerPaivanUutiset(){
        this.client = new HTTPClient();
        if(this.baseurl.equals("")){
            baseurl = "https://hacker-news.firebaseio.com";
        } 
    }
    
    public HackerPaivanUutiset(String baseurl){
        this.client = new HTTPClient();
        this.baseurl = baseurl;
    }

    @Override
    public String haeSuosituinUutinen() {
        String suosituimmat = client.callURL(baseurl + "/v0/topstories.json");
        System.out.println("SUOSITUIMMAT: " + suosituimmat);
        suosituimmat = suosituimmat.replace("[", "");
        suosituimmat = suosituimmat.replace("]", "");
        String[] array = suosituimmat.split(",");
        System.out.println("ARRAY[0]: " + array[0]);
        int suosituin = Integer.parseInt(array[0]);
        String vastaus = client.callURL(baseurl + "/v0/item/" + suosituin + ".json?print=pretty");
        Uutinen uutinen = gson.fromJson(vastaus, Uutinen.class);
        return "Suosituin uutinen on " + uutinen.toString();
    }

    @Override
    public String haeViimeisinUutinen() {
        String uusimmat = client.callURL(baseurl + "/v0/newstories.json");
        uusimmat = uusimmat.replace("[", "");
        uusimmat = uusimmat.replace("]", "");
        String[] array = uusimmat.split(",");
        int viimeisin = Integer.parseInt(array[0]);
        String vastaus = client.callURL(baseurl + "/v0/item/" + viimeisin + ".json?print=pretty");
        Uutinen uutinen = gson.fromJson(vastaus, Uutinen.class);
        return "Viimeisin uutinen on " + uutinen.toString();
    }
    
}
