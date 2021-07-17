package com.nepplus.listview_20210717.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.nepplus.listview_20210717.R
import com.nepplus.listview_20210717.datas.Student

//StudentAdapter는 ArrayAdapter에게 상속을 받음
class StudentAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext,resId,mList) {

        //Xml로 만들어진 파일 => 코틀린에서 사용해서, 이름/나이/거주지 등등을 입혀줘야함.
        //xml파일을 코틀린으로 가져와주는 도구(LayoutInflater)가 우선 필요함.

        val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //1.  convertView에 내용물이 없는 상태라면 ( null 상태 ) => 내용물을 채워주자.
        //convertView를 직접 다루기 까다롭다. => tempRow에 옮겨닮아 사용.
        var tempRow = convertView
        if(tempRow == null){
            tempRow = mInflater.inflate(R.layout.student_list_item, null)
        }

        //진짜 row 생성, tempRow가 절대 null이 아니다.
        val row = tempRow!!

        //row와 + position에 해당하는 학생데이터를 이용해서 => 위치에 맞는 이름/나이/주소 등을 넣어주자.(Adapter의 2차 작업)

        //완성된 row가 결과로 나가도록 지정
        return row

    }
}