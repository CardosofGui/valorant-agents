package com.example.valorantcharacters

import android.app.Application
import com.example.valorantcharacters.framework.modules.AppModule
import com.example.valorantcharacters.presenter.CharacterList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        baseContext.cacheDir.deleteRecursively()

        startKoin {
            androidContext(this@BaseApplication)
        }

        AppModule.load()
    }
}