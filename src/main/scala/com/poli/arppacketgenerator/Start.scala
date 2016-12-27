package com.poli.arppacketgenerator

import com.poli.arppacketgenerator.commons.ApplicationConfMessages
import com.poli.arppacketgenerator.ui.main.MainFrameView

/**
 * Created by juanmartinez on 20/12/16.
 */
object Start extends App {
  val appName = ApplicationConfMessages.getString("app-name")
  val dimensionX = ApplicationConfMessages.getInt("dimension-x")
  val dimensionY = ApplicationConfMessages.getInt("dimension-x")
  val main = new MainFrameView()
  main.visible = true
}
