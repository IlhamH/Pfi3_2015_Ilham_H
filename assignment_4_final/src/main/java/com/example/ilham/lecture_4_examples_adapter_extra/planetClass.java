package com.example.ilham.lecture_4_examples_adapter_extra;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Ilham on 2015-04-21.
 */
public class planetClass implements Serializable{
    String nameOfPlanets;
    Drawable imgId;


    // Planet = img + name
    public planetClass( String nameOfPlanets, Drawable imgId){
        this.imgId = imgId;
        this.nameOfPlanets = nameOfPlanets;
    }

    public String getNameOfPlanets(){return nameOfPlanets;}

    public void setNameOfPlanets(String nameOfPlanets) {
        this.nameOfPlanets = nameOfPlanets;
    }

    public Drawable getImgId() {
        return imgId;
    }

    public void setImgId(Drawable imgId) {
        this.imgId = imgId;
    }


    public String getInfo(){
        return "Info About This Planet";
    }}