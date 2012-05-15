package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WarehouseManagerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        productEditText = (EditText)findViewById(R.id.product);
        quantityEditText = (EditText)findViewById(R.id.quantity);
    }
    
    public void placeOrder(View view) {
        String product = productEditText.getText().toString();
        int quantity = Integer.parseInt(quantityEditText.getText().toString());
        Order order = new Order(product, quantity);
        order.fill(warehouse);
  
        String message = order.isFilled() ? "Success" : "Failure";
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();    
    }

    private Warehouse warehouse = new RealWarehouse();
  
    private EditText productEditText;
    private EditText quantityEditText;
}