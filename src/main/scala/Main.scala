package main.scala

import main.scala.Model.{Person, Track}
import org.json4s._
import org.json4s.jackson.JsonMethods._


/**
  * Created by flavio on 28/05/2017.
  */
  object Main {

    def main(args: Array[String]): Unit = {

      val jsValue = parse("""{"name":"john", "age": 28}""")

      // json4s requires you to have this in scope to call extract
      implicit val formats = DefaultFormats

      val p = jsValue.extract[Person]
      // p is Person("john",28)

      println(p.name)

      val track = getTrackDetails("14310750")
      println(track.title)
      println(track.rank)

    }

  def getTrackDetails (trackId: String) : Track = {
    val baseDeezerURL = "https://api.deezer.com/track/"
    val apiURL = baseDeezerURL + trackId
    var respJSON = scala.io.Source.fromURL(apiURL).mkString
    // json4s requires you to have this in scope to call extract
    implicit val formats = DefaultFormats
    val jsonValue = parse(respJSON)
    val track = jsonValue.extract[Track]
    return track
  }
  }

