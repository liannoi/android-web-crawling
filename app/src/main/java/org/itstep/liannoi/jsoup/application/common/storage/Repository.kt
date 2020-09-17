package org.itstep.liannoi.jsoup.application.common.storage

interface Repository<TAllRequest, TAllNotification> {

    fun getAll(request: TAllRequest, notification: TAllNotification)
}
