package com.aba.cryptosample.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aba.cryptosample.data.entity.Report


@Dao
interface ReportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(itens : List<Report>)

    @Query("SELECT * FROM reports")
    fun getReports() : LiveData<List<Report>>


}