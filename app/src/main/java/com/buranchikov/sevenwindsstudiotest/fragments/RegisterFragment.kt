package com.buranchikov.sevenwindsstudiotest.fragments

import APP_ACTIVITY
import APP_API
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.data_classes.RegisterRequest
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.HttpException


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.binding.materialToolbar.title = getString(R.string.register_title_toolbar)
        binding.btnRegister.setOnClickListener {


            val login = binding.etEmailRegister.text.toString()
            val password = binding.etPasswordRegister.text.toString()
            val password2 = binding.etPasswordRepeatRegister.text.toString()

//            when (true) {
//                login.isEmpty() -> binding.etEmailRegister.hint = "Введите логин"
//                password.isEmpty() -> binding.etPasswordRegister.hint = "Введите пароль"
//                password2.isEmpty() -> binding.etPasswordRepeatRegister.hint = "Введите пароль"
//                (password != password2) -> binding.tvError.text = "Пароли не совпадают"
//                else -> {}
//            }

            CoroutineScope(Dispatchers.IO).launch {
                val responseRegister = APP_API.register(RegisterRequest(login, password))
                MainScope().launch {
//                    APP_ACTIVITY.viewModel.token.value = responseRegister.token
                    binding.tvError.text = responseRegister.token
                    APP_ACTIVITY.navController.navigate(R.id.action_registerFragment_to_loginFragment)
//

                }
            }

        }
    }
}