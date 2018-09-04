package com.akash.skyhigh.tictacto;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.solver.widgets.WidgetContainer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class tictack extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,replay,home;
    int draw=0;
    int x,o;
    boolean cross,isdraw,f;
    int blue= Color.parseColor("#3f51b5"),dpbl=Color.parseColor("#ffffff");
    int white= Color.parseColor("#ffffff");
    char a[][]=new char[3][3],winner;

    public void ai(char v,char w)
    {
        if(winner=='\0'&&f) {
            isdraw = true;
            int c=0,c1=0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (a[i][j] == '\0') {
                        //row wise check
                        if (a[i][(j + 1) % 3] == v && a[i][(j + 1) % 3] == a[i][(j + 2) % 3])
                            c++;
                            //coloum wise check
                        else if (a[(i + 1) % 3][j] == v && a[(i + 1) % 3][j] == a[(i + 2) % 3][j])
                            c++;
                            //diagonal wise check
                        else if (i == j) {
                            if (a[(i + 1) % 3][(j + 1) % 3] == v && a[(i + 1) % 3][(j + 1) % 3] == a[(i + 2) % 3][(j + 2) % 3])
                                c++;
                            if (i == 1 && j == 1 && a[2][0] == v && a[2][0] == a[0][2])
                                c++;
                        } else if ((i == 2 && j == 0) && a[1][1] == v && a[1][1] == a[0][2])
                            c++;
                        else if (i == 0 && j == 2 && a[2][0] == v && a[2][0] == a[1][1])
                            c++;

                        if (a[i][(j + 1) % 3] == w && a[i][(j + 1) % 3] == a[i][(j + 2) % 3])
                            c1++;
                            //coloum wise check
                        else if (a[(i + 1) % 3][j] == w && a[(i + 1) % 3][j] == a[(i + 2) % 3][j])
                            c1++;
                            //diagonal wise check
                        else if (i == j) {
                            if (a[(i + 1) % 3][(j + 1) % 3] == w && a[(i + 1) % 3][(j + 1) % 3] == a[(i + 2) % 3][(j + 2) % 3])
                                c1++;
                            if (i == 1 && j == 1 && a[2][0] == w && a[2][0] == a[0][2])
                                c1++;
                        } else if ((i == 2 && j == 0) && a[1][1] == w && a[1][1] == a[0][2])
                            c1++;
                        else if (i == 0 && j == 2 && a[2][0] == w && a[2][0] == a[1][1])
                            c1++;
                    }
                }
            }
            if(isdraw&&c==1) {
                if (v == 'x' && x > 0) {
                    Toast.makeText(getApplicationContext(), "Player 1 might win", Toast.LENGTH_SHORT).show();
                    isdraw=false;
                } else if (v == 'o' && o > 0) {
                    Toast.makeText(getApplicationContext(), "Player 2 might win", Toast.LENGTH_SHORT).show();
                    isdraw=false;
                }
            }
            if(isdraw&&c>1)
            {
                if (v == 'x' && x > 0) {
                    Toast.makeText(getApplicationContext(), "Player 1 has 100% winning chance", Toast.LENGTH_SHORT).show();
                    isdraw=false;
                }else if (v == 'o' && o > 0){
                    Toast.makeText(getApplicationContext(), "Player 2 has 100% win chance", Toast.LENGTH_SHORT).show();
                    isdraw=false;
                }
            }
            if(isdraw&&c1==1) {
                if (w == 'x' && x > 0) {
                    Toast.makeText(getApplicationContext(), "Player 1 might win", Toast.LENGTH_SHORT).show();
                    isdraw=false;
                } else if (w == 'o' && o > 0) {
                    Toast.makeText(getApplicationContext(), "Player 2 might win", Toast.LENGTH_SHORT).show();
                    isdraw=false;
                }
            }
            if(isdraw&&c1>1)
            {
                if (w == 'x' && x > 0) {
                    Toast.makeText(getApplicationContext(), "Player 1 has 100% winning chance", Toast.LENGTH_SHORT).show();
                    isdraw=false;
                }else if (w == 'o' && o > 0){
                    Toast.makeText(getApplicationContext(), "Player 2 has 100% win chance", Toast.LENGTH_SHORT).show();
                    isdraw=false;
                }
            }

            if (draw > 6 && draw < 9 && isdraw)
                Toast.makeText(getApplicationContext(), "Match already draw", Toast.LENGTH_SHORT).show();

        }
    }
    public void pop(String s)
    {
        AlertDialog dialog = new AlertDialog.Builder(this).setMessage(s).show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(40);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        textView.setTextColor(dpbl);
    }
    public void lightup(int a)
    {
        if(a==1)
        {
            b1.setBackgroundColor(blue);
            b1.setTextColor(white);
        }
        if(a==2)
        {
            b2.setBackgroundColor(blue);
            b2.setTextColor(white);
        }
        if(a==3)
        {
            b3.setBackgroundColor(blue);
            b3.setTextColor(white);
        }
        if(a==4)
        {
            b4.setBackgroundColor(blue);
            b4.setTextColor(white);
        }
        if(a==5)
        {
            b5.setBackgroundColor(blue);
            b5.setTextColor(white);
        }
        if(a==6)
        {
            b6.setBackgroundColor(blue);
            b6.setTextColor(white);
        }
        if(a==7)
        {
            b7.setBackgroundColor(blue);
            b7.setTextColor(white);
        }
        if(a==8)
        {
            b8.setBackgroundColor(blue);
            b8.setTextColor(white);
        }
        if(a==9)
        {
            b9.setBackgroundColor(blue);
            b9.setTextColor(white);
        }
    }
    public void check(int n,char v)
    {
        if(v=='x')
            x--;
        else o--;
        draw++;
        int i=n/3;
        int j=n%3;
        a[i][j]=v;
        //main checking algo part
        for(i=0;i<3;i++)
        {
            if(a[i][0]==a[i][1]&&a[i][0]==a[i][2]&&a[i][2]!='\0')
            {
                winner=a[i][0];
                lightup(3*i+1);
                lightup(3*i+2);
                lightup(3*i+3);
                draw=0;
                return;
            }
            if(a[0][i]==a[1][i]&&a[1][i]==a[2][i]&&a[2][i]!='\0')
            {
                winner=a[0][i];
                lightup(3*0+i+1);
                lightup(3*1+i+1);
                lightup(3*2+i+1);
                draw=0;
                return;
            }
        }
        if(a[0][0]==a[1][1]&&a[1][1]==a[2][2]&&a[2][2]!='\0')
        {
            winner=a[1][1];
            lightup(1);
            lightup(5);
            lightup(9);
            draw=0;
            return;
        }
        if(a[0][2]==a[1][1]&&a[1][1]==a[2][0]&&a[2][0]!='\0')
        {
            winner=a[1][1];
            lightup(3);
            lightup(5);
            lightup(7);
            draw=0;
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictack);
        Bundle extras = getIntent().getExtras();  //used to share data b/w activities
        f = extras.getBoolean("ai");
        b1=findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        replay=(Button)findViewById(R.id.button10);
        home=findViewById(R.id.button11);
        b1.setTypeface(null, Typeface.BOLD);
        b2.setTypeface(null, Typeface.BOLD);
        b3.setTypeface(null, Typeface.BOLD);
        b4.setTypeface(null, Typeface.BOLD);
        b5.setTypeface(null, Typeface.BOLD);
        b6.setTypeface(null, Typeface.BOLD);
        b7.setTypeface(null, Typeface.BOLD);
        b8.setTypeface(null, Typeface.BOLD);
        b9.setTypeface(null, Typeface.BOLD);
        b1.setTextSize(40);
        b2.setTextSize(40);
        b3.setTextSize(40);
        b4.setTextSize(40);
        b5.setTextSize(40);
        b6.setTextSize(40);
        b7.setTextSize(40);
        b8.setTextSize(40);
        b9.setTextSize(40);

        /*ViewGroup v=(ViewGroup)tst.getView();
        TextView txt=(TextView) v.getChildAt(0);
        txt.setTextSize(25);*/
        isdraw=cross = true;
        x=5;o=4;
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw>0&&draw<9) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(tictack.this);

                    //Setting message manually and performing action on button click
                    builder.setTitle("Do you want to end this game and go to home?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent i = new Intent(getApplicationContext(),home.class);
                                    finish();
                                    startActivity(i);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();
                }
                else {
                    Intent i = new Intent(getApplicationContext(),home.class);
                    finish();
                    startActivity(i);
                }

            }
        });
        replay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                if(winner!='x'&&winner!='o'&&draw>0&&draw<9) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(tictack.this);

                    //Setting message manually and performing action on button click
                    builder.setTitle("Do you want to end this game and start new game?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent i = new Intent(getApplicationContext(),tictack.class);
                                    i.putExtra("ai", f);
                                    finish();
                                    startActivity(i);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();
                }
                else {
                    Intent i = new Intent(getApplicationContext(),tictack.class);
                    i.putExtra("ai", f);
                    finish();
                    startActivity(i);
                }

            }

        });
        b1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b1.getText().equals("")) {
                        if (cross) {
                            b1.setText("X");
                            check(0,'x');
                            ai('o','x');
                            cross = false;
                        } else {
                            b1.setText("O");
                            check(0,'o');
                            ai('x','o');
                            cross = true;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner=='x')
                    pop("1st Player Wins!");
                else if(winner=='o')
                    pop("2nd Player Wins!");
                else if(draw==9)
                    pop("Match Draw");
            }
        });
        b2.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {

                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b2.getText().equals("")) {
                        if (cross) {
                            b2.setText("X");
                            check(1,'x');
                            ai('o','x');
                            cross = false;
                        } else {
                            b2.setText("O");
                            check(1,'o');
                            ai('x','o');
                            cross = true;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner=='x')
                    pop("1st Player Wins!");
                else if(winner=='o')
                    pop("2nd Player Wins!");
                else if(draw==9)
                    pop("Match Draw");
            }
        });
        b3.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b3.getText().equals("")) {
                        if (cross) {
                            b3.setText("X");
                            check(2,'x');
                            ai('o','x');
                            cross = false;
                        } else {
                            b3.setText("O");
                            check(2,'o');
                            ai('x','o');
                            cross = true;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner=='x')
                    pop("1st Player Wins!");
                else if(winner=='o')
                    pop("2nd Player Wins!");
                else if(draw==9)
                    pop("Match Draw");
            }
        });
        b4.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b4.getText().equals("")) {
                        if (cross) {
                            b4.setText("X");
                            check(3,'x');
                            ai('o','x');
                            cross = false;
                        } else {
                            b4.setText("O");
                            check(3,'o');
                            ai('x','o');
                            cross = true;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner=='x')
                    pop("1st Player Wins!");
                else if(winner=='o')
                    pop("2nd Player Wins!");
                else if(draw==9)
                    pop("Match Draw");
            }
        });
        b5.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b5.getText().equals("")) {
                        if (cross) {
                            b5.setText("X");
                            check(4,'x');
                            ai('o','x');
                            cross = false;
                        } else {
                            b5.setText("O");
                            check(4,'o');
                            ai('x','o');
                            cross = true;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner=='x')
                    pop("1st Player Wins!");
                else if(winner=='o')
                    pop("2nd Player Wins!");
                else if(draw==9)
                    pop("Match Draw");
            }
        });
        b6.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b6.getText().equals("")) {
                        if (cross) {
                            b6.setText("X");
                            check(5,'x');
                            ai('o','x');
                            cross = false;
                        } else {
                            b6.setText("O");
                            check(5,'o');
                            ai('x','o');
                            cross = true;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner=='x')
                    pop("1st Player Wins!");
                else if(winner=='o')
                    pop("2nd Player Wins!");
                else if(draw==9)
                    pop("Match Draw");
            }
        });
        b7.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b7.getText().equals("")) {
                        if (cross) {
                            b7.setText("X");
                            check(6,'x');
                            ai('o','x');
                            cross = false;
                        } else {
                            b7.setText("O");
                            check(6,'o');
                            ai('x','o');
                            cross = true;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner=='x')
                    pop("1st Player Wins!");
                else if(winner=='o')
                    pop("2nd Player Wins!");
                else if(draw==9)
                    pop("Match Draw");
            }
        });
        b8.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b8.getText().equals("")) {
                        if (cross) {
                            b8.setText("X");
                            check(7,'x');
                            ai('o','x');
                            cross = false;
                        } else {
                            b8.setText("O");
                            check(7,'o');
                            ai('x','o');
                            cross = true;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner=='x')
                    pop("1st Player Wins!");
                else if(winner=='o')
                    pop("2nd Player Wins!");
                else if(draw==9)
                    pop("Match Draw");
            }
        });
        b9.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b9.getText().equals("")) {
                        if (cross) {
                            b9.setText("X");
                            check(8,'x');
                            ai('o','x');
                            cross = false;
                        } else {
                            b9.setText("O");
                            check(8,'o');
                            ai('x','o');
                            cross = true;
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner=='x')
                    pop("1st Player Wins!");
                else if(winner=='o')
                    pop("2nd Player Wins!");
                else if(draw==9)
                    pop("Match Draw");
            }
        });
        //Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem Item = menu.findItem(R.id.ai_switch);
        // set your desired icon here based on a flag if you like
        if(f)
            Item.setIcon(getResources().getDrawable(R.drawable.android_robot_green));
        else
            Item.setIcon(getResources().getDrawable(R.drawable.android_robot_white));
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public void onBackPressed() {
        if(winner!='x'&&winner!='o'&&draw>0&&draw<9) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Do you want to end this game and go to home?");
            //builder.setMessage("Do you want to save this? ");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent i = new Intent(getApplicationContext(), home.class);
                    finish();
                    startActivity(i);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            builder.show();
        }else {
            Intent i = new Intent(getApplicationContext(),home.class);
            finish();
            startActivity(i);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ai_switch:
                // set your desired icon here based on a flag if you like
                if(f)
                {
                    item.setIcon(getResources().getDrawable(R.drawable.android_robot_white));
                    f=false;
                }else {
                    item.setIcon(getResources().getDrawable(R.drawable.android_robot_green));
                    f=true;
                    if(cross)
                        ai('o','x');
                    else
                        ai('x','o');
                }
                //Toast.makeText(getApplicationContext(),"cross="+cross,Toast.LENGTH_LONG).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
