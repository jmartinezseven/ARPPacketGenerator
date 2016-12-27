package com.poli.arppacketgenerator.bussiness.interfaces.services
import java.util

import com.poli.arppacketgenerator.bussiness.interfaces.objects.NetworkInterface
import org.pcap4j.core.{PcapNetworkInterface, Pcaps}
import org.pcap4j.util.NifSelector
import scala.collection.JavaConversions._

/**
  * Created by juanmartinez on 27/12/16.
  */
class NetworkInterfacesServiceImpl extends NetworkInterfacesService{

  /**
    * Methodo que implementa la funcionalidad para traer la lista de interfaces disponibles del dispositivo
    *
    * @return Lista de interfaces de red disponibles en el dispositivo
    */
  override def getNetworkInterfaces: List[NetworkInterface] = {
    val networkInterfaces = Pcaps.findAllDevs().toList
  }
}
