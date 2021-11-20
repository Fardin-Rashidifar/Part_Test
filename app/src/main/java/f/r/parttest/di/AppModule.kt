package f.r.parttest.di

import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import f.r.parttest.androidWrapper.G
import f.r.parttest.local.db.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
    ) = Room.databaseBuilder(
        G.instance,
        AppDatabase::class.java,
        "AppLocalData"
    ).build()
}