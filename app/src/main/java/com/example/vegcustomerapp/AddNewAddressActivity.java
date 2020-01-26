package com.example.vegcustomerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddNewAddressActivity extends AppCompatActivity {
    Button submit;




    private static final String  KEY_NAME ="name";
    private static final String KEY_MOBILE_NO = "mobileno";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PINCODE = " pincode";
    private static final String KEY_CITY = "city";
    private static final  String KEY_STATE = "state";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_LANDMARK = "landmark";


    private EditText etname;
    private EditText etmobileno;
    private  EditText etstate;
    private  EditText etcountry;
    private  EditText etcity;
    private EditText etpincode;
    private EditText etaddress;
    private EditText etlandmark;

    private String name;
    private  String mobileno;
    private  String useraddress;
    private  String pincode;
    private  String city;
    private  String state;
    private String country;
    private String landmaek;
    ADDRESS address = new ADDRESS();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewaddress);
        submit=findViewById(R.id.placeorder);
        etname=findViewById(R.id.etname);
        etmobileno=findViewById(R.id.etmobile_no);
        etcity=findViewById(R.id.etcity);
        etaddress=findViewById(R.id.etaddress);
        etcountry=findViewById(R.id.etcountry);
        etpincode=findViewById(R.id.etpincode);
        etstate=findViewById(R.id.etstate);
        etlandmark=findViewById(R.id.etlandmark);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent=new Intent(AddNewAddressActivity.this,PaymentActivity.class);
                //startActivity(intent);
                //Retrieve the data entered in the edit texts


                address.setAddressCustomerId(CUSTOMER.getCurrentCustomer().getCustomerId());
                address.setAddressName(etname.getText().toString().trim());
                address.setAddressMobile(etmobileno.getText().toString().trim());
                address.setAddressCity(etcity.getText().toString().trim());
                address.setAddressAddress(etaddress.getText().toString().trim());
                address.setAddressCountry(etcountry.getText().toString().trim());
                address.setAddressPincode(etpincode.getText().toString().trim());
                address.setAddressState(etstate.getText().toString().trim());
                address.setAddressLandmark(etlandmark.getText().toString().trim());

                addAddress(address);


            }
        });

    }




    //============================================  Address Adding Function ==========================================



    private void addAddress(ADDRESS address)
    {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_address))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AddAddressRequestInterface requestInteface = retrofit.create(AddAddressRequestInterface.class);
        Call<AddressRequestResponsePOJO> call = requestInteface.getAddAddressResponse(
                address.getAddressCustomerId(),
                address.getAddressName(),
                address.getAddressMobile(),
                address.getAddressCountry(),
                address.getAddressState(),
                address.getAddressCity(),
                address.getAddressAddress(),
                address.getAddressPincode(),
                address.getAddressLandmark()

        );

        call.enqueue(new Callback<AddressRequestResponsePOJO>() {
            @Override
            public void onResponse(Call<AddressRequestResponsePOJO> call, Response<AddressRequestResponsePOJO> response) {


                AddressRequestResponsePOJO addressRequestResponsePOJO = response.body();

                if(addressRequestResponsePOJO.getStatus().equals("successful"))
                {
                   // ADDRESS.setCurrentAddress(addressRequestResponsePOJO.getData().get(0));

                    //================================= Code to write on successful address Adding=====================================


                      AddressRequestResponsePOJO.setAddressArrayList(addressRequestResponsePOJO.getData());
                    Toast.makeText(AddNewAddressActivity.this, "Add Address Successfully", Toast.LENGTH_SHORT).show();

                    /*Intent intent= new Intent(AddNewAddressActivity.this,AddressSelectionActivity.class);
                    startActivity(intent);
*/
                    finish();


                    //================================= *** Code to write on successful address Adding =======================================


                }

                else
                {
                    Toast.makeText(AddNewAddressActivity.this, "Responded Address Adding Failed", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<AddressRequestResponsePOJO> call, Throwable t) {
                Toast.makeText(AddNewAddressActivity.this, "Responded Address Adding Failed\n"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    //========================================  *** Address Adding Function   ===========================================

}


