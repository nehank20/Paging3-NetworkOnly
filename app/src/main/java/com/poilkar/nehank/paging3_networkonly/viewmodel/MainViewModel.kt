package com.poilkar.nehank.paging3_networkonly.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.poilkar.nehank.paging3_networkonly.repo.PictureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    pictureRepository: PictureRepository
) : ViewModel() {

    val result = pictureRepository.getQuotes().cachedIn(viewModelScope)
}