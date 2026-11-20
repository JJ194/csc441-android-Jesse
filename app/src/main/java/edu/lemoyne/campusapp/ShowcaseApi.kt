package edu.lemoyne.campusapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface ShowcaseApi {
    @GET( value = "/rest/v1/showcase_items")
    suspend fun getShowcaseItems(
        @Header ( value = "apikey") apiKey: String

    ): List<ShowcaseItem>
}

object ShowcaseService {
    const val API_KEY = "sb_publishable_2pp8Aaqqipp7r5crRqDgPQ_fi1u-GCj"
    const val BASE_URL = "https://rmsswcnahxnapmljvflw.supabase.co"

    val api: ShowcaseApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ShowcaseApi::class.java)
}