package br.com.aline.cryptocurrency.domain.use_case.get_coins

import br.com.aline.cryptocurrency.common.Resource
import br.com.aline.cryptocurrency.data.dto.toCoin
import br.com.aline.cryptocurrency.domain.Coin
import br.com.aline.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource. Success(coins))

        }catch (e: retrofit2.HttpException){
            emit(Resource.Error(e.localizedMessage ?:"An unexpected error occurred"))

        }catch (e:IOException){

            emit(Resource.Error("Couldn't reach server. Check your internet connection"))

        }
    }
}