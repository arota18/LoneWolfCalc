package it.andrea.lonewolfcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FightActivity extends TwoCounterActivity {

    private int lwEndurance, lwCombat, enEndurance, combatRateo;

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

    public void startFight(View v) {
        enEndurance = Integer.parseInt(etEndurance.getText().toString());
        int enCombat = Integer.parseInt(etCombat.getText().toString());
        if (enEndurance > 0 && enCombat > 0) {
            combatRateo = lwCombat - enCombat;
            ((TextView) findViewById(R.id.textView3)).setText(fullCombat());
        }
    }

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

    private String fullCombat() {
        return fullCombat("", 0);
    }

    private String fullCombat(String s, int i) {
        i++;
        final int roll = dice10();
        lwEndurance -= lwReceivedDmg(roll);
        enEndurance -= enReceivedDmg(roll);
        // todo: exit condition, just for testing
        if (lwEndurance < 1 || enEndurance < 1) return i + " round, " + s;
        return fullCombat(s, i);
    }

    private static int dice10() {
        // min + random*(max - min + 1)
        return (int) Math.floor(1 + Math.random() * 10);
    }

    private int lwReceivedDmg(int roll) {
        switch (roll) {
            case 0:
                return 0;
            case 1:
                if (combatRateo > 8) return 3;
                else if (combatRateo > 2) return 4;
                else if (combatRateo > -3) return 5;
                else if (combatRateo > -7) return 6;
                else if (combatRateo > -9) return 8;
                else return lwEndurance;
        }
        // todo: switch from LW table
        return -1;
    }

    private int enReceivedDmg(int roll) {
        // todo: switch from LW table
        return -1;
    }
}