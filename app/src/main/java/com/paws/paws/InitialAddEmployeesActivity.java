package com.paws.paws;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class InitialAddEmployeesActivity extends AppCompatActivity {

    List<EmployeeData> data; // The employees
    EditEmployeeAdapter adapter; //The adapter for the employee list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_add_employees_page);

        data = fill_with_data();

        RecyclerView recyclerView = findViewById(R.id.initial_add_employee_list_recycler);
        adapter = new EditEmployeeAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton add_employee_button = findViewById(R.id.initial_add_employee_button_id);
        add_employee_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(0, new EmployeeData());
                adapter.notifyDataSetChanged();
            }
        });

        final Button next_btn = findViewById(R.id.initial_add_employee_next_btn);
        if (next_btn == null) {
            Log.i("InitialAddEmployees", "next_btn is null");
        }
        next_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchActivity1= new Intent(InitialAddEmployeesActivity.this,ManageEmployeesActivity.class);
                startActivity(launchActivity1);
            }
        });

        final Button prev_btn = findViewById(R.id.initial_add_employee_prev_btn);
        prev_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchActivity1= new Intent(InitialAddEmployeesActivity.this,MainActivity.class);
                startActivity(launchActivity1);
            }
        });
    }

    public List<EmployeeData> fill_with_data() {

        List<EmployeeData> data = new ArrayList<>();

        data.add(new EmployeeData("בטמן", "0546121212", "bat@gmail.com", R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("סופה", "0540056574", "storm@gmail.com", R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("קפטן אמריקה", "05467000000","cap@gmail.com", R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("ג'קי צ'אן", "05411111777", "chan@gmail.com",R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("דירק גנטלי", "0540726574", "hollistic_agency@gmail.com",R.drawable.icons8_monkey_26));
        data.add(new EmployeeData("אליס פלאות", "0540756574", "alice@gmail.com",R.drawable.icons8_monkey_26));

        return data;
    }

}
