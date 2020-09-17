package org.itstep.liannoi.jsoup.application.storage.photos

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import org.itstep.liannoi.jsoup.application.common.interfaces.PhotosRepository
import org.itstep.liannoi.jsoup.application.common.sources.RemoteDataSource
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo
import org.itstep.liannoi.jsoup.application.storage.photos.queries.ListQuery

class DefaultPhotosRepository constructor(
    private val photosRemoteDataSource: RemoteDataSource<Photo, Int>
) : PhotosRepository {

    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun getAll(request: ListQuery, notification: ListQuery.Notification) {
        photosRemoteDataSource.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { notification.onSuccess(it) },
                { notification.onError(it) }
            ).addTo(disposable)
    }

    ///////////////////////////////////////////////////////////////////////////
    // Dispose
    ///////////////////////////////////////////////////////////////////////////

    override fun stop() {
        disposable.clear()
    }

    override fun destroy() {
        disposable.dispose()
    }
}
