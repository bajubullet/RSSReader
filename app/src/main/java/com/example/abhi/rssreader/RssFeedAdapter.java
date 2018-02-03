package com.example.abhi.rssreader;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.net.URI;
import java.util.List;

/**
 * Created by abhi on 2/2/18.
 */

public class RssFeedAdapter extends RecyclerView.Adapter <RssFeedAdapter.FeedModelViewHolder> {
    public RssFeedAdapter(Context context, List<RssFeedModel> rssFeedModels) {
        this.context = context;
        this.rssFeedModels = rssFeedModels;
    }

    private List<RssFeedModel> rssFeedModels;
    private Context context;


    @Override
    public FeedModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rss_feed_item, parent, false);
        return new FeedModelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FeedModelViewHolder holder, int position) {
        final RssFeedModel rssFeedModel = rssFeedModels.get(position);
        holder.textViewTitle.setText(rssFeedModel.title);
        holder.textViewDescription.setText(rssFeedModel.description);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(rssFeedModel.link);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rssFeedModels.size();
    }

    public class FeedModelViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewDescription;
        public CardView cardView;

        public FeedModelViewHolder(View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
}
