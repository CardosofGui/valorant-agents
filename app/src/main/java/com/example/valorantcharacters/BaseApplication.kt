package com.example.valorantcharacters

import android.app.Application
import com.example.valorantcharacters.framework.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)

            modules(viewModelModule)
        }
    }
}