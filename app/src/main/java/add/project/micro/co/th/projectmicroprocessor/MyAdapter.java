package add.project.micro.co.th.projectmicroprocessor;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;


public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    private AdapterView.OnItemClickListener listener;
    Context c;
    String[] status;
    String[] statusShow;
    String[] date;
    String[] dateShow;
    int[] imgs;
    int[] arrow;

    public MyAdapter(Context ctx,int[] imgs,String[] status, String[] statusShow, String[] date, String[] dateShow,
                      int[] arrow) {
        this.c = ctx;
        this.imgs = imgs;
        this.status = status;
        this.statusShow = statusShow;
        this.date = date;
        this.dateShow = dateShow;
        this.arrow = arrow;

    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,null);
        MyHolder holder = new MyHolder(v);

        return holder;
    }


    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.image.setImageResource(imgs[position]);
        holder.statusView.setText(status[position]);
        holder.statusShow.setText(statusShow[position]);
        holder.dateView.setText(date[position]);
        holder.dateShow.setText(dateShow[position]);
        holder.arrowRight.setImageResource(arrow[position]);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                MainFragment fragment = new MainFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                        .addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrow.length;
    }
}
