package com.example.nyashadzaishebryan.waterdiary;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class DayUse {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int cleaning;
    private int cooking;
    private int dishes;
    private int drinking;
    private int hygiene;
    private int laundry;
    private int other;
    private int shower;
    private int toilet;

    private long date;

    DayUse(int shower, int toilet, int hygiene, int laundry, int dishes,
           int drinking, int cleaning, int other, int cooking, long date){

        this.shower = shower;
        this.toilet = toilet;
        this.hygiene = hygiene;
        this.laundry = laundry;
        this.dishes = dishes;
        this.drinking = drinking;
        this.cleaning = cleaning;
        this.other = other;
        this.cooking = cooking;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShower() {
        return shower;
    }

    public void setShower(int shower) {
        this.shower = shower;
    }

    public int getToilet() {
        return toilet;
    }

    public void setToilet(int toilet) {
        this.toilet = toilet;
    }

    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public int getLaundry() {
        return laundry;
    }

    public void setLaundry(int laundry) {
        this.laundry = laundry;
    }

    public int getDishes() {
        return dishes;
    }

    public void setDishes(int dishes) {
        this.dishes = dishes;
    }

    public int getDrinking() {
        return drinking;
    }

    public void setDrinking(int drinking) {
        this.drinking = drinking;
    }

    public int getCleaning() {
        return cleaning;
    }

    public void setCleaning(int cleaning) {
        this.cleaning = cleaning;
    }

    public int getOther() {
        return other;
    }

    public long getDate(){
        return this.date;
    }

    public int getCooking() {
        return cooking;
    }

    public void setCooking(int cooking) {
        this.cooking = cooking;
    }

    public String getDateAsString() {
        Date date = new Date(this.date);
        SimpleDateFormat ft =  new SimpleDateFormat("E dd/MM/yyyy");
        return ft.format(date);
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getTotalUsage(){
        return this.cleaning + this.drinking + this.laundry + this.dishes
                + this.shower + this.toilet + this.other + this.hygiene;
    }

    public String toString(){
        return this.getDateAsString() + ":        " + this.getTotalUsage() + "litres";
    }

}
