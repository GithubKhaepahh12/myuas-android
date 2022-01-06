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
import com.khaepah.myuas.model.DataSayur
import com.khaepah.myuas.model.ResponseBuahList
import com.khaepah.myuas.model.ResponseSayurList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SayurFragment : Fragment() {

    private lateinit var adapter: AdapterSayur
    private lateinit var progresbar: ProgressBar
    lateinit var rcvSayur: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sayur, container, false)

        initFragment(view)
        return view

    }

    override fun onStart() {
        setData()
        super.onStart()

    }

    fun setData() {
        progresbar.visibility = View.VISIBLE

        ApiService.endpoint.getSayur().enqueue(object : Callback<ResponseSayurList> {
            override fun onResponse(
                call: Call<ResponseSayurList>,
                response: Response<ResponseSayurList>
            ) {
                progresbar.visibility = View.GONE
                if (response.isSuccessful){
                    val dataSayur: List<DataSayur> = response.body()!!.dataSayur
                    adapter.setData(dataSayur)
                }
            }

            override fun onFailure(call: Call<ResponseSayurList>, t: Throwable) {
                progresbar.visibility = View.GONE
            }

        })
    }

    fun initFragment(view: View) {

        progresbar = view.findViewById(R.id.progresBarsayur)
        rcvSayur = view.findViewById(R.id.rv_sayur)


        val layoutManager = LinearLayoutManager(requireActivity())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        adapter = AdapterSayur(requireActivity(), arrayListOf())

        rcvSayur.adapter = adapter
        rcvSayur.layoutManager = layoutManager

    }
}