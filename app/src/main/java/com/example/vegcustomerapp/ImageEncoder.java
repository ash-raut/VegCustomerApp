package com.example.vegcustomerapp;

import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class ImageEncoder {

    public static String convertBitmapToBase64(Bitmap bitmap){


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] b = baos.toByteArray();
        String base64ImageString = Base64.encodeToString(b, Base64.DEFAULT);

        return base64ImageString;
    }


}
