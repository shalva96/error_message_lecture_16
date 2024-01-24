package com.example.myapplication.login

import android.util.Log.e
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.auth_api.AuthRepository
import com.example.myapplication.auth_api.AuthResult
import com.example.myapplication.auth_api.AuthViewModel
import com.example.myapplication.auth_api.AuthViewModelFactory
import com.example.myapplication.auth_api.RetrofitInstance
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(AuthRepository(RetrofitInstance.apiService))
    }


    override fun start() {

    }

    override fun clickListener() {
        binding.apply {
            btnLogin.setOnClickListener {
                authViewModel.loginUser(edUsername.text.toString(), edPass.text.toString())
                observe()
            }
        }

    }


    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            authViewModel.loginResult.collect { result ->
                result?.let {
                    when (result) {
                        is AuthResult.Success -> {
                            // Success login
                            val token = result.token
                        }
                        is AuthResult.Error -> {
                            // Error message
                            val errorMessage = result.errorMessage
                            e("errorLoginError", "$errorMessage")
                            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        }
    }



}