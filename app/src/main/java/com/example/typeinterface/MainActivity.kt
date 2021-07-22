package com.example.typeinterface

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.AdapterView
import android.view.View
import android.widget.TextView
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type
import java.security.spec.PSSParameterSpec.DEFAULT
import kotlin.jvm.internal.TypeIntrinsics
import kotlin.random.Random

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    var Typeface = arrayOf("DEFAULT", "DEFAULT BOLD", "MONOSPACE", "SAN_SERIF", "SERIF")
    //var Colors = arrayOf("RED", "BLUE", "GREEN","YELLOW", "PURPLE", "BLACK", "ORANGE")
    var bi = 0
    var tf: Typeface = android.graphics.Typeface.DEFAULT
    //var cf = EditText.setTextColor(Color.BLACK)
    var spinner: Spinner? = null
    //var colorSpin: Spinner? = null
    var textView_msg: TextView? = null
    var ts = 16F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent: Intent = getIntent()
//        val bundleInfo: Bundle? = intent.getExtras()
//        if (bundleInfo != null) {
//
//        }
//        setResult(Activity.RESULT_OK, intent)
//        finish()

        textView_msg = this.textView
        spinner = this.TypeSpinner
        spinner!!.setOnItemSelectedListener(this)


        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, Typeface)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.setAdapter(aa)

        toggleButton()
        changeColor()
        changeSize()

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p2 == 0) {
            resetToggle()
            tf = android.graphics.Typeface.DEFAULT
        } else if (p2 == 1) {
            resetToggle()
            boldToggle.toggle()
            bi = 1
            tf = DEFAULT_BOLD
        } else if (p2 == 2) {
            resetToggle()
            tf = MONOSPACE
        } else if (p2 == 3) {
            resetToggle()
            tf = SANS_SERIF
        } else if (p2 == 4) {
            resetToggle()
            tf = SERIF
        }
        EditText.setTypeface(tf, bi)
    }



    private fun resetToggle() {
        if (boldToggle.isChecked) {
            boldToggle.toggle()
            bi = 0
        }

        if (italicToggle.isChecked) {
            italicToggle.toggle()
            bi = 0
        }
    }

    private fun resetBoldToggle() {
        if (boldToggle.isChecked) {
            boldToggle.toggle()
            bi = 0
        }
    }

    private fun resetItalicToggle() {
        if (italicToggle.isChecked) {
            italicToggle.toggle()
            bi = 0
        }
    }

    private fun resetBoldItalicToggle() {
        if (boldItalicToggle.isChecked) {
            boldItalicToggle.toggle()
            bi = 0
        }
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }

    private fun toggleButton() {
        val toggle: ToggleButton = findViewById(R.id.boldToggle)
        //val toggle2: ToggleButton = findViewById(R.id.italicToggle)
        toggle.setOnCheckedChangeListener { _, _ ->
            //toggle2.setOnCheckedChangeListener { _, isDone ->

            if (boldToggle.isChecked) {
                resetItalicToggle()
                resetBoldItalicToggle()
                EditText.setTypeface(null, android.graphics.Typeface.BOLD)
            }
            else {
                EditText.setTypeface(null, android.graphics.Typeface.NORMAL)
            }
        }

        val toggle2: ToggleButton = findViewById(R.id.italicToggle)
        toggle2.setOnCheckedChangeListener { _, _ ->
            if (italicToggle.isChecked) {
                resetBoldToggle()
                resetBoldItalicToggle()
                EditText.setTypeface(null, android.graphics.Typeface.ITALIC)
            }
            else {
                EditText.setTypeface(null, android.graphics.Typeface.NORMAL)
            }
        }

        val toggle3: ToggleButton = findViewById(R.id.boldItalicToggle)
        toggle3.setOnCheckedChangeListener { _, _ ->
            if (boldItalicToggle.isChecked) {
                resetBoldToggle()
                resetItalicToggle()
                EditText.setTypeface(null, android.graphics.Typeface.BOLD_ITALIC)
            }
            else {
                EditText.setTypeface(null, android.graphics.Typeface.NORMAL)

            }

        }
    }

    private fun changeColor() {

        val radioBl: RadioButton = findViewById(R.id.colorBlue)
        radioBl.setOnClickListener {

            if (radioBl.isChecked) {
                EditText.setTextColor(Color.BLUE)
            }
        }
        val radioB: RadioButton = findViewById(R.id.colorBlack)
        radioB.setOnClickListener {

            if (radioB.isChecked) {
                EditText.setTextColor(Color.BLACK)
            }
        }
        val radioR: RadioButton = findViewById(R.id.colorRed)
        radioR.setOnClickListener {

            if (radioR.isChecked) {
                EditText.setTextColor(Color.RED)
            }
        }
        val radioG: RadioButton = findViewById(R.id.colorGreen)
        radioG.setOnClickListener {

            if (radioG.isChecked) {
                EditText.setTextColor(Color.GREEN)
            }
        }
    }

    private fun changeSize() {

        sizeButton.setOnClickListener {
            ts += 2F
            EditText.textSize = ts
        }

        sizeMButton.setOnClickListener {
            ts -= 2F
            EditText.textSize = ts
        }
    }


}







