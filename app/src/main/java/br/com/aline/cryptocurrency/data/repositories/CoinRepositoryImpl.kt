package br.com.aline.cryptocurrency.data.repositories

import br.com.aline.cryptocurrency.data.dto.CoinDetailDto
import br.com.aline.cryptocurrency.data.dto.CoinDto
import br.com.aline.cryptocurrency.data.remote.CoinPaprikaApi
import br.com.aline.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}