# de.choffmeister.utils

## Usage

Add the following lines to you `build.sbt` file:

~~~
resolvers += "choffmeister repo" at "http://repo.choffmeister.de/maven2/"

libraryDependencies ++= Seq(
  "de.choffmeister" %% "util-core" % "0.0.1-SNAPSHOT",
  "de.choffmeister" %% "util-spray" % "0.0.1-SNAPSHOT"
)
~~~

## License

Published under the permissive [MIT](https://raw.githubusercontent.com/choffmeister/util/master/LICENSE.txt) license.
