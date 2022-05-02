package it.andrea.lonewolfcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FightActivity extends AppCompatActivity {

    private int lwEndurance;
    private int lwCombat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        Bundle ext = getIntent().getExtras();
        if (ext != null) {
            lwEndurance = ext.getInt(MainActivity.EXT_ENDURANCE);
            lwCombat = ext.getInt(MainActivity.EXT_COMBAT);
        }
        ((TextView)findViewById(R.id.textView)).setText(String.valueOf(lwEndurance) + " " + String.valueOf(lwCombat));
    }
}