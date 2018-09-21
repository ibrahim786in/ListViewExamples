package com.example.ibrahim.listviewexample

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.video_listview_design.*
import java.io.File

class CustomListViewExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_custom_list_view_example) /* This layout For Custom Adapter for Images with texts*/
        setContentView(R.layout.video_listview_design)
        val permisStatus = ContextCompat.checkSelfPermission(this@CustomListViewExample,Manifest.permission.READ_EXTERNAL_STORAGE)
        if (permisStatus == PackageManager.PERMISSION_GRANTED) readFile()
        else ActivityCompat.requestPermissions(this@CustomListViewExample, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET), 7007)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) readFile()
        else Toast.makeText(this@CustomListViewExample, "The Permission is denied", Toast.LENGTH_LONG).show()
    }

    fun readFile() {
        var path1 = "/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
        var path2 = "/storage/sdcard0/"
        var path3 = "/storage/sdcard0/WhatsApp/Media/WhatsApp Video/"

        var file1 = File(path1)
        var file2 = File(path2)
        var file3 = File(path3)

        if (!file1.exists()) {
            path1 = "/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
            file1 = File(path1)
        }

        if (!file2.exists()) {
            path2 = "/storage/emulated/0/"
            file2 = File(path2)
        }
        if (!file3.exists()) {
            path3 = "/storage/emulated/0/WhatsApp/Media/WhatsApp Video/"
            file3 = File(path3)
        }

        val files1: Array<File> = file1.listFiles() //Array of files

        val files3: Array<File> = file3.listFiles() //Array of files

        val files2: Array<String> = file2.list() //Array of String

        gallery.adapter=MyCustomAdapter(files3,this) //For Video list

//        listVfrmCustLay.adapter = MyCustomAdapter(files1, this@CustomListViewExample)

    }
}