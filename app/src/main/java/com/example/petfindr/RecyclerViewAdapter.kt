import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.petfindr.R

import java.util.ArrayList

import de.hdodenhof.circleimageview.CircleImageView


class RecyclerViewAdapter(
    private val mContext: Context,
    imageNames: ArrayList<String>,
    images: ArrayList<String>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var mImageNames = ArrayList<String>()
    private var mImages = ArrayList<String>()

    init {
        this.mImageNames = imageNames
        this.mImages = images
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")

        Glide.with(mContext)
            .asBitmap()
            .load(mImages[position])
            .into(holder.image)

        holder.imageName.text = mImageNames[position]

        //onclick listener to have toast pop out
        holder.parentLayout.setOnClickListener {
            Log.d(TAG, "onClick: clicked on: " + mImageNames[position])

            Toast.makeText(mContext, mImageNames[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return mImageNames.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var image: CircleImageView
        internal var imageName: TextView
        internal var parentLayout: RelativeLayout

        init {
            image = itemView.findViewById(R.id.image)
            imageName = itemView.findViewById(R.id.image_name)
            parentLayout = itemView.findViewById(R.id.parent_layout)
        }
    }

    companion object {
        private val TAG = "RecyclerViewAdapter"
    }
}

