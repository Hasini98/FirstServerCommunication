package mami.com.rssserverwithretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class feed {

        @SerializedName("author")
        authors author ;
        class authors{
            @SerializedName("name")
            String author;
            @SerializedName("uri")
            String uri;

            public authors(String author, String uri) {
                this.author = author;
                this.uri = uri;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }
        }
        @SerializedName("copyright")
        String copyright;
        @SerializedName("country")
        String country;
        @SerializedName("icon")
        String icon;
        @SerializedName("id")
        String id;
        @SerializedName("results")
        List<Album> results;
        @SerializedName("title")
        String title;
        @SerializedName("updated")
        String updated;

        class Links{
            @SerializedName("self")
            String self;
            @SerializedName("alternate")
            String alternate;

            public Links(String self, String alternate) {
                this.self = self;
                this.alternate = alternate;
            }

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public String getAlternate() {
                return alternate;
            }

            public void setAlternate(String alternate) {
                this.alternate = alternate;
            }
        }
        @SerializedName("links")
        List<Links> links;

        public feed(authors author, String copyright,
                    String country, String icon, String id,
                    List<Album> results, String title,
                    String updated, List<Links> links) {
            this.author = author;
            this.copyright = copyright;
            this.country = country;
            this.icon = icon;
            this.id = id;
            this.results = results;
            this.title = title;
            this.updated = updated;
            this.links = links;
        }

        public authors getAuthor() {
            return author;
        }

        public void setAuthor(authors author) {
            this.author = author;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Album> getResults() {
            return results;
        }

        public void setResults(List<Album> results) {
            this.results = results;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public List<Links> getLinks() {
            return links;
        }

        public void setLinks(List<Links> links) {
            this.links = links;
        }
    }

