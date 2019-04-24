package com.example.mypokerteste.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sprites implements Serializable, Parcelable
{

    @SerializedName("back_default")
    @Expose
    private String backDefault;
    @SerializedName("back_female")
    @Expose
    private Object backFemale;
    @SerializedName("back_shiny")
    @Expose
    private String backShiny;
    @SerializedName("back_shiny_female")
    @Expose
    private Object backShinyFemale;
    @SerializedName("front_default")
    @Expose
    private String frontDefault;
    @SerializedName("front_female")
    @Expose
    private Object frontFemale;
    @SerializedName("front_shiny")
    @Expose
    private String frontShiny;
    @SerializedName("front_shiny_female")
    @Expose
    private Object frontShinyFemale;
    public final static Parcelable.Creator<Sprites> CREATOR = new Creator<Sprites>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Sprites createFromParcel(Parcel in) {
            return new Sprites(in);
        }

        public Sprites[] newArray(int size) {
            return (new Sprites[size]);
        }

    }
            ;
    private final static long serialVersionUID = 6549272947043857308L;

    protected Sprites(Parcel in) {
        this.backDefault = ((String) in.readValue((String.class.getClassLoader())));
        this.backFemale = ((Object) in.readValue((Object.class.getClassLoader())));
        this.backShiny = ((String) in.readValue((String.class.getClassLoader())));
        this.backShinyFemale = ((Object) in.readValue((Object.class.getClassLoader())));
        this.frontDefault = ((String) in.readValue((String.class.getClassLoader())));
        this.frontFemale = ((Object) in.readValue((Object.class.getClassLoader())));
        this.frontShiny = ((String) in.readValue((String.class.getClassLoader())));
        this.frontShinyFemale = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Sprites() {
    }

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public Object getBackFemale() {
        return backFemale;
    }

    public void setBackFemale(Object backFemale) {
        this.backFemale = backFemale;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    public Object getBackShinyFemale() {
        return backShinyFemale;
    }

    public void setBackShinyFemale(Object backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }



    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public Object getFrontFemale() {
        return frontFemale;
    }

    public void setFrontFemale(Object frontFemale) {
        this.frontFemale = frontFemale;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    public Object getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public void setFrontShinyFemale(Object frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(backDefault);
        dest.writeValue(backFemale);
        dest.writeValue(backShiny);
        dest.writeValue(backShinyFemale);
        dest.writeValue(frontDefault);
        dest.writeValue(frontFemale);
        dest.writeValue(frontShiny);
        dest.writeValue(frontShinyFemale);
    }

    public int describeContents() {
        return  0;
    }

}
