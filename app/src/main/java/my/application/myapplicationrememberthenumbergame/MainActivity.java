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
    private Button level_btn1;
    private Button level_btn2;
    private Button level_btn3;
    private int numberMAX;
    private int numberMIN;

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
        level_btn1 = findViewById(R.id.level_btn1);
        level_btn2 = findViewById(R.id.level_btn2);
        level_btn3 = findViewById(R.id.level_btn3);


        level_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberMAX = 1999;
                numberMIN = 1000;

            }
        });
        level_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberMAX = 19999;
                numberMIN = 10000;

            }
        });
        level_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberMAX = 199999;
                numberMIN = 100000;

            }
        });



        further_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                rInt = (int) ((Math.random() * ((numberMAX-numberMIN)+1))+numberMAX);
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