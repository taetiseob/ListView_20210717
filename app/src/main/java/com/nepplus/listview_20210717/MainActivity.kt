package com.nepplus.listview_20210717

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.nepplus.listview_20210717.adapter.StudentAdapter
import com.nepplus.listview_20210717.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //변수로 mAdapter를 만들어주고 => 나중에 채워주겠다고 명시, (lateinit var)
    //어댑터는 onCreate{} 안에서 채워줘야 정상 동작
    lateinit var mAdapter : StudentAdapter
    //맨위 변수 생성시 멤버변수라 함
    val mStudentList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mStudentList.add( Student("tts",1991,"경기 평택시") )
        mStudentList.add( Student("adt",1994,"서울 동대문구") )
        mStudentList.add( Student("zts",1993,"경기 수원시") )
        mStudentList.add( Student("ius",1991,"경기 평택시") )
        mStudentList.add( Student("uat",1994,"서울 동대문구") )
        mStudentList.add( Student("bbs",1997,"경기 수원시") )
        mStudentList.add( Student("tt1s",1991,"경기 평택시") )
        mStudentList.add( Student("gddft",1994,"서울 동대문구") )
        mStudentList.add( Student("zts",1993,"경기 의왕시") )
        mStudentList.add( Student("idus",1991,"경기 구리시") )
        mStudentList.add( Student("nacxt",1994,"서울 동대문구") )
        mStudentList.add( Student("bfvs",1997,"경기 안양시") )

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        //만들어진 mAdapter를 리스트의 어댑터로써 연결
        studentListView.adapter = mAdapter
        //리스트뷰 이벤트 처리

        studentListView.setOnItemClickListener { parent, view, position, id ->

//            클릭된 학생의 이름을 토스트로 찍어보자.
//            클릭된 학생이 누구냐?
            val clickStudent = mStudentList[position]
            Toast.makeText(this, "${clickStudent.name} 클릭됨", Toast.LENGTH_SHORT).show()

        }
        studentListView.setOnItemLongClickListener { parent, view, position, id ->
//            길게 눌린 학생이름  로그로 출력
            val clickStudent = mStudentList[position]
            Log.d("길게눌린학생",clickStudent.name)
//             경고창을 띄우고 -> 확인을 눌렀을때만 학생 삭제.
            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생삭제확인")
            alert.setMessage("정말 ${clickStudent.name}을 삭제하시겟습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
//                확인 눌리면 할 일
                //            길게 눌린 학생을 목록에서 제거하자.
                mStudentList.remove(clickStudent)

//            원본 목록 내용변화 -> 어댑터변수에게도 알려줘야함
                mAdapter.notifyDataSetChanged()
            })
            alert.setNegativeButton("취소",null)

//            반드시 화면에 등장시키는 함수를 실행시키자
            alert.show()

            return@setOnItemLongClickListener true
        }
    }
}