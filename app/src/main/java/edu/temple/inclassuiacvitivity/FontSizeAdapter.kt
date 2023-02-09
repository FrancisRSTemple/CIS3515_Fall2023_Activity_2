package edu.temple.inclassuiacvitivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class FontSizeAdapter(_context : Context, _sizes: Array<Int>) : BaseAdapter() {

    private val context = _context
    private val fontSizes = _sizes

    /*
    more often use case: how many elements are in this adapter?

    what this really asks: How many views can this adapter generate?

    can use this one line thing if you're strictly returning 1 single value and doing nothing else
     */
    override fun getCount() = fontSizes.size

    /*
    return item at particular index
     */
    override fun getItem(position: Int) = fontSizes[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return (getDropDownView(position, convertView, parent) as TextView).apply{
            textSize = 24f
        }
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView: TextView

        if(convertView == null){
            textView = TextView(context)
            textView.setPadding(20, 20, 0, 20)
        }else{
            textView = convertView as TextView
        }

        textView.text = fontSizes[position].toString()
        textView.textSize = fontSizes[position].toFloat()

        return textView
    }
}