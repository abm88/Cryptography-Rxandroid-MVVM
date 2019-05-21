package com.aba.cryptosample.ui.main

import android.content.Context
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import com.aba.cryptosample.data.repository.ReportReposity
import com.aba.cryptosample.utils.CryptoUtils
import javax.inject.Inject


class MainViewModel @Inject constructor(
    @NonNull val context: Context,
    @NonNull val repository: ReportReposity
) : ViewModel() {


    fun getReportItems() = repository.getReportItems()
    fun getReport() = repository.getReport()
    fun getState() = repository.getState()
    fun clear() = repository.clear()


    fun encryptText(text: String): String {
        try {
            return CryptoUtils.encrypt(text)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return text

    }

    fun decryptText(text: String): String {
        try {
            return CryptoUtils.decrypt(text)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return text
    }


}
