package it.univpm.progettoPavicSasu.model;

import java.util.Date;

public class Measurement {

    protected Date date;
    public double temperature;
    public double pressure;
    public double visibility;
    public double humidity;
    public double cloud;

    /**
     * @param dt the date to set
     */
    public void setDate(long dt) {
        this.date = new Date(dt * 1000);
    }

    public void setDate(Date d) {
        this.date = d;
    }

    public Date getDate(){
        return this.date;
    }
}
