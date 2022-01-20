package com.example.trainingdiary;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trainingdiary.fragments.menu.AddWorkoutFragment;
import com.example.trainingdiary.fragments.menu.AllExercisesFragment;
import com.example.trainingdiary.fragments.menu.AllWorkoutsFragment;
import com.example.trainingdiary.fragments.menu.HistoryFragment;
import com.example.trainingdiary.fragments.menu.ProfileFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    EditText edtTxtName, edtTxtSurname, edtTxtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Firebase connection Succes", Toast.LENGTH_LONG).show();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddWorkoutFragment()).commit();
    }

    public void onClickRegisterBtn(View view) {
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtSurname = findViewById(R.id.edtTxtSurname);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);

//        TextView txtName = findViewById(R.id.txtName);
//        TextView txtSurname = findViewById(R.id.txtSurname);
//        TextView txtEmail = findViewById(R.id.txtEmail);
//
//        txtName.setText(edtTxtName.getText().toString());
//        txtSurname.setText(edtTxtSurname.getText().toString());
//        txtEmail.setText(edtTxtEmail.getText().toString());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.nav_add_workout:
                            selectedFragment = new AddWorkoutFragment();
                            break;
                        case R.id.nav_history:
                            selectedFragment = new HistoryFragment();
                            break;
                        case R.id.nav_workouts:
                            selectedFragment = new AllWorkoutsFragment();
                            break;
                        case R.id.nav_exercises:
                            selectedFragment = new AllExercisesFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }
getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;}
            };
}