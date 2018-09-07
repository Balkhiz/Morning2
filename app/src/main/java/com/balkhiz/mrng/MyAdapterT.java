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

public class MyAdapterT extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

        private List<String> mlist;
        public Context context;

    public MyAdapterT(List<String> mlist,Context context)
        {
            this.mlist=mlist;
            this.context=context;
        }

        public static final int TEXT_VIEW_TYPE = 1;
        public static final int PLUS_VIEW_TYPE = 2;

        public static class ViewText extends RecyclerView.ViewHolder {

            TextView text;
            public ViewText(View itemView) {
                super( itemView );
                text = (TextView) itemView.findViewById( R.id.textView );
            }
        }

        public class ViewPlus extends RecyclerView.ViewHolder {

            public ImageButton image2;
            public ViewPlus(View itemView) {
                super( itemView );
                image2 = (ImageButton) itemView.findViewById( R.id.image2 );
                image2.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context,NoteTaskList.class );
                        context.startActivity( i );
                    }
                } );
            }
        }

        @Override
        public int getItemViewType(int position) {

        if (position < mlist.size()) {
            return TEXT_VIEW_TYPE;
        } else
            return PLUS_VIEW_TYPE;
    }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TEXT_VIEW_TYPE:
                View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.task_list_layout, parent, false );
                ViewText viewText = new ViewText( view );
                return viewText;

            default:
                View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.tasklist12new, parent, false );
                ViewPlus viewPlus = new ViewPlus( v );
                return viewPlus;

        }
    }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType( position );
        switch (viewType) {
            case TEXT_VIEW_TYPE:
                ((ViewText) holder).text.setText( mlist.get(position) );
                break;

            case PLUS_VIEW_TYPE:
                break;
        }

    }

        @Override
        public int getItemCount() {
        return mlist.size()+1;
    }

    }