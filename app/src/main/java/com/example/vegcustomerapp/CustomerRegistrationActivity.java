package com.example.vegcustomerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomerRegistrationActivity extends AppCompatActivity {
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_EMPTY = "";


    private EditText DOB;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etFullName;
    private EditText etMoNumber;
    private EditText etEmail;
    private EditText Address;
    private String username;
    private String password;
    private String confirmPassword;
    private String fullName;
    private String number;
    private String address;
    private String dob;
    private String email;
    Button signupbtn;
    DatePickerDialog datePickerDialog;
    String gender;

    private RadioGroup radioGroup;
    private RadioButton rButton,maButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);
        signupbtn = findViewById(R.id.btnRegister);
        etFullName = findViewById(R.id.etFullName);
        radioGroup = findViewById(R.id.radioGrp);
        Address=findViewById(R.id.address);
        rButton = findViewById(R.id.radioF);
        etUsername = findViewById(R.id.etUsername);
        DOB=findViewById(R.id.DOB);
        etMoNumber = findViewById(R.id.etmobileNo);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.emailadd);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(CustomerRegistrationActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        //date.setText(day+"-"+(month+1)+"-"+year);
                        DOB.setText(year+"-"+(month+1)+"-"+day);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CustomerRegistrationActivity.this,CustomerLoginActivity.class);
                startActivity(intent);

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if(selectedId == R.id.radioF) {
                    gender = "f";
                }
               else  if(selectedId == R.id.radioM) {
                    gender = "m";
                }

                //Retrieve the data entered in the edit texts
                username = etUsername.getText().toString().toLowerCase().trim();
                password = etPassword.getText().toString().trim();
                confirmPassword = etConfirmPassword.getText().toString().trim();
                fullName = etFullName.getText().toString().trim();
                number = etMoNumber.getText().toString().trim();
                email = etEmail.getText().toString().trim();
                address=Address.getText().toString().trim();
                dob=DOB.getText().toString().trim();


                CUSTOMER customer= new CUSTOMER();
                customer.setCustomerName(fullName);
                customer.setCustomerUserName(username);
                customer.setCustomerPassword(password);
                customer.setCustomerEmail(email);
                customer.setCustomerMobile(number);
                customer.setCustomerGender(gender);
                customer.setCustomerAddress(address);
                customer.setCustomerDob(dob);

                if (validateInputs()) {

                    Toast.makeText(CustomerRegistrationActivity.this, "Validated", Toast.LENGTH_SHORT).show();
                    registerCustomer(customer);
                }

            }
        });


    }


    private boolean validateInputs() {


        if (KEY_EMPTY.equals(fullName)) {
            etFullName.setError("Full Name Is Required");
            etFullName.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(username)) {
            etUsername.setError("Username Is Required");
            etUsername.requestFocus();
            return false;
        }
        if (etMoNumber.getText().toString().length()!=10){
            etMoNumber.setError("Please enter Valid no");
            return false;

        }

        if (KEY_EMPTY.equals(email)) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(password)) {
            etPassword.setError("Password Is Required");
            etPassword.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(confirmPassword)) {
            etConfirmPassword.setError("Confirm Password Is Required");
            etConfirmPassword.requestFocus();
            return false;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Password and Confirm Password does not match");
            etConfirmPassword.requestFocus();
            return false;
        }
        if (KEY_NUMBER.equals(number)) {
            etMoNumber.setError("Mobile no Is Required");
            etMoNumber.requestFocus();
            return false;
        }


        Intent i = new Intent(getApplicationContext(), CustomerLoginActivity.class);
        startActivity(i);

        return true;
    }



    //=======================================   Register Customer function  =============================================


    private void registerCustomer(CUSTOMER customer){


        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CustomerRegisterRequestInterface requestInterface = retrofit.create(CustomerRegisterRequestInterface.class);
        Call<CustomerRegistrationResponsePOJO> call = requestInterface.getRegistrationPOJO(

                customer.getCustomerName(),
                customer.getCustomerPassword(),
                customer.getCustomerUserName(),
                customer.getCustomerMobile(),
                customer.getCustomerAddress(),
                customer.getCustomerEmail(),
                customer.getCustomerDob(),
                customer.getCustomerGender()

        );




        call.enqueue(new Callback<CustomerRegistrationResponsePOJO>() {
            @Override
            public void onResponse(Call<CustomerRegistrationResponsePOJO> call, Response<CustomerRegistrationResponsePOJO> response) {


                CustomerRegistrationResponsePOJO customerRegistrationResponsePOJO = response.body();


                if(customerRegistrationResponsePOJO.getStatus().equals("successful")) {


                    //=================================== Write code on successful customer registeration      ===========================


                    Toast.makeText(CustomerRegistrationActivity.this, "Customer Registration Successful", Toast.LENGTH_SHORT).show();


                    //================================== *** Write code on successful customer registeration  =========================

                }

                else{

                    Toast.makeText(CustomerRegistrationActivity.this, "Customer Registration Failed", Toast.LENGTH_SHORT).show();

                }



            }

            @Override
            public void onFailure(Call<CustomerRegistrationResponsePOJO> call, Throwable t) {

                Toast.makeText(CustomerRegistrationActivity.this, "Customer Registration Failed Failed", Toast.LENGTH_SHORT).show();


            }
        });








    }


    //============================================== ***  Register Customer function ================================================================


}

