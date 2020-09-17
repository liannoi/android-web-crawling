package org.itstep.liannoi.jsoup.application.core.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.itstep.liannoi.jsoup.application.common.interfaces.PhotosRepository
import org.itstep.liannoi.jsoup.application.common.sources.RemoteDataSource
import org.itstep.liannoi.jsoup.application.storage.photos.DefaultPhotosRepository
import org.itstep.liannoi.jsoup.application.storage.photos.models.Photo
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object PhotosRepositoryModule {

    @Singleton
    @Provides
    fun providePhotosRepository(@ApplicationModule.PhotosRemoteSource remoteDataSource: RemoteDataSource<Photo, Int>): PhotosRepository =
        DefaultPhotosRepository(remoteDataSource)
}
