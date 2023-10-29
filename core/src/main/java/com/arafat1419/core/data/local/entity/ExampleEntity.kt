package com.arafat1419.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "example_entity")
internal data class ExampleEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,
)
