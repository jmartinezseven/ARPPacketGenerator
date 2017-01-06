package com.poli.arppacketgenerator.ui.dialog

import java.awt.Dimension
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{ImageIcon, JOptionPane}

import com.poli.arppacketgenerator.bussiness.main.ARPPacketGenerator
import com.poli.arppacketgenerator.ui.commons.WindowFrameSettings
import com.typesafe.scalalogging.LazyLogging

import scala.swing.{Button, GridPanel, Label, MainFrame}
import scala.util.{Failure, Success}

/**
  * Created by juanmartinez on 6/01/17.
  */
class ExecutingDialog(aRPPacketGenerator: ARPPacketGenerator) extends MainFrame with WindowFrameSettings with LazyLogging{

  title = getName()
  preferredSize = new Dimension(getDimensions()._1, getDimensions()._2)

  aRPPacketGenerator.execute() match {
    case Success(e) =>
      logger.info("Tareas ejecutadas correctamente")
    case Failure(ex) =>
      JOptionPane.showMessageDialog(this.peer,
        ex.getMessage,
        "Inane error",
        JOptionPane.ERROR_MESSAGE)
      stopProcessAndStopDialog()

  }

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

  val stopButton = new Button("Detener prueba")
  stopButton.peer.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent) = {
      stopProcessAndStopDialog()
    }
  })

  contents = new GridPanel(4, 1) {
    contents += message
    contents += labelImage
    contents += openWireSharkButton
    contents += stopButton
  }

  private def stopProcessAndStopDialog(): Unit ={
    val dest = new DestinationFrame()
    aRPPacketGenerator.stopTasks()
    dest.visible = true
    this.dispose()
  }
}
