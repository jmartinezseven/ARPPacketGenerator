package com.poli.arppacketgenerator.ui.dialog

import java.awt.Dimension
import java.util.concurrent.Executors

import com.poli.arppacketgenerator.bussiness.main.{ARPPacketGenerator, PacketGeneratorParameters}
import com.poli.arppacketgenerator.commons.Services._
import com.poli.arppacketgenerator.ui.commons.WindowFrameSettings

import scala.swing.{MainFrame, _}

/**
 * Created by juanmartinez on 20/12/16.
 */
class DestinationFrame extends MainFrame with WindowFrameSettings {
  title = getName()
  preferredSize = new Dimension(getDimensions()._1, getDimensions()._2)

  val labelSrcIp = new Label("IP origen:")
  val txtFieldIpSrc = new TextField()
  val labelMacDestination = new Label("MAC Destino:")
  val txtBoxMacDest = new TextField()
  val threads = new Label("Número de operaciones concurrentes:")
  val threadsText = new TextField()
  val networkIntLabel = new Label("Interfaz de red: ")
  val networkIntCombo = new ComboBox(networkInterfacesService.getNetworkInterfaces)
  val clearButton = Button("Limpiar"){ clearData() }
  val nextButton = Button("Siguiente"){goToProcessWindow()}

  contents = new GridPanel(5, 2) {
    contents += labelSrcIp
    contents += txtFieldIpSrc
    contents += labelMacDestination
    contents += txtBoxMacDest
    contents += threads
    contents += threadsText
    contents += networkIntLabel
    contents += networkIntCombo
    contents += clearButton
    contents += nextButton
  }

  def clearData(): Unit = {
    txtFieldIpSrc.peer.setText("")
    txtBoxMacDest.peer.setText("")
    threadsText.peer.setText("")
  }

  def goToProcessWindow(): Unit = {
    val executorService = Executors.newFixedThreadPool(threadsText.text.toInt)
    val parameters = PacketGeneratorParameters(txtFieldIpSrc.text, txtBoxMacDest.text, networkIntCombo.selection.item, threadsText.text.toInt)
    val arpPacketGenerator = new ARPPacketGenerator(networkInterfacesService, executorService, parameters)
    val executingWindow = new ExecutingDialog(arpPacketGenerator)
    this.dispose()
    executingWindow.visible = true
  }
}
