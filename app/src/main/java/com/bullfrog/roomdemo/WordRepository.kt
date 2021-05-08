package com.bullfrog.roomdemo

import androidx.annotation.WorkerThread
import com.bullfrog.roomdemo.dao.WordDao
import com.bullfrog.roomdemo.model.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}