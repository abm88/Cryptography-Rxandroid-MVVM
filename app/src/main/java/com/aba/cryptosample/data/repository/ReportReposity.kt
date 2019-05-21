package com.aba.cryptosample.data.repository

import androidx.lifecycle.LiveData
import com.aba.cryptosample.data.entity.Report
import com.aba.cryptosample.data.entity.STATE

interface ReportReposity {



    fun getReportItems() : LiveData<List<Report>>
    fun getReport()
    fun getState() : LiveData<STATE>
    fun clear()
}