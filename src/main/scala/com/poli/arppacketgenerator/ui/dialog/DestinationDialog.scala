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

  val labelGenerateDynamic = new Label("Generar MAC origen dinamicas: ")
  val generateMacDynamic = new CheckBox()
  val labelSrcIp = new Label("IP origen:")
  val txtFieldIpSrc = new TextField()
  val labelMacDestination = new Label("MAC Destino:")
  val txtBoxMacDest = new TextField()
  val labelIPDestiny = new Label("IP Destino: ")
  val txtBoxIpDest = new TextField()


  contents = new GridPanel(2, 2) {
    contents += labelGenerateDynamic
    contents += generateMacDynamic
    contents += labelSrcIp
    contents += txtFieldIpSrc
    contents += labelMacDestination
    contents += txtBoxMacDest
    contents += labelIPDestiny
    contents += txtBoxIpDest
  }
}
