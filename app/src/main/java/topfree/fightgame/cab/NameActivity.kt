package topfree.fightgame.cab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import topfree.fightgame.cab.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {


    lateinit var binding: ActivityNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nextBtnInMain.setOnClickListener {

            if (binding.nameInput.text.isNotEmpty()){
                if (binding.numberInput.text.isNotEmpty()){

                    val name = binding.nameInput.text.toString()
                    val number = binding.numberInput.text.toString()

                     getSharedPreferences("name", MODE_PRIVATE).edit().putString("name", name)
                     getSharedPreferences("Number", MODE_PRIVATE).edit().putString("Number", number)
                    startActivity(Intent(this, DateActivity::class.java))
                }
            }else {
                Toast.makeText(this, "Please Enter Place", Toast.LENGTH_SHORT).show()}
        }

    }
}