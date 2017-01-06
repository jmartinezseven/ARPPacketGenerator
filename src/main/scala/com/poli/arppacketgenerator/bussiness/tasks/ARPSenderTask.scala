package com.poli.arppacketgenerator.bussiness.tasks

import java.net.InetAddress

import com.poli.arppacketgenerator.bussiness.generators.RandomMacGenerator
import com.poli.arppacketgenerator.bussiness.tasks.ARPSenderTask._
import com.typesafe.scalalogging.LazyLogging
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode
import org.pcap4j.core.{PcapHandle, PcapNetworkInterface}
import org.pcap4j.packet.{ArpPacket, EthernetPacket}
import org.pcap4j.packet.namednumber.{ArpHardwareType, ArpOperation, EtherType}
import org.pcap4j.util.{ByteArrays, MacAddress}

/**
  * Created by juanmartinez on 5/01/17.
  */
class ARPSenderTask(nif: PcapNetworkInterface, var stopLoop: Boolean = false, destinationMac: MacAddress, sourceIpAddress: String) extends Thread with LazyLogging{

  val sendHandle: PcapHandle = nif.openLive(SNAPLEN, PromiscuousMode.PROMISCUOUS, READ_TIMEOUT)

  override def run(): Unit = {
    val arpBuilder = new ArpPacket.Builder

    while (!stopLoop) {
      val sourceMacAddress = MacAddress.getByName(RandomMacGenerator.randomMACAddress())

      arpBuilder.hardwareType(ArpHardwareType.ETHERNET)
        .protocolType(EtherType.IPV4)
        .hardwareAddrLength(MacAddress.SIZE_IN_BYTES.toByte)
        .protocolAddrLength(ByteArrays.INET4_ADDRESS_SIZE_IN_BYTES.toByte)
        .operation(ArpOperation.REQUEST)
        .srcHardwareAddr(sourceMacAddress)
        .srcProtocolAddr(InetAddress.getByName(sourceIpAddress))
        .dstHardwareAddr(destinationMac)
        .dstProtocolAddr(InetAddress.getByName(sourceIpAddress))

      val etherBuilder = new EthernetPacket.Builder
      etherBuilder.dstAddr(destinationMac).srcAddr(sourceMacAddress).`type`(EtherType.ARP).payloadBuilder(arpBuilder).paddingAtBuild(true)

      logger.info("Enviando el paquete ARP:")
      logger.info(s"MAC fuente: ${sourceMacAddress.toString}")

      val p = etherBuilder.build
      System.out.println(p)
      sendHandle.sendPacket(p)
    }
  }

  def stopFinalLoop() = {
    stopLoop = true
    this.finalize()
  }
}

object ARPSenderTask {

  private val COUNT_KEY = classOf[ARPSenderTask].getName + ".count"
  private val COUNT = Integer.getInteger(COUNT_KEY, 1)
  private val READ_TIMEOUT_KEY = classOf[ARPSenderTask].getName + ".readTimeout"
  private val READ_TIMEOUT = Integer.getInteger(READ_TIMEOUT_KEY, 10)
  private val SNAPLEN_KEY = classOf[ARPSenderTask].getName + ".snaplen"
  private val SNAPLEN = Integer.getInteger(SNAPLEN_KEY, 65536)

}
