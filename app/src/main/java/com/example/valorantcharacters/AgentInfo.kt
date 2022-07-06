package com.example.valorantcharacters

import Ability
import Datum
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.valorantcharacters.databinding.ActivityAgentInfoBinding
import com.example.valorantcharacters.presenter.CharacterList.Companion.AGENT_ID_LIST
import com.example.valorantcharacters.presenter.CharacterList.Companion.listAgent
import com.squareup.picasso.Picasso
import java.lang.Exception


class AgentInfo : AppCompatActivity() {

    private val binding by lazy { ActivityAgentInfoBinding.inflate(layoutInflater) }

    private var mediaPlayer: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
        initClicks()
    }

    private fun initClicks() {
        val idAgent = intent.getIntExtra(AGENT_ID_LIST, -1)
        if (idAgent == -1) finish()
        val selectAgent : Datum = listAgent[idAgent]

        binding.ibCloseAgent.setOnClickListener {
            finish()
        }

        binding.ibStartSound.setOnClickListener {
            startVoice()
        }

        binding.ivAbility1.setOnClickListener {
            selectAgent.abilities?.let { it1 -> alertDialogAbility(it1.get(0)) }
        }
        binding.ivAbility2.setOnClickListener {
            selectAgent.abilities?.let { it1 -> alertDialogAbility(it1.get(1)) }
        }
        binding.ivAbility3.setOnClickListener {
            selectAgent.abilities?.let { it1 -> alertDialogAbility(it1.get(2)) }
        }
        binding.ivAbility4.setOnClickListener {
            selectAgent.abilities?.let { it1 -> alertDialogAbility(it1.get(3)) }
        }
    }

    private fun startVoice() {
        val idAgent = intent.getIntExtra(AGENT_ID_LIST, -1)
        if (idAgent == -1) finish()
        val selectAgent : Datum = listAgent[idAgent]

        if (mediaPlayer?.isPlaying() == true)  {
            mediaPlayer!!.stop();
            mediaPlayer!!.release();
        }

        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

        // below line is use to set our
        // url to our media player.
        try {
            mediaPlayer!!.setDataSource(selectAgent.voiceLine?.mediaList?.get(0)!!.wave)
            mediaPlayer!!.prepare();
            mediaPlayer!!.start();

        } catch (e : Exception) {
            Log.e("Deu ruim fi", "Olha o erro aqui $e")
        }
    }

    private fun initData() {
        val idAgent = intent.getIntExtra(AGENT_ID_LIST, -1)
        if (idAgent == -1) finish()
        val selectAgent : Datum = listAgent[idAgent]

        Picasso.get()
            .load(selectAgent.fullPortraitV2)
            .error(R.drawable.valorant_logo)
            .into(binding.ivAgent)

        binding.tvAgentName.setText(selectAgent.displayName)
        binding.tvAgentDescription.setText(selectAgent.description)

        Picasso.get()
            .load(selectAgent.abilities?.get(0)!!.displayIcon)
            .error(R.drawable.valorant_logo)
            .into(binding.ivAbility1)

        Picasso.get()
            .load(selectAgent.abilities?.get(1)!!.displayIcon)
            .error(R.drawable.valorant_logo)
            .into(binding.ivAbility2)

        Picasso.get()
            .load(selectAgent.abilities?.get(2)!!.displayIcon)
            .error(R.drawable.valorant_logo)
            .into(binding.ivAbility3)

        Picasso.get()
            .load(selectAgent.abilities?.get(3)!!.displayIcon)
            .error(R.drawable.valorant_logo)
            .into(binding.ivAbility4)
    }

    private fun alertDialogAbility(ability : Ability) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("")

        val view = layoutInflater.inflate(R.layout.ability_info, null)
        val ivAbility = view.findViewById<ImageView>(R.id.iv_ability)
        val tvAbilityName = view.findViewById<TextView>(R.id.tv_ability_name)
        val tvAbilityDescription = view.findViewById<TextView>(R.id.tv_ability_description)

        Picasso.get()
            .load(ability.displayIcon)
            .error(R.drawable.valorant_logo)
            .into(ivAbility)

        tvAbilityName.setText(ability.displayName)
        tvAbilityDescription.setText(ability.description)



        builder.setView(view)
        builder.create().show()
    }
}