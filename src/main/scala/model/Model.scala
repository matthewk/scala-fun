package main.scala

/**
  * Object containing all the models
  */
object Model {
  case class Person(name: String, age: Int)
  case class Track(title: String, id: Int, rank: Int)
}
