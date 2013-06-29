package org.kurron.spring.data.graph.example.one

/**
 * Domain model.
 **/
class User {
    String login
    String name
    String password
    Set<Rating> ratings
    Set<User> friends
}
