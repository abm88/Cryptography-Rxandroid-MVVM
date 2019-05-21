package com.aba.cryptosample.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.aba.cryptosample.AppConstants
import com.aba.cryptosample.data.local.AppDataBase
import com.aba.cryptosample.data.local.dao.ReportDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PersistenceModule {

    @Singleton
    @Provides
    fun provideDataBase(@NonNull application : Application) : AppDataBase {

        return Room.databaseBuilder(application ,
            AppDataBase::class.java ,
            AppConstants.DATABASE_NAME)
            .allowMainThreadQueries().build()

    }

    @Singleton
    @Provides
    fun provideCorridorDao(@NonNull db : AppDataBase) : ReportDao {
        return db.reportDao()
    }

}