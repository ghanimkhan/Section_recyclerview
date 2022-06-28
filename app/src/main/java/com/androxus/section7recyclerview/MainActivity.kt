package com.androxus.section7recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.androxus.section7recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val MyAdapter:MyRecyclerViewAdapter by lazy{
        MyRecyclerViewAdapter(fruites)
    }

    val fruites= listOf(Fruits("Apple","jon"),Fruits("mango","jon"),Fruits("banana","jon"),Fruits("apple","jon"))



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }


        binding.myRecyclerView.setBackgroundColor(Color.YELLOW)

        binding.myRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.myRecyclerView.adapter=MyRecyclerViewAdapter(fruites)
        binding.seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                Toast.makeText(this@MainActivity, "seekbar progress: $progress", Toast.LENGTH_SHORT).show()
                MyAdapter.getUpdateIterface().onProgressChanged(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(this@MainActivity, "seekbar touch started!", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(this@MainActivity, "seekbar touch stopped!", Toast.LENGTH_SHORT).show()

            }
        })









    }
}