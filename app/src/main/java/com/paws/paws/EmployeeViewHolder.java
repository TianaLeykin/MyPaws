package com.paws.paws;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView edit_name;
        TextView edit_phone;
        TextView edit_email;
        ImageView edit_employee_icon;

    EmployeeViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.editEmployeeCardView);
            edit_name = itemView.findViewById(R.id.edit_name);
            edit_phone = itemView.findViewById(R.id.edit_phone);
            edit_email = itemView.findViewById(R.id.edit_email);
            edit_employee_icon = itemView.findViewById(R.id.edit_employee_icon);
        }
    }
