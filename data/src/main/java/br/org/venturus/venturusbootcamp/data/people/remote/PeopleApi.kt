package br.org.venturus.venturusbootcamp.data.people.remote

import io.reactivex.Single
import retrofit2.http.GET

interface PeopleApi {

    @GET("/prod/users")
    fun getPeople(): Single<PeopleResponse>

    companion object Factory {
        const val BASE_URL = " https://xctndp5sg8.execute-api.us-east-1.amazonaws.com/"
    }
}
