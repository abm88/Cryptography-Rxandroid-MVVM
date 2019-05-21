package com.aba.cryptosample.di

import com.aba.cryptosample.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): MainFragment

}