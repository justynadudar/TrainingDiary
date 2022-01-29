package com.example.trainingdiary.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trainingdiary.R;

public class AllWorkoutsFragment extends Fragment {
    Button btnAddExercise, btnAddAPIExercise;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_workouts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        btnAddExercise = (Button) getView().findViewById(R.id.btn_add_user_exercise);
//        btnAddExercise.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle result = new Bundle();
//                result.putString("bundleKey", "result");
//                getParentFragmentManager().setFragmentResult("requestKey", result);
//            }});
//        btnAddAPIExercise = (Button) getView().findViewById(R.id.btn_add_api_exercise);
//        btnAddAPIExercise.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle result = new Bundle();
//                result.putString("bundleKey", "addAPIExerciseButtonClicked");
//                getParentFragmentManager().setFragmentResult("requestKey", result);
//            }});
    }
}