package com.example.registration

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var radioGroup: RadioGroup
    lateinit var radioButton: RadioButton
    lateinit var spinner: Spinner
    var hobbies= arrayOf("Dancing","Singing","Drawing","Reading")
    lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView=findViewById(R.id.imageView)
        textView=findViewById(R.id.textView)
        textView=findViewById(R.id.textView2)
        textView=findViewById(R.id.textView3)
        textView=findViewById(R.id.textView4)
        editText=findViewById(R.id.editName)
        editText=findViewById(R.id.EmailAddress)
        textView=findViewById(R.id.textView5)
        radioGroup=findViewById(R.id.radioGroup)
        radioButton=findViewById(R.id.male)
        radioButton=findViewById(R.id.female)
        spinner=findViewById(R.id.spinner)
        button =findViewById(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this,"Registration complete",Toast.LENGTH_LONG).show()
        }


        spinner.onItemSelectedListener = this

        var adapter = ArrayAdapter(this@MainActivity,
            android.R.layout.simple_spinner_item,hobbies)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        textView.setOnClickListener{
            loadCalendar()
        }
    }

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, yyyy, mm, dd ->
                textView?.text = "$yyyy/${mm + 1}/$dd"
            },
            year, month, day
        ).show()

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}