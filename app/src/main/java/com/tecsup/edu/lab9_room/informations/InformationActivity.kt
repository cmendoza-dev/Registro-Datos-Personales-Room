package com.tecsup.edu.lab9_room.informations

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tecsup.edu.lab9_room.R

class InformationActivity: AppCompatActivity() {

    private lateinit var informationViewModel: InformationViewModel;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        informationViewModel = run {
            ViewModelProvider(this)[InformationViewModel::class.java]
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerInformations)

        val adapter = InformationAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        informationViewModel.informations?.observe(this){ informations ->
            informations?.let {
                adapter.setInformation(informations)
            }
        }

        val floatingNota = findViewById<FloatingActionButton>(R.id.floatingInformation)
        floatingNota.setOnClickListener{
            registerAndUpdateNote()
        }


            //layoutManager =  LinearLayoutManager(context)
            //layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.contactos)
        val drawable = resources.getDrawable(R.color.purple_620)
        supportActionBar?.setBackgroundDrawable(drawable)

    }

    private fun registerAndUpdateNote() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_information, null)

        val titleAlertNote = "Registrar mis Datos"

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(titleAlertNote)

        val mAlertDialog = mBuilder.show()

        val buttonCreate  = mDialogView.findViewById<Button>(R.id.btnCreate)
        val editTextNamesCreate  = mDialogView.findViewById<EditText>(R.id.edtNames)
        val editTextPhoneCreate  = mDialogView.findViewById<EditText>(R.id.edtPhoneNumber)
        val editTextEmailCreate  = mDialogView.findViewById<EditText>(R.id.edtEmail)
        val editTextAddressCreate  = mDialogView.findViewById<EditText>(R.id.edtAddress)

        buttonCreate.setOnClickListener {

            mAlertDialog.dismiss()

            val textNames = editTextNamesCreate.text.toString()
            val textPhone = editTextPhoneCreate.text.toString()
            val textEmail = editTextEmailCreate.text.toString()
            val textAddress = editTextAddressCreate.text.toString()

            var informationVM = Information(textNames, textPhone, textEmail, textAddress )
            informationViewModel.saveInformations(informationVM)

        }


    }



}