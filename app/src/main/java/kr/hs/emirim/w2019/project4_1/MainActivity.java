package kr.hs.emirim.w2019.project4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlus = findViewById(R.id.btn1);
        Button btnMinus = findViewById(R.id.btn2);
        Button btnMulti = findViewById(R.id.btn3);
        Button btnDiv = findViewById(R.id.btn4);
        Button btnMod = findViewById(R.id.btn5);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult = findViewById(R.id.t1);

        btnPlus.setOnClickListener(btnListener);
        btnMinus.setOnClickListener(btnListener);
        btnMulti.setOnClickListener(btnListener);
        btnDiv.setOnClickListener(btnListener);
        btnMod.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strEdit1 = edit1.getText().toString();
            String strEdit2 = edit2.getText().toString();
            Log.v("***strEdit1", strEdit1);
            if(strEdit1.equals("") || strEdit2.equals("")){
                Toast.makeText(getApplicationContext(), "계산에 필요한 값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            double num1 = Double.parseDouble(strEdit1);
            double num2 = Double.parseDouble(strEdit2);
            double result = 0;
            switch (v.getId()){
                case R.id.btn1:
                    result = num1 + num2;
                    break;
                case R.id.btn2:
                    result = num1 - num2;
                    break;
                case R.id.btn3:
                    result = num1 * num2;
                    break;
                case R.id.btn4:
                    if(strEdit2.equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 나눗셈을 할 수 없어요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                    break;
                case R.id.btn5:
                    if(strEdit2.equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 나눗셈을 할 수 없어요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 % num2;
                    break;
            }
            textResult.setText(R.string.t1);
            textResult.append(String.format("%.2f", result) + "");
        }
    };

}