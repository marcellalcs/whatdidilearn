package com.wcc.whatdoilearn

import android.app.Application
import com.wcc.whatdoilearn.data.LearnedItemRepository
import com.wcc.whatdoilearn.data.LearnedItemsDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class WhatDidILearnApplication: Application() {
    val database by lazy {
        LearnedItemsDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO))
    }

    val repository by lazy {
        LearnedItemRepository(database.learnedItemDao())
    }
}