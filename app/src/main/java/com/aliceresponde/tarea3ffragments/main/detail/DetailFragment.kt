package com.aliceresponde.tarea3ffragments.main.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aliceresponde.tarea3ffragments.Person
import com.aliceresponde.tarea3ffragments.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private var binding: FragmentDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    fun showData(person: Person) {
        binding?.apply {
            userEmailTv.text = person.email
            userNameTv.text = person.name
            userAgeTv.text = person.age.toString()
        }
    }
}