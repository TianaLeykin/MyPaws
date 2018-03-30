package com.paws.paws;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.choose_existing_branch_button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchActivity1= new Intent(MainActivity.this,InitialAddEmployeesActivity.class);
                startActivity(launchActivity1);
            }
        });

        final Button button2 = findViewById(R.id.create_new_branch_button_id);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    button2.setText("LALA");
                }
        });
    }
}
