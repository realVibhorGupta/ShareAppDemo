package com.example.vibhor.shareapp1demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.edit_text_view);
        textView= (TextView) findViewById(R.id.text_view);
    }
    @SuppressLint("SetTextI18n")
    public  void onSaveData(View view)
    {
        File file = null;
        String text = editText.getText().toString();
        FileOutputStream fileOutputStream=null;


        try {
            file =getFilesDir();
            fileOutputStream=openFileOutput("vibh.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            textView.setTextColor(Color.CYAN);
            textView.setText(text +"\n written to \n " +  file.getAbsolutePath());

        } catch (IOException e) {
            textView.setTextColor(Color.RED);
            textView.setText(e.toString());

        }


    }
}
