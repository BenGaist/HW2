package com.example.hw2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            });




        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText edit = findViewById(R.id.edit);
        TextView text = findViewById(R.id.textView);

        int editTextColor = edit.getCurrentTextColor();
        int dullColor = (editTextColor & 0x00FFFFFF) | (0x80 << 24);//כדי שהיהלו צבע יפה
        text.setTextColor(dullColor);

        Button TxtChangeBtn = findViewById(R.id.TxtChangeBtn);
        TxtChangeBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                text.setTextColor(Color.BLACK);
                String inputText = edit.getText().toString().trim();
                Random random = new Random();
                int rn = random.nextInt(10);

                final String[] x = {
                        "yo, how are you %s",
                        "you're great %s",
                        "that's what you chose?, %s",
                        "AMAZING! %s",
                        "yes %s",
                        "%s  is a horrible thing",
                        "is %s your name?",
                        "oof that's tough %s",
                        "wow %s is a thing!",
                        "this: '%s' looks like this: (～￣▽￣)～"
                };


                if (inputText.isEmpty()) {
                    text.setText("Wow really? Not writing anything? That's lame");
                } else {

                    String response = x[rn];
                    text.setText(String.format(response,inputText));
                }
            }
        });

        Button ColorChangeBtn = findViewById(R.id.RandomColorBtn);
        ColorChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (text.getCurrentTextColor()== Color.BLACK)
                {
                text.setTextColor(Color.BLUE);
                }
                else if (text.getCurrentTextColor()== Color.BLUE)
                {
                    text.setTextColor(Color.RED);
                }
                else if (text.getCurrentTextColor()== Color.RED)
                {
                    text.setTextColor(Color.BLACK);
                }

            }
        });

  }

}