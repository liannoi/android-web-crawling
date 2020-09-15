package org.itstep.liannoi.jsoup.presentation.common.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo
import org.itstep.liannoi.jsoup.presentation.photos.PhotosAdapter

@BindingAdapter("app:items")
fun RecyclerView.adapt(items: List<Photo>?) {
    items?.let { (adapter as PhotosAdapter).submitList(items) }
}
