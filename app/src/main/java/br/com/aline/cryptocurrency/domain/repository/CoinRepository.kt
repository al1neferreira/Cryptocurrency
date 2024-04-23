package br.com.aline.cryptocurrency.domain.repository

import br.com.aline.cryptocurrency.data.dto.CoinDetailDto
import br.com.aline.cryptocurrency.data.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId: String):CoinDetailDto
}