package topfree.fightgame.cab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.database.database
import topfree.fightgame.cab.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {
lateinit var recyclerView: RecyclerView
lateinit var newArrayList: ArrayList<DataListSilde>
lateinit var fromName : Array<String>
lateinit var toName : Array<String>
    lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


            fromName = arrayOf(
                "surat",
                "delhi",
                "mumbai",
                "dubai",
                "gujarat",
                "india"
            )
            toName = arrayOf(
                "delhi",
                "gujarat",
                "name",
                "surat",
                "gujardfsdffgat",
                "dfsfsf"
            )



            binding.nextBtnInMain.setOnClickListener {

                if (binding.fromInput.text.isNotEmpty()){
                    if (binding.toInput.text.isNotEmpty()){

                val fromInMain = binding.fromInput.text.toString()
                val toInMain = binding.toInput.text.toString()

                val intent = Intent(this, NameActivity::class.java)
                  getSharedPreferences("from", MODE_PRIVATE).edit().putString("from", fromInMain)
                  getSharedPreferences("to", MODE_PRIVATE).edit().putString("to", toInMain)
                startActivity(intent)
            } 
                }else {
                    Toast.makeText(this, "Please Enter Place", Toast.LENGTH_SHORT).show()}
            }
            newArrayList = ArrayList<DataListSilde>()
            addInArrayList()

            recyclerView = binding.recycleView

             recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)

            val adapter = MyAdapter(newArrayList)
        recyclerView.adapter = adapter
        adapter.litener(object : MyAdapter.onclickListener{
            override fun onItemClick(position: Int) {

                getSharedPreferences("from", MODE_PRIVATE).edit().putString("from", newArrayList[position].toString())
                getSharedPreferences("to", MODE_PRIVATE).edit().putString("to", newArrayList[position].toString())
                startActivity(Intent(this@MainScreen, NameActivity::class.java))
            }

        })


    }

    private fun addInArrayList() {
        for (i in fromName.indices){

            val newList = DataListSilde(fromName[i],toName[i])
            newArrayList.add(newList)

        }
    }
}
