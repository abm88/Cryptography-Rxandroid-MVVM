package com.aba.cryptosample.data.service

import com.aba.cryptosample.data.entity.Report
import io.reactivex.Observable
import retrofit2.http.GET

interface ReportService {

    @GET("reports")
    fun getReport() : Observable<List<Report>>
}