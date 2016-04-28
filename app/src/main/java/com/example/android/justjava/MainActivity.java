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

        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     * @param view
     */
    public void submitOrder(View view){
        displayMessage(createOrderSummary(calculatePrice()));
    }

    /**
     * Calculates the price of the order.
     *
     * @return total of price.
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Create summary of the order.
     *
     * @param totalPrice of the order.
     * @return text summary.
     */
    private String createOrderSummary(int totalPrice){
        String summaryMessage = "Name: Feng Lin" +
                "\nQuantity: " + quantity +
                "\nTotal: " + NumberFormat.getCurrencyInstance().format(totalPrice) +
                "\nThank you!";
        return summaryMessage;
    }

    /**
     * This method is called when the increment button is clicked.
     * @param view
     */
    public void increment(View view){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement button is clicked.
     * @param view
     */
    public void decrement(View view){
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the give quantity value on the screen.
     * @param number
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        if(quantityTextView != null){
            quantityTextView.setText("" + number);
        }

    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}


