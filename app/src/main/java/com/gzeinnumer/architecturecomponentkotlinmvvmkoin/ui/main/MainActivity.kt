package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.R
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.model.Phrase
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    //inject
    private val mainViewModel: MainVM by viewModel()


    private val adapter: MainAdapter by lazy{
        MainAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = adapter


        mainViewModel.getAllPhrases().observe(this, Observer{

            if(it!!.isEmpty()){
                tv_phrases_count.text = "No data."
                return@Observer
            }


            adapter.addAll(it)
        })

        mainViewModel.loadAllData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(R.id.action_add == item!!.itemId){
            showDialogNewWord()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showDialogNewWord() {
        val edtPhrase = EditText(this)

        AlertDialog.Builder(this)
            .setTitle("Type a phrase")
            .setView(edtPhrase)
            .setNegativeButton("Cancel", null)
            .setPositiveButton("Save") { dialogInterface, i ->
                val text = edtPhrase.text.toString()

                // if there is a text, save it
                if (text.trim { it <= ' ' }.isNotEmpty()) {
                    val phrase = Phrase(text = text)

                    //TODO: save in room database
                }
            }
            .create()
            .show() // show dialog
    }
}
