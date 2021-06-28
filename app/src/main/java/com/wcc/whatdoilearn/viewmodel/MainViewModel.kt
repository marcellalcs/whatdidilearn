package com.wcc.whatdoilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wcc.whatdoilearn.data.LearnedItemRepository
import com.wcc.whatdoilearn.entities.LearnedItem

class MainViewModel(private val repository: LearnedItemRepository): ViewModel() {
    val learnedItems: LiveData<List<LearnedItem>> = repository.learnedItems
}