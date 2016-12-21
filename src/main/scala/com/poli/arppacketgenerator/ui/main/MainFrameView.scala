package com.poli.arppacketgenerator.ui.main

import java.awt.Dimension

import com.poli.arppacketgenerator.ui.dialog.DestinationFrame

import scala.swing.{FlowPanel, BorderPanel, Button, MainFrame}

/**
 * Created by juanmartinez on 20/12/16.
 */
class MainFrameView(titleFrame: String, dimensionX: Int, dimensionY: Int) extends  MainFrame{
  title = titleFrame
  preferredSize = new Dimension(dimensionX, dimensionY)
  contents = new FlowPanel {
    contents += Button("Iniciar prueba") { openDestinationFrame() }
  }

  def openDestinationFrame() = {
    val destinationFrame = new DestinationFrame()
    destinationFrame.visible = true
    this.dispose()
  }
}
