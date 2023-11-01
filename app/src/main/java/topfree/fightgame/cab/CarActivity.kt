package topfree.fightgame.cab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import topfree.fightgame.cab.databinding.ActivityCarBinding

class CarActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding : ActivityCarBinding
    lateinit var databaseReference : DatabaseReference
    lateinit var selecteCar : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        selecteCar = arrayOf(
            "Car",
            "Mini Bus",
            "bus"
        )

        val triptrype = intent.getStringExtra("tripe")
        val fromDate = intent.getStringExtra("fromDate")
        val toDate = intent.getStringExtra("toDate")

        Toast.makeText(this, "$triptrype", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "$fromDate", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "${toDate}", Toast.LENGTH_SHORT).show()

       var adapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,selecteCar)
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)


        val selecteTrypes = binding.selectTrype
        selecteTrypes.adapter = adapter
        selecteTrypes.setSelection(0,false)
        selecteTrypes.onItemSelectedListener = this@CarActivity



        binding.nextBtnInMain.setOnClickListener{
            val intent = Intent(this@CarActivity, EndActivity::class.java)
            startActivity(intent)
            addDataToFireBase()
        }

        databaseReference = Firebase.database.reference
    }

    private fun addDataToFireBase() {

    }

    override fun onItemSelected(adpter: AdapterView<*>?, view: View?, position: Int, p3: Long) {
        Toast.makeText(this, selecteCar[position], Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}