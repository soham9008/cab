package topfree.fightgame.cab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplaceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splace_screen)

         Handler().postDelayed({
            val intent = Intent(this, MainScreen::class.java)
             startActivity(intent)
             finish()
        },1000)

    }
}