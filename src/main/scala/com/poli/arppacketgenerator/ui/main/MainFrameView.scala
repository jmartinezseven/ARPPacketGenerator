package com.poli.arppacketgenerator.ui.main

import java.awt.Dimension

import com.poli.arppacketgenerator.ui.commons.WindowFrameSettings
import com.poli.arppacketgenerator.ui.dialog.DestinationFrame

import scala.swing.{FlowPanel, Button, MainFrame}

/**
 * Created by juanmartinez on 20/12/16.
 */
class MainFrameView extends MainFrame with WindowFrameSettings{
  title = getName()
  preferredSize = new Dimension(getDimensions()._1, getDimensions()._2)
  contents = new FlowPanel {
    contents += Button("Iniciar prueba") { openDestinationFrame() }
  }

  def openDestinationFrame() = {
    val destinationFrame = new DestinationFrame()
    destinationFrame.visible = true
    this.dispose()
  }
}
