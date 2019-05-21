package com.aba.cryptosample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aba.cryptosample.factory.AppViewModelFactory
import com.aba.cryptosample.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {



    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindHomeFragmentViewmodel(viewmodel : MainViewModel) : ViewModel



    @Binds
    internal abstract fun bindViewModelFactory(factory : AppViewModelFactory) : ViewModelProvider.Factory




}