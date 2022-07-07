package com.example.valorantcharacters.implementation

import Agent
import com.example.valorantcharacters.framework.EndPoint

class AgentImplementation(private val valorantServiceAPI : EndPoint) {

    fun getAllAgent(): Agent? {
        val callback = valorantServiceAPI.getAllAgents().execute()

        return if (callback.isSuccessful) callback.body()
        else null
    }

}