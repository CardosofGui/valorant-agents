package com.example.valorantcharacters.framework

import Agent
import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {

    @GET("agents?language=pt-BR&isPlayableCharacter=true")
    fun getAllAgents() : Call<Agent>
}