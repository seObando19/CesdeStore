package com.example.cesdestore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText id_res,productos,valor,categoria,des;
    Button btnbus,btnIns,btnElim,btnAct;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id_res=findViewById(R.id.Id_text);
        productos=findViewById(R.id.productos);
        valor=findViewById(R.id.valor);
        categoria=findViewById(R.id.categoria);
        des=findViewById(R.id.descrip);
    }

    private void servicioHttp(String URL)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "Operacion correcta", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Hubo un error en la petecion", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>parametros = new HashMap<>();
                parametros.put("id",id_res.getText().toString());
                parametros.put("productos",productos.getText().toString());
                parametros.put("valor",valor.getText().toString());
                parametros.put("categoria",categoria.getText().toString());
                parametros.put("descripcion",des.getText().toString());
                return parametros;
            }
        };
        //se procesa las peticiones realizadas para que la libreria para procesarla
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void insertarProducto(View view) {
        servicioHttp("aqui debe ir la ruta");

    }
}
