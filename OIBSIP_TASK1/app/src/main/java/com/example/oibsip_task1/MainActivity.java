package com.example.oibsip_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputEditText, outputEditText;
    Spinner inputSpinner, outputSpinner;
    Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        outputEditText = findViewById(R.id.outputEditText);
        inputSpinner = findViewById(R.id.inputSpinner);
        outputSpinner = findViewById(R.id.outputSpinner);
        convertButton = findViewById(R.id.convertButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputSpinner.setAdapter(adapter);
        outputSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = inputEditText.getText().toString();
                if (TextUtils.isEmpty(inputString)) {
                    outputEditText.setText("Please enter a value.");
                } else {
                    double input = Double.parseDouble(inputString);
                    String inputUnit = inputSpinner.getSelectedItem().toString();
                    String outputUnit = outputSpinner.getSelectedItem().toString();
                    double output;
                    switch (inputUnit) {
                        case "Centimeters":
                            if (outputUnit.equals("Meters")) {
                                output = input / 100;
                                outputEditText.setText(String.format("%.2f meters", output));
                            } else if (outputUnit.equals("Millimeters")) {
                                output = input * 10;
                                outputEditText.setText(String.format("%.2f millimeters", output));
                            } else if (outputUnit.equals("Kilometers")) {
                                output = input / 100000;
                                outputEditText.setText(String.format("%.2f kilometers", output));
                            }
                            break;
                        case "Meters":
                            if (outputUnit.equals("Centimeters")) {
                                output = input * 100;
                                outputEditText.setText(String.format("%.2f centimeters", output));
                            } else if (outputUnit.equals("Millimeters")) {
                                output = input * 1000;
                                outputEditText.setText(String.format("%.2f millimeters", output));
                            } else if (outputUnit.equals("Kilometers")) {
                                output = input / 1000;
                                outputEditText.setText(String.format("%.2f kilometers", output));
                            }
                            break;
                        case "Millimeters":
                            if (outputUnit.equals("Centimeters")) {
                                output = input / 10;
                                outputEditText.setText(String.format("%.2f centimeters", output));
                            } else if (outputUnit.equals("Meters")) {
                                output = input / 1000;
                                outputEditText.setText(String.format("%.2f meters", output));
                            } else if (outputUnit.equals("Kilometers")) {
                                output = input / 1000000;
                                outputEditText.setText(String.format("%.2f kilometers", output));
                            }
                            break;
                        case "Kilometers":
                            if (outputUnit.equals("Centimeters")) {
                                output = input * 100000;
                                outputEditText.setText(String.format("%.2f centimeters", output));
                            } else if (outputUnit.equals("Millimeters")) {
                                output = input * 1000000;
                                outputEditText.setText(String.format("%.2f millimeters", output));
                            } else if (outputUnit.equals("Meters")) {
                                output = input * 1000;
                                outputEditText.setText(String.format("%.2f meters", output));
                            }
                            break;
                        case "Grams":
                            if (outputUnit.equals("Kilograms")) {
                                output = input / 1000;
                                outputEditText.setText(String.format("%.2f kilograms", output));
                            } else if (outputUnit.equals("Milligrams")) {
                                output = input * 1000;
                                outputEditText.setText(String.format("%.2f milligrams", output));
                            }
                            break;
                        case "Kilograms":
                            if (outputUnit.equals("Grams")) {
                                output = input * 1000;
                                outputEditText.setText(String.format("%.2f grams", output));
                            } else if (outputUnit.equals("Milligrams")) {
                                output = input * 1000000;
                                outputEditText.setText(String.format("%.2f milligrams", output));
                            }
                            break;
                        case "Milligrams":
                            if (outputUnit.equals("Grams")) {
                                output = input / 1000;
                                outputEditText.setText(String.format("%.2f grams", output));
                            } else if (outputUnit.equals("Kilograms")) {
                                output = input / 1000000;
                                outputEditText.setText(String.format("%.2f kilograms", output));
                            }
                            break;
                    }
                }
            }
        });
    }
}