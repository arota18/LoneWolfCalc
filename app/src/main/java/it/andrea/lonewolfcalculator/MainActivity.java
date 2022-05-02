package it.andrea.lonewolfcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXT_ENDURANCE = "it.andrea.lonewolfcalculator.EXT_ENDURANCE";

    public static final String EXT_COMBAT = "it.andrea.lonewolfcalculator.EXT_COMBAT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void toFight(View v) {
        EditText etEndurance = findViewById(R.id.txtEndurance);
        EditText etCombat = findViewById(R.id.txtEndurance);
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

    // private Methods

    /**
     * private method for buttons handling
     *
     * @param v    View
     * @param mode int value that represent which button has been pressed
     */
    private void editTxtValue(View v, int mode) {
        EditText et;
        int val = -1;
        if (mode < 3) et = findViewById(R.id.txtEndurance);
        else et = findViewById(R.id.txtCombat);
        try {
            val = Integer.parseInt(et.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mode % 2 == 0)
            if (val == -1)
                val = 1;
            else
                val++;
        else if (val > 0)
            val--;
        if (val != -1)
            et.setText(String.valueOf(val));
    }
}