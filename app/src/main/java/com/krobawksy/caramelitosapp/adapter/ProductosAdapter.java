package com.krobawksy.caramelitosapp.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.krobawksy.caramelitosapp.R;
import com.krobawksy.caramelitosapp.models.Producto;
import com.krobawksy.caramelitosapp.servicios.ApiService;
import com.qhutch.elevationimageview.ElevationImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder> implements Filterable {

    private static final String TAG = ProductosAdapter.class.getSimpleName();

    private List<Producto> productos;
    public ArrayList<Producto> filterList;

    private Filter fRecords;
    private Activity activity;

    public ProductosAdapter(Activity activity){
        this.productos = new ArrayList<>();
        this.activity = activity;
    }

    public void setProductos(List<Producto> productos){
        this.productos = productos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivImage;
        public TextView tvNombre;
        public TextView tvPrecio;
        public ImageButton ibAdd;

        public LinearLayout llAgregar;
        public ImageButton ibMas;
        public ImageButton ibMenos;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
            tvNombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            tvPrecio = (TextView) itemView.findViewById(R.id.tv_precio);
            ibAdd = (ImageButton) itemView.findViewById(R.id.ib_add);
            llAgregar = (LinearLayout) itemView.findViewById(R.id.ll_agregar);
            ibMas = (ImageButton) itemView.findViewById(R.id.ib_mas);
            ibMenos = (ImageButton) itemView.findViewById(R.id.ib_menos);
        }
    }

    @Override
    public ProductosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ProductosAdapter.ViewHolder viewHolder, final int position) {

        final Producto producto = this.productos.get(position);

        viewHolder.tvNombre.setText(producto.getNombre());
        viewHolder.tvPrecio.setText("S/. " + producto.getPreciounitario());

        String url = ApiService.API_BASE_URL + "/images/" + producto.getImagenxs();
            Picasso.get().load(url).resize(52, 52)
                .centerCrop().into(viewHolder.ivImage);

        viewHolder.ibAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.ibAdd.setVisibility(View.GONE);
                viewHolder.llAgregar.setVisibility(View.VISIBLE);
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*final Dialog productDialog = new Dialog(activity);
                productDialog.setContentView(R.layout.alert_producto);
                productDialog.setCancelable(false);


                ImageButton close = ( ImageButton ) productDialog.findViewById(R.id.close_btn);
                ImageButton store = ( ImageButton ) productDialog.findViewById(R.id.store_btn);
                ImageView productImg = ( ImageView ) productDialog.findViewById(R.id.image_product);
                TextView productName = ( TextView ) productDialog.findViewById(R.id.name_product);
                TextView productDetails = ( TextView ) productDialog.findViewById(R.id.details_product);
                TextView productPrice = ( TextView ) productDialog.findViewById(R.id.price_product);

                String url = ApiService.API_BASE_URL + "/images/" + producto.getImagendetalle();
                Picasso.get().load(url).resize(320, 320)
                        .centerCrop().into(productImg);

                productName.setText(producto.getNombre());
                productDetails.setText(producto.getDescripcion());
                productPrice.setText("S/. "+ producto.getPreciounitario());

                store.setVisibility(View.GONE);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        productDialog.cancel();
                    }
                });

                productDialog.show();*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }

    @Override
    public Filter getFilter() {
        if(fRecords == null) {
            fRecords=new ProductosAdapter.RecordFilter();
        }
        return fRecords;
    }

    //filter class
    private class RecordFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            if (constraint == null || constraint.length() == 0) {
                //No need for filter
                results.values = productos;
                results.count = productos.size();

            } else {
                ArrayList<Producto> fRecords = new ArrayList<Producto>();

                for (Producto producto : productos) {
                    if (producto.getNombre().toUpperCase().trim().contains(constraint.toString().toUpperCase().trim())) {
                        fRecords.add(producto);
                    }
                }
                results.values = fRecords;
                results.count = fRecords.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,FilterResults results) {
            productos = (ArrayList<Producto>) results.values;
            notifyDataSetChanged();
        }
    }

}
