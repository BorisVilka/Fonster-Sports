package com.fonster.sports

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fonster.sports.databinding.LeagueItemBinding

class LeagueAdapter: RecyclerView.Adapter<LeagueAdapter.Companion.LeagueHolder>() {

    var data = mutableListOf<League>()

    companion object {
        class LeagueHolder(val binding: LeagueItemBinding): RecyclerView.ViewHolder(binding.root) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueHolder {
        return LeagueHolder(LeagueItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.binding.textView6.text = data[position].name
    }

    override fun getItemCount(): Int {
        return data.size
    }
}