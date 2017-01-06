package com.poli.arppacketgenerator.bussiness.generators

import java.util.Random

/**
  * Created by juanmartinez on 27/12/16.
  */
object RandomMacGenerator {

  /**
    * Genera mac aleatoriamente
    * @return
    */
  def randomMACAddress() : String = {
    val rand = new Random()
    val macPositions = new Array[String](6)
    val finalResult = new StringBuilder()
    macPositions.foreach(mp => {
      if(finalResult.length() > 0)
        finalResult.append(":");
      val number = rand.nextInt(256)
      finalResult.append(String.format("%02X", Integer.valueOf(number)))
    })
    finalResult.toString()
  }
}
