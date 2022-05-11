package com.example.myshoeapp.model

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myshoeapp.R


class MyCustomView(context: Context?): LinearLayout(context) {
    private lateinit var d: TextView
    private lateinit var n: TextView
    private lateinit var c: TextView
    private lateinit var s: TextView

    init {
        orientation = VERTICAL
        initialize()
    }

    private fun initialize() {
        //val inflater =  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater  //1
        //val inflater = LayoutInflater.from(context)  //2

        //inflater.inflate(R.layout.my_custom_view,this, true)
        inflate(context, R.layout.my_custom_view, this)

        //u should use Binding maybe..
        d = findViewById(R.id.descr_view)
        n = findViewById(R.id.name_view)
        c = findViewById(R.id.company_view)
        s = findViewById(R.id.size_view)
    }

    fun setDescription(description: String) {
        val text = String.format(resources.getString(R.string.description_text_view), description)
        d.text = text
    }

    fun setCompanyName(company: String) {
        val text = String.format(resources.getString(R.string.company_text_view), company)
        c.text = text
    }

    fun setShoeName(name: String) {
        val text = String.format(resources.getString(R.string.name_text_view), name)
        n.text = text
    }

    fun setShoeSize(size: Double) {
        //u should convert this value into the ViewModel I think..
        val sizeToString = size.toString()
        val text = String.format(resources.getString(R.string.size_text_view), sizeToString)
        s.text = text
    }
}