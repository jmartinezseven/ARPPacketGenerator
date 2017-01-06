package com.poli.arppacketgenerator.bussiness.interfaces.services

import com.poli.arppacketgenerator.bussiness.interfaces.objects.NetworkInterface
import org.pcap4j.core.PcapNetworkInterface

/**
  * Created by juanmartinez on 27/12/16.
  */
trait NetworkInterfacesService {

  /**
    * Methodo abstracto para traer la lista de interfaces disponibles del dispositivo
    * @return
    */
  def getNetworkInterfaces(): List[NetworkInterface]

  /**
    * Retorna la interfaz de red seleccionada por el usuario
    * @param index
    * @return PcapNetworkInterface
    */
  def getSelectedNetworkInterface(index: Int): PcapNetworkInterface

}
