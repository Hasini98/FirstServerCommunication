package mami.com.rssserverwithretrofit.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import mami.com.rssserverwithretrofit.R;
import mami.com.rssserverwithretrofit.model.Album;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Album> albums;
    private int row;
    private Context context;String[] urls ;
    Bitmap bitmap;

    public MyAdapter(List<Album> albums, String[] urls, int row, Context context) {
        this.albums = albums;
        this.row = row;
        this.context = context;
        this.urls = urls;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.myrow,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tv.setText(albums.get(i).getArtistName());
        myViewHolder.tv2.setText(albums.get(i).getName());

        new getImageFromUrl(myViewHolder.iv).execute(urls[i]);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv2 ;
        ImageView iv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
            tv2 = itemView.findViewById(R.id.textView2);
            iv = itemView.findViewById(R.id.imageview);
        }
    }


    public class  getImageFromUrl extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;

        public getImageFromUrl(ImageView imageView) {
            this.imageView = imageView;
        }


        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            bitmap =null;
            InputStream in = null;
            try {
                in = new java.net.URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }
}
