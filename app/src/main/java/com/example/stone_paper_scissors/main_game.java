package com.example.stone_paper_scissors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class main_game extends AppCompatActivity {
    String p1name, p2name;
    Integer rounds;
    int res1val = 3, res2val = 3;
    TextView comment,p1Score,p2Score;
    ImageView res1, res2;
    int counter = 7;
    int checker=1;
    int p1s=0,p2s=0;
    ArrayList<ArrayList<String>>results;
    LinearLayout play1,play2;
    int cho;
    CountDownTimer countDT;


    private static final String TAG = "main_game";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);



            final Intent intent = getIntent();
            p1name = intent.getStringExtra("p1name");
            p2name = intent.getStringExtra("p2name");
            rounds = intent.getIntExtra("rounds", 0);
            cho = intent.getIntExtra("cho", 0);


            if(savedInstanceState!=null){
                p1s=savedInstanceState.getInt("p1s");
                p2s=savedInstanceState.getInt("p2s");
                checker=savedInstanceState.getInt("checker");
            }


        play1=findViewById(R.id.play1);
        play2=findViewById(R.id.play2);




        results = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Draw!!");
        temp.add(p2name);
        temp.add(p1name);
        results.add(temp);
        ArrayList<String> temp1 = new ArrayList<>();
        temp1.add(p1name);
        temp1.add("Draw!!");
        temp1.add(p2name);
        results.add(temp1);
        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add(p2name);
        temp2.add(p1name);
        temp2.add("Draw!!");
        results.add(temp2);


        comment = findViewById(R.id.comment);
        p1Score=findViewById(R.id.score1);
        p2Score=findViewById(R.id.score2);
        randcount();



        p1Score.setText(p1name+": \n"+p1s);
        p2Score.setText(p2name+": \n"+p2s);









        ArrayList<ImageButton> player2Buttons = new ArrayList<>();


        player2Buttons.add((ImageButton) findViewById(R.id.rock2));
        player2Buttons.add((ImageButton) findViewById(R.id.paper2));
        player2Buttons.add((ImageButton) findViewById(R.id.scissors2));

        res1 = (ImageView) findViewById(R.id.present1);
        res2 = (ImageView) findViewById(R.id.present2);


        if(cho==1) {
            ArrayList<ImageButton> player1Buttons = new ArrayList<>();
            player1Buttons.add((ImageButton) findViewById(R.id.rock1));
            player1Buttons.add((ImageButton) findViewById(R.id.paper1));
            player1Buttons.add((ImageButton) findViewById(R.id.scissors1));


            player1Buttons.get(0).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    res1.setImageResource(R.drawable.rockmain);
                    res1val = 0;
                    if (res2val != 3) {
                        randcount();

                    }

                }

            });
            player1Buttons.get(1).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    res1.setImageResource(R.drawable.papermain);
                    res1val = 1;
                    if (res2val != 3) {
                        randcount();

                    }


                }
            });

            player1Buttons.get(2).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    res1.setImageResource(R.drawable.scissormain);
                    res1val = 2;
                    if (res2val != 3) {
                        randcount();


                    }

                }
            });
        }


        player2Buttons.get(0).setOnClickListener(new View.OnClickListener() {

            @Override
                public void onClick(View view) {

                        res2.setImageResource(R.drawable.rockmain);
                        res2val = 0;
                        if (cho==2) {
                            int cho=randImage(3);
                            Log.d(TAG, "onClick: " +cho);
                            if(cho==0){ res1.setImageResource(R.drawable.rockmain);
                                res1val=0;}
                            else if(cho==1){ res1.setImageResource(R.drawable.papermain);
                                res1val=1;}
                            else if(cho==2){ res1.setImageResource(R.drawable.scissormain);
                                res1val=2;}
                        }
                        if(res1val!=3) {
                            randcount();


                        }

                }
            });

        player2Buttons.get(1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    res2.setImageResource(R.drawable.papermain);
                    res2val=1;

                    if (cho==2) {
                        int cho=randImage(3);
                        Log.d(TAG, "onClick: " +cho);
                        if(cho==0){ res1.setImageResource(R.drawable.rockmain);
                        res1val=0;}
                        else if(cho==1){ res1.setImageResource(R.drawable.papermain);
                            res1val=1;}
                        else if(cho==2){ res1.setImageResource(R.drawable.scissormain);
                            res1val=2;}
                }

                    if(res1val!=3) {
                    randcount();


                }
            }
        });

        player2Buttons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    res2.setImageResource(R.drawable.scissormain);
                    res2val=2;
                if (cho==2) {
                    int cho=randImage(3);
                    Log.d(TAG, "onClick: " +cho);
                    if(cho==0){ res1.setImageResource(R.drawable.rockmain);
                        res1val=0;}
                    else if(cho==1){ res1.setImageResource(R.drawable.papermain);
                        res1val=1;}
                    else if(cho==2){ res1.setImageResource(R.drawable.scissormain);
                        res1val=2;}
                }
                if(res1val!=3) {
                    randcount();


                }
            }
        });
    }



