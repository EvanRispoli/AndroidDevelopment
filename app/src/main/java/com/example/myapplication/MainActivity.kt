package com.example.myapplication

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var btn_plus:Button;
    lateinit var btn_minus:Button;
    lateinit var tv_mouse_qty: TextView;
    //lateinit don't define a value immediately, but it causes an error if we start the app

    var mouseQty: Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       settings()
    }

    fun settings(){
        viewsStart()
        setButtons()

    }
    fun viewsStart(){
        btn_plus = findViewById(R.id.btn_plus);  //represents the btn_plus on screen
        btn_minus = findViewById(R.id.btn_minus); //represents the btn_minus on screen
        tv_mouse_qty = findViewById(R.id.tv_mouse_qty); //represents the tv_mouse_qty on screen
        //If we use the lateinit, we have to declare the values before start the app.
    }

    fun setButtons(){
        btn_plus.setOnClickListener{
            mouseAdd();
        }
        btn_minus.setOnClickListener{
            mouseSub();
        }
    }

    //Creates a function to increment the mouse qty
    fun mouseAdd(){
        mouseQty++;
        tv_mouse_qty.text = mouseQty.toString();
    }
    //Creates a function to decrement the mouse qty
    fun mouseSub(){
        if (mouseQty == 0){
            mouseQty = 0;
        }else {
            mouseQty--;
        }
        tv_mouse_qty.text = mouseQty.toString();
    }


}