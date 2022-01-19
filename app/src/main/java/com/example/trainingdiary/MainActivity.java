package com.example.trainingdiary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegistrationFragment()).commit();
    }

    public void onClickRegisterBtn(View view) {
        EditText edtTxtName = findViewById(R.id.edtTxtName);
        EditText edtTxtSurname = findViewById(R.id.edtTxtSurname);
        EditText edtTxtEmail = findViewById(R.id.edtTxtEmail);

        Boolean checkinsertdata = db.insertuserdata(edtTxtName.getText().toString(), edtTxtSurname.getText().toString(), edtTxtEmail.getText().toString());

        if(checkinsertdata == true){
            Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();

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