package it.andrea.lonewolfcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends TwoCounterActivity {

    public static final String EXT_ENDURANCE = "it.andrea.lonewolfcalculator.EXT_ENDURANCE";
    public static final String EXT_COMBAT = "it.andrea.lonewolfcalculator.EXT_COMBAT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEndurance = findViewById(R.id.txtEndurance);
        etCombat = findViewById(R.id.txtCombat);
        // TODO:
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            etEndurance.setText(String.valueOf(extras.getInt(EXT_ENDURANCE)));
            etCombat.setText(String.valueOf(extras.getInt(MainActivity.EXT_COMBAT)));
        }
    }

    // buttons handlings

    public void toFight(View v) {
        try {
            int enduranceValue = Integer.parseInt(etEndurance.getText().toString());
            int combatValue = Integer.parseInt(etCombat.getText().toString());
            Intent intent = new Intent(this, FightActivity.class);
            intent.putExtra(EXT_ENDURANCE, enduranceValue);
            intent.putExtra(EXT_COMBAT, combatValue);
            startActivity(intent);
        } catch (Exception e) {
            // TODO: add error message, popup?
        }
    }

    public void subEndurance(View v) {
        this.editTxtValue(v, 1);
    }

    public void addEndurance(View v) {
        this.editTxtValue(v, 2);
    }

    public void subCombat(View v) {
        this.editTxtValue(v, 3);
    }

    public void addCombat(View v) {
        this.editTxtValue(v, 4);
    }
}