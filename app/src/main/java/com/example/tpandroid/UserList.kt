package com.example.tpandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserList : AppCompatActivity(),onUserClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        var users= mutableListOf<User>()
        for(i in 0..20){

            users.add(User("Linda"+i,"Lamouchi"))
            println(users[i])
        }

          val  recyclerView :  RecyclerView =  findViewById(R.id.recyclerView)

        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this,1))
        recyclerView.adapter=UserAdapter(users,this)



    }

    override fun onUserClick(user: User, position: Int) {
       // Toast.makeText(this,user.firstName,Toast.LENGTH_SHORT).show()
        val intent=Intent(this@UserList, UserDetails::class.java)
        intent.putExtra("firstName",user.firstName)
        intent.putExtra("lastName",user.lastName)
        startActivity( intent)
    }
}