package e.mi.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import e.mi.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var myName: MyName = MyName("Dmitry","gooDiVer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.nicknameButton.setOnClickListener {
            addNickName(it)
        }

        binding.myName = myName

    }

    fun addNickName(view: View) {

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            
            invalidateAll()

            view.visibility = View.GONE

            nicknameEdit.visibility = View.GONE

            nicknameText.visibility = View.VISIBLE
        }
//
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
