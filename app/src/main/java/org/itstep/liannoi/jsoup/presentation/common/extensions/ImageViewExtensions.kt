package org.itstep.liannoi.jsoup.presentation.common.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:src")
fun ImageView.load(src: String) {
    Picasso.get().load(src).into(this)
}
