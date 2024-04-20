package br.com.aline.cryptocurrency.domain.model

import android.media.audiofx.AudioEffect.Descriptor
import br.com.aline.cryptocurrency.data.dto.CoinDetailDto
import br.com.aline.cryptocurrency.data.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>


)

fun CoinDetailDto.toCoinDetailDto(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}
