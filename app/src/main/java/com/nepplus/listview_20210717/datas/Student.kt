package com.nepplus.listview_20210717.datas

class Student(
    val name : String,
    val birthYear : Int,
    val address : String) {

    //자신의 출생년도를 가지고 -> 나이로 변환해서 경과를 주는 함수를 제작.
    fun getAgeByYear(year : Int) : Int {
        return year - this.birthYear - 1;
    }
}