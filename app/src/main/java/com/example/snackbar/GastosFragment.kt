package com.example.snackbar

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GastosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GastosFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gastos, container, false)
    }

    companion object {
        fun newInstance() = GastosFragment()
    }

    override fun onResume() {
        Log.e("GastosFragment", "onResume")
        activity?.btn_gastos?.setBackgroundColor(Color.RED)
        activity?.btn_gastos?.isEnabled = false
        activity?.btn_gastos?.isClickable = false
        super.onResume()
    }

    override fun onPause() {
        Log.e("GastosFragment", "onPause")
        activity?.btn_gastos?.setBackgroundColor(Color.GRAY)
        activity?.btn_gastos?.isEnabled = true
        activity?.btn_gastos?.isClickable = true
        super.onPause()
    }
}