package com.example.projectsrule;

import static android.widget.Toast.makeText;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button button_add, button_change, button_settings, button_more;
    EditText edit_weight;
    GridView grid_weight;
    TextView display_date;
    LineGraphSeries<DataPoint> graph_weight;
    private DatePickerDialog.OnDateSetListener date_set_listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set up graph parameters


        //initialize interface fields
        button_add = findViewById(R.id.addData);
        button_change = findViewById(R.id.edit_goal_button);
        button_settings = findViewById(R.id.settings_button);
        button_more = findViewById(R.id.more_button);
        edit_weight = findViewById(R.id.edit_weight);
        display_date = findViewById(R.id.display_date);
        //set up graph
        GraphView graph = findViewById(R.id.graph_weight);
        graph_weight = new LineGraphSeries<DataPoint>();
        float z = 0f;
        Cursor data = Database.getData();
        int rows = data.getCount();
        data.moveToNext();

        //initialize databases
        Database database = new Database(MainActivity.this);

        List<UserModel> allUserData = database.getEveryone();
        ArrayAdapter<UserModel> userArray = new ArrayAdapter<UserModel>(MainActivity.this, android.R.layout.simple_list_item_1, allUserData);
        grid_weight.setAdapter(userArray);

        //add graph data
        for (int i = 0; i < rows; i++) {
            data.moveToNext();
            String x = data.getString(2);
            String y = data.getString(3);
            z = Float.parseFloat(y);
            Date d = null;

            try {
                d = new SimpleDateFormat("mm/dd/yyyy").parse(x);
                graph_weight.appendData(new DataPoint(d, z), true, 25);
            }   catch (Exception e) {
                    e.printStackTrace();
                }
    };
        graph.addSeries(graph_weight);
        graph.getGridLabelRenderer().setNumVerticalLabels(30);
        graph.getGridLabelRenderer().setNumHorizontalLabels(30);
        graph.getGridLabelRenderer().setHumanRounding(false);



        //add record to database
        button_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                UserModel userModel;
                try{
                    userModel = new UserModel(-1, display_date.getText().toString(), parseInt(edit_weight.getText().toString()));
                    makeText(MainActivity.this, userModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    makeText(MainActivity.this, "Entry error", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel(-1, "ERROR", 0);
                }
                Database database = new Database(MainActivity.this);
                boolean success = database.addOne(userModel);
                makeText(MainActivity.this, "Added Record: " + success, Toast.LENGTH_SHORT).show();
                int newWeight = parseInt(edit_weight.getText().toString());
                int goalWeight = parseInt(GoalDatabase.edit_goal);

                if (newWeight <= goalWeight){
                    makeText(MainActivity.this, "Goal Weight reached!", Toast.LENGTH_SHORT).show();
                }
                else{
                    makeText(MainActivity.this, "Keep Trying!", Toast.LENGTH_SHORT).show();
                }

            }

        });

        //set date
        date_set_listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                month = month + 1;
                Log.d("Logging", "onDateSet: mm/dd/yyyy " + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                display_date.setText(date);
            }
        };
        //display date
        display_date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme, date_set_listener, year, month, day);
                dialog.show();
            }
        });

        //open sms settings - navigate to sms screen
        button_settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, SMS.class);
                startActivity(intent);
                makeText(MainActivity.this, "SMS Settings", Toast.LENGTH_SHORT).show();
            }

        });
        //open change goal weight screen
        button_change.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, UpdateGoal.class);
                startActivity(intent);
                makeText(MainActivity.this, "Update Goal", Toast.LENGTH_SHORT).show();
            }

        });

        button_more.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, WeightGrid.class);
                startActivity(intent);
                makeText(MainActivity.this, "See More", Toast.LENGTH_SHORT).show();
            }

        });


    }

    // fix mes: Check goal against current weight, add notification for reaching or surpassing goal,


}