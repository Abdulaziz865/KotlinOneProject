package com.example.kotlinoneproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerFragment : Fragment(), OnItemClickListener {

    private var repository = BusinessRepository()
    private var buttonAdd: Button? = null
    private var characterAdapter : BusinessAdapter? = null
    private var model: BusinessModel? = null
    private lateinit var listCharacters: List<BusinessModel>
    private var rvListOfName: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvListOfName = view.findViewById(R.id.rv_list_of_name)
        buttonAdd = view.findViewById(R.id.button_add)
        rvListOfName?.adapter = characterAdapter
        listCharacters = repository.getListOfCharacters()
        characterAdapter?.setData(listCharacters)
        initialize()
        onAdds()
        click()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    private fun click() {
        buttonAdd?.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val addFragment = AddFragment()
            fragmentTransaction.add(R.id.fragment_container, addFragment)
            parentFragmentManager.popBackStack()
            fragmentTransaction.commit()

        }
    }

    private fun initialize() {
        rvListOfName?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvListOfName?.adapter = characterAdapter
        characterAdapter = BusinessAdapter(listCharacters, this)
    }

    override fun onClick(model: BusinessModel) {
        val bundle = Bundle()
        bundle.putSerializable("character", model)
        parentFragmentManager.beginTransaction()
            .add(R.id.fragment_container, DetailFragment::class.java, bundle)
            .addToBackStack("RecyclerFragment")
            .commit()
    }

    private fun onAdds() {
        parentFragmentManager.setFragmentResultListener(
            "OK", viewLifecycleOwner
        ) { requestKey, result ->
            if (requestKey == "OK") {
                model = result.getSerializable("editBusinesmens") as BusinessModel?
               characterAdapter?.setData(listCharacters)
            }
        }
    }
}