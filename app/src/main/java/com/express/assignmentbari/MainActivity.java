package com.express.assignmentbari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
databaseopenhelper dbhp;
Button phy,chem,eng,urdu,bio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhp=new databaseopenhelper(this);
        phy=(Button)findViewById(R.id.btnphy);
        chem=(Button)findViewById(R.id.btnchem);
        eng=(Button)findViewById(R.id.btneng);
        urdu=(Button)findViewById(R.id.btnurdu);
        bio=(Button)findViewById(R.id.btnbio);
        phy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,physics.class);
                startActivity(intent);
            }
        });
        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,chemistry.class);
                startActivity(intent);
            }
        });
       eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,english.class);
                startActivity(intent);
            }
        });
        urdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,urdu.class);
                startActivity(intent);
            }
        });
       bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,biology.class);
                startActivity(intent);
            }
        });
    }
}
