package org.itstep.liannoi.jsoup.application.storage.photos.sources

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import org.itstep.liannoi.jsoup.application.ApplicationDefaults
import org.itstep.liannoi.jsoup.application.common.sources.JsoupRemoteDataSource
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo

class UnsplashRemoteDataSource :
    JsoupRemoteDataSource<Photo, Int>(ApplicationDefaults.URL_UNSPLASH_FOREST) {

    override fun getAll(): Single<List<Photo>> =
        Observable.fromCallable { connectedSource.getElementsByTag("img").eachAttr("src") }
            .flatMapIterable { it }
            .map { Photo(0, it) }
            .toList()
}
