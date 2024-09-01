package com.example.fragmentlists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentlists.listData.AdapterClass
import com.example.fragmentlists.listData.DataClass
import java.util.Locale

class Fragment2 : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>
    private lateinit var descList: Array<String>
    private lateinit var detailImageList: Array<Int>
    private lateinit var myAdapter: AdapterClass
    private lateinit var searchView: SearchView
//    private lateinit var searchList: ArrayList<DataClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        imageList = arrayOf(
            R.drawable.ic_list,
            R.drawable.ic_checkbox,
            R.drawable.ic_image,
            R.drawable.ic_toggle,
            R.drawable.ic_date,
            R.drawable.ic_rating,
            R.drawable.ic_time,
            R.drawable.ic_text,
            R.drawable.ic_edit,
            R.drawable.ic_camera
        )

        titleList = arrayOf(
            "ListView",
            "CheckBox",
            "ImageView",
            "Toggle Switch",
            "Date Picker",
            "Rating Bar",
            "Time Picker",
            "TextView",
            "EditText",
            "Camera"
        )

        descList = arrayOf(
            getString(R.string.listview),
            getString(R.string.checkbox),
            getString(R.string.imageview),
            getString(R.string.toggle),
            getString(R.string.date),
            getString(R.string.rating),
            getString(R.string.time),
            getString(R.string.textview),
            getString(R.string.edit),
            getString(R.string.camera)
        )

        recyclerView = view.findViewById(R.id.recyclerView)
//        searchView = view.findViewById(R.id.search)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf()
//        searchList = arrayListOf()
        getData()

//        searchView.clearFocus()
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                searchView.clearFocus()
//                return true
//            }
//
////            override fun onQueryTextChange(newText: String?): Boolean {
////                searchList.clear()
////                val searchText = newText?.toLowerCase(Locale.getDefault()).orEmpty()
////                if (searchText.isNotEmpty()) {
////                    dataList.forEach {
////                        if (it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)) {
////                            searchList.add(it)
////                        }
////                    }
////                    myAdapter.notifyDataSetChanged()
////                } else {
////                    searchList.clear()
////                    searchList.addAll(dataList)
////                    myAdapter.notifyDataSetChanged()
////                }
////                return false
////            }
//        })

        myAdapter = AdapterClass(dataList)
        recyclerView.adapter = myAdapter

        return view
    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i], descList[i])
            dataList.add(dataClass)
        }
        dataList.addAll(dataList)
        recyclerView.adapter = AdapterClass(dataList)
    }
}
