package org.itstep.liannoi.jsoup.application.storage.photos.queries

import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo

class ListQuery {

    interface Notification {

        fun onSuccess(photos: List<Photo>)

        fun onError(throwable: Throwable)
    }

    abstract class NotificationHandler : Notification {

        override fun onSuccess(photos: List<Photo>) {
            /* no-op */
        }

        override fun onError(throwable: Throwable) {
            /* no-op */
        }
    }
}
