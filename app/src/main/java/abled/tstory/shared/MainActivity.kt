package abled.tstory.shared

import abled.tstory.shared.databinding.ActivityMainBinding
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            saveButton(binding)
        }

        binding.buttonLoad.setOnClickListener {
            loadButton(binding)
        }

    }

    private fun saveButton(binding:ActivityMainBinding){

        //쉐어드 저장
        val shared = getSharedPreferences("shared",0)
        val edit = shared.edit()
        edit.putString("name",binding.editTextName.text.toString())
        edit.putInt("phone",binding.editTextPhone.text.toString().toInt())
        edit.apply()

        //에딧텍스트 빈칸처리
        binding.editTextName.setText("")
        binding.editTextPhone.setText("")

    }

    private fun loadButton(binding: ActivityMainBinding){

        //쉐어드 로드
        val shared = getSharedPreferences("shared",0)
        binding.textViewName.text = shared.getString("name","")
        //핸드폰 번호 저장시 정수형이기 때문에 맨 앞에 0 추가
        binding.textViewPhone.text = "0${shared.getInt("phone",0).toString()}"
    }

}