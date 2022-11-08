package com.example.kotlinoneproject

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView

class BusinessAdapter(
    private var list: List<BusinessModel>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<BusinessAdapter.CharacterViewHolder>(), View.OnClickListener {

//     private var list1 = listOf<BusinessModel>()

    fun setData(listCharacters: List<BusinessModel>) {
        this.list = listCharacters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.itemView.setOnClickListener(this)
        holder.onBind(list[position])
    }

    override fun onClick(view: View?) {
        onItemClickListener.onClick(view?.tag as BusinessModel)
    }

    override fun getItemCount(): Int {
        return list.size
    }

     class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(character: BusinessModel) {
            ivImage.let { imageView ->
                Glide.with(imageView.context).load(character.imageUrl).into(imageView)
            }
            tvName.text = character.name
            tvAge.text = (character.age.toString())
            mainContainer.setCardBackgroundColor(Color.parseColor(character.color))
            itemView.tag = character
        }

        private val ivImage: ImageView
        private val tvName: TextView
        private val tvAge: TextView

        private val mainContainer: MaterialCardView

        init {
            ivImage = itemView.findViewById(R.id.iv_image)
            tvName = itemView.findViewById(R.id.tv_name)
            tvAge = itemView.findViewById(R.id.tv_age)
            mainContainer = itemView.findViewById(R.id.main_container)
        }
    }
}