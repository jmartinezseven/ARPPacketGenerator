package com.poli.arppacketgenerator.ui.main

import java.awt.Dimension

import com.poli.arppacketgenerator.ui.commons.WindowFrameSettings
import com.poli.arppacketgenerator.ui.dialog.DestinationFrame

import scala.swing.{FlowPanel, Button, MainFrame}

/**
  * clase que modela la ventana principal
  */
class MainFrameView extends MainFrame with WindowFrameSettings{
  title = getName()
  preferredSize = new Dimension(getDimensions()._1, getDimensions()._2)
  contents = new FlowPanel {
    contents += Button("Iniciar prueba") { openDestinationFrame() }
  }

  /**
    * Abre el el dialogo que recibe los paramtros de destino para las pruebas
    */
  def openDestinationFrame() = {
    val destinationFrame = new DestinationFrame()
    destinationFrame.visible = true
    this.dispose()
  }
}
