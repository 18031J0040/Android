package com.example.divyanarahari.bloodbud;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

class member {
    String name;
    String bloodgroup;
    String phno;
    String pincode;

    member(String name, String bloodgroup, String phno , String pincode) {
        this.name = name;
        this.bloodgroup = bloodgroup;
        this.phno = phno;
        this.pincode=pincode;
    }

    public member() {
    }

    public String getName() {
        return name;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getPhno() {
        return phno;
    }

    public String getPincode()
    {
        return pincode;
    }
    public String toString()
    {
        return name+" "+bloodgroup+" "+phno+" "+pincode;
    }


}
public class Registration extends AppCompatActivity {
    EditText name;
    EditText bloodgroup;
    EditText phno;
    EditText pincode;
    Button register;
    Button exit;
    FirebaseDatabase database;
    DatabaseReference myref;
    member mem;
    long id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText) findViewById(R.id.etName);
        bloodgroup = (EditText) findViewById(R.id.etbloodgrp);
        phno=(EditText)findViewById(R.id.etphone) ;
        pincode=(EditText)findViewById(R.id.etPin);
        register = (Button) findViewById(R.id.btnreg);
        exit = (Button) findViewById(R.id.btnexit);
        database = FirebaseDatabase.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
                //  Toast.makeText(Registration.this, mem.toString() +" data inserted.. ", Toast.LENGTH_LONG).show();
                String bd =bloodgroup.getText().toString();
                String blood = bd.toLowerCase();
                switch (blood)
                {
                    case "a+" : myref = database.getReference("a+");
                        mem = new member(name.getText().toString(), bloodgroup.getText().toString(), phno.getText().toString(),pincode.getText().toString());
                        id=id+1;
                        System .out.println("*************************************************&&&&&&&&&&&&&&&&&&&&&&&  "+id);
                        myref.child(String.valueOf(id)).setValue(mem);
                        Toast.makeText(Registration.this, mem+"..data inserted.. ", Toast.LENGTH_LONG).show();
                        break;
                    case "a-": myref = database.getReference("a-");
                        mem = new member(name.getText().toString(), bloodgroup.getText().toString(), phno.getText().toString(),pincode.getText().toString());
                        id=id+1;
                        System .out.println("*************************************************&&&&&&&&&&&&&&&&&&&&&&&  "+id);
                        myref.child(String.valueOf(id)).setValue(mem);
                        Toast.makeText(Registration.this, mem+"..data inserted.. ", Toast.LENGTH_LONG).show();
                        break;
                    case "b+":myref = database.getReference("b+");
                        mem = new member(name.getText().toString(), bloodgroup.getText().toString(), phno.getText().toString(),pincode.getText().toString());
                        id=id+1;
                        System .out.println("*************************************************&&&&&&&&&&&&&&&&&&&&&&&  "+id);
                        myref.child(String.valueOf(id)).setValue(mem);
                        Toast.makeText(Registration.this, mem+"..data inserted.. ", Toast.LENGTH_LONG).show();
                        break;
                    case "b-":myref = database.getReference("b-");
                        mem = new member(name.getText().toString(), bloodgroup.getText().toString(), phno.getText().toString(),pincode.getText().toString());
                        id=id+1;
                        System .out.println("*************************************************&&&&&&&&&&&&&&&&&&&&&&&  "+id);
                        myref.child(String.valueOf(id)).setValue(mem);
                        Toast.makeText(Registration.this, mem+"..data inserted.. ", Toast.LENGTH_LONG).show();
                        break;
                    case "ab+":myref = database.getReference("ab+");
                        mem = new member(name.getText().toString(), bloodgroup.getText().toString(), phno.getText().toString(),pincode.getText().toString());
                        id=id+1;
                        System .out.println("*************************************************&&&&&&&&&&&&&&&&&&&&&&&  "+id);
                        myref.child(String.valueOf(id)).setValue(mem);
                        Toast.makeText(Registration.this, mem+"..data inserted.. ", Toast.LENGTH_LONG).show();
                        break;
                    case "ab-":myref = database.getReference("ab-");
                        mem = new member(name.getText().toString(), bloodgroup.getText().toString(), phno.getText().toString(),pincode.getText().toString());
                        id=id+1;
                        System .out.println("*************************************************&&&&&&&&&&&&&&&&&&&&&&&  "+id);
                        myref.child(String.valueOf(id)).setValue(mem);
                        Toast.makeText(Registration.this, mem+"..data inserted.. ", Toast.LENGTH_LONG).show();
                        break;
                    case "o+":  myref = database.getReference("o+");
                        mem = new member(name.getText().toString(), bloodgroup.getText().toString(), phno.getText().toString(),pincode.getText().toString());
                        myref.child(String.valueOf(id++)).setValue(mem);
                        Toast.makeText(Registration.this, mem+"..data inserted.. ", Toast.LENGTH_LONG).show();
                        break;
                    case "o-":  myref = database.getReference("o-");
                        mem = new member(name.getText().toString(), bloodgroup.getText().toString(), phno.getText().toString(),pincode.getText().toString());
                        id=id+1;
                        //System .out.println("*************************************************&&&&&&&&&&&&&&&&&&&&&&&  "+id);
                        myref.child(String.valueOf(id)).setValue(mem);
                        Toast.makeText(Registration.this, mem+"..data inserted.. ", Toast.LENGTH_LONG).show();
                        break;
                }
                name.setText("");
                bloodgroup.setText("");
                phno.setText("");
                pincode.setText("");

            }

            private boolean validate() {
                Boolean result = false;
                String name1 = name.getText().toString();
                String bg1 = bloodgroup.getText().toString();
                String num = phno.getText().toString();
                String pin=pincode.getText().toString();
                if(num.length()>10||num.length()<10)
                {
                    Toast.makeText(Registration.this,"Please enter valid phone number",Toast.LENGTH_LONG).show();
                }
                if(name1.isEmpty() || bg1.isEmpty() || num.isEmpty())
                {
                    Toast.makeText(Registration.this,"Please fill all the details",Toast.LENGTH_LONG).show();
                }
                if(pin.length()>6||pin.length()<6)
                {
                    Toast.makeText(Registration.this,"Please enter valid pincode",Toast.LENGTH_LONG).show();
                }
                else
                {
                    result = true;
                }
                return result;
            }


        });


       /* myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    id=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mem=new member();

*/
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
