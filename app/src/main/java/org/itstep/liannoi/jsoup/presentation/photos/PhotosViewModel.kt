package org.itstep.liannoi.jsoup.presentation.photos

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.itstep.liannoi.jsoup.application.common.interfaces.PhotosRepository
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo
import org.itstep.liannoi.jsoup.application.storage.photos.queries.ListQuery

class PhotosViewModel @ViewModelInject constructor(
    private val photosRepository: PhotosRepository
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _photos: MutableLiveData<List<Photo>> = MutableLiveData()
    val photos: LiveData<List<Photo>> = _photos

    init {
        getAllPhotos()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Dispose
    ///////////////////////////////////////////////////////////////////////////

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
        disposable.dispose()
        photosRepository.stop()
        photosRepository.destroy()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private fun getAllPhotos() {
        photosRepository.getAll(ListQuery(), ListQueryHandler())
    }

    ///////////////////////////////////////////////////////////////////////////
    // Companion object
    ///////////////////////////////////////////////////////////////////////////

    companion object {
        private const val TAG: String =
            "org.itstep.liannoi.jsoup.presentation.photos.PhotosViewModel"
    }

    ///////////////////////////////////////////////////////////////////////////
    // Internal members
    ///////////////////////////////////////////////////////////////////////////

    private inner class ListQueryHandler : ListQuery.NotificationHandler() {

        override fun onSuccess(photos: List<Photo>) {
            _photos.value = photos
        }

        override fun onError(throwable: Throwable) {
            Log.d(TAG, "onPhotosFetchedError: " + throwable.message)
        }
    }
}
