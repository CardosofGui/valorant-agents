package com.example.valorantcharacters.framework.modules

import com.example.valorantcharacters.data.AgentRepository
import com.example.valorantcharacters.framework.viewmodel.AgentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (agentRepository : AgentRepository) -> AgentViewModel(agentRepository)  }
}