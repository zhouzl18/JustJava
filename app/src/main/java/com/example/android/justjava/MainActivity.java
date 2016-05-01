package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     * @param view
     */
    public void submitOrder(View view){
        //Get the name of customer.
        EditText nameEditText = (EditText) findViewById(R.id.name_field);
        String name = nameEditText.getText().toString();

        //Figure out if the user wants the whipped cream topping.
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.check_whipped_cream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Figure out if the user wants the chocolate topping.
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.check_chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        String orderSummaryMessage = createOrderSummary(calculatePrice(hasWhippedCream, hasChocolate), name, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, orderSummaryMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @return total of price.
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        //Price of a cup of coffee.
        int basePrice = 5;

        //basePrice add 1 if the user want whipped cream.
        if(hasWhippedCream){
            basePrice += 1;
        }

        ////basePrice add 2 if the user want chocolate..
        if(hasChocolate){
            basePrice += 2;
        }

        //Calculate the total order price
        return quantity * basePrice;
    }

    /**
     * Create summary of the order.
     *
     * @param name of the customer.
     * @param addWhippedCream that the coffees is added.
     * @param addChocolate is weather or not the user wants the whipped cream topping.
     * @param totalPrice is weather or not the user wants the chocolate topping.
     * @return text summary.
     */
    private String createOrderSummary(int totalPrice, String name, boolean addWhippedCream, boolean addChocolate){
        /*String summaryMessage = "Name: " + name +
                "\nAdd Whipped cream? " + addWhippedCream +
                "\nAdd Chocolate? " + addChocolate +
                "\nQuantity: " + quantity +
                "\nTotal: " + NumberFormat.getCurrencyInstance().format(totalPrice) +
                "\nThank you!";*/

        String summaryMessage = getString(R.string.order_summary_name, name);
        summaryMessage += "\n" + getString(R.string.order_summary_whipped_cream, addWhippedCream);
        summaryMessage += "\n" + getString(R.string.order_summary_chocolate, addChocolate);
        summaryMessage += "\n" + getString(R.string.order_summary_quantity, quantity);
        summaryMessage += "\n" + getString(R.string.order_summary_price, NumberFormat.getCurrencyInstance().format(totalPrice));
        summaryMessage += "\n" + getString(R.string.thank_you);
        return summaryMessage;
    }

    /**
     * This method is called when the increment button is clicked.
     * @param view
     */
    public void increment(View view){
        if(quantity == 100){
            Toast.makeText(this, "You can order up to 100 cups of coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement button is clicked.
     * @param view
     */
    public void decrement(View view){
        if(quantity == 1){
            Toast.makeText(this, "Order at least 1 cups of coffee.", Toast.LENGTH_SHORT).show();
            return;
        }
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

}


