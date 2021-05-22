package com.example.tpandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.tpandroid.databinding.ActivityUserDetailsBinding

class UserDetails : AppCompatActivity() {
    //lateinit var binding: ActivityUserDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
       // binding=DataBindingUtil.setContentView(this,R.layout.activity_user_details)
        val firstName:TextView=findViewById(R.id.firstName)
        val lastName:TextView=findViewById(R.id.lastName)
        firstName.text = intent.getStringExtra("firstName")
        lastName.text = intent.getStringExtra("lastName")
    }
}