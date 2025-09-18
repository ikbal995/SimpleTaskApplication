package ikbal.mulalic.data.remote.datasource

import ikbal.mulalic.data.remote.NetworkState
import kotlinx.coroutines.flow.Flow

abstract class DataSource<RM, T>() {
    abstract suspend fun fetch(requestModel: RM): Flow<NetworkState<T>>
}