package edu.bu.ec500c1.tasterchallengeandroid;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.lang.String;
import android.content.Intent;



public class ParentalControl extends ActionBarActivity {

    String correctPin = "2832";
    private Button mResetPinButton;
    private EditText mPinNumber;
    private ImageButton mBackButton;
    private Button mEnterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parental_control);

        backButtonPressed();
        enterButtonPressed();


    }
    public void enterButtonPressed(){
        mEnterButton = (Button) findViewById(R.id.enter_button);
        mEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkPinNumber()) {
                    //pin number is right so go to parental control settings
                    Intent intent = new Intent(ParentalControl.this,ControlSettingsActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(ParentalControl.this, "incorrect, try again", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    public void backButtonPressed(){
        mBackButton = (ImageButton) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                onBackPressed();
            }
        });
    }
    public boolean checkPinNumber(){
        boolean pinCorrect;
        mPinNumber = (EditText) findViewById(R.id.pin_key);
        String value = mPinNumber.getText().toString().trim();

        if(correctPin.equals(value) ){
            pinCorrect =true;
        }
        else{
            pinCorrect =false;
        }
        return pinCorrect;
    }

    public void setPinButton(){
        mResetPinButton = (Button) findViewById(R.id.reset_button);
        mResetPinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(ParentalControl.this,R.string.reset_button, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parental_control, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
