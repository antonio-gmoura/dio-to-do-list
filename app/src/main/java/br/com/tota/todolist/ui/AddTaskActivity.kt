package br.com.tota.todolist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.tota.todolist.databinding.ActivityAddTaskBinding
import br.com.tota.todolist.extensions.format
import br.com.tota.todolist.extensions.text
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners() {
        binding.tilDate.editText?.setOnClickListener{
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener {
                binding.tilDate.text = Date(it).format()
            }
            datePicker.show(supportFragmentManager,"DATE_PICKER_TAG")
        }
    }
}