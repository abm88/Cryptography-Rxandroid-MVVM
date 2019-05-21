package com.aba.cryptosample.data.remoteDataSource

import androidx.lifecycle.LiveData
import com.aba.cryptosample.data.entity.Report
import com.aba.cryptosample.data.entity.STATE

interface ReportRemoteDataSource {

    val reports : LiveData<List<Report>>
    val state : LiveData<STATE>

    fun getReports()
    fun clear()

}