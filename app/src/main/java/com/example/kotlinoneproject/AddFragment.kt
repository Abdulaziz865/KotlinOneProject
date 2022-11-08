package com.example.kotlinoneproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class AddFragment : Fragment() {

    private var imageViewCreate: EditText? = null
    private var editNameCreate: EditText? = null
    private var editAgeCreate: EditText? = null
    private var buttonCreate: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageViewCreate = view.findViewById(R.id.image_create)
        editNameCreate = view.findViewById(R.id.et_name_create)
        editAgeCreate = view.findViewById(R.id.et_age_create)
        buttonCreate = view.findViewById(R.id.btn_create)
        onClick()
    }

    private fun onClick() {
        buttonCreate!!.setOnClickListener {
            val imageCreateView = imageViewCreate!!.text.toString().trim { it <= ' ' }
            val nameCreateText: String = editNameCreate!!.text.toString().trim { it <= ' ' }
            val ageCreateText: String = editAgeCreate!!.text.toString().trim { it <= ' ' }
            if (imageCreateView.isEmpty() && nameCreateText.isEmpty() && ageCreateText.isEmpty()) {
                editNameCreate!!.error = "Введите имя"
                imageViewCreate!!.error = "Введите ссылку"
                editAgeCreate!!.error = "Введите возраст"
            } else if (imageCreateView.isEmpty()) {
                imageViewCreate!!.error = "Введите ссылку"
            } else if (nameCreateText.isEmpty()) {
                editNameCreate!!.error = "Введите имя"
            } else if (ageCreateText.isEmpty()) {
                editAgeCreate!!.error = "Введите возраст"
            } else {
                val bundle = Bundle()
                val model = BusinessModel(imageCreateView, nameCreateText, ageCreateText.toInt(), "#36D375")
                bundle.putSerializable("editBusinesmens", model)
                parentFragmentManager.setFragmentResult("OK", bundle)
                parentFragmentManager.popBackStack()
            }
        }
    }
}