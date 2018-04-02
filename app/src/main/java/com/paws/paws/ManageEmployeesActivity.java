package com.paws.paws;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ManageEmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_employees_page);

        List<EmployeeData> data = fill_with_data();

        RecyclerView recyclerView = findViewById(R.id.manage_employee_list_recycler);
        ManageEmployeeAdapter adapter = new ManageEmployeeAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final Button prev_btn = findViewById(R.id.manage_employees_prev_btn);
        prev_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchActivity1= new Intent(ManageEmployeesActivity.this,InitialAddEmployeesActivity.class);
                startActivity(launchActivity1);
            }
        });
    }

    public List<EmployeeData> fill_with_data() {

        List<EmployeeData> data = new ArrayList<>();

        data.add(new EmployeeData("Batman", "0546121212", "bat@gmail.com", R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("Storm", "0546006574", "storm@gmail.com", R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("Captain America", "0546700000","cap@gmail.com", R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("Jacky Chan", "0541111177", "chan@gmail.com",R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("Dirk Gently", "0546756572", "hollistic_agency@gmail.com",R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("Alice in Wonderland", "0546756574", "alice@gmail.com",R.drawable.icons8_monkey_26));

        return data;
    }

}
