import java.text.SimpleDateFormat
import java.util.Date

import twitter4j.TwitterFactory

import sys.process._
/**
  * Created by mordred on 1/12/17.
  */

class FortuneBot {

  val twitter =TwitterFactory.getSingleton

  def publishTwit(twit: String ): Unit = {
    val status = twitter.updateStatus(twit)
    println(s"[FORTUNE BOT] New Twit ----> [${status.getText}]")
  }

  def extractFortune(): String = {
    val fortuneText: String = "fortune".!!
    println(s"[FORTUNE BOT] Executing $$fortune ---> $fortuneText")
    fortuneText
  }


  def formatTwit(message: String): List[String] = {
    var listTwits = List[String]()
    var twit = ""
    val twitLength = 133
    val trueTwitLength = 140
    var twitEndString = "..."
    var twitStartString = "..."
    var fortune =  message.map(c => if (c != '\n') c else ' ' )
    fortune = fortune.replaceAllLiterally("--", "\n--")
    var counter = 0
    while (fortune.length > 0) {
      twitEndString = "..."
      twitStartString = "..."
      var indexToSeparateString = twitLength
      if(counter == 0 ) twitStartString = ""

      if(fortune.length <= trueTwitLength && counter == 0){
        indexToSeparateString = 140
        twitStartString = ""
        twitEndString = ""
      }
      else if (fortune.length <= twitLength) {
        twitEndString = ""
      }
      else {
        twit = fortune.take(twitLength)
        if (twit.last != ' ') {
          val lastIndex = twit.lastIndexOf(' ')
          indexToSeparateString = lastIndex
        }
      }
      twit =  twitStartString + fortune.take(indexToSeparateString) + twitEndString
      fortune = fortune.drop(indexToSeparateString)
      println("Line ----->" +twit)
      listTwits :+= twit
      counter += 1
  }
    listTwits
  }

}

//Mighty starships plied their way between exotic suns, seeking adventure and
