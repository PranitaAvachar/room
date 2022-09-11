package com.ithena.studentdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
 class Student (
   @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "surname")
    val surname: String
){
    @PrimaryKey(autoGenerate = true)var roll_no=0
 }

