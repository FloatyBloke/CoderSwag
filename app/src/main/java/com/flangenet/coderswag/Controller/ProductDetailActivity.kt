package com.flangenet.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.flangenet.coderswag.Adapters.ProductsAdapter
import com.flangenet.coderswag.Model.Product
import com.flangenet.coderswag.R
import com.flangenet.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity() : AppCompatActivity() {
    lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)


        val productDetail: Product? = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        //println(productDetail)

        //adapter = ProductsAdapter(this, DataService.getProducts(categoryType))


        val productImage = findViewById<ImageView>(R.id.productImage)
        val productName = findViewById<TextView>(R.id.productName)
        val productPrice = findViewById<TextView>(R.id.productPrice)
        val productDescription = findViewById<TextView>(R.id.productDetails)


        val resourceId = resources.getIdentifier(productDetail?.image, "drawable", this.packageName)
        productImage?.setImageResource(resourceId)
        productName?.text = productDetail?.title
        productPrice?.text = productDetail?.price
        productDescription.text = "This is a load of goolies for ${productDetail?.title} it really should be an extension of the data service that allows an an extra field, but the lesson didn't ask for it so....Arse :)"
        //productDescription.text  = productDetail.image

        addToCartBtn.setOnClickListener{addToCart()}
    }
    private fun addToCart(){
        Toast.makeText(this,"Added To Cart",Toast.LENGTH_LONG).show()
    }
}
