package edu.bu.ec500c1.tasterchallengeandroid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PasswordKeyboard extends Activity{

    private Button[] buttons;
    private TextView pinView;
    private int i;
    private String pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parental_pin_input);
        buttons=new Button[11];
        buttons[0]=(Button)findViewById(R.id.b_0);
        buttons[1]=(Button)findViewById(R.id.b_1);
        buttons[2]=(Button)findViewById(R.id.b_2);
        buttons[3]=(Button)findViewById(R.id.b_3);
        buttons[4]=(Button)findViewById(R.id.b_4);
        buttons[5]=(Button)findViewById(R.id.b_5);
        buttons[6]=(Button)findViewById(R.id.b_6);
        buttons[7]=(Button)findViewById(R.id.b_7);
        buttons[8]=(Button)findViewById(R.id.b_8);
        buttons[9]=(Button)findViewById(R.id.b_9);
        buttons[10]=(Button)findViewById(R.id.b_c);

        pinView=(TextView)findViewById(R.id.pin_display);

        for(i=0;i<11;i++){
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(i<10)pinView.setText(pinView.getText()+String.valueOf(i));
                    if(pinView.getText().equals(pin)){}
                }
            });
        }
    }

}
