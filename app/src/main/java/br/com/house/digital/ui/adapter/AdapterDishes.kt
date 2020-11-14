package br.com.house.digital.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.house.digital.R
import br.com.house.digital.model.Dish

internal class AdapterDishes(
    private val context: Context,
    private val listDishes: ArrayList<Dish>,
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun getCount(): Int {
        return listDishes.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View? {
        var convertView = convertView

        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.grid_sigle_dishis, null)
        }

        imageView = convertView!!.findViewById(R.id.imageViewDish)
        textView = convertView.findViewById(R.id.textViewDish)

        imageView.setImageResource(listDishes[position].resourceImage)
        textView.text = listDishes[position].name

        return convertView
    }
}