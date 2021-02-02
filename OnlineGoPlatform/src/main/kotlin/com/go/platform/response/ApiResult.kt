package com.go.platform.response

import kotlin.jvm.JvmOverloads

class ApiResult {
    var isSuccess = false
    var message: String? = null
    var code: Int? = null
    var data: Any? = null

    constructor() {}

    @JvmOverloads
    constructor(success: Boolean,
                message: String?,
                code: Int?,
                data: Any? = null) : super() {
        isSuccess = success
        this.message = message
        this.code = code
        this.data = data
    }
}