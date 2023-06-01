package sg.edu.rp.c346.id22045554.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> alTasks;
    ListView lvTask;
    EditText etTask;
    Button btnAdd;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTask = findViewById(R.id.listTask);
        etTask = findViewById(R.id.editTextTask);
        btnAdd =findViewById(R.id.buttonAdd);
        btnClear =findViewById(R.id.buttonClear);
        alTasks = new ArrayList<String>();

        ArrayAdapter aaTasks = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alTasks);
        lvTask.setAdapter(aaTasks);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = etTask.getText().toString();
                alTasks.add(task);
                aaTasks.notifyDataSetChanged();
                etTask.setText("");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etTask.getText().toString();
                aaTasks.clear();
            }
        });



    }
}