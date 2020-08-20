package ru.makskol.jokes.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.makskol.jokes.pojo.Joke
import ru.makskol.jokes.pojo.JokesResponse

interface ApiService {

    @GET("random/{count}")
    fun getJokes(@Path("count") count: String,
                 @Query("firstName") firstName: String = "Chuck",
                 @Query("lastName") lastName: String = "Norris"): Single<JokesResponse>

}