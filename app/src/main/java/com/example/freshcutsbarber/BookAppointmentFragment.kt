package com.example.freshcutsbarber

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.Calendar

class BookAppointmentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_book_appointment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinnerService = view.findViewById<Spinner>(R.id.spinnerService)
        val spinnerBarber = view.findViewById<Spinner>(R.id.spinnerBarber)
        val etDate = view.findViewById<EditText>(R.id.etDate)
        val etTime = view.findViewById<EditText>(R.id.etTime)
        val etNotes = view.findViewById<EditText>(R.id.etNotes)
        val btnConfirm = view.findViewById<Button>(R.id.btnConfirmBooking)

        // Service
        val services = listOf("Haircut - R100", "Fade - R120", "Beard Trim - R80", "Haircut + Beard - R160")
        spinnerService.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, services).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Barber
        val barbers = listOf("Thabo - Fade Cuts", "Sipho - Classic Cuts", "Kabelo - Beard Specialist")
        spinnerBarber.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, barbers).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Date
        etDate.setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(requireContext(), { _, year, month, day ->
                etDate.setText("$day/${month + 1}/$year")
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        // Time
        etTime.setOnClickListener {
            val cal = Calendar.getInstance()
            TimePickerDialog(requireContext(), { _, hour, minute ->
                val amPm = if (hour < 12) "AM" else "PM"
                val hour12 = if (hour == 0) 12 else if (hour > 12) hour - 12 else hour
                etTime.setText(String.format("%02d:%02d %s", hour12, minute, amPm))
            }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false).show()
        }

        // Confirm
        btnConfirm.setOnClickListener {
            val service = spinnerService.selectedItem.toString()
            val barber = spinnerBarber.selectedItem.toString()
            val date = etDate.text.toString()
            val time = etTime.text.toString()

            if (date.isEmpty() || time.isEmpty()) {
                Toast.makeText(requireContext(), "Please select Date and Time", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Booked: $service with $barber on $date at $time", Toast.LENGTH_LONG).show()
            }
        }
    }
}