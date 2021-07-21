package com.vogproject.vogappmktfy.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vogproject.vogappmktfy.R
import com.vogproject.vogappmktfy.databinding.ActivityHomeBinding
import com.vogproject.vogappmktfy.models.Category
import com.vogproject.vogappmktfy.models.Product

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.apply {

            categories = listOf(
                Category("1", "Deals", getDrawable(R.drawable.ic_drawable_deals)),
                Category("2", "Cars & Vehicles", getDrawable(R.drawable.ic_drawable_car)),
                Category("3", "Furniture", getDrawable(R.drawable.ic_drawable_furniture)),
                Category("4", "Electronics", getDrawable(R.drawable.ic_drawable_electronics)),
                Category("5", "Real Estate", getDrawable(R.drawable.ic_drawable_real_estate)),
            )
            products = MutableLiveData<List<Product>>(
                listOf(
                Product("10", "https://picsum.photos/210/300", "Deals", 38.99),
                Product("11", "https://picsum.photos/400/300", "Cars ", 29.99),
                Product("12", "https://picsum.photos/120/300", "Furniture", 99.99),
                Product("13", "https://picsum.photos/320/300", "Electronics", 67.65),
                Product("14", "https://picsum.photos/260/300", "Real ", 54.99)
            ))
            categoriesRecyclerView.apply{
                layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.HORIZONTAL, false)
                adapter = CategoryListAdapter(CategoryClickListener { category ->

                })
            }
            productRecyclerView.apply {
                layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
                adapter = ProductListAdapter(ProductClickListener { product ->

                })
            }
        }
    }
}