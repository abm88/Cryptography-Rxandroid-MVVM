package com.aba.cryptosample.di

import androidx.annotation.NonNull
import com.aba.cryptosample.data.remoteDataSource.ReportRemoteDataSource
import com.aba.cryptosample.data.remoteDataSource.ReportRemoteDataSourceImpl
import com.aba.cryptosample.data.local.dao.ReportDao
import com.aba.cryptosample.data.repository.ReportReposity
import com.aba.cryptosample.data.repository.ReportReposityImpl
import com.aba.cryptosample.data.service.ReportService

import com.twistedequations.rx2.AndroidRxSchedulers
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/*
 * create service, data sources and repository dependencies here.
 *
 */
@Module
class DataModule  {


    @Singleton
    @Provides
    fun provideCoridorService(@NonNull retrofit : Retrofit) : ReportService {
        return retrofit.create(ReportService::class.java)
    }


    @Singleton
    @Provides
    fun procideCorridorDatSource(@NonNull rxSchedulers: AndroidRxSchedulers ,
                                 @NonNull service : ReportService) : ReportRemoteDataSource {
        return ReportRemoteDataSourceImpl(rxSchedulers , service)
    }

    @Singleton
    @Provides
    fun provideCorridorRepository(@NonNull reportDataSource : ReportRemoteDataSource ,
                                  @NonNull dao : ReportDao) : ReportReposity{
        return ReportReposityImpl(dao , reportDataSource  )
    }


}