name := "scrimage-filters"

publishMavenStyle := true

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

publishTo <<= version {
  (v: String) =>
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT"))
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

libraryDependencies ++= Seq(
  "org.apache.sanselan"             % "sanselan"              % "0.97-incubator",
  "org.slf4j"                       % "slf4j-api"             % "1.6.6",
  "commons-io"                      % "commons-io"            % "2.4",
  "junit"                           % "junit"                 % "4.11"                    % "test",
  "org.imgscalr"                    % "imgscalr-lib"          % "4.2"                     % "test",
  "org.scalatest"                   %% "scalatest"            % "2.1.3"                   % "test",
  "org.mockito"                     % "mockito-all"           % "1.9.5"                   % "test"
)

pomExtra := {
  <url>https://github.com/sksamuel/scrimage</url>
  <licenses>
    <license>
      <name>The Apache Software License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
    <scm>
      <connection>scm:git:git@github.com:sksamuel/scrimage.git</connection>
      <developerConnection>scm:git:git@github.com:sksamuel/scrimage.git</developerConnection>
      <url>git@github.com:sksamuel/scrimage.git</url>
    </scm>
    <developers>
      <developer>
        <name>Stephen Samuel</name>
        <email>sam@sksamuel.com</email>
        <timezone>GMT</timezone>
      </developer>
    </developers>
}
