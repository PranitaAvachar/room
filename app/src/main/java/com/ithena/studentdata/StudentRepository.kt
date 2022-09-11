package com.ithena.studentdata

import androidx.lifecycle.LiveData

class StudentRepository(private val studentDao: StudentDao) {



        val allStudent:LiveData<List<Student>> = studentDao.getAllStudents()


    suspend fun insert(student: Student) {
            studentDao.insert(student)
        }
        suspend fun delete(student: Student){
            studentDao.delete(student)
        }

        suspend fun update(student: Student){
            studentDao.update(student)
        }
    }
