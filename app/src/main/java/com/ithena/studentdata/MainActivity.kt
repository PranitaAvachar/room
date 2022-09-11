package com.ithena.studentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() ,ClickInterface, ClickDeleteInterface {

    private lateinit var viewModal: StudentViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var click:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerview)
        click = findViewById(R.id.click)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val studentAdapter = StudentAdapter(this, this, this)

        recyclerView.adapter = studentAdapter

        viewModal = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(StudentViewModel::class.java)

        viewModal.allStudent.observe(this, Observer { list -> list?.let {
                studentAdapter.updateList(it)
            }
        })
        click.setOnClickListener {
            val intent = Intent(this@MainActivity,StudentAddActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    override fun onNoteClick(student: Student) {
        val intent = Intent(this@MainActivity,StudentAddActivity::class.java)
        intent.putExtra("noteType", "Edit")
        intent.putExtra("name", student.name)
        intent.putExtra("surname", student.surname)
        //intent.putExtra("roll_no", roll_no)
        startActivity(intent)
        this.finish()
    }

    override fun onDeleteIconClick(student: Student) {
        viewModal.deleteStudent(student)
        Toast.makeText(this, "${student.name} Deleted", Toast.LENGTH_LONG).show()
    }

}
