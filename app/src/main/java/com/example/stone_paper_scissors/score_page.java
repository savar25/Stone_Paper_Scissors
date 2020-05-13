package com.example.stone_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        Intent intent=getIntent();
        String p1name=intent.getStringExtra("p1name");
        String p2name=intent.getStringExtra("p2name");
        int p1s=intent.getIntExtra("p1s",0);
        int p2s=intent.getIntExtra("p2s",0);

        TextView sc1=findViewById(R.id.disp1);
        sc1.setText(p1name+"\n"+(p1s));
        TextView sc2=findViewById(R.id.disp2);
        sc2.setText(p2name+"\n"+(p2s));
        TextView winner=findViewById(R.id.winner);

        if(p1s>p2s){
            winner.setText(p1name+ " Won!");
        }else if(p2s>p1s){
            winner.setText(p2name+"  Won!");
        }else{
            winner.setText("Its a Draw!!");
        }

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(score_page.this,MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}
