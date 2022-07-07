package com.example.valorantcharacters.framework.modules

import com.example.valorantcharacters.data.AgentRepository
import com.example.valorantcharacters.framework.EndPoint
import com.example.valorantcharacters.framework.viewmodel.AgentViewModel
import com.example.valorantcharacters.implementation.AgentImplementation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object AppModule {

    private const val BASE_URL = "https://valorant-api.com/v1/"

    fun load() {
        loadKoinModules(viewModelModule() + postsModule() + netWorkModule())
    }

    private fun viewModelModule() = module {
        viewModel { AgentViewModel(get()) }
    }

    private fun postsModule() : Module {
        return  module {
            single<AgentRepository> { AgentRepository(get()) }

            single<AgentImplementation> { AgentImplementation(get()) }
        }
    }

    private fun netWorkModule() : Module {
        return module {
            single { createService() }
        }
    }

    private inline fun createService() : EndPoint {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EndPoint::class.java)
    }
}

