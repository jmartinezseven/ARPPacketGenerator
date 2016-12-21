package com.poli.arppacketgenerator.commons

import com.typesafe.config.ConfigFactory

/**
 * Created by juanmartinez on 20/12/16.
 */
object ApplicationConfMessages{

  val conf = ConfigFactory.load()

  def getString(path: String): String = conf.getString(path)

  def getInt(path: String): Int = conf.getInt(path)
}
