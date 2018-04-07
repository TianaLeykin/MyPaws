package com.paws.paws;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public class EditEmployeeAdapter extends RecyclerView.Adapter<EditEmployeeViewHolder> {

    List<EmployeeData> list = Collections.emptyList();
    Context context;

    public EditEmployeeAdapter(List<EmployeeData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public EditEmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_employee_data, parent, false);
        EditEmployeeViewHolder holder = new EditEmployeeViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(EditEmployeeViewHolder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.edit_name.setText(list.get(position).name);
        holder.edit_phone.setText(list.get(position).phone);
        holder.edit_email.setText(list.get(position).email);;
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
