package com.example.valorantcharacters.presenter.adapter

import Agent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantcharacters.R
import com.example.valorantcharacters.databinding.CardAgentBinding
import com.squareup.picasso.Picasso

class AgentAdapter(
    var listAgents : Agent,
    val agentItemInterface : AgenteItemInferface
) : RecyclerView.Adapter<AgentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        return AgentViewHolder(CardAgentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val agent = listAgents.data?.get(position)
        val binding = holder.binding

        if (agent != null) {
            Picasso.get()
                .load(agent.displayIcon)
                .error(R.drawable.valorant_logo)
                .into(binding.ivAgent)

            binding.tvAgentName.setText(agent.displayName)
            binding.tvAgentDescription.setText(agent.description)

            Picasso.get()
                .load(agent.abilities?.get(0)!!.displayIcon)
                .error(R.drawable.valorant_logo)
                .into(binding.ivAbility1)

            Picasso.get()
                .load(agent.abilities?.get(1)!!.displayIcon)
                .error(R.drawable.valorant_logo)
                .into(binding.ivAbility2)

            Picasso.get()
                .load(agent.abilities?.get(2)!!.displayIcon)
                .error(R.drawable.valorant_logo)
                .into(binding.ivAbility3)

            Picasso.get()
                .load(agent.abilities?.get(3)!!.displayIcon)
                .error(R.drawable.valorant_logo)
                .into(binding.ivAbility4)
        }

        binding.root.setOnClickListener {
            agentItemInterface.showAgentInfo(position)
        }
    }

    override fun getItemCount(): Int = listAgents.data?.size ?: 0

    fun updateList(newListAgents : Agent){
        listAgents = newListAgents
        notifyDataSetChanged()
    }
}

class AgentViewHolder(val binding : CardAgentBinding) : RecyclerView.ViewHolder(binding.root)
