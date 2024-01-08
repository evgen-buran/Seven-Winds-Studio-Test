package com.buranchikov.sevenwindsstudiotest.fragments.list_menu

import APP_ACTIVITY
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buranchikov.sevenwindsstudiotest.R
import com.buranchikov.sevenwindsstudiotest.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    private lateinit var binding:FragmentMenuBinding
    private lateinit var adapter: MenuListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
       initRecyclerView()
        APP_ACTIVITY.viewModel.menu.observe(APP_ACTIVITY){
            adapter.submitList(it)
        }
    }
    fun initRecyclerView() {
        adapter = MenuListAdapter()
        binding.rvMenu.adapter = adapter
    }


}