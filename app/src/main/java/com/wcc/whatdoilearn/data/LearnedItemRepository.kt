package com.wcc.whatdoilearn.data

import androidx.lifecycle.LiveData
import com.wcc.whatdoilearn.entities.LearnedItem

class LearnedItemRepository(private val dao: LearnedItemDao) {
    val learnedItems: LiveData<List<LearnedItem>> = dao.getAll()

    suspend fun addNewItem(item: LearnedItem) {
        dao.insert(item)
    }
}