package com.example.ibrahim.listviewexample

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.custlistvvideo.view.*
import java.io.File

class MyCustomAdapter(var files1: Array<File>, var customListViewExample: CustomListViewExample) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater = LayoutInflater.from(customListViewExample)
//        val viewInf = inflater.inflate(R.layout.cust_list_design_img, null) /* This layout For Custom Adapter for Images with texts*/
        val file1 = files1[position]

        val viewInf = inflater.inflate(R.layout.custlistvvideo, null)

        viewInf.videoView.setVideoURI(Uri.fromFile(file1))
        viewInf.checkbox.text=file1.name
        viewInf.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) viewInf.videoView.start()

            else viewInf.videoView.pause()
        }


//        viewInf.img_preview.setImageURI(Uri.fromFile(file2))  //This is to set the Original Image

        /*val bitmap = BitmapFactory.decodeFile(file1.path)
        val imgThumbnail = ThumbnailUtils.extractThumbnail(bitmap, 60, 60)
        viewInf.img_preview.setImageBitmap(imgThumbnail)
        viewInf.file_nameTV.text = file1.name
        viewInf.file_nameTV.text = file1.name
        viewInf.file_sizeTV.text = "${file1.length() / 1024} KB"

        viewInf.delete_IV.setOnClickListener {
        val alertDialog = AlertDialog.Builder(customListViewExample)

            alertDialog.setTitle("Confirm")
            alertDialog.setMessage("Are You Sure You want to delete this?")
            alertDialog.setPositiveButton("Yes") { dialog, which ->
                file1.delete()
                customListViewExample.readFile()
                dialog.dismiss()
            }
            alertDialog.setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            val alertDialogNew: AlertDialog = alertDialog.create()
            alertDialogNew.show()
        }*/

        return viewInf
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return files1.size

    }
}