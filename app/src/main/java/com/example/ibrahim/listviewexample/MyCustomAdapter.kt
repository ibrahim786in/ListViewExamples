package com.example.ibrahim.listviewexample

import android.app.AlertDialog
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.custominflaterlayout.view.*
import java.io.File

class MyCustomAdapter(var files: Array<File>, var customListViewExample: CustomListViewExample) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater = LayoutInflater.from(customListViewExample)
        val viewInf = inflater.inflate(R.layout.custominflaterlayout, null)
        val file = files[position]

//        viewInf.img_preview.setImageURI(Uri.fromFile(file))  //This is to set the Original Image

        val bitmap = BitmapFactory.decodeFile(file.path)
        val img_Thumbnail = ThumbnailUtils.extractThumbnail(bitmap, 80, 80)
        viewInf.img_preview.setImageBitmap(img_Thumbnail)
        viewInf.file_nameTV.text = file.name
        viewInf.file_sizeTV.text = "${file.length() / 1024} KB"
        viewInf.delete_IV.setOnClickListener {

            val alertDialog = AlertDialog.Builder(customListViewExample)

            alertDialog.setTitle("Confirm")
            alertDialog.setMessage("Are You Sure You want to delete this?")
            alertDialog.setPositiveButton("Yes") { dialog, which ->
                file.delete()
                customListViewExample.readFile()
                dialog.dismiss()
            }
            alertDialog.setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            val alertDialogNew: AlertDialog = alertDialog.create()
            alertDialogNew.show()

        }
        return viewInf
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return files.size
    }
}