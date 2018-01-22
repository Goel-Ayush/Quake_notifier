package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by Ayush Goel on 12/24/2017.
 */

public class Earthquake {

    Double magn;
    String place;
    long ddate;
    String Url;

    public Earthquake(Double m, String p, long d, String mUrl){
        magn = m;
        place = p;
        ddate = d;
        Url = mUrl;
    }

   public Earthquake(){
            magn=0.0; place="0"; ddate=0; Url="0";
    }
    public Double getmagn () { return magn;  }

    public String getPlace(){
        return place;
    }

    public long getDdate() {
        return ddate;
    }

    public String getUrl() { return Url; }
}
