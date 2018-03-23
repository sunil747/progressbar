package com.example.sunil.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    ProgressBar prg;
    private DatabaseReference mdatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prg = (ProgressBar)findViewById(R.id.progressBar);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Name");
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Puc");



        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String name = dataSnapshot.getValue().toString();
                String puc = dataSnapshot.getValue().toString();

                int n1 = Integer.parseInt(name);
                int n2 = Integer.parseInt(puc);



                     if((n1>50)&&(n2>75))
                     {
                         prg.setProgress(75);
                     }
                     else
                     {
                         prg.setProgress(25);
                     }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
