package com.fonster.sports

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.fonster.sports.databinding.FragmentLeaguesBinding
import retrofit2.Call
import retrofit2.Response

class LeaguesFragment : Fragment() {

    private lateinit var binding: FragmentLeaguesBinding
    private var adapter = LeagueAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentLeaguesBinding.inflate(layoutInflater,container,false)
        binding.listLeague.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        binding.listLeague.adapter = adapter
        Client.getApi().getAns("ayna","12784-OhJLY5mb3BSOx0O","livedata","soccer").enqueue(object : retrofit2.Callback<Answer> {
            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                Log.d("TAG","${response.body()?.games?.size ?: -1}")
                requireActivity().runOnUiThread {
                    for(i in response.body()!!.games) {
                        if(!adapter.data.contains(i.league)) {
                            adapter.data.add(i.league)
                            adapter.notifyDataSetChanged()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<Answer>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return binding.root
    }


}