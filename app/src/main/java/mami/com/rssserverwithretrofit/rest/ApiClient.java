package mami.com.rssserverwithretrofit.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    static String base_url = "https://rss.itunes.apple.com/api/v1/";
    static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        if(retrofit ==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
