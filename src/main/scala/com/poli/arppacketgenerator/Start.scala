package com.poli.arppacketgenerator

import com.poli.arppacketgenerator.commons.ApplicationConfMessages
import com.poli.arppacketgenerator.ui.main.MainFrameView

/**
  * Clase que inicia la interfaz gráfica principal
  */
object Start extends App {
  val appName = ApplicationConfMessages.getString("app-name")
  val dimensionX = ApplicationConfMessages.getInt("dimension-x")
  val dimensionY = ApplicationConfMessages.getInt("dimension-x")
  val main = new MainFrameView()
  main.visible = true
}
