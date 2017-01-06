package com.poli.arppacketgenerator.bussiness.main

import java.util.concurrent.ExecutorService

import com.poli.arppacketgenerator.bussiness.interfaces.objects.NetworkInterface
import com.poli.arppacketgenerator.bussiness.interfaces.services.NetworkInterfacesService
import com.poli.arppacketgenerator.bussiness.tasks.ARPSenderTask
import org.pcap4j.util.MacAddress

import scala.collection.JavaConversions._

/**
  * Created by juanmartinez on 5/01/17.
  */
class ARPPacketGenerator(networkInterfacesService: NetworkInterfacesService,
                         executorService: ExecutorService,
                         packetGeneratorParameters: PacketGeneratorParameters) {

  val tasks = new Array[ARPSenderTask](packetGeneratorParameters.numTask)

  def execute (): Unit = {
    for {
      i <- 0 to packetGeneratorParameters.numTask - 1
    } yield {
      val interface = networkInterfacesService.getSelectedNetworkInterface(packetGeneratorParameters.selectedInterface.index)
      val destMacAdd = MacAddress.getByName(packetGeneratorParameters.destinationMacAddress)
      val task = new ARPSenderTask(interface, false, destMacAdd, packetGeneratorParameters.sourceIpAddress)
      tasks(i) = task
      executorService.execute(task)
    }
  }


  /**
    * retorna la lista de interfaces disponibles en la red
    * @return
    */
  def getNetworkInterfaces = networkInterfacesService.getNetworkInterfaces()

}

case class PacketGeneratorParameters(sourceIpAddress: String,
                                destinationMacAddress: String,
                                selectedInterface: NetworkInterface,
                                numTask : Int)
