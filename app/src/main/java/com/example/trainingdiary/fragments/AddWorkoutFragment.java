package com.example.trainingdiary.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingdiary.Exercise;
import com.example.trainingdiary.adapters.ExerciseAdapter;
import com.example.trainingdiary.databinding.FragmentAddWorkoutBinding;

import com.example.trainingdiary.R;

import java.util.ArrayList;

public class AddWorkoutFragment extends Fragment implements View.OnClickListener{
    FragmentAddWorkoutBinding binding;
    Button btnAddUserExercise, btnAddAPIExercise, btnConfirm;
    RecyclerView addedExercisesList;
    private static final String EXERCISE_KEY = "exercise_key";
    Exercise exercise;
    ArrayList<Exercise> exercises = new ArrayList<>();
    ExerciseAdapter exerciseAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle(getString(R.string.add_training_title
        ));
        binding = FragmentAddWorkoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAddUserExercise = binding.btnAddUserExercise;
        btnAddAPIExercise = binding.btnAddApiExercise;
        btnConfirm = binding.btnAddWorkout;
        btnAddUserExercise.setOnClickListener(this);
        btnAddAPIExercise.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);

        if(getArguments() != null){
            exercise = (Exercise) getArguments().getSerializable(EXERCISE_KEY);
            exercises.add(exercise);
        }
        addedExercisesList = binding.addedToTrainingList;
        addedExercisesList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        exerciseAdapter = new ExerciseAdapter(exercises);
        addedExercisesList.setAdapter(exerciseAdapter);

    }

    @Override
    public void onClick(View v) {
        Bundle result = new Bundle();
        switch(v.getId()){
            case R.id.btn_add_user_exercise:
                result.putString("bundleKey", "addUserExerciseButtonClicked");
                getParentFragmentManager().setFragmentResult("requestKey", result);
                break;
            case R.id.btn_add_api_exercise:
                result.putString("bundleKey", "addAPIExerciseButtonClicked");
                getParentFragmentManager().setFragmentResult("requestKey", result);
                break;
            case R.id.btn_add_workout:
                result.putString("bundleKey", "addWorkoutButtonClicked");
                getParentFragmentManager().setFragmentResult("requestKey", result);
                break;
        }

    }
}
