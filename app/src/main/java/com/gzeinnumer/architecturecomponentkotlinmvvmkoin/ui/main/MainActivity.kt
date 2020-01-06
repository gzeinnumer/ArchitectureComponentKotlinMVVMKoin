package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.R
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.local.MyDatabase
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.handling.Resource
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.handling.Status
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model.MyResponse
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {


    //inject
    private val mainViewModel by inject<MainVM>()
    private val db by inject<MyDatabase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MyZein", db.categoriesDao().getAll().size.toString())


        with(mainViewModel) {
            getCategory().observe(this@MainActivity, Observer<Resource<MyResponse>> {
                when(it.status) {
                    Status.SHOWLOADING -> {
                        Log.d("Sukses", "Loading")
                    }

                    Status.SUCCESS -> {
                        Log.d("Sukses", "Sukses")
                        val listData = it.data
                        Log.d("Sukses", "Sukses list size "+ listData?.categories?.size)


                        listData?.categories?.let{
                            recyclerView.apply {
                                layoutManager = LinearLayoutManager(applicationContext)
//                                addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
                                adapter = MainAdapter(it) {

                                }
                                hasFixedSize()
                            }
                        }
                    }

                    Status.ERROR -> {
                        Log.d("Sukses", "Error")
                    }

                    Status.HIDELOADING -> {
                        Log.d("Sukses", "Hide")
                    }

                    else -> {
                        Log.d("Sukses", "Error")
                    }
                }
            })
        }
    }
}
