package org.gsm.software.hktproject.view.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.MenuItem
import android.view.Window
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator
import org.gsm.software.hktproject.Adapter.LankAdapter
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.adapter.ViewPagerFragmentAdapter
import org.gsm.software.hktproject.databinding.ActivityLankcommentBinding
import org.gsm.software.hktproject.databinding.ActivityMainBinding
import org.gsm.software.hktproject.databinding.MainHeaderBinding
import org.gsm.software.hktproject.viewmodel.LankcommentViewModel
import org.gsm.software.hktproject.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LankcommentActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val binding by lazy { ActivityLankcommentBinding.inflate(layoutInflater) }
    private lateinit var headB: MainHeaderBinding
    private val mainViewModel : LankcommentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        slideInit()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        actionBar()
    }

    fun initView(){
        binding.lankactivity = this
        binding.navigationView.setNavigationItemSelectedListener(this@LankcommentActivity)
        val headV = binding.navigationView.getHeaderView(0)
        headB = MainHeaderBinding.bind(headV)
        val viewpagerFragmentAdapter = LankAdapter(this)
        binding.viewPager.adapter = LankAdapter(this)
        val tabTitles = listOf<String>("예쁜 글 작성자","예쁜 댓글 작성자")
        TabLayoutMediator(binding.taps,binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

    }


    private fun slideInit(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            with(window) {
                requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
                // set an slide transition
                enterTransition = Slide(Gravity.END)
                exitTransition = Slide(Gravity.END)
            }
        }
    }


    // menubar 생성
    fun actionBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        //메뉴바 왼쪽 설정
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menubar)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

    //메뉴 버튼
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.END)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}