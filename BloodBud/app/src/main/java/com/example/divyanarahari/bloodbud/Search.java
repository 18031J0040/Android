package com.example.divyanarahari.bloodbud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Search extends AppCompatActivity {
    EditText bloodgroup;
    Button search;
    EditText pincode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bloodgroup=(EditText)findViewById(R.id.editText);
        pincode=(EditText)findViewById(R.id.etPin);
        search=(Button)findViewById(R.id.button);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Search.this,DivyaActivity.class);
                i.putExtra("blood",bloodgroup.getText().toString());
                Toast.makeText(Search.this, bloodgroup.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(i);

            }
        });
    }
}
