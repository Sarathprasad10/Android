package com.example.displayinfoapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // UI elements
    private TextView textViewDisplay;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEquals, buttonDecimal;

    // Variables to hold operands and operators
    private double operand1, operand2;
    private String currentOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        textViewDisplay = findViewById(R.id.textViewDisplay);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonDecimal = findViewById(R.id.buttonDecimal);

        // Log UI element initialization
        Log.d("MainActivity", "UI elements initialized");

        // Set initial values
        operand1 = Double.NaN;
        operand2 = Double.NaN;
        currentOperator = "";

        // Set click listeners for number buttons
        button0.setOnClickListener(v -> appendNumber("0"));
        button1.setOnClickListener(v -> appendNumber("1"));
        button2.setOnClickListener(v -> appendNumber("2"));
        button3.setOnClickListener(v -> appendNumber("3"));
        button4.setOnClickListener(v -> appendNumber("4"));
        button5.setOnClickListener(v -> appendNumber("5"));
        button6.setOnClickListener(v -> appendNumber("6"));
        button7.setOnClickListener(v -> appendNumber("7"));
        button8.setOnClickListener(v -> appendNumber("8"));
        button9.setOnClickListener(v -> appendNumber("9"));

        // Set click listeners for operator buttons
        buttonAdd.setOnClickListener(v -> setOperator("+"));
        buttonSubtract.setOnClickListener(v -> setOperator("-"));
        buttonMultiply.setOnClickListener(v -> setOperator("*"));
        buttonDivide.setOnClickListener(v -> setOperator("/"));
        buttonEquals.setOnClickListener(v -> performOperation());
        buttonDecimal.setOnClickListener(v -> appendDecimal());
    }

    // Method to append a number to the display
    private void appendNumber(String num) {
        String currentText = textViewDisplay.getText().toString();
        if (!currentText.equals("0")) {
            textViewDisplay.setText(currentText + num);
        } else {
            textViewDisplay.setText(num);
        }
    }

    // Method to append a decimal point to the display
    private void appendDecimal() {
        String currentText = textViewDisplay.getText().toString();
        if (!currentText.contains(".")) {
            textViewDisplay.setText(currentText + ".");
        }
    }

    // Method to set the current operator
    private void setOperator(String operator) {
        if (!textViewDisplay.getText().toString().isEmpty()) {
            operand1 = Double.parseDouble(textViewDisplay.getText().toString());
            currentOperator = operator;
            textViewDisplay.setText("");
        }
    }

    // Method to perform the arithmetic operation
    private void performOperation() {
        if (!Double.isNaN(operand1) && !textViewDisplay.getText().toString().isEmpty()) {
            operand2 = Double.parseDouble(textViewDisplay.getText().toString());
            double result = calculateResult();
            if (!Double.isNaN(result)) {
                textViewDisplay.setText(formatResult(result));
            }
            operand1 = result;
        }
    }

    // Method to calculate the result based on the operator
    private double calculateResult() {
        switch (currentOperator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    return Double.NaN; // Handle division by zero
                }
                return operand1 / operand2;
            default:
                return Double.NaN;
        }
    }

    // Method to format the result (remove unnecessary decimal places)
    private String formatResult(double result) {
        DecimalFormat df = new DecimalFormat("#.##########");
        return df.format(result);
    }
}
