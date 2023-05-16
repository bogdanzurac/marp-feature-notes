package dev.bogdanzurac.marp.app.notes

import dev.bogdanzurac.marp.feature.crypto.domain.CryptoAsset
import dev.bogdanzurac.marp.feature.crypto.domain.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.koin.core.annotation.Single

@Single
class DummyCryptoRepository : CryptoRepository {

    override suspend fun getCryptoAsset(id: String): Result<CryptoAsset> =
        Result.failure(NotImplementedError())

    override suspend fun getCryptoAssets(refresh: Boolean): Result<List<CryptoAsset>> =
        Result.failure(NotImplementedError())

    override fun observeCryptoAsset(id: String): Flow<Result<CryptoAsset>> = emptyFlow()

    override fun observeCryptoAssets(): Flow<Result<List<CryptoAsset>>> = emptyFlow()
}