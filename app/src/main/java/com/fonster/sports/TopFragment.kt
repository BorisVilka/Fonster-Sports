package com.fonster.sports

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fonster.sports.databinding.FragmentTopBinding
import retrofit2.Call
import retrofit2.Response


class TopFragment : Fragment() {

    private lateinit var binding: FragmentTopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTopBinding.inflate(inflater,container,false)
        Client.getApi().getAns("ayna","12784-OhJLY5mb3BSOx0O","livedata","soccer").enqueue(object : retrofit2.Callback<Answer> {
            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                Log.d("TAG","${response.body()?.games?.size ?: -1}")
                requireActivity().runOnUiThread {
                    val adapter = GamesAdapter(response.body()?.games ?: listOf())
                    binding.listLeague.adapter = adapter
                }
            }

            override fun onFailure(call: Call<Answer>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return binding.root
    }


}