package com.ithena.studentdata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel (application: Application) : AndroidViewModel(application) {

     val allStudent:LiveData<List<Student>>
     val repository:StudentRepository

    init {
        val studentDao=StudentDatabase.getDatabase(application).getStudentDao()
        repository=StudentRepository(studentDao)
        allStudent = repository.allStudent
    }

    fun deleteStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(student)
    }

    fun updateStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(student)
    }

    fun addStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(student)
    }
}



