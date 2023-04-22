package com.fonster.sports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fonster.sports.databinding.FragmentSportBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class SportFragment : Fragment() {

    private lateinit var binding: FragmentSportBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSportBinding.inflate(inflater,container,false)
        binding.imageView.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
            navController.navigate(R.id.gamesFragment,Bundle().apply {
                putString("sport","basketball")
                putString("sport1","Basketball")
            })
        }
        binding.imageView2.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
            navController.navigate(R.id.gamesFragment,Bundle().apply {
                putString("sport","icehockey")
                putString("sport1","Hockey")
            })
        }
        binding.imageView3.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
            navController.navigate(R.id.gamesFragment,Bundle().apply {
                putString("sport","tennis")
                putString("sport1","Tennis")
            })
        }
        binding.imageView4.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
            navController.navigate(R.id.gamesFragment,Bundle().apply {
                putString("sport","boxing")
                putString("sport1","Boxing")
            })
        }
        return binding.root
    }


}