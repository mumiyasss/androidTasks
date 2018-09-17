package com.mumiyasss.profile

import java.io.Serializable


data class Profile (var firstName: String,
                    var lastName: String,
                    var age: String,
                    var phone: String,
                    var inst: String,
                    var vk: String) : Serializable