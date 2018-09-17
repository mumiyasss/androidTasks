package com.mumiyasss.profile

import java.io.Serializable


data class Profile (var firstName: String,
                    var lastName: String,
                    var age: Int) : Serializable