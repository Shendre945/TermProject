package com.example.bv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CurrencyConverterActivity extends AppCompatActivity {

    private double conversionRate = 83;
    private double AmountEntered;
    private double convertedAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        final EditText weight = findViewById(R.id.tvAmount);
        final RadioButton USDToINR = findViewById(R.id.rbUSDToINR);
        final RadioButton INRToUSD = findViewById(R.id.rbINRToUSD);
        final TextView result = findViewById(R.id.tvResult);
        final Button convert = findViewById(R.id.btConvert);

        DecimalFormat tenth = new DecimalFormat("#.#");

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AmountEntered = Double.parseDouble(weight.getText().toString());
                if (USDToINR.isChecked()) {
                    // do the conversion
                    convertedAmount = AmountEntered * conversionRate;
                    result.setText(tenth.format(convertedAmount) + " Rupees");
                }
                else if (INRToUSD.isChecked()) {
                    // do the conversion
                    convertedAmount = AmountEntered / conversionRate;
                    result.setText(tenth.format(convertedAmount) + " Dollars");
                }
                else {
                    Toast.makeText(CurrencyConverterActivity.this,
                                    "Please select Currency to Convert",
                                    Toast.LENGTH_SHORT)
                            .show();
                }


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}
