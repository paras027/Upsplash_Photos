package com.example.up_splash;

public class Photoss {
    private String murl;
    private String mtext;
    private String murl2;
    private String mname;
    private String loc;
    private String bb;



    public Photoss(String url, String text, String url2, String name, String bb1, String locc )
    {
        murl=url;
        mtext=text;
        murl2=url2;
        mname=name;
        bb=bb1;
        loc=locc;
    }

    public String getMurl() {
        return murl;
    }

    public String getMtext() {
        return mtext;
    }

    public String getMurl2() {
        return murl2;
    }

    public String getMname() {
        return mname;
    }
    public String getLoc() {
        return loc;
    }

    public String getBb() {
        return bb;
    }
}
