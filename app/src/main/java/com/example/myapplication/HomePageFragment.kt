package com.example.myapplication

import androidx.navigation.fragment.findNavController
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentHomePageBinding

class HomePageFragment : BaseFragment<FragmentHomePageBinding>(FragmentHomePageBinding::inflate) {

    override fun start() {

    }

    override fun clickListener() {
        binding.apply {
            btnLogin.setOnClickListener {
                findNavController().navigate(
                    R.id.action_homePageFragment_to_loginFragment
                )
            }
            btnReg.setOnClickListener {
                findNavController().navigate(
                    R.id.action_homePageFragment_to_regFragment
                )
            }

        }
    }
}