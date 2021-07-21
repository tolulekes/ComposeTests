package com.vogproject.mktfy.ui.home

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.vogproject.mktfy.ui.navhost.MainActivity2
import com.vogproject.mktfy.R
import com.vogproject.mktfy.adapters.CategoryClickListener
import com.vogproject.mktfy.adapters.CategoryListAdapter
import com.vogproject.mktfy.adapters.ProductClickListener
import com.vogproject.mktfy.adapters.ProductListAdapter
import com.vogproject.mktfy.databinding.ActivityHomeBinding
import com.vogproject.mktfy.general.startActivityWithClass
import com.vogproject.mktfy.general.viewModel
import com.vogproject.mktfy.models.homeactivity.Category
import com.vogproject.mktfy.models.homeactivity.HomeActivityViewModel
import com.vogproject.mktfy.models.homeactivity.Product
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
//    private val viewModel: HomeActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.apply {
            


            citySelection.setOnClickListener {
                if (containerCityFilter.isVisible){
                    containerCityFilter.visibility = View.GONE
                }else{
                    containerCityFilter.visibility = View.VISIBLE
                }
            }

            createOfferButton.setOnClickListener {


            }

            homeMenuButton.setOnClickListener {
                val intent = Intent(this@HomeActivity, MainActivity2::class.java)
                startActivity(intent)
            }
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
//                    startActivityWithClass<>()

                })
            }


            productRecyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    Log.d(TAG, "onScrolled: " + dy)
                    if (dy > 0 && !createOfferButton.isExtended){
                        createOfferButton.shrink()
                    }
                    if (dy < 0 && createOfferButton.isExtended){
                        createOfferButton.shrink()
                    }
                    if (!recyclerView.canScrollVertically(-1)){
                        createOfferButton.extend()
                    }
                }
            })
//            productRecyclerView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
//                if (scrollY > oldScrollY + 12 && createOfferButton.isExtended){
//                    Log.d(TAG, "onCreate: " + scrollY)
//                    createOfferButton.shrink()
//                }
//                if (scrollY < oldScrollY - 12 && !createOfferButton.isExtended){
//                    createOfferButton.extend()
//                }
//                if (scrollY == 0){
//                    createOfferButton.extend()
//                }
//            }
        }
    }
}