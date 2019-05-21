package com.aba.cryptosample.data.remoteDataSource

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aba.cryptosample.data.entity.Report
import com.aba.cryptosample.data.entity.STATE
import com.aba.cryptosample.data.service.ReportService
import com.twistedequations.rx2.AndroidRxSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ReportRemoteDataSourceImpl @Inject
        constructor( @NonNull val  rxSchedulers: AndroidRxSchedulers ,
                    @NonNull val  service : ReportService) : ReportRemoteDataSource {


    override val reports: LiveData<List<Report>>
        get() = _reports
    override val state: LiveData<STATE>
        get() = _state



    private var _reports = MutableLiveData<List<Report>>()
    private var _state = MutableLiveData<STATE>()
    private var page = MutableLiveData<Int>()
    private val  compositeDisposable = CompositeDisposable()

    init {

        page.observeForever {
            getData()
        }

    }

    private fun getData() {

        _state.postValue(STATE.loading)
        compositeDisposable.add(service.getReport()
            .subscribeOn(rxSchedulers.io())
            .observeOn(rxSchedulers.mainThread())
            .subscribe ({

                _state.postValue(STATE.successful)

                _reports.postValue(it)

            } , {
                _state.postValue(STATE.error(it.toString() , ""))

            })
        )

    }


    override fun getReports() {

        page.postValue(1)
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}