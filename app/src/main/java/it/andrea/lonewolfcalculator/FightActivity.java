package it.andrea.lonewolfcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FightActivity extends TwoCounterActivity {

    private int lwEndurance, lwCombat;

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
        int enEndurance = Integer.parseInt(etEndurance.getText().toString());
        int enCombat = Integer.parseInt(etCombat.getText().toString());
        if (enEndurance > 0 && enCombat > 0) {
            ((TextView) findViewById(R.id.textView3)).setText(fullCombat(enEndurance, (lwCombat - enCombat)));
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

    private String fullCombat(int enEndurance, int delta) {
        String result = "";
        int i = 0;
        do {
            i++;
            final int rollValue = LWUtils.roll();
            int lwDmg = lwReceivedDmg(rollValue, delta);
            lwEndurance -= lwDmg;
            int enDmg = enReceivedDmg(rollValue, delta);
            enEndurance -= enDmg;
        } while (lwEndurance > 0 && enEndurance > 0);
        if (lwEndurance > 0) return "lw win"; //TODO: wip
        return "lw died";
    }

    private int lwReceivedDmg(int roll, int delta) {
        switch (roll) {
            case 0:
                return 0;
            case 1:
                if (delta > 8) return 3;
                else if (delta > 2) return 4;
                else if (delta > -3) return 5;
                else if (delta > -7) return 6;
                else if (delta > -9) return 8;
                else return lwEndurance;
        }
        // todo: switch from LW table
        return -1;
    }

    private int enReceivedDmg(int roll, int delta) {
        // todo: switch from LW table
        return -1;
    }
}