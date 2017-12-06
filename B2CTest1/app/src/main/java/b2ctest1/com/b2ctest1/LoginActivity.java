package b2ctest1.com.b2ctest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import b2ctest1.com.b2ctest1.model.ObjectsHelper;
import b2ctest1.com.b2ctest1.model.UserDAO;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        Button login = (Button)this.findViewById(R.id.login_button);
        Button register = (Button)this.findViewById(R.id.login_register_button);
        Button guestLogin = (Button)this.findViewById(R.id.login_guest_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailField = (EditText)findViewById(R.id.login_email);
                String email = emailField.getText().toString();
                EditText passwordField = (EditText)findViewById(R.id.login_password);
                String password = passwordField.getText().toString();

                boolean validLogin = ObjectsHelper.checkEmailNPassHelper(email, password, v.getContext());
                if (validLogin == true) {
                    Intent intentGotoForm = new Intent(LoginActivity.this, ProductsListActivity.class);
                    intentGotoForm.putExtra("email", email);
                    intentGotoForm.putExtra("title", "PRODUCTS WITH DISCOUNT");
                    intentGotoForm.putExtra("listProducts", "products");
                    startActivity(intentGotoForm);
                } else {
                    Toast.makeText(LoginActivity.this, "Email or password incorrect. Please try again.", Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGotoForm = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentGotoForm);
            }
        });

        guestLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGotoForm = new Intent(LoginActivity.this, ProductsListActivity.class);
                intentGotoForm.putExtra("email", "");
                intentGotoForm.putExtra("title", "PRODUCTS WITH NO DISCOUNT");
                intentGotoForm.putExtra("listProducts", "productsDiscount");
                startActivity(intentGotoForm);
            }
        });

    }


}
