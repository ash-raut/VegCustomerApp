package com.example.vegcustomerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomerLoginActivity extends AppCompatActivity {
    Button button,buttonlogin;
    EditText usernamebt,passwordbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        button=findViewById(R.id.btnLoginRegister);
        usernamebt=findViewById(R.id.etLoginUsername);
        passwordbt=findViewById(R.id.etloginpassword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CustomerLoginActivity.this,CustomerRegistrationActivity.class);
                startActivity(intent);
            }
        });
        buttonlogin=findViewById(R.id.btnLogin);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomerLoginActivity.this, usernamebt.getText().toString()+" "+passwordbt.getText().toString() , Toast.LENGTH_SHORT).show();
                loginCustomer(usernamebt.getText().toString(),passwordbt.getText().toString());
                Intent intent = new Intent(CustomerLoginActivity.this,CustomerDrawerActivity.class);
                startActivity(intent);

            }
        });


    }



    //================================= Customer Login Function ==================================================


    private void loginCustomer(String customer_id,String customer_password) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CustomerLoginRequestInterface requestInteface = retrofit.create(CustomerLoginRequestInterface.class);
        Call<CUSTOMER> call = requestInteface.getCustomer(customer_id,customer_password);

        call.enqueue(new Callback<CUSTOMER>() {
            @Override
            public void onResponse(Call<CUSTOMER> call, Response<CUSTOMER> response) {
                CUSTOMER currentCustomer = response.body();
                CUSTOMER.setCurrentCustomer(currentCustomer);
               // Toast.makeText(CustomerLoginActivity.this,"Welcome "+currentCustomer.getCustomerName(), Toast.LENGTH_SHORT).show();

                //===================   Code to write on successful Customer Login ==========================

               /* Intent intent=new Intent(CustomerLoginActivity.this,CustomerDrawerActivity.class);
                startActivity(intent);
                finish();*/




                //=================== ***  Code to write on successful Customer Login ==========================

            }

            @Override
            public void onFailure(Call<CUSTOMER> call, Throwable t) {
                Toast.makeText(CustomerLoginActivity.this,"Login Failed \n"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


//================================= *** Customer Login Function ==================================================


}

