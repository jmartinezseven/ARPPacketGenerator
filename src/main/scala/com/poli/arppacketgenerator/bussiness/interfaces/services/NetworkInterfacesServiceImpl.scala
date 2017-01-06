package com.poli.arppacketgenerator.bussiness.interfaces.services
import com.poli.arppacketgenerator.bussiness.interfaces.objects.NetworkInterface
import org.pcap4j.core.{PcapNetworkInterface, Pcaps}

import scala.collection.JavaConversions._

/**
  * Created by juanmartinez on 27/12/16.
  */
class NetworkInterfacesServiceImpl extends NetworkInterfacesService {

  /**
    * Methodo que implementa la funcionalidad para traer la lista de interfaces disponibles del dispositivo
    *
    * @return Lista de interfaces de red disponibles en el dispositivo
    */
  override def getNetworkInterfaces: List[NetworkInterface] = {
    val networkList = Pcaps.findAllDevs().toList
    val result = for {
      i <- 0 to networkList.size -1
    } yield NetworkInterface(i, networkList(i).getName)
    result.toList
  }

  /**
    * Retorna la instancia correcta de una interfaz de red
    * @param index
    */
  override def getSelectedNetworkInterface(index: Int): PcapNetworkInterface = {
    Pcaps.findAllDevs().get(index)
  }
}
