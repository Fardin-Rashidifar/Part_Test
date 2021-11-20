package f.r.parttest.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import f.r.parttest.R
import f.r.parttest.dataClass.Data
import f.r.parttest.helper.ImageDownloader


class UserListAdapter(private val activity:Activity,private val dataSet: ArrayList<Data>) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imgCircle: ImageView
        val clRecTopSheet: ConstraintLayout

        init {
            textView = view.findViewById(R.id.tvCircleName)
            imgCircle = view.findViewById(R.id.imgCircle)
            clRecTopSheet = view.findViewById(R.id.clRecTopSheet)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_rec_user_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.textView.text = dataSet[position].last_name
        ImageDownloader.initGlideForImage(activity,dataSet[position].avatar,viewHolder.imgCircle)


    }

    override fun getItemCount() = dataSet.size

    fun updateData(newList: ArrayList<Data>) {
        dataSet.clear()
        dataSet.addAll(newList)
        notifyDataSetChanged()
    }

}