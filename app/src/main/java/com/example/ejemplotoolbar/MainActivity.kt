package com.example.ejemplotoolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        val bIr = findViewById<Button>(R.id.bir)
        bIr.setOnClickListener{
            val intent = Intent(this, PantallaDos::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val itemBusqueda = menu?.findItem(R.id.busqueda)
        var vistaBusqueda = itemBusqueda?.actionView as SearchView

        vistaBusqueda.queryHint = "Escribe tu nombre..."

        vistaBusqueda.setOnQueryTextFocusChangeListener{ view, b ->
            Log.d("LISTENERFOCUS", hasWindowFocus().toString())
        }

        vistaBusqueda.setOnQueryTextListener(object :  SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                if(p0 != null){
                    Log.d("onQueryTextChange",p0)
                }
                return true
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                if(p0 != null){
                    Log.d("onQueryTextSubmit",p0)
                }
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.bFav -> {
                Toast.makeText(this,"Elemento añadido como Favorito", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }

        }

    }
}