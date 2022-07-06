package com.example.valorantcharacters.presenter

import Agent
import Datum
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.valorantcharacters.AgentInfo
import com.example.valorantcharacters.data.AgentRepository
import com.example.valorantcharacters.databinding.ActivityCharacterListBinding
import com.example.valorantcharacters.framework.viewmodel.AgentViewModel
import com.example.valorantcharacters.implementation.AgentImplementation
import com.example.valorantcharacters.presenter.adapter.AgentAdapter
import com.example.valorantcharacters.presenter.adapter.AgenteItemInferface
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CharacterList : AppCompatActivity(), AgenteItemInferface {

    private val binding by lazy { ActivityCharacterListBinding.inflate(layoutInflater) }

    private var agentAdapter = AgentAdapter(Agent(), this)

    private val mViewModel : AgentViewModel by viewModel {
        parametersOf(AgentRepository(AgentImplementation()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        initRecycler()
        initObserver()
    }

    private fun initObserver() {
        mViewModel.getAllAgents()
        mViewModel.agent.observe(this) {
            if (it != null) {
                if (it.data?.isNotEmpty() == true) {
                    agentAdapter.updateList(it)
                    listAgent = it.data!!
                }
            }
        }
    }

    private fun initRecycler() {
        binding.rcvAgents.adapter = agentAdapter
    }

    override fun showAgentInfo(idAgent: Int) {
        startActivity(Intent(this, AgentInfo::class.java).putExtra(AGENT_ID_LIST, idAgent))
    }

    companion object {
        const val AGENT_ID_LIST = "AGENT_ID"
        var listAgent = arrayListOf<Datum>()
    }

}