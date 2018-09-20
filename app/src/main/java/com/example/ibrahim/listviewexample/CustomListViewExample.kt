package com.example.ibrahim.listviewexample

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_custom_list_view_example.*
import java.io.File

class CustomListViewExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view_example)
        val permisStatus = ContextCompat.checkSelfPermission(this@CustomListViewExample, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permisStatus == PackageManager.PERMISSION_GRANTED) readFile()
        else ActivityCompat.requestPermissions(this@CustomListViewExample, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET),7007)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults[0]== PackageManager.PERMISSION_GRANTED) readFile()
        else Toast.makeText(this@CustomListViewExample,"The Permission is denied", Toast.LENGTH_LONG).show()
    }

     fun readFile() {
        var path = "/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
        var file = File(path)
        if (!file.exists()) {
            path = "/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
            file = File(path)
        }

        val files:Array<File> = file.listFiles() //Array String of files
        CustomListView.adapter = MyCustomAdapter(files,this@CustomListViewExample)

    }
}