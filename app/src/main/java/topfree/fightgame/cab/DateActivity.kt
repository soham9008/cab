package topfree.fightgame.cab

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import topfree.fightgame.cab.databinding.ActivityDataBinding
import java.util.Calendar

class DateActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding : ActivityDataBinding
    lateinit var tripeTrype : String
    lateinit var trip: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trip = arrayOf("One Way", "Round Trip")
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        var adapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,trip)
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)


        val selecteTrypes = binding.selectTrype
        selecteTrypes.adapter = adapter
        selecteTrypes.setSelection(0,false)
        selecteTrypes.onItemSelectedListener = this@DateActivity


        binding.textView.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                val dateFormate = "$dayOfMonth/$monthOfYear/$year"
                binding.textView.text = dateFormate
            }, year, month, day)

            dpd.show()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, yera, month, day ->

            }, year,month, day)
        }

        binding.textView2.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                val dateFormate = "$dayOfMonth/$monthOfYear/$year"
                binding.textView2.text = dateFormate
            }, year, month, day)

            dpd.show()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, yera, month, day ->

            }, year,month, day)
        }

        binding.nextBtnInMain.setOnClickListener {

            getSharedPreferences("tripe", MODE_PRIVATE).edit().putString("tripe", tripeTrype)
            getSharedPreferences("fromDate", MODE_PRIVATE).edit().putString("fromDate", binding.textView.text.toString())
            getSharedPreferences("toDate", MODE_PRIVATE).edit().putString("toDate", binding.textView2.text.toString())
            startActivity(Intent(this, CarActivity::class.java))
        }
    }

    override fun onItemSelected(adapter : AdapterView<*>?, view: View?, position: Int, p3: Long) {
            tripeTrype = trip[position]
        binding.notVisibleText.visibility = if (tripeTrype == "Round Trip") View.VISIBLE else View.GONE
        binding.notVisiblrLayout.visibility = if (tripeTrype == "Round Trip") View.VISIBLE else View.GONE

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}