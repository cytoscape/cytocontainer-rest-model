
[jetty]: http://eclipse.org/jetty/
[maven]: http://maven.apache.org/
[java]: https://www.oracle.com/java/index.html
[git]: https://git-scm.com/
[cdservice]: https://github.com/cytoscape/communitydetection-rest-server 
[make]: https://www.gnu.org/software/make

Community Detection Object Model
==================================

[![Build Status](https://travis-ci.com/cytoscape/communitydetection-rest-model.svg?branch=master)](https://travis-ci.com/cytoscape/communitydetection-rest-model)
[![Coverage Status](https://coveralls.io/repos/github/cytoscape/communitydetection-rest-model/badge.svg?branch=master)](https://coveralls.io/github/cytoscape/communitydetection-rest-model?branch=master)

Contains Java Pojo objects needed by [Community Detection REST Service][cdservice]



Requirements
============

* [Java][java] 8+ **(jdk to build)**

Building  
========

Build requirements:

* [Java 8+][java] JDK
* [Make][make] **(to build)**
* [Maven][maven] 3.3 or higher **(to build)** -- tested with 3.6


```Bash
# In lieu of git one can just download repo and unzip it
git clone https://github.com/cytoscape/communitydetection-rest-model.git

cd communitydetection-rest-model
mvn install

```

The above command will create a jar file under **target/** named 
**communitydetection-rest-model-\<VERSION\>.jar** 




COPYRIGHT AND LICENSE
=====================

[Click here](LICENSE)

Acknowledgements
================

TODO
