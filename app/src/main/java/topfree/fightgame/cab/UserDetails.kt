package topfree.fightgame.cab

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import topfree.fightgame.cab.databinding.ActivityUserDetailsBinding

class UserDetails : AppCompatActivity() {

    lateinit var binding: ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



//        val name = getSharedPreferences("name", MODE_PRIVATE).getString("name", null)
//        val number = getSharedPreferences("Number", MODE_PRIVATE).getString("Number", null)
//
//        Toast.makeText(this, "$name", Toast.LENGTH_SHORT).show()




    }
}