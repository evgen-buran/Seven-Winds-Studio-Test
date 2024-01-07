package com.buranchikov.sevenwindsstudiotest.fragments

import APP_ACTIVITY
import APP_API
import TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.AuthRequest
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.binding.materialToolbar.title = getString(R.string.Enter)

        binding.btnLogin.setOnClickListener {
            val login = binding.etEmailLogin.text.toString()
            val password = binding.etPasswordLogin.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                val responseLogin = APP_API.auth(AuthRequest(login, password))
                MainScope().launch {
                    APP_ACTIVITY.viewModel.token.postValue(responseLogin.token)
                    binding.token.text = responseLogin.token
                    APP_ACTIVITY.navController.navigate(R.id.action_loginFragment_to_сoffeeListFragment)
                }


            }

        }
        binding.tvRegisterNewUser.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}