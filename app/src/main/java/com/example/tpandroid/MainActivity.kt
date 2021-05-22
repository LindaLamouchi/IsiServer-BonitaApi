package com.example.tpandroid

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.*;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b1 = findViewById<Button>(R.id.LogBtn)
        val ed1 = findViewById<EditText>(R.id.editText)
        val ed2 = findViewById<EditText>(R.id.editText2)

        b1.setOnClickListener {

          /*  if (ed1.getText().toString().equals("linda") && ed2.getText().toString()
                    .equals("1234")
            ) {
                startActivity(Intent(this@MainActivity, UserList::class.java) )
            } else {
                Toast.makeText(applicationContext, "Wrong Credentials", Toast.LENGTH_SHORT)
                    .show()
            }*/
            val SDK_INT = Build.VERSION.SDK_INT
            if (SDK_INT > 8) {
                val policy= StrictMode.ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)
                var client = OkHttpClient().newBuilder()
                        .build()
                var mediaType: MediaType? = "application/x-www-form-urlencoded".toMediaTypeOrNull()
                // var s:String= "username=$user&password=$pass&redirect=false"

                var body: RequestBody = RequestBody.create(
                        mediaType,"username=etud1.l3sil&password=bpm&redirect=false")
                var request: Request = Request.Builder()
                        .url("http://digitalisi.tn:8080/bonita/loginservice")
                        .method("POST", body)
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .build()
                var response: Response = client.newCall(request).execute()
                System.out.println(response.headers.toString());
            }

            startActivity(Intent(this, MainActivity::class.java))


        }



    }

}