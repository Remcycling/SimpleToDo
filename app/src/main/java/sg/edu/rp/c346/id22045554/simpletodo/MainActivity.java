package sg.edu.rp.c346.id22045554.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> alTasks;
    ListView lvTask;
    EditText etTask;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;
    Spinner spnChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTask = findViewById(R.id.listTask);
        etTask = findViewById(R.id.editTextTask);
        btnAdd =findViewById(R.id.buttonAdd);
        btnDelete =findViewById(R.id.buttonDelete);
        btnClear =findViewById(R.id.buttonClear);
        alTasks = new ArrayList<String>();
        spnChoice = findViewById(R.id.spinner);

        ArrayAdapter aaTasks = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alTasks);
        lvTask.setAdapter(aaTasks);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerItems, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnChoice.setAdapter(adapter);


        spnChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        parent.getItemAtPosition(position);
                        etTask.setHint("Type in a new task here");
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        break;
                    case 1:
                        parent.getItemAtPosition(position);
                        etTask.setHint("Type in the index of the task to be removed");
                        btnDelete.setEnabled(true);
                        btnAdd.setEnabled(false);


                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                etTask.setHint("Nothing selected");
            }
        });




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = etTask.getText().toString();
                alTasks.add(task);
                aaTasks.notifyDataSetChanged();
                etTask.setText("");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= etTask.getText().toString();
                int pos = Integer.parseInt(s)-1;
                alTasks.remove(pos);
                aaTasks.notifyDataSetChanged();
                etTask.setText("");
            }
        });



        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaTasks.clear();
            }
        });



    }
}