package ikbal.mulalic.simpletaskapplication.post

import ikbal.mulalic.data.remote.NetworkState
import ikbal.mulalic.data.remote.datasource.GetAllPostsDataSource
import ikbal.mulalic.data.ui.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val getAllPostsDataSource: GetAllPostsDataSource
) : MainRepository {
    override suspend fun getAllPosts(): Flow<NetworkState<List<Post>>> =
        getAllPostsDataSource.fetch()
}