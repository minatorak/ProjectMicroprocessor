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
    private Context c;
    private String[] status;
    private int[] imgs;
    private int[] arrow;

    public MyAdapter(Context ctx,int[] imgs,String[] status, int[] arrow) {
        this.c = ctx;
        this.imgs = imgs;
        this.status = status;
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
        holder.arrowRight.setImageResource(arrow[position]);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                MainFragment fragment = new MainFragment();
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrow.length;
    }


}
