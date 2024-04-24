package br.com.aline.cryptocurrency.presentation.coin_detail

import br.com.aline.cryptocurrency.domain.Coin
import br.com.aline.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
