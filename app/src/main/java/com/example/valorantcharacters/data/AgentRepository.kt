package com.example.valorantcharacters.data

import com.example.valorantcharacters.implementation.AgentImplementation

class AgentRepository(private val agentImplementation: AgentImplementation) {

    fun getAllAgents() = agentImplementation.getAllAgent()
}