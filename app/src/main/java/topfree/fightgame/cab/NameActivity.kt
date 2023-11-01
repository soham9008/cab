package topfree.fightgame.cab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import topfree.fightgame.cab.databinding.ActivityMainScreenBinding
import topfree.fightgame.cab.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {


    lateinit var binding: ActivityNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fromData = intent.getStringExtra("from")
        val toData = intent.getStringExtra("to")



        binding.nextBtnInMain.setOnClickListener {

            if (binding.nameInput.text.isNotEmpty()){
                if (binding.numberInput.text.isNotEmpty()){

                    val name = binding.nameInput.text.toString()
                    val number = binding.numberInput.text.toString()

                    val intent = Intent(this, DataActivity::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("number", number)
                    intent.putExtra("from", fromData)
                    intent.putExtra("to", toData)
                    startActivity(intent)
                }
            }else {
                Toast.makeText(this, "Please Enter Place", Toast.LENGTH_SHORT).show()}
        }

    }
}