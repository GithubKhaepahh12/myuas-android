package com.khaepah.myuas.navdrewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khaepah.myuas.ApiService
import com.khaepah.myuas.R
import com.khaepah.myuas.model.DataBuah
import com.khaepah.myuas.model.ResponseBuahList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BuahFragment : Fragment() {

    private lateinit var adapter: AdapterBuah
    private lateinit var progresbar: ProgressBar
    lateinit var rcvBuah: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_buah, container, false)

        initFragment(view)
        return view

    }

    override fun onStart() {
        setData()
        super.onStart()

    }

    fun setData() {
        progresbar.visibility = View.VISIBLE

        ApiService.endpoint.getBuah().enqueue(object : Callback<ResponseBuahList> {
            override fun onResponse(
                call: Call<ResponseBuahList>,
                response: Response<ResponseBuahList>
            ) {
                progresbar.visibility = View.GONE
                if (response.isSuccessful){
                    val dataBuah: List<DataBuah> = response.body()!!.dataBuah
                    adapter.setData(dataBuah)
                }
            }

            override fun onFailure(call: Call<ResponseBuahList>, t: Throwable) {
                progresbar.visibility = View.GONE
            }

        })
    }

    fun initFragment(view: View) {

        progresbar = view.findViewById(R.id.progresBar)
        rcvBuah = view.findViewById(R.id.rv_buah)


        val layoutManager = LinearLayoutManager(requireActivity())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        adapter = AdapterBuah(requireActivity(), arrayListOf())

        rcvBuah.adapter = adapter
        rcvBuah.layoutManager = layoutManager

    }
}