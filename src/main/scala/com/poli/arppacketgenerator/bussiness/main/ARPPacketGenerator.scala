package com.poli.arppacketgenerator.bussiness.main

import java.util.concurrent.ExecutorService

import com.poli.arppacketgenerator.bussiness.interfaces.objects.NetworkInterface
import com.poli.arppacketgenerator.bussiness.interfaces.services.NetworkInterfacesService
import com.poli.arppacketgenerator.bussiness.tasks.ARPSenderTask
import org.pcap4j.util.MacAddress

/**
  * Clase que modela la logica principal del generador de paquetes ARP
  *
  * @param networkInterfacesService
  * @param executorService
  * @param packetGeneratorParameters
  */
class ARPPacketGenerator(networkInterfacesService: NetworkInterfacesService,
                         executorService: ExecutorService,
                         packetGeneratorParameters: PacketGeneratorParameters) {

  val tasks = new Array[ARPSenderTask](packetGeneratorParameters.numTask)

  /**
    * Ejecuta las pruebas creando el número de tareas indicadas
    * y agregandolas al pull de threads para ejecutarlas
    */
  def execute (): Unit = {
    for {
      i <- 0 to packetGeneratorParameters.numTask - 1
    } yield {
      val interface = networkInterfacesService.getSelectedNetworkInterface(packetGeneratorParameters.selectedInterface.index)
      val destMacAdd = MacAddress.getByName(packetGeneratorParameters.destinationMacAddress)
      val task = new ARPSenderTask(interface, false, destMacAdd, packetGeneratorParameters.sourceIpAddress, i)
      tasks(i) = task
      executorService.execute(task)
    }
  }

  /**
    * Detiene las tareas y termina el thread pull
    */
  def stopTasks(): Unit = {
    tasks.foreach(_.stopLoop)
    executorService.shutdown()
  }

  /**
    * retorna la lista de interfaces disponibles en la red
    * @return
    */
  def getNetworkInterfaces = networkInterfacesService.getNetworkInterfaces()

}

/**
  * Clase que modela los parametros para las tareas a ejecutar en el thread pull
  * @param sourceIpAddress
  * @param destinationMacAddress
  * @param selectedInterface
  * @param numTask
  */
case class PacketGeneratorParameters(sourceIpAddress: String,
                                destinationMacAddress: String,
                                selectedInterface: NetworkInterface,
                                numTask : Int)
