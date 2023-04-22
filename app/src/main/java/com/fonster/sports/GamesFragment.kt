package com.fonster.sports

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fonster.sports.databinding.FragmentGamesBinding
import retrofit2.Call
import retrofit2.Response


class GamesFragment : Fragment() {

    private lateinit var binding: FragmentGamesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGamesBinding.inflate(inflater,container,false)
        binding.textView7.text = requireArguments().getString("sport1")
        binding.imageView5.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
            navController.popBackStack()
        }
        Client.getApi().getAns("ayna","12784-OhJLY5mb3BSOx0O","livedata",requireArguments().getString("sport")).enqueue(object : retrofit2.Callback<Answer> {
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