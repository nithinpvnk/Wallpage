package com.techdining.www.wallpage.paging

import androidx.paging.PagingSource
import com.techdining.www.wallpage.dataModel.PhotoItems
import com.techdining.www.wallpage.repository.network.WallpageService
import retrofit2.HttpException
import java.io.IOException

class WallpagePagingSource(
    private val wallpageService: WallpageService
) : PagingSource<Int, PhotoItems>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoItems> {
        val position = params.key ?: START_INDEX
        return try {
            val response = wallpageService.displayPhotos(position, params.loadSize)
            LoadResult.Page(
                data = response,
                prevKey = if (position == START_INDEX) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val START_INDEX = 1
    }
}