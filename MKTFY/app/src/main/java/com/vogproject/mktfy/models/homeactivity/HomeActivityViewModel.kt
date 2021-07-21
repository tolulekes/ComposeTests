package com.vogproject.mktfy.models.homeactivity

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.vogproject.mktfy.general.datasource.faq.FAQTopicDataSource
import com.vogproject.mktfy.general.network.APIService

class HomeActivityViewModel(apiService: APIService): ViewModel() {
    val listData = Pager(PagingConfig(pageSize = 1)){
        FAQTopicDataSource(apiService)
    }.flow
}