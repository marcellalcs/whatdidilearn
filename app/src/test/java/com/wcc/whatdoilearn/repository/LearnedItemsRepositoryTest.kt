package com.devventure.whatdidilearn.data

import androidx.lifecycle.MutableLiveData
import com.wcc.whatdoilearn.data.LearnedItemDao
import com.wcc.whatdoilearn.data.LearnedItemRepository
import com.wcc.whatdoilearn.entities.LearnedItem
import com.wcc.whatdoilearn.entities.UnderstandingLevel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class LearnedItemRepositoryTest {
    @Mock
    lateinit var dao: LearnedItemDao

    lateinit var repository: LearnedItemRepository

    @Test
    fun `Given itens stored when recover them then should return same form database`() {
        val mockedItems = mockDatabase()
        whenever(dao.getAll()).thenReturn(MutableLiveData(mockedItems))

        repository = LearnedItemRepository(dao)
        val result = repository.learnedItems

        assertEquals(result.value, mockedItems)
    }

    private fun mockDatabase(): List<LearnedItem> {
        return listOf(
            LearnedItem(
                title = "item",
                description = "description",
                understandingLevel = UnderstandingLevel.LOW
            )
        )
    }
}