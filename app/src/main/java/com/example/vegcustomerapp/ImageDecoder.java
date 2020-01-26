package com.example.vegcustomerapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ImageDecoder {

    public static Bitmap convertBase64ToBitmap(String base64String){


        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);

        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return bitmap;

    }




}
