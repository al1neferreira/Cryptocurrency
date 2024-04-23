package br.com.aline.cryptocurrency.domain.use_case.get_coin

import br.com.aline.cryptocurrency.common.Resource
import br.com.aline.cryptocurrency.data.dto.toCoin
import br.com.aline.cryptocurrency.data.dto.toCoinDetail
import br.com.aline.cryptocurrency.domain.Coin
import br.com.aline.cryptocurrency.domain.model.CoinDetail
import br.com.aline.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource. Success(coin))

        }catch (e: retrofit2.HttpException){
            emit(Resource.Error(e.localizedMessage ?:"An unexpected error occurred"))

        }catch (e:IOException){

            emit(Resource.Error("Couldn't reach server. Check your internet connection"))

        }
    }
}