package com.aba.cryptosample.data.entity




sealed class STATE {
    data class error(val message : String , val code : String) : STATE()
    object loading : STATE()
    object successful : STATE()

}