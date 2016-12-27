package com.poli.arppacketgenerator.bussiness.interfaces.services

import com.poli.arppacketgenerator.bussiness.interfaces.objects.NetworkInterface

/**
  * Created by juanmartinez on 27/12/16.
  */
trait NetworkInterfacesService {

  /**
    * Methodo abstracto para traer la lista de interfaces disponibles del dispositivo
    * @return
    */
  def getNetworkInterfaces: List[NetworkInterface]

}
