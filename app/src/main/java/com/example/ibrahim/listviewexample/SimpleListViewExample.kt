package com.example.ibrahim.listviewexample

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_simple_list_view_example.*
import java.io.File

class SimpleListViewExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_view_example)
        val permisStatus = ContextCompat.checkSelfPermission(this@SimpleListViewExample, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (permisStatus == PackageManager.PERMISSION_GRANTED) readFile()
        else ActivityCompat.requestPermissions(this@SimpleListViewExample, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET),7007)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults[0]== PackageManager.PERMISSION_GRANTED) readFile()
        else Toast.makeText(this@SimpleListViewExample,"The Permission is denied", Toast.LENGTH_LONG).show()
    }

    private fun readFile() {
        var path = "/storage/sdcard0/"
        var file = File(path)
        if (!file.exists()) {
            path = "/storage/emulated/0/"
            file = File(path)
        }
        val files = file.list() //Array String of files
        val adapter = ArrayAdapter<String>(this@SimpleListViewExample, R.layout.textviewdesign, files)
        simpleListView.adapter = adapter

    }
}
