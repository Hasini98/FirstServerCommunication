package mami.com.rssserverwithretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Album {
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("id")
    private Integer id;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("name")
    private String name;
    @SerializedName("kind")
    private String kind;
    @SerializedName("copyright")
    private  String copyright;
    @SerializedName("artistId")
    private Integer artistId;
    @SerializedName("contentAdvisoryRating")
    private String contentAdvisoryRating;
    @SerializedName("artistUrl")
    private String artistUrl;
    @SerializedName("artworkUrl100")
    private String artworkUrl100;
     class  Genre{
         @SerializedName("genreId")
         private Integer genreId;
         @SerializedName("name")
         private  String name;
         @SerializedName("url")
         private String url;
         public Genre(Integer genreId, String name, String url) {
             this.genreId = genreId;
             this.name = name;
             this.url = url;
         }
         public Integer getGenreId() {
             return genreId;
         }

         public void setGenreId(Integer genreId) {
             this.genreId = genreId;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public String getUrl() {
             return url;
         }

         public void setUrl(String url) {
             this.url = url;
         }
     }
     @SerializedName("genres")
    private List<Genre> genres;
     @SerializedName("url")
     private String url;
    public Album(String artistName, Integer id,
                 String releaseDate, String name,
                 String kind, String copyright,
                 Integer artistId,
                 String contentAdvisoryRating,
                 String artistUrl,
                 String artworkUrl100,
                 List<Genre> genres, String url) {
        this.artistName = artistName;
        this.id = id;
        this.releaseDate = releaseDate;
        this.name = name;
        this.kind = kind;
        this.copyright = copyright;
        this.artistId = artistId;
        this.contentAdvisoryRating = contentAdvisoryRating;
        this.artistUrl = artistUrl;
        this.artworkUrl100 = artworkUrl100;
        this.genres = genres;
        this.url = url;
    }
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public String getArtistUrl() {
        return artistUrl;
    }

    public void setArtistUrl(String artistUrl) {
        this.artistUrl = artistUrl;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
