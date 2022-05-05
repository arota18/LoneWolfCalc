package it.andrea.lonewolfcalculator;

import android.os.Bundle;
import android.view.View;

public class FightActivity extends TwoCounterActivity {

    private int lwEndurance;
    private int lwCombat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        etEndurance = findViewById(R.id.txtEnemyEndurance);
        etCombat = findViewById(R.id.txtEnemyCombat);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            lwEndurance = extras.getInt(MainActivity.EXT_ENDURANCE);
            lwCombat = extras.getInt(MainActivity.EXT_COMBAT);
        }
    }

    // buttons handlings

    public void subEnemyEndurance(View v) {
        this.editTxtValue(v, 1);
    }

    public void addEnemyEndurance(View v) {
        this.editTxtValue(v, 2);
    }

    public void subEnemyCombat(View v) {
        this.editTxtValue(v, 3);
    }

    public void addEnemyCombat(View v) {
        this.editTxtValue(v, 4);
    }
}