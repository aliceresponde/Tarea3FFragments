package com.aliceresponde.tarea3ffragments.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aliceresponde.tarea3ffragments.Person
import com.aliceresponde.tarea3ffragments.R
import com.aliceresponde.tarea3ffragments.databinding.ActivityMainBinding
import com.aliceresponde.tarea3ffragments.main.List.ListFragment
import com.aliceresponde.tarea3ffragments.main.detail.DetailActivity
import com.aliceresponde.tarea3ffragments.main.detail.DetailFragment


class MainActivity : AppCompatActivity(),
    ListFragment.OnPersonClickedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentA: ListFragment
    private var fragmentB: DetailFragment? = null
    private val TAG  = MainActivity::class.java.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val fragmentManager = supportFragmentManager
        fragmentA = fragmentManager.findFragmentById(R.id.listFragment) as ListFragment
        fragmentB = fragmentManager.findFragmentById(R.id.detailFragment) as? DetailFragment
        Log.d(TAG, "onCreate: ")
        setContentView(binding.root)
    }


    override fun onItemClickListener(person: Person) {
        if (fragmentB != null) {
         fragmentB?.showData(person)
        } else {
            goToDetailActivity(person)
        }
    }

    private fun goToDetailActivity(person: Person) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("KEY_PEOPLE", person)
        }
        startActivity(intent)
    }
}