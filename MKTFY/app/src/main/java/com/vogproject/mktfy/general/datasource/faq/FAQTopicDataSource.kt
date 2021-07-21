package com.vogproject.mktfy.general.datasource.faq

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vogproject.mktfy.general.network.APIService
import com.vogproject.mktfy.models.faq.FAQTopic
import java.lang.Exception

class FAQTopicDataSource(private val apiService: APIService): PagingSource<Int, FAQTopic>() {
    override fun getRefreshKey(state: PagingState<Int, FAQTopic>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FAQTopic> {
       return try {
           val currentLoadingPageKey = params.key?:1
           val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey -1
           val faqT = apiService.getJoke("pun", "nsfw")
           LoadResult.Page(
               data = listOf(faqT),
               prevKey = prevKey,
               nextKey = currentLoadingPageKey.plus(1)
           )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}