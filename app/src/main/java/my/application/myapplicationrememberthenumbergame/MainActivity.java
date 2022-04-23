package my.application.myapplicationrememberthenumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
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
    private Button further_btn;
    private int seconds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.info);
        user_field = findViewById(R.id.user_field);
        main_btn = findViewById(R.id.main_btn);
        result_info = findViewById(R.id.result_info);
        further_btn = findViewById(R.id.further_btn);
        seconds = 2;


        further_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                rInt = (int) ((Math.random() * ((100000-1000)+1))+1000);
                info.setText(Integer.toString(rInt));

                CountDownTimer my_timer = new CountDownTimer(seconds*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        info.setText(Integer.toString(rInt));
                    }

                    @Override
                    public void onFinish() {
                        info.setText("");
                    }

                };
                my_timer.start();


            }
        });


        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vvodInt = Integer.parseInt(user_field.getText().toString());
                if(rInt==vvodInt) {
                    result_info.setText("Верно");
                    user_field.setText("");
                }
                else {
                    result_info.setText("Неверно");
                }
            }
        });
    }
}