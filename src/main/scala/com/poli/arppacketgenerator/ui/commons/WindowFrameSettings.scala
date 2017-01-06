package com.poli.arppacketgenerator.ui.commons

import com.poli.arppacketgenerator.commons.ApplicationConfMessages

/**
 * Created by juanmartinez on 21/12/16.
 */
trait WindowFrameSettings {

  def getName() = ApplicationConfMessages.getString("app-name")

  def getDimensions() = {
    val dimensionX = ApplicationConfMessages.getInt("dimension-x")
    val dimensionY = ApplicationConfMessages.getInt("dimension-y")
    (dimensionX, dimensionY)
  }

}
