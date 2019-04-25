package com.example.divyanarahari.bloodbud;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DivyaActivity extends AppCompatActivity {
    TextView info;
    FirebaseDatabase database;
    DatabaseReference mref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divya);
        info=(TextView)findViewById(R.id.divya);
        String b=getIntent().getStringExtra("blood");
        database=FirebaseDatabase.getInstance();
        mref=database.getReference();
        mref.child(b).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    for(DataSnapshot da1:ds.getChildren())
                    {
                        String s=(String)da1.getValue();
                        //info.setText(s);
                        info.append(s+"\n");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
