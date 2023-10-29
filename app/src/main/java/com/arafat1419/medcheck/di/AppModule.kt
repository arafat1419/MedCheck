package com.arafat1419.medcheck.di

import com.arafat1419.medcheck.ui.features.auth.login.LoginViewModel
import com.arafat1419.medcheck.ui.features.auth.register.RegisterViewModel
import com.arafat1419.medcheck.ui.features.main.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {
    private val viewModelModule = module {
        viewModel { LoginViewModel(get()) }
        viewModel { RegisterViewModel(get()) }
        viewModel { ProfileViewModel(get()) }
    }

    fun getAllModules(): MutableList<Module> {
        return mutableListOf(viewModelModule)
    }
}