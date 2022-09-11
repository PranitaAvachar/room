package com.ithena.studentdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class StudentAdapter(val context: Context,
                     val ClickDeleteInterface: ClickDeleteInterface,
                     val ClickInterface: ClickInterface
): RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    private val allStudent = ArrayList<Student>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTV = itemView.findViewById<TextView>(R.id.idTVNote)
        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.student_data,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noteTV.setText(allStudent.get(position).name)
        holder.dateTV.setText(allStudent.get(position).surname)
        holder.deleteIV.setOnClickListener {
            ClickDeleteInterface.onDeleteIconClick(allStudent.get(position))
        }

        holder.itemView.setOnClickListener {

            ClickInterface.onNoteClick(allStudent.get(position))
        }
    }
    override fun getItemCount(): Int {
        return allStudent.size
    }
    fun updateList(newList: List<Student>) {
        allStudent.clear()
        allStudent.addAll(newList)
        notifyDataSetChanged()
    }
}

interface ClickDeleteInterface {
    fun onDeleteIconClick(student: Student)
}

interface ClickInterface {
    fun onNoteClick(student: Student)
}