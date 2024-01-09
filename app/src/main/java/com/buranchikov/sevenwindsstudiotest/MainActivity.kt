package com.buranchikov.sevenwindsstudiotest

import API_KEY
import APP_ACTIVITY
import APP_API
import BASE_URL
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.buranchikov.sevenwindsstudiotest.api.AppAPI
import com.buranchikov.sevenwindsstudiotest.databinding.ActivityMainBinding
import com.yandex.mapkit.MapKitFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        MapKitFactory.setApiKey(API_KEY)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView (binding.root)

        navController = findNavController(R.id.nav_host_fragment)
        initRetrofit()

        viewModel = ViewModelProvider(APP_ACTIVITY).get(MainViewModel::class.java)


        setSupportActionBar(binding.materialToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
//        supportActionBar?.setDisplayShowHomeEnabled(true);
        binding.materialToolbar.setNavigationOnClickListener { _ -> onBackPressed() };
    }

    private fun initRetrofit() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        APP_API = retrofit.create(AppAPI::class.java)
    }
}