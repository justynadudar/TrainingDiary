package com.example.trainingdiary.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;


}
