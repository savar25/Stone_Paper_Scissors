package com.example.stone_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText p1Name=(EditText)findViewById(R.id.p1Name);
        final EditText p2Name=(EditText)findViewById(R.id.p2Name);
        final EditText rounds=(EditText)findViewById(R.id.rounds);


       p1Name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View view, boolean b) {
               if(b){
                   p1Name.setHint("");
               }else{
                   p1Name.setHint("Player 1 Name\n Leave Empty for Single Player) ");
               }
           }
       });

        p2Name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    p2Name.setHint("");
                }else{
                    p2Name.setHint("Player 2 Name");
                }
            }
        });


        rounds.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    rounds.setHint("");
                }else{
                    rounds.setHint("No. of Rounds");
                }
            }
        });

        Button startBtn=(Button)findViewById(R.id.GO);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String p1=p1Name.getText().toString();
                Log.d(TAG, "onClick: "+p1Name.getText());
                Log.d(TAG, "onClick: "+p1);
                String p2=p2Name.getText().toString();
                Integer r;
                if(rounds.getText().toString().isEmpty()) {
                    r=0;

                }else{
                    r = Integer.parseInt(rounds.getText().toString());
                }

                if(p1.isEmpty()||p2.isEmpty()||r==0){
                    String empty="";
                    if(p1.isEmpty()){empty=empty.concat("Player 1 Name,");}
                    if(p2.isEmpty()){empty=empty.concat("Player 2 Name,");}
                    if(r==0){empty=empty.concat("No. of rounds");}

                    Toast.makeText(MainActivity.this,empty+" not added",Toast.LENGTH_SHORT).show();


                }else {
                    Intent intent = new Intent(MainActivity.this, main_game.class);
                    intent.putExtra("p1name", p1);
                    intent.putExtra("p2name", p2);
                    intent.putExtra("rounds", r);
                    intent.putExtra("cho", 1);
                    startActivity(intent);
                }

            }
        });

        Button splyer=(Button)findViewById(R.id.splayer);
        splyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p2=p2Name.getText().toString();
                String p1="Computer";
                Integer r;
                if(rounds.getText().toString().isEmpty()) {
                    r=0;

                }else{
                    r = Integer.parseInt(rounds.getText().toString());
                }

                if(p2.isEmpty()||r==0) {
                    String empty = "";

                    if (p2.isEmpty()) {
                        empty = empty.concat("Player 2 Name,");
                    }

                    if (r == 0) {
                        empty = empty.concat("No. of rounds");
                    }

                    Toast.makeText(MainActivity.this, empty + " not added", Toast.LENGTH_SHORT).show();

                }else if(!(p1Name.getText().toString().isEmpty())){
                        Toast.makeText(MainActivity.this, "Remove Player 1 Name", Toast.LENGTH_SHORT).show();

                }else {


                    Intent intent = new Intent(MainActivity.this, main_game.class);
                    intent.putExtra("p1name", p1);
                    intent.putExtra("p2name", p2);
                    intent.putExtra("rounds", r);
                    intent.putExtra("cho", 2);
                    startActivity(intent);
                }
            }
        });
    }
}
