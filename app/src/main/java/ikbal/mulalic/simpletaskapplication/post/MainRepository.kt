package ikbal.mulalic.simpletaskapplication.post

import ikbal.mulalic.data.remote.NetworkState
import ikbal.mulalic.data.ui.Post
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getAllPosts(): Flow<NetworkState<List<Post>>>
}