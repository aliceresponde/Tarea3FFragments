package com.aliceresponde.tarea3ffragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(val list: List<Person>, val listener: PersonAdapter.ClickListener) :
    RecyclerView.Adapter<PersonAdapter.CityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.person_item, parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class CityViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(person: Person) {
            val nameTv = view.findViewById<TextView>(R.id.userNameTv)
            nameTv.text = person.name
            view.setOnClickListener {
                listener.onItemClickListener(person)
            }
        }
    }

    interface ClickListener {
        fun onItemClickListener(person: Person)
    }
}
