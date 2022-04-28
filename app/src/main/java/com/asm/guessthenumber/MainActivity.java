package com.asm.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int tryNum=1;
    int randomRight=10;
    int random;
    int preRandom;

    public void randFunc(){
        int randomExtra=new Random().nextInt(randomRight);
        preRandom= new Random().nextInt(501);
        random=preRandom+randomExtra;
        TextView firstText= (TextView) findViewById(R.id.textOne);
        firstText.setText("");
        firstText.append("I am thinking of a number between"+preRandom+" and "+(randomRight+preRandom));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randFunc();

        TextView secondText=(TextView) findViewById(R.id.textTwo);
        secondText.setText("Can you guess it?");

        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(view -> {
            EditText guess= (EditText) findViewById(R.id.myNum);
            int myNum=Integer.parseInt(guess.getText().toString());
            if (random==myNum){
                Toast.makeText(MainActivity.this, "You are excellent in Guessing",
                        Toast.LENGTH_LONG).show();
                tryNum=1;
                randFunc();
            }
            else if(myNum<preRandom||myNum>(randomRight+preRandom)){
                Toast.makeText(MainActivity.this, "Error, Out of range! Tried "+tryNum+" times",
                        Toast.LENGTH_LONG).show();
                tryNum=tryNum+1;
            }
            else{
                if(myNum>random){
                Toast.makeText(MainActivity.this, "Go a bit lower, Bitte! Tried "+tryNum+" times",
                        Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, " Go a bit Higher, Bitte! Tried "+tryNum+" times",
                            Toast.LENGTH_LONG).show();
                }
                tryNum=tryNum+1;
            }
            guess.setText("");
        });

    }
}