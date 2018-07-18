package com.akash.skyhigh.tictacto;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class tictack_ai extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,replay,home;
    boolean c1,c;
    int draw=0,lcp,lup,scp,sup,st,level;
    int blue= Color.parseColor("#3f51b5"),dpbl=Color.parseColor("#ffffff");
    int white= Color.parseColor("#ffffff"),deep_grey=Color.parseColor("#bbbbbb");
    char a[][]=new char[3][3],winner,comp,user;
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
        lup=n+1;
        draw++;
        if(draw<=2) {
            sup = lup;
            if(st<1)
                st=sup;
        }
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
    /*
    *                   COMPUTER PART
    *               COMPUTER PART
    *           COMPUTER PART
    *       COMPUTER PART
    *   COMPUTER PART
    * COMPUTER PART
    * */
    public void computer_set(int i,char ch)
    {
        String s="";s+=ch;s.toUpperCase();
        if(i==1)
        {
            b1.setBackgroundColor(deep_grey);
            b1.setText(s);
        }
        if(i==2)
        {
            b2.setBackgroundColor(deep_grey);
            b2.setText(s);
        }
        if(i==3)
        {
            b3.setBackgroundColor(deep_grey);
            b3.setText(s);
        }
        if(i==4)
        {
            b4.setBackgroundColor(deep_grey);
            b4.setText(s);
        }
        if(i==5)
        {
            b5.setBackgroundColor(deep_grey);
            b5.setText(s);
        }
        if(i==6)
        {
            b6.setBackgroundColor(deep_grey);
            b6.setText(s);
        }
        if(i==7)
        {
            b7.setBackgroundColor(deep_grey);
            b7.setText(s);
        }
        if(i==8)
        {
            b8.setBackgroundColor(deep_grey);
            b8.setText(s);
        }
        if(i==9)
        {
            b9.setBackgroundColor(deep_grey);
            b9.setText(s);
        }
    }
    public boolean computer_win_block(char v,char w) {
         c = false; c1 = false;
        int i,j=0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++)
                if (a[i][j] == '\0') {
                    //win part
                    //row wise check
                    if (a[i][(j + 1) % 3] == v && a[i][(j + 1) % 3] == a[i][(j + 2) % 3]) {
                        a[i][j] = v;
                        winner=v;
                        computer_set(i*3+j+1,v);
                        lightup(i*3+j+1); lightup(i*3+(j + 1) % 3+1);lightup(i*3+(j + 2) % 3+1);
                        return true;
                    }
                    //column wise check
                    else if (a[(i + 1) % 3][j] == v && a[(i + 1) % 3][j] == a[(i + 2) % 3][j]) {
                        a[i][j] = v;
                        winner=v;
                        computer_set(i*3+j+1,v);
                        lightup(i*3+j+1);lightup(((i + 1) % 3)*3+j+1);lightup(((i + 2) % 3)*3+j+1);
                        return true;
                    }
                    //diagonal wise check
                    else if (i == j) {
                        if (a[(i + 1) % 3][(j + 1) % 3] == v && a[(i + 1) % 3][(j + 1) % 3] == a[(i + 2) % 3][(j + 2) % 3]) {
                            a[i][j] = v;
                            winner=v;
                            computer_set(i*3+j+1,v);
                            lightup(1);lightup(5);lightup(9);
                            return true;
                        }
                        if (i == 1 && j == 1 && a[2][0] == v && a[2][0] == a[0][2]) {
                            a[i][j] = v;
                            winner=v;
                            computer_set(i*3+j+1,v);
                            lightup(3);lightup(5);lightup(7);
                            return true;
                        }
                    } else if ((i == 2 && j == 0) && a[1][1] == v && a[1][1] == a[0][2]) {
                        a[i][j] = v;
                        winner=v;
                        computer_set(i*3+j+1,v);
                        lightup(3);lightup(5);lightup(7);
                        return true;
                    } else if (i == 0 && j == 2 && a[2][0] == v && a[2][0] == a[1][1]) {
                        a[i][j] = v;
                        winner=v;
                        computer_set(i*3+j+1,v);
                        lightup(3);lightup(5);lightup(7);
                        return true;
                    }
                }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++)
                if (a[i][j] == '\0') {
                    //block part
                    //row wise check
                    if (a[i][(j + 1) % 3] == w && a[i][(j + 1) % 3] == a[i][(j + 2) % 3])
                    {
                        c1=true;
                        break;
                    }
                        //column wise check
                    else if (a[(i + 1) % 3][j] == w && a[(i + 1) % 3][j] == a[(i + 2) % 3][j])
                    {
                        c1=true;
                        break;
                    }
                        //diagonal wise check
                    else if (i == j)
                    {
                        //11 22 00
                        if (a[(i + 1) % 3][(j + 1) % 3] == w && a[(i + 1) % 3][(j + 1) % 3] == a[(i + 2) % 3][(j + 2) % 3])
                        {
                            c1=true;
                            break;
                        }
                        // 20 11 02
                        if (i == 1 && j == 1 && a[2][0] == w && a[2][0] == a[0][2])
                        {
                            c1=true;
                            break;
                        }
                    }
                    else if ((i == 2 && j == 0) && a[1][1] == w && a[1][1] == a[0][2])
                    {
                        c1=true;
                        break;
                    }
                    else if (i == 0 && j == 2 && a[2][0] == w && a[2][0] == a[1][1])
                    {
                        c1=true;
                        break;
                    }
                }
            if(c1) {
                a[i][j] = v;
                computer_set(i*3+j+1,v);
                return true;
            }
        }

        return false;
    }

    public  boolean two_empty_squares(char v, char w)
    {
         int i,j=0;
        for (i = 0; i < 3; i+=2) {
            for (j = 0; j < 3; j+=2) {
                if (a[i][j] == v) {
                    //row wise check
                    if (a[i][(j + 1) % 3] == w && a[i][(j + 1) % 3] == a[i][(j + 2) % 3]) {
                        if(j==2)
                            j = (j + 1) % 3;
                        else
                            j = (j + 2) % 3;
                        a[i][j] = comp;
                        lcp = i * 3 + j + 1;
                        return true;
                    }
                    //column wise check
                    else if (a[(i + 1) % 3][j] == w && a[(i + 1) % 3][j] == a[(i + 2) % 3][j]) {
                        if(i==2)
                            i = (i + 1) % 3;
                        else
                            i = (i + 2) % 3;
                        a[i][j] = comp;
                        lcp = i * 3 + j + 1;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void side_game()
    {
        int i=0,j=0;
       // Toast.makeText(getApplicationContext(), "in side game", Toast.LENGTH_SHORT).show();
        //give comp val to opposite side of user val
        if(draw==2&&level>1)
        {
            //Toast.makeText(getApplicationContext(), "if 1", Toast.LENGTH_SHORT).show();
            if(sup==2||sup==8)
                lcp=sup+1;
            else
                lcp=sup+3;
            a[(lcp - 1) / 3][(lcp - 1) % 3] = comp;
            computer_set(lcp, comp);
            return;
        }
        else if(draw==3&&level>1)
        {
            //Toast.makeText(getApplicationContext(), "if 2", Toast.LENGTH_SHORT).show();
            if(lcp==4||lcp==6)
            {
                if((lup-1)/3==(lcp-1)/3)
                {
                    i = (lup - 1) / 3 + 1;
                    j= (lup-1)%3;
                }
                else if((lup-1)%3==(lcp-1)%3)
                {
                    i = (lup - 1) / 3;
                    if(lcp==4)
                        j=(lcp-1)%3+2;
                    else
                        j=(lcp-1)%3-2;
                }
                else {
                    i = (lup - 1) / 3;
                    j=(lcp-1)%3;
                }
            }
            else if(lcp==2||lcp==8)
            {
                if((lup-1)%3==(lcp-1)%3)
                {
                    i = (lup - 1) / 3;
                    j = (lup - 1) % 3 + 1;
                }
                else if((lup-1)/3==(lcp-1)/3)
                {
                    if(lcp==2)
                        i=((lcp - 1) / 3 +2);
                    else
                        i=((lcp - 1) / 3 -2);
                    j=(lup - 1) % 3;
                }
                else {
                    i = (lcp - 1) / 3;
                    j = (lup - 1) % 3;
                }
            }
            a[i][j] = comp;
            lcp = i * 3 + j + 1;
            computer_set(lcp, comp);
            return;
        }
        else if(draw==4&&level>2)
        {
            //Toast.makeText(getApplicationContext(), "if 3", Toast.LENGTH_SHORT).show();
            if(sup==2||sup==8) {
                if ((lup - 1) / 3 == (lcp - 1) / 3)
                    lcp = 6;
                else if(Math.abs((lup - 1) / 3 -(lcp - 1) / 3)==1&&(lup - 1) % 3 !=(lcp - 1) % 3){
                    if (lcp == 3)
                        lcp = 9;
                    else
                        lcp = 3;
                }
                else lcp=5;
                }
            else{
                if ((lup - 1) % 3 == (lcp - 1) % 3)
                    lcp = 8;
                else if(Math.abs((lup - 1) % 3 -(lcp - 1) % 3)==1&&(lup - 1) / 3 !=(lcp - 1) / 3) {
                    if (lcp == 7)
                        lcp = 9;
                    else
                        lcp = 7;
                }
                else lcp=5;
            }
            a[(lcp - 1) / 3][(lcp - 1) % 3] = comp;
            computer_set(lcp, comp);
            return;

        }
        //select connection block between two comp values
        else if(draw==5&&level>2)
        {
            //Toast.makeText(getApplicationContext(), "if 4", Toast.LENGTH_SHORT).show();
            if( connection_point(scp,lcp))
               return;
           else if(connection_point(sup,lup))
               return;
        }
        //Toast.makeText(getApplicationContext(), "if 5", Toast.LENGTH_SHORT).show();
        for (i=0; i < 3; i++) {
            for (j=0; j < 3; j++)
                if (a[i][j] == '\0') {
                    a[i][j] = comp;
                    lcp = i * 3 + j + 1;
                    computer_set(lcp, comp);
                    return;
                }
        }

    }

    private boolean connection_point(int s, int l) {
        //Toast.makeText(getApplicationContext(), "in connection point", Toast.LENGTH_SHORT).show();
        int i = (s - 1) / 3;
        int j = (s - 1) % 3;
        int x[]=new int[4],y[]=new int[5];
        if(a[i][(j+1)%3]=='\0'&&a[i][(j + 2) % 3] == '\0')
        {
            x[0]=i * 3 + (j+1)%3 + 1;
            x[1]=i * 3 + (j+2)%3 + 1;
        }
        if(a[(i+1)%3][j]=='\0'&&a[(i + 2) % 3][j] == '\0')
        {
            x[2]=(i + 1) % 3 * 3 + j + 1;
            x[3]=(i + 2) % 3 * 3 + j + 1;
        }
        i = (l - 1) / 3;
        j = (l - 1) % 3;
        if(a[i][(j+1)%3]=='\0'&&a[i][(j + 2) % 3] == '\0')
        {
            y[0]=i * 3 + (j+1)%3 + 1;
            y[1]=i * 3 + (j+2)%3 + 1;
        }
        if(a[(i+1)%3][j]=='\0'&&a[(i + 2) % 3][j] == '\0')
        {
            y[2]=(i + 1) % 3 * 3 + j + 1;
            y[3]=(i + 2) % 3 * 3 + j + 1;
        }
        //Toast.makeText(getApplicationContext(), x[0]+" "+x[1]+" "+x[2]+" "+x[3], Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), y[0]+" "+y[1]+" "+y[2]+" "+y[3]+" "+y[4], Toast.LENGTH_LONG).show();
        boolean five=false;
        for (i = 0; i <=3; i++) {
            for (j = 0; j < 5; j++)
                if(x[i]==y[j]&&x[i]>0)
                {
                    a[(x[i] - 1) / 3][(x[i] - 1) % 3] = comp;
                    lcp = x[i];
                    computer_set(lcp, comp);
                    return true;
                }else if(x[i]==5)
                    five=true;
        }
        if(a[1][1]=='\0'&&five)
        {
            a[1][1]=comp;
            lcp = 5;
            computer_set(lcp, comp);
            return true;
        }
        return false;
    }

    public void computer()
    {
        draw++;
        if(winner=='\0'&&!computer_win_block(comp,user))
        {

            //Toast.makeText(getApplicationContext(), "draw="+draw, Toast.LENGTH_SHORT).show();
           // Toast.makeText(getApplicationContext(),"st="+st+" scp="+scp+" sup="+sup, Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(), "lcp="+lcp+" lup="+lup, Toast.LENGTH_SHORT).show();
            if((st % 2) == 0)
                 side_game();
            //middle and corner game.
            else {
                //Toast.makeText(getApplicationContext(), "corner and middle", Toast.LENGTH_SHORT).show();
                if (level>1&&draw == 3 && (lup == 5 || lcp == 5)) {
                    //Toast.makeText(getApplicationContext(), "if 1", Toast.LENGTH_SHORT).show();
                    /*diagonal 2nd tackle
                   _| |(x)
                   _|x|_
                   o| |     */
                    if (lcp == 1 || lup == 1 && a[2][2] == '\0')
                        lcp = 9;
                    else if (lcp == 3 || lup == 3 && a[2][0] == '\0')
                        lcp = 7;
                    else if (lcp == 7 || lup == 7 && a[0][2] == '\0')
                        lcp = 3;
                    else if (lcp == 9 || lup == 9 && a[0][0] == '\0')
                        lcp = 1;
                    /*side 2nd tackle
                   _|o|(x)
                   _|x|_
                    | |     */
                    else if (lup == 4 || lup == 6 && a[(lcp + 2) / 3][(lcp + 2) % 3] == '\0')
                        lcp = lup + 3;
                    else lcp = lup + 1;

                    a[(lcp - 1) / 3][(lcp - 1) % 3] = comp;
                    computer_set(lcp, comp);
                    return;
                }
                /* for x|_|_
                       _| |_
                     (x)| |     */
                else if (two_empty_squares(comp, '\0'))
                {
                    //Toast.makeText(getApplicationContext(), "if 2", Toast.LENGTH_SHORT).show();
                    computer_set(lcp, comp);
                    return;
                }
                //empty middle fill up
                else if (a[1][1] == '\0') {
                    //Toast.makeText(getApplicationContext(), "if 3", Toast.LENGTH_SHORT).show();
                    a[1][1] = comp;
                    lcp = 5;
                    computer_set(lcp, comp);
                    return;
                }
                /* for x|(o)|_
                       _| o |_
                       _|___|x     */
                else if(draw==4&&level>1) {
                    if (a[1][1] == comp && ((a[0][0] == a[2][2] && a[0][0] == user) || (a[0][2] == a[2][0] && a[0][2] == user))) {
                        //  Toast.makeText(getApplicationContext(), "if 5", Toast.LENGTH_SHORT).show();
                        a[0][1] = comp;
                        lcp = 2;
                        computer_set(lcp, comp);
                        return;
                    }/* for x| |_
                            _|o|_
                          (o)|x|     */
                    else if(connection_point(sup,lup))
                        return;
                }
                //Toast.makeText(getApplicationContext(), "if 6", Toast.LENGTH_SHORT).show();
                for (int i=0; i < 3; i++)
                {
                    for (int j=0; j < 3; j++)
                    {

                        if (a[i][j] == '\0')
                        {
                            a[i][j] = comp;
                            lcp = i * 3 + j + 1;
                            computer_set(lcp, comp);
                            return;
                        }
                    }
                }
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictack);
        Bundle extras = getIntent().getExtras();  //used to share data b/w activities
        level = extras.getInt("lvl");
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
        Random r=new Random();
        int i=r.nextInt(2)+1;
        if(i==1)
        {
            comp='x';
            user='o';
            i=r.nextInt(9);
            a[i/3][i%3]='x';
            i++;
            /*try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }*/
            computer_set(i,'x');
            st=scp=lcp=i;
            draw++;
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Your turn first", Toast.LENGTH_SHORT).show();
            user='x';
            comp='o';
        }

        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw>0&&draw<9) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(tictack_ai.this);

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
        replay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(winner!='x'&&winner!='o'&&draw>0&&draw<9) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(tictack_ai.this);

                    //Setting message manually and performing action on button click
                    builder.setTitle("Do you want to end this game and start new game?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent i = new Intent(getApplicationContext(),tictack_ai.class);
                                    i.putExtra("lvl",level);
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
                    Intent i = new Intent(getApplicationContext(),tictack_ai.class);
                    i.putExtra("lvl",level);
                    finish();
                    startActivity(i);
                }

            }

        });
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b1.getText().equals("")) {
                        if (user=='x') {
                            b1.setText("X");
                            check(0,'x');
                            computer();
                        } else {
                            b1.setText("O");
                            check(0,'o');
                            computer();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner==comp)
                    pop("Computer Wins!");
                else if(winner==user)
                    pop("User Wins!");
                else if(draw>=9)
                    pop("Match Draw");
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b2.getText().equals("")) {
                        if (user=='x') {
                            b2.setText("X");
                            check(1,'x');
                            computer();
                        } else {
                            b2.setText("O");
                            check(1,'o');
                            computer();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner==comp)
                    pop("Computer Wins!");
                else if(winner==user)
                    pop("User Wins!");
                else if(draw>=9)
                    pop("Match Draw");
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b3.getText().equals("")) {
                        if (user=='x') {
                            b3.setText("X");
                            check(2,'x');
                            computer();
                        } else {
                            b3.setText("O");
                            check(2,'o');
                            computer();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner==comp)
                    pop("Computer Wins!");
                else if(winner==user)
                    pop("User Wins!");
                else if(draw>=9)
                    pop("Match Draw");
            }
        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b4.getText().equals("")) {
                        if (user=='x') {
                            b4.setText("X");
                            check(3,'x');
                            computer();
                        } else {
                            b4.setText("O");
                            check(3,'o');
                            computer();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner==comp)
                    pop("Computer Wins!");
                else if(winner==user)
                    pop("User Wins!");
                else if(draw>=9)
                    pop("Match Draw");
            }
        });
        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b5.getText().equals("")) {
                        if (user=='x') {
                            b5.setText("X");
                            check(4,'x');
                            computer();
                        } else {
                            b5.setText("O");
                            check(4,'o');
                            computer();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner==comp)
                    pop("Computer Wins!");
                else if(winner==user)
                    pop("User Wins!");
                else if(draw>=9)
                    pop("Match Draw");
            }
        });
        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b6.getText().equals("")) {
                        if (user=='x') {
                            b6.setText("X");
                            check(5,'x');
                            computer();
                        } else {
                            b6.setText("O");
                            check(5,'o');
                            computer();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner==comp)
                    pop("Computer Wins!");
                else if(winner==user)
                    pop("User Wins!");
                else if(draw>=9)
                    pop("Match Draw");
            }
        });
        b7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b7.getText().equals("")) {
                        if (user=='x') {
                            b7.setText("X");
                            check(6,'x');
                            computer();
                        } else {
                            b7.setText("O");
                            check(6,'o');
                            computer();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner==comp)
                    pop("Computer Wins!");
                else if(winner==user)
                    pop("User Wins!");
                else if(draw>=9)
                    pop("Match Draw");
            }
        });
        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b8.getText().equals("")) {
                        if (user=='x') {
                            b8.setText("X");
                            check(7,'x');
                            computer();
                        } else {
                            b8.setText("O");
                            check(7,'o');
                            computer();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner==comp)
                    pop("Computer Wins!");
                else if(winner==user)
                    pop("User Wins!");
                else if(draw>=9)
                    pop("Match Draw");
            }
        });
        b9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(winner!='x'&&winner!='o'&&draw<9)
                {
                    if (b9.getText().equals("")) {
                        if (user=='x') {
                            b9.setText("X");
                            check(8,'x');
                            computer();
                        } else {
                            b9.setText("O");
                            check(8,'o');
                            computer();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), "Already filled", Toast.LENGTH_SHORT).show();
                }
                if(winner==comp)
                    pop("Computer Wins!");
                else if(winner==user)
                    pop("User Wins!");
                else if(draw>=9)
                    pop("Match Draw");
            }
        });
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
}