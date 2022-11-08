package com.example.kotlinoneproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class DetailFragment : Fragment() {

    private var ivFullScreen: ImageView? = null
    private var model: BusinessModel? = null
    private var buttonRedactor: MaterialButton? = null
    private var namePerson: EditText? = null
    private var agePerson: EditText? = null
//    private var imageRedactor: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivFullScreen = view.findViewById(R.id.iv_fullscreen)
        namePerson = view.findViewById(R.id.tv_name_person)
        agePerson = view.findViewById(R.id.tv_age_person)
        buttonRedactor = view.findViewById(R.id.btn_redactor)
        getData()
    }


    private fun getData() {
        val arguments = arguments
        if (arguments != null) {
            model = arguments.getSerializable("character") as BusinessModel?
            ivFullScreen?.context?.let { Glide.with(it).load(model?.imageUrl).into(ivFullScreen!!) }
            namePerson?.setText(model?.name)
            agePerson?.setText(java.lang.String.valueOf(model?.age))
        }
    }
}
