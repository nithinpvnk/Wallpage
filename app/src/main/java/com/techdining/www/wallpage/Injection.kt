package com.techdining.www.wallpage

import androidx.lifecycle.ViewModelProvider
import com.techdining.www.wallpage.repository.WallpageRepository
import com.techdining.www.wallpage.repository.network.WallpageService
import com.techdining.www.wallpage.viewModel.ViewModelFactory

object Injection {

        /**
         * Creates an instance of [WallpageRepository] based on the [WallpageService]
         */
        private fun provideWallpageRepository(): WallpageRepository {
            return WallpageRepository(WallpageService.create())
        }

        /**
         * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
         * ViewModel objects.
         */
        fun provideViewModelFactory(): ViewModelProvider.Factory {
            return ViewModelFactory(provideWallpageRepository())
        }
}