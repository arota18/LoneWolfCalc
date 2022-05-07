package it.andrea.lonewolfcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FightActivity extends TwoCounterActivity {

    private int lwEndurance, lwCombat, enEndurance;

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
        int enEndurance = -1, enCombat = -1;
        try {
            enEndurance = Integer.parseInt(etEndurance.getText().toString());
            enCombat = Integer.parseInt(etCombat.getText().toString());
            this.enEndurance = enEndurance;
            ((TextView) findViewById(R.id.textView3)).setText(fullCombat((lwCombat - enCombat)));
        } catch (Exception e) {
            e.printStackTrace();
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

    private String fullCombat(int combatRatio) {
        String result = "";
        int i = 0;
        do {
            i++;
            final int rollValue = LWUtils.roll();
            result += "(" + rollValue + ")";
//            int lwDmg = lwReceivedDmg(rollValue, combatRatio);
            int lwDmg = LWUtils.decodeDmg[rollValue][LWUtils.convertCombatRatio(combatRatio)][1];
            lwEndurance -= lwDmg;
//            int enDmg = enReceivedDmg(rollValue, combatRatio);
            int enDmg = LWUtils.decodeDmg[rollValue][LWUtils.convertCombatRatio(combatRatio)][0];
            enEndurance -= enDmg;
            result += enEndurance;
        } while (lwEndurance > 0 && enEndurance > 0);
        return result.concat(" lw end:").concat(String.valueOf(lwEndurance)).concat(" r:").concat(String.valueOf(i));
    }

//    private int lwReceivedDmg(int roll, int cr) {
//        switch (roll) {
//            case 1:
//                if (cr > 8) return 3;
//                if (cr > 2) return 4;
//                if (cr > -3) return 5;
//                if (cr > -7) return 6;
//                if (cr > -9) return 8;
//                return lwEndurance;
//            case 2:
//                if (cr > 10) return 2;
//                if (cr > 2) return 3;
//                if (cr > -1) return 4;
//                if (cr > -5) return 5;
//                if (cr > -7) return 6;
//                if (cr > -9) return 7;
//                if (cr > -11) return 8;
//                return lwEndurance;
//            case 3:
//                if (cr > 6) return 2;
//                if (cr > 0) return 3;
//                if (cr > -3) return 4;
//                if (cr > -7) return 5;
//                if (cr > -9) return 6;
//                if (cr > -11) return 7;
//                return 8;
//            case 4:
//                if (cr > 2) return 2;
//                if (cr > -1) return 3;
//                if (cr > -5) return 4;
//                if (cr > -7) return 5;
//                if (cr > -9) return 6;
//                if (cr > -11) return 7;
//                return 8;
//            case 5:
//                if (cr > 10) return 1;
//                if (cr > -1) return 2;
//                if (cr > -3) return 3;
//                if (cr > -7) return 4;
//                if (cr > -9) return 5;
//                if (cr > -11) return 6;
//                return 7;
//            case 6:
//                if (cr > 4) return 1;
//                if (cr > -3) return 2;
//                if (cr > -5) return 3;
//                if (cr > -7) return 4;
//                if (cr > -9) return 5;
//                return 6;
//            case 7:
//                if (cr > 4) return 0;
//                if (cr > -1) return 1;
//                if (cr > -5) return 2;
//                if (cr > -7) return 3;
//                if (cr > -9) return 4;
//                return 5;
//            case 8:
//                if (cr > -1) return 0;
//                if (cr > -5) return 1;
//                if (cr > -7) return 2;
//                if (cr > -9) return 3;
//                return 4;
//            case 9:
//                if (cr > -7) return 0;
//                if (cr > -9) return 2;
//                return 3;
//            default:
//                return 0;
//        }
//    }

//    private int enReceivedDmg(int roll, int cr) {
//        switch (roll) {
//            case 1:
//                if (cr > 10) return 9;
//                if (cr > 8) return 8;
//                if (cr > 6) return 7;
//                if (cr > 4) return 6;
//                if (cr > 2) return 5;
//                if (cr > 0) return 4;
//                if (cr > -1) return 3;
//                if (cr > -3) return 2;
//                if (cr > -5) return 1;
//                return 0;
//            case 2:
//                if (cr > 10) return 10;
//                if (cr > 8) return 9;
//                if (cr > 6) return 8;
//                if (cr > 4) return 7;
//                if (cr > 2) return 6;
//                if (cr > 0) return 5;
//                if (cr > -1) return 4;
//                if (cr > -3) return 3;
//                if (cr > -5) return 2;
//                if (cr > -7) return 1;
//                return 0;
//            case 3:
//                if (cr > 10) return 11;
//                if (cr > 8) return 10;
//                if (cr > 6) return 9;
//                if (cr > 4) return 8;
//                if (cr > 2) return 7;
//                if (cr > 0) return 6;
//                if (cr > -1) return 5;
//                if (cr > -3) return 4;
//                if (cr > -5) return 3;
//                if (cr > -7) return 2;
//                if (cr > -9) return 1;
//                return 0;
//            case 4:
//                if (cr > 10) return 12;
//                if (cr > 8) return 11;
//                if (cr > 6) return 10;
//                if (cr > 4) return 9;
//                if (cr > 2) return 8;
//                if (cr > 0) return 7;
//                if (cr > -1) return 6;
//                if (cr > -3) return 5;
//                if (cr > -5) return 4;
//                if (cr > -7) return 3;
//                if (cr > -9) return 2;
//                if (cr > -11) return 1;
//                return 0;
//            case 5:
//                if (cr > 10) return 14;
//                if (cr > 8) return 12;
//                if (cr > 6) return 11;
//                if (cr > 4) return 10;
//                if (cr > 2) return 9;
//                if (cr > 0) return 8;
//                if (cr > -1) return 7;
//                if (cr > -3) return 6;
//                if (cr > -5) return 5;
//                if (cr > -7) return 4;
//                if (cr > -9) return 3;
//                if (cr > -11) return 2;
//                return 1;
//            case 6:
//                if (cr > 10) return 16;
//                if (cr > 8) return 14;
//                if (cr > 6) return 12;
//                if (cr > 4) return 11;
//                if (cr > 2) return 10;
//                if (cr > 0) return 9;
//                if (cr > -1) return 8;
//                if (cr > -3) return 7;
//                if (cr > -5) return 6;
//                if (cr > -7) return 5;
//                if (cr > -9) return 4;
//                if (cr > -11) return 3;
//                return 2;
//            case 7:
//                if (cr > 10) return 18;
//                if (cr > 8) return 16;
//                if (cr > 6) return 14;
//                if (cr > 4) return 12;
//                if (cr > 2) return 11;
//                if (cr > 0) return 10;
//                if (cr > -1) return 9;
//                if (cr > -3) return 8;
//                if (cr > -5) return 7;
//                if (cr > -7) return 6;
//                if (cr > -9) return 5;
//                if (cr > -11) return 4;
//                return 3;
//            case 8:
//                if (cr > 10) return enEndurance;
//                if (cr > 8) return 18;
//                if (cr > 6) return 16;
//                if (cr > 4) return 14;
//                if (cr > 2) return 12;
//                if (cr > 0) return 11;
//                if (cr > -1) return 10;
//                if (cr > -3) return 9;
//                if (cr > -5) return 8;
//                if (cr > -7) return 7;
//                if (cr > -9) return 6;
//                if (cr > -11) return 5;
//                return 4;
//            case 9:
//                if (cr > 8) return enEndurance;
//                if (cr > 6) return 18;
//                if (cr > 4) return 16;
//                if (cr > 2) return 14;
//                if (cr > 0) return 12;
//                if (cr > -1) return 11;
//                if (cr > -3) return 10;
//                if (cr > -5) return 9;
//                if (cr > -7) return 8;
//                if (cr > -9) return 7;
//                if (cr > -11) return 6;
//                return 5;
//            default:
//                if (cr > 6) return enEndurance;
//                if (cr > 4) return 18;
//                if (cr > 2) return 16;
//                if (cr > 0) return 14;
//                if (cr > -1) return 12;
//                if (cr > -3) return 11;
//                if (cr > -5) return 10;
//                if (cr > -7) return 9;
//                if (cr > -9) return 8;
//                if (cr > -11) return 7;
//                return 6;
//        }
//    }
}