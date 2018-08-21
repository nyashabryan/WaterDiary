package com.example.nyashadzaishebryan.waterdiary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {DayUse.class}, version = 1)
public abstract class DayUseDatabase extends RoomDatabase{
    public abstract DayUseDao dayUseDao();

}
