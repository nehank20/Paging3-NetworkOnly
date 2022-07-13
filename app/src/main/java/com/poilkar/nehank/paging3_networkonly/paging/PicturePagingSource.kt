package com.poilkar.nehank.paging3_networkonly.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.poilkar.nehank.paging3_networkonly.model.Pictures
import com.poilkar.nehank.paging3_networkonly.retrofit.PictureApi
import java.lang.Exception


class PicturePagingSource (
    private val pictureApi: PictureApi
) : PagingSource<Int, Pictures.Hit>() {
    override fun getRefreshKey(state: PagingState<Int, Pictures.Hit>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pictures.Hit> {
        return try{
            val position = params.key ?: 1
            val response = pictureApi.getPictures(position)
            LoadResult.Page(
                data = response.hits,
                prevKey = if(position == 1) null else position - 1,
                nextKey = if(response.hits.isEmpty()) null else position + 1
            )
        }catch (ex: Exception){
            LoadResult.Error(ex)
        }
    }

}