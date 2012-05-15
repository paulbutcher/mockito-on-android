package com.example.test;

import android.test.InstrumentationTestCase;
import com.example.*;

import static org.mockito.Mockito.*;

public class OrderTest extends InstrumentationTestCase {
  
    public void testInStock() {
        Warehouse mockWarehouse = mock(Warehouse.class);
        
        when(mockWarehouse.hasInventory("Talisker", 50)).thenReturn(true);
        
        Order order = new Order("Talisker", 50);
        order.fill(mockWarehouse);
        
        assertTrue(order.isFilled());
        verify(mockWarehouse).remove("Talisker", 50);
    }
    
    public void testOutOfStock() {
        Warehouse mockWarehouse = mock(Warehouse.class);
        
        when(mockWarehouse.hasInventory("Talisker", 50)).thenReturn(false);

        Order order = new Order("Talisker", 50);
        order.fill(mockWarehouse);
        
        assertFalse(order.isFilled());
    }
}
