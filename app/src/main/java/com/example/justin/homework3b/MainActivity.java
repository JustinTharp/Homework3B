package com.example.justin.homework3b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button save;
    EditText name;
    EditText city;
    EditText state;
    EditText zip;
    String Message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=(Button) findViewById(R.id.SubmitBtn);
        name=(EditText) findViewById(R.id.TextBox1);
        city=(EditText) findViewById(R.id.TextBox2);
        state=(EditText) findViewById(R.id.TextBox3);
        zip=(EditText) findViewById(R.id.TextBox4);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Message= name.getText().toString() +  state.getText().toString() +
                        city.getText().toString() + zip.getText().toString();
                try
                {
                    FileOutputStream stream = openFileOutput("text.txt", MODE_WORLD_WRITEABLE);
                    OutputStreamWriter writer = new OutputStreamWriter(stream);
                    try
                    {
                        writer.write(Message);
                        writer.flush();
                        writer.close();
                        Toast.makeText(getBaseContext(),"Data Saved", Toast.LENGTH_LONG).show();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
