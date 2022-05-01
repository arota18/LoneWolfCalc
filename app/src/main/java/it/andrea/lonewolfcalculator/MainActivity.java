package it.andrea.lonewolfcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addEndurance(View view) {
        this.editTxtNumber(view, false, true);
    }

    public void subEndurance(View view) {
        this.editTxtNumber(view, false, false);
    }

    public void addCombat(View view) {
        this.editTxtNumber(view, true, true);
    }

    public void subCombat(View view) {
        this.editTxtNumber(view, true, false);
    }

    // private Methods

    private void editTxtNumber(View view, boolean isEditCombat, boolean isAdd) {
        EditText et;
        if (isEditCombat)
            et = findViewById(R.id.txtCombat);
        else
            et = findViewById(R.id.txtEndurance);
        int val = -1;
        try {
            val = Integer.parseInt(et.getText().toString());
        } catch (Exception e) {
            if (isAdd)
                val = 0;
        }
        if (val != -1) {
            if (isAdd)
                val++;
            else
                val--;
            et.setText(String.valueOf(val));
        }
    }
}