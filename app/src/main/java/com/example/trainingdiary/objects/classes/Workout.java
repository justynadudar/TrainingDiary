package com.example.trainingdiary.objects.classes;

import java.util.ArrayList;

public class Workout {
    String id;
    String name;
    private ArrayList<Exercise> Exercises;

    public Workout() {
        this.Exercises = new ArrayList<>();
    }

    public Workout(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Exercise> getExercises() {
        return Exercises;
    }

    public void addExercise(Exercise exercise) {
        this.Exercises.add(exercise);
    }
}
