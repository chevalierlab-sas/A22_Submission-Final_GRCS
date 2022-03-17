package com.chikalfachdiana.recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chikalfachdiana.recyclerview.R
import com.chikalfachdiana.recyclerview.databinding.ActivityDetailBinding
import com.chikalfachdiana.recyclerview.model.Hewan
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var namaHewan: String
    private lateinit var namaLatinHewan: String
    private lateinit var jenisHewan: String
    private var fotoHewan by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getInfoFromIntent()
        setDataHewan()
    }


    private fun setDataHewan() {
        binding.nama.text = namaHewan
        binding.namaLatin.text = namaLatinHewan
        binding.jenisHewan.text = jenisHewan
        binding.imgRes.setImageResource(fotoHewan)
    }

    private fun getInfoFromIntent() {
        val intent = intent
        namaHewan = intent.getStringExtra(MainActivity.NAMA_HEWAN)!!
        namaLatinHewan = intent.getStringExtra(MainActivity.NAMA_LATIN_HEWAN)!!
        jenisHewan = intent.getStringExtra(MainActivity.JENIS_HEWAN)!!
        fotoHewan = intent.getIntExtra(MainActivity.FOTO_HEWAN,0)
    }
}