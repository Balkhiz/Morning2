package com.balkhiz.mrng;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Balkhiz on 04-Feb-18.
 */

public class MyAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>  {


    private List<String> list;
    public Context context;

    public MyAdapter(List<String> list,Context context) {
        this.list = list;
        this.context=context;
    }

    public static final int TEXT_VIEW_TYPE = 1;
    public static final int PLUS_VIEW_TYPE = 2;


    public class ViewHolderInfo extends RecyclerView.ViewHolder {

        TextView text;
        public ViewHolderInfo(View itemView) {
            super( itemView );
            text = (TextView) itemView.findViewById( R.id.text );
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageButton image;
        public ViewHolder(final View itemView) {
            super( itemView );
            image = (ImageButton) itemView.findViewById( R.id.image );
            image.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context,NoteAffirmation.class );
                    context.startActivity( i );
                    }
            } );
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position < list.size()) {
            return TEXT_VIEW_TYPE;
        } else
            return PLUS_VIEW_TYPE;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case TEXT_VIEW_TYPE:
                View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.list_item_layout, parent, false );
                ViewHolderInfo viewHolderInfo = new ViewHolderInfo( view );
                return viewHolderInfo;

            default:
                View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.affirmation9new, parent, false );
                ViewHolder viewHolder = new ViewHolder( v );
                return viewHolder;
        }
    }

    @Override
        public void onBindViewHolder (RecyclerView.ViewHolder holder, int position){

            int viewType = getItemViewType( position );
            switch (viewType) {
                case TEXT_VIEW_TYPE:
                    ((ViewHolderInfo)holder).text.setText( list.get(position) );
                    break;

                case PLUS_VIEW_TYPE:
                    break;
            }
        }

        @Override
        public int getItemCount () {
            return list.size()+1;
        }
    }
