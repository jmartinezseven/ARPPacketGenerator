# ARPPacketGenerator

Este pequeño programa tiene como objetivo generar trafico ARP con MAC origen aleatorias con el fin de congestionar una red local. Este programa puede generar una cantidad importante de tráfico generando los paquetes y enviandolos de manera asincrona mediante la interfaz de red que se seleccione. También permite abri wireshark para verificar el trafico generado.

# Precondiciones 
* Java 8
* SBT
* libpcap-dev
* Wireshark con permisos necesarios para ver tráfico
* Sistema operativo linux de preferencia ubuntu con permisos de administrador

Nota: Se escogió el sistema operativo ubuntu por simplicidad en los permisos de administrador sobre las interfaces y otros temas de configuración pero es posible adaptarlo para Windows. De momento las instrucciones se harán asumiendo que cuenta con el sistema operativo Ubuntu 14.4 o superior

# Instalación de Java 8

- sudo add-apt-repository ppa:webupd8team/java
- sudo apt-get update
- sudo apt-get install oracle-java8-installer

# Instalación de SBT

- echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
- sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
- sudo apt-get update
- sudo apt-get install sbt

# Instalación de libpcap

- sudo apt-get install libpcap-dev

# Instalación de wireshark

- sudo add-apt-repository ppa:wireshark-dev/stable
- sudo apt-get update
- sudo apt-get install wireshark

# Configuraciones adicionales

Hay que darle permiso a java para que pueda acceder a las interfaces de red y poder hacer uso de ellas. Para eso ejecute el siguiente comando

- sudo setcap cap_net_raw,cap_net_admin=eip /usr/lib/jvm/java-8-oracle/bin/java

También es posible que se presente un error con wireshark. Puede presentarse el error *dumpcap permission denied* para lo que tiene que ejecutar:

- sudo chgrp <usuario_sistema> /usr/bin/dumpcap
