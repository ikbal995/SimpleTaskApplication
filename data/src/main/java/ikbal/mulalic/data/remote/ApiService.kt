package ikbal.mulalic.data.remote

import ikbal.mulalic.data.remote.model.PostEntity
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getAllPosts(): List<PostEntity>
}