name := "ARPPacketGenerator"

version := "1.0"

scalaVersion := "2.11.5"

resolvers += Resolver.mavenLocal

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.pcap4j" % "pcap4j-core" % "1.7.0",
  "org.pcap4j" % "pcap4j-packetfactory-static" % "1.7.0",
  "com.typesafe" % "config" % "1.2.1",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "org.scala-lang.modules" %% "scala-swing" % "1.0.2",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
)

assemblyMergeStrategy in assembly := {
  case PathList("org", "pcap4j", xs @ _*) => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

mainClass in assembly := Some("com.poli.arppacketgenerator.Start")

assemblyJarName in assembly := "ARPPacketGenerator.jar"