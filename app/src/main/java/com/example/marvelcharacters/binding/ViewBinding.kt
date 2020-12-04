package com.example.marvelcharacters.binding

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.marvelcharacters.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("characterImage")
fun setCharacterImage(imageView: AppCompatImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .timeout(15000)
        .apply(
            RequestOptions()
                .error(R.mipmap.ic_launcher)
                .fitCenter()
        )
        .fitCenter()
        .into(imageView)
}
@BindingAdapter("generatingDate")
fun setModify(textView: TextView,modify: String?){
    val originalFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss-SSSS")
    val targetFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
    val date: Date = originalFormat.parse(modify)
    val formattedDate: String = targetFormat.format(date)

    textView.text= formattedDate
}
