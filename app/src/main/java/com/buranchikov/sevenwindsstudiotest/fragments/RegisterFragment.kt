package com.buranchikov.sevenwindsstudiotest.fragments

import APP_ACTIVITY
import APP_API
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

            if (password != password2) {
                binding.tvError.text =
                    getString(R.string.difference_passwords)
                binding.etPasswordRegister.setText("")
                binding.etPasswordRepeatRegister.setText("")
            } else {
                try {
                    requestRegister(login, password)
                } catch (e: HttpException) {
                    when (e.code()) {
                        406 -> {
                            // Обработка HTTP 406 Not Acceptable
                            binding.tvError.text = "Ошибка: Неприемлемый запрос"
                        }
                        // Добавьте другие возможные коды ошибок при необходимости
                        else -> {
                            // Обработка других ошибок
                            binding.tvError.text = "Произошла ошибка при выполнении запроса"
                        }
                    }
                } catch (e: Exception) {
                    // Обработка других исключений
                    binding.tvError.text = "Произошла неожиданная ошибка"
                }
            }
        }
    }

    fun requestRegister(login: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val responseRegister = APP_API.register(RegisterRequest(login, password))
            MainScope().launch {
                binding.tvError.text = responseRegister.token
                APP_ACTIVITY.navController.navigate(R.id.action_registerFragment_to_loginFragment)

            }
        }
    }
}