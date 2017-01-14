import org.junit.Test
import org.scalatest.junit.JUnitSuite


/**
  * Created by mordred on 1/12/17.
  */
class FortuneBotTest extends JUnitSuite {


  @Test def shouldTruncateLargeString(): Unit ={

//    Mighty starships plied their way between exotic suns, seeking adventure and
//    reward among the furthest reaches of Galactic space.  In those days, spirits
//    were brave, the stakes were high, men were real men, women were real women
//      and small furry creatures from Alpha Centauri were real small furry creatures
//      from Alpha Centauri.  And all dared to brave unknown terrors, to do mighty
//    deeds, to boldly split infinitives that no man had split before -- and thus
//    was the Empire forged.
//    -- Douglas Adams, _The Hitchhiker's Guide to the Galaxy_
//
    //val twit = "It will be advantageous to cross the great stream ... the Dragon is on the wing in the Sky ... the Great Man rouses himself to his Work."
    val twit = "Mighty starships plied their way between exotic suns, seeking adventure and\nreward among the furthest reaches of Galactic space.  In those days, spirits\nwere brave, the stakes were high, men were real men, women were real women\nand small furry creatures from Alpha Centauri were real small furry creatures\nfrom Alpha Centauri.  And all dared to brave unknown terrors, to do mighty\ndeeds, to boldly split infinitives that no man had split before -- and thus\nwas the Empire forged.\n-- Douglas Adams, _The Hitchhiker's Guide to the Galaxy_"
    val fortuneBot = new FortuneBot
    val finalTwit = fortuneBot.formatTwit(twit: String)
    println("Generated String -> " +finalTwit)
  }

  //tab  -> Eliminar tabs ???
//  What the hell is it good for?
//  -- Robert Lloyd (engineer of the Advanced Computing Systems
//    Division of IBM), to colleagues who insisted that the
//    microprocessor was the wave of the future, c. 1968

  @Test def shouldFormatMillisecondsToReadableTime(): Unit ={
    val time = 4231978
    Main.formatMillisecondsToReadableTime(time)

  }




}
