package com.objectpartners.comics
class Character {
    String firstName
    String middleName
    String lastName

    List<String> aliases

    String toString() {
        "$firstName $lastName (${aliases.join(', ')})"
    }
}
