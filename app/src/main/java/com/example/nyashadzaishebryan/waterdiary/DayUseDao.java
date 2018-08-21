package com.example.nyashadzaishebryan.waterdiary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DayUseDao {

    @Query("SELECT * FROM DayUse")
    public List<DayUse> getAll();

    @Query("SELECT * FROM DayUse WHERE id LIKE :index LIMIT 1")
    public DayUse getByID(int index);

    @Query("SELECT COUNT(*)")
    public int getSize();

    @Insert
    public void insertAll(DayUse ... dayUse);

    @Delete
    public void delete(DayUse dayUse);
}
