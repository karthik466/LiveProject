package com.example.liveproject

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.liveproject.databinding.DialogLayoutBinding

//Step1: We want to apply theme to Dialog Fragment level

//Step2: We want to apply theme to Dialog inside the Dialog Fragment onCreateDialog level

class MyDialog : DialogFragment() {
    //Step 1:
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NO_TITLE, R.style.FullScreenDialogStyle)
//
//    }

//Step 1:

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val binding = DialogLayoutBinding.inflate(inflater)
//        return binding.root
//    }

    //Step 2
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext(),R.style.FullScreenDialogStyle)
        dialog.setContentView(R.layout.dialog_layout)
        return dialog
    }


}