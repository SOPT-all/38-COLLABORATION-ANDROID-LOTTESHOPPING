package org.sopt.lotteshopping.data.repository

import org.sopt.lotteshopping.data.model.Dummy


interface DummyRepository {
    suspend fun getDummy(): Result<Dummy>
}

