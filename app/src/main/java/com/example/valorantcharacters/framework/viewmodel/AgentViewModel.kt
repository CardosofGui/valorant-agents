package com.example.valorantcharacters.framework.viewmodel

import Agent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.valorantcharacters.data.AgentRepository
import okhttp3.Dispatcher
import java.lang.Exception

class AgentViewModel(private val agentRepository: AgentRepository) : ViewModel() {

    private var _agent = MutableLiveData<Agent?>()
    val agent : LiveData<Agent?>
        get() = _agent

    var agentStatusRequest = MutableLiveData<Boolean?>()

    fun getAllAgents() {
        Thread{
            try {
                Log.e("Deu bom fi", "Era pra ter ido")
                _agent.postValue(agentRepository.getAllAgents())
                agentStatusRequest.postValue(true)
            } catch (e : Exception) {
                Log.e("Deu ruim fi", "Olha o erro aqui $e")
                _agent.postValue(agentRepository.getAllAgents())
                agentStatusRequest.postValue(false)
            }
        }.start()
    }
}