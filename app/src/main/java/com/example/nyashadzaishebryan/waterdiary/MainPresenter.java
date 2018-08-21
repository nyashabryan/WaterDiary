package com.example.nyashadzaishebryan.waterdiary;

import android.app.Activity;
import android.arch.persistence.room.Room;

import java.util.Date;
import java.util.List;

public class MainPresenter {

    private DayUseDatabase db;

    int runningTotal = 0;
    Activity currentActivity;

    MainPresenter(Activity currentActivity){
        this.currentActivity = currentActivity;
        this.db = Room.databaseBuilder(currentActivity.getApplicationContext(),
                DayUseDatabase.class, "database-name").build();
    }

    protected List<DayUse> getListOfDayUses(){
        DayUseDatabase db = Room.databaseBuilder(this.currentActivity.getApplicationContext(),
                DayUseDatabase.class, "database-name").build();
        return db.dayUseDao().getAll();
    }

}
