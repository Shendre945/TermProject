package com.example.bv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrencyConverterActivity extends AppCompatActivity {

    private EditText usdEditText, intEditText;
    Button convertButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        usdEditText = findViewById(R.id.editTextUSD);
        intEditText = findViewById(R.id.editTextINR);
        convertButton = findViewById(R.id.button);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUSDToINR();
            }
        });
    }

    private void convertUSDToINR() {
        try {
            // Get the amount in USD from the EditText
            double usdAmount = Double.parseDouble(usdEditText.getText().toString());

            // Assuming a fixed exchange rate for this example
            double exchangeRate = 83; // Replace with actual exchange rate

            // Perform the conversion
            double inrAmount = usdAmount * exchangeRate;
            // Display the result in the TextView
            resultTextView.setText("Converted amount: " + inrAmount + "INR");
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input. Please enter a valid number.");
        }
    }
}
