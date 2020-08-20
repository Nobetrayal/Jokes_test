package ru.makskol.jokes.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.makskol.jokes.pojo.JokesResponse

interface ApiService {

    @GET("random/{count}")
    fun getJokes(@Path(ApiConstants.PARAMETER_COUNT) count: String,
                 @Query(ApiConstants.PARAMETER_FIRST_NAME) firstName: String = ApiConstants.CHARACTER_NAME,
                 @Query(ApiConstants.PARAMETER_lAST_NAME) lastName: String = ApiConstants.CHARACTER_LAST_NAME): Single<JokesResponse>

}