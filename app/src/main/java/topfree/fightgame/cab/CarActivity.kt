package topfree.fightgame.cab

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.*
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import topfree.fightgame.cab.databinding.ActivityCarBinding

class CarActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener {
    lateinit var binding : ActivityCarBinding
    lateinit var selecteCarArray : Array<String>
    lateinit var selectedItem : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        selecteCarArray = arrayOf(
            "Car",
            "Mini Bus",
            "bus"
        )


       val adapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,selecteCarArray)
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)


        val selecteCar = binding.selectCar
        selecteCar.adapter = adapter
        selecteCar.setSelection(0,false)


        binding.nextBtnInMain.setOnClickListener {
            val intent = Intent(this, UserDetails::class.java)
            startActivity(intent)
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

        selectedItem = selecteCarArray[position]
        getSharedPreferences("Car", MODE_PRIVATE).edit().putString("Car", selectedItem)


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


}