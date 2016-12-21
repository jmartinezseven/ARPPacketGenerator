package com.poli.arppacketgenerator.ui.dialog

import java.awt.{Dimension}

import com.poli.arppacketgenerator.ui.commons.WindowFrameSettings

import scala.swing._
import scala.swing.MainFrame

/**
 * Created by juanmartinez on 20/12/16.
 */
class DestinationFrame extends MainFrame with WindowFrameSettings{
  title = getName()
  preferredSize = new Dimension(getDimensions()._1, getDimensions()._2)

  val labelGenerateDinamnew Label("Generar MAC dinamicas: ")
  val generateMacDinamic = new CheckBox()

  contents = new GridPanel(2, 2) {
    contents +=
    contents += new CheckBox()
    contents += new Button("Another Button")
    contents += new Button("Button Three")
    contents += new CheckBox("Check me!")
    contents += Button("Close") { sys.exit(0) }
  }
}
