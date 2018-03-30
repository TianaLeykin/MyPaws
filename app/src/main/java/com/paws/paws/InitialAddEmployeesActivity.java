package com.paws.paws;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InitialAddEmployeesActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_add_employee);

        List<EditEmployee> data = fill_with_data();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.initial_add_employee_list_recycler);
        EditEmployeeAdapter adapter = new EditEmployeeAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<EditEmployee> fill_with_data() {

        List<EditEmployee> data = new ArrayList<>();

        data.add(new EditEmployee("Batman", "05461212123", "bat@gmail.com", R.drawable.icons8_monkey_26));
        data.add(new EditEmployee("Storm", "0546778787877", "storm@gmail.com", R.drawable.icons8_monkey_26));
        data.add(new EditEmployee("Captain America", "05467000000","cap@gmail.com", R.drawable.icons8_monkey_26));
        data.add(new EditEmployee("Jacky Chan", "05411111777", "chan@gmail.com",R.drawable.icons8_monkey_26));
        data.add(new EditEmployee("Dirk Gently", "0546999977", "hollistic_agency@gmail.com",R.drawable.icons8_monkey_26));
        data.add(new EditEmployee("Alice in Wonderland", "0546756574574", "alice@gmail.com",R.drawable.icons8_monkey_26));

        return data;
    }

}
