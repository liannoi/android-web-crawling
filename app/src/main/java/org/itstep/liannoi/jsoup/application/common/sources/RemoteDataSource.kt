package org.itstep.liannoi.jsoup.application.common.sources

import io.reactivex.rxjava3.core.Single
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo

interface RemoteDataSource<TEntity, TKey> {

    fun getAll(): Single<List<Photo>>
}
