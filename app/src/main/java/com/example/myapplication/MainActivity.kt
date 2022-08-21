package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var tvMouseQty: TextView
    private lateinit var tvMousePrice: TextView

    private lateinit var btnPlusKeyboard: Button
    private lateinit var btnMinusKeyboard: Button
    private lateinit var tvKeyboardQty: TextView
    private lateinit var tvKeyboardPrice: TextView

    //lateinit don't define a value immediately, but it causes an error if we start the app

    private var mouseQty: Int = 0
    private var mousePrice: Double = 20.55

    private var KeyboardQty: Int = 0
    private var KeyboardPrice: Double = 39.99

    private lateinit var btnCloseDeal : Button
    private lateinit var tvTotal: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settings()
    }

    private fun settings() {
        viewsStart()
        setButtons()
        setPrices()

    }

    private fun setPrices() {

        tvMousePrice.text = mousePrice.toString()
        tvKeyboardPrice.text = KeyboardPrice.toString()
    }

    private fun viewsStart() {
        //If we use the lateinit, we have to declare the values before start the app.
        btnPlus = findViewById(R.id.btn_plus)  //represents the btn_plus on screen
        btnMinus = findViewById(R.id.btn_minus) //represents the btn_minus on screen
        tvMouseQty = findViewById(R.id.tv_mouse_qty) //represents the tv_mouse_qty on screen
        tvMousePrice = findViewById(R.id.mousePrice)

        btnPlusKeyboard = findViewById(R.id.btn_plus_Keyboard)
        btnMinusKeyboard = findViewById(R.id.btn_minus_Keyboard)
        tvKeyboardQty = findViewById(R.id.tv_Keyboard_qty)
        tvKeyboardPrice = findViewById(R.id.keyboardPrice)

        tvTotal = findViewById(R.id.tv_total)
        btnCloseDeal = findViewById(R.id.btn_deal)


    }

    private fun setButtons() {
        btnPlus.setOnClickListener {
            mouseAdd()
        }
        btnMinus.setOnClickListener {
            mouseSub()
        }
        btnPlusKeyboard.setOnClickListener {
            keyboardAdd()
        }
        btnMinusKeyboard.setOnClickListener {
            keyboardSub()
        }
        btnCloseDeal.setOnClickListener{
            closeDeal()
        }
    }

    //Creates a function to increment the mouse qty
    private fun mouseAdd() {
        mouseQty++
        tvMouseQty.text = mouseQty.toString()
    }

    //Creates a function to decrement the mouse qty
    private fun mouseSub() {
        if (mouseQty > 0) {
            mouseQty--
        }
        tvMouseQty.text = mouseQty.toString()
    }

    //Creates a function to increment the keyboard qty
    private fun keyboardAdd() {
        KeyboardQty++
        tvKeyboardQty.text = KeyboardQty.toString()
    }

    //Creates a function to decrement the mouse qty
    private fun keyboardSub() {
        if (KeyboardQty > 0) {
            KeyboardQty--
        }
        tvKeyboardQty.text = KeyboardQty.toString()
    }

    private fun closeDeal(){
        val total = mouseQty * mousePrice + KeyboardQty * KeyboardPrice
        tvTotal.text = "Total: $ ${"%.2f".format( total ) }"

    }


}