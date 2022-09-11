package com.ithena.studentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class StudentAddActivity : AppCompatActivity() {

    lateinit var noteTitleEdt: EditText
    lateinit var noteEdt: EditText
    lateinit var saveBtn: Button
    lateinit var viewModal: StudentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_add)


            viewModal = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            ).get(StudentViewModel::class.java)

            noteTitleEdt = findViewById(R.id.idEdtNoteName)
            noteEdt = findViewById(R.id.idEdtNoteDesc)
            saveBtn = findViewById(R.id.idBtn)

            val noteType = intent.getStringExtra("noteType")
        if (noteType != null) {
            if (noteType.equals("Edit")) {
                val name = intent.getStringExtra("name")
                val surname = intent.getStringExtra("surname")
                // noteID = intent.getIntExtra("noteId", -1)

                saveBtn.setText("Update Note")
                noteTitleEdt.setText(name)
                noteEdt.setText(surname)

            } else {
                saveBtn.setText("Save Note")
            }
        }
            saveBtn.setOnClickListener {
                val name = noteTitleEdt.text.toString()
                val surname = noteEdt.text.toString()

                    if (noteType.equals("Edit")) {

                        if (name.isNotEmpty() && surname.isNotEmpty()) {

                            val updatedStudent = Student(name,surname)
                            viewModal.updateStudent(updatedStudent)
                            Toast.makeText(this, "Student Updated..", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        if (name.isNotEmpty() && surname.isNotEmpty()) {
                            viewModal.addStudent(Student(name, surname))
                            Toast.makeText(this, "$name Added", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                startActivity(Intent(applicationContext, MainActivity::class.java))
                this.finish()
            }
        }

