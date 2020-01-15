package com.cnm.homework.data.source.local

import androidx.lifecycle.LiveData
import com.cnm.homework.data.source.local.db.LocalEntity
import io.reactivex.Single

interface NaverQueryLocalDataSource {
    fun saveCacheMovie(localEntity: LocalEntity) : Single<Unit>

    fun loadLocal(): LiveData<List<LocalEntity>>
}