package com.chikalfachdiana.recyclerview.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chikalfachdiana.recyclerview.adapter.MainAdapter
import com.chikalfachdiana.recyclerview.databinding.ActivityMainBinding


@SuppressLint("NotifyDataSetChanged")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    companion object {
        const val  NAMA_HEWAN = "org.d3if2146.galerihewan.namaHewan"
        const val  NAMA_LATIN_HEWAN = "org.d3if2146.galerihewan.namaLatin"
        const val  JENIS_HEWAN = "org.d3if2146.galerihewan.jenisHewan"
        const val  FOTO_HEWAN = "org.d3if2146.galerihewan.fotoHewan"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mainAdapter = MainAdapter()
        prepareRecyclerView()
        onHewanItemClick()
    }

    private fun onHewanItemClick() {
        mainAdapter.onItemClick = {
                data ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(NAMA_HEWAN,data.nama)
            intent.putExtra(NAMA_LATIN_HEWAN,data.namaLatin)
            intent.putExtra(JENIS_HEWAN,data.jenisHewan)
            intent.putExtra(FOTO_HEWAN,data.imgResId)
            startActivity(intent)
        }
    }

    private fun prepareRecyclerView() {
        binding.recyclerView.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context,RecyclerView.VERTICAL))
        }
        mainAdapter.notifyDataSetChanged()
    }
}