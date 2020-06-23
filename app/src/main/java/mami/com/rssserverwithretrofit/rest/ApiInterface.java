package mami.com.rssserverwithretrofit.rest;

import mami.com.rssserverwithretrofit.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("{con}/apple-music/coming-soon/all/{num}/explicit.json")
    Call<MovieResponse> getResponse(@Path("con") String country,@Path("num") int num);



}
