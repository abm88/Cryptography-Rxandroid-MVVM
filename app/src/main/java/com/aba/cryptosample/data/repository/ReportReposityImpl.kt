package com.aba.cryptosample.data.repository

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import com.aba.cryptosample.data.remoteDataSource.ReportRemoteDataSource
import com.aba.cryptosample.data.entity.Report
import com.aba.cryptosample.data.entity.STATE
import com.aba.cryptosample.data.local.dao.ReportDao
import javax.inject.Inject

class ReportReposityImpl @Inject
            constructor(@NonNull val dao : ReportDao,
                        @NonNull val datasource  : ReportRemoteDataSource): ReportReposity {


    init {


        datasource.reports.observeForever {
            dao.upsert(it)
        }


    }

    override fun getReportItems(): LiveData<List<Report>> {
        return dao.getReports()
    }

    override fun getReport() {
        datasource.getReports()
    }

    override fun getState(): LiveData<STATE> {
        return datasource.state
    }

    override fun clear() {
        datasource.clear()
    }



}