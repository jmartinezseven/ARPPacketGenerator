package com.poli.arppacketgenerator.ui.dialog

import java.awt.Dimension
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.ImageIcon

import com.poli.arppacketgenerator.bussiness.main.ARPPacketGenerator
import com.poli.arppacketgenerator.ui.commons.WindowFrameSettings

import scala.swing.{Button, GridPanel, Label, MainFrame}

/**
  * Created by juanmartinez on 6/01/17.
  */
class ExecutingDialog(aRPPacketGenerator: ARPPacketGenerator) extends MainFrame with WindowFrameSettings {

  title = getName()
  preferredSize = new Dimension(getDimensions()._1, getDimensions()._2)

  aRPPacketGenerator.execute()

  val message = new Label("Ejecutando el envío de paquetes")
  val labelImage = new Label{
    icon = new ImageIcon(classOf[ExecutingDialog].getResource("/spinner.gif"))
  }

  val openWireSharkButton = new Button("Abrir wireshark")
  openWireSharkButton.peer.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent) = {
      Runtime.getRuntime().exec("wireshark")
    }
  })

  contents = new GridPanel(3, 1) {
    contents += message
    contents += labelImage
    contents += openWireSharkButton
  }
}
