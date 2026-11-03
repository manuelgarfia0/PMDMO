package com.example.contactos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactosAdapter(private val contactos: List<Contacto>,
                       private val contactoPulsadoListener: ContactoPulsadoListener) :
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val contacto = contactos[position]
        holder.tvNombre.text = contacto.nombre
        holder.tvTelefono.text = contacto.tfno
        holder.tvCorreo.text = contacto.correo
        holder.btnLlamar.setOnClickListener {
            contactoPulsadoListener.contactoPulsado(contacto)
        }
        holder.btnInfo.setOnClickListener {
            contactoPulsadoListener.contactoInfoPulsado(contacto)
        }

        val ultimoDigito = contacto.tfno.lastOrNull()?.digitToIntOrNull() ?: 0
        val imageRes = when (ultimoDigito) {
            0 -> R.drawable.numero0
            1 -> R.drawable.numero1
            2 -> R.drawable.numero2
            3 -> R.drawable.numero3
            4 -> R.drawable.numero4
            5 -> R.drawable.numero5
            6 -> R.drawable.numero6
            7 -> R.drawable.numero7
            8 -> R.drawable.numero8
            9 -> R.drawable.numero9
            else -> R.drawable.numero0
        }
        holder.imageView.setImageResource(imageRes)
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefono)
        val tvCorreo: TextView = itemView.findViewById(R.id.tvCorreo)
        val btnInfo: Button = itemView.findViewById(R.id.btnInfo)
        val btnLlamar: Button = itemView.findViewById(R.id.btnLlamar)
    }
}