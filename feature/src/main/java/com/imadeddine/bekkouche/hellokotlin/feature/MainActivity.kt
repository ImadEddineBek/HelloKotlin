package com.imadeddine.bekkouche.hellokotlin.feature

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var imageView:ImageView?=null
    private var btn:Button?=null
    private val CAMERA_REQUEST=123
    private var toolTip:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = pictureIMV
        btn = button
    }
    fun btnClick(view:View){
        toolTip=editText.text.toString()
        imageView!!.tooltipText=toolTip
        var intent:Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,CAMERA_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==CAMERA_REQUEST&&resultCode== Activity.RESULT_OK){
            val photo:Bitmap=data!!.extras.get("data")as Bitmap
            imageView!!.setImageBitmap(photo)
        }
    }
}
