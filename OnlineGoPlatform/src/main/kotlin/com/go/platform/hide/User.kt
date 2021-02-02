package com.go.platform.hide


class User {
    var username: String? = null
    var name: String? = null
    constructor() {}
    constructor(username: String?,
                name: String?) : super() {
        this.username = username
        this.name = name
    }
}