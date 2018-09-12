package es.sdos.joaquinruiz.livedataexample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.sdos.joaquinruiz.livedataexample.ALGO_CON
import es.sdos.joaquinruiz.livedataexample.ALGO_DON
import es.sdos.joaquinruiz.livedataexample.R
import es.sdos.joaquinruiz.livedataexample.model.User
import kotlinx.android.synthetic.main.row_user.view.*

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size

    fun updateUsers(users: List<User>) {
        list = users
        notifyDataSetChanged()
        ALGO_DON
        ALGO_CON
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: User) = with(itemView) {
            row_user__label__username.text = item.username
        }
    }
}