public void randcount(){




    Log.d(TAG, "randcount: called");
    countDT=new CountDownTimer(7000,1000){
        @Override
        public void onTick(long millisUntilFinished) {
            if (counter <= 7 && counter > 5 && checker!=1) {

                if(res1val==res2val) {
                    comment.setText(results.get(res1val).get(res2val));
                    comment.setTextColor(Color.BLUE);
                    play1.setBackgroundColor(Color.YELLOW);
                    play2.setBackgroundColor(Color.YELLOW);
                }else{

                    comment.setText(results.get(res1val).get(res2val)+" Wins!!");
                    comment.setTextColor(Color.BLUE);
                    if(results.get(res1val).get(res2val)==p1name){
                        play1.setBackgroundColor(Color.GREEN);
                        play2.setBackgroundColor(Color.RED);
                    }else if(results.get(res1val).get(res2val)==p2name){
                        play2.setBackgroundColor(Color.GREEN);
                        play1.setBackgroundColor(Color.RED);
                    }
                }
            }else if(counter<=5 && counter>3){
                if(checker==1) {
                    comment.setText("Game Starts in: ");
                    Log.d(TAG, "onTick: "+checker);
                } else if(checker<=rounds){
                    if(counter==5) {
                        addPoints();
                    }
                    play2.setBackgroundColor(getResources().getColor(R.color.lakeblue));
                    play1.setBackgroundColor(getResources().getColor(R.color.lakeblue));
                    res1.setImageResource(R.color.lakeblue);
                    res2.setImageResource(R.color.lakeblue);
                    comment.setText("Next Round In: ");
                }else {
                    if(counter==5) {
                        addPoints();
                        Intent intent = new Intent(main_game.this, score_page.class);
                        intent.putExtra("p1s", Integer.valueOf(p1s));
                        intent.putExtra("p2s", Integer.valueOf(p2s));
                        intent.putExtra("p1name", p1name);
                        intent.putExtra("p2name", p2name);
                        startActivity(intent);
                    }
                }

            }else if(counter==3) {
                if (checker != 1) {

                }

                comment.setText(String.valueOf(counter));
                comment.setTextColor(Color.RED);
            }else if(counter==2) {
                comment.setText(String.valueOf(counter));
                comment.setTextColor(Color.YELLOW);
            }else if(counter==1) {
                comment.setText(String.valueOf(counter));
                comment.setTextColor(Color.GREEN);

            }
            counter--;

        }

        @Override
        public void onFinish() {
            counter=7;
            comment.setText("Choose!!");
            comment.setTextColor(Color.DKGRAY);

            checker++;
            res2val=3;
            res1val=3;

        }
    }.start();

}

public void addPoints(){
    if(results.get(res1val).get(res2val)==p1name){
        p1s++;
        p1Score.setText(p1name+": \n"+(p1s));

    }else if (results.get(res1val).get(res2val)==p2name){
        p2s++;
        p2Score.setText(p2name+": \n"+(p2s));

    }
}

    public int randImage(int n){
        Log.d(TAG, "randImage: called");
        Random rand = new Random();
        return rand.nextInt(n);



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("p1s",p1s);
        outState.putInt("p2s",p2s);
        outState.putInt("checker",checker);
    }
}