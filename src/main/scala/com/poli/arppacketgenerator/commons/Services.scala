package com.poli.arppacketgenerator.commons

import com.poli.arppacketgenerator.bussiness.interfaces.services.{NetworkInterfacesService, NetworkInterfacesServiceImpl}

/**
  * Created by juanmartinez on 5/01/17.
  */
object Services {
  val networkInterfacesService : NetworkInterfacesService = new NetworkInterfacesServiceImpl
}
