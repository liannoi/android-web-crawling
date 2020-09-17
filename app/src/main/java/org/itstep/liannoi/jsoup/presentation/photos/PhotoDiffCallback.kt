package org.itstep.liannoi.jsoup.presentation.photos

import androidx.recyclerview.widget.DiffUtil
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo

class PhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {

    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
        oldItem.photoId == newItem.photoId

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
        oldItem == newItem
}
