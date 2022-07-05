package com.example.valorantcharacters.implementation

import Agent
import com.example.valorantcharacters.framework.RetrofitUtils
import com.example.valorantcharacters.framework.EndPoint

class AgentImplementation {

    private val retrofit =
        RetrofitUtils.getRetrofitInstance("https://valorant-api.com/v1/")

    fun getAllAgent(): Agent? {
        val endPoint = retrofit.create(EndPoint::class.java)
        val callback = endPoint.getAllAgents().execute()

        return if (callback.isSuccessful) callback.body()
        else null
    }

}