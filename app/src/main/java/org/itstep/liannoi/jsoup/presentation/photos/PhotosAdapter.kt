package org.itstep.liannoi.jsoup.presentation.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo
import org.itstep.liannoi.jsoup.databinding.ItemPhotoBinding

class PhotosAdapter constructor(
    private val viewModel: PhotosViewModel
) : ListAdapter<Photo, PhotosAdapter.ViewHolder>(PhotoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel, getItem(position))
    }

    ///////////////////////////////////////////////////////////////////////////
    // Nested classes
    ///////////////////////////////////////////////////////////////////////////

    class ViewHolder private constructor(
        private val binding: ItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: PhotosViewModel, photo: Photo) {
            binding.viewmodel = viewModel
            binding.photo = photo
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder = ViewHolder(
                ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}
