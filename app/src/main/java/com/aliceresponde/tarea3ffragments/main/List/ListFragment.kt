package com.aliceresponde.tarea3ffragments.main.List

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aliceresponde.tarea3ffragments.Person
import com.aliceresponde.tarea3ffragments.PersonAdapter
import com.aliceresponde.tarea3ffragments.databinding.FragmentListBinding

class ListFragment : Fragment(), PersonAdapter.ClickListener {
    private lateinit var binding: FragmentListBinding
    private var listener: OnPersonClickedListener? = null
    private val list by lazy { getPeopleList() }
    private val adapter: PersonAdapter by lazy { PersonAdapter(list, this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.recycler.adapter = adapter
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnPersonClickedListener
        Log.d("ListFragment", "onAttach: ")

        if (listener == null)
            throw RuntimeException("You must implement CallBack interface in activity")
    }

    private fun getPeopleList(): List<Person> = listOf(
        Person("Person1", 11, "a1@aa.com"),
        Person("Person2", 12, "a2@aa.com"),
        Person("Person3", 13, "a3@aa.com"),
        Person("Person4", 14, "a4@aa.com"),
        Person("Person5", 15, "a5@aa.com"),
        Person("Person6", 16, "a6@aa.com"),
        Person("Person7", 17, "a7@aa.com"),
        Person("Person8", 18, "a8@aa.com"),
        Person("Person9", 19, "a@9aa.com")
    )

    override fun onItemClickListener(person: Person) {
        listener?.onItemClickListener(person)
    }

    interface OnPersonClickedListener {
        fun onItemClickListener(person: Person)
    }
}