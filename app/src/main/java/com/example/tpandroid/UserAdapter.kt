package com.example.tpandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter (var users:MutableList<User> ,var clickListener: onUserClickListener):RecyclerView.Adapter<UserViewHolder>(){




    override fun getItemCount(): Int {
     return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
      //  holder.firstName.text =users[position].firstName
      //  holder.lastName.text =users[position].lastName

        holder.initilaze(users[position],clickListener)
    }

}

class UserViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var firstName : TextView=itemView.findViewById(R.id.firstName)
    var lastName  : TextView=itemView.findViewById(R.id.lastName)

    fun initilaze(user:User,action:onUserClickListener){
        firstName.text=user.firstName
        lastName.text=user.lastName
        itemView.setOnClickListener{
            action.onUserClick(user,adapterPosition)
        }
    }
}

interface onUserClickListener{

    fun onUserClick(user:User,position: Int)
}