package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)

        btnDatePicker.setOnClickListener{view ->
            clickDatePicker(view)
        }
    }
    fun clickDatePicker(view:View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{
                    view, selectedyear, selectedmonth, selecteddayOfMonth ->
                Toast.makeText(this,
                    "the chosen year is $selectedyear, the month is $selectedmonth and the day is $selecteddayOfMonth"
                    ,Toast.LENGTH_LONG).show()
                val selectedDate = "$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"

                val tvSelectDate = findViewById<TextView>(R.id.tvSelectDate)
                //hien thi ngay thang nam duoc chon
                tvSelectDate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate!!.time/1000 //in minute: 60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateToMinutes = currentDate!!.time/1000 //in minute: 60000

//  val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes    -> in minutes
                val differenceInMinutes = git remote add origin https://github.com/xxx/yyy.git

                val tvSelectDateInMinutes = findViewById<TextView>(R.id.tvSelectDateInMinutes)

                tvSelectDateInMinutes.setText(differenceInMinutes.toString())
            }
            ,year
            ,month
            ,day)
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }
}