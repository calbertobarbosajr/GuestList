package com.calberto.guests.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.calberto.guests.R
import com.calberto.guests.databinding.RowGuestBinding
import com.calberto.guests.service.model.GuestModel
import com.calberto.guests.view.listener.GuestListener

class GuestViewHolder(private val item: RowGuestBinding, private val listener: GuestListener) :
    RecyclerView.ViewHolder(item.root) {

    fun bind(guest: GuestModel) {
        item.textName.text = guest.name
        item.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        item.textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNeutralButton(R.string.cancelar, null)
                .show()
            true
        }
    }
}