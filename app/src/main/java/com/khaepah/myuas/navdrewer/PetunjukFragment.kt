package com.khaepah.myuas.navdrewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khaepah.myuas.ApiService
import com.khaepah.myuas.R
import com.khaepah.myuas.model.DataBuah
import com.khaepah.myuas.model.ResponseBuahList
import kotlinx.android.synthetic.main.fragment_petunjuk.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PetunjukFragment : Fragment() {

    private lateinit var adapter: AdapterPetunjuk
    lateinit var rcvPetunjuk: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_petunjuk, container, false)

        initFragment(view)
        return view

    }

    override fun onStart() {
        super.onStart()

    }

    fun initFragment(view: View) {

        rcvPetunjuk = view.findViewById(R.id.rv_petunjuk)


        val layoutManager = LinearLayoutManager(requireActivity())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        adapter = AdapterPetunjuk()

        rcvPetunjuk.layoutManager = layoutManager
        rcvPetunjuk.adapter = adapter
    }
}