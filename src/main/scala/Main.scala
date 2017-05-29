package main.scala

import main.scala.Model.{Person, Track}
import org.json4s._
import org.json4s.jackson.JsonMethods._


/**
  * Created by flavio on 28/05/2017.
  */
object Main {

  val BaseDeezerAPIURL: String = "https://api.deezer.com/track/"
  val BenzinaOgoshiTrackId: String = "14310750";

  def main(args: Array[String]): Unit = {

    val track = getTrackDetails(BenzinaOgoshiTrackId)
    println(track.title)
    println(track.rank)

  }

  def getTrackDetails(trackId: String): Track = {
    val apiURL = BaseDeezerAPIURL + trackId
    var respJSON = scala.io.Source.fromURL(apiURL).mkString
    // json4s requires you to have this in scope to call extract
    implicit val formats = DefaultFormats
    val jsonValue = parse(respJSON)
    val track = jsonValue.extract[Track]
    return track
  }
}

