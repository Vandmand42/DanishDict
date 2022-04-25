package com.dtn.danishdict.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "dictionary_table", indices = [Index(value = ["danish", "english"], unique = true)])
data class Dictionary(

    @ColumnInfo(name = "danish")
    val danish: String,
    @ColumnInfo(name = "english")
    val english: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "vocab_id")
    val id: Int = 0
    )