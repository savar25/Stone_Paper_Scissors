package com.example.stone_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText p1Name=(EditText)findViewById(R.id.p1Name);
        final EditText p2Name=(EditText)findViewById(R.id.p2Name);
        final EditText rounds=(EditText)findViewById(R.id.rounds);

        Button startBtn=(Button)findViewById(R.id.GO);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1=p1Name.getText().toString();
                String p2=p2Name.getText().toString();
                Integer r=Integer.parseInt(rounds.getText().toString());

                Intent intent=new Intent(MainActivity.this,main_game.class);
                intent.putExtra("p1name",p1);
                intent.putExtra("p2name",p2);
                intent.putExtra("rounds",r);
                intent.putExtra("cho",1);
                startActivity(intent);

            }
        });

        Button splyer=(Button)findViewById(R.id.splayer);
        splyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p2=p2Name.getText().toString();
                String p1="Computer";
                Integer r=Integer.parseInt(rounds.getText().toString());

                Intent intent=new Intent(MainActivity.this,main_game.class);
                intent.putExtra("p1name",p1);
                intent.putExtra("p2name",p2);
                intent.putExtra("rounds",r);
                intent.putExtra("cho",2);
                startActivity(intent);
            }
        });
    }
}
