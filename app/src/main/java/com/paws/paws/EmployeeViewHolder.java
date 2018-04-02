package com.paws.paws;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    CardView cv;
    TextView name;
    TextView phone;
    TextView email;
    ImageView employee_icon;

    EmployeeViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.employeeCardView);
            name = itemView.findViewById(R.id.employee_data_name);
            phone = itemView.findViewById(R.id.employee_data_phone);
            email = itemView.findViewById(R.id.employee_data_email);
            employee_icon = itemView.findViewById(R.id.employee_data_icon);
        }
    }
