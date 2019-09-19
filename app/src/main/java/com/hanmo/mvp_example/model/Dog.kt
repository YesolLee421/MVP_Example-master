package com.hanmo.mvp_example.model

data class Dog(val name : String,val age : Int)

/*
data class로 선언했을 경우 컴파일
1. 인스턴스 간 비교를 위한 equals() 자동 생성
2. Hash 기반 container에서 키로 사용할 수 있도록 hashCode() 자동생성
3. property 순서대로 값 반환해주는 toString() 자동생성
 */