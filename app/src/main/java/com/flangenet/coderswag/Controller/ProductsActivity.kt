package com.flangenet.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.flangenet.coderswag.Adapters.ProductsAdapter
import com.flangenet.coderswag.R
import com.flangenet.coderswag.Services.DataService
import com.flangenet.coderswag.Utilities.EXTRA_CATEGORY
import com.flangenet.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var  adapter: ProductsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        // adapter = ProductsAdapter(this, DataService.getProducts(categoryType))
        adapter = ProductsAdapter(this,DataService.getProducts(categoryType)){ productDetail ->
            //println(productDetail.title)
            // Open up Product Detail Form
            val productDetailIntent = Intent(this,ProductDetailActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT, productDetail)
            startActivity(productDetailIntent)


        }

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720 ) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter


    }
}
