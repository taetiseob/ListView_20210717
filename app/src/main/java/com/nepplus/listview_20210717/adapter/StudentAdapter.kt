package com.nepplus.listview_20210717.adapter

import android.content.Context
import android.widget.ArrayAdapter
import com.nepplus.listview_20210717.datas.Student

//StudentAdapter는 ArrayAdapter에게 상속을 받음
class StudentAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext,resId,mList) {
}