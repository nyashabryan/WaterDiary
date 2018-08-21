package com.example.nyashadzaishebryan.waterdiary;

import android.arch.persistence.room.Room;

public class DiaryPresenter {

    private DiaryActivity activity;
    private DayUseDatabase db;

    protected DiaryPresenter(DiaryActivity activity){
        this.activity = activity;
        this.db = Room.databaseBuilder(activity.getApplicationContext(),
                DayUseDatabase.class, "database-name").build();
    }

    public DayUse getDayUseByIndex(int index){
        return db.dayUseDao().getByID(index);
    }

    public int getMaxIndex(){
        return db.dayUseDao().getSize();
    }

}
