package com.techdining.www.wallpage.viewModel

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.techdining.www.wallpage.dataModel.PhotoItems
import com.techdining.www.wallpage.repository.WallpageRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class HomeViewModel(private val wallpageRepository: WallpageRepository) : ViewModel() {
    init {
        Timber.i("HomeViewModel is created")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private var currentResult: Flow<PagingData<PhotoItems>>? = null

    fun photosToBeDisplayed(): Flow<PagingData<PhotoItems>> {
        val lastResult = currentResult
        val newResult: Flow<PagingData<PhotoItems>> =
            wallpageRepository.getPhotoStream().cachedIn(viewModelScope)
        currentResult = newResult
        return newResult
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("HomeViewModel is cleared")
    }
}

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val repository: WallpageRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}