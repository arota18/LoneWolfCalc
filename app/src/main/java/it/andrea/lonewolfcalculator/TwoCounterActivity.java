package it.andrea.lonewolfcalculator;

import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TwoCounterActivity extends AppCompatActivity {
    /**
     * view ref.
     */
    protected EditText etEndurance, etCombat;

    /**
     * protected method used to increase/decrease endurance and combat counter
     *
     * @param v    View
     * @param mode int value that represent which button has been pressed
     */
    protected void editTxtValue(View v, int mode) {
        EditText et;
        int val = -1;
        et = (mode < 3) ? etEndurance : etCombat;
        try {
            val = Integer.parseInt(et.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mode % 2 == 0)
            if (val == -1) val = 1;
            else val++;
        else if (val > 0) val--;
        if (val != -1) et.setText(String.valueOf(val));
    }
}
