package mami.com.rssserverwithretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("feed")
    feed feed;

    public MovieResponse(mami.com.rssserverwithretrofit.model.feed feed) {
        this.feed = feed;
    }

    public mami.com.rssserverwithretrofit.model.feed getFeed() {
        return feed;
    }

    public void setFeed(mami.com.rssserverwithretrofit.model.feed feed) {
        this.feed = feed;
    }
}
