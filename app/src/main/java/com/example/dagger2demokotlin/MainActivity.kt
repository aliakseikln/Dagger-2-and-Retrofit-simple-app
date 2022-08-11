package com.example.dagger2demokotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2demokotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var rvAdapter: RecyclerViewAdapter
    private lateinit var vm: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        rvAdapter = RecyclerViewAdapter()
        binding.recyclerView.adapter = rvAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel() {
        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]
        vm.getLiveDataObserver().observe(this) { t ->
            if (t != null) {
                rvAdapter.setUpdatedData(t.items)
                rvAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Error in getting the data",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        vm.makeApiCall()
    }
}