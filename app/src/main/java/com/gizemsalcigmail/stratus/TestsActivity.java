package com.gizemsalcigmail.stratus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        Button sozcukteanlambtn=(Button)findViewById(R.id.button4);
        Button cumledeanlambtn=(Button)findViewById(R.id.button5);
        Button anlatimbicimbtn=(Button)findViewById(R.id.button6);
        Button paragrafbtn=(Button)findViewById(R.id.button7);
        Button anlatimbozukbtn=(Button)findViewById(R.id.button8);
        final Intent intent=new Intent(TestsActivity.this,Questions1Activity.class);

        sozcukteanlambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });



    }


}
