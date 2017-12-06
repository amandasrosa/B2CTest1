package b2ctest1.com.b2ctest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import b2ctest1.com.b2ctest1.model.ObjectsHelper;
import b2ctest1.com.b2ctest1.model.User;
import b2ctest1.com.b2ctest1.model.UserDAO;

/**
 * Created by Amanda on 05/12/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button save = (Button)this.findViewById(R.id.save_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailField = (EditText)findViewById(R.id.reg_email);
                String email = emailField.getText().toString();
                EditText passwordField = (EditText)findViewById(R.id.reg_password);
                String password = passwordField.getText().toString();

                if (email.equals("") || password.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Please type an email and password", Toast.LENGTH_LONG).show();
                } else {
                    User user = new User();
                    user.setEmail(email);
                    user.setPassword(password);

                    UserDAO dao = new UserDAO(v.getContext());
                    dao.dbinsert(user);
                    dao.close();

                    Toast.makeText(RegisterActivity.this, "User " + email + " saved ", Toast.LENGTH_LONG).show();
                    Intent intentGotoForm = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intentGotoForm);
                }
            }
        });
    }
}
