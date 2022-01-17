package com.example.trainingdiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickRegisterBtn(View view) {
        EditText edtTxtName = findViewById(R.id.edtTxtName);
        EditText edtTxtSurname = findViewById(R.id.edtTxtSurname);
        EditText edtTxtEmail = findViewById(R.id.edtTxtEmail);

        TextView txtName = findViewById(R.id.txtName);
        TextView txtSurname = findViewById(R.id.txtSurname);
        TextView txtEmail = findViewById(R.id.txtEmail);

        txtName.setText(edtTxtName.getText().toString());
        txtSurname.setText(edtTxtSurname.getText().toString());
        txtEmail.setText(edtTxtEmail.getText().toString());
    }
}