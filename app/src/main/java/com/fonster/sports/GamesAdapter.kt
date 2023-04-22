package com.fonster.sports

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fonster.sports.databinding.GameItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class GamesAdapter(val list: List<Game>): RecyclerView.Adapter<GamesAdapter.Companion.GameHolder>() {



    companion object {
        class GameHolder(val binding: GameItemBinding): RecyclerView.ViewHolder(binding.root) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(GameItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.binding.textView10.text = list[position].home.name
        holder.binding.textView11.text = list[position].away.name
        holder.binding.textView9.text = SimpleDateFormat("dd.MM.yyyy HH:mm").format(Date(list[position].getTime().toLong()))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}