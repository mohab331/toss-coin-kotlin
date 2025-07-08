package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

/// Activity => one screen - handles UI drawing -> (setContentView),
// User interactions,
// Navigation
/// Lifecycle => onCreate, onStart, onResume, onPause, onStop, onDestroy

/// setContentView(layoutID) -> Android looks up this ID to find the layout file it needs.
/// Android uses a system service called LayoutInflater to inflate the XML into View objects.(XML → View objects)
/// It reads the XML and builds a tree of View and ViewGroup objects in memory.

/// Android internally calls window.setContentView(view)
// This tells the Window Manager:
// "Here’s the root view — attach it to the window and show it on the screen"
//Activity
//└── Root View: LinearLayout (ViewGroup)
//├── TextView (text = "Hello, Mohab!")
//└── Button   (text = "Click Me")

//A layout defines the structure for a user interface in your app
// All elements in the layout are built using a hierarchy of View and ViewGroup objects.
// A View usually draws something the user can see and interact with.
// A ViewGroup is an invisible container that defines the layout structure for View and other ViewGroup objects,
//View objects are often called widgets and can be one of many subclasses, such as Button or TextView.
//The ViewGroup objects are usually called layouts and can be one of many types that provide a different layout structure, such as LinearLayout or ConstraintLayout.
//  tools namespace that enable design-time features

/// A ViewGroup is a special view that can contain other views (called children.)
// The view group is the base class for layouts and views containers
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tossCoinButtonId.setOnClickListener {
            val randomNumber = (0..1).random()
            val imageResource = when(randomNumber){
                0 -> R.drawable.coin_head
                else -> R.drawable.coin_tail
            }
            val toastMessage = when(randomNumber){
                0 -> R.string.head
                else -> R.string.tail
            }
            binding.tossCoinImageId.setImageResource(imageResource)
            Toast.makeText(baseContext,toastMessage,Toast.LENGTH_SHORT).show()
        }
    }
}