package br.com.cdsoft.fundictionary;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Button button1;
    private EditText editText1;
    private EditText editText2;

    private TextView textView1;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        Button button2 = findViewById(R.id.button2);
        textView1 = findViewById(R.id.textView3);
        textView1.setVisibility(View.GONE);

        button1.setOnClickListener(this::onClick);

        button2.setOnClickListener(v -> finish());
    }

    private void onClick(final View view) {
        if (editText1.getText().toString().equals("admin") &&
                editText2.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(),
                    "Redirecionando", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Inválida Credentiais", Toast.LENGTH_SHORT).show();

            textView1.setVisibility(View.VISIBLE);
//                    textView1.setBackgroundColor(Color.RED);
            counter--;
            textView1.setText(counter);

            if (counter == 0) {
                button1.setEnabled(false);
            }
        }
    }
}