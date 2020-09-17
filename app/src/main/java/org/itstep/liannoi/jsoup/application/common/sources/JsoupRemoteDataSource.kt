package org.itstep.liannoi.jsoup.application.common.sources

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

abstract class JsoupRemoteDataSource<TEntity, TKey> constructor(
    private val url: String
) : RemoteDataSource<TEntity, TKey> {

    protected val connectedSource: Document
        get() = Jsoup.connect(url).get()
}
