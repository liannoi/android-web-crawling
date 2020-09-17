package org.itstep.liannoi.jsoup.application.common.interfaces

import org.itstep.liannoi.jsoup.application.common.storage.Disposable
import org.itstep.liannoi.jsoup.application.storage.photos.queries.ListQuery

interface PhotosRepository : Disposable {

    fun getAll(request: ListQuery, notification: ListQuery.Notification)
}
