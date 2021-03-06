package com.dtn.danishdict.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DictionaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVocabulary(dictionary: Dictionary)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateVocabulary(dictionary: Dictionary)

    // Remove this since it makes no sense
    @Delete
    suspend fun deleteVocabulary(dictionary: Dictionary)

    @Query("SELECT * FROM dictionary_table WHERE vocab_id == danish")
    fun getVocabulary(): Flow<Dictionary>

    @Query("SELECT * FROM dictionary_table ORDER BY danish COLLATE NOCASE ASC")
    fun getDanish(): Flow<MutableList<Dictionary>>

    @Query("SELECT * FROM dictionary_table GROUP BY english ORDER BY danish COLLATE NOCASE ASC")
    fun getEnglish(): Flow<MutableList<Dictionary>>

//    @Query("SELECT * FROM dictionary_table WHERE danish LIKE 'A%' ORDER BY danish COLLATE NOCASE ASC")
//    fun getDanishA(): Flow<MutableList<Dictionary>>
//
//    @Query("SELECT * FROM dictionary_table WHERE danish LIKE 'A%' GROUP BY english ORDER BY danish COLLATE NOCASE ASC")
//    fun getEnglishA(): Flow<MutableList<Dictionary>>
//
//    @Query("SELECT * FROM dictionary_table WHERE danish LIKE 'B%' ORDER BY danish COLLATE NOCASE ASC")
//    fun getDanishB(): Flow<MutableList<Dictionary>>
//
//    @Query("SELECT * FROM dictionary_table WHERE danish LIKE 'B%' GROUP BY english ORDER BY danish COLLATE NOCASE ASC")
//    fun getEnglishB(): Flow<MutableList<Dictionary>>
}