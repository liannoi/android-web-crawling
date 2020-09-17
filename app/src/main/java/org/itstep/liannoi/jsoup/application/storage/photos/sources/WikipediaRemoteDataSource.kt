package org.itstep.liannoi.jsoup.application.storage.photos.sources

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import org.itstep.liannoi.jsoup.application.ApplicationDefaults
import org.itstep.liannoi.jsoup.application.common.sources.JsoupRemoteDataSource
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo

class WikipediaRemoteDataSource :
    JsoupRemoteDataSource<Photo, Int>(ApplicationDefaults.URL_WIKIPEDIA) {

    override fun getAll(): Single<List<Photo>> =
        Observable.fromCallable { connectedSource.select(".central-featured-logo").eachAttr("src") }
            .flatMapIterable { it }
            .map { Photo("${ApplicationDefaults.URL_WIKIPEDIA}$it", 0) }
            .toList()
}
