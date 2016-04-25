package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display(quantity);
        displayPrice(quantity * 5);
    }

    /**
     * This method is called when the order button is clicked.
     * @param view
     */
    public void submitOrder(View view){
        //display(quantity);
        displayPrice(quantity * 5);
    }

    /**
     * This method is called when the increment button is clicked.
     * @param view
     */
    public void increment(View view){
        quantity += 1;
        display(quantity);
        //displayPrice(quantity * 5);
    }

    /**
     * This method is called when the decrement button is clicked.
     * @param view
     */
    public void decrement(View view){
        if(quantity > 1){
            quantity -= 1;
        }
        display(quantity);
        //displayPrice(quantity * 5);
    }

    /**
     * This method displays the give quantity value on the screen.
     * @param number
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


}


