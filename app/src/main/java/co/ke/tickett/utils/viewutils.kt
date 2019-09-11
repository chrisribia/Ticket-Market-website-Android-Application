package co.ke.tickett.utils

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toast(message :String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}

fun ProgressBar.show(){
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    visibility = View.GONE
}

fun Button.show(){
    visibility = View.VISIBLE
}

fun Button.hide(){
    visibility = View.GONE
}