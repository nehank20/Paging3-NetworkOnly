package com.poilkar.nehank.paging3_networkonly.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.poilkar.nehank.paging3_networkonly.paging.PicturePagingSource
import com.poilkar.nehank.paging3_networkonly.retrofit.PictureApi
import javax.inject.Inject

class PictureRepository @Inject constructor(
    val pictureApi: PictureApi
){


    fun getQuotes() = Pager(
        config = PagingConfig(
            pageSize = 10,
            maxSize = 50
        ),
        pagingSourceFactory = {
            PicturePagingSource(pictureApi)
        }
    ).flow

}
