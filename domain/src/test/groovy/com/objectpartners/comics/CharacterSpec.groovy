package com.objectpartners.comics
 
import spock.lang.Specification
class CharacterSpec extends Specification {

    def "toString should print aliases"() {

        when:
        def character = new Character(firstName:firstName, lastName:lastName,aliases:aliases)

        then:
        character.toString() == string

        where:
        firstName | lastName  | aliases               | string
        'Wade'    | 'Wilson'  | ['Deadpool']          | 'Wade Wilson (Deadpool)'
        'Dick'    | 'Grayson' | ['Robin','Nightwing'] | 'Dick Grayson (Robin, Nightwing)'
    }
}
