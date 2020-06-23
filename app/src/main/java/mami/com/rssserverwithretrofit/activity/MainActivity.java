package mami.com.rssserverwithretrofit.activity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import mami.com.rssserverwithretrofit.R;
import mami.com.rssserverwithretrofit.adapter.MyAdapter;
import mami.com.rssserverwithretrofit.model.Album;
import mami.com.rssserverwithretrofit.model.MovieResponse;
import mami.com.rssserverwithretrofit.model.feed;
import mami.com.rssserverwithretrofit.rest.ApiClient;
import mami.com.rssserverwithretrofit.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ApiInterface apiService;
    RecyclerView recyclerView;
    String[] urls ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.textView);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        getRequest();
    }
    public  void  getRequest(){
        recyclerView = (RecyclerView) findViewById(R.id.rcview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Call<MovieResponse> call = apiService.getResponse("ind" ,20);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(!response.isSuccessful()){
                    textView.setText("code "+response.code());
                    return;
                }
                MovieResponse mv = response.body();
                feed fe = mv.getFeed();
                List<Album> albums = fe.getResults();
                urls = new String[albums.size()];
                int i=0;
                for(Album album : albums)
                {
                       urls[i] = album.getArtworkUrl100();
                       i++;
                }
//                   for(String arr: urls){
//                        Log.v("msg ",arr);
//                    }
                recyclerView.setAdapter(new MyAdapter(albums,urls,R.layout.myrow,getApplicationContext()));
                /*for (Album album:albums)
                {
                    String res = "";
                    res += "ArtistName: "+album.getArtistName()+"\n";
                    res +="ArtsitUrl " +album.getArtistUrl()+"\n";
                    res += "ArtWorkUrl "+album.getArtworkUrl100()+"\n";
                    res += "CAF "+album.getContentAdvisoryRating()+"\n";
                    res += "@copy "+album.getCopyright()+"\n";
                    res += "name "+album.getName()+"\n";
                    res +="kind "+album.getKind()+"\n";
                    res += "relaesedate "+album.getReleaseDate()+"\n";
                    res += "ID "+album.getId()+"\n";
                    res += "genre "+album.getGenres()+"\n";
                    res += "artist "+album.getArtistId()+"\n";
                    res += "url "+album.getUrl()+"\n\n\n";

                    textView.append(res);

                }*/
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

}
