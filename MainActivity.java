package com.example.passwordmanagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private TextView MsgText;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mChildReference = mRootReference.child("message");
    EditText txtuser, txtpass;
    Button save;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtuser = (EditText) findViewById(R.id.username);
        txtpass = (EditText) findViewById(R.id.password);
        save = (Button) findViewById(R.id.button);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UN = txtuser.getText().toString().trim();
                member.setUsername(txtuser.getText().toString().trim());
                member.setPassword(txtpass.getText().toString().trim());
                reff.push().setValue(member);
                Toast.makeText(MainActivity.this, "data inserted successfully", Toast.LENGTH_LONG).show();
            }
        });

    }
}


   /* @Override
    protected void onStart() {
        super.onStart();
        mChildReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String message = dataSnapshot.getValue(String.class);
                MsgText.setText(message);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    } */

