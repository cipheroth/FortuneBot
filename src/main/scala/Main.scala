import java.text.SimpleDateFormat
import java.util.{Date, Timer, TimerTask}

/**
  * Created by mordred on 1/12/17.
  */
object Main extends App {

  val fortuneBot = new FortuneBot
  val timer = new Timer
  val timeHigh =  10800000
  val timeLow =    1800000

//  val timeHigh =  72000
//  val timeLow = 18000

  class BotAction extends TimerTask {
    override def run() = generateAndSendTweet()
  }

  def nextTimeExecution () : Int = {scala.util.Random.nextInt(timeHigh) + timeLow}

  def formatMillisecondsToReadableTime(milliseconds : Long): String ={
    val now = new Date
    val totalTime = now.getTime + milliseconds
    val formater = new SimpleDateFormat("HH:mm:ss")
    val readableTime = formater.format(new Date(totalTime))
    println(s"[FORTUNE BOT] Next execution time : [$milliseconds] milliseconds")
    println(s"[FORTUNE BOT] Next execution exactly at -> [$readableTime]")
    readableTime
  }


  def generateAndSendTweet(){
    println("###############################")
    val fortune = fortuneBot.extractFortune()
    val twit = fortuneBot.formatTwit(fortune)
    twit.foreach(fortuneBot.publishTwit)
    val nextTime = nextTimeExecution()
    formatMillisecondsToReadableTime(nextTime)
    timer.schedule(new BotAction, nextTime)

  }

  (new BotAction).run()

}
