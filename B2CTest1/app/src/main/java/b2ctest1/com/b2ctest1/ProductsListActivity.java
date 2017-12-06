package b2ctest1.com.b2ctest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import b2ctest1.com.b2ctest1.model.ObjectsHelper;
import b2ctest1.com.b2ctest1.model.Product;
import b2ctest1.com.b2ctest1.model.ProductDAO;

/**
 * Created by Amanda on 05/12/2017.
 */

public class ProductsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        TextView emailTextView = (TextView) findViewById(R.id.products_email);

        String email = getIntent().getStringExtra("email");
        String title = getIntent().getStringExtra("title");

        this.setTitle(title);
        emailTextView.setText(email);

        Button backToLogin = (Button)findViewById(R.id.back_button);

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGotoForm = new Intent(ProductsListActivity.this, LoginActivity.class);
                startActivity(intentGotoForm);
            }
        });
    }

    private void loadProductsList() {
        String title = getIntent().getStringExtra("title");

        ProductDAO dao = new ProductDAO(this);

        List<Product> products = new ArrayList<Product>();
        products = dao.dbSearch();

        if (products.isEmpty() || products == null) {
            ObjectsHelper.createProducts(this);
            products = dao.dbSearch();
        }

        dao.close();

        List<Product> productsDiscount = new ArrayList<Product>();
        for (Product p : products) {
            Double priceDiscount = p.getPrice()*0.9;
            Product pDiscount = new Product();
            pDiscount.setId(p.getId());
            pDiscount.setDescription(p.getDescription());
            pDiscount.setPrice(priceDiscount);
            productsDiscount.add(pDiscount);
        }

        ListView productsList = (ListView)findViewById(R.id.products_list);
        ArrayAdapter<Product> adapterDiscount = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, productsDiscount);
        ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products);

        System.out.println(title);
        if (title.equals("PRODUCTS WITH DISCOUNT")) {
            productsList.setAdapter(adapterDiscount);
        } else {
            productsList.setAdapter(adapter);
        }
    }

    @Override
    protected void onResume() {
        loadProductsList();
        super.onResume();
    }


}
