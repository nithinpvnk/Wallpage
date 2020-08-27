package com.techdining.www.wallpage.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.techdining.www.wallpage.dataModel.PhotoItems
import com.techdining.www.wallpage.paging.WallpagePagingSource
import com.techdining.www.wallpage.repository.network.WallpageService
import kotlinx.coroutines.flow.Flow

class WallpageRepository(private val service: WallpageService) {

    fun getPhotoStream(): Flow<PagingData<PhotoItems>> {
        return Pager(
            config =
            PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { WallpagePagingSource(service) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }
}