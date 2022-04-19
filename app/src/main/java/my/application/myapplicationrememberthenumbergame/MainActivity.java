package my.application.myapplicationrememberthenumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView info;
    private EditText user_field;
    private Button main_btn;
    private TextView result_info;
    private int vvodInt;
    private int rInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.info);
        user_field = findViewById(R.id.user_field);
        main_btn = findViewById(R.id.main_btn);
        result_info = findViewById(R.id.result_info);

        rInt = (int) ((Math.random() * ((999-100)+1))+100);
        info.setText(Integer.toString(rInt));

        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vvodInt = Integer.parseInt(user_field.getText().toString());
                if(rInt==vvodInt) {
                    result_info.setText("Верно");
                }
                else {
                    result_info.setText("Неверно");
                }
            }
        });
    }
}