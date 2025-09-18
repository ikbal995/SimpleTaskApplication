package ikbal.mulalic.data.remote.datasource

import ikbal.mulalic.data.remote.ApiService
import ikbal.mulalic.data.remote.NetworkState
import ikbal.mulalic.data.remote.model.toUiModel
import ikbal.mulalic.data.ui.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class GetAllPostsDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun fetch(): Flow<NetworkState<List<Post>>> = flow {
        emit(NetworkState.Loading)
        emit(NetworkState.Success(apiService.getAllPosts().map { it.toUiModel() }
            .filter { it.id < 50 }))
        Timber.e("TEST123 from datasource: ${apiService.getAllPosts()}")
    }.catch { exception ->
        Timber.e("TEST123 got exception ${exception.message}")
        emit(NetworkState.Error(exception))
    }
}