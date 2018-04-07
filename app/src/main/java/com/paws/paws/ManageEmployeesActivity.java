package com.paws.paws;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class ManageEmployeesActivity extends AppCompatActivity {

    private Context mContext;
    private RelativeLayout mRelativeLayout;
    private FloatingActionButton addEmployeeButton;
    private PopupWindow mPopupWindow;

    int WRAP_CONTENT = -2;
    int MATCH_PARENT = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_employees_page);
        mContext = getApplicationContext();
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

        mRelativeLayout = (RelativeLayout) findViewById(R.id.manage_employees_page_rl_id);

        addEmployeeButton = findViewById(R.id.add_employee_button_id);

        // Set a click listener for the text view
        addEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize a new instance of LayoutInflater service
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                // Inflate the custom layout/view
                View customView = inflater.inflate(R.layout.edit_employee_pop_up,null);

                /*
                    public PopupWindow (View contentView, int width, int height)
                        Create a new non focusable popup window which can display the contentView.
                        The dimension of the window must be passed to this constructor.

                        The popup does not provide any background. This should be handled by
                        the content view.

                    Parameters
                        contentView : the popup's content
                        width : the popup's width
                        height : the popup's height
                */
                // Initialize a new instance of popup window
                mPopupWindow = new PopupWindow(customView,MATCH_PARENT,WRAP_CONTENT);

                // Set an elevation value for popup window
                // Call requires API level 21
                if(Build.VERSION.SDK_INT>=21){
                    mPopupWindow.setElevation(5.0f);
                }

                // Tell buttons to stop hiding
                ImageButton deleteButton = customView.findViewById(R.id.add_employee_pop_up_delete_btn_id);
                deleteButton.bringToFront();

                Button saveButton = customView.findViewById(R.id.add_employee_pop_up_save_btn_id);
                saveButton.bringToFront();

                // Get a reference for the custom view close button
                FloatingActionButton closeButton = customView.findViewById(R.id.add_employee_pop_up_cancel_btn_id);
                closeButton.bringToFront();
                // Set a click listener for the popup window close button
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });

                /*
                    public void showAtLocation (View parent, int gravity, int x, int y)
                        Display the content view in a popup window at the specified location. If the
                        popup window cannot fit on screen, it will be clipped.
                        Learn WindowManager.LayoutParams for more information on how gravity and the x
                        and y parameters are related. Specifying a gravity of NO_GRAVITY is similar
                        to specifying Gravity.LEFT | Gravity.TOP.

                    Parameters
                        parent : a parent view to get the getWindowToken() token from
                        gravity : the gravity which controls the placement of the popup window
                        x : the popup's x location offset
                        y : the popup's y location offset
                */
                // Finally, show the popup window at the center location of root relative layout
                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
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
