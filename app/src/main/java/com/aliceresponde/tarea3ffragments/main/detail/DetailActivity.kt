package com.aliceresponde.tarea3ffragments.main.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aliceresponde.tarea3ffragments.Person
import com.aliceresponde.tarea3ffragments.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val person = intent.getParcelableExtra<Person>("KEY_PEOPLE")
        person?.let {
            binding.apply {
                userEmailTv.text = person.email
                userNameTv.text = person.name
                userAgeTv.text = person.age.toString()
            }
        }
        setContentView(binding.root)
    }
}