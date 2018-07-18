package com.akash.skyhigh.tictacto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class hardness extends AppCompatActivity {
    Button e,m,h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hardness);
        e=findViewById(R.id.button14);
        m=findViewById(R.id.button15);
        h=findViewById(R.id.button16);
        e.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),tictack_ai.class);
                i.putExtra("lvl", 1);
                finish();
                startActivity(i);
            }
        });
        m.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),tictack_ai.class);
                i.putExtra("lvl", 2);
                finish();
                startActivity(i);
            }
        });
        h.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),tictack_ai.class);
                i.putExtra("lvl", 3);
                finish();
                startActivity(i);
            }
        });
    }
    public void onBackPressed()
    {
        Intent i = new Intent(getApplicationContext(),home.class);
        finish();
        startActivity(i);
    }
}
