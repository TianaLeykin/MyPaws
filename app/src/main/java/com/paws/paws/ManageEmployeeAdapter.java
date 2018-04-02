package com.paws.paws;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public class ManageEmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    List<EmployeeData> list = Collections.emptyList();
    Context context;

    public ManageEmployeeAdapter(List<EmployeeData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_employees_page, parent, false);
        if (v == null) {
            Log.i("ManageEmployeeAdapter", "view is null");
        }
        EmployeeViewHolder holder = new EmployeeViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.name.setText(list.get(position).name);
        holder.phone.setText(list.get(position).phone);
        holder.email.setText(list.get(position).email);
        holder.employee_icon.setImageResource(list.get(position).employee_icon);

        //animate(holder);

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, EmployeeData data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(EmployeeData data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }
}
