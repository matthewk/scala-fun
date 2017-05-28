package main.scala

import org.json4s._
import org.json4s.jackson.JsonMethods._


/**
  * Created by flavio on 28/05/2017.
  */
  object Main {

  case class Person(name: String, age: Int)

    def main(args: Array[String]): Unit = {

      val jsValue = parse("""{"name":"john", "age": 28}""")

      // json4s requires you to have this in scope to call extract
      implicit val formats = DefaultFormats

      val p = jsValue.extract[Person]
      // p is Person("john",28)

      println(p.name)
    }
  }

