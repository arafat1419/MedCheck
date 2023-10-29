package com.arafat1419.medcheck

import android.app.Application
import com.arafat1419.core.di.CoreModule
import com.arafat1419.medcheck.di.AppModule
import com.arafat1419.medcheck.utils.PreferenceManager
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        PreferenceManager.initialize(this)
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApp)

            val allModules = CoreModule
                .getAllModules()
                .plus(AppModule.getAllModules())
                .toList()

            modules(allModules)
        }
    }
}