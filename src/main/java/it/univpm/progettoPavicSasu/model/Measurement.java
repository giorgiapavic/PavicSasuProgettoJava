package it.univpm.progettoPavicSasu.model;

import java.util.Date;
 /**
  * Classe che definisce la stuttura delle misurazioni
  * @author Giorgia Pavic
  * @author Riccardo Sasu
  *
  */
public class Measurement {

    protected Date date;
    public double temperature;
    public double pressure;
    public double visibility;
    public double humidity;
    public double cloud;

    /**
     * Metodo che imposta la data
     * @param dt
     */
    public void setDate(long dt) {
        this.date = new Date(dt * 1000);
    }
    /**
     * Metodo che imposta la data
     * @param d
     */
    public void setDate(Date d) {
        this.date = d;
    }
    /**
     * Metodo che restituisce la data
     * @return data
     */
    public Date getDate(){
        return this.date;
    }
}
