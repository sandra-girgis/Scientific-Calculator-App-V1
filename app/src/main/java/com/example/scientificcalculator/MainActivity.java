package com.example.scientificcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
    }
    private void updateText(String strToAdd){
        String oldstr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldstr.substring(0, cursorPos);
        String rightStr = oldstr.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBTN(View view){
        updateText(getResources().getString(R.string.zero));
    }
    public void oneBTN(View view){
        updateText(getResources().getString(R.string.one));
    }
    public void twoBTN(View view){
        updateText(getResources().getString(R.string.two));
    }
    public void threeBTN(View view){
        updateText(getResources().getString(R.string.three));
    }
    public void fourBTN(View view){
        updateText(getResources().getString(R.string.four));
    }
    public void fiveBTN(View view){
        updateText(getResources().getString(R.string.five));
    }
    public void sixBTN(View view){
        updateText(getResources().getString(R.string.six));
    }
    public void sevenBTN(View view){
        updateText(getResources().getString(R.string.seven));
    }
    public void eightBTN(View view){updateText(getResources().getString(R.string.eight)); }
    public void nineBTN(View view){
        updateText(getResources().getString(R.string.nine));
    }
    public void clearBTN(View view){
        display.setText("");
        previousCalculation.setText("");
    }

    public void divideBTN(View view){
        updateText(getResources().getString(R.string.divide));
    }
    public void multiplyBTN(View view){
        updateText(getResources().getString(R.string.multiply));
    }
    public void addBTN(View view){
        updateText(getResources().getString(R.string.add));
    }
    public void subtractBTN(View view){
        updateText(getResources().getString(R.string.subtract));
    }
    public void pointBTN(View view){
        updateText(getResources().getString(R.string.point));
    }
    public void openParenthesesBTN(View view){
        updateText(getResources().getString(R.string.openParentheses));
    }
    public void closeParenthesesBTN(View view){
        updateText(getResources().getString(R.string.closeParentheses));
    }
    public void equalsBTN(View view){
        String userExp = display.getText().toString();
        previousCalculation.setText(userExp);
        userExp = userExp.replaceAll(getResources().getString(R.string.divide),"/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiply),"*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos -1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void trigSinBTNPush(View view){
        updateText("sin(");
    }
    public void trigCosBTNPush(View view){
        updateText("cos(");
    }
    public void trigTanBTNPush(View view){
        updateText("tan(");
    }
    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }
    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }
    public void trigArcTanBTNPush(View view){
        updateText("arctan(");
    }
    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }
    public void logBTNPush(View view){
        updateText("log(");
    }
    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }
    public void absBTNPush(View view){
        updateText("abs(");
    }
    public void piBTNPush(View view){
        updateText("pi");
    }
    public void eBTNPush(View view){
        updateText("e");
    }
    public void radiansBTNPush(View view){
        updateText("rad(");
    }
    public void xPowerYBTNPush(View view){
        updateText("^(");
    }
    public void primeBTNPush(View view){
        updateText("ispr(");
    }
}