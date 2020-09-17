package org.itstep.liannoi.jsoup.application.core.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.itstep.liannoi.jsoup.application.common.sources.RemoteDataSource
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo
import org.itstep.liannoi.jsoup.application.storage.photos.sources.UnsplashRemoteDataSource
import org.itstep.liannoi.jsoup.application.storage.photos.sources.WikipediaRemoteDataSource
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class PhotosRemoteSource

    @Singleton
    @PhotosRemoteSource
    @Provides
    fun providePhotosRemoteDataSource(): RemoteDataSource<Photo, Int> = UnsplashRemoteDataSource()
}
