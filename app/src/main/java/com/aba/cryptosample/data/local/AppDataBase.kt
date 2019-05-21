package com.aba.cryptosample.data.local

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.aba.cryptosample.data.entity.Report
import com.aba.cryptosample.data.local.dao.ReportDao


@Database(entities = [(Report::class) ] , version = 1 , exportSchema = false)
abstract class AppDataBase : RoomDatabase(){

    abstract fun reportDao() : ReportDao

}