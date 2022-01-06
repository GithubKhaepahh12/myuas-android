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
import com.khaepah.myuas.model.DataUser
import com.khaepah.myuas.model.ResponseBuahList
import com.khaepah.myuas.model.ResponseProfilList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileFragment : Fragment() {

    private lateinit var adapter: AdapterProfil
    private lateinit var progresbar: ProgressBar
    lateinit var rcvProfil: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        initFragment(view)
        return view

    }

    override fun onStart() {
        setData()
        super.onStart()

    }

    fun setData() {
        progresbar.visibility = View.VISIBLE

        ApiService.endpoint.getProfil().enqueue(object : Callback<ResponseProfilList> {
            override fun onResponse(
                call: Call<ResponseProfilList>,
                response: Response<ResponseProfilList>
            ) {
                progresbar.visibility = View.GONE
                if (response.isSuccessful){
                    val dataUser: List<DataUser> = response.body()!!.dataUser
                    adapter.setData(dataUser)
                }
            }

            override fun onFailure(call: Call<ResponseProfilList>, t: Throwable) {
                progresbar.visibility = View.GONE
            }

        })
    }

    fun initFragment(view: View) {

        progresbar = view.findViewById(R.id.progresBarProfil)
        rcvProfil = view.findViewById(R.id.rv_profil)


        val layoutManager = LinearLayoutManager(requireActivity())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        adapter = AdapterProfil(requireActivity(), arrayListOf())

        rcvProfil.adapter = adapter
        rcvProfil.layoutManager = layoutManager

    }
}