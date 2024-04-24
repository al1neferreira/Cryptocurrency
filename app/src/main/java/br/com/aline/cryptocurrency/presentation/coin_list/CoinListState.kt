package br.com.aline.cryptocurrency.presentation.coin_list

import br.com.aline.cryptocurrency.domain.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